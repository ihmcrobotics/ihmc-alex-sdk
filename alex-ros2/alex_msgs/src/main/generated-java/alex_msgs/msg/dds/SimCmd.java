package alex_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class SimCmd extends Packet<SimCmd> implements Settable<SimCmd>, EpsilonComparable<SimCmd>
{
   public float control_dt_;

   public SimCmd()
   {
   }

   public SimCmd(SimCmd other)
   {
      this();
      set(other);
   }

   public void set(SimCmd other)
   {
      control_dt_ = other.control_dt_;

   }

   public void setControlDt(float control_dt)
   {
      control_dt_ = control_dt;
   }
   public float getControlDt()
   {
      return control_dt_;
   }


   public static Supplier<SimCmdPubSubType> getPubSubType()
   {
      return SimCmdPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return SimCmdPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(SimCmd other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.control_dt_, other.control_dt_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof SimCmd)) return false;

      SimCmd otherMyClass = (SimCmd) other;

      if(this.control_dt_ != otherMyClass.control_dt_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SimCmd {");
      builder.append("control_dt=");
      builder.append(this.control_dt_);
      builder.append("}");
      return builder.toString();
   }
}
