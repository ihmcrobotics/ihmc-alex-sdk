package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "OneDOFJointCommand" defined in "OneDOFJointCommand_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from OneDOFJointCommand_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit OneDOFJointCommand_.idl instead.
*
*/
public class OneDOFJointCommandPubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.OneDOFJointCommand>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::OneDOFJointCommand_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "ac5b15b16bd755230f099d4a89241b8127b71446b2c976c85c34fde6fac12902";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.OneDOFJointCommand data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.OneDOFJointCommand data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 35 + 1;
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.OneDOFJointCommand data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.OneDOFJointCommand data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getJointName().length() + 1;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.OneDOFJointCommand data, us.ihmc.idl.CDR cdr)
   {
      if(data.getJointName().length() <= 35)
      cdr.write_type_d(data.getJointName());else
          throw new RuntimeException("joint_name field exceeds the maximum length: %d > %d".formatted(data.getJointName().length(), 35));

      cdr.write_type_6(data.getQDes());

      cdr.write_type_6(data.getQdDes());

      cdr.write_type_6(data.getTauDes());

      cdr.write_type_6(data.getStiffness());

      cdr.write_type_6(data.getDamping());

      cdr.write_type_6(data.getMaxPositionError());

      cdr.write_type_6(data.getMaxVelocityError());

      cdr.write_type_6(data.getMaxTorque());

      cdr.write_type_7(data.getEnable());

      cdr.write_type_9(data.getJointControlType());

   }

   public static void read(alex_msgs.msg.dds.OneDOFJointCommand data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getJointName());	
      data.setQDes(cdr.read_type_6());
      	
      data.setQdDes(cdr.read_type_6());
      	
      data.setTauDes(cdr.read_type_6());
      	
      data.setStiffness(cdr.read_type_6());
      	
      data.setDamping(cdr.read_type_6());
      	
      data.setMaxPositionError(cdr.read_type_6());
      	
      data.setMaxVelocityError(cdr.read_type_6());
      	
      data.setMaxTorque(cdr.read_type_6());
      	
      data.setEnable(cdr.read_type_7());
      	
      data.setJointControlType(cdr.read_type_9());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.OneDOFJointCommand data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("joint_name", data.getJointName());
      ser.write_type_6("q_des", data.getQDes());
      ser.write_type_6("qd_des", data.getQdDes());
      ser.write_type_6("tau_des", data.getTauDes());
      ser.write_type_6("stiffness", data.getStiffness());
      ser.write_type_6("damping", data.getDamping());
      ser.write_type_6("max_position_error", data.getMaxPositionError());
      ser.write_type_6("max_velocity_error", data.getMaxVelocityError());
      ser.write_type_6("max_torque", data.getMaxTorque());
      ser.write_type_7("enable", data.getEnable());
      ser.write_type_9("joint_control_type", data.getJointControlType());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.OneDOFJointCommand data)
   {
      ser.read_type_d("joint_name", data.getJointName());
      data.setQDes(ser.read_type_6("q_des"));
      data.setQdDes(ser.read_type_6("qd_des"));
      data.setTauDes(ser.read_type_6("tau_des"));
      data.setStiffness(ser.read_type_6("stiffness"));
      data.setDamping(ser.read_type_6("damping"));
      data.setMaxPositionError(ser.read_type_6("max_position_error"));
      data.setMaxVelocityError(ser.read_type_6("max_velocity_error"));
      data.setMaxTorque(ser.read_type_6("max_torque"));
      data.setEnable(ser.read_type_7("enable"));
      data.setJointControlType(ser.read_type_9("joint_control_type"));
   }

   public static void staticCopy(alex_msgs.msg.dds.OneDOFJointCommand src, alex_msgs.msg.dds.OneDOFJointCommand dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.OneDOFJointCommand createData()
   {
      return new alex_msgs.msg.dds.OneDOFJointCommand();
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
   
   public void serialize(alex_msgs.msg.dds.OneDOFJointCommand data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.OneDOFJointCommand data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.OneDOFJointCommand src, alex_msgs.msg.dds.OneDOFJointCommand dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public OneDOFJointCommandPubSubType newInstance()
   {
      return new OneDOFJointCommandPubSubType();
   }
}
