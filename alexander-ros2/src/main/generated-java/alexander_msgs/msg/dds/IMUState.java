package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds the state of the IMU
       */
public class IMUState extends Packet<IMUState> implements Settable<IMUState>, EpsilonComparable<IMUState>
{
   public java.lang.StringBuilder sensor_name_;
   /**
            * Sensor Data
            */
   public double[] quaternion_;
   public double[] gyroscope_;
   public double[] accelerometer_;
   /**
            * Sensor Status
            */
   public int temperature_;
   public boolean is_operational_;

   public IMUState()
   {
      sensor_name_ = new java.lang.StringBuilder(32);
      quaternion_ = new double[4];

      gyroscope_ = new double[3];

      accelerometer_ = new double[3];

   }

   public IMUState(IMUState other)
   {
      this();
      set(other);
   }

   public void set(IMUState other)
   {
      sensor_name_.setLength(0);
      sensor_name_.append(other.sensor_name_);

      for(int i1 = 0; i1 < quaternion_.length; ++i1)
      {
            quaternion_[i1] = other.quaternion_[i1];

      }

      for(int i3 = 0; i3 < gyroscope_.length; ++i3)
      {
            gyroscope_[i3] = other.gyroscope_[i3];

      }

      for(int i5 = 0; i5 < accelerometer_.length; ++i5)
      {
            accelerometer_[i5] = other.accelerometer_[i5];

      }

      temperature_ = other.temperature_;

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
   public double[] getQuaternion()
   {
      return quaternion_;
   }


   public double[] getGyroscope()
   {
      return gyroscope_;
   }


   public double[] getAccelerometer()
   {
      return accelerometer_;
   }

   /**
            * Sensor Status
            */
   public void setTemperature(int temperature)
   {
      temperature_ = temperature;
   }
   /**
            * Sensor Status
            */
   public int getTemperature()
   {
      return temperature_;
   }

   public void setIsOperational(boolean is_operational)
   {
      is_operational_ = is_operational;
   }
   public boolean getIsOperational()
   {
      return is_operational_;
   }


   public static Supplier<IMUStatePubSubType> getPubSubType()
   {
      return IMUStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return IMUStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(IMUState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.sensor_name_, other.sensor_name_, epsilon)) return false;

      for(int i7 = 0; i7 < quaternion_.length; ++i7)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.quaternion_[i7], other.quaternion_[i7], epsilon)) return false;
      }

      for(int i9 = 0; i9 < gyroscope_.length; ++i9)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.gyroscope_[i9], other.gyroscope_[i9], epsilon)) return false;
      }

      for(int i11 = 0; i11 < accelerometer_.length; ++i11)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.accelerometer_[i11], other.accelerometer_[i11], epsilon)) return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.temperature_, other.temperature_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_operational_, other.is_operational_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof IMUState)) return false;

      IMUState otherMyClass = (IMUState) other;

      if (!us.ihmc.idl.IDLTools.equals(this.sensor_name_, otherMyClass.sensor_name_)) return false;

      for(int i13 = 0; i13 < quaternion_.length; ++i13)
      {
                if(this.quaternion_[i13] != otherMyClass.quaternion_[i13]) return false;

      }
      for(int i15 = 0; i15 < gyroscope_.length; ++i15)
      {
                if(this.gyroscope_[i15] != otherMyClass.gyroscope_[i15]) return false;

      }
      for(int i17 = 0; i17 < accelerometer_.length; ++i17)
      {
                if(this.accelerometer_[i17] != otherMyClass.accelerometer_[i17]) return false;

      }
      if(this.temperature_ != otherMyClass.temperature_) return false;

      if(this.is_operational_ != otherMyClass.is_operational_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IMUState {");
      builder.append("sensor_name=");
      builder.append(this.sensor_name_);      builder.append(", ");
      builder.append("quaternion=");
      builder.append(java.util.Arrays.toString(this.quaternion_));      builder.append(", ");
      builder.append("gyroscope=");
      builder.append(java.util.Arrays.toString(this.gyroscope_));      builder.append(", ");
      builder.append("accelerometer=");
      builder.append(java.util.Arrays.toString(this.accelerometer_));      builder.append(", ");
      builder.append("temperature=");
      builder.append(this.temperature_);      builder.append(", ");
      builder.append("is_operational=");
      builder.append(this.is_operational_);
      builder.append("}");
      return builder.toString();
   }
}
