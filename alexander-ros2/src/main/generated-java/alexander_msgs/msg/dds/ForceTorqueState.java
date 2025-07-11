package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds current state of the FT sensor
       */
public class ForceTorqueState extends Packet<ForceTorqueState> implements Settable<ForceTorqueState>, EpsilonComparable<ForceTorqueState>
{
   public java.lang.StringBuilder sensor_name_;
   /**
            * Sensor Data
            */
   public double[] force_;
   public double[] torque_;
   /**
            * Sensor Status
            */
   public boolean is_operational_;

   public ForceTorqueState()
   {
      sensor_name_ = new java.lang.StringBuilder(32);
      force_ = new double[3];

      torque_ = new double[3];

   }

   public ForceTorqueState(ForceTorqueState other)
   {
      this();
      set(other);
   }

   public void set(ForceTorqueState other)
   {
      sensor_name_.setLength(0);
      sensor_name_.append(other.sensor_name_);

      for(int i1 = 0; i1 < force_.length; ++i1)
      {
            force_[i1] = other.force_[i1];

      }

      for(int i3 = 0; i3 < torque_.length; ++i3)
      {
            torque_[i3] = other.torque_[i3];

      }

      is_operational_ = other.is_operational_;

   }

   public void setSensorName(java.lang.String sensor_name)
   {
      sensor_name_.setLength(0);
      sensor_name_.append(sensor_name);
   }

   public java.lang.String getSensorNameAsString()
   {
      return getSensorName().toString();
   }
   public java.lang.StringBuilder getSensorName()
   {
      return sensor_name_;
   }


   /**
            * Sensor Data
            */
   public double[] getForce()
   {
      return force_;
   }


   public double[] getTorque()
   {
      return torque_;
   }

   /**
            * Sensor Status
            */
   public void setIsOperational(boolean is_operational)
   {
      is_operational_ = is_operational;
   }
   /**
            * Sensor Status
            */
   public boolean getIsOperational()
   {
      return is_operational_;
   }


   public static Supplier<ForceTorqueStatePubSubType> getPubSubType()
   {
      return ForceTorqueStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ForceTorqueStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ForceTorqueState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.sensor_name_, other.sensor_name_, epsilon)) return false;

      for(int i5 = 0; i5 < force_.length; ++i5)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.force_[i5], other.force_[i5], epsilon)) return false;
      }

      for(int i7 = 0; i7 < torque_.length; ++i7)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.torque_[i7], other.torque_[i7], epsilon)) return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_operational_, other.is_operational_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ForceTorqueState)) return false;

      ForceTorqueState otherMyClass = (ForceTorqueState) other;

      if (!us.ihmc.idl.IDLTools.equals(this.sensor_name_, otherMyClass.sensor_name_)) return false;

      for(int i9 = 0; i9 < force_.length; ++i9)
      {
                if(this.force_[i9] != otherMyClass.force_[i9]) return false;

      }
      for(int i11 = 0; i11 < torque_.length; ++i11)
      {
                if(this.torque_[i11] != otherMyClass.torque_[i11]) return false;

      }
      if(this.is_operational_ != otherMyClass.is_operational_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ForceTorqueState {");
      builder.append("sensor_name=");
      builder.append(this.sensor_name_);      builder.append(", ");
      builder.append("force=");
      builder.append(java.util.Arrays.toString(this.force_));      builder.append(", ");
      builder.append("torque=");
      builder.append(java.util.Arrays.toString(this.torque_));      builder.append(", ");
      builder.append("is_operational=");
      builder.append(this.is_operational_);
      builder.append("}");
      return builder.toString();
   }
}
