# Holds desired control commands for Alex

# Requests auto startup, which: requests safe power up, clears faults, enables actuators, and sets robot_control_state to user
bool request_auto_startup

# Requests auto shutdown, which: disables actuators and requests safe power down
bool request_auto_shutdown

# Requests for safe power up and power down procedures for PMB
bool request_safe_power_up
bool request_safe_power_down

# Other individual controls for robot startup procedure
bool request_enable_actuators
bool request_disable_actuators
bool clear_faults
bool calibrate
bool servo_actuators
bool unservo_quickly
bool use_requested_master_gain
float64 requested_master_gain

# Option to disable non-critical faults
bool disable_noncritical_faults

# Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
byte robot_control_state

# Joint Commands for the robot
OneDOFJointCommand[<=50] joint_commands
uint32 number_of_joints
