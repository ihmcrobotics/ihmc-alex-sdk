# Alexander ROS2 Python Implementation
This repo contains classes for communication with Alexander via ROS2 through cyclonedds.

Current version: 0.3.1

Requirements:
- Python < 3.11
- Build dependencies:
  - build
- Use Dependencies:
	- cyclonedds (will be installed when running installation)

## Building alexander_msgs
To build the package with resources, follow these steps:
1. Copy any wanted files/folders into `alexander_msgs/resources`. This will get them included in the build
2. Run `python -m build`. This will create two files in the `dist` folder:
   1. `alexander_msgs-<version>-py3-none-any.whl`
   2. `alexander_msgs-<version>.tar.gz`

## Installing alexander_msgs
To install the package, run `pip install <download_location>/<package>`. I recommend using the `.whl`

In the currently built wheel, we have added a `resources` folder that contains two items:
- `mjcf`: Holds mjx descriptions of Alex
- `msg`: Holds the actual message files corresponding to the python files

TODO make a remote package that can be downloaded from our remote repo
