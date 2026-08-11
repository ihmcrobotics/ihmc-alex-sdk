# Publishing motion-capture markers to Alex

This is the contract for whatever process talks to Motive and republishes marker positions as
ROS 2. That process is **not** in this repository — this document plus
[`msg/MocapMarkerArray.msg`](msg/MocapMarkerArray.msg) is the whole interface.

The consumer is `alex-mocap`, which registers each marker cluster against a calibrated layout to
recover per-link poses. It never sees Motive; it sees only this topic.

---

## What to publish

| | |
|---|---|
| **Topic** | `mocap_markers` |
| **Type** | `alex_msgs::msg::dds_::MocapMarkerArray_` (Java: `alex_msgs.MocapMarkerArray`) |
| **QoS** | **BEST_EFFORT** |
| **Domain** | **42** on the current consumer machine — see *Network* below, this is not the default |
| **Rate** | Motive's frame rate, typically 100–200 Hz. Publish every frame; do not decimate. |

Best-effort is deliberate. The consumer stages one frame and drops the rest by design, so
reliable delivery would spend retransmissions on data that is already stale. A dropped frame
costs one tick of a held pose; a *late* frame costs a reconstruction of where the robot used to
be.

Dependency for a JVM publisher:

```kotlin
api("us.ihmc:ihmc-alex-sdk:0.4.0")   // brings alex_msgs + us.ihmc:jros2
```

---

## Network — read this before writing any code

The consumer machine (`Cyber-1327`, `10.100.5.115/8` on `enp4s0`) is currently configured
**loopback-only**. As shipped, nothing you publish from another machine will ever arrive, and
there will be no error on either side — DDS discovery simply never matches.

`~/.ihmc/jros2.properties` on the consumer, as of this writing:

```properties
jros2.fastdds.interface.whitelist= 127.0.0.1/8
jros2.ros.domain.id=42
jros2.fastdds.intraprocess.delivery=false
```

Two things follow.

**Domain 42, not 0.** Whatever you publish from must be on the same domain. jros2 resolves it
from, in order: `jros2.properties` (cwd, then JAR resources, then `$HOME/.ihmc/`), then the
`ROS_DOMAIN_ID` environment variable, then the default. The properties file wins, so exporting
`ROS_DOMAIN_ID=42` on a machine that also has a `jros2.properties` will not do what you expect.

**The whitelist must be widened on the consumer** to include the LAN interface — this is the
consumer side's job, not yours, but it is the first thing to check when nothing arrives:

```properties
jros2.fastdds.interface.whitelist= 127.0.0.1/8, 10.100.5.115/8
jros2.ros.domain.id=42
```

Corresponding environment variables, if you prefer them on the publisher side:
`FASTDDS_INTERFACE_WHITELIST`, `ROS_DOMAIN_ID`, `FASTDDS_INRAPROCESS_DELIVERY` (note the typo in
that last one — it is spelled that way in jros2 and must be matched exactly).

The publisher must also be reachable on the same subnet. Tailscale (`100.78.167.88`) is present
on the consumer; if the Motive machine is only reachable that way, that address has to go in the
whitelist instead, and multicast discovery over Tailscale is its own problem — prefer a real LAN
path.

---

## Three things that are silent when wrong

These will not throw, will not warn, and will produce a plausible reconstruction that is simply
incorrect. They are listed first because they are the whole reason this document exists.

### 1. Z-up, metres

Motive streams **Y-up by default.** `alex-mocap` requires Z-up.

Fix it in Motive (`Streaming → Up Axis → Z-Up`) or rotate before publishing. A Y-up stream
reconstructs a robot lying on its side that still registers cleanly, because the marker
constellation is internally consistent either way — nothing downstream can detect it.

Units are metres. Motive can be configured in millimetres; check it.

### 2. Label provenance honestly; never launder a solved marker as observed

Motive will happily report a position for an occluded marker, inferred from the rigid-body asset.
There is no `visible` boolean in this message precisely because that flattens a distinction that
matters. Instead each marker carries a `provenance` byte:

| Constant | Value | Meaning |
|---|---|---|
| `PROVENANCE_NOT_SEEN` | 0 | not reported, or no usable position |
| `PROVENANCE_OBSERVED` | 1 | triangulated by >=2 cameras **and** labelled by the asset |
| `PROVENANCE_POINT_CLOUD_SOLVED` | 2 | triangulated by >=2 cameras, labelled by point-cloud solve |
| `PROVENANCE_MODEL_SOLVED` | 3 | **not a measurement** -- inferred from the asset pose |
| `PROVENANCE_UNKNOWN` | 4 | publisher could not determine provenance |

The constants are generated onto the message class: `MocapMarkerArray.PROVENANCE_OBSERVED`, etc.

Read these from NatNet's labelled-marker `params` bitfield -- occluded, point-cloud-solved,
model-solved. (Confirm the exact bit semantics against your NatNet SDK version; they are stable
across 3.x/4.x but worth a five-minute check.) **Publish everything you have, labelled truthfully.**
The consumer decides what to register against and reports the mix per cluster, so "three real
markers and one the asset invented" becomes something visible rather than something discovered
later.

If you genuinely cannot get at those flags, publish `PROVENANCE_UNKNOWN` rather than guessing
`OBSERVED`. A stream nobody labelled should look like one. The fallback of last resort is turning
off asset-based marker solving in Motive, which removes the ambiguity at the cost of the feature.

**Why 2 and 3 are not the same thing.** Point-cloud-solved is a real triangulation whose *label*
is uncertain -- the position is measured, the identity is a guess. Model-solved is the opposite:
the identity is certain and the position is invented. They fail in opposite directions and want
opposite treatment, which a boolean cannot express.

**Why model-solved is the dangerous one.** The consumer does not use Motive's rigid-body pose. It
runs its own registration of each marker cluster against its own separately calibrated layout --
that is the entire point of the framework. A model-solved marker smuggles Motive's pose estimate
back in through the marker channel, expressed in *Motive's* stored layout, which is the very thing
that calibration exists to replace.

The damage is quantifiable. Registration stiffness goes as `N * r^2` for `N` markers at cluster
radius `r`; one correspondence displaced by `delta` applies torque `r * delta`, so the pose biases
by

    dtheta ~ delta / (N * r),      dt ~ delta / N

For a pelvis bracket (`N = 4`, `r ~ 70 mm`) and `delta ~ 2 mm` -- roughly the disagreement between
Motive's layout and the calibrated one -- that is ~7 mrad, about 6 mm of centre-of-mass error
through the body's lever arm. Larger than every other term in the error budget combined, and
systematic, so it does not average out.

And it is invisible: a synthetic marker sits at nominal geometry with zero noise, so adding it
makes the registration residual *smaller* and the conditioning *better* while the answer gets
worse. The rigidity check looks for inter-marker distances varying too *much*; these vary too
*little*.

### 3. The timestamp epoch

`timestamp_nanoseconds` must share an epoch with the robot's encoder stream, or the
reconstructed pose silently lags whatever it is compared against — which shows up as a phase
error in the estimator comparison and reads like an estimator bug.

If you can resolve Motive's own timestamp into that epoch, publish it. If you cannot, publish the
transmit time (`System.nanoTime()` offset to wall clock, or `clock_gettime(CLOCK_REALTIME)`) and
**say so in the handoff** — the consumer reports clock skew as a diagnostic and someone needs to
know whether that number is meaningful.

---

## Message fields

```
uint64 timestamp_nanoseconds     # see trap 3
uint32 frame_number              # Motive's frame counter, monotonic; gaps distinguish
                                 #   "network dropped a frame" from "Motive stopped"
int32[<=256] motive_id           # stable per-marker id, must match the labelling file
geometry_msgs/Point[<=256] position   # metres, Motive world frame W, Z-up
uint8[<=256] provenance          # see trap 2 -- NOT a visibility flag
```

The three sequences are **parallel and must be the same length**: entry `i` of `position` and
`provenance` describes marker `motive_id[i]`. The consumer drops any frame where they disagree, and
counts it.

`motive_id` may be the packed `(model_id << 16) | marker_id` that Motive uses for markers in an
asset, or the point-cloud streaming id. Either is fine — the only requirements are that it is
**stable across frames** and that it **matches the labelling file** (below).

Do **not** apply any floor-tilt correction. That is a measured session constant applied
downstream; baking it into the stream makes it invisible and unrecorded.

---

## The labelling file — please produce this too

The consumer addresses markers by *name*, not by Motive id, because the names carry the
marker-to-link assignment. Someone has to write down that mapping, and the publisher side is the
only place that knows Motive's ids.

Produce a file like this alongside the stream:

```
# alex-mocap marker labelling, format 1
# motiveId,markerName
1001,PELVIS_LINK_M0
1002,PELVIS_LINK_M1
1003,PELVIS_LINK_M2
1004,PELVIS_LINK_M3
2001,LEFT_THIGH_M0
...
```

**The naming rule is load-bearing.** Clusters are inferred as *everything before the last
underscore*, and that prefix must be the **exact URDF link name**. So a marker on `PELVIS_LINK`
is `PELVIS_LINK_M0`, giving cluster `PELVIS_LINK`. A marker named `PELVIS_M0` yields a cluster
called `PELVIS`, which is not a link, and the run fails at startup — loudly, which is the good
case.

Rules:
- ≥ 3 markers per link, 4 recommended. Three is the minimum for a pose; four gives redundancy
  when one is occluded.
- Ids unique, names unique.
- A marker's id must not be reused for a different physical marker between sessions.

Nothing can catch a marker that is physically on the thigh but labelled as a shank marker. That
assignment is taken on trust, and it yields a clean calibration of the wrong thing. Check it
against the actual robot when the markers go on.

---

## Worked publisher

```java
import alex_msgs.MocapMarkerArray;
import us.ihmc.jros2.ROS2Node;
import us.ihmc.jros2.ROS2Publisher;
import us.ihmc.jros2.ROS2QoSProfile;
import us.ihmc.jros2.ROS2Topic;

ROS2Node node = new ROS2Node("motive_bridge");

ROS2Topic<MocapMarkerArray> topic = new ROS2Topic<>().appendedWith("mocap_markers")
                                                     .withType(MocapMarkerArray.class)
                                                     .withQoS(ROS2QoSProfile.BEST_EFFORT);

ROS2Publisher<MocapMarkerArray> publisher = node.createPublisher(topic);

// Allocate once, reuse every frame.
MocapMarkerArray message = new MocapMarkerArray();

// ... per NatNet frame:
message.setTimestampNanoseconds(timestampNanoseconds);
message.setFrameNumber(frameNumber);

message.getMotiveId().clear();
message.getPosition().clear();
message.getProvenance().clear();

for (int i = 0; i < markerCount; i++)
{
   message.getMotiveId().add(motiveId[i]);

   // add() returns a preallocated element to fill in place -- no allocation per frame.
   geometry_msgs.Point point = message.getPosition().add();
   point.setX(x[i]);           // metres, Z-up
   point.setY(y[i]);
   point.setZ(z[i]);

   message.getProvenance().add(provenanceOf(params[i]));   // trap 2: label it truthfully
}

publisher.publish(message);
```

The one piece of real work is the mapping. Sketch, to be checked against your SDK's
`sMarker.params` bit definitions — the ordering below is the usual NatNet 3.x/4.x layout, but
**verify it before trusting a capture**, because getting it inverted is exactly trap 2:

```java
private static final short OCCLUDED           = 0x01;   // bit 0
private static final short POINT_CLOUD_SOLVED = 0x02;   // bit 1
private static final short MODEL_SOLVED       = 0x04;   // bit 2

static byte provenanceOf(short params)
{
   // Order matters: a model-solved marker is typically ALSO flagged occluded, and the
   // occlusion is the less specific fact. Test the specific bits first.
   if ((params & MODEL_SOLVED) != 0)
      return MocapMarkerArray.PROVENANCE_MODEL_SOLVED;
   if ((params & OCCLUDED) != 0)
      return MocapMarkerArray.PROVENANCE_NOT_SEEN;
   if ((params & POINT_CLOUD_SOLVED) != 0)
      return MocapMarkerArray.PROVENANCE_POINT_CLOUD_SOLVED;

   return MocapMarkerArray.PROVENANCE_OBSERVED;
}
```

If you cannot get `params` at all, return `PROVENANCE_UNKNOWN` from this method rather than
`PROVENANCE_OBSERVED`. The consumer will refuse the markers and say why, which is recoverable; a
stream that claims everything was observed is not.

`clear()` before each frame is not optional — the sequences retain their previous contents
otherwise, and you would publish a growing frame until the 256 cap throws.

Cap is 256 markers per frame. Alex's marker sets run well under that; if you need more, the
bound is in `MocapMarkerArray.msg` and both sides must be regenerated.

---

## Verifying it works, before anyone connects a robot

0. **Same machine first.** Run a publisher and a subscriber on the *publisher* box before
   involving the network at all. If that fails, the problem is the message or the QoS. If it
   works and the cross-machine case does not, the problem is the whitelist or the domain — see
   *Network*. Conflating the two is how a day disappears.

1. **Is it on the wire at all?**
   ```
   ROS_DOMAIN_ID=42 ros2 topic list | grep mocap_markers
   ROS_DOMAIN_ID=42 ros2 topic hz  /mocap_markers      # should sit at Motive's frame rate
   ROS_DOMAIN_ID=42 ros2 topic echo /mocap_markers --once
   ```
   If `ros2 topic list` shows nothing, check the domain and the interface whitelist on **both**
   machines before suspecting anything else. Note `ros2` CLI needs the `alex_msgs` type available
   to echo the payload; without it you will still see the topic listed, which is enough to prove
   discovery works.

2. **Is it Z-up?** Hold a marker at a known height and echo it. `position.z` should be that
   height, and `position.y` should not be. This takes ten seconds and catches trap 1.

3. **Is `provenance` honest?** Occlude one marker by hand. Its provenance must leave `OBSERVED`
   — `NOT_SEEN` if Motive drops it, `MODEL_SOLVED` if the asset fills it in. If it stays
   `OBSERVED` with a plausible position, you are reading the params bitfield wrong: trap 2, and
   the consumer cannot detect it downstream.

4. **Are the sequences parallel?** `ros2 topic echo --once` and count. Three different lengths
   means every frame will be dropped.

5. **Is `frame_number` monotonic and gap-free** over a quiet minute? Gaps here are the network;
   a frozen counter is Motive.

---

## What the consumer does with it

For context, not because you need to implement any of it: the marker frame goes to
`NatNetMocapSource.onFrameReceived(...)`, then per-cluster rigid registration against the
calibrated layout (`LinkPoseEstimator`), then pelvis pose extraction, and finally a translucent
ghost robot drawn at that pose next to the real one in the SCS2 visualizer. Full detail lives in
`alex-mocap/RUNNING.md` and `FRAMEWORK.md`.
