"""
Generate a single convex hull STL for each *_visual.stl in a directory.

Each output is a proper convex hull — fully convex, watertight, no artifacts.
Strategy: pre-simplify the source mesh with meshlabserver first, then compute
the convex hull of that simplified mesh. This produces a naturally low face
count hull without any post-decimation (which causes spike artifacts).

Usage:
    python3 make_convex_hulls.py <input_dir> <output_dir> [--mlx script.mlx]

Examples:
    # No pre-simplification (raw hull, higher face count)
    python3 make_convex_hulls.py assets/merged convex_hull_meshes

    # Pre-simplify source to ~400 faces before hulling (low face count, no artifacts)
    python3 make_convex_hulls.py assets/merged convex_hull_meshes --mlx reduce_to_400.mlx
"""

import argparse
import subprocess
import sys
import tempfile
from pathlib import Path

import trimesh


def simplify_with_meshlab(input_path: Path, script: Path) -> Path:
    tmp = tempfile.NamedTemporaryFile(suffix=".stl", delete=False)
    tmp.close()
    subprocess.run(
        ["meshlabserver", "-i", str(input_path), "-o", tmp.name, "-s", str(script)],
        check=True, capture_output=True,
    )
    return Path(tmp.name)


def convex_hull_from_mesh(input_path: Path, mlx: Path = None) -> trimesh.Trimesh:
    source = input_path

    if mlx:
        source = simplify_with_meshlab(input_path, mlx)

    mesh = trimesh.load(str(source), force="mesh")
    mesh.merge_vertices()
    mesh.update_faces(mesh.nondegenerate_faces())
    mesh.update_faces(mesh.unique_faces())
    mesh.remove_unreferenced_vertices()

    if mlx:
        source.unlink()

    return mesh.convex_hull


def main():
    parser = argparse.ArgumentParser(description="Generate convex hull STLs from visual meshes")
    parser.add_argument("input_dir", help="Directory containing *_visual.stl source meshes")
    parser.add_argument("output_dir", help="Directory to write *_convex.stl outputs")
    parser.add_argument("--mlx", default=None,
                        help="MeshLab .mlx script to pre-simplify source before hulling")
    args = parser.parse_args()

    input_dir = Path(args.input_dir)
    output_dir = Path(args.output_dir)
    mlx = Path(args.mlx) if args.mlx else None

    if not input_dir.exists():
        print(f"Error: input directory not found: {input_dir}")
        sys.exit(1)

    output_dir.mkdir(parents=True, exist_ok=True)

    inputs = sorted(input_dir.glob("*_visual.stl"))
    if not inputs:
        print(f"No *_visual.stl files found in {input_dir}")
        sys.exit(1)

    print(f"Generating convex hulls for {len(inputs)} meshes"
          + (f"  (pre-simplified with {mlx.name})" if mlx else ""))
    print(f"  Input:  {input_dir}")
    print(f"  Output: {output_dir}\n")

    for f in inputs:
        stem = f.name[: -len("_visual.stl")]
        out = output_dir / f"{stem}_convex.stl"
        hull = convex_hull_from_mesh(f, mlx)
        hull.export(str(out))
        status = "OK" if hull.is_convex and hull.is_watertight else \
                 "watertight-only" if hull.is_watertight else "WARN: non-watertight source"
        print(f"  {stem}: {len(hull.faces)} faces  [{status}]")

    print(f"\nDone — {len(inputs)} hulls written to {output_dir}")


if __name__ == "__main__":
    main()
