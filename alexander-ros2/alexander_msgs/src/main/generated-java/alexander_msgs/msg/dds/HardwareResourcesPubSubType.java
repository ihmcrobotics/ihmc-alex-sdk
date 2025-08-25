package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "HardwareResources" defined in "HardwareResources_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from HardwareResources_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit HardwareResources_.idl instead.
*
*/
public class HardwareResourcesPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.HardwareResources>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::HardwareResources_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "71e5dca75383716869883c0d721b2276e2ec0a6c4b21ee5931c8201d663e055e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.HardwareResources data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.HardwareResources data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 32 + 1;
      for(int i0 = 0; i0 < (9); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      for(int i0 = 0; i0 < (6); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.HardwareResources data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.HardwareResources data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getVersionDirectory().length() + 1;

      for(int i0 = 0; i0 < data.getXmlResources().length; ++i0)
      {
              current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getXmlResources()[i0].length() + 1;

      }
      for(int i0 = 0; i0 < data.getUrdfResources().length; ++i0)
      {
              current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getUrdfResources()[i0].length() + 1;

      }

      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_4(data.getNumResources());

      if(data.getVersionDirectory().length() <= 32)
      cdr.write_type_d(data.getVersionDirectory());else
          throw new RuntimeException("version_directory field exceeds the maximum length: %d > %d".formatted(data.getVersionDirectory().length(), 32));

      for(int i0 = 0; i0 < data.getXmlResources().length; ++i0)
      {
        	cdr.write_type_d(data.getXmlResources()[i0]);	
      }

      for(int i0 = 0; i0 < data.getUrdfResources().length; ++i0)
      {
        	cdr.write_type_d(data.getUrdfResources()[i0]);	
      }

   }

   public static void read(alexander_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      data.setNumResources(cdr.read_type_4());
      	
      cdr.read_type_d(data.getVersionDirectory());	
      for(int i0 = 0; i0 < data.getXmlResources().length; ++i0)
      {
        	cdr.read_type_d(data.getXmlResources()[i0]);	
      }
      	
      for(int i0 = 0; i0 < data.getUrdfResources().length; ++i0)
      {
        	cdr.read_type_d(data.getUrdfResources()[i0]);	
      }
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.HardwareResources data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_4("num_resources", data.getNumResources());
      ser.write_type_d("version_directory", data.getVersionDirectory());
      ser.write_type_f("xml_resources", data.getXmlResources());
      ser.write_type_f("urdf_resources", data.getUrdfResources());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.HardwareResources data)
   {
      data.setNumResources(ser.read_type_4("num_resources"));
      ser.read_type_d("version_directory", data.getVersionDirectory());
      ser.read_type_f("xml_resources", data.getXmlResources());
      ser.read_type_f("urdf_resources", data.getUrdfResources());
   }

   public static void staticCopy(alexander_msgs.msg.dds.HardwareResources src, alexander_msgs.msg.dds.HardwareResources dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.HardwareResources createData()
   {
      return new alexander_msgs.msg.dds.HardwareResources();
   }
   @Override
   public int getTypeSize()
   {
      return us.ihmc.idl.CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public java.lang.String getName()
   {
      return name;
   }
   
   public void serialize(alexander_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.HardwareResources src, alexander_msgs.msg.dds.HardwareResources dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HardwareResourcesPubSubType newInstance()
   {
      return new HardwareResourcesPubSubType();
   }
}
