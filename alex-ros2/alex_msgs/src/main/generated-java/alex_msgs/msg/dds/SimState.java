package alex_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class SimState extends Packet<SimState> implements Settable<SimState>, EpsilonComparable<SimState>
{
   public float sim_realtime_rate_;
   public float physics_realtime_rate_;
   public float dwell_duration_;

   public SimState()
   {
   }

   public SimState(SimState other)
   {
      this();
      set(other);
   }

   public void set(SimState other)
   {
      sim_realtime_rate_ = other.sim_realtime_rate_;

      physics_realtime_rate_ = other.physics_realtime_rate_;

      dwell_duration_ = other.dwell_duration_;

   }

   public void setSimRealtimeRate(float sim_realtime_rate)
   {
      sim_realtime_rate_ = sim_realtime_rate;
   }
   public float getSimRealtimeRate()
   {
      return sim_realtime_rate_;
   }

   public void setPhysicsRealtimeRate(float physics_realtime_rate)
   {
      physics_realtime_rate_ = physics_realtime_rate;
   }
   public float getPhysicsRealtimeRate()
   {
      return physics_realtime_rate_;
   }

   public void setDwellDuration(float dwell_duration)
   {
      dwell_duration_ = dwell_duration;
   }
   public float getDwellDuration()
   {
      return dwell_duration_;
   }


   public static Supplier<SimStatePubSubType> getPubSubType()
   {
      return SimStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return SimStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(SimState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sim_realtime_rate_, other.sim_realtime_rate_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.physics_realtime_rate_, other.physics_realtime_rate_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.dwell_duration_, other.dwell_duration_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof SimState)) return false;

      SimState otherMyClass = (SimState) other;

      if(this.sim_realtime_rate_ != otherMyClass.sim_realtime_rate_) return false;

      if(this.physics_realtime_rate_ != otherMyClass.physics_realtime_rate_) return false;

      if(this.dwell_duration_ != otherMyClass.dwell_duration_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SimState {");
      builder.append("sim_realtime_rate=");
      builder.append(this.sim_realtime_rate_);      builder.append(", ");
      builder.append("physics_realtime_rate=");
      builder.append(this.physics_realtime_rate_);      builder.append(", ");
      builder.append("dwell_duration=");
      builder.append(this.dwell_duration_);
      builder.append("}");
      return builder.toString();
   }
}
