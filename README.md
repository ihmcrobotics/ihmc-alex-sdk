<p align="center">
  <img src="media/17_Alex_v2_ArmsCrossed_4.jpg" width="20%" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <img src="media/25_Alex_v2_Crouch_HelpingHand.png" width="40%" /><br>
  <a href="https://robots.ihmc.us/">IHMC Robotics</a>
</p>

# ihmc-alex-sdk
Light SDK with resources for visualizing/simulating Alex, properly initializing hardware, and communicating with Alex's low-level control process.

## SDK Structure
### `alex-models`

This directory contains all files required for describing the Alex humanoid robot model both on hardware and in simulation/visualization. For simplicity and modularity 
when switching robot configurations, each body segment is split into its own file to be selected if that segment is included. The subdirectory structure is as follows:
- `alex_hardware_description`: Contains XML files for describing the hardware configuration of a specific Alex hardware unit number (e.g. Alex001, Alex002, etc.)
  - `XYZ_xml_description`: Contains the hardware description XML files for Alex hardware unit number XYZ (e.g. `001_xml_description` for Alex001). This includes
    sensor parameters, EtherCAT slave parameters, joint zeros, etc.
  - `actuator_xml_descriptions`: Contains the hardware description XML files for each individual actuator package (motor/gearbox combo) across all Alex units.
    These contain things like gear ratio, kt, etc.
- `alex_virtual_description`: Contains URDF, mesh, and MJCF files for describing the Alex robot model configuration of a specific Alex design version (e.g. Alex
  V1, Alex V2, etc.) in visualization and simulation
  - `alex_vX_description`: Contains the virtual description (URDF, mesh, MJCF, etc.) for Alex VX (e.g. Alex V1, Alex V2, etc.)
    - `meshes`: Contains the OBJ and MTL files to describe each link on Alex
    - `mjcf`: Contains XML files for use with MuJoCo
    - `urdf`: Contains URDF files describing Alex for use in visualization/simulation

### `alex-ros2`
This directory contains all files specific to ROS communication between Alex's onboard low-level control process, and any external high-level process
- `alex_msgs`: Contains all Alex-specific messages used for communication with the robot
  - The generated Java code for using these messages is contained within `src/main/generated-java`
- `ihmc-hands-ros2`: Git submodule of [`ihmc-hands-ros2`](https://github.com/ihmcrobotics/ihmc_hands_ros2)
  - This contains URDF and OBJ files for hands used on Alex, as well as ROS2 messages for communication with the hands

## Maintainers
* Stefan Fasano (sfasano@ihmc.org)
* Reese Peterson (rpeterson@ihmc.org)
* Dexton Anderson (danderson@ihmc.org)
* Robert Griffin (rgriffin@ihmc.org)
* Duncan Calvert (dcalvert@ihmc.org)
