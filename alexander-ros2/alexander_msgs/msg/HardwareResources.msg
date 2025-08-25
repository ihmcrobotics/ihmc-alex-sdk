# Designates the resources to use for hardware

# Designate the number of xml resources and their names
uint32 num_resources

# The directory containing the xml resources of the desired version of the robot
string<=32 xml_directory

# The directory containing the urdf resources of the desired version of the robot
string<=32 urdf_directory

# The list of individual XML files comprising the full XML description of the robot
string<=32[9] xml_resources

# The list of individual URDF files comprising the full URDF description of the robot
string<=32[6] urdf_resources