<p align="center">
  <img src="media/alexander_running.png" width="30%" /><br>
  <a href="https://robots.ihmc.us/">IHMC Robotics</a>
</p>

# ihmc-alexander-sdk
Light SDK with resources for visualizing/simulating Alex, properly initializing hardware, and communicating between low and high-level processes.

## SDK Structure
### alexander-models
This directory contains all files specific to describing Alex. The files in the directories are as follows:
- `hardware`: Contains XML files describing the hardware on the robot, including parameters for all sensors and actuators
  - For simplicity when switching robot configurations, each body segment is split into its own file to be selected if that segment is included
- `meshes`: Contains the OBJ and MTL files to describe each link on Alex
- `mjcf`: Contains XML files for use with MuJoCo
- `rl_urdf`: URDF files describing Alex for use in reinforcement learning applications.
- `urdf`: URDF files describing Alex for use in visualization/simulation within the IHMC Java Framework
  - For simplicity when switching robot configurations, each body segment is split into its own file to be selected if that segment is included
### alexander-ros2
This directory contains all files specific to ROS communication between the low-level and high-level communication of Alex
- `alexander_msgs`: Contains all Alex-specific messages used for communication
  - The generated Java code for using these messages is contained within `src/main/generated-java`
- `ihmc-hands-ros2`: Git submodule of [`ihmc-hands-ros2`](https://github.com/ihmcrobotics/ihmc_hands_ros2)
  - This contains URDF and OBJ files for hands used on Alex and ROS messages for communication with hands

## Maintainers
* Stefan Fasano (sfasano@ihmc.org)
* Reese Peterson (rpeterson@ihmc.org)
* Dexton Anderson (danderson@ihmc.org)
* Robert Griffin (rgriffin@ihmc.org)
* Duncan Calvert (dcalvert@ihmc.org)
