#!/usr/bin/env python3
"""
Generates media/banner.svg, the README banner: the arms-crossed photo of the IHMC Alex Humanoid cut out of its
white background, next to the ALEX logo set in the Alex typeface (media/fonts/Alex-Regular.ttf)
under IHMC's "ihmc" wordmark, on a translucent blue gradient that reads on both light and dark GitHub themes.

The SVG is self-contained (text is converted to paths and the robot is embedded as WebP),
because GitHub renders README SVGs as images that cannot load fonts or linked files.

Usage:
    uv run --no-project --with numpy --with scipy --with pillow --with fonttools \\
        python utils/make_readme_banner.py
"""

import base64
import io
import re
from pathlib import Path

import numpy as np
from fontTools.pens.svgPathPen import SVGPathPen
from fontTools.pens.transformPen import TransformPen
from fontTools.ttLib import TTFont
from PIL import Image
from scipy import ndimage

REPO_ROOT = Path(__file__).resolve().parent.parent
PHOTO = REPO_ROOT / "media/17_Alex_v2_ArmsCrossed_4.jpg"
ALEX_FONT = REPO_ROOT / "media/fonts/Alex-Regular.ttf"
OUTPUT = REPO_ROOT / "media/banner.svg"

WIDTH, HEIGHT, CORNER = 1280, 400, 28
ROBOT_X, ROBOT_Y, ROBOT_HEIGHT = 120, 28, 620
ROBOT_PIXEL_SCALE = 2  # embed at 2x for high-DPI screens
# Head camera lens windows ("eyes") in PHOTO pixels as (x0, y0, x1, y1), and how much to brighten them
EYE_BOXES = [(168, 32, 208, 101), (248, 32, 288, 101)]
EYE_GAIN = 1.9
# The i, h, m and c of IHMC's logo, from IHMC's own IHMC_logoShort.pdf in
# https://www.ihmc.us/files/ihmc_Keynote_Generic.key.zip: SVG path data in points, y down,
# the baseline at y=0 and the i's left edge at x=0.
IHMC_WORDMARK = (
    "M0 0 L0 -36.61 L8.36 -36.61 L8.36 0 L0 0 M0 -44.971 L0 -55.091 L8.36 -55.091 L8.36 -44.971 L0 -44.971 Z",
    "M42.506 0 L42.506 -22.265 C42.506 -27.634 39.338 -29.922 35.818 -29.922 C31.242 -29.922 27.281 -26.401 "
    "27.281 -19.625 L27.281 0 L18.921 0 L18.921 -64.244 L27.281 -64.244 L27.281 -32.21 C29.129 -35.114 32.914 "
    "-37.666 37.49 -37.666 C45.059 -37.666 50.866 -33.09 50.866 -23.85 L50.866 0 L42.506 0 Z",
    "M106.31 0 L106.31 -23.409 C106.31 -27.897 103.581 -29.922 99.886 -29.922 C95.397 -29.922 91.788 -26.401 "
    "91.788 -21.825 L91.788 0 L83.429 0 L83.429 -23.409 C83.429 -27.897 80.524 -29.922 76.828 -29.922 C72.34 "
    "-29.922 68.907 -26.401 68.907 -21.737 L68.907 0 L60.547 0 L60.547 -36.61 L68.907 -36.61 L68.907 -33.09 "
    "C71.02 -35.73 74.716 -37.666 78.588 -37.666 C84.396 -37.666 87.741 -35.642 90.116 -32.034 C92.933 "
    "-35.906 98.125 -37.666 101.909 -37.666 C111.502 -37.666 114.67 -31.594 114.67 -24.201 L114.67 0 L106.31 "
    "0 Z",
    "M141.335 1.056 C128.575 1.056 122.15 -7.568 122.15 -18.306 C122.15 -28.514 129.454 -37.666 140.632 "
    "-37.666 C148.991 -37.666 154.448 -32.825 156.912 -29.13 L150.84 -24.554 C148.903 -27.018 145.911 -29.922 "
    "140.72 -29.922 C134.383 -29.922 130.687 -24.113 130.687 -18.657 C130.687 -11.001 134.911 -6.688 141.247 "
    "-6.688 C145.56 -6.688 148.991 -8.977 151.896 -12.409 L157.616 -7.833 C154.185 -3.08 148.024 1.056 "
    "141.335 1.056 Z",
)
IHMC_WORDMARK_X_HEIGHT = 37.666


def cut_out_robot(path):
    """Removes the white studio background and returns an RGBA image."""
    rgb = np.asarray(Image.open(path).convert("RGB")).astype(np.float32)
    min_channel = rgb.min(axis=2)
    luminance = rgb @ np.array([0.299, 0.587, 0.114], dtype=np.float32)

    # Background is near-white connected to the border, plus large enclosed near-white holes.
    labels, count = ndimage.label(min_channel > 228)
    indices = np.arange(count + 1)
    sizes = ndimage.sum(np.ones_like(min_channel), labels, indices)
    means = ndimage.mean(min_channel, labels, indices)
    background_ids = set(np.concatenate([labels[0], labels[-1], labels[:, 0], labels[:, -1]]).tolist())
    background_ids |= {i for i in range(1, count + 1) if sizes[i] > 300 and means[i] > 246}
    background_ids.discard(0)
    foreground = ~np.isin(labels, list(background_ids))

    # Anti-aliased edge: alpha from darkness within a few pixels of the silhouette.
    inside_distance = ndimage.distance_transform_edt(foreground)
    outside_distance = ndimage.distance_transform_edt(~foreground)
    edge_alpha = np.clip((255.0 - luminance) / (255.0 - 40.0), 0, 1)
    alpha = np.where(foreground, 1.0, 0.0)
    alpha = np.where(foreground & (inside_distance <= 2.5), edge_alpha, alpha)
    alpha = np.where(~foreground & (outside_distance <= 1.5), edge_alpha, alpha)
    alpha = 0.7 * alpha + 0.3 * ndimage.gaussian_filter(alpha, 0.5)

    # Un-mix the white background from partially transparent edge pixels.
    a = np.clip(alpha, 1e-3, 1)[..., None]
    color = np.clip((rgb - (1 - a) * 255.0) / a, 0, 255)
    color = np.where(alpha[..., None] > 0.02, color, 0)
    return Image.fromarray(np.dstack([color, np.clip(alpha, 0, 1) * 255]).astype(np.uint8), "RGBA")


def lighten_eyes(robot):
    """Brightens the lens windows, which are dark grey-blue inside a near-black bezel."""
    rgba = np.asarray(robot).astype(np.float32)
    luminance = rgba[..., :3] @ np.array([0.299, 0.587, 0.114], dtype=np.float32)
    mask = np.zeros(luminance.shape, dtype=np.float32)
    for x0, y0, x1, y1 in EYE_BOXES:
        mask[y0:y1, x0:x1] = np.clip((luminance[y0:y1, x0:x1] - 10.0) / 15.0, 0, 1)
    mask = ndimage.gaussian_filter(mask, 0.7)[..., None]
    rgba[..., :3] = np.clip(rgba[..., :3] * (1 + (EYE_GAIN - 1) * mask), 0, 255)
    return Image.fromarray(rgba.astype(np.uint8), "RGBA")


def robot_data_uri(robot, height):
    width = round(robot.width * height / robot.height)
    resized = robot.resize((width, height), Image.LANCZOS)
    buffer = io.BytesIO()
    resized.save(buffer, "WEBP", quality=86, method=6)
    return "data:image/webp;base64," + base64.b64encode(buffer.getvalue()).decode("ascii")


def apply_ligatures(font, glyph_names):
    """Applies the font's 'liga' substitutions (the ALEX lockup is a ligature)."""
    if "GSUB" not in font or font["GSUB"].table.FeatureList is None:
        return glyph_names
    gsub = font["GSUB"].table
    lookup_indices = [index for record in gsub.FeatureList.FeatureRecord if record.FeatureTag == "liga"
                      for index in record.Feature.LookupListIndex]
    for lookup_index in lookup_indices:
        for subtable in gsub.LookupList.Lookup[lookup_index].SubTable:
            result, i = [], 0
            while i < len(glyph_names):
                for ligature in subtable.ligatures.get(glyph_names[i], []):
                    components = ligature.Component
                    if glyph_names[i + 1:i + 1 + len(components)] == components:
                        result.append(ligature.LigGlyph)
                        i += 1 + len(components)
                        break
                else:
                    result.append(glyph_names[i])
                    i += 1
            glyph_names = result
    return glyph_names


def text_path(font, text, size, x, baseline):
    """Returns (SVG path data, advance width) for text set in font at the given size."""
    glyph_set = font.getGlyphSet()
    cmap = font.getBestCmap()
    scale = size / font["head"].unitsPerEm
    pen = SVGPathPen(glyph_set)
    cursor = 0.0
    for name in apply_ligatures(font, [cmap[ord(character)] for character in text]):
        glyph_set[name].draw(TransformPen(pen, (scale, 0, 0, -scale, x + cursor, baseline)))
        cursor += glyph_set[name].width * scale
    return pen.getCommands(), cursor


def ihmc_path(x_height, x, baseline):
    """Returns SVG path data for IHMC's "ihmc" wordmark with the i's left edge at x."""
    scale = x_height / IHMC_WORDMARK_X_HEIGHT

    def place(match):
        values = [float(value) for value in match.group(2).split()]
        points = [f"{x + scale * px:.2f} {baseline + scale * py:.2f}" for px, py in zip(values[::2], values[1::2])]
        return match.group(1) + " ".join(points)

    return "".join(re.sub(r"([MLCZ])([^MLCZ]*)", place, letter) for letter in IHMC_WORDMARK)


def build_svg(robot_uri, robot_width):
    alex_font = TTFont(ALEX_FONT)
    cap_height = alex_font["OS/2"].sCapHeight / alex_font["head"].unitsPerEm

    logo_x, logo_size = 440, 200
    logo_baseline = 282
    logo, logo_width = text_path(alex_font, "ALEX", logo_size, logo_x, logo_baseline)
    logo_top = logo_baseline - cap_height * logo_size
    ihmc = ihmc_path(23.5, logo_x + 0.14 * logo_width + 3.25, logo_top - 12)

    glow_cx = ROBOT_X + robot_width / 2
    return f"""<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 {WIDTH} {HEIGHT}" role="img" aria-label="IHMC Alex Humanoid">
<defs>
<linearGradient id="background" x1="0" y1="0" x2="1" y2="1">
<stop offset="0" stop-color="#051a4f" stop-opacity="0.9"/>
<stop offset="0.5" stop-color="#1150d8" stop-opacity="0.84"/>
<stop offset="1" stop-color="#1fa8f5" stop-opacity="0.76"/>
</linearGradient>
<radialGradient id="robotGlow" cx="{glow_cx:.1f}" cy="200" r="260" gradientUnits="userSpaceOnUse">
<stop offset="0" stop-color="#bfeaff" stop-opacity="0.55"/>
<stop offset="0.55" stop-color="#7fd0ff" stop-opacity="0.18"/>
<stop offset="1" stop-color="#7fd0ff" stop-opacity="0"/>
</radialGradient>
<radialGradient id="corner" cx="{WIDTH}" cy="0" r="520" gradientUnits="userSpaceOnUse">
<stop offset="0" stop-color="#8fe0ff" stop-opacity="0.35"/>
<stop offset="1" stop-color="#8fe0ff" stop-opacity="0"/>
</radialGradient>
<linearGradient id="rail" x1="0" y1="0" x2="1" y2="0">
<stop offset="0" stop-color="#ffffff" stop-opacity="0"/>
<stop offset="0.5" stop-color="#ffffff" stop-opacity="0.22"/>
<stop offset="1" stop-color="#ffffff" stop-opacity="0"/>
</linearGradient>
<pattern id="dots" width="22" height="22" patternUnits="userSpaceOnUse">
<circle cx="2" cy="2" r="1.2" fill="#ffffff" fill-opacity="0.09"/>
</pattern>
<clipPath id="card"><rect width="{WIDTH}" height="{HEIGHT}" rx="{CORNER}"/></clipPath>
</defs>
<g clip-path="url(#card)">
<rect width="{WIDTH}" height="{HEIGHT}" fill="url(#background)"/>
<rect width="{WIDTH}" height="{HEIGHT}" fill="url(#dots)"/>
<rect width="{WIDTH}" height="{HEIGHT}" fill="url(#corner)"/>
<rect width="{WIDTH}" height="{HEIGHT}" fill="url(#robotGlow)"/>
<path d="M{logo_x - 60} 352 H{logo_x + 610} L{logo_x + 680} 422" fill="none" stroke="url(#rail)" stroke-width="3" stroke-linecap="round"/>
<path d="M{logo_x + 150} 52 H{WIDTH - 110} L{WIDTH - 60} 2" fill="none" stroke="url(#rail)" stroke-width="3" stroke-linecap="round"/>
<image x="{ROBOT_X}" y="{ROBOT_Y}" width="{robot_width:.1f}" height="{ROBOT_HEIGHT}" href="{robot_uri}"/>
<path d="{logo}" fill="#ffffff"/>
<path d="{ihmc}" fill="#ffffff"/></g>
<rect x="0.75" y="0.75" width="{WIDTH - 1.5}" height="{HEIGHT - 1.5}" rx="{CORNER - 0.75}" fill="none" stroke="#ffffff" stroke-opacity="0.16" stroke-width="1.5"/>
</svg>
"""


def main():
    robot = lighten_eyes(cut_out_robot(PHOTO))
    robot_width = robot.width * ROBOT_HEIGHT / robot.height
    svg = build_svg(robot_data_uri(robot, ROBOT_HEIGHT * ROBOT_PIXEL_SCALE), robot_width)
    OUTPUT.write_text(svg)
    print(f"Wrote {OUTPUT.relative_to(REPO_ROOT)} ({len(svg) / 1024:.0f} KiB)")


if __name__ == "__main__":
    main()
