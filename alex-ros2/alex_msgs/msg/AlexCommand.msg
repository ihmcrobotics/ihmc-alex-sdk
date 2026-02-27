# Holds desired control commands for Alex

# Operational commands of the robot
bool request_safe_power_up
bool request_safe_power_down
bool enable_actuators
bool clear_faults
bool calibrate
float64 low_level_master_gain

# Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
byte robot_control_state

# Joint Commands for the robot
OneDOFJointCommand[<=50] joint_commands
uint32 number_of_joints
