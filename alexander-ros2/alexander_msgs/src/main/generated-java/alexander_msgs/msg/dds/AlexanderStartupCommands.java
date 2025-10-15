package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * High Level Commands for Starting Up/Shutting Down Alexander
       */
public class AlexanderStartupCommands extends Packet<AlexanderStartupCommands> implements Settable<AlexanderStartupCommands>, EpsilonComparable<AlexanderStartupCommands>
{
   public boolean enable_publishing_to_robot_;
   public boolean clear_faults_;
   public boolean enable_user_control_mode_;
   public boolean enable_actuators_;
   public boolean servo_robot_;
   public boolean unservo_quickly_;
   public double master_gain_;

   public AlexanderStartupCommands()
   {
   }

   public AlexanderStartupCommands(AlexanderStartupCommands other)
   {
      this();
      set(other);
   }

   public void set(AlexanderStartupCommands other)
   {
      enable_publishing_to_robot_ = other.enable_publishing_to_robot_;

      clear_faults_ = other.clear_faults_;

      enable_user_control_mode_ = other.enable_user_control_mode_;

      enable_actuators_ = other.enable_actuators_;

      servo_robot_ = other.servo_robot_;

      unservo_quickly_ = other.unservo_quickly_;

      master_gain_ = other.master_gain_;

   }

   public void setEnablePublishingToRobot(boolean enable_publishing_to_robot)
   {
      enable_publishing_to_robot_ = enable_publishing_to_robot;
   }
   public boolean getEnablePublishingToRobot()
   {
      return enable_publishing_to_robot_;
   }

   public void setClearFaults(boolean clear_faults)
   {
      clear_faults_ = clear_faults;
   }
   public boolean getClearFaults()
   {
      return clear_faults_;
   }

   public void setEnableUserControlMode(boolean enable_user_control_mode)
   {
      enable_user_control_mode_ = enable_user_control_mode;
   }
   public boolean getEnableUserControlMode()
   {
      return enable_user_control_mode_;
   }

   public void setEnableActuators(boolean enable_actuators)
   {
      enable_actuators_ = enable_actuators;
   }
   public boolean getEnableActuators()
   {
      return enable_actuators_;
   }

   public void setServoRobot(boolean servo_robot)
   {
      servo_robot_ = servo_robot;
   }
   public boolean getServoRobot()
   {
      return servo_robot_;
   }

   public void setUnservoQuickly(boolean unservo_quickly)
   {
      unservo_quickly_ = unservo_quickly;
   }
   public boolean getUnservoQuickly()
   {
      return unservo_quickly_;
   }

   public void setMasterGain(double master_gain)
   {
      master_gain_ = master_gain;
   }
   public double getMasterGain()
   {
      return master_gain_;
   }


   public static Supplier<AlexanderStartupCommandsPubSubType> getPubSubType()
   {
      return AlexanderStartupCommandsPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AlexanderStartupCommandsPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AlexanderStartupCommands other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_publishing_to_robot_, other.enable_publishing_to_robot_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.clear_faults_, other.clear_faults_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_user_control_mode_, other.enable_user_control_mode_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_actuators_, other.enable_actuators_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.servo_robot_, other.servo_robot_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.unservo_quickly_, other.unservo_quickly_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.master_gain_, other.master_gain_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexanderStartupCommands)) return false;

      AlexanderStartupCommands otherMyClass = (AlexanderStartupCommands) other;

      if(this.enable_publishing_to_robot_ != otherMyClass.enable_publishing_to_robot_) return false;

      if(this.clear_faults_ != otherMyClass.clear_faults_) return false;

      if(this.enable_user_control_mode_ != otherMyClass.enable_user_control_mode_) return false;

      if(this.enable_actuators_ != otherMyClass.enable_actuators_) return false;

      if(this.servo_robot_ != otherMyClass.servo_robot_) return false;

      if(this.unservo_quickly_ != otherMyClass.unservo_quickly_) return false;

      if(this.master_gain_ != otherMyClass.master_gain_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexanderStartupCommands {");
      builder.append("enable_publishing_to_robot=");
      builder.append(this.enable_publishing_to_robot_);      builder.append(", ");
      builder.append("clear_faults=");
      builder.append(this.clear_faults_);      builder.append(", ");
      builder.append("enable_user_control_mode=");
      builder.append(this.enable_user_control_mode_);      builder.append(", ");
      builder.append("enable_actuators=");
      builder.append(this.enable_actuators_);      builder.append(", ");
      builder.append("servo_robot=");
      builder.append(this.servo_robot_);      builder.append(", ");
      builder.append("unservo_quickly=");
      builder.append(this.unservo_quickly_);      builder.append(", ");
      builder.append("master_gain=");
      builder.append(this.master_gain_);
      builder.append("}");
      return builder.toString();
   }
}
