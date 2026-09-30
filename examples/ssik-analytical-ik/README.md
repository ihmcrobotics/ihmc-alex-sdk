# Closed-form IK for the Alex V2 arms (via ssik)

Analytical inverse kinematics for the IHMC Alex V2 7-DOF arms, using
[ssik](https://github.com/personalrobotics/ssik) (BSD-3, `pip install ssik`).
No numerical seed, no iteration — the IK is solved in closed form.

The Alex V2 arm is a **non-SRS 7R** chain (shoulder Y/X/Z, elbow Y, wrist Z/X,
gripper Z; the shoulder triple is non-concurrent — ~0.157 m offset, ~40° tilts —
so it is not spherical-roll-spherical, and EAIK/IKFast-style solvers don't cover
it). Being 7-DOF it is **kinematically redundant**: each reachable end-effector
pose has a 1-DOF self-motion manifold of solutions.

## Run

```
pip install "ssik>=2.1.0"
python example_ik.py
```

Measured here (Apple M-series), both arms:

| mode | result |
|------|--------|
| **Exact IK at a chosen redundancy** | recovers the target config to ~1e-11 rad, **FK closure ~6e-16** (300 poses) |
| Full self-motion manifold (`solve(T)`) | ~40 branches/pose, all FK-closing (median ~1e-13, worst ≤ 1.9e-7) (500 poses) |
| Seeded tracking (`q_seed`, `max_solutions=1`) | step median ~0.02 rad, occasional ~2 rad hop; FK ~1e-10 (200 steps) |

## The three modes

**1. Exact IK at a chosen redundancy value (machine precision).** Pin joint 0
to any value and ssik solves the remaining 6R in closed form — the exact
branches at that redundancy, FK closure ~1e-15:

```python
import numpy as np
from ssik._urdf import load_urdf_kinbody_normalized
from ssik.solvers.jointlock import seven_r

kb = load_urdf_kinbody_normalized("alex_v2_left_arm.urdf", "TORSO_LINK", "LEFT_GRIPPER_Z_LINK")
sols, _ = seven_r.solve(kb, T_target, lock_samples=np.array([psi]), allow_refinement=True)
```

**2. The whole self-motion manifold, sampled.** The standalone solvers
`alex_v2_left_arm_ik.py` / `alex_v2_right_arm_ik.py` (emitted by `ssik build`,
zero-build to import) sweep joint 0 at 16 values and return every branch:

```python
import alex_v2_left_arm_ik as arm
sols = arm.solve(T_target)              # ~40 branches across the manifold
T_check = arm.fk(sols[0].q)             # forward kinematics
```

**3. Seeded tracking.** Pass the current configuration to get the single
nearest solution (ssik ≥ 2.1.0 ranks by largest-single-joint move, so the arm
holds its branch):

```python
sols = arm.solve(T_target, q_seed=q_current, max_solutions=1)
```

Because mode 2/3 resolve the redundancy on a 16-value grid, tracking is smooth
between grid points but takes an occasional step when the nearest branch hops to
an adjacent redundancy sample. For uniformly smooth motion, follow the
redundancy continuously with mode 1 (pin joint 0 near its previous value), or
re-build the solvers with a denser grid (`lock_samples=` in `ssik build`).

## Files

- `alex_v2_left_arm_ik.py`, `alex_v2_right_arm_ik.py` — standalone closed-form
  solvers (import + `solve`/`fk`). Re-run `ssik build` to regenerate.
- `alex_v2_left_arm.urdf`, `alex_v2_right_arm.urdf` — single-chain,
  kinematics-only URDFs (merged from the modular `alex_V2_description` URDFs;
  visual/collision/inertial stripped). Base `TORSO_LINK`, tip
  `*_GRIPPER_Z_LINK`.
- `example_ik.py` — the three modes above, with self-checks.

## Rebuild from the IHMC URDFs

The arm is split across `alex_v2.leftUpperArm.urdf` (shoulder Y/X/Z) and
`alex_v2.leftForearm.urdf` (elbow Y, wrist Z/X, gripper Z) in
`alex-models/alex_V2_description/urdf/`. Merge each pair's `<link>` + revolute
`<joint>` elements into one chain, then:

```python
from ssik._urdf import load_urdf_kinbody_normalized
from ssik.core.dispatcher import dispatch
from ssik.core.codegen import emit_artifact

kb = load_urdf_kinbody_normalized("alex_v2_left_arm.urdf", "TORSO_LINK", "LEFT_GRIPPER_Z_LINK")
emit_artifact(kb=kb, plan=dispatch(kb), module_name="alex_v2_left_arm_ik",
              output_path="alex_v2_left_arm_ik.py", arm_label="IHMC Alex V2 (left arm)")
```

The RR derivation takes ~10 min/arm at build time; the emitted solver runs in
closed form at solve time. The right arm is the mirror (`rightUpperArm` +
`rightForearm`, tip `RIGHT_GRIPPER_Z_LINK`).
