#!/usr/bin/env python3
"""
Convert mesh files into *_visual.stl files for make_convex_hulls.py.

Supported inputs:
- .glb
- .gltf
- .obj
- .stl

Examples:
  python3 convert_meshes_to_visual_stl.py assets --recursive
  python3 convert_meshes_to_visual_stl.py assets/merged --recursive --overwrite

This writes each converted mesh next to the source file:
  robot.glb -> robot_visual.stl
  arm.obj   -> arm_visual.stl
"""

import argparse
import sys
from pathlib import Path

import trimesh

SUPPORTED_EXTS = {".obj"}


def load_as_single_mesh(path: Path) -> trimesh.Trimesh:
    loaded = trimesh.load(str(path), force="scene")

    if isinstance(loaded, trimesh.Scene):
        if not loaded.geometry:
            raise ValueError("scene contains no geometry")
        meshes = [g for g in loaded.geometry.values() if isinstance(g, trimesh.Trimesh)]
        if not meshes:
            raise ValueError("scene contains no mesh geometry")
        mesh = trimesh.util.concatenate(meshes)
    elif isinstance(loaded, trimesh.Trimesh):
        mesh = loaded
    else:
        raise ValueError(f"unsupported mesh type: {type(loaded)}")

    mesh = mesh.copy()
    mesh.merge_vertices()
    mesh.update_faces(mesh.nondegenerate_faces())
    mesh.update_faces(mesh.unique_faces())
    mesh.remove_unreferenced_vertices()
    return mesh


def convert_one(src: Path, overwrite: bool) -> tuple[Path, str]:
    dst = src.with_name(f"{src.stem}_visual.stl")
    if dst.exists() and not overwrite:
        return dst, "SKIP exists"

    mesh = load_as_single_mesh(src)
    mesh.export(str(dst))
    return dst, f"OK {len(mesh.faces)} faces"


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Convert GLB/GLTF/OBJ/STL meshes into *_visual.stl files"
    )
    parser.add_argument("input_dir", help="Directory containing source meshes")
    parser.add_argument("--recursive", action="store_true", help="Search subdirectories recursively")
    parser.add_argument("--overwrite", action="store_true", help="Overwrite existing *_visual.stl files")
    args = parser.parse_args()

    root = Path(args.input_dir)
    if not root.exists():
        print(f"Error: input directory not found: {root}")
        sys.exit(1)

    walker = root.rglob("*") if args.recursive else root.glob("*")
    inputs = [
        p for p in walker
        if p.is_file()
        and p.suffix.lower() in SUPPORTED_EXTS
        and not p.name.endswith("_visual.stl")
    ]

    if not inputs:
        print(f"No source meshes found in {root}. Supported: {sorted(SUPPORTED_EXTS)}")
        sys.exit(1)

    print(f"Converting {len(inputs)} mesh(es) in {root}\n")

    converted = 0
    skipped = 0
    failed = 0

    for src in sorted(inputs):
        try:
            dst, status = convert_one(src, args.overwrite)
            print(f"{src} -> {dst}  [{status}]")
            if status.startswith("OK"):
                converted += 1
            else:
                skipped += 1
        except Exception as e:
            failed += 1
            print(f"{src}  [FAIL: {e}]")

    print(f"\nDone. converted={converted} skipped={skipped} failed={failed}")
    if failed:
        sys.exit(2)


if __name__ == "__main__":
    main()
