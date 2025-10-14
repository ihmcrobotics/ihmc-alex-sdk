# Holds hardware status info of Alexander

# Various fault info
bool robot_fault
bool motor_fault
bool missed_deadline_fault
bool working_counter_fault

# Important EtherCAT Stuff
float64 working_counter_mismatch_count
float64 missed_deadlines

# Joint States
ROSDeviceStatusProvider[<=50] device_status_holders