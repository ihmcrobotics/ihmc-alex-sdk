package alexander_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TwitterStatus" defined in "TwitterStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TwitterStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TwitterStatus_.idl instead.
*
*/
public class TwitterStatusPubSubType implements us.ihmc.pubsub.TopicDataType<alexander_msgs.msg.dds.TwitterStatus>
{
   public static final java.lang.String name = "alexander_msgs::msg::dds_::TwitterStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "f6f3c06074f441a4c6a3d9245e01f9e4945efed551d43eecfef5494da9f4a4ed";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alexander_msgs.msg.dds.TwitterStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alexander_msgs.msg.dds.TwitterStatus data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.TwitterStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alexander_msgs.msg.dds.TwitterStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getTwitterName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(alexander_msgs.msg.dds.TwitterStatus data, us.ihmc.idl.CDR cdr)
   {
      if(data.getTwitterName().length() <= 255)
      cdr.write_type_d(data.getTwitterName());else
          throw new RuntimeException("twitter_name field exceeds the maximum length: %d > %d".formatted(data.getTwitterName().length(), 255));

      cdr.write_type_2(data.getStatusCode());

      cdr.write_type_2(data.getErrorCode());

   }

   public static void read(alexander_msgs.msg.dds.TwitterStatus data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getTwitterName());	
      data.setStatusCode(cdr.read_type_2());
      	
      data.setErrorCode(cdr.read_type_2());
      	

   }

   @Override
   public final void serialize(alexander_msgs.msg.dds.TwitterStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("twitter_name", data.getTwitterName());
      ser.write_type_2("status_code", data.getStatusCode());
      ser.write_type_2("error_code", data.getErrorCode());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alexander_msgs.msg.dds.TwitterStatus data)
   {
      ser.read_type_d("twitter_name", data.getTwitterName());
      data.setStatusCode(ser.read_type_2("status_code"));
      data.setErrorCode(ser.read_type_2("error_code"));
   }

   public static void staticCopy(alexander_msgs.msg.dds.TwitterStatus src, alexander_msgs.msg.dds.TwitterStatus dest)
   {
      dest.set(src);
   }

   @Override
   public alexander_msgs.msg.dds.TwitterStatus createData()
   {
      return new alexander_msgs.msg.dds.TwitterStatus();
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
   
   public void serialize(alexander_msgs.msg.dds.TwitterStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alexander_msgs.msg.dds.TwitterStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alexander_msgs.msg.dds.TwitterStatus src, alexander_msgs.msg.dds.TwitterStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TwitterStatusPubSubType newInstance()
   {
      return new TwitterStatusPubSubType();
   }
}
