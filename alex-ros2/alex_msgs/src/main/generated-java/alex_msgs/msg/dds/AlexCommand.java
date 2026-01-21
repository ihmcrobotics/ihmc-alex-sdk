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
            * Operational commands of the robot
            */
   public boolean enable_actuators_;
   public boolean clear_faults_;
   public boolean calibrate_;
   /**
            * Control state of the robot, 0 is do nothing, 1 is hold position, 2 is user control
            */
   public byte robot_control_state_;
   public long number_of_joints_;
   /**
            * Joint Commands for the robot
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointCommand>  joint_commands_;
   public double low_level_master_gain_;

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
      enable_actuators_ = other.enable_actuators_;

      clear_faults_ = other.clear_faults_;

      calibrate_ = other.calibrate_;

      robot_control_state_ = other.robot_control_state_;

      number_of_joints_ = other.number_of_joints_;

      joint_commands_.set(other.joint_commands_);
      low_level_master_gain_ = other.low_level_master_gain_;

   }

   /**
            * Operational commands of the robot
            */
   public void setEnableActuators(boolean enable_actuators)
   {
      enable_actuators_ = enable_actuators;
   }
   /**
            * Operational commands of the robot
            */
   public boolean getEnableActuators()
   {
      return enable_actuators_;
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

   public void setNumberOfJoints(long number_of_joints)
   {
      number_of_joints_ = number_of_joints;
   }
   public long getNumberOfJoints()
   {
      return number_of_joints_;
   }


   /**
            * Joint Commands for the robot
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointCommand>  getJointCommands()
   {
      return joint_commands_;
   }

   public void setLowLevelMasterGain(double low_level_master_gain)
   {
      low_level_master_gain_ = low_level_master_gain;
   }
   public double getLowLevelMasterGain()
   {
      return low_level_master_gain_;
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_actuators_, other.enable_actuators_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.clear_faults_, other.clear_faults_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.calibrate_, other.calibrate_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.robot_control_state_, other.robot_control_state_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.number_of_joints_, other.number_of_joints_, epsilon)) return false;

      if (this.joint_commands_.size() != other.joint_commands_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.joint_commands_.size(); i++)
         {  if (!this.joint_commands_.get(i).epsilonEquals(other.joint_commands_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.low_level_master_gain_, other.low_level_master_gain_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexCommand)) return false;

      AlexCommand otherMyClass = (AlexCommand) other;

      if(this.enable_actuators_ != otherMyClass.enable_actuators_) return false;

      if(this.clear_faults_ != otherMyClass.clear_faults_) return false;

      if(this.calibrate_ != otherMyClass.calibrate_) return false;

      if(this.robot_control_state_ != otherMyClass.robot_control_state_) return false;

      if(this.number_of_joints_ != otherMyClass.number_of_joints_) return false;

      if (!this.joint_commands_.equals(otherMyClass.joint_commands_)) return false;
      if(this.low_level_master_gain_ != otherMyClass.low_level_master_gain_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexCommand {");
      builder.append("enable_actuators=");
      builder.append(this.enable_actuators_);      builder.append(", ");
      builder.append("clear_faults=");
      builder.append(this.clear_faults_);      builder.append(", ");
      builder.append("calibrate=");
      builder.append(this.calibrate_);      builder.append(", ");
      builder.append("robot_control_state=");
      builder.append(this.robot_control_state_);      builder.append(", ");
      builder.append("number_of_joints=");
      builder.append(this.number_of_joints_);      builder.append(", ");
      builder.append("joint_commands=");
      builder.append(this.joint_commands_);      builder.append(", ");
      builder.append("low_level_master_gain=");
      builder.append(this.low_level_master_gain_);
      builder.append("}");
      return builder.toString();
   }
}
