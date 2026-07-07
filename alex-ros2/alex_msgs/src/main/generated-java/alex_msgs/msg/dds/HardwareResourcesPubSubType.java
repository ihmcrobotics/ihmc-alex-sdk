package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "HardwareResources" defined in "HardwareResources_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from HardwareResources_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit HardwareResources_.idl instead.
*
*/
public class HardwareResourcesPubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.HardwareResources>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::HardwareResources_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "ec8e24c1875f12ede6a1f9631b636139db0444a36958df93587231b00bf34944";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.HardwareResources data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.HardwareResources data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      for(int i0 = 0; i0 < (11); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      for(int i0 = 0; i0 < (10); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 46 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 46 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.HardwareResources data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.HardwareResources data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      for(int i0 = 0; i0 < data.getXmlResources().length; ++i0)
      {
              current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getXmlResources()[i0].length() + 1;

      }
      for(int i0 = 0; i0 < data.getUrdfResources().length; ++i0)
      {
              current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getUrdfResources()[i0].length() + 1;

      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getHardwareDescriptionDirectory().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getVirtualDescriptionDirectory().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_4(data.getNumXmlResources());

      cdr.write_type_4(data.getNumUrdfResources());

      for(int i0 = 0; i0 < data.getXmlResources().length; ++i0)
      {
        	cdr.write_type_d(data.getXmlResources()[i0]);	
      }

      for(int i0 = 0; i0 < data.getUrdfResources().length; ++i0)
      {
        	cdr.write_type_d(data.getUrdfResources()[i0]);	
      }

      if(data.getHardwareDescriptionDirectory().length() <= 46)
      cdr.write_type_d(data.getHardwareDescriptionDirectory());else
          throw new RuntimeException("hardware_description_directory field exceeds the maximum length: %d > %d".formatted(data.getHardwareDescriptionDirectory().length(), 46));

      if(data.getVirtualDescriptionDirectory().length() <= 46)
      cdr.write_type_d(data.getVirtualDescriptionDirectory());else
          throw new RuntimeException("virtual_description_directory field exceeds the maximum length: %d > %d".formatted(data.getVirtualDescriptionDirectory().length(), 46));

   }

   public static void read(alex_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      data.setNumXmlResources(cdr.read_type_4());
      	
      data.setNumUrdfResources(cdr.read_type_4());
      	
      for(int i0 = 0; i0 < data.getXmlResources().length; ++i0)
      {
        	cdr.read_type_d(data.getXmlResources()[i0]);	
      }
      	
      for(int i0 = 0; i0 < data.getUrdfResources().length; ++i0)
      {
        	cdr.read_type_d(data.getUrdfResources()[i0]);	
      }
      	
      cdr.read_type_d(data.getHardwareDescriptionDirectory());	
      cdr.read_type_d(data.getVirtualDescriptionDirectory());	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.HardwareResources data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_4("num_xml_resources", data.getNumXmlResources());
      ser.write_type_4("num_urdf_resources", data.getNumUrdfResources());
      ser.write_type_f("xml_resources", data.getXmlResources());
      ser.write_type_f("urdf_resources", data.getUrdfResources());
      ser.write_type_d("hardware_description_directory", data.getHardwareDescriptionDirectory());
      ser.write_type_d("virtual_description_directory", data.getVirtualDescriptionDirectory());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.HardwareResources data)
   {
      data.setNumXmlResources(ser.read_type_4("num_xml_resources"));
      data.setNumUrdfResources(ser.read_type_4("num_urdf_resources"));
      ser.read_type_f("xml_resources", data.getXmlResources());
      ser.read_type_f("urdf_resources", data.getUrdfResources());
      ser.read_type_d("hardware_description_directory", data.getHardwareDescriptionDirectory());
      ser.read_type_d("virtual_description_directory", data.getVirtualDescriptionDirectory());
   }

   public static void staticCopy(alex_msgs.msg.dds.HardwareResources src, alex_msgs.msg.dds.HardwareResources dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.HardwareResources createData()
   {
      return new alex_msgs.msg.dds.HardwareResources();
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
   
   public void serialize(alex_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.HardwareResources data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.HardwareResources src, alex_msgs.msg.dds.HardwareResources dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HardwareResourcesPubSubType newInstance()
   {
      return new HardwareResourcesPubSubType();
   }
}
