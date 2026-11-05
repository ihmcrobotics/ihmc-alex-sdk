package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class AlexanderStatus extends Packet<AlexanderStatus> implements Settable<AlexanderStatus>, EpsilonComparable<AlexanderStatus>
{
   public double time_;
   public boolean motors_enabled_;
   public boolean is_faulted_;
   public boolean working_counter_fault_;
   public boolean missed_deadline_fault_;
   public boolean motor_fault_;
   public us.ihmc.idl.IDLSequence.Object<alexander_msgs.msg.dds.ECATDeviceStatus>  device_statuses_;

   public AlexanderStatus()
   {
      device_statuses_ = new us.ihmc.idl.IDLSequence.Object<alexander_msgs.msg.dds.ECATDeviceStatus> (100, new alexander_msgs.msg.dds.ECATDeviceStatusPubSubType());

   }

   public AlexanderStatus(AlexanderStatus other)
   {
      this();
      set(other);
   }

   public void set(AlexanderStatus other)
   {
      time_ = other.time_;

      motors_enabled_ = other.motors_enabled_;

      is_faulted_ = other.is_faulted_;

      working_counter_fault_ = other.working_counter_fault_;

      missed_deadline_fault_ = other.missed_deadline_fault_;

      motor_fault_ = other.motor_fault_;

      device_statuses_.set(other.device_statuses_);
   }

   public void setTime(double time)
   {
      time_ = time;
   }
   public double getTime()
   {
      return time_;
   }

   public void setMotorsEnabled(boolean motors_enabled)
   {
      motors_enabled_ = motors_enabled;
   }
   public boolean getMotorsEnabled()
   {
      return motors_enabled_;
   }

   public void setIsFaulted(boolean is_faulted)
   {
      is_faulted_ = is_faulted;
   }
   public boolean getIsFaulted()
   {
      return is_faulted_;
   }

   public void setWorkingCounterFault(boolean working_counter_fault)
   {
      working_counter_fault_ = working_counter_fault;
   }
   public boolean getWorkingCounterFault()
   {
      return working_counter_fault_;
   }

   public void setMissedDeadlineFault(boolean missed_deadline_fault)
   {
      missed_deadline_fault_ = missed_deadline_fault;
   }
   public boolean getMissedDeadlineFault()
   {
      return missed_deadline_fault_;
   }

   public void setMotorFault(boolean motor_fault)
   {
      motor_fault_ = motor_fault;
   }
   public boolean getMotorFault()
   {
      return motor_fault_;
   }


   public us.ihmc.idl.IDLSequence.Object<alexander_msgs.msg.dds.ECATDeviceStatus>  getDeviceStatuses()
   {
      return device_statuses_;
   }


   public static Supplier<AlexanderStatusPubSubType> getPubSubType()
   {
      return AlexanderStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return AlexanderStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(AlexanderStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.time_, other.time_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.motors_enabled_, other.motors_enabled_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_faulted_, other.is_faulted_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.working_counter_fault_, other.working_counter_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.missed_deadline_fault_, other.missed_deadline_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.motor_fault_, other.motor_fault_, epsilon)) return false;

      if (this.device_statuses_.size() != other.device_statuses_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.device_statuses_.size(); i++)
         {  if (!this.device_statuses_.get(i).epsilonEquals(other.device_statuses_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof AlexanderStatus)) return false;

      AlexanderStatus otherMyClass = (AlexanderStatus) other;

      if(this.time_ != otherMyClass.time_) return false;

      if(this.motors_enabled_ != otherMyClass.motors_enabled_) return false;

      if(this.is_faulted_ != otherMyClass.is_faulted_) return false;

      if(this.working_counter_fault_ != otherMyClass.working_counter_fault_) return false;

      if(this.missed_deadline_fault_ != otherMyClass.missed_deadline_fault_) return false;

      if(this.motor_fault_ != otherMyClass.motor_fault_) return false;

      if (!this.device_statuses_.equals(otherMyClass.device_statuses_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("AlexanderStatus {");
      builder.append("time=");
      builder.append(this.time_);      builder.append(", ");
      builder.append("motors_enabled=");
      builder.append(this.motors_enabled_);      builder.append(", ");
      builder.append("is_faulted=");
      builder.append(this.is_faulted_);      builder.append(", ");
      builder.append("working_counter_fault=");
      builder.append(this.working_counter_fault_);      builder.append(", ");
      builder.append("missed_deadline_fault=");
      builder.append(this.missed_deadline_fault_);      builder.append(", ");
      builder.append("motor_fault=");
      builder.append(this.motor_fault_);      builder.append(", ");
      builder.append("device_statuses=");
      builder.append(this.device_statuses_);
      builder.append("}");
      return builder.toString();
   }
}
