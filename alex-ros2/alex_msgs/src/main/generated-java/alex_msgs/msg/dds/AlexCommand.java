package alex_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds desired control commands for Alex
       */
public class AlexCommand extends Packet<AlexCommand> implements Settable<AlexCommand>, EpsilonComparable<AlexCommand>
{
   /**
            * Requests auto startup, which: requests safe power up, clears faults, enables actuators, and sets robot_control_state to user
            */
   public boolean request_auto_startup_;
   /**
            * Requests auto shutdown, which: disables actuators and requests safe power down
            */
   public boolean request_auto_shutdown_;
   /**
            * Requests for safe power up and power down procedures for PMB
            */
   public boolean request_safe_power_up_;
   public boolean request_safe_power_down_;
   /**
            * Other individual controls for robot startup procedure
            */
   public boolean request_enable_actuators_;
   public boolean request_disable_actuators_;
   public boolean clear_faults_;
   public boolean calibrate_;
   public boolean servo_actuators_;
   public boolean unservo_quickly_;
   public boolean use_requested_master_gain_;
   public double requested_master_gain_;
   /**
            * Option to disable non-critical faults
            */
   public boolean disable_noncritical_faults_;
   /**
            * Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
            */
   public byte robot_control_state_;
   /**
            * Joint Commands for the robot
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointCommand>  joint_commands_;
   public long number_of_joints_;

   public AlexCommand()
   {
      joint_commands_ = new us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointCommand> (50, new alex_msgs.msg.dds.OneDOFJointCommandPubSubType());

   }

   public AlexCommand(AlexCommand other)
   {
      this();
      set(other);
   }

   public void set(AlexCommand other)
   {
      request_auto_startup_ = other.request_auto_startup_;

      request_auto_shutdown_ = other.request_auto_shutdown_;

      request_safe_power_up_ = other.request_safe_power_up_;

      request_safe_power_down_ = other.request_safe_power_down_;

      request_enable_actuators_ = other.request_enable_actuators_;

      request_disable_actuators_ = other.request_disable_actuators_;

      clear_faults_ = other.clear_faults_;

      calibrate_ = other.calibrate_;

      servo_actuators_ = other.servo_actuators_;

      unservo_quickly_ = other.unservo_quickly_;

      use_requested_master_gain_ = other.use_requested_master_gain_;

      requested_master_gain_ = other.requested_master_gain_;

      disable_noncritical_faults_ = other.disable_noncritical_faults_;

      robot_control_state_ = other.robot_control_state_;

      joint_commands_.set(other.joint_commands_);
      number_of_joints_ = other.number_of_joints_;

   }

   /**
            * Requests auto startup, which: requests safe power up, clears faults, enables actuators, and sets robot_control_state to user
            */
   public void setRequestAutoStartup(boolean request_auto_startup)
   {
      request_auto_startup_ = request_auto_startup;
   }
   /**
            * Requests auto startup, which: requests safe power up, clears faults, enables actuators, and sets robot_control_state to user
            */
   public boolean getRequestAutoStartup()
   {
      return request_auto_startup_;
   }

   /**
            * Requests auto shutdown, which: disables actuators and requests safe power down
            */
   public void setRequestAutoShutdown(boolean request_auto_shutdown)
   {
      request_auto_shutdown_ = request_auto_shutdown;
   }
   /**
            * Requests auto shutdown, which: disables actuators and requests safe power down
            */
   public boolean getRequestAutoShutdown()
   {
      return request_auto_shutdown_;
   }

   /**
            * Requests for safe power up and power down procedures for PMB
            */
   public void setRequestSafePowerUp(boolean request_safe_power_up)
   {
      request_safe_power_up_ = request_safe_power_up;
   }
   /**
            * Requests for safe power up and power down procedures for PMB
            */
   public boolean getRequestSafePowerUp()
   {
      return request_safe_power_up_;
   }

   public void setRequestSafePowerDown(boolean request_safe_power_down)
   {
      request_safe_power_down_ = request_safe_power_down;
   }
   public boolean getRequestSafePowerDown()
   {
      return request_safe_power_down_;
   }

   /**
            * Other individual controls for robot startup procedure
            */
   public void setRequestEnableActuators(boolean request_enable_actuators)
   {
      request_enable_actuators_ = request_enable_actuators;
   }
   /**
            * Other individual controls for robot startup procedure
            */
   public boolean getRequestEnableActuators()
   {
      return request_enable_actuators_;
   }

   public void setRequestDisableActuators(boolean request_disable_actuators)
   {
      request_disable_actuators_ = request_disable_actuators;
   }
   public boolean getRequestDisableActuators()
   {
      return request_disable_actuators_;
   }

   public void setClearFaults(boolean clear_faults)
   {
      clear_faults_ = clear_faults;
   }
   public boolean getClearFaults()
   {
      return clear_faults_;
   }

   public void setCalibrate(boolean calibrate)
   {
      calibrate_ = calibrate;
   }
   public boolean getCalibrate()
   {
      return calibrate_;
   }

   public void setServoActuators(boolean servo_actuators)
   {
      servo_actuators_ = servo_actuators;
   }
   public boolean getServoActuators()
   {
      return servo_actuators_;
   }

   public void setUnservoQuickly(boolean unservo_quickly)
   {
      unservo_quickly_ = unservo_quickly;
   }
   public boolean getUnservoQuickly()
   {
      return unservo_quickly_;
   }

   public void setUseRequestedMasterGain(boolean use_requested_master_gain)
   {
      use_requested_master_gain_ = use_requested_master_gain;
   }
   public boolean getUseRequestedMasterGain()
   {
      return use_requested_master_gain_;
   }

   public void setRequestedMasterGain(double requested_master_gain)
   {
      requested_master_gain_ = requested_master_gain;
   }
   public double getRequestedMasterGain()
   {
      return requested_master_gain_;
   }

   /**
            * Option to disable non-critical faults
            */
   public void setDisableNoncriticalFaults(boolean disable_noncritical_faults)
   {
      disable_noncritical_faults_ = disable_noncritical_faults;
   }
   /**
            * Option to disable non-critical faults
            */
   public boolean getDisableNoncriticalFaults()
   {
      return disable_noncritical_faults_;
   }

   /**
            * Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
            */
   public void setRobotControlState(byte robot_control_state)
   {
      robot_control_state_ = robot_control_state;
   }
   /**
            * Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
            */
   public byte getRobotControlState()
   {
      return robot_control_state_;
   }


   /**
            * Joint Commands for the robot
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointCommand>  getJointCommands()
   {
      return joint_commands_;
   }

   public void setNumberOfJoints(long number_of_joints)
   {
      number_of_joints_ = number_of_joints;
   }
   public long getNumberOfJoints()
   {
      return number_of_joints_;
   }


   public static Supplier<AlexCommandPubSubType> getPubSubType()
   {
      return AlexCommandPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AlexCommandPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AlexCommand other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.request_auto_startup_, other.request_auto_startup_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.request_auto_shutdown_, other.request_auto_shutdown_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.request_safe_power_up_, other.request_safe_power_up_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.request_safe_power_down_, other.request_safe_power_down_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.request_enable_actuators_, other.request_enable_actuators_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.request_disable_actuators_, other.request_disable_actuators_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.clear_faults_, other.clear_faults_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.calibrate_, other.calibrate_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.servo_actuators_, other.servo_actuators_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.unservo_quickly_, other.unservo_quickly_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.use_requested_master_gain_, other.use_requested_master_gain_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.requested_master_gain_, other.requested_master_gain_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.disable_noncritical_faults_, other.disable_noncritical_faults_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.robot_control_state_, other.robot_control_state_, epsilon)) return false;

      if (this.joint_commands_.size() != other.joint_commands_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.joint_commands_.size(); i++)
         {  if (!this.joint_commands_.get(i).epsilonEquals(other.joint_commands_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.number_of_joints_, other.number_of_joints_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexCommand)) return false;

      AlexCommand otherMyClass = (AlexCommand) other;

      if(this.request_auto_startup_ != otherMyClass.request_auto_startup_) return false;

      if(this.request_auto_shutdown_ != otherMyClass.request_auto_shutdown_) return false;

      if(this.request_safe_power_up_ != otherMyClass.request_safe_power_up_) return false;

      if(this.request_safe_power_down_ != otherMyClass.request_safe_power_down_) return false;

      if(this.request_enable_actuators_ != otherMyClass.request_enable_actuators_) return false;

      if(this.request_disable_actuators_ != otherMyClass.request_disable_actuators_) return false;

      if(this.clear_faults_ != otherMyClass.clear_faults_) return false;

      if(this.calibrate_ != otherMyClass.calibrate_) return false;

      if(this.servo_actuators_ != otherMyClass.servo_actuators_) return false;

      if(this.unservo_quickly_ != otherMyClass.unservo_quickly_) return false;

      if(this.use_requested_master_gain_ != otherMyClass.use_requested_master_gain_) return false;

      if(this.requested_master_gain_ != otherMyClass.requested_master_gain_) return false;

      if(this.disable_noncritical_faults_ != otherMyClass.disable_noncritical_faults_) return false;

      if(this.robot_control_state_ != otherMyClass.robot_control_state_) return false;

      if (!this.joint_commands_.equals(otherMyClass.joint_commands_)) return false;
      if(this.number_of_joints_ != otherMyClass.number_of_joints_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexCommand {");
      builder.append("request_auto_startup=");
      builder.append(this.request_auto_startup_);      builder.append(", ");
      builder.append("request_auto_shutdown=");
      builder.append(this.request_auto_shutdown_);      builder.append(", ");
      builder.append("request_safe_power_up=");
      builder.append(this.request_safe_power_up_);      builder.append(", ");
      builder.append("request_safe_power_down=");
      builder.append(this.request_safe_power_down_);      builder.append(", ");
      builder.append("request_enable_actuators=");
      builder.append(this.request_enable_actuators_);      builder.append(", ");
      builder.append("request_disable_actuators=");
      builder.append(this.request_disable_actuators_);      builder.append(", ");
      builder.append("clear_faults=");
      builder.append(this.clear_faults_);      builder.append(", ");
      builder.append("calibrate=");
      builder.append(this.calibrate_);      builder.append(", ");
      builder.append("servo_actuators=");
      builder.append(this.servo_actuators_);      builder.append(", ");
      builder.append("unservo_quickly=");
      builder.append(this.unservo_quickly_);      builder.append(", ");
      builder.append("use_requested_master_gain=");
      builder.append(this.use_requested_master_gain_);      builder.append(", ");
      builder.append("requested_master_gain=");
      builder.append(this.requested_master_gain_);      builder.append(", ");
      builder.append("disable_noncritical_faults=");
      builder.append(this.disable_noncritical_faults_);      builder.append(", ");
      builder.append("robot_control_state=");
      builder.append(this.robot_control_state_);      builder.append(", ");
      builder.append("joint_commands=");
      builder.append(this.joint_commands_);      builder.append(", ");
      builder.append("number_of_joints=");
      builder.append(this.number_of_joints_);
      builder.append("}");
      return builder.toString();
   }
}
