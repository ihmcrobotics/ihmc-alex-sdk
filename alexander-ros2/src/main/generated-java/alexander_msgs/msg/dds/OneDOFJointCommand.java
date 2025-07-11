package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Sets the desireds for controlling each 1DOF joint
       */
public class OneDOFJointCommand extends Packet<OneDOFJointCommand> implements Settable<OneDOFJointCommand>, EpsilonComparable<OneDOFJointCommand>
{
   public java.lang.StringBuilder joint_name_;
   /**
            * Joint Desireds
            */
   public double q_des_;
   public double qd_des_;
   public double tau_des_;
   public double stiffness_;
   public double damping_;
   public double max_position_error_;
   public double max_velocity_error_;
   public double max_torque_;
   /**
            * Enable Actuator Command
            */
   public boolean enable_;
   /**
            * Joint control type, 0 is Position, 1 is Velocity, 2 is Effort, 3 disables the control
            */
   public byte joint_control_type_;

   public OneDOFJointCommand()
   {
      joint_name_ = new java.lang.StringBuilder(32);
   }

   public OneDOFJointCommand(OneDOFJointCommand other)
   {
      this();
      set(other);
   }

   public void set(OneDOFJointCommand other)
   {
      joint_name_.setLength(0);
      joint_name_.append(other.joint_name_);

      q_des_ = other.q_des_;

      qd_des_ = other.qd_des_;

      tau_des_ = other.tau_des_;

      stiffness_ = other.stiffness_;

      damping_ = other.damping_;

      max_position_error_ = other.max_position_error_;

      max_velocity_error_ = other.max_velocity_error_;

      max_torque_ = other.max_torque_;

      enable_ = other.enable_;

      joint_control_type_ = other.joint_control_type_;

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
            * Joint Desireds
            */
   public void setQDes(double q_des)
   {
      q_des_ = q_des;
   }
   /**
            * Joint Desireds
            */
   public double getQDes()
   {
      return q_des_;
   }

   public void setQdDes(double qd_des)
   {
      qd_des_ = qd_des;
   }
   public double getQdDes()
   {
      return qd_des_;
   }

   public void setTauDes(double tau_des)
   {
      tau_des_ = tau_des;
   }
   public double getTauDes()
   {
      return tau_des_;
   }

   public void setStiffness(double stiffness)
   {
      stiffness_ = stiffness;
   }
   public double getStiffness()
   {
      return stiffness_;
   }

   public void setDamping(double damping)
   {
      damping_ = damping;
   }
   public double getDamping()
   {
      return damping_;
   }

   public void setMaxPositionError(double max_position_error)
   {
      max_position_error_ = max_position_error;
   }
   public double getMaxPositionError()
   {
      return max_position_error_;
   }

   public void setMaxVelocityError(double max_velocity_error)
   {
      max_velocity_error_ = max_velocity_error;
   }
   public double getMaxVelocityError()
   {
      return max_velocity_error_;
   }

   public void setMaxTorque(double max_torque)
   {
      max_torque_ = max_torque;
   }
   public double getMaxTorque()
   {
      return max_torque_;
   }

   /**
            * Enable Actuator Command
            */
   public void setEnable(boolean enable)
   {
      enable_ = enable;
   }
   /**
            * Enable Actuator Command
            */
   public boolean getEnable()
   {
      return enable_;
   }

   /**
            * Joint control type, 0 is Position, 1 is Velocity, 2 is Effort, 3 disables the control
            */
   public void setJointControlType(byte joint_control_type)
   {
      joint_control_type_ = joint_control_type;
   }
   /**
            * Joint control type, 0 is Position, 1 is Velocity, 2 is Effort, 3 disables the control
            */
   public byte getJointControlType()
   {
      return joint_control_type_;
   }


   public static Supplier<OneDOFJointCommandPubSubType> getPubSubType()
   {
      return OneDOFJointCommandPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return OneDOFJointCommandPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(OneDOFJointCommand other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.joint_name_, other.joint_name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.q_des_, other.q_des_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.qd_des_, other.qd_des_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.tau_des_, other.tau_des_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.stiffness_, other.stiffness_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.damping_, other.damping_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_position_error_, other.max_position_error_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_velocity_error_, other.max_velocity_error_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_torque_, other.max_torque_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.enable_, other.enable_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.joint_control_type_, other.joint_control_type_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof OneDOFJointCommand)) return false;

      OneDOFJointCommand otherMyClass = (OneDOFJointCommand) other;

      if (!us.ihmc.idl.IDLTools.equals(this.joint_name_, otherMyClass.joint_name_)) return false;

      if(this.q_des_ != otherMyClass.q_des_) return false;

      if(this.qd_des_ != otherMyClass.qd_des_) return false;

      if(this.tau_des_ != otherMyClass.tau_des_) return false;

      if(this.stiffness_ != otherMyClass.stiffness_) return false;

      if(this.damping_ != otherMyClass.damping_) return false;

      if(this.max_position_error_ != otherMyClass.max_position_error_) return false;

      if(this.max_velocity_error_ != otherMyClass.max_velocity_error_) return false;

      if(this.max_torque_ != otherMyClass.max_torque_) return false;

      if(this.enable_ != otherMyClass.enable_) return false;

      if(this.joint_control_type_ != otherMyClass.joint_control_type_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("OneDOFJointCommand {");
      builder.append("joint_name=");
      builder.append(this.joint_name_);      builder.append(", ");
      builder.append("q_des=");
      builder.append(this.q_des_);      builder.append(", ");
      builder.append("qd_des=");
      builder.append(this.qd_des_);      builder.append(", ");
      builder.append("tau_des=");
      builder.append(this.tau_des_);      builder.append(", ");
      builder.append("stiffness=");
      builder.append(this.stiffness_);      builder.append(", ");
      builder.append("damping=");
      builder.append(this.damping_);      builder.append(", ");
      builder.append("max_position_error=");
      builder.append(this.max_position_error_);      builder.append(", ");
      builder.append("max_velocity_error=");
      builder.append(this.max_velocity_error_);      builder.append(", ");
      builder.append("max_torque=");
      builder.append(this.max_torque_);      builder.append(", ");
      builder.append("enable=");
      builder.append(this.enable_);      builder.append(", ");
      builder.append("joint_control_type=");
      builder.append(this.joint_control_type_);
      builder.append("}");
      return builder.toString();
   }
}
