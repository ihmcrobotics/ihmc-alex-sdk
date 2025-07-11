package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "OneDOFJointState" defined in "OneDOFJointState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from OneDOFJointState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit OneDOFJointState_.idl instead.
*
*/
public class OneDOFJointStatePubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.OneDOFJointState>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::OneDOFJointState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "678cdbda8b93927e34201c5edb405d8e94e6b9dd965c6e07c9347075474faf85";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.OneDOFJointState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.OneDOFJointState data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 32 + 1;
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.OneDOFJointState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.OneDOFJointState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getJointName().length() + 1;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.OneDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      if(data.getJointName().length() <= 32)
      cdr.write_type_d(data.getJointName());else
          throw new RuntimeException("joint_name field exceeds the maximum length: %d > %d".formatted(data.getJointName().length(), 32));

      cdr.write_type_6(data.getQ());

      cdr.write_type_6(data.getQd());

      cdr.write_type_6(data.getTau());

      cdr.write_type_6(data.getActTemp());

      cdr.write_type_7(data.getIsOperational());

   }

   public static void read(alexander_msgs.msg.dds.OneDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getJointName());	
      data.setQ(cdr.read_type_6());
      	
      data.setQd(cdr.read_type_6());
      	
      data.setTau(cdr.read_type_6());
      	
      data.setActTemp(cdr.read_type_6());
      	
      data.setIsOperational(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.OneDOFJointState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("joint_name", data.getJointName());
      ser.write_type_6("q", data.getQ());
      ser.write_type_6("qd", data.getQd());
      ser.write_type_6("tau", data.getTau());
      ser.write_type_6("act_temp", data.getActTemp());
      ser.write_type_7("is_operational", data.getIsOperational());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.OneDOFJointState data)
   {
      ser.read_type_d("joint_name", data.getJointName());
      data.setQ(ser.read_type_6("q"));
      data.setQd(ser.read_type_6("qd"));
      data.setTau(ser.read_type_6("tau"));
      data.setActTemp(ser.read_type_6("act_temp"));
      data.setIsOperational(ser.read_type_7("is_operational"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.OneDOFJointState src, alexander_msgs.msg.dds.OneDOFJointState dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.OneDOFJointState createData()
   {
      return new alexander_msgs.msg.dds.OneDOFJointState();
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
   
   public void serialize(alexander_msgs.msg.dds.OneDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.OneDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.OneDOFJointState src, alexander_msgs.msg.dds.OneDOFJointState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public OneDOFJointStatePubSubType newInstance()
   {
      return new OneDOFJointStatePubSubType();
   }
}
