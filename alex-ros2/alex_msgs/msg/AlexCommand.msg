# Holds desired control commands for Alex

# Operational commands of the robot
bool enable_actuators
bool clear_faults
bool calibrate
bool servo_actuators
# Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
byte robot_control_state
uint32 number_of_joints

# Joint Commands for the robot
OneDOFJointCommand[<=50] joint_commands
