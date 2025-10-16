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
class ForceTorqueState_(idl.IdlStruct, typename="alexander_msgs.msg.dds_.ForceTorqueState_"):
    sensor_name: types.bounded_str(32)
    force: types.array[types.float64, 3]
    torque: types.array[types.float32, 3]
    is_operational: bool


