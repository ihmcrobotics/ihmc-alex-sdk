package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * High Level Commands for Starting Up/Shutting Down Alexander
       */
public class AlexanderStartupStatus extends Packet<AlexanderStartupStatus> implements Settable<AlexanderStartupStatus>, EpsilonComparable<AlexanderStartupStatus>
{
   public boolean robot_is_faulted_;
   public boolean robot_is_servod_;
   public boolean robot_is_calibrated_;
   public boolean publishing_to_robot_is_enabled_;
   public boolean actuators_are_enabled_;
   public double current_master_gain_;

   public AlexanderStartupStatus()
   {
   }

   public AlexanderStartupStatus(AlexanderStartupStatus other)
   {
      this();
      set(other);
   }

   public void set(AlexanderStartupStatus other)
   {
      robot_is_faulted_ = other.robot_is_faulted_;

      robot_is_servod_ = other.robot_is_servod_;

      robot_is_calibrated_ = other.robot_is_calibrated_;

      publishing_to_robot_is_enabled_ = other.publishing_to_robot_is_enabled_;

      actuators_are_enabled_ = other.actuators_are_enabled_;

      current_master_gain_ = other.current_master_gain_;

   }

   public void setRobotIsFaulted(boolean robot_is_faulted)
   {
      robot_is_faulted_ = robot_is_faulted;
   }
   public boolean getRobotIsFaulted()
   {
      return robot_is_faulted_;
   }

   public void setRobotIsServod(boolean robot_is_servod)
   {
      robot_is_servod_ = robot_is_servod;
   }
   public boolean getRobotIsServod()
   {
      return robot_is_servod_;
   }

   public void setRobotIsCalibrated(boolean robot_is_calibrated)
   {
      robot_is_calibrated_ = robot_is_calibrated;
   }
   public boolean getRobotIsCalibrated()
   {
      return robot_is_calibrated_;
   }

   public void setPublishingToRobotIsEnabled(boolean publishing_to_robot_is_enabled)
   {
      publishing_to_robot_is_enabled_ = publishing_to_robot_is_enabled;
   }
   public boolean getPublishingToRobotIsEnabled()
   {
      return publishing_to_robot_is_enabled_;
   }

   public void setActuatorsAreEnabled(boolean actuators_are_enabled)
   {
      actuators_are_enabled_ = actuators_are_enabled;
   }
   public boolean getActuatorsAreEnabled()
   {
      return actuators_are_enabled_;
   }

   public void setCurrentMasterGain(double current_master_gain)
   {
      current_master_gain_ = current_master_gain;
   }
   public double getCurrentMasterGain()
   {
      return current_master_gain_;
   }


   public static Supplier<AlexanderStartupStatusPubSubType> getPubSubType()
   {
      return AlexanderStartupStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AlexanderStartupStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AlexanderStartupStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.robot_is_faulted_, other.robot_is_faulted_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.robot_is_servod_, other.robot_is_servod_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.robot_is_calibrated_, other.robot_is_calibrated_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.publishing_to_robot_is_enabled_, other.publishing_to_robot_is_enabled_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.actuators_are_enabled_, other.actuators_are_enabled_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.current_master_gain_, other.current_master_gain_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexanderStartupStatus)) return false;

      AlexanderStartupStatus otherMyClass = (AlexanderStartupStatus) other;

      if(this.robot_is_faulted_ != otherMyClass.robot_is_faulted_) return false;

      if(this.robot_is_servod_ != otherMyClass.robot_is_servod_) return false;

      if(this.robot_is_calibrated_ != otherMyClass.robot_is_calibrated_) return false;

      if(this.publishing_to_robot_is_enabled_ != otherMyClass.publishing_to_robot_is_enabled_) return false;

      if(this.actuators_are_enabled_ != otherMyClass.actuators_are_enabled_) return false;

      if(this.current_master_gain_ != otherMyClass.current_master_gain_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexanderStartupStatus {");
      builder.append("robot_is_faulted=");
      builder.append(this.robot_is_faulted_);      builder.append(", ");
      builder.append("robot_is_servod=");
      builder.append(this.robot_is_servod_);      builder.append(", ");
      builder.append("robot_is_calibrated=");
      builder.append(this.robot_is_calibrated_);      builder.append(", ");
      builder.append("publishing_to_robot_is_enabled=");
      builder.append(this.publishing_to_robot_is_enabled_);      builder.append(", ");
      builder.append("actuators_are_enabled=");
      builder.append(this.actuators_are_enabled_);      builder.append(", ");
      builder.append("current_master_gain=");
      builder.append(this.current_master_gain_);
      builder.append("}");
      return builder.toString();
   }
}
