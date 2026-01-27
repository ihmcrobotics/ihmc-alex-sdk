package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexCommand" defined in "AlexCommand_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexCommand_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexCommand_.idl instead.
*
*/
public class AlexCommandPubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.AlexCommand>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::AlexCommand_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e19576563b9a09a2d516cf1d57b1acfe6561b9c952de39d48279595ddff73e8a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.AlexCommand data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.AlexCommand data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 50; ++i0)
      {
          current_alignment += alex_msgs.msg.dds.OneDOFJointCommandPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.AlexCommand data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.AlexCommand data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJointCommands().size(); ++i0)
      {
          current_alignment += alex_msgs.msg.dds.OneDOFJointCommandPubSubType.getCdrSerializedSize(data.getJointCommands().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.AlexCommand data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getEnableActuators());

      cdr.write_type_7(data.getClearFaults());

      cdr.write_type_7(data.getCalibrate());

      cdr.write_type_7(data.getServoActuators());

      cdr.write_type_7(data.getUnservoQuickly());

      cdr.write_type_9(data.getRobotControlState());

      cdr.write_type_4(data.getNumberOfJoints());

      if(data.getJointCommands().size() <= 50)
      cdr.write_type_e(data.getJointCommands());else
          throw new RuntimeException("joint_commands field exceeds the maximum length: %d > %d".formatted(data.getJointCommands().size(), 50));

   }

   public static void read(alex_msgs.msg.dds.AlexCommand data, us.ihmc.idl.CDR cdr)
   {
      data.setEnableActuators(cdr.read_type_7());
      	
      data.setClearFaults(cdr.read_type_7());
      	
      data.setCalibrate(cdr.read_type_7());
      	
      data.setServoActuators(cdr.read_type_7());
      	
      data.setUnservoQuickly(cdr.read_type_7());
      	
      data.setRobotControlState(cdr.read_type_9());
      	
      data.setNumberOfJoints(cdr.read_type_4());
      	
      cdr.read_type_e(data.getJointCommands());	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.AlexCommand data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("enable_actuators", data.getEnableActuators());
      ser.write_type_7("clear_faults", data.getClearFaults());
      ser.write_type_7("calibrate", data.getCalibrate());
      ser.write_type_7("servo_actuators", data.getServoActuators());
      ser.write_type_7("unservo_quickly", data.getUnservoQuickly());
      ser.write_type_9("robot_control_state", data.getRobotControlState());
      ser.write_type_4("number_of_joints", data.getNumberOfJoints());
      ser.write_type_e("joint_commands", data.getJointCommands());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.AlexCommand data)
   {
      data.setEnableActuators(ser.read_type_7("enable_actuators"));
      data.setClearFaults(ser.read_type_7("clear_faults"));
      data.setCalibrate(ser.read_type_7("calibrate"));
      data.setServoActuators(ser.read_type_7("servo_actuators"));
      data.setUnservoQuickly(ser.read_type_7("unservo_quickly"));
      data.setRobotControlState(ser.read_type_9("robot_control_state"));
      data.setNumberOfJoints(ser.read_type_4("number_of_joints"));
      ser.read_type_e("joint_commands", data.getJointCommands());
   }

   public static void staticCopy(alex_msgs.msg.dds.AlexCommand src, alex_msgs.msg.dds.AlexCommand dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.AlexCommand createData()
   {
      return new alex_msgs.msg.dds.AlexCommand();
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
   
   public void serialize(alex_msgs.msg.dds.AlexCommand data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.AlexCommand data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.AlexCommand src, alex_msgs.msg.dds.AlexCommand dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexCommandPubSubType newInstance()
   {
      return new AlexCommandPubSubType();
   }
}
