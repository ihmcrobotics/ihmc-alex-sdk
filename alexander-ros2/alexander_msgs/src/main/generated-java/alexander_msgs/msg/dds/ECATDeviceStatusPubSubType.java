package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ECATDeviceStatus" defined in "ECATDeviceStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ECATDeviceStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ECATDeviceStatus_.idl instead.
*
*/
public class ECATDeviceStatusPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.ECATDeviceStatus>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::ECATDeviceStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "994bf477bc7a07f337a2be7aa51a7e48dff89b76d7c41732fe19ae16e0fbaf07";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.ECATDeviceStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.ECATDeviceStatus data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.ECATDeviceStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.ECATDeviceStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getDeviceName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.ECATDeviceStatus data, us.ihmc.idl.CDR cdr)
   {
      if(data.getDeviceName().length() <= 255)
      cdr.write_type_d(data.getDeviceName());else
          throw new RuntimeException("device_name field exceeds the maximum length: %d > %d".formatted(data.getDeviceName().length(), 255));

      cdr.write_type_2(data.getAlias());

      cdr.write_type_2(data.getPosition());

      cdr.write_type_2(data.getState());

      cdr.write_type_7(data.getIsOperational());

   }

   public static void read(alexander_msgs.msg.dds.ECATDeviceStatus data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getDeviceName());	
      data.setAlias(cdr.read_type_2());
      	
      data.setPosition(cdr.read_type_2());
      	
      data.setState(cdr.read_type_2());
      	
      data.setIsOperational(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.ECATDeviceStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("device_name", data.getDeviceName());
      ser.write_type_2("alias", data.getAlias());
      ser.write_type_2("position", data.getPosition());
      ser.write_type_2("state", data.getState());
      ser.write_type_7("is_operational", data.getIsOperational());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.ECATDeviceStatus data)
   {
      ser.read_type_d("device_name", data.getDeviceName());
      data.setAlias(ser.read_type_2("alias"));
      data.setPosition(ser.read_type_2("position"));
      data.setState(ser.read_type_2("state"));
      data.setIsOperational(ser.read_type_7("is_operational"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.ECATDeviceStatus src, alexander_msgs.msg.dds.ECATDeviceStatus dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.ECATDeviceStatus createData()
   {
      return new alexander_msgs.msg.dds.ECATDeviceStatus();
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
   
   public void serialize(alexander_msgs.msg.dds.ECATDeviceStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.ECATDeviceStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.ECATDeviceStatus src, alexander_msgs.msg.dds.ECATDeviceStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ECATDeviceStatusPubSubType newInstance()
   {
      return new ECATDeviceStatusPubSubType();
   }
}
