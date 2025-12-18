# Holds current state of the FT sensor

string<=32 sensor_name

# Sensor Data
float64[3] force
float64[3] torque

# Sensor Status
bool is_operational