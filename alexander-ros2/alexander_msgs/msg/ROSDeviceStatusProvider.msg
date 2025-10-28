# Data holder containing status info for a given device

# The device name
string<=70 name

# Primary device status info
bool is_responding
bool is_faulted
byte ethercat_state

# More specific device status info related to isFaulted (elmo twitter fault)
bool under_voltage
bool over_voltage
bool sto_disabled
bool current_short
bool over_temp
# uint32 elmo_error_code TODO
# float64 input_encoder_error TODO
# float64 output_encoder_error TODO
# float64 output_encoder_error TODO