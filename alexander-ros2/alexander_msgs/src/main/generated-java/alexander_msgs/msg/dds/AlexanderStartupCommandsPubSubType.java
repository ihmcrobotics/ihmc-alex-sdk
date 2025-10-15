package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexanderStartupCommands" defined in "AlexanderStartupCommands_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexanderStartupCommands_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexanderStartupCommands_.idl instead.
*
*/
public class AlexanderStartupCommandsPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.AlexanderStartupCommands>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::AlexanderStartupCommands_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "dce4e02c1a87c40910f149a2aef2500c46afb5ad23ce663cd9932ec4effd487d";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.AlexanderStartupCommands data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.AlexanderStartupCommands data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderStartupCommands data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderStartupCommands data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.AlexanderStartupCommands data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getEnablePublishingToRobot());

      cdr.write_type_7(data.getClearFaults());

      cdr.write_type_7(data.getEnableUserControlMode());

      cdr.write_type_7(data.getEnableActuators());

      cdr.write_type_7(data.getServoRobot());

      cdr.write_type_7(data.getUnservoQuickly());

      cdr.write_type_6(data.getMasterGain());

   }

   public static void read(alexander_msgs.msg.dds.AlexanderStartupCommands data, us.ihmc.idl.CDR cdr)
   {
      data.setEnablePublishingToRobot(cdr.read_type_7());
      	
      data.setClearFaults(cdr.read_type_7());
      	
      data.setEnableUserControlMode(cdr.read_type_7());
      	
      data.setEnableActuators(cdr.read_type_7());
      	
      data.setServoRobot(cdr.read_type_7());
      	
      data.setUnservoQuickly(cdr.read_type_7());
      	
      data.setMasterGain(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.AlexanderStartupCommands data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("enable_publishing_to_robot", data.getEnablePublishingToRobot());
      ser.write_type_7("clear_faults", data.getClearFaults());
      ser.write_type_7("enable_user_control_mode", data.getEnableUserControlMode());
      ser.write_type_7("enable_actuators", data.getEnableActuators());
      ser.write_type_7("servo_robot", data.getServoRobot());
      ser.write_type_7("unservo_quickly", data.getUnservoQuickly());
      ser.write_type_6("master_gain", data.getMasterGain());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.AlexanderStartupCommands data)
   {
      data.setEnablePublishingToRobot(ser.read_type_7("enable_publishing_to_robot"));
      data.setClearFaults(ser.read_type_7("clear_faults"));
      data.setEnableUserControlMode(ser.read_type_7("enable_user_control_mode"));
      data.setEnableActuators(ser.read_type_7("enable_actuators"));
      data.setServoRobot(ser.read_type_7("servo_robot"));
      data.setUnservoQuickly(ser.read_type_7("unservo_quickly"));
      data.setMasterGain(ser.read_type_6("master_gain"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.AlexanderStartupCommands src, alexander_msgs.msg.dds.AlexanderStartupCommands dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.AlexanderStartupCommands createData()
   {
      return new alexander_msgs.msg.dds.AlexanderStartupCommands();
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
   
   public void serialize(alexander_msgs.msg.dds.AlexanderStartupCommands data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.AlexanderStartupCommands data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.AlexanderStartupCommands src, alexander_msgs.msg.dds.AlexanderStartupCommands dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexanderStartupCommandsPubSubType newInstance()
   {
      return new AlexanderStartupCommandsPubSubType();
   }
}
