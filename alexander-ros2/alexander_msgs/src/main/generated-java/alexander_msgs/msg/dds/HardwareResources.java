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
   /**
            * The directory containing the resources of the desired version of the robot
            */
   public java.lang.StringBuilder version_directory_;
   /**
            * The list of individual XML files comprising the full XML description of the robot
            */
   public java.lang.StringBuilder[] xml_resources_;
   /**
            * The list of individual URDF files comprising the full URDF description of the robot
            */
   public java.lang.StringBuilder[] urdf_resources_;

   public HardwareResources()
   {
      version_directory_ = new java.lang.StringBuilder(32);
      xml_resources_ = new java.lang.StringBuilder[9];

      for(int i1 = 0; i1 < xml_resources_.length; ++i1)
      {
          xml_resources_[i1] = new java.lang.StringBuilder();
      }
      urdf_resources_ = new java.lang.StringBuilder[6];

      for(int i3 = 0; i3 < urdf_resources_.length; ++i3)
      {
          urdf_resources_[i3] = new java.lang.StringBuilder();
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

      version_directory_.setLength(0);
      version_directory_.append(other.version_directory_);

      for(int i5 = 0; i5 < xml_resources_.length; ++i5)
      {
            xml_resources_[i5].setLength(0);
            xml_resources_[i5].append(other.xml_resources_[i5]);
      }

      for(int i7 = 0; i7 < urdf_resources_.length; ++i7)
      {
            urdf_resources_[i7].setLength(0);
            urdf_resources_[i7].append(other.urdf_resources_[i7]);
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

   /**
            * The directory containing the resources of the desired version of the robot
            */
   public void setVersionDirectory(java.lang.String version_directory)
   {
      version_directory_.setLength(0);
      version_directory_.append(version_directory);
   }

   /**
            * The directory containing the resources of the desired version of the robot
            */
   public java.lang.String getVersionDirectoryAsString()
   {
      return getVersionDirectory().toString();
   }
   /**
            * The directory containing the resources of the desired version of the robot
            */
   public java.lang.StringBuilder getVersionDirectory()
   {
      return version_directory_;
   }


   /**
            * The list of individual XML files comprising the full XML description of the robot
            */
   public java.lang.StringBuilder[] getXmlResources()
   {
      return xml_resources_;
   }


   /**
            * The list of individual URDF files comprising the full URDF description of the robot
            */
   public java.lang.StringBuilder[] getUrdfResources()
   {
      return urdf_resources_;
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.version_directory_, other.version_directory_, epsilon)) return false;

      for(int i9 = 0; i9 < xml_resources_.length; ++i9)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.xml_resources_[i9], other.xml_resources_[i9], epsilon)) return false;}

      for(int i11 = 0; i11 < urdf_resources_.length; ++i11)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.urdf_resources_[i11], other.urdf_resources_[i11], epsilon)) return false;}


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

      if (!us.ihmc.idl.IDLTools.equals(this.version_directory_, otherMyClass.version_directory_)) return false;

      for(int i13 = 0; i13 < xml_resources_.length; ++i13)
      {
                if (!us.ihmc.idl.IDLTools.equals(this.xml_resources_[i13], otherMyClass.xml_resources_[i13])) return false;}
      for(int i15 = 0; i15 < urdf_resources_.length; ++i15)
      {
                if (!us.ihmc.idl.IDLTools.equals(this.urdf_resources_[i15], otherMyClass.urdf_resources_[i15])) return false;}

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("HardwareResources {");
      builder.append("num_resources=");
      builder.append(this.num_resources_);      builder.append(", ");
      builder.append("version_directory=");
      builder.append(this.version_directory_);      builder.append(", ");
      builder.append("xml_resources=");
      builder.append(java.util.Arrays.toString(this.xml_resources_));      builder.append(", ");
      builder.append("urdf_resources=");
      builder.append(java.util.Arrays.toString(this.urdf_resources_));
      builder.append("}");
      return builder.toString();
   }
}
