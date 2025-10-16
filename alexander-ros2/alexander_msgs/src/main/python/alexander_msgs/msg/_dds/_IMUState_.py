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
class IMUState_(idl.IdlStruct, typename="alexander_msgs.msg.dds_.IMUState_"):
    sensor_name: types.bounded_str(32)
    quaternion: types.array[types.float64, 4]
    gyroscope: types.array[types.float64, 3]
    accelerometer: types.array[types.float64, 3]
    temperature: types.int32
    is_operational: bool


