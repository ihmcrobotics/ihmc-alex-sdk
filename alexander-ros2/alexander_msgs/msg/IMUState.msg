# Holds the state of the IMU

string<=32 sensor_name

# SensorData
# This is the position of the IMU in the world frame
float64[3] position
# This is the orientation of the IMU in the world frame
float64[4] quaternion
# This is the angular velocity of the IMU in the sensor frame
float64[3] gyroscope
# This is the linear acceleration of the IMU in the sensor frame
float64[3] accelerometer

# Sensor Status
int32 temperature
bool is_operational