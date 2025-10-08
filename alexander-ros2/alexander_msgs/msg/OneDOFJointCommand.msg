# Sets the desireds for controlling each 1DOF joint

string<=35 joint_name

# Joint Desireds
float64 q_des
float64 qd_des
float64 tau_des
float64 stiffness
float64 damping
float64 max_position_error
float64 max_velocity_error
float64 max_torque

# Enable Actuator Command
bool enable

# Joint control type, 0 is Position, 1 is Velocity, 2 is Effort, 3 disables the control
byte joint_control_type