package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "SimCmd" defined in "SimCmd_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from SimCmd_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit SimCmd_.idl instead.
*
*/
public class SimCmdPubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.SimCmd>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::SimCmd_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "39ecf82f57c212bff3c90d41398b55e197b711b7b5e36805e9db522550a92d59";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.SimCmd data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.SimCmd data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.SimCmd data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.SimCmd data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.SimCmd data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_5(data.getControlDt());

   }

   public static void read(alex_msgs.msg.dds.SimCmd data, us.ihmc.idl.CDR cdr)
   {
      data.setControlDt(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.SimCmd data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_5("control_dt", data.getControlDt());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.SimCmd data)
   {
      data.setControlDt(ser.read_type_5("control_dt"));   }

   public static void staticCopy(alex_msgs.msg.dds.SimCmd src, alex_msgs.msg.dds.SimCmd dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.SimCmd createData()
   {
      return new alex_msgs.msg.dds.SimCmd();
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
   
   public void serialize(alex_msgs.msg.dds.SimCmd data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.SimCmd data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.SimCmd src, alex_msgs.msg.dds.SimCmd dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public SimCmdPubSubType newInstance()
   {
      return new SimCmdPubSubType();
   }
}
