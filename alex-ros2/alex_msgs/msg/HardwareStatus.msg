# Holds hardware status info of Alex

# Various fault info
bool robot_fault
bool motor_fault
bool missed_deadline_fault
bool working_counter_fault

# Important EtherCAT Stuff
uint32 working_counter_mismatch_count
uint32 missed_deadlines

# Power Management Board Information
float64 battery_charge_percetage
float64 estimated_runtime_minutes
bool enabled_24_v

# Joint States
ROSDeviceStatusProvider[<=75] device_status_providers