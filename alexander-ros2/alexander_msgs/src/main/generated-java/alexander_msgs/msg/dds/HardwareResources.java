package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Designates the resources to use for hardware
       */
public class HardwareResources extends Packet<HardwareResources> implements Settable<HardwareResources>, EpsilonComparable<HardwareResources>
{
   /**
            * Designate the number of xml resources and their names
            */
   public long num_resources_;
   public java.lang.StringBuilder[] xml_resources_;

   public HardwareResources()
   {
      xml_resources_ = new java.lang.StringBuilder[7];

      for(int i1 = 0; i1 < xml_resources_.length; ++i1)
      {
          xml_resources_[i1] = new java.lang.StringBuilder();
      }
   }

   public HardwareResources(HardwareResources other)
   {
      this();
      set(other);
   }

   public void set(HardwareResources other)
   {
      num_resources_ = other.num_resources_;

      for(int i3 = 0; i3 < xml_resources_.length; ++i3)
      {
            xml_resources_[i3].setLength(0);
            xml_resources_[i3].append(other.xml_resources_[i3]);
      }

   }

   /**
            * Designate the number of xml resources and their names
            */
   public void setNumResources(long num_resources)
   {
      num_resources_ = num_resources;
   }
   /**
            * Designate the number of xml resources and their names
            */
   public long getNumResources()
   {
      return num_resources_;
   }


   public java.lang.StringBuilder[] getXmlResources()
   {
      return xml_resources_;
   }


   public static Supplier<HardwareResourcesPubSubType> getPubSubType()
   {
      return HardwareResourcesPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return HardwareResourcesPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(HardwareResources other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.num_resources_, other.num_resources_, epsilon)) return false;

      for(int i5 = 0; i5 < xml_resources_.length; ++i5)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.xml_resources_[i5], other.xml_resources_[i5], epsilon)) return false;}


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof HardwareResources)) return false;

      HardwareResources otherMyClass = (HardwareResources) other;

      if(this.num_resources_ != otherMyClass.num_resources_) return false;

      for(int i7 = 0; i7 < xml_resources_.length; ++i7)
      {
                if (!us.ihmc.idl.IDLTools.equals(this.xml_resources_[i7], otherMyClass.xml_resources_[i7])) return false;}

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("HardwareResources {");
      builder.append("num_resources=");
      builder.append(this.num_resources_);      builder.append(", ");
      builder.append("xml_resources=");
      builder.append(java.util.Arrays.toString(this.xml_resources_));
      builder.append("}");
      return builder.toString();
   }
}
