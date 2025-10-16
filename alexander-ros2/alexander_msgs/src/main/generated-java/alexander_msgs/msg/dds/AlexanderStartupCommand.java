package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * High Level Commands for Starting Up/Shutting Down Alexander
       */
public class AlexanderStartupCommand extends Packet<AlexanderStartupCommand> implements Settable<AlexanderStartupCommand>, EpsilonComparable<AlexanderStartupCommand>
{
   public boolean enable_publishing_to_robot_;
   public boolean clear_faults_;
   public boolean calibrate_robot_;
   public boolean enable_actuators_;
   public boolean servo_robot_;
   public boolean unservo_quickly_;
   public boolean set_master_gain_;
   public double desired_master_gain_;

   public AlexanderStartupCommand()
   {
   }

   public AlexanderStartupCommand(AlexanderStartupCommand other)
   {
      this();
      set(other);
   }

   public void set(AlexanderStartupCommand other)
   {
      enable_publishing_to_robot_ = other.enable_publishing_to_robot_;

      clear_faults_ = other.clear_faults_;

      calibrate_robot_ = other.calibrate_robot_;

      enable_actuators_ = other.enable_actuators_;

      servo_robot_ = other.servo_robot_;

      unservo_quickly_ = other.unservo_quickly_;

      set_master_gain_ = other.set_master_gain_;

      desired_master_gain_ = other.desired_master_gain_;

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

   public void setCalibrateRobot(boolean calibrate_robot)
   {
      calibrate_robot_ = calibrate_robot;
   }
   public boolean getCalibrateRobot()
   {
      return calibrate_robot_;
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

   public void setSetMasterGain(boolean set_master_gain)
   {
      set_master_gain_ = set_master_gain;
   }
   public boolean getSetMasterGain()
   {
      return set_master_gain_;
   }

   public void setDesiredMasterGain(double desired_master_gain)
   {
      desired_master_gain_ = desired_master_gain;
   }
   public double getDesiredMasterGain()
   {
      return desired_master_gain_;
   }


   public static Supplier<AlexanderStartupCommandPubSubType> getPubSubType()
   {
      return AlexanderStartupCommandPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AlexanderStartupCommandPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AlexanderStartupCommand other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_publishing_to_robot_, other.enable_publishing_to_robot_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.clear_faults_, other.clear_faults_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.calibrate_robot_, other.calibrate_robot_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_actuators_, other.enable_actuators_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.servo_robot_, other.servo_robot_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.unservo_quickly_, other.unservo_quickly_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.set_master_gain_, other.set_master_gain_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.desired_master_gain_, other.desired_master_gain_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexanderStartupCommand)) return false;

      AlexanderStartupCommand otherMyClass = (AlexanderStartupCommand) other;

      if(this.enable_publishing_to_robot_ != otherMyClass.enable_publishing_to_robot_) return false;

      if(this.clear_faults_ != otherMyClass.clear_faults_) return false;

      if(this.calibrate_robot_ != otherMyClass.calibrate_robot_) return false;

      if(this.enable_actuators_ != otherMyClass.enable_actuators_) return false;

      if(this.servo_robot_ != otherMyClass.servo_robot_) return false;

      if(this.unservo_quickly_ != otherMyClass.unservo_quickly_) return false;

      if(this.set_master_gain_ != otherMyClass.set_master_gain_) return false;

      if(this.desired_master_gain_ != otherMyClass.desired_master_gain_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexanderStartupCommand {");
      builder.append("enable_publishing_to_robot=");
      builder.append(this.enable_publishing_to_robot_);      builder.append(", ");
      builder.append("clear_faults=");
      builder.append(this.clear_faults_);      builder.append(", ");
      builder.append("calibrate_robot=");
      builder.append(this.calibrate_robot_);      builder.append(", ");
      builder.append("enable_actuators=");
      builder.append(this.enable_actuators_);      builder.append(", ");
      builder.append("servo_robot=");
      builder.append(this.servo_robot_);      builder.append(", ");
      builder.append("unservo_quickly=");
      builder.append(this.unservo_quickly_);      builder.append(", ");
      builder.append("set_master_gain=");
      builder.append(this.set_master_gain_);      builder.append(", ");
      builder.append("desired_master_gain=");
      builder.append(this.desired_master_gain_);
      builder.append("}");
      return builder.toString();
   }
}
