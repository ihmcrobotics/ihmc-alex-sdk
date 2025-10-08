package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexanderState" defined in "AlexanderState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexanderState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexanderState_.idl instead.
*
*/
public class AlexanderStatePubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.AlexanderState>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::AlexanderState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "72c1cd731045b2230fdb016aa0b590bbc186c1f9eb25bcd4602536d4159bad31";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.AlexanderState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.AlexanderState data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.OneDOFJointStatePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.IMUStatePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.ForceTorqueStatePubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJointStates().size(); ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.OneDOFJointStatePubSubType.getCdrSerializedSize(data.getJointStates().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getImuStates().size(); ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.IMUStatePubSubType.getCdrSerializedSize(data.getImuStates().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getFtStates().size(); ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.ForceTorqueStatePubSubType.getCdrSerializedSize(data.getFtStates().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.AlexanderState data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(data.getTime());

      cdr.write_type_7(data.getIsFaulted());

      cdr.write_type_7(data.getIsCalibrated());

      cdr.write_type_4(data.getNumberOfJoints());

      cdr.write_type_4(data.getNumberOfImus());

      cdr.write_type_4(data.getNumberOfFts());

      if(data.getJointStates().size() <= 50)
      cdr.write_type_e(data.getJointStates());else
          throw new RuntimeException("joint_states field exceeds the maximum length: %d > %d".formatted(data.getJointStates().size(), 50));

      if(data.getImuStates().size() <= 50)
      cdr.write_type_e(data.getImuStates());else
          throw new RuntimeException("imu_states field exceeds the maximum length: %d > %d".formatted(data.getImuStates().size(), 50));

      if(data.getFtStates().size() <= 50)
      cdr.write_type_e(data.getFtStates());else
          throw new RuntimeException("ft_states field exceeds the maximum length: %d > %d".formatted(data.getFtStates().size(), 50));

   }

   public static void read(alexander_msgs.msg.dds.AlexanderState data, us.ihmc.idl.CDR cdr)
   {
      data.setTime(cdr.read_type_6());
      	
      data.setIsFaulted(cdr.read_type_7());
      	
      data.setIsCalibrated(cdr.read_type_7());
      	
      data.setNumberOfJoints(cdr.read_type_4());
      	
      data.setNumberOfImus(cdr.read_type_4());
      	
      data.setNumberOfFts(cdr.read_type_4());
      	
      cdr.read_type_e(data.getJointStates());	
      cdr.read_type_e(data.getImuStates());	
      cdr.read_type_e(data.getFtStates());	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.AlexanderState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("time", data.getTime());
      ser.write_type_7("is_faulted", data.getIsFaulted());
      ser.write_type_7("is_calibrated", data.getIsCalibrated());
      ser.write_type_4("number_of_joints", data.getNumberOfJoints());
      ser.write_type_4("number_of_imus", data.getNumberOfImus());
      ser.write_type_4("number_of_fts", data.getNumberOfFts());
      ser.write_type_e("joint_states", data.getJointStates());
      ser.write_type_e("imu_states", data.getImuStates());
      ser.write_type_e("ft_states", data.getFtStates());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.AlexanderState data)
   {
      data.setTime(ser.read_type_6("time"));
      data.setIsFaulted(ser.read_type_7("is_faulted"));
      data.setIsCalibrated(ser.read_type_7("is_calibrated"));
      data.setNumberOfJoints(ser.read_type_4("number_of_joints"));
      data.setNumberOfImus(ser.read_type_4("number_of_imus"));
      data.setNumberOfFts(ser.read_type_4("number_of_fts"));
      ser.read_type_e("joint_states", data.getJointStates());
      ser.read_type_e("imu_states", data.getImuStates());
      ser.read_type_e("ft_states", data.getFtStates());
   }

   public static void staticCopy(alexander_msgs.msg.dds.AlexanderState src, alexander_msgs.msg.dds.AlexanderState dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.AlexanderState createData()
   {
      return new alexander_msgs.msg.dds.AlexanderState();
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
   
   public void serialize(alexander_msgs.msg.dds.AlexanderState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.AlexanderState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.AlexanderState src, alexander_msgs.msg.dds.AlexanderState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexanderStatePubSubType newInstance()
   {
      return new AlexanderStatePubSubType();
   }
}
