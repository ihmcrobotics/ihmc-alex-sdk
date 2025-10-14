package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "HardwareStatus" defined in "HardwareStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from HardwareStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit HardwareStatus_.idl instead.
*
*/
public class HardwareStatusPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.HardwareStatus>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::HardwareStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "b5e4685efc1ee9fc6e8f773772cd7c9987370dbc1f12c8465aa8666c3f4cdae5";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.HardwareStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.HardwareStatus data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.ROSDeviceStatusProviderPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.HardwareStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.HardwareStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getDeviceStatusHolders().size(); ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.ROSDeviceStatusProviderPubSubType.getCdrSerializedSize(data.getDeviceStatusHolders().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getRobotFault());

      cdr.write_type_7(data.getMotorFault());

      cdr.write_type_7(data.getMissedDeadlineFault());

      cdr.write_type_7(data.getWorkingCounterFault());

      cdr.write_type_6(data.getWorkingCounterMismatchCount());

      cdr.write_type_6(data.getMissedDeadlines());

      if(data.getDeviceStatusHolders().size() <= 50)
      cdr.write_type_e(data.getDeviceStatusHolders());else
          throw new RuntimeException("device_status_holders field exceeds the maximum length: %d > %d".formatted(data.getDeviceStatusHolders().size(), 50));

   }

   public static void read(alexander_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      data.setRobotFault(cdr.read_type_7());
      	
      data.setMotorFault(cdr.read_type_7());
      	
      data.setMissedDeadlineFault(cdr.read_type_7());
      	
      data.setWorkingCounterFault(cdr.read_type_7());
      	
      data.setWorkingCounterMismatchCount(cdr.read_type_6());
      	
      data.setMissedDeadlines(cdr.read_type_6());
      	
      cdr.read_type_e(data.getDeviceStatusHolders());	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("robot_fault", data.getRobotFault());
      ser.write_type_7("motor_fault", data.getMotorFault());
      ser.write_type_7("missed_deadline_fault", data.getMissedDeadlineFault());
      ser.write_type_7("working_counter_fault", data.getWorkingCounterFault());
      ser.write_type_6("working_counter_mismatch_count", data.getWorkingCounterMismatchCount());
      ser.write_type_6("missed_deadlines", data.getMissedDeadlines());
      ser.write_type_e("device_status_holders", data.getDeviceStatusHolders());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.HardwareStatus data)
   {
      data.setRobotFault(ser.read_type_7("robot_fault"));
      data.setMotorFault(ser.read_type_7("motor_fault"));
      data.setMissedDeadlineFault(ser.read_type_7("missed_deadline_fault"));
      data.setWorkingCounterFault(ser.read_type_7("working_counter_fault"));
      data.setWorkingCounterMismatchCount(ser.read_type_6("working_counter_mismatch_count"));
      data.setMissedDeadlines(ser.read_type_6("missed_deadlines"));
      ser.read_type_e("device_status_holders", data.getDeviceStatusHolders());
   }

   public static void staticCopy(alexander_msgs.msg.dds.HardwareStatus src, alexander_msgs.msg.dds.HardwareStatus dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.HardwareStatus createData()
   {
      return new alexander_msgs.msg.dds.HardwareStatus();
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
   
   public void serialize(alexander_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.HardwareStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.HardwareStatus src, alexander_msgs.msg.dds.HardwareStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HardwareStatusPubSubType newInstance()
   {
      return new HardwareStatusPubSubType();
   }
}
