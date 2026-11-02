from launch import LaunchDescription
from launch.actions import DeclareLaunchArgument
from launch.substitutions import Command, LaunchConfiguration, PathJoinSubstitution
from launch_ros.actions import Node
from launch_ros.parameter_descriptions import ParameterValue
from launch_ros.substitutions import FindPackageShare


def generate_launch_description():
    package_share = FindPackageShare("alex_description")
    model = LaunchConfiguration("model")

    robot_description = ParameterValue(
        Command(["cat ", PathJoinSubstitution([package_share, "urdf", model])]), value_type=str
    )

    return LaunchDescription([
        DeclareLaunchArgument(
            "model",
            default_value="alex_v2.wholeBody_abilityHands_convex.urdf",
            description="URDF file name in alex_description/urdf (one of: alex_v2.wholeBody_abilityHands_convex.urdf, alex_v2.wholeBody_convex.urdf, alex_v2.wholeBody_abilityHands.urdf, alex_v2.wholeBody.urdf)",
        ),
        Node(
            package="robot_state_publisher",
            executable="robot_state_publisher",
            parameters=[{"robot_description": robot_description}],
        ),
        Node(package="joint_state_publisher_gui", executable="joint_state_publisher_gui"),
        Node(
            package="rviz2",
            executable="rviz2",
            arguments=["-d", PathJoinSubstitution([package_share, "rviz", "display.rviz"])],
        ),
    ])
