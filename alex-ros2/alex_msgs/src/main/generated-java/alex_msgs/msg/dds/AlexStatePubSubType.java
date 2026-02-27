package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexState" defined in "AlexState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexState_.idl instead.
*
*/
public class AlexStatePubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.AlexState>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::AlexState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "1e7e6fb9aa0a086942d37fd70c10212b847d94891b5d0ea047a391f8edf1545e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.AlexState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.AlexState data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alex_msgs.msg.dds.OneDOFJointStatePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alex_msgs.msg.dds.IMUStatePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alex_msgs.msg.dds.ForceTorqueStatePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.AlexState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.AlexState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJointStates().size(); ++i0)
      {
          current_alignment += alex_msgs.msg.dds.OneDOFJointStatePubSubType.getCdrSerializedSize(data.getJointStates().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getImuStates().size(); ++i0)
      {
          current_alignment += alex_msgs.msg.dds.IMUStatePubSubType.getCdrSerializedSize(data.getImuStates().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getFtStates().size(); ++i0)
      {
          current_alignment += alex_msgs.msg.dds.ForceTorqueStatePubSubType.getCdrSerializedSize(data.getFtStates().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.AlexState data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(data.getTime());

      cdr.write_type_7(data.getIsFaulted());

      cdr.write_type_7(data.getIsCalibrated());

      cdr.write_type_7(data.getAreActuatorsEnabled());

      cdr.write_type_7(data.getSafePowerUpComplete());

      cdr.write_type_7(data.getSafePowerDownComplete());

      cdr.write_type_6(data.getCurrentLowLevelMasterGain());

      if(data.getJointStates().size() <= 50)
      cdr.write_type_e(data.getJointStates());else
          throw new RuntimeException("joint_states field exceeds the maximum length: %d > %d".formatted(data.getJointStates().size(), 50));

      cdr.write_type_4(data.getNumberOfJoints());

      if(data.getImuStates().size() <= 50)
      cdr.write_type_e(data.getImuStates());else
          throw new RuntimeException("imu_states field exceeds the maximum length: %d > %d".formatted(data.getImuStates().size(), 50));

      cdr.write_type_4(data.getNumberOfImus());

      if(data.getFtStates().size() <= 50)
      cdr.write_type_e(data.getFtStates());else
          throw new RuntimeException("ft_states field exceeds the maximum length: %d > %d".formatted(data.getFtStates().size(), 50));

      cdr.write_type_4(data.getNumberOfFts());

   }

   public static void read(alex_msgs.msg.dds.AlexState data, us.ihmc.idl.CDR cdr)
   {
      data.setTime(cdr.read_type_6());
      	
      data.setIsFaulted(cdr.read_type_7());
      	
      data.setIsCalibrated(cdr.read_type_7());
      	
      data.setAreActuatorsEnabled(cdr.read_type_7());
      	
      data.setSafePowerUpComplete(cdr.read_type_7());
      	
      data.setSafePowerDownComplete(cdr.read_type_7());
      	
      data.setCurrentLowLevelMasterGain(cdr.read_type_6());
      	
      cdr.read_type_e(data.getJointStates());	
      data.setNumberOfJoints(cdr.read_type_4());
      	
      cdr.read_type_e(data.getImuStates());	
      data.setNumberOfImus(cdr.read_type_4());
      	
      cdr.read_type_e(data.getFtStates());	
      data.setNumberOfFts(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.AlexState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("time", data.getTime());
      ser.write_type_7("is_faulted", data.getIsFaulted());
      ser.write_type_7("is_calibrated", data.getIsCalibrated());
      ser.write_type_7("are_actuators_enabled", data.getAreActuatorsEnabled());
      ser.write_type_7("safe_power_up_complete", data.getSafePowerUpComplete());
      ser.write_type_7("safe_power_down_complete", data.getSafePowerDownComplete());
      ser.write_type_6("current_low_level_master_gain", data.getCurrentLowLevelMasterGain());
      ser.write_type_e("joint_states", data.getJointStates());
      ser.write_type_4("number_of_joints", data.getNumberOfJoints());
      ser.write_type_e("imu_states", data.getImuStates());
      ser.write_type_4("number_of_imus", data.getNumberOfImus());
      ser.write_type_e("ft_states", data.getFtStates());
      ser.write_type_4("number_of_fts", data.getNumberOfFts());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.AlexState data)
   {
      data.setTime(ser.read_type_6("time"));
      data.setIsFaulted(ser.read_type_7("is_faulted"));
      data.setIsCalibrated(ser.read_type_7("is_calibrated"));
      data.setAreActuatorsEnabled(ser.read_type_7("are_actuators_enabled"));
      data.setSafePowerUpComplete(ser.read_type_7("safe_power_up_complete"));
      data.setSafePowerDownComplete(ser.read_type_7("safe_power_down_complete"));
      data.setCurrentLowLevelMasterGain(ser.read_type_6("current_low_level_master_gain"));
      ser.read_type_e("joint_states", data.getJointStates());
      data.setNumberOfJoints(ser.read_type_4("number_of_joints"));
      ser.read_type_e("imu_states", data.getImuStates());
      data.setNumberOfImus(ser.read_type_4("number_of_imus"));
      ser.read_type_e("ft_states", data.getFtStates());
      data.setNumberOfFts(ser.read_type_4("number_of_fts"));
   }

   public static void staticCopy(alex_msgs.msg.dds.AlexState src, alex_msgs.msg.dds.AlexState dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.AlexState createData()
   {
      return new alex_msgs.msg.dds.AlexState();
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
   
   public void serialize(alex_msgs.msg.dds.AlexState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.AlexState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.AlexState src, alex_msgs.msg.dds.AlexState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexStatePubSubType newInstance()
   {
      return new AlexStatePubSubType();
   }
}
