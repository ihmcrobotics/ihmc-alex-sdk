<p align="center">
  <img src="media/17_Alex_v2_ArmsCrossed_4.png" width="20%" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="media/25_Alex_v2_Crouch_HelpingHand.png" width="40%" /><br>
  <a href="https://robots.ihmc.us/">IHMC Robotics</a>
</p>

# ihmc-alex-sdk
Light SDK with resources for visualizing/simulating Alex, properly initializing hardware, and communicating with Alex's low-level control process.

## SDK Structure
### alex-models

This directory contains all files required for describing the Alex humanoid both on hardware and in simulation/visualization. For simplicity and modularity when switching robot
configurations, each body segment is split into its own file to be selected if that segment is included. The subdirectories in the version directories are as follows:
- `alex_hardware_description`: Contains XML files for describing the hardware configuration of a specific Alex hardware unit number (e.g. Alex001, Alex002, etc.)
  - `0XY_xml_description`: Contains the hardware description (XMLs) for Alex hardware unit number 0XY (e.g. Alex001, Alex002, etc.). This includes sensor
    parameters, EtherCAT slave parameters, joint zeros, etc.
  - `actuator_xml_descriptions`: Contains the hardware description (XMLs) for each individual actuator package (motor/gearbox combo) across all Alex units
- `alex_virtual_description`: Contains URDF, mesh, and MJCF files for describing the layout of an Alex design version number (e.g. Alex V1, Alex V2, etc.) in visualization and simulation
  - `alex_vX_description`: Contains the virtual description (URDF, mesh, MJCF, etc.) for Alex VX (e.g. Alex V1, Alex V2, etc.)
    - `meshes`: Contains the OBJ and MTL files to describe each link on Alex
    - `mjcf`: Contains XML files for use with MuJoCo
    - `urdf`: URDF files describing Alex for use in visualization/simulation within the IHMC Java Framework

### alex-ros2
This directory contains all files specific to ROS communication between Alex's onboard low-level control process, and any external high-level process
- `alex_msgs`: Contains all Alex-specific messages used for communication
  - The generated Java code for using these messages is contained within `src/main/generated-java`
- `ihmc-hands-ros2`: Git submodule of [`ihmc-hands-ros2`](https://github.com/ihmcrobotics/ihmc_hands_ros2)
  - This contains URDF and OBJ files for hands used on Alex and ROS messages for communication with hands

## Maintainers
* Stefan Fasano (sfasano@ihmc.org)
* Reese Peterson (rpeterson@ihmc.org)
* Dexton Anderson (danderson@ihmc.org)
* Robert Griffin (rgriffin@ihmc.org)
* Duncan Calvert (dcalvert@ihmc.org)
