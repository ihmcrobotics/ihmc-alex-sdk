package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "SimState" defined in "SimState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from SimState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit SimState_.idl instead.
*
*/
public class SimStatePubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.SimState>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::SimState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "03e4fc4b36a6f1e17a23e81b43129a16a30076da76ffaa8be5bfda6f241fae36";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.SimState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.SimState data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.SimState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.SimState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.SimState data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_5(data.getSimRealtimeRate());

      cdr.write_type_5(data.getPhysicsRealtimeRate());

      cdr.write_type_5(data.getDwellDuration());

   }

   public static void read(alex_msgs.msg.dds.SimState data, us.ihmc.idl.CDR cdr)
   {
      data.setSimRealtimeRate(cdr.read_type_5());
      	
      data.setPhysicsRealtimeRate(cdr.read_type_5());
      	
      data.setDwellDuration(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.SimState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_5("sim_realtime_rate", data.getSimRealtimeRate());
      ser.write_type_5("physics_realtime_rate", data.getPhysicsRealtimeRate());
      ser.write_type_5("dwell_duration", data.getDwellDuration());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.SimState data)
   {
      data.setSimRealtimeRate(ser.read_type_5("sim_realtime_rate"));
      data.setPhysicsRealtimeRate(ser.read_type_5("physics_realtime_rate"));
      data.setDwellDuration(ser.read_type_5("dwell_duration"));
   }

   public static void staticCopy(alex_msgs.msg.dds.SimState src, alex_msgs.msg.dds.SimState dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.SimState createData()
   {
      return new alex_msgs.msg.dds.SimState();
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
   
   public void serialize(alex_msgs.msg.dds.SimState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.SimState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.SimState src, alex_msgs.msg.dds.SimState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public SimStatePubSubType newInstance()
   {
      return new SimStatePubSubType();
   }
}
