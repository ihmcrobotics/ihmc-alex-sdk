package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds hardware status info of Alexander
       */
public class HardwareStatus extends Packet<HardwareStatus> implements Settable<HardwareStatus>, EpsilonComparable<HardwareStatus>
{
   /**
            * Various fault info
            */
   public boolean robot_fault_;
   public boolean motor_fault_;
   public boolean missed_deadline_fault_;
   public boolean working_counter_fault_;
   /**
            * Important EtherCAT Stuff
            */
   public long working_counter_mismatch_count_;
   public long missed_deadlines_;
   /**
            * Joint States
            */
   public us.ihmc.idl.IDLSequence.Object<alexander_msgs.msg.dds.ROSDeviceStatusProvider>  device_status_providers_;

   public HardwareStatus()
   {
      device_status_providers_ = new us.ihmc.idl.IDLSequence.Object<alexander_msgs.msg.dds.ROSDeviceStatusProvider> (75, new alexander_msgs.msg.dds.ROSDeviceStatusProviderPubSubType());

   }

   public HardwareStatus(HardwareStatus other)
   {
      this();
      set(other);
   }

   public void set(HardwareStatus other)
   {
      robot_fault_ = other.robot_fault_;

      motor_fault_ = other.motor_fault_;

      missed_deadline_fault_ = other.missed_deadline_fault_;

      working_counter_fault_ = other.working_counter_fault_;

      working_counter_mismatch_count_ = other.working_counter_mismatch_count_;

      missed_deadlines_ = other.missed_deadlines_;

      device_status_providers_.set(other.device_status_providers_);
   }

   /**
            * Various fault info
            */
   public void setRobotFault(boolean robot_fault)
   {
      robot_fault_ = robot_fault;
   }
   /**
            * Various fault info
            */
   public boolean getRobotFault()
   {
      return robot_fault_;
   }

   public void setMotorFault(boolean motor_fault)
   {
      motor_fault_ = motor_fault;
   }
   public boolean getMotorFault()
   {
      return motor_fault_;
   }

   public void setMissedDeadlineFault(boolean missed_deadline_fault)
   {
      missed_deadline_fault_ = missed_deadline_fault;
   }
   public boolean getMissedDeadlineFault()
   {
      return missed_deadline_fault_;
   }

   public void setWorkingCounterFault(boolean working_counter_fault)
   {
      working_counter_fault_ = working_counter_fault;
   }
   public boolean getWorkingCounterFault()
   {
      return working_counter_fault_;
   }

   /**
            * Important EtherCAT Stuff
            */
   public void setWorkingCounterMismatchCount(long working_counter_mismatch_count)
   {
      working_counter_mismatch_count_ = working_counter_mismatch_count;
   }
   /**
            * Important EtherCAT Stuff
            */
   public long getWorkingCounterMismatchCount()
   {
      return working_counter_mismatch_count_;
   }

   public void setMissedDeadlines(long missed_deadlines)
   {
      missed_deadlines_ = missed_deadlines;
   }
   public long getMissedDeadlines()
   {
      return missed_deadlines_;
   }


   /**
            * Joint States
            */
   public us.ihmc.idl.IDLSequence.Object<alexander_msgs.msg.dds.ROSDeviceStatusProvider>  getDeviceStatusProviders()
   {
      return device_status_providers_;
   }


   public static Supplier<HardwareStatusPubSubType> getPubSubType()
   {
      return HardwareStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return HardwareStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(HardwareStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.robot_fault_, other.robot_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.motor_fault_, other.motor_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.missed_deadline_fault_, other.missed_deadline_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.working_counter_fault_, other.working_counter_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.working_counter_mismatch_count_, other.working_counter_mismatch_count_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.missed_deadlines_, other.missed_deadlines_, epsilon)) return false;

      if (this.device_status_providers_.size() != other.device_status_providers_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.device_status_providers_.size(); i++)
         {  if (!this.device_status_providers_.get(i).epsilonEquals(other.device_status_providers_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof HardwareStatus)) return false;

      HardwareStatus otherMyClass = (HardwareStatus) other;

      if(this.robot_fault_ != otherMyClass.robot_fault_) return false;

      if(this.motor_fault_ != otherMyClass.motor_fault_) return false;

      if(this.missed_deadline_fault_ != otherMyClass.missed_deadline_fault_) return false;

      if(this.working_counter_fault_ != otherMyClass.working_counter_fault_) return false;

      if(this.working_counter_mismatch_count_ != otherMyClass.working_counter_mismatch_count_) return false;

      if(this.missed_deadlines_ != otherMyClass.missed_deadlines_) return false;

      if (!this.device_status_providers_.equals(otherMyClass.device_status_providers_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("HardwareStatus {");
      builder.append("robot_fault=");
      builder.append(this.robot_fault_);      builder.append(", ");
      builder.append("motor_fault=");
      builder.append(this.motor_fault_);      builder.append(", ");
      builder.append("missed_deadline_fault=");
      builder.append(this.missed_deadline_fault_);      builder.append(", ");
      builder.append("working_counter_fault=");
      builder.append(this.working_counter_fault_);      builder.append(", ");
      builder.append("working_counter_mismatch_count=");
      builder.append(this.working_counter_mismatch_count_);      builder.append(", ");
      builder.append("missed_deadlines=");
      builder.append(this.missed_deadlines_);      builder.append(", ");
      builder.append("device_status_providers=");
      builder.append(this.device_status_providers_);
      builder.append("}");
      return builder.toString();
   }
}
