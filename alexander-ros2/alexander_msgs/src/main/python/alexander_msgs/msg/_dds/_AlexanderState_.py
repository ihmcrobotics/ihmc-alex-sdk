from enum import auto
from typing import TYPE_CHECKING, Optional
from dataclasses import dataclass

import cyclonedds.idl as idl
import cyclonedds.idl.annotations as annotate
import cyclonedds.idl.types as types

from ._OneDOFJointState_ import OneDOFJointState_
from ._IMUState_ import IMUState_
from ._ForceTorqueState_ import ForceTorqueState_

# root module import for resolving types
# import alexander_msgs


@dataclass
@annotate.final
@annotate.autoid("sequential")
class AlexanderState_(idl.IdlStruct, typename="alexander_msgs.msg.dds_.AlexanderState_"):
    time: types.float64
    is_faulted: bool
    is_calibrated: bool
    number_of_joints: types.uint32
    number_of_imus: types.uint32
    number_of_fts: types.uint32
    joint_states: types.array[OneDOFJointState_, 50]
    imu_states: types.array[IMUState_, 50]
    ft_states: types.array[ForceTorqueState_, 50]


