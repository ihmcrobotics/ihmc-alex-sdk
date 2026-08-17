# Pre-processed depth observation for the fixed-neck / active-neck transformer nav policies.
# Published by the Isaac Sim DDS bridge (and later the real perception stack) already in the
# POLICY's format: cropped, resampled and sanitized exactly like training
# (nan/inf -> 6 m, clamp [0, 6], divided by 6 — so values are in [0, 1], 1.0 = FAR).
#
# head_depth : head camera center crop -> 24x32, row-major        (768 values)
# chest_depth: chest camera full frame -> 12x16, row-major        (192 values)
#
# The training contract is a fresh frame every 20 ms policy step (update_period 0.02);
# the consumer holds the last frame if a tick is missed and treats never-received as
# all-FAR (1.0 everywhere).

uint32 sequence_number

# Publisher-side sim/wall time of the frame, seconds (for staleness accounting)
float64 frame_time

float32[768] head_depth
float32[192] chest_depth
