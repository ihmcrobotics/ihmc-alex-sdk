#!/usr/bin/env python3
"""
Generates alex_description, a standalone ROS 2 robot description package with whole-body
URDFs of the IHMC Alex Humanoid, from the per-segment URDF fragments in alex-models and the
hand models in ihmc_hands_ros2.

Each variant is merged into a single URDF, every referenced mesh (plus its .mtl and
textures) is copied into the package, and mesh URIs are rewritten to
package://alex_description/meshes/...

Usage:
    python3 utils/generate_alex_description.py
"""

import re
import shutil
import sys
import xml.etree.ElementTree as ET
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent
PACKAGE_NAME = "alex_description"
PACKAGE_VERSION = "0.1.0"

V2_URDF_DIR = REPO_ROOT / "alex-models/alex_virtual_description/alex_v2_description/urdf"
HANDS_ROOT = REPO_ROOT / "alex-ros2/ihmc_hands_ros2"
ABILITY_HAND_URDF_DIR = HANDS_ROOT / "urdf/abilityHand"

# Maps the package:// prefixes used by the source URDFs to (source directory, destination
# directory under meshes/). Longest prefix wins.
MESH_SOURCES = {
    "package://alex_virtual_description/alex_v2_description/meshes/":
        (REPO_ROOT / "alex-models/alex_virtual_description/alex_v2_description/meshes", "alex_v2"),
    "package://abilityHand/":
        (HANDS_ROOT / "meshes/abilityHand", "ability_hand"),
}

def v2_body(suffix=""):
    """The body fragments; suffix "_convex" selects the fragments with convex hull collision meshes."""
    return [V2_URDF_DIR / f"alex_v2.{segment}{suffix}.urdf"
            for segment in ("lowerBody", "head", "leftUpperArm", "leftForearm", "rightUpperArm", "rightForearm")]


V2_ABILITY_HANDS = [
    V2_URDF_DIR / "alex_v2.leftAbilityHandAdapter.urdf",
    ABILITY_HAND_URDF_DIR / "ability_hand_left_large.urdf",
    V2_URDF_DIR / "alex_v2.rightAbilityHandAdapter.urdf",
    ABILITY_HAND_URDF_DIR / "ability_hand_right_large.urdf",
]

ROBOT_NAME = "Alex"

# URDF file name (without extension) -> ordered list of fragments to merge.
# The first variant is the default model used by the launch file. The non-convex variants have
# <capsule> collisions, which are not part of the URDF spec and are dropped with an error by urdfdom.
VARIANTS = {
    "alex_v2.wholeBody_abilityHands_convex": v2_body("_convex") + V2_ABILITY_HANDS,
    "alex_v2.wholeBody_convex": v2_body("_convex"),
    "alex_v2.wholeBody_abilityHands": v2_body() + V2_ABILITY_HANDS,
    "alex_v2.wholeBody": v2_body(),
}


def load_fragment(path):
    if not path.is_file():
        hint = ""
        if HANDS_ROOT in path.parents:
            hint = " (run: git submodule update --init alex-ros2/ihmc_hands_ros2)"
        raise FileNotFoundError(f"Missing URDF fragment {path}{hint}")
    root = ET.parse(path).getroot()
    if root.tag != "robot":
        raise ValueError(f"{path}: root element is <{root.tag}>, expected <robot>")
    return root


def merge_fragments(robot_name, fragment_paths):
    robot = ET.Element("robot", {"name": robot_name})
    for path in fragment_paths:
        robot.append(ET.Comment(f" Generated from {path.relative_to(REPO_ROOT)} "))
        for child in load_fragment(path):
            robot.append(child)
    return robot


def validate_tree(robot, robot_name):
    links = [link.get("name") for link in robot.findall("link")]
    joints = robot.findall("joint")

    duplicate_links = {name for name in links if links.count(name) > 1}
    if duplicate_links:
        raise ValueError(f"{robot_name}: duplicate links {sorted(duplicate_links)}")
    joint_names = [joint.get("name") for joint in joints]
    duplicate_joints = {name for name in joint_names if joint_names.count(name) > 1}
    if duplicate_joints:
        raise ValueError(f"{robot_name}: duplicate joints {sorted(duplicate_joints)}")

    link_set = set(links)
    children = set()
    for joint in joints:
        parent = joint.find("parent").get("link")
        child = joint.find("child").get("link")
        for link in (parent, child):
            if link not in link_set:
                raise ValueError(f"{robot_name}: joint {joint.get('name')} references undefined link {link}")
        if child in children:
            raise ValueError(f"{robot_name}: link {child} has more than one parent joint")
        children.add(child)

    roots = link_set - children
    if len(roots) != 1:
        raise ValueError(f"{robot_name}: expected exactly one root link, found {sorted(roots)}")
    return roots.pop(), len(links), len(joints)


def resolve_mesh_uri(uri):
    for prefix in sorted(MESH_SOURCES, key=len, reverse=True):
        if uri.startswith(prefix):
            source_dir, dest_subdir = MESH_SOURCES[prefix]
            relative = uri[len(prefix):]
            return source_dir / relative, Path(dest_subdir) / relative
    raise ValueError(f"No mesh source configured for URI {uri}")


def mesh_dependencies(mesh_path):
    """Returns files a mesh needs next to it: .mtl files for .obj, textures for .mtl."""
    if mesh_path.suffix.lower() == ".obj":
        pattern = re.compile(r"^\s*mtllib\s+(.+?)\s*$")
    elif mesh_path.suffix.lower() == ".mtl":
        pattern = re.compile(r"^\s*(?:map_\w+|bump|disp|decal|refl)\s+(?:-\S+\s+\S+\s+)*(.+?)\s*$")
    else:
        return []
    dependencies = []
    with open(mesh_path, "r", errors="replace") as file:
        for line in file:
            match = pattern.match(line)
            if match:
                dependencies.append(match.group(1))
    return dependencies


def copy_with_dependencies(source, destination, copied):
    if destination in copied:
        return
    if not source.is_file():
        raise FileNotFoundError(f"Referenced mesh file not found: {source}")
    destination.parent.mkdir(parents=True, exist_ok=True)
    shutil.copy2(source, destination)
    copied.add(destination)
    for dependency in mesh_dependencies(source):
        dependency_source = source.parent / dependency
        if dependency_source.is_file():
            copy_with_dependencies(dependency_source, destination.parent / dependency, copied)
        else:
            print(f"  warning: {source.name} references missing file {dependency}", file=sys.stderr)


def relocate_meshes(robot, meshes_dir, copied):
    for mesh in robot.iter("mesh"):
        source, relative_dest = resolve_mesh_uri(mesh.get("filename"))
        copy_with_dependencies(source, meshes_dir / relative_dest, copied)
        mesh.set("filename", f"package://{PACKAGE_NAME}/meshes/{relative_dest.as_posix()}")


def write_urdf(robot, path):
    ET.indent(robot, space="  ")
    tree = ET.ElementTree(robot)
    with open(path, "wb") as file:
        file.write(b'<?xml version="1.0"?>\n')
        file.write(b"<!-- This file is generated by utils/generate_alex_description.py. Do not edit. -->\n")
        tree.write(file, encoding="utf-8", xml_declaration=False)
        file.write(b"\n")


PACKAGE_XML = """<?xml version="1.0"?>
<?xml-model href="http://download.ros.org/schema/package_format3.xsd" schematypens="http://www.w3.org/2001/XMLSchema"?>
<package format="3">
  <name>{package}</name>
  <version>{version}</version>
  <description>URDF and meshes for the IHMC Alex Humanoid</description>
  <maintainer email="sfasano@ihmc.org">Stefan Fasano</maintainer>
  <license>Apache-2.0</license>
  <license file="meshes/ability_hand/LICENSE">MIT</license>

  <buildtool_depend>ament_cmake</buildtool_depend>

  <exec_depend>robot_state_publisher</exec_depend>
  <exec_depend>joint_state_publisher_gui</exec_depend>
  <exec_depend>rviz2</exec_depend>

  <export>
    <build_type>ament_cmake</build_type>
  </export>
</package>
"""

CMAKE_LISTS = f"""cmake_minimum_required(VERSION 3.8)
project({PACKAGE_NAME})

find_package(ament_cmake REQUIRED)

install(
  DIRECTORY urdf meshes launch rviz
  DESTINATION share/${{PROJECT_NAME}}
)

ament_package()
"""

DISPLAY_LAUNCH = """from launch import LaunchDescription
from launch.actions import DeclareLaunchArgument
from launch.substitutions import Command, LaunchConfiguration, PathJoinSubstitution
from launch_ros.actions import Node
from launch_ros.parameter_descriptions import ParameterValue
from launch_ros.substitutions import FindPackageShare


def generate_launch_description():
    package_share = FindPackageShare("{package}")
    model = LaunchConfiguration("model")

    robot_description = ParameterValue(
        Command(["cat ", PathJoinSubstitution([package_share, "urdf", model])]), value_type=str
    )

    return LaunchDescription([
        DeclareLaunchArgument(
            "model",
            default_value="{default_model}",
            description="URDF file name in {package}/urdf (one of: {model_list})",
        ),
        Node(
            package="robot_state_publisher",
            executable="robot_state_publisher",
            parameters=[{{"robot_description": robot_description}}],
        ),
        Node(package="joint_state_publisher_gui", executable="joint_state_publisher_gui"),
        Node(
            package="rviz2",
            executable="rviz2",
            arguments=["-d", PathJoinSubstitution([package_share, "rviz", "display.rviz"])],
        ),
    ])
"""

DISPLAY_RVIZ = """Panels:
  - Class: rviz_common/Displays
    Name: Displays
Visualization Manager:
  Class: ""
  Displays:
    - Class: rviz_default_plugins/Grid
      Name: Grid
      Enabled: true
      Reference Frame: <Fixed Frame>
    - Class: rviz_default_plugins/RobotModel
      Name: RobotModel
      Enabled: true
      Description Source: Topic
      Description Topic:
        Value: /robot_description
      Visual Enabled: true
      Collision Enabled: false
    - Class: rviz_default_plugins/TF
      Name: TF
      Enabled: false
  Global Options:
    Fixed Frame: {fixed_frame}
    Frame Rate: 30
  Tools:
    - Class: rviz_default_plugins/Interact
    - Class: rviz_default_plugins/MoveCamera
    - Class: rviz_default_plugins/Select
    - Class: rviz_default_plugins/Measure
  Views:
    Current:
      Class: rviz_default_plugins/Orbit
      Distance: 3
      Focal Point:
        X: 0
        Y: 0
        Z: 0
      Pitch: 0.3
      Yaw: 0.8
Window Geometry:
  Width: 1200
  Height: 800
"""


def generate_package():
    output = REPO_ROOT / PACKAGE_NAME
    shutil.rmtree(output, ignore_errors=True)
    for subdir in ("urdf", "meshes", "launch", "rviz"):
        (output / subdir).mkdir(parents=True)
    meshes_dir = output / "meshes"
    copied = set()
    root_links = set()

    for variant, fragments in VARIANTS.items():
        robot = merge_fragments(ROBOT_NAME, fragments)
        root_link, link_count, joint_count = validate_tree(robot, variant)
        root_links.add(root_link)
        relocate_meshes(robot, meshes_dir, copied)
        write_urdf(robot, output / "urdf" / f"{variant}.urdf")
        print(f"  urdf/{variant}.urdf: {link_count} links, {joint_count} joints, root {root_link}")

    if len(root_links) != 1:
        raise ValueError(f"Variants have different root links {sorted(root_links)}; rviz config needs one fixed frame")
    # The Ability Hand meshes are MIT licensed by PSYONIC, which requires the notice to ship with them.
    shutil.copy2(HANDS_ROOT / "LICENSE.PSYONIC", meshes_dir / "ability_hand" / "LICENSE")

    variant_names = list(VARIANTS)
    (output / "package.xml").write_text(PACKAGE_XML.format(package=PACKAGE_NAME, version=PACKAGE_VERSION))
    (output / "CMakeLists.txt").write_text(CMAKE_LISTS)
    (output / "launch" / "display.launch.py").write_text(DISPLAY_LAUNCH.format(
        package=PACKAGE_NAME,
        default_model=f"{variant_names[0]}.urdf",
        model_list=", ".join(f"{name}.urdf" for name in variant_names),
    ))
    (output / "rviz" / "display.rviz").write_text(DISPLAY_RVIZ.format(fixed_frame=root_links.pop()))
    print(f"  meshes/: {len(copied)} files")


def main():
    try:
        print(f"Generating {PACKAGE_NAME}")
        generate_package()
    except (FileNotFoundError, ValueError) as error:
        print(f"error: {error}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
