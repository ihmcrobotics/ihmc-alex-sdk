package alex_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds hardware status info of Alex
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
   public boolean bus_over_voltage_fault_;
   public boolean bus_over_current_fault_;
   /**
            * Important EtherCAT Stuff
            */
   public long working_counter_mismatch_count_;
   public long missed_deadlines_;
   /**
            * Power Management Board Information
            */
   public double battery_charge_percentage_;
   public double estimated_runtime_minutes_;
   public boolean bus_over_voltage_warning_;
   public boolean bus_over_current_warning_;
   public double battery_voltage_volts_;
   public double battery_current_amps_;
   public double battery_power_watts_;
   public double power_supply_voltage_volts_;
   public double power_supply_current_amps_;
   public double power_supply_power_watts_;
   public double motor_bus_voltage_volts_;
   public double motor_bus_current_amps_;
   public double motor_bus_power_watts_;
   /**
            * Joint States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.ROSDeviceStatusProvider>  device_status_providers_;

   public HardwareStatus()
   {
      device_status_providers_ = new us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.ROSDeviceStatusProvider> (75, new alex_msgs.msg.dds.ROSDeviceStatusProviderPubSubType());

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

      bus_over_voltage_fault_ = other.bus_over_voltage_fault_;

      bus_over_current_fault_ = other.bus_over_current_fault_;

      working_counter_mismatch_count_ = other.working_counter_mismatch_count_;

      missed_deadlines_ = other.missed_deadlines_;

      battery_charge_percentage_ = other.battery_charge_percentage_;

      estimated_runtime_minutes_ = other.estimated_runtime_minutes_;

      bus_over_voltage_warning_ = other.bus_over_voltage_warning_;

      bus_over_current_warning_ = other.bus_over_current_warning_;

      battery_voltage_volts_ = other.battery_voltage_volts_;

      battery_current_amps_ = other.battery_current_amps_;

      battery_power_watts_ = other.battery_power_watts_;

      power_supply_voltage_volts_ = other.power_supply_voltage_volts_;

      power_supply_current_amps_ = other.power_supply_current_amps_;

      power_supply_power_watts_ = other.power_supply_power_watts_;

      motor_bus_voltage_volts_ = other.motor_bus_voltage_volts_;

      motor_bus_current_amps_ = other.motor_bus_current_amps_;

      motor_bus_power_watts_ = other.motor_bus_power_watts_;

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

   public void setBusOverVoltageFault(boolean bus_over_voltage_fault)
   {
      bus_over_voltage_fault_ = bus_over_voltage_fault;
   }
   public boolean getBusOverVoltageFault()
   {
      return bus_over_voltage_fault_;
   }

   public void setBusOverCurrentFault(boolean bus_over_current_fault)
   {
      bus_over_current_fault_ = bus_over_current_fault;
   }
   public boolean getBusOverCurrentFault()
   {
      return bus_over_current_fault_;
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
            * Power Management Board Information
            */
   public void setBatteryChargePercentage(double battery_charge_percentage)
   {
      battery_charge_percentage_ = battery_charge_percentage;
   }
   /**
            * Power Management Board Information
            */
   public double getBatteryChargePercentage()
   {
      return battery_charge_percentage_;
   }

   public void setEstimatedRuntimeMinutes(double estimated_runtime_minutes)
   {
      estimated_runtime_minutes_ = estimated_runtime_minutes;
   }
   public double getEstimatedRuntimeMinutes()
   {
      return estimated_runtime_minutes_;
   }

   public void setBusOverVoltageWarning(boolean bus_over_voltage_warning)
   {
      bus_over_voltage_warning_ = bus_over_voltage_warning;
   }
   public boolean getBusOverVoltageWarning()
   {
      return bus_over_voltage_warning_;
   }

   public void setBusOverCurrentWarning(boolean bus_over_current_warning)
   {
      bus_over_current_warning_ = bus_over_current_warning;
   }
   public boolean getBusOverCurrentWarning()
   {
      return bus_over_current_warning_;
   }

   public void setBatteryVoltageVolts(double battery_voltage_volts)
   {
      battery_voltage_volts_ = battery_voltage_volts;
   }
   public double getBatteryVoltageVolts()
   {
      return battery_voltage_volts_;
   }

   public void setBatteryCurrentAmps(double battery_current_amps)
   {
      battery_current_amps_ = battery_current_amps;
   }
   public double getBatteryCurrentAmps()
   {
      return battery_current_amps_;
   }

   public void setBatteryPowerWatts(double battery_power_watts)
   {
      battery_power_watts_ = battery_power_watts;
   }
   public double getBatteryPowerWatts()
   {
      return battery_power_watts_;
   }

   public void setPowerSupplyVoltageVolts(double power_supply_voltage_volts)
   {
      power_supply_voltage_volts_ = power_supply_voltage_volts;
   }
   public double getPowerSupplyVoltageVolts()
   {
      return power_supply_voltage_volts_;
   }

   public void setPowerSupplyCurrentAmps(double power_supply_current_amps)
   {
      power_supply_current_amps_ = power_supply_current_amps;
   }
   public double getPowerSupplyCurrentAmps()
   {
      return power_supply_current_amps_;
   }

   public void setPowerSupplyPowerWatts(double power_supply_power_watts)
   {
      power_supply_power_watts_ = power_supply_power_watts;
   }
   public double getPowerSupplyPowerWatts()
   {
      return power_supply_power_watts_;
   }

   public void setMotorBusVoltageVolts(double motor_bus_voltage_volts)
   {
      motor_bus_voltage_volts_ = motor_bus_voltage_volts;
   }
   public double getMotorBusVoltageVolts()
   {
      return motor_bus_voltage_volts_;
   }

   public void setMotorBusCurrentAmps(double motor_bus_current_amps)
   {
      motor_bus_current_amps_ = motor_bus_current_amps;
   }
   public double getMotorBusCurrentAmps()
   {
      return motor_bus_current_amps_;
   }

   public void setMotorBusPowerWatts(double motor_bus_power_watts)
   {
      motor_bus_power_watts_ = motor_bus_power_watts;
   }
   public double getMotorBusPowerWatts()
   {
      return motor_bus_power_watts_;
   }


   /**
            * Joint States
            */
   public us.ihmc.idl.IDLSequence.Object<alex_msgs.msg.dds.ROSDeviceStatusProvider>  getDeviceStatusProviders()
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bus_over_voltage_fault_, other.bus_over_voltage_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bus_over_current_fault_, other.bus_over_current_fault_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.working_counter_mismatch_count_, other.working_counter_mismatch_count_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.missed_deadlines_, other.missed_deadlines_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.battery_charge_percentage_, other.battery_charge_percentage_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.estimated_runtime_minutes_, other.estimated_runtime_minutes_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bus_over_voltage_warning_, other.bus_over_voltage_warning_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bus_over_current_warning_, other.bus_over_current_warning_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.battery_voltage_volts_, other.battery_voltage_volts_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.battery_current_amps_, other.battery_current_amps_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.battery_power_watts_, other.battery_power_watts_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.power_supply_voltage_volts_, other.power_supply_voltage_volts_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.power_supply_current_amps_, other.power_supply_current_amps_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.power_supply_power_watts_, other.power_supply_power_watts_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.motor_bus_voltage_volts_, other.motor_bus_voltage_volts_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.motor_bus_current_amps_, other.motor_bus_current_amps_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.motor_bus_power_watts_, other.motor_bus_power_watts_, epsilon)) return false;

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

      if(this.bus_over_voltage_fault_ != otherMyClass.bus_over_voltage_fault_) return false;

      if(this.bus_over_current_fault_ != otherMyClass.bus_over_current_fault_) return false;

      if(this.working_counter_mismatch_count_ != otherMyClass.working_counter_mismatch_count_) return false;

      if(this.missed_deadlines_ != otherMyClass.missed_deadlines_) return false;

      if(this.battery_charge_percentage_ != otherMyClass.battery_charge_percentage_) return false;

      if(this.estimated_runtime_minutes_ != otherMyClass.estimated_runtime_minutes_) return false;

      if(this.bus_over_voltage_warning_ != otherMyClass.bus_over_voltage_warning_) return false;

      if(this.bus_over_current_warning_ != otherMyClass.bus_over_current_warning_) return false;

      if(this.battery_voltage_volts_ != otherMyClass.battery_voltage_volts_) return false;

      if(this.battery_current_amps_ != otherMyClass.battery_current_amps_) return false;

      if(this.battery_power_watts_ != otherMyClass.battery_power_watts_) return false;

      if(this.power_supply_voltage_volts_ != otherMyClass.power_supply_voltage_volts_) return false;

      if(this.power_supply_current_amps_ != otherMyClass.power_supply_current_amps_) return false;

      if(this.power_supply_power_watts_ != otherMyClass.power_supply_power_watts_) return false;

      if(this.motor_bus_voltage_volts_ != otherMyClass.motor_bus_voltage_volts_) return false;

      if(this.motor_bus_current_amps_ != otherMyClass.motor_bus_current_amps_) return false;

      if(this.motor_bus_power_watts_ != otherMyClass.motor_bus_power_watts_) return false;

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
      builder.append("bus_over_voltage_fault=");
      builder.append(this.bus_over_voltage_fault_);      builder.append(", ");
      builder.append("bus_over_current_fault=");
      builder.append(this.bus_over_current_fault_);      builder.append(", ");
      builder.append("working_counter_mismatch_count=");
      builder.append(this.working_counter_mismatch_count_);      builder.append(", ");
      builder.append("missed_deadlines=");
      builder.append(this.missed_deadlines_);      builder.append(", ");
      builder.append("battery_charge_percentage=");
      builder.append(this.battery_charge_percentage_);      builder.append(", ");
      builder.append("estimated_runtime_minutes=");
      builder.append(this.estimated_runtime_minutes_);      builder.append(", ");
      builder.append("bus_over_voltage_warning=");
      builder.append(this.bus_over_voltage_warning_);      builder.append(", ");
      builder.append("bus_over_current_warning=");
      builder.append(this.bus_over_current_warning_);      builder.append(", ");
      builder.append("battery_voltage_volts=");
      builder.append(this.battery_voltage_volts_);      builder.append(", ");
      builder.append("battery_current_amps=");
      builder.append(this.battery_current_amps_);      builder.append(", ");
      builder.append("battery_power_watts=");
      builder.append(this.battery_power_watts_);      builder.append(", ");
      builder.append("power_supply_voltage_volts=");
      builder.append(this.power_supply_voltage_volts_);      builder.append(", ");
      builder.append("power_supply_current_amps=");
      builder.append(this.power_supply_current_amps_);      builder.append(", ");
      builder.append("power_supply_power_watts=");
      builder.append(this.power_supply_power_watts_);      builder.append(", ");
      builder.append("motor_bus_voltage_volts=");
      builder.append(this.motor_bus_voltage_volts_);      builder.append(", ");
      builder.append("motor_bus_current_amps=");
      builder.append(this.motor_bus_current_amps_);      builder.append(", ");
      builder.append("motor_bus_power_watts=");
      builder.append(this.motor_bus_power_watts_);      builder.append(", ");
      builder.append("device_status_providers=");
      builder.append(this.device_status_providers_);
      builder.append("}");
      return builder.toString();
   }
}
