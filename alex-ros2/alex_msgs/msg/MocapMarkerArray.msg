# One frame of labelled motion-capture markers, as Motive streams them.
#
# Consumed by alex-mocap's NatNetMocapSource, which reconstructs per-link poses by
# registering each marker cluster against its calibrated layout. See MOCAP_STREAMING.md
# in this directory for the publisher contract, including the two conventions below that
# are silent when wrong.
#
# FRAME. Positions are metres in Motive's world frame W, Z-UP. Motive streams Y-up by
# default; set Streaming -> Up Axis to Z-Up, or rotate before publishing. A Y-up stream
# produces a plausible, wrong reconstruction rather than an error.
#
# NOT GRAVITY-ALIGNED. Do not apply any floor-tilt correction here. That correction is a
# measured session constant applied downstream (alex-mocap F8, TiltMeasurement); baking it
# into the stream makes it invisible and unrecorded.

# Motive's frame timestamp. Must share an epoch with the robot's encoder stream, or the
# reconstructed pose silently lags whatever it is compared against. Publish the transmit
# time if Motive's own timestamp cannot be resolved to that epoch, and say so.
uint64 timestamp_nanoseconds

# Motive's frame counter. Gaps here separate "the network dropped a frame" from "Motive
# stopped sending", which are otherwise indistinguishable at the consumer.
uint32 frame_number

# The three sequences below are parallel and MUST be the same length: entry i of
# `position` and `provenance` describes marker `motive_id[i]`. A consumer that sees them
# disagree drops the whole frame.

# Stable per-marker identifier, consistent across frames, matching the consumer's
# labelling file. For markers in a Motive asset this is the packed (model_id << 16) |
# marker_id; for point-cloud markers it is the streaming id. Either is fine as long as it
# is stable and the labelling file agrees.
int32[<=256] motive_id

# Marker position in W. Ignored when the corresponding provenance is NOT_SEEN; publishing
# NaN there is encouraged but not required.
geometry_msgs/Point[<=256] position

# How this frame's position for this marker was arrived at. NOT a visibility flag: the
# consumer decides which provenances it will register against, and reports the mix per
# cluster, so that "three real markers and one the asset invented" is a thing you can see
# rather than a thing you find out about later.
#
# Read these from NatNet's labelled-marker params bitfield. Confirm the bit semantics
# against your SDK version.

# Not reported this frame, or reported with no usable position. Equivalent to omitting the
# marker from all three sequences.
uint8 PROVENANCE_NOT_SEEN=0

# Triangulated from two or more cameras AND labelled by the asset. The only provenance the
# consumer registers against by default.
uint8 PROVENANCE_OBSERVED=1

# Triangulated from two or more cameras, but labelled by the point-cloud solve rather than
# by the asset. The POSITION is a real measurement; only the identity is less certain.
# Kept distinct from MODEL_SOLVED because the failure modes are opposite: this one risks
# the wrong label on a real point, that one is not a measurement at all.
uint8 PROVENANCE_POINT_CLOUD_SOLVED=2

# Inferred from the asset: Motive estimated the rigid body from the markers it DID see and
# reported this one at the pose implied by its stored layout. This is not a measurement --
# it carries no new information and it carries Motive's layout, which is the thing this
# project's calibration exists to replace. Registering against it biases the pose by about
# delta/(N*r) in rotation while making the residual SMALLER and the conditioning BETTER.
# Publish it if you have it, honestly labelled; do not launder it as OBSERVED.
uint8 PROVENANCE_MODEL_SOLVED=3

# The publisher could not determine provenance. Deliberately representable, and deliberately
# not spelled OBSERVED: a stream nobody labelled should be visible as such rather than
# indistinguishable from one that was checked. Treated as unusable by default, and counted.
uint8 PROVENANCE_UNKNOWN=4

uint8[<=256] provenance
