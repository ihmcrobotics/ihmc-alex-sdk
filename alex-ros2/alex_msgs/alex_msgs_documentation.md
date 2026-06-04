# alex_msgs — Message Documentation

---

- **AlexCommand** — Holds desired control commands for Alex

    - request_auto_startup
        - Type: bool
        - Description: Requests auto startup — initiates safe power up, clears faults, enables actuators, and sets robot_control_state to user.

    - request_auto_shutdown
        - Type: bool
        - Description: Requests auto shutdown — disables actuators and initiates safe power down.

    - request_safe_power_up
        - Type: bool
        - Description: Requests the safe power up procedure for the PMB.

    - request_safe_power_down
        - Type: bool
        - Description: Requests the safe power down procedure for the PMB.

    - request_enable_actuators
        - Type: bool
        - Description: Requests enabling of actuators.

    - request_disable_actuators
        - Type: bool
        - Description: Requests disabling of actuators.

    - clear_faults
        - Type: bool
        - Description: Clears active faults on the robot.

    - calibrate
        - Type: bool
        - Description: Triggers actuator calibration.

    - servo_actuators
        - Type: bool
        - Description: Commands actuators to servo (hold position).

    - unservo_quickly
        - Type: bool
        - Description: Commands actuators to unservo immediately.

    - use_requested_master_gain
        - Type: bool
        - Description: When true, applies the value in requested_master_gain to all actuators.

    - requested_master_gain
        - Type: float64
        - Description: Master gain value applied to all actuators when use_requested_master_gain is true.

    - disable_noncritical_faults
        - Type: bool
        - Description: Suppresses non-critical faults from triggering protective responses.

    - robot_control_state
        - Type: byte
        - Description: Sets the robot control mode: 0 = do nothing, 1 = hold position, 2 = user control.

    - joint_commands
        - Type: OneDOFJointCommand[<=50]
        - Description: Array of joint commands for up to 50 joints.

    - number_of_joints
        - Type: uint32
        - Description: Number of valid entries in the joint_commands array.

---

- **AlexState** — Holds the current state of Alex

    - time
        - Type: float64
        - Description: Timestamp of the current state.

    - is_faulted
        - Type: bool
        - Description: True if the robot is in a faulted state.

    - is_calibrated
        - Type: bool
        - Description: True if the robot has been calibrated.

    - is_servoing
        - Type: bool
        - Description: True if the robot is in the process of servoing.

    - is_unservoing
        - Type: bool
        - Description: True if the robot is in the process of unservoing.

    - is_servoed
        - Type: bool
        - Description: True if the robot is fully servoed.

    - are_actuators_enabled
        - Type: bool
        - Description: True if all actuators are currently enabled.

    - safe_power_up_complete
        - Type: bool
        - Description: True if the safe power up procedure has completed.

    - safe_power_down_complete
        - Type: bool
        - Description: True if the safe power down procedure has completed.

    - auto_startup_complete
        - Type: bool
        - Description: True if the auto startup sequence has completed.

    - auto_shutdown_complete
        - Type: bool
        - Description: True if the auto shutdown sequence has completed.

    - current_low_level_master_gain
        - Type: float64
        - Description: The currently active master gain applied at the low-level controller.

    - joint_states
        - Type: OneDOFJointState[<=50]
        - Description: Array of state data for up to 50 joints.

    - number_of_joints
        - Type: uint32
        - Description: Number of valid entries in the joint_states array.

    - imu_states
        - Type: IMUState[<=50]
        - Description: Array of state data for up to 50 IMUs.

    - number_of_imus
        - Type: uint32
        - Description: Number of valid entries in the imu_states array.

    - ft_states
        - Type: ForceTorqueState[<=50]
        - Description: Array of state data for up to 50 force/torque sensors.

    - number_of_fts
        - Type: uint32
        - Description: Number of valid entries in the ft_states array.

---

- **ForceTorqueState** — Holds the current state of a force/torque sensor

    - sensor_name
        - Type: string<=32
        - Description: Name identifier for the force/torque sensor.

    - force
        - Type: float64[3]
        - Description: Measured force vector [x, y, z] in Newtons.

    - torque
        - Type: float64[3]
        - Description: Measured torque vector [x, y, z] in Newton-meters.

    - is_operational
        - Type: bool
        - Description: True if the sensor is functioning normally.

---

- **FortRoboticsRCHandheldState** — Holds the current state of a Fort Robotics RC handheld controller

    - left_joystick_x_normalized
        - Type: float64
        - Description: Normalized X-axis value of the left joystick, in range [-1.0, 1.0].

    - left_joystick_y_normalized
        - Type: float64
        - Description: Normalized Y-axis value of the left joystick, in range [-1.0, 1.0].

    - right_joystick_x_normalized
        - Type: float64
        - Description: Normalized X-axis value of the right joystick, in range [-1.0, 1.0].

    - right_joystick_y_normalized
        - Type: float64
        - Description: Normalized Y-axis value of the right joystick, in range [-1.0, 1.0].

    - left_trigger_normalized
        - Type: float64
        - Description: Normalized value of the left trigger, in range [-1.0, 1.0].

    - right_trigger_normalized
        - Type: float64
        - Description: Normalized value of the right trigger, in range [-1.0, 1.0].

    - button1_pressed
        - Type: bool
        - Description: True if button 1 (right side of controller) is pressed.

    - button2_pressed
        - Type: bool
        - Description: True if button 2 (right side of controller) is pressed.

    - button3_pressed
        - Type: bool
        - Description: True if button 3 (right side of controller) is pressed.

    - button4_pressed
        - Type: bool
        - Description: True if button 4 (right side of controller) is pressed.

    - button_up_pressed
        - Type: bool
        - Description: True if the D-pad up button is pressed.

    - button_down_pressed
        - Type: bool
        - Description: True if the D-pad down button is pressed.

    - button_left_pressed
        - Type: bool
        - Description: True if the D-pad left button is pressed.

    - button_right_pressed
        - Type: bool
        - Description: True if the D-pad right button is pressed.

    - e_stop_pressed
        - Type: bool
        - Description: True if the emergency stop button is pressed.

    - battery_level
        - Type: uint16
        - Description: Battery level of the handheld controller.

---

- **HardwareResources** — Designates the hardware resource files used to describe the robot

    - num_xml_resources
        - Type: uint32
        - Description: Number of XML resource files in the xml_resources list.

    - num_urdf_resources
        - Type: uint32
        - Description: Number of URDF resource files in the urdf_resources list.

    - xml_resources
        - Type: string<=32[11]
        - Description: List of individual XML files comprising the full XML description of the robot (max 11 entries).

    - urdf_resources
        - Type: string<=32[10]
        - Description: List of individual URDF files comprising the full URDF description of the robot (max 10 entries).

    - directory
        - Type: string<=32
        - Description: Directory containing the XML and URDF resources for the desired version of the robot.

---

- **HardwareStatus** — Holds hardware status and fault information for Alex

    - robot_fault
        - Type: bool
        - Description: True if a general robot-level fault is active.

    - motor_fault
        - Type: bool
        - Description: True if a motor fault is active.

    - missed_deadline_fault
        - Type: bool
        - Description: True if a missed control loop deadline fault is active.

    - working_counter_fault
        - Type: bool
        - Description: True if an EtherCAT working counter fault is active.

    - bus_over_voltage_fault
        - Type: bool
        - Description: True if a bus over-voltage fault is active.

    - bus_over_current_fault
        - Type: bool
        - Description: True if a bus over-current fault is active.

    - working_counter_mismatch_count
        - Type: uint32
        - Description: Cumulative count of EtherCAT working counter mismatches.

    - missed_deadlines
        - Type: uint32
        - Description: Cumulative count of missed control loop deadlines.

    - battery_charge_percentage
        - Type: float64
        - Description: Current battery charge as a percentage.

    - estimated_runtime_minutes
        - Type: float64
        - Description: Estimated remaining runtime in minutes based on current battery state.

    - bus_over_voltage_warning
        - Type: bool
        - Description: True if a bus over-voltage warning (non-fault) is active.

    - bus_over_current_warning
        - Type: bool
        - Description: True if a bus over-current warning (non-fault) is active.

    - battery_voltage_volts
        - Type: float64
        - Description: Current battery voltage in volts.

    - battery_current_amps
        - Type: float64
        - Description: Current battery draw in amps.

    - battery_power_watts
        - Type: float64
        - Description: Current battery power consumption in watts.

    - power_supply_voltage_volts
        - Type: float64
        - Description: Power supply voltage in volts.

    - power_supply_current_amps
        - Type: float64
        - Description: Power supply current in amps.

    - power_supply_power_watts
        - Type: float64
        - Description: Power supply power in watts.

    - motor_bus_voltage_volts
        - Type: float64
        - Description: Motor bus voltage in volts.

    - motor_bus_current_amps
        - Type: float64
        - Description: Motor bus current in amps.

    - motor_bus_power_watts
        - Type: float64
        - Description: Motor bus power consumption in watts.

    - device_status_providers
        - Type: ROSDeviceStatusProvider[<=75]
        - Description: Array of per-device status information for up to 75 devices.

---

- **IMUState** — Holds the current state of an IMU sensor

    - sensor_name
        - Type: string<=32
        - Description: Name identifier for the IMU sensor.

    - quaternion
        - Type: float64[4]
        - Description: Orientation expressed as a quaternion [x, y, z, w].

    - gyroscope
        - Type: float64[3]
        - Description: Angular velocity vector [x, y, z] in radians per second.

    - accelerometer
        - Type: float64[3]
        - Description: Linear acceleration vector [x, y, z] in meters per second squared.

    - temperature
        - Type: int32
        - Description: IMU sensor temperature in degrees Celsius.

    - is_operational
        - Type: bool
        - Description: True if the IMU is functioning normally.

---

- **OneDOFJointCommand** — Sets the desired commands for controlling a single 1-DOF joint

    - joint_name
        - Type: string<=35
        - Description: Name identifier for the joint being commanded.

    - q_des
        - Type: float64
        - Description: Desired joint position in radians.

    - qd_des
        - Type: float64
        - Description: Desired joint velocity in radians per second.

    - tau_des
        - Type: float64
        - Description: Desired joint torque in Newton-meters.

    - stiffness
        - Type: float64
        - Description: Proportional (position) gain for the joint controller.

    - damping
        - Type: float64
        - Description: Derivative (velocity) gain for the joint controller.

    - max_position_error
        - Type: float64
        - Description: Maximum allowable position error before a fault is triggered.

    - max_velocity_error
        - Type: float64
        - Description: Maximum allowable velocity error before a fault is triggered.

    - max_torque
        - Type: float64
        - Description: Maximum torque limit for the joint.

    - enable
        - Type: bool
        - Description: When true, enables the actuator for this joint.

    - joint_control_type
        - Type: byte
        - Description: Control mode for the joint: 0 = position, 1 = velocity, 2 = effort, 3 = disabled.

---

- **OneDOFJointState** — Holds state information for a single 1-DOF controlled joint

    - joint_name
        - Type: string<=35
        - Description: Name identifier for the joint.

    - q
        - Type: float64
        - Description: Current joint position in radians.

    - qd
        - Type: float64
        - Description: Current joint velocity in radians per second.

    - tau
        - Type: float64
        - Description: Current joint torque in Newton-meters.

    - act_temp
        - Type: float64
        - Description: Current actuator temperature in degrees Celsius.

    - is_operational
        - Type: bool
        - Description: True if the joint actuator is functioning normally.

---

- **ROSDeviceStatusProvider** — Holds status information for a single hardware device

    - name
        - Type: string<=70
        - Description: Name identifier for the device.

    - is_responding
        - Type: bool
        - Description: True if the device is actively responding on the bus.

    - is_faulted
        - Type: bool
        - Description: True if the device is in a faulted state.

    - ethercat_state
        - Type: byte
        - Description: Current EtherCAT state of the device.

    - under_voltage
        - Type: bool
        - Description: True if the device is reporting an under-voltage condition.

    - over_voltage
        - Type: bool
        - Description: True if the device is reporting an over-voltage condition.

    - sto_disabled
        - Type: bool
        - Description: True if the Safe Torque Off (STO) function is disabled on the device.

    - current_short
        - Type: bool
        - Description: True if the device is reporting a current short condition.

    - over_temp
        - Type: bool
        - Description: True if the device is reporting an over-temperature condition.
