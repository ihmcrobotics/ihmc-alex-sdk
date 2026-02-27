package alex_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds the current state of Alex
       */
public class AlexState extends Packet<AlexState> implements Settable<AlexState>, EpsilonComparable<AlexState>
{
   /**
            * General Status
            */
   public double time_;
   public boolean is_faulted_;
   public boolean is_calibrated_;
   public boolean are_actuators_enabled_;
   public boolean safe_power_up_complete_;
   public boolean safe_power_down_complete_;
   public double current_low_level_master_gain_;
   /**
            * Joint States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointState>  joint_states_;
   public long number_of_joints_;
   /**
            * IMU States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.IMUState>  imu_states_;
   public long number_of_imus_;
   /**
            * FT States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.ForceTorqueState>  ft_states_;
   public long number_of_fts_;

   public AlexState()
   {
      joint_states_ = new us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointState> (50, new alex_msgs.msg.dds.OneDOFJointStatePubSubType());
      imu_states_ = new us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.IMUState> (50, new alex_msgs.msg.dds.IMUStatePubSubType());
      ft_states_ = new us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.ForceTorqueState> (50, new alex_msgs.msg.dds.ForceTorqueStatePubSubType());

   }

   public AlexState(AlexState other)
   {
      this();
      set(other);
   }

   public void set(AlexState other)
   {
      time_ = other.time_;

      is_faulted_ = other.is_faulted_;

      is_calibrated_ = other.is_calibrated_;

      are_actuators_enabled_ = other.are_actuators_enabled_;

      safe_power_up_complete_ = other.safe_power_up_complete_;

      safe_power_down_complete_ = other.safe_power_down_complete_;

      current_low_level_master_gain_ = other.current_low_level_master_gain_;

      joint_states_.set(other.joint_states_);
      number_of_joints_ = other.number_of_joints_;

      imu_states_.set(other.imu_states_);
      number_of_imus_ = other.number_of_imus_;

      ft_states_.set(other.ft_states_);
      number_of_fts_ = other.number_of_fts_;

   }

   /**
            * General Status
            */
   public void setTime(double time)
   {
      time_ = time;
   }
   /**
            * General Status
            */
   public double getTime()
   {
      return time_;
   }

   public void setIsFaulted(boolean is_faulted)
   {
      is_faulted_ = is_faulted;
   }
   public boolean getIsFaulted()
   {
      return is_faulted_;
   }

   public void setIsCalibrated(boolean is_calibrated)
   {
      is_calibrated_ = is_calibrated;
   }
   public boolean getIsCalibrated()
   {
      return is_calibrated_;
   }

   public void setAreActuatorsEnabled(boolean are_actuators_enabled)
   {
      are_actuators_enabled_ = are_actuators_enabled;
   }
   public boolean getAreActuatorsEnabled()
   {
      return are_actuators_enabled_;
   }

   public void setSafePowerUpComplete(boolean safe_power_up_complete)
   {
      safe_power_up_complete_ = safe_power_up_complete;
   }
   public boolean getSafePowerUpComplete()
   {
      return safe_power_up_complete_;
   }

   public void setSafePowerDownComplete(boolean safe_power_down_complete)
   {
      safe_power_down_complete_ = safe_power_down_complete;
   }
   public boolean getSafePowerDownComplete()
   {
      return safe_power_down_complete_;
   }

   public void setCurrentLowLevelMasterGain(double current_low_level_master_gain)
   {
      current_low_level_master_gain_ = current_low_level_master_gain;
   }
   public double getCurrentLowLevelMasterGain()
   {
      return current_low_level_master_gain_;
   }


   /**
            * Joint States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.OneDOFJointState>  getJointStates()
   {
      return joint_states_;
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
            * IMU States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.IMUState>  getImuStates()
   {
      return imu_states_;
   }

   public void setNumberOfImus(long number_of_imus)
   {
      number_of_imus_ = number_of_imus;
   }
   public long getNumberOfImus()
   {
      return number_of_imus_;
   }


   /**
            * FT States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.ForceTorqueState>  getFtStates()
   {
      return ft_states_;
   }

   public void setNumberOfFts(long number_of_fts)
   {
      number_of_fts_ = number_of_fts;
   }
   public long getNumberOfFts()
   {
      return number_of_fts_;
   }


   public static Supplier<AlexStatePubSubType> getPubSubType()
   {
      return AlexStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AlexStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AlexState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.time_, other.time_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_faulted_, other.is_faulted_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_calibrated_, other.is_calibrated_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.are_actuators_enabled_, other.are_actuators_enabled_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.safe_power_up_complete_, other.safe_power_up_complete_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.safe_power_down_complete_, other.safe_power_down_complete_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.current_low_level_master_gain_, other.current_low_level_master_gain_, epsilon)) return false;

      if (this.joint_states_.size() != other.joint_states_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.joint_states_.size(); i++)
         {  if (!this.joint_states_.get(i).epsilonEquals(other.joint_states_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.number_of_joints_, other.number_of_joints_, epsilon)) return false;

      if (this.imu_states_.size() != other.imu_states_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.imu_states_.size(); i++)
         {  if (!this.imu_states_.get(i).epsilonEquals(other.imu_states_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.number_of_imus_, other.number_of_imus_, epsilon)) return false;

      if (this.ft_states_.size() != other.ft_states_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.ft_states_.size(); i++)
         {  if (!this.ft_states_.get(i).epsilonEquals(other.ft_states_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.number_of_fts_, other.number_of_fts_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexState)) return false;

      AlexState otherMyClass = (AlexState) other;

      if(this.time_ != otherMyClass.time_) return false;

      if(this.is_faulted_ != otherMyClass.is_faulted_) return false;

      if(this.is_calibrated_ != otherMyClass.is_calibrated_) return false;

      if(this.are_actuators_enabled_ != otherMyClass.are_actuators_enabled_) return false;

      if(this.safe_power_up_complete_ != otherMyClass.safe_power_up_complete_) return false;

      if(this.safe_power_down_complete_ != otherMyClass.safe_power_down_complete_) return false;

      if(this.current_low_level_master_gain_ != otherMyClass.current_low_level_master_gain_) return false;

      if (!this.joint_states_.equals(otherMyClass.joint_states_)) return false;
      if(this.number_of_joints_ != otherMyClass.number_of_joints_) return false;

      if (!this.imu_states_.equals(otherMyClass.imu_states_)) return false;
      if(this.number_of_imus_ != otherMyClass.number_of_imus_) return false;

      if (!this.ft_states_.equals(otherMyClass.ft_states_)) return false;
      if(this.number_of_fts_ != otherMyClass.number_of_fts_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexState {");
      builder.append("time=");
      builder.append(this.time_);      builder.append(", ");
      builder.append("is_faulted=");
      builder.append(this.is_faulted_);      builder.append(", ");
      builder.append("is_calibrated=");
      builder.append(this.is_calibrated_);      builder.append(", ");
      builder.append("are_actuators_enabled=");
      builder.append(this.are_actuators_enabled_);      builder.append(", ");
      builder.append("safe_power_up_complete=");
      builder.append(this.safe_power_up_complete_);      builder.append(", ");
      builder.append("safe_power_down_complete=");
      builder.append(this.safe_power_down_complete_);      builder.append(", ");
      builder.append("current_low_level_master_gain=");
      builder.append(this.current_low_level_master_gain_);      builder.append(", ");
      builder.append("joint_states=");
      builder.append(this.joint_states_);      builder.append(", ");
      builder.append("number_of_joints=");
      builder.append(this.number_of_joints_);      builder.append(", ");
      builder.append("imu_states=");
      builder.append(this.imu_states_);      builder.append(", ");
      builder.append("number_of_imus=");
      builder.append(this.number_of_imus_);      builder.append(", ");
      builder.append("ft_states=");
      builder.append(this.ft_states_);      builder.append(", ");
      builder.append("number_of_fts=");
      builder.append(this.number_of_fts_);
      builder.append("}");
      return builder.toString();
   }
}
