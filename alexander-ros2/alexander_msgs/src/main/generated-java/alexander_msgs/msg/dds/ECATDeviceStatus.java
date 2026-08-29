package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class ECATDeviceStatus extends Packet<ECATDeviceStatus> implements Settable<ECATDeviceStatus>, EpsilonComparable<ECATDeviceStatus>
{
   /**
            * Holds the device info and the respective status
            */
   public java.lang.StringBuilder device_name_;
   public int alias_;
   public int position_;
   public int state_;
   public boolean is_operational_;

   public ECATDeviceStatus()
   {
      device_name_ = new java.lang.StringBuilder(255);
   }

   public ECATDeviceStatus(ECATDeviceStatus other)
   {
      this();
      set(other);
   }

   public void set(ECATDeviceStatus other)
   {
      device_name_.setLength(0);
      device_name_.append(other.device_name_);

      alias_ = other.alias_;

      position_ = other.position_;

      state_ = other.state_;

      is_operational_ = other.is_operational_;

   }

   /**
            * Holds the device info and the respective status
            */
   public void setDeviceName(java.lang.String device_name)
   {
      device_name_.setLength(0);
      device_name_.append(device_name);
   }

   /**
            * Holds the device info and the respective status
            */
   public java.lang.String getDeviceNameAsString()
   {
      return getDeviceName().toString();
   }
   /**
            * Holds the device info and the respective status
            */
   public java.lang.StringBuilder getDeviceName()
   {
      return device_name_;
   }

   public void setAlias(int alias)
   {
      alias_ = alias;
   }
   public int getAlias()
   {
      return alias_;
   }

   public void setPosition(int position)
   {
      position_ = position;
   }
   public int getPosition()
   {
      return position_;
   }

   public void setState(int state)
   {
      state_ = state;
   }
   public int getState()
   {
      return state_;
   }

   public void setIsOperational(boolean is_operational)
   {
      is_operational_ = is_operational;
   }
   public boolean getIsOperational()
   {
      return is_operational_;
   }


   public static Supplier<ECATDeviceStatusPubSubType> getPubSubType()
   {
      return ECATDeviceStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ECATDeviceStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ECATDeviceStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.device_name_, other.device_name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.alias_, other.alias_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.position_, other.position_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.state_, other.state_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_operational_, other.is_operational_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ECATDeviceStatus)) return false;

      ECATDeviceStatus otherMyClass = (ECATDeviceStatus) other;

      if (!us.ihmc.idl.IDLTools.equals(this.device_name_, otherMyClass.device_name_)) return false;

      if(this.alias_ != otherMyClass.alias_) return false;

      if(this.position_ != otherMyClass.position_) return false;

      if(this.state_ != otherMyClass.state_) return false;

      if(this.is_operational_ != otherMyClass.is_operational_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ECATDeviceStatus {");
      builder.append("device_name=");
      builder.append(this.device_name_);      builder.append(", ");
      builder.append("alias=");
      builder.append(this.alias_);      builder.append(", ");
      builder.append("position=");
      builder.append(this.position_);      builder.append(", ");
      builder.append("state=");
      builder.append(this.state_);      builder.append(", ");
      builder.append("is_operational=");
      builder.append(this.is_operational_);
      builder.append("}");
      return builder.toString();
   }
}
