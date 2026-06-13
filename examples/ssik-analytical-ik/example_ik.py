"""Closed-form inverse kinematics for the IHMC Alex V2 arms via ssik.

The Alex V2 arm is a 7-DOF, kinematically redundant chain: every reachable
end-effector pose has a 1-DOF self-motion manifold of solutions. ssik solves it
analytically -- no numerical seed, no iteration. Three usage modes:

  1. Exact IK at a chosen redundancy value  -> the exact branches, machine
     precision. Pin joint 0; ssik solves the remaining 6R in closed form.
  2. The self-motion manifold, sampled       -> default solve() sweeps joint 0
     at 16 values and returns every branch.
  3. Seeded tracking                          -> the single solution nearest
     your current config (branch-continuous, fast).

    pip install "ssik>=2.1.0"
    python example_ik.py
"""

import alex_v2_left_arm_ik as left_solver
import alex_v2_right_arm_ik as right_solver
import numpy as np

from ssik._urdf import load_urdf_kinbody_normalized
from ssik.solvers.jointlock import seven_r

ARMS = [
    ("left", left_solver, "alex_v2_left_arm.urdf", "LEFT_GRIPPER_Z_LINK"),
    ("right", right_solver, "alex_v2_right_arm.urdf", "RIGHT_GRIPPER_Z_LINK"),
]


def wrap(d):
    return (d + np.pi) % (2 * np.pi) - np.pi


def exact_at_redundancy(solver, urdf, ee, n=300):
    """Mode 1: pin joint 0 to a chosen value, solve the 6R remainder exactly.

    We pin it to each random target's own joint-0 value and recover that exact
    configuration -- the strongest correctness check.
    """
    kb = load_urdf_kinbody_normalized(urdf, "TORSO_LINK", ee)
    rng = np.random.default_rng(0)
    worst_q = worst_fk = 0.0
    for _ in range(n):
        q = rng.uniform(-1.5, 1.5, size=solver.DOF)
        T = solver.fk(q)
        sols, _ = seven_r.solve(
            kb, T, lock_samples=np.array([q[0]]), respect_limits=False, allow_refinement=True
        )
        assert sols, "no solution at the pinned redundancy"
        worst_q = max(worst_q, min(np.abs(wrap(np.asarray(s.q) - q)).max() for s in sols))
        worst_fk = max(worst_fk, min(np.abs(solver.fk(s.q) - T).max() for s in sols))
    return worst_q, worst_fk


def manifold(solver, n=500):
    """Mode 2: default solve() returns the manifold sampled at 16 redundancy
    values. Every returned branch must reproduce the pose."""
    rng = np.random.default_rng(0)
    counts, worst_fk = [], 0.0
    for _ in range(n):
        q = rng.uniform(-1.5, 1.5, size=solver.DOF)
        T = solver.fk(q)
        sols = solver.solve(T)
        assert sols, "no solution at a reachable pose"
        counts.append(len(sols))
        worst_fk = max(worst_fk, max(np.abs(solver.fk(s.q) - T).max() for s in sols))
    return int(np.median(counts)), worst_fk


def track(solver, steps=200):
    """Mode 3: follow a smooth Cartesian path, each step seeded by the previous
    solution. Returns the single nearest branch, fast. Steps are small while the
    redundancy sits between lock samples and jump when the nearest branch hops to
    an adjacent grid value -- see the README for smoother options."""
    q = np.zeros(solver.DOF)
    T = solver.fk(q)
    steps_taken, worst_fk = [], 0.0
    for i in range(steps):
        target = T.copy()
        target[:3, 3] += 0.05 * np.array([np.sin(2 * np.pi * i / steps), 0.0, 0.0])
        sols = solver.solve(target, q_seed=q, max_solutions=1)
        assert sols, "lost the target while tracking"
        nxt = np.asarray(sols[0].q)
        steps_taken.append(np.abs(wrap(nxt - q)).max())
        worst_fk = max(worst_fk, np.abs(solver.fk(nxt) - target).max())
        q = nxt
    return float(np.median(steps_taken)), float(np.max(steps_taken)), worst_fk


for name, solver, urdf, ee in ARMS:
    wq, wfk = exact_at_redundancy(solver, urdf, ee)
    med, mfk = manifold(solver)
    med_step, worst_step, tfk = track(solver)
    print(f"[{name}]")
    print(f"  exact @ redundancy : recovered q to {wq:.1e} rad, FK {wfk:.1e}  (300 poses)")
    print(f"  sampled manifold   : {med} branches/pose, FK <= {mfk:.1e}  (500 poses)")
    print(
        f"  seeded tracking    : step median {med_step:.3f} / max {worst_step:.3f} rad, "
        f"FK {tfk:.1e}  (200 steps)"
    )
