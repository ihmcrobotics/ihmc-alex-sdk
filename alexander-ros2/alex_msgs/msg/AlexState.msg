# Holds the current state of Alexander

# General Status
float64 time
bool is_faulted
bool is_calibrated
uint32 number_of_joints
uint32 number_of_imus
uint32 number_of_fts

# Joint States
OneDOFJointState[<=50] joint_states

# Sensor States
IMUState[<=50] imu_states
ForceTorqueState[<=50] ft_states
