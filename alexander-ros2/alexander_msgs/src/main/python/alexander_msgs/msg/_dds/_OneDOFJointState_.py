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
class OneDOFJointState_(idl.IdlStruct, typename="alexander_msgs.msg.dds_.OneDOFJointState_"):
    joint_name: types.bounded_str(35)
    q: types.float64
    qd: types.float64
    tau: types.float64
    act_temp: types.float64
    is_operational: bool