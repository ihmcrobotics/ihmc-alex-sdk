package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "AlexanderStartupStatus" defined in "AlexanderStartupStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from AlexanderStartupStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit AlexanderStartupStatus_.idl instead.
*
*/
public class AlexanderStartupStatusPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.AlexanderStartupStatus>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::AlexanderStartupStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "a443c13126796461bf5a059b3dd4bd0d97f1bdb00396b766071b57519818362c";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.AlexanderStartupStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.AlexanderStartupStatus data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderStartupStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.AlexanderStartupStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.AlexanderStartupStatus data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getRobotIsFaulted());

      cdr.write_type_7(data.getRobotIsServod());

      cdr.write_type_7(data.getRobotIsCalibrated());

      cdr.write_type_7(data.getPublishingToRobotIsEnabled());

      cdr.write_type_7(data.getActuatorsAreEnabled());

      cdr.write_type_6(data.getCurrentMasterGain());

   }

   public static void read(alexander_msgs.msg.dds.AlexanderStartupStatus data, us.ihmc.idl.CDR cdr)
   {
      data.setRobotIsFaulted(cdr.read_type_7());
      	
      data.setRobotIsServod(cdr.read_type_7());
      	
      data.setRobotIsCalibrated(cdr.read_type_7());
      	
      data.setPublishingToRobotIsEnabled(cdr.read_type_7());
      	
      data.setActuatorsAreEnabled(cdr.read_type_7());
      	
      data.setCurrentMasterGain(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.AlexanderStartupStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("robot_is_faulted", data.getRobotIsFaulted());
      ser.write_type_7("robot_is_servod", data.getRobotIsServod());
      ser.write_type_7("robot_is_calibrated", data.getRobotIsCalibrated());
      ser.write_type_7("publishing_to_robot_is_enabled", data.getPublishingToRobotIsEnabled());
      ser.write_type_7("actuators_are_enabled", data.getActuatorsAreEnabled());
      ser.write_type_6("current_master_gain", data.getCurrentMasterGain());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.AlexanderStartupStatus data)
   {
      data.setRobotIsFaulted(ser.read_type_7("robot_is_faulted"));
      data.setRobotIsServod(ser.read_type_7("robot_is_servod"));
      data.setRobotIsCalibrated(ser.read_type_7("robot_is_calibrated"));
      data.setPublishingToRobotIsEnabled(ser.read_type_7("publishing_to_robot_is_enabled"));
      data.setActuatorsAreEnabled(ser.read_type_7("actuators_are_enabled"));
      data.setCurrentMasterGain(ser.read_type_6("current_master_gain"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.AlexanderStartupStatus src, alexander_msgs.msg.dds.AlexanderStartupStatus dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.AlexanderStartupStatus createData()
   {
      return new alexander_msgs.msg.dds.AlexanderStartupStatus();
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
   
   public void serialize(alexander_msgs.msg.dds.AlexanderStartupStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.AlexanderStartupStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.AlexanderStartupStatus src, alexander_msgs.msg.dds.AlexanderStartupStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public AlexanderStartupStatusPubSubType newInstance()
   {
      return new AlexanderStartupStatusPubSubType();
   }
}
