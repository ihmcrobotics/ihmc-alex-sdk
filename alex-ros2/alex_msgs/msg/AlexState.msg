# Holds the current state of Alex

# General Status
float64 time
bool is_faulted
bool is_calibrated
bool are_actuators_enabled
bool safe_power_up_complete
bool safe_power_down_complete
float64 current_low_level_master_gain

# Joint States
OneDOFJointState[<=50] joint_states
uint32 number_of_joints

# IMU States
IMUState[<=50] imu_states
uint32 number_of_imus

# FT States
ForceTorqueState[<=50] ft_states
uint32 number_of_fts
