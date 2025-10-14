# Holds hardware status info of Alexander

# Various fault info
bool robot_fault
bool motor_fault
bool missed_deadline_fault
bool working_counter_fault

# Important EtherCAT Stuff
uint32 working_counter_mismatch_count
uint32 missed_deadlines

# Joint States
ROSDeviceStatusProvider[<=50] device_status_providers