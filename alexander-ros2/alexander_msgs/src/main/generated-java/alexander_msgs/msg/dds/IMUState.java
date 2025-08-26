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
            * SensorData
            * This is the position of the IMU in the world frame
            */
   public double[] position_;
   /**
            * This is the orientation of the IMU in the world frame, stored as x, y, z, s
            */
   public double[] quaternion_;
   /**
            * This is the angular velocity of the IMU in the sensor frame
            */
   public double[] gyroscope_;
   /**
            * This is the linear acceleration of the IMU in the sensor frame
            */
   public double[] accelerometer_;
   /**
            * Sensor Status
            */
   public int temperature_;
   public boolean is_operational_;

   public IMUState()
   {
      sensor_name_ = new java.lang.StringBuilder(32);
      position_ = new double[3];

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

      for(int i1 = 0; i1 < position_.length; ++i1)
      {
            position_[i1] = other.position_[i1];

      }

      for(int i3 = 0; i3 < quaternion_.length; ++i3)
      {
            quaternion_[i3] = other.quaternion_[i3];

      }

      for(int i5 = 0; i5 < gyroscope_.length; ++i5)
      {
            gyroscope_[i5] = other.gyroscope_[i5];

      }

      for(int i7 = 0; i7 < accelerometer_.length; ++i7)
      {
            accelerometer_[i7] = other.accelerometer_[i7];

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
            * SensorData
            * This is the position of the IMU in the world frame
            */
   public double[] getPosition()
   {
      return position_;
   }


   /**
            * This is the orientation of the IMU in the world frame, stored as x, y, z, s
            */
   public double[] getQuaternion()
   {
      return quaternion_;
   }


   /**
            * This is the angular velocity of the IMU in the sensor frame
            */
   public double[] getGyroscope()
   {
      return gyroscope_;
   }


   /**
            * This is the linear acceleration of the IMU in the sensor frame
            */
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

      for(int i9 = 0; i9 < position_.length; ++i9)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.position_[i9], other.position_[i9], epsilon)) return false;
      }

      for(int i11 = 0; i11 < quaternion_.length; ++i11)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.quaternion_[i11], other.quaternion_[i11], epsilon)) return false;
      }

      for(int i13 = 0; i13 < gyroscope_.length; ++i13)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.gyroscope_[i13], other.gyroscope_[i13], epsilon)) return false;
      }

      for(int i15 = 0; i15 < accelerometer_.length; ++i15)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.accelerometer_[i15], other.accelerometer_[i15], epsilon)) return false;
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

      for(int i17 = 0; i17 < position_.length; ++i17)
      {
                if(this.position_[i17] != otherMyClass.position_[i17]) return false;

      }
      for(int i19 = 0; i19 < quaternion_.length; ++i19)
      {
                if(this.quaternion_[i19] != otherMyClass.quaternion_[i19]) return false;

      }
      for(int i21 = 0; i21 < gyroscope_.length; ++i21)
      {
                if(this.gyroscope_[i21] != otherMyClass.gyroscope_[i21]) return false;

      }
      for(int i23 = 0; i23 < accelerometer_.length; ++i23)
      {
                if(this.accelerometer_[i23] != otherMyClass.accelerometer_[i23]) return false;

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
      builder.append("position=");
      builder.append(java.util.Arrays.toString(this.position_));      builder.append(", ");
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
