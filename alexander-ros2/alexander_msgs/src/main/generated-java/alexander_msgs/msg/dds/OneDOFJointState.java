package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Holds info for each 1DOF controlled Joint
       */
public class OneDOFJointState extends Packet<OneDOFJointState> implements Settable<OneDOFJointState>, EpsilonComparable<OneDOFJointState>
{
   public java.lang.StringBuilder joint_name_;
   /**
            * Joint Data
            */
   public double q_;
   public double qd_;
   public double tau_;
   /**
            * Actuator statuses
            */
   public double act_temp_;
   public boolean is_operational_;

   public OneDOFJointState()
   {
      joint_name_ = new java.lang.StringBuilder(35);
   }

   public OneDOFJointState(OneDOFJointState other)
   {
      this();
      set(other);
   }

   public void set(OneDOFJointState other)
   {
      joint_name_.setLength(0);
      joint_name_.append(other.joint_name_);

      q_ = other.q_;

      qd_ = other.qd_;

      tau_ = other.tau_;

      act_temp_ = other.act_temp_;

      is_operational_ = other.is_operational_;

   }

   public void setJointName(java.lang.String joint_name)
   {
      joint_name_.setLength(0);
      joint_name_.append(joint_name);
   }

   public java.lang.String getJointNameAsString()
   {
      return getJointName().toString();
   }
   public java.lang.StringBuilder getJointName()
   {
      return joint_name_;
   }

   /**
            * Joint Data
            */
   public void setQ(double q)
   {
      q_ = q;
   }
   /**
            * Joint Data
            */
   public double getQ()
   {
      return q_;
   }

   public void setQd(double qd)
   {
      qd_ = qd;
   }
   public double getQd()
   {
      return qd_;
   }

   public void setTau(double tau)
   {
      tau_ = tau;
   }
   public double getTau()
   {
      return tau_;
   }

   /**
            * Actuator statuses
            */
   public void setActTemp(double act_temp)
   {
      act_temp_ = act_temp;
   }
   /**
            * Actuator statuses
            */
   public double getActTemp()
   {
      return act_temp_;
   }

   public void setIsOperational(boolean is_operational)
   {
      is_operational_ = is_operational;
   }
   public boolean getIsOperational()
   {
      return is_operational_;
   }


   public static Supplier<OneDOFJointStatePubSubType> getPubSubType()
   {
      return OneDOFJointStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return OneDOFJointStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(OneDOFJointState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.joint_name_, other.joint_name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.q_, other.q_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.qd_, other.qd_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.tau_, other.tau_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.act_temp_, other.act_temp_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.is_operational_, other.is_operational_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof OneDOFJointState)) return false;

      OneDOFJointState otherMyClass = (OneDOFJointState) other;

      if (!us.ihmc.idl.IDLTools.equals(this.joint_name_, otherMyClass.joint_name_)) return false;

      if(this.q_ != otherMyClass.q_) return false;

      if(this.qd_ != otherMyClass.qd_) return false;

      if(this.tau_ != otherMyClass.tau_) return false;

      if(this.act_temp_ != otherMyClass.act_temp_) return false;

      if(this.is_operational_ != otherMyClass.is_operational_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("OneDOFJointState {");
      builder.append("joint_name=");
      builder.append(this.joint_name_);      builder.append(", ");
      builder.append("q=");
      builder.append(this.q_);      builder.append(", ");
      builder.append("qd=");
      builder.append(this.qd_);      builder.append(", ");
      builder.append("tau=");
      builder.append(this.tau_);      builder.append(", ");
      builder.append("act_temp=");
      builder.append(this.act_temp_);      builder.append(", ");
      builder.append("is_operational=");
      builder.append(this.is_operational_);
      builder.append("}");
      return builder.toString();
   }
}
