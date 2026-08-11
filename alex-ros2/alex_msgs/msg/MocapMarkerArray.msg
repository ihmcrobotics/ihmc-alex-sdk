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
# `position` and `visible` describes marker `motive_id[i]`. A consumer that sees them
# disagree drops the whole frame.

# Stable per-marker identifier, consistent across frames, matching the consumer's
# labelling file. For markers in a Motive asset this is the packed (model_id << 16) |
# marker_id; for point-cloud markers it is the streaming id. Either is fine as long as it
# is stable and the labelling file agrees.
int32[<=256] motive_id

# Marker position in W. Ignored when the corresponding `visible` is false; publishing NaN
# there is encouraged but not required.
geometry_msgs/Point[<=256] position

# False when Motive did not actually see the marker this frame -- occluded, or solved by
# the asset rather than observed. A marker may also simply be omitted from all three
# sequences, which means the same thing.
#
# What must NOT happen is publishing a stale or model-solved position with visible=true.
# The consumer's rigidity and conditioning gates cannot detect an invented marker, and a
# cluster completed by three real markers and one invented one registers cleanly to the
# wrong pose.
bool[<=256] visible
