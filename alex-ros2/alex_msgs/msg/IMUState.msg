# Holds the state of the IMU

string<=32 sensor_name

# Sensor Data
float64[4] quaternion
float64[3] gyroscope
float64[3] accelerometer

# Sensor Status
int32 temperature
bool is_operational