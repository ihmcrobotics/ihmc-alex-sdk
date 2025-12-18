package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ROSDeviceStatusProvider" defined in "ROSDeviceStatusProvider_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ROSDeviceStatusProvider_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ROSDeviceStatusProvider_.idl instead.
*
*/
public class ROSDeviceStatusProviderPubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.ROSDeviceStatusProvider>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::ROSDeviceStatusProvider_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "40816d4484f568c3ac572b8c51a3ed85c493128f1149a876faa6633c3b556daa";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.ROSDeviceStatusProvider data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.ROSDeviceStatusProvider data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 70 + 1;
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.ROSDeviceStatusProvider data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.ROSDeviceStatusProvider data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.ROSDeviceStatusProvider data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 70)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 70));

      cdr.write_type_7(data.getIsResponding());

      cdr.write_type_7(data.getIsFaulted());

      cdr.write_type_9(data.getEthercatState());

      cdr.write_type_7(data.getUnderVoltage());

      cdr.write_type_7(data.getOverVoltage());

      cdr.write_type_7(data.getStoDisabled());

      cdr.write_type_7(data.getCurrentShort());

      cdr.write_type_7(data.getOverTemp());

   }

   public static void read(alex_msgs.msg.dds.ROSDeviceStatusProvider data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      data.setIsResponding(cdr.read_type_7());
      	
      data.setIsFaulted(cdr.read_type_7());
      	
      data.setEthercatState(cdr.read_type_9());
      	
      data.setUnderVoltage(cdr.read_type_7());
      	
      data.setOverVoltage(cdr.read_type_7());
      	
      data.setStoDisabled(cdr.read_type_7());
      	
      data.setCurrentShort(cdr.read_type_7());
      	
      data.setOverTemp(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.ROSDeviceStatusProvider data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_7("is_responding", data.getIsResponding());
      ser.write_type_7("is_faulted", data.getIsFaulted());
      ser.write_type_9("ethercat_state", data.getEthercatState());
      ser.write_type_7("under_voltage", data.getUnderVoltage());
      ser.write_type_7("over_voltage", data.getOverVoltage());
      ser.write_type_7("sto_disabled", data.getStoDisabled());
      ser.write_type_7("current_short", data.getCurrentShort());
      ser.write_type_7("over_temp", data.getOverTemp());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.ROSDeviceStatusProvider data)
   {
      ser.read_type_d("name", data.getName());
      data.setIsResponding(ser.read_type_7("is_responding"));
      data.setIsFaulted(ser.read_type_7("is_faulted"));
      data.setEthercatState(ser.read_type_9("ethercat_state"));
      data.setUnderVoltage(ser.read_type_7("under_voltage"));
      data.setOverVoltage(ser.read_type_7("over_voltage"));
      data.setStoDisabled(ser.read_type_7("sto_disabled"));
      data.setCurrentShort(ser.read_type_7("current_short"));
      data.setOverTemp(ser.read_type_7("over_temp"));
   }

   public static void staticCopy(alex_msgs.msg.dds.ROSDeviceStatusProvider src, alex_msgs.msg.dds.ROSDeviceStatusProvider dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.ROSDeviceStatusProvider createData()
   {
      return new alex_msgs.msg.dds.ROSDeviceStatusProvider();
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
   
   public void serialize(alex_msgs.msg.dds.ROSDeviceStatusProvider data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.ROSDeviceStatusProvider data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.ROSDeviceStatusProvider src, alex_msgs.msg.dds.ROSDeviceStatusProvider dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ROSDeviceStatusProviderPubSubType newInstance()
   {
      return new ROSDeviceStatusProviderPubSubType();
   }
}
