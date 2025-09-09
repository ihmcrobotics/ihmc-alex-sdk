# Designates the resources to use for hardware

# Designate the number of xml resources
uint32 num_xml_resources

# Designate the number of xml resources
uint32 num_urdf_resources

# The list of individual XML files comprising the full XML description of the robot
string<=32[9] xml_resources

# The list of individual URDF files comprising the full URDF description of the robot
string<=32[9] urdf_resources

# The directory containing the xml and URDF resources of the desired version of the robot
string<=32 directory