package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexanderCommand" defined in "AlexanderCommand_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexanderCommand_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexanderCommand_.idl instead.
*
*/
public class AlexanderCommandPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.AlexanderCommand>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::AlexanderCommand_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "98a92767d58e4b8900edacf4db18dcdfcfb8db57905db0656ceea14142f7e00d";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.AlexanderCommand data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.AlexanderCommand data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.OneDOFJointCommandPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderCommand data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderCommand data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJointCommands().size(); ++i0)
      {
          current_alignment += alexander_msgs.msg.dds.OneDOFJointCommandPubSubType.getCdrSerializedSize(data.getJointCommands().get(i0), current_alignment);}

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.AlexanderCommand data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getEnableActuators());

      cdr.write_type_7(data.getClearFaults());

      cdr.write_type_7(data.getCalibrate());

      cdr.write_type_9(data.getRobotControlState());

      cdr.write_type_4(data.getNumberOfJoints());

      if(data.getJointCommands().size() <= 50)
      cdr.write_type_e(data.getJointCommands());else
          throw new RuntimeException("joint_commands field exceeds the maximum length: %d > %d".formatted(data.getJointCommands().size(), 50));

      cdr.write_type_6(data.getLowLevelMasterGain());

   }

   public static void read(alexander_msgs.msg.dds.AlexanderCommand data, us.ihmc.idl.CDR cdr)
   {
      data.setEnableActuators(cdr.read_type_7());
      	
      data.setClearFaults(cdr.read_type_7());
      	
      data.setCalibrate(cdr.read_type_7());
      	
      data.setRobotControlState(cdr.read_type_9());
      	
      data.setNumberOfJoints(cdr.read_type_4());
      	
      cdr.read_type_e(data.getJointCommands());	
      data.setLowLevelMasterGain(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.AlexanderCommand data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("enable_actuators", data.getEnableActuators());
      ser.write_type_7("clear_faults", data.getClearFaults());
      ser.write_type_7("calibrate", data.getCalibrate());
      ser.write_type_9("robot_control_state", data.getRobotControlState());
      ser.write_type_4("number_of_joints", data.getNumberOfJoints());
      ser.write_type_e("joint_commands", data.getJointCommands());
      ser.write_type_6("low_level_master_gain", data.getLowLevelMasterGain());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.AlexanderCommand data)
   {
      data.setEnableActuators(ser.read_type_7("enable_actuators"));
      data.setClearFaults(ser.read_type_7("clear_faults"));
      data.setCalibrate(ser.read_type_7("calibrate"));
      data.setRobotControlState(ser.read_type_9("robot_control_state"));
      data.setNumberOfJoints(ser.read_type_4("number_of_joints"));
      ser.read_type_e("joint_commands", data.getJointCommands());
      data.setLowLevelMasterGain(ser.read_type_6("low_level_master_gain"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.AlexanderCommand src, alexander_msgs.msg.dds.AlexanderCommand dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.AlexanderCommand createData()
   {
      return new alexander_msgs.msg.dds.AlexanderCommand();
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
   
   public void serialize(alexander_msgs.msg.dds.AlexanderCommand data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.AlexanderCommand data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.AlexanderCommand src, alexander_msgs.msg.dds.AlexanderCommand dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexanderCommandPubSubType newInstance()
   {
      return new AlexanderCommandPubSubType();
   }
}
