This python repo contains classes for communication with Alexander via ROS2 through cyclonedds.

Current version: 0.3.1

Requirements:
- Python: 3.10
- Dependencies:
	- cyclonedds
	- build

If building the package, there are two options:
- `python -m build --sdist`. This will create `alexander_msgs-<version>.tar.gz`
- `python -m build --wheel`. This will create `alexander_msgs-<version>-py3-none-any.whl`

To install that package, run `pip install <package>`. 

TODO make a remote package that can be downloaded from our remote repo
