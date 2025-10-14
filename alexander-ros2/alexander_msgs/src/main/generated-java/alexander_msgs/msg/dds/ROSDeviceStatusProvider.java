package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Data holder containing status info for a given device
       */
public class ROSDeviceStatusProvider extends Packet<ROSDeviceStatusProvider> implements Settable<ROSDeviceStatusProvider>, EpsilonComparable<ROSDeviceStatusProvider>
{
   /**
            * The device name
            */
   public java.lang.StringBuilder name_;
   /**
            * Primary device status info
            */
   public boolean is_responding_;
   public boolean is_faulted_;
   /**
            * More specific device status info related to isFaulted (elmo twitter fault)
            */
   public boolean under_voltage_;
   public boolean over_voltage_;
   public boolean sto_disabled_;
   public boolean current_short_;
   public boolean over_temp_;

   public ROSDeviceStatusProvider()
   {
      name_ = new java.lang.StringBuilder(32);
   }

   public ROSDeviceStatusProvider(ROSDeviceStatusProvider other)
   {
      this();
      set(other);
   }

   public void set(ROSDeviceStatusProvider other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      is_responding_ = other.is_responding_;

      is_faulted_ = other.is_faulted_;

      under_voltage_ = other.under_voltage_;

      over_voltage_ = other.over_voltage_;

      sto_disabled_ = other.sto_disabled_;

      current_short_ = other.current_short_;

      over_temp_ = other.over_temp_;

   }

   /**
            * The device name
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * The device name
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * The device name
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
            * Primary device status info
            */
   public void setIsResponding(boolean is_responding)
   {
      is_responding_ = is_responding;
   }
   /**
            * Primary device status info
            */
   public boolean getIsResponding()
   {
      return is_responding_;
   }

   public void setIsFaulted(boolean is_faulted)
   {
      is_faulted_ = is_faulted;
   }
   public boolean getIsFaulted()
   {
      return is_faulted_;
   }

   /**
            * More specific device status info related to isFaulted (elmo twitter fault)
            */
   public void setUnderVoltage(boolean under_voltage)
   {
      under_voltage_ = under_voltage;
   }
   /**
            * More specific device status info related to isFaulted (elmo twitter fault)
            */
   public boolean getUnderVoltage()
   {
      return under_voltage_;
   }

   public void setOverVoltage(boolean over_voltage)
   {
      over_voltage_ = over_voltage;
   }
   public boolean getOverVoltage()
   {
      return over_voltage_;
   }

   public void setStoDisabled(boolean sto_disabled)
   {
      sto_disabled_ = sto_disabled;
   }
   public boolean getStoDisabled()
   {
      return sto_disabled_;
   }

   public void setCurrentShort(boolean current_short)
   {
      current_short_ = current_short;
   }
   public boolean getCurrentShort()
   {
      return current_short_;
   }

   public void setOverTemp(boolean over_temp)
   {
      over_temp_ = over_temp;
   }
   public boolean getOverTemp()
   {
      return over_temp_;
   }


   public static Supplier<ROSDeviceStatusProviderPubSubType> getPubSubType()
   {
      return ROSDeviceStatusProviderPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ROSDeviceStatusProviderPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ROSDeviceStatusProvider other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_responding_, other.is_responding_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_faulted_, other.is_faulted_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.under_voltage_, other.under_voltage_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.over_voltage_, other.over_voltage_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.sto_disabled_, other.sto_disabled_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.current_short_, other.current_short_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.over_temp_, other.over_temp_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ROSDeviceStatusProvider)) return false;

      ROSDeviceStatusProvider otherMyClass = (ROSDeviceStatusProvider) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if(this.is_responding_ != otherMyClass.is_responding_) return false;

      if(this.is_faulted_ != otherMyClass.is_faulted_) return false;

      if(this.under_voltage_ != otherMyClass.under_voltage_) return false;

      if(this.over_voltage_ != otherMyClass.over_voltage_) return false;

      if(this.sto_disabled_ != otherMyClass.sto_disabled_) return false;

      if(this.current_short_ != otherMyClass.current_short_) return false;

      if(this.over_temp_ != otherMyClass.over_temp_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ROSDeviceStatusProvider {");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("is_responding=");
      builder.append(this.is_responding_);      builder.append(", ");
      builder.append("is_faulted=");
      builder.append(this.is_faulted_);      builder.append(", ");
      builder.append("under_voltage=");
      builder.append(this.under_voltage_);      builder.append(", ");
      builder.append("over_voltage=");
      builder.append(this.over_voltage_);      builder.append(", ");
      builder.append("sto_disabled=");
      builder.append(this.sto_disabled_);      builder.append(", ");
      builder.append("current_short=");
      builder.append(this.current_short_);      builder.append(", ");
      builder.append("over_temp=");
      builder.append(this.over_temp_);
      builder.append("}");
      return builder.toString();
   }
}
