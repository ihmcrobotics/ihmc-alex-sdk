from enum import auto
from typing import TYPE_CHECKING, Optional
from dataclasses import dataclass

import cyclonedds.idl as idl
import cyclonedds.idl.annotations as annotate
import cyclonedds.idl.types as types

from ._OneDOFJointCommand_ import OneDOFJointCommand_

# root module import for resolving types
# import alexander_msgs


@dataclass
@annotate.final
@annotate.autoid("sequential")
class AlexanderCommand_(idl.IdlStruct, typename="alexander_msgs.msg.dds_.AlexanderCommand_"):
    enable_actuators: bool
    clear_faults: bool
    calibrate: bool
    robot_control_state: types.byte
    number_of_joints: types.uint32
    joint_commands: types.array[OneDOFJointCommand_, 50]
    low_level_master_gain: types.float64


