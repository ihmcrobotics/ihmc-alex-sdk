# Holds info for each 1DOF controlled Joint

string<=35 joint_name

# Joint Data
float64 q
float64 qd
float64 tau

# Actuator statuses
float64 act_temp
bool is_operational