from enum import auto
from typing import TYPE_CHECKING, Optional
from dataclasses import dataclass

import cyclonedds.idl as idl
import cyclonedds.idl.annotations as annotate
import cyclonedds.idl.types as types

# root module import for resolving types
# import alexander_msgs


@dataclass
@annotate.final
@annotate.autoid("sequential")
class OneDOFJointCommand_(idl.IdlStruct, typename="alexander_msgs.msg.dds_.OneDOFJointCommand_"):
    joint_name: types.bounded_str(35)
    q_des: types.float64
    qd_des: types.float64
    tau_des: types.float64
    stiffness: types.float64
    damping: types.float64
    max_position_error: types.float64
    max_velocity_error: types.float64
    max_torque: types.float64
    enable: bool
    joint_control_type: types.uint8