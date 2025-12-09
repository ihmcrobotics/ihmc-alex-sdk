package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ForceTorqueState" defined in "ForceTorqueState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ForceTorqueState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ForceTorqueState_.idl instead.
*
*/
public class ForceTorqueStatePubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.ForceTorqueState>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::ForceTorqueState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "44e6c4c59075193516ab2b7fd3b849bc63c883e61c6b66209f96e2de4dd7996e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.ForceTorqueState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.ForceTorqueState data) throws java.io.IOException
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
      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.ForceTorqueState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.ForceTorqueState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getSensorName().length() + 1;

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.ForceTorqueState data, us.ihmc.idl.CDR cdr)
   {
      if(data.getSensorName().length() <= 32)
      cdr.write_type_d(data.getSensorName());else
          throw new RuntimeException("sensor_name field exceeds the maximum length: %d > %d".formatted(data.getSensorName().length(), 32));

      for(int i0 = 0; i0 < data.getForce().length; ++i0)
      {
        	cdr.write_type_6(data.getForce()[i0]);	
      }

      for(int i0 = 0; i0 < data.getTorque().length; ++i0)
      {
        	cdr.write_type_6(data.getTorque()[i0]);	
      }

      cdr.write_type_7(data.getIsOperational());

   }

   public static void read(alex_msgs.msg.dds.ForceTorqueState data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getSensorName());	
      for(int i0 = 0; i0 < data.getForce().length; ++i0)
      {
        	data.getForce()[i0] = cdr.read_type_6();
        	
      }
      	
      for(int i0 = 0; i0 < data.getTorque().length; ++i0)
      {
        	data.getTorque()[i0] = cdr.read_type_6();
        	
      }
      	
      data.setIsOperational(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.ForceTorqueState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("sensor_name", data.getSensorName());
      ser.write_type_f("force", data.getForce());
      ser.write_type_f("torque", data.getTorque());
      ser.write_type_7("is_operational", data.getIsOperational());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.ForceTorqueState data)
   {
      ser.read_type_d("sensor_name", data.getSensorName());
      ser.read_type_f("force", data.getForce());
      ser.read_type_f("torque", data.getTorque());
      data.setIsOperational(ser.read_type_7("is_operational"));
   }

   public static void staticCopy(alex_msgs.msg.dds.ForceTorqueState src, alex_msgs.msg.dds.ForceTorqueState dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.ForceTorqueState createData()
   {
      return new alex_msgs.msg.dds.ForceTorqueState();
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
   
   public void serialize(alex_msgs.msg.dds.ForceTorqueState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.ForceTorqueState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.ForceTorqueState src, alex_msgs.msg.dds.ForceTorqueState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ForceTorqueStatePubSubType newInstance()
   {
      return new ForceTorqueStatePubSubType();
   }
}
