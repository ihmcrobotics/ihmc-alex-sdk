package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexanderStartupCommand" defined in "AlexanderStartupCommand_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexanderStartupCommand_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexanderStartupCommand_.idl instead.
*
*/
public class AlexanderStartupCommandPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.AlexanderStartupCommand>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::AlexanderStartupCommand_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "5975937dc64763201e6806932b6fc17f4dd2900516395dfe317f62649d825d93";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.AlexanderStartupCommand data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.AlexanderStartupCommand data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderStartupCommand data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderStartupCommand data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.AlexanderStartupCommand data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getEnablePublishingToRobot());

      cdr.write_type_7(data.getClearFaults());

      cdr.write_type_7(data.getCalibrateRobot());

      cdr.write_type_7(data.getEnableActuators());

      cdr.write_type_7(data.getServoRobot());

      cdr.write_type_7(data.getUnservoQuickly());

      cdr.write_type_7(data.getSetMasterGain());

      cdr.write_type_6(data.getDesiredMasterGain());

   }

   public static void read(alexander_msgs.msg.dds.AlexanderStartupCommand data, us.ihmc.idl.CDR cdr)
   {
      data.setEnablePublishingToRobot(cdr.read_type_7());
      	
      data.setClearFaults(cdr.read_type_7());
      	
      data.setCalibrateRobot(cdr.read_type_7());
      	
      data.setEnableActuators(cdr.read_type_7());
      	
      data.setServoRobot(cdr.read_type_7());
      	
      data.setUnservoQuickly(cdr.read_type_7());
      	
      data.setSetMasterGain(cdr.read_type_7());
      	
      data.setDesiredMasterGain(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.AlexanderStartupCommand data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("enable_publishing_to_robot", data.getEnablePublishingToRobot());
      ser.write_type_7("clear_faults", data.getClearFaults());
      ser.write_type_7("calibrate_robot", data.getCalibrateRobot());
      ser.write_type_7("enable_actuators", data.getEnableActuators());
      ser.write_type_7("servo_robot", data.getServoRobot());
      ser.write_type_7("unservo_quickly", data.getUnservoQuickly());
      ser.write_type_7("set_master_gain", data.getSetMasterGain());
      ser.write_type_6("desired_master_gain", data.getDesiredMasterGain());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.AlexanderStartupCommand data)
   {
      data.setEnablePublishingToRobot(ser.read_type_7("enable_publishing_to_robot"));
      data.setClearFaults(ser.read_type_7("clear_faults"));
      data.setCalibrateRobot(ser.read_type_7("calibrate_robot"));
      data.setEnableActuators(ser.read_type_7("enable_actuators"));
      data.setServoRobot(ser.read_type_7("servo_robot"));
      data.setUnservoQuickly(ser.read_type_7("unservo_quickly"));
      data.setSetMasterGain(ser.read_type_7("set_master_gain"));
      data.setDesiredMasterGain(ser.read_type_6("desired_master_gain"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.AlexanderStartupCommand src, alexander_msgs.msg.dds.AlexanderStartupCommand dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.AlexanderStartupCommand createData()
   {
      return new alexander_msgs.msg.dds.AlexanderStartupCommand();
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
   
   public void serialize(alexander_msgs.msg.dds.AlexanderStartupCommand data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.AlexanderStartupCommand data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.AlexanderStartupCommand src, alexander_msgs.msg.dds.AlexanderStartupCommand dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexanderStartupCommandPubSubType newInstance()
   {
      return new AlexanderStartupCommandPubSubType();
   }
}
