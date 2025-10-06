package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "IMUState" defined in "IMUState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IMUState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IMUState_.idl instead.
*
*/
public class IMUStatePubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.IMUState>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::IMUState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "0b081b32e122babfdeb44cef727c67dcb2c08019a64e642afa495b9164dfc7c5";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.IMUState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.IMUState data) throws java.io.IOException
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

      current_alignment += ((4) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.IMUState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.IMUState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getSensorName().length() + 1;

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((4) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.IMUState data, us.ihmc.idl.CDR cdr)
   {
      if(data.getSensorName().length() <= 32)
      cdr.write_type_d(data.getSensorName());else
          throw new RuntimeException("sensor_name field exceeds the maximum length: %d > %d".formatted(data.getSensorName().length(), 32));

      for(int i0 = 0; i0 < data.getPosition().length; ++i0)
      {
        	cdr.write_type_6(data.getPosition()[i0]);	
      }

      for(int i0 = 0; i0 < data.getQuaternion().length; ++i0)
      {
        	cdr.write_type_6(data.getQuaternion()[i0]);	
      }

      for(int i0 = 0; i0 < data.getGyroscope().length; ++i0)
      {
        	cdr.write_type_6(data.getGyroscope()[i0]);	
      }

      for(int i0 = 0; i0 < data.getAccelerometer().length; ++i0)
      {
        	cdr.write_type_6(data.getAccelerometer()[i0]);	
      }

      cdr.write_type_2(data.getTemperature());

      cdr.write_type_7(data.getIsOperational());

   }

   public static void read(alexander_msgs.msg.dds.IMUState data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getSensorName());	
      for(int i0 = 0; i0 < data.getPosition().length; ++i0)
      {
        	data.getPosition()[i0] = cdr.read_type_6();
        	
      }
      	
      for(int i0 = 0; i0 < data.getQuaternion().length; ++i0)
      {
        	data.getQuaternion()[i0] = cdr.read_type_6();
        	
      }
      	
      for(int i0 = 0; i0 < data.getGyroscope().length; ++i0)
      {
        	data.getGyroscope()[i0] = cdr.read_type_6();
        	
      }
      	
      for(int i0 = 0; i0 < data.getAccelerometer().length; ++i0)
      {
        	data.getAccelerometer()[i0] = cdr.read_type_6();
        	
      }
      	
      data.setTemperature(cdr.read_type_2());
      	
      data.setIsOperational(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.IMUState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("sensor_name", data.getSensorName());
      ser.write_type_f("position", data.getPosition());
      ser.write_type_f("quaternion", data.getQuaternion());
      ser.write_type_f("gyroscope", data.getGyroscope());
      ser.write_type_f("accelerometer", data.getAccelerometer());
      ser.write_type_2("temperature", data.getTemperature());
      ser.write_type_7("is_operational", data.getIsOperational());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.IMUState data)
   {
      ser.read_type_d("sensor_name", data.getSensorName());
      ser.read_type_f("position", data.getPosition());
      ser.read_type_f("quaternion", data.getQuaternion());
      ser.read_type_f("gyroscope", data.getGyroscope());
      ser.read_type_f("accelerometer", data.getAccelerometer());
      data.setTemperature(ser.read_type_2("temperature"));
      data.setIsOperational(ser.read_type_7("is_operational"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.IMUState src, alexander_msgs.msg.dds.IMUState dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.IMUState createData()
   {
      return new alexander_msgs.msg.dds.IMUState();
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
   
   public void serialize(alexander_msgs.msg.dds.IMUState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.IMUState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.IMUState src, alexander_msgs.msg.dds.IMUState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IMUStatePubSubType newInstance()
   {
      return new IMUStatePubSubType();
   }
}
