package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "HardwareStatus" defined in "HardwareStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from HardwareStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit HardwareStatus_.idl instead.
*
*/
public class HardwareStatusPubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.HardwareStatus>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::HardwareStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "30402f23a14805d3c8bb2981f5087eda6b9c34dcc390f28b2f85d6e4d1a17081";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.HardwareStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.HardwareStatus data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 75; ++i0)
      {
          current_alignment += alex_msgs.msg.dds.ROSDeviceStatusProviderPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.HardwareStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.HardwareStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getDeviceStatusProviders().size(); ++i0)
      {
          current_alignment += alex_msgs.msg.dds.ROSDeviceStatusProviderPubSubType.getCdrSerializedSize(data.getDeviceStatusProviders().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getRobotFault());

      cdr.write_type_7(data.getMotorFault());

      cdr.write_type_7(data.getMissedDeadlineFault());

      cdr.write_type_7(data.getWorkingCounterFault());

      cdr.write_type_4(data.getWorkingCounterMismatchCount());

      cdr.write_type_4(data.getMissedDeadlines());

      cdr.write_type_6(data.getBatteryChargePercetage());

      cdr.write_type_6(data.getEstimatedRuntimeMinutes());

      cdr.write_type_7(data.getEnabled24V());

      if(data.getDeviceStatusProviders().size() <= 75)
      cdr.write_type_e(data.getDeviceStatusProviders());else
          throw new RuntimeException("device_status_providers field exceeds the maximum length: %d > %d".formatted(data.getDeviceStatusProviders().size(), 75));

   }

   public static void read(alex_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      data.setRobotFault(cdr.read_type_7());
      	
      data.setMotorFault(cdr.read_type_7());
      	
      data.setMissedDeadlineFault(cdr.read_type_7());
      	
      data.setWorkingCounterFault(cdr.read_type_7());
      	
      data.setWorkingCounterMismatchCount(cdr.read_type_4());
      	
      data.setMissedDeadlines(cdr.read_type_4());
      	
      data.setBatteryChargePercetage(cdr.read_type_6());
      	
      data.setEstimatedRuntimeMinutes(cdr.read_type_6());
      	
      data.setEnabled24V(cdr.read_type_7());
      	
      cdr.read_type_e(data.getDeviceStatusProviders());	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("robot_fault", data.getRobotFault());
      ser.write_type_7("motor_fault", data.getMotorFault());
      ser.write_type_7("missed_deadline_fault", data.getMissedDeadlineFault());
      ser.write_type_7("working_counter_fault", data.getWorkingCounterFault());
      ser.write_type_4("working_counter_mismatch_count", data.getWorkingCounterMismatchCount());
      ser.write_type_4("missed_deadlines", data.getMissedDeadlines());
      ser.write_type_6("battery_charge_percetage", data.getBatteryChargePercetage());
      ser.write_type_6("estimated_runtime_minutes", data.getEstimatedRuntimeMinutes());
      ser.write_type_7("enabled_24_v", data.getEnabled24V());
      ser.write_type_e("device_status_providers", data.getDeviceStatusProviders());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.HardwareStatus data)
   {
      data.setRobotFault(ser.read_type_7("robot_fault"));
      data.setMotorFault(ser.read_type_7("motor_fault"));
      data.setMissedDeadlineFault(ser.read_type_7("missed_deadline_fault"));
      data.setWorkingCounterFault(ser.read_type_7("working_counter_fault"));
      data.setWorkingCounterMismatchCount(ser.read_type_4("working_counter_mismatch_count"));
      data.setMissedDeadlines(ser.read_type_4("missed_deadlines"));
      data.setBatteryChargePercetage(ser.read_type_6("battery_charge_percetage"));
      data.setEstimatedRuntimeMinutes(ser.read_type_6("estimated_runtime_minutes"));
      data.setEnabled24V(ser.read_type_7("enabled_24_v"));
      ser.read_type_e("device_status_providers", data.getDeviceStatusProviders());
   }

   public static void staticCopy(alex_msgs.msg.dds.HardwareStatus src, alex_msgs.msg.dds.HardwareStatus dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.HardwareStatus createData()
   {
      return new alex_msgs.msg.dds.HardwareStatus();
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
   
   public void serialize(alex_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.HardwareStatus src, alex_msgs.msg.dds.HardwareStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HardwareStatusPubSubType newInstance()
   {
      return new HardwareStatusPubSubType();
   }
}
