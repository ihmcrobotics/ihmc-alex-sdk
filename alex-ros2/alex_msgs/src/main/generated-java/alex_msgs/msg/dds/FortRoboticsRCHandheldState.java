package alex_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class FortRoboticsRCHandheldState extends Packet<FortRoboticsRCHandheldState> implements Settable<FortRoboticsRCHandheldState>, EpsilonComparable<FortRoboticsRCHandheldState>
{
   /**
            * Normalized joystick values [-1.0 1.0]
            */
   public double left_joystick_x_normalized_;
   public double left_joystick_y_normalized_;
   public double right_joystick_x_normalized_;
   public double right_joystick_y_normalized_;
   /**
            * Normalized trigger values [-1.0 1.0]
            */
   public double left_trigger_normalized_;
   public double right_trigger_normalized_;
   /**
            * Button 1-4 (right side of controller)
            */
   public boolean button1_pressed_;
   public boolean button2_pressed_;
   public boolean button3_pressed_;
   public boolean button4_pressed_;
   /**
            * DPad (left side of controller)
            */
   public boolean button_up_pressed_;
   public boolean button_down_pressed_;
   public boolean button_left_pressed_;
   public boolean button_right_pressed_;
   /**
            * E-stop
            */
   public boolean e_stop_pressed_;
   /**
            * Battery
            */
   public int battery_level_;

   public FortRoboticsRCHandheldState()
   {
   }

   public FortRoboticsRCHandheldState(FortRoboticsRCHandheldState other)
   {
      this();
      set(other);
   }

   public void set(FortRoboticsRCHandheldState other)
   {
      left_joystick_x_normalized_ = other.left_joystick_x_normalized_;

      left_joystick_y_normalized_ = other.left_joystick_y_normalized_;

      right_joystick_x_normalized_ = other.right_joystick_x_normalized_;

      right_joystick_y_normalized_ = other.right_joystick_y_normalized_;

      left_trigger_normalized_ = other.left_trigger_normalized_;

      right_trigger_normalized_ = other.right_trigger_normalized_;

      button1_pressed_ = other.button1_pressed_;

      button2_pressed_ = other.button2_pressed_;

      button3_pressed_ = other.button3_pressed_;

      button4_pressed_ = other.button4_pressed_;

      button_up_pressed_ = other.button_up_pressed_;

      button_down_pressed_ = other.button_down_pressed_;

      button_left_pressed_ = other.button_left_pressed_;

      button_right_pressed_ = other.button_right_pressed_;

      e_stop_pressed_ = other.e_stop_pressed_;

      battery_level_ = other.battery_level_;

   }

   /**
            * Normalized joystick values [-1.0 1.0]
            */
   public void setLeftJoystickXNormalized(double left_joystick_x_normalized)
   {
      left_joystick_x_normalized_ = left_joystick_x_normalized;
   }
   /**
            * Normalized joystick values [-1.0 1.0]
            */
   public double getLeftJoystickXNormalized()
   {
      return left_joystick_x_normalized_;
   }

   public void setLeftJoystickYNormalized(double left_joystick_y_normalized)
   {
      left_joystick_y_normalized_ = left_joystick_y_normalized;
   }
   public double getLeftJoystickYNormalized()
   {
      return left_joystick_y_normalized_;
   }

   public void setRightJoystickXNormalized(double right_joystick_x_normalized)
   {
      right_joystick_x_normalized_ = right_joystick_x_normalized;
   }
   public double getRightJoystickXNormalized()
   {
      return right_joystick_x_normalized_;
   }

   public void setRightJoystickYNormalized(double right_joystick_y_normalized)
   {
      right_joystick_y_normalized_ = right_joystick_y_normalized;
   }
   public double getRightJoystickYNormalized()
   {
      return right_joystick_y_normalized_;
   }

   /**
            * Normalized trigger values [-1.0 1.0]
            */
   public void setLeftTriggerNormalized(double left_trigger_normalized)
   {
      left_trigger_normalized_ = left_trigger_normalized;
   }
   /**
            * Normalized trigger values [-1.0 1.0]
            */
   public double getLeftTriggerNormalized()
   {
      return left_trigger_normalized_;
   }

   public void setRightTriggerNormalized(double right_trigger_normalized)
   {
      right_trigger_normalized_ = right_trigger_normalized;
   }
   public double getRightTriggerNormalized()
   {
      return right_trigger_normalized_;
   }

   /**
            * Button 1-4 (right side of controller)
            */
   public void setButton1Pressed(boolean button1_pressed)
   {
      button1_pressed_ = button1_pressed;
   }
   /**
            * Button 1-4 (right side of controller)
            */
   public boolean getButton1Pressed()
   {
      return button1_pressed_;
   }

   public void setButton2Pressed(boolean button2_pressed)
   {
      button2_pressed_ = button2_pressed;
   }
   public boolean getButton2Pressed()
   {
      return button2_pressed_;
   }

   public void setButton3Pressed(boolean button3_pressed)
   {
      button3_pressed_ = button3_pressed;
   }
   public boolean getButton3Pressed()
   {
      return button3_pressed_;
   }

   public void setButton4Pressed(boolean button4_pressed)
   {
      button4_pressed_ = button4_pressed;
   }
   public boolean getButton4Pressed()
   {
      return button4_pressed_;
   }

   /**
            * DPad (left side of controller)
            */
   public void setButtonUpPressed(boolean button_up_pressed)
   {
      button_up_pressed_ = button_up_pressed;
   }
   /**
            * DPad (left side of controller)
            */
   public boolean getButtonUpPressed()
   {
      return button_up_pressed_;
   }

   public void setButtonDownPressed(boolean button_down_pressed)
   {
      button_down_pressed_ = button_down_pressed;
   }
   public boolean getButtonDownPressed()
   {
      return button_down_pressed_;
   }

   public void setButtonLeftPressed(boolean button_left_pressed)
   {
      button_left_pressed_ = button_left_pressed;
   }
   public boolean getButtonLeftPressed()
   {
      return button_left_pressed_;
   }

   public void setButtonRightPressed(boolean button_right_pressed)
   {
      button_right_pressed_ = button_right_pressed;
   }
   public boolean getButtonRightPressed()
   {
      return button_right_pressed_;
   }

   /**
            * E-stop
            */
   public void setEStopPressed(boolean e_stop_pressed)
   {
      e_stop_pressed_ = e_stop_pressed;
   }
   /**
            * E-stop
            */
   public boolean getEStopPressed()
   {
      return e_stop_pressed_;
   }

   /**
            * Battery
            */
   public void setBatteryLevel(int battery_level)
   {
      battery_level_ = battery_level;
   }
   /**
            * Battery
            */
   public int getBatteryLevel()
   {
      return battery_level_;
   }


   public static Supplier<FortRoboticsRCHandheldStatePubSubType> getPubSubType()
   {
      return FortRoboticsRCHandheldStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return FortRoboticsRCHandheldStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(FortRoboticsRCHandheldState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.left_joystick_x_normalized_, other.left_joystick_x_normalized_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.left_joystick_y_normalized_, other.left_joystick_y_normalized_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.right_joystick_x_normalized_, other.right_joystick_x_normalized_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.right_joystick_y_normalized_, other.right_joystick_y_normalized_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.left_trigger_normalized_, other.left_trigger_normalized_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.right_trigger_normalized_, other.right_trigger_normalized_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button1_pressed_, other.button1_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button2_pressed_, other.button2_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button3_pressed_, other.button3_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button4_pressed_, other.button4_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button_up_pressed_, other.button_up_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button_down_pressed_, other.button_down_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button_left_pressed_, other.button_left_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.button_right_pressed_, other.button_right_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.e_stop_pressed_, other.e_stop_pressed_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.battery_level_, other.battery_level_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof FortRoboticsRCHandheldState)) return false;

      FortRoboticsRCHandheldState otherMyClass = (FortRoboticsRCHandheldState) other;

      if(this.left_joystick_x_normalized_ != otherMyClass.left_joystick_x_normalized_) return false;

      if(this.left_joystick_y_normalized_ != otherMyClass.left_joystick_y_normalized_) return false;

      if(this.right_joystick_x_normalized_ != otherMyClass.right_joystick_x_normalized_) return false;

      if(this.right_joystick_y_normalized_ != otherMyClass.right_joystick_y_normalized_) return false;

      if(this.left_trigger_normalized_ != otherMyClass.left_trigger_normalized_) return false;

      if(this.right_trigger_normalized_ != otherMyClass.right_trigger_normalized_) return false;

      if(this.button1_pressed_ != otherMyClass.button1_pressed_) return false;

      if(this.button2_pressed_ != otherMyClass.button2_pressed_) return false;

      if(this.button3_pressed_ != otherMyClass.button3_pressed_) return false;

      if(this.button4_pressed_ != otherMyClass.button4_pressed_) return false;

      if(this.button_up_pressed_ != otherMyClass.button_up_pressed_) return false;

      if(this.button_down_pressed_ != otherMyClass.button_down_pressed_) return false;

      if(this.button_left_pressed_ != otherMyClass.button_left_pressed_) return false;

      if(this.button_right_pressed_ != otherMyClass.button_right_pressed_) return false;

      if(this.e_stop_pressed_ != otherMyClass.e_stop_pressed_) return false;

      if(this.battery_level_ != otherMyClass.battery_level_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("FortRoboticsRCHandheldState {");
      builder.append("left_joystick_x_normalized=");
      builder.append(this.left_joystick_x_normalized_);      builder.append(", ");
      builder.append("left_joystick_y_normalized=");
      builder.append(this.left_joystick_y_normalized_);      builder.append(", ");
      builder.append("right_joystick_x_normalized=");
      builder.append(this.right_joystick_x_normalized_);      builder.append(", ");
      builder.append("right_joystick_y_normalized=");
      builder.append(this.right_joystick_y_normalized_);      builder.append(", ");
      builder.append("left_trigger_normalized=");
      builder.append(this.left_trigger_normalized_);      builder.append(", ");
      builder.append("right_trigger_normalized=");
      builder.append(this.right_trigger_normalized_);      builder.append(", ");
      builder.append("button1_pressed=");
      builder.append(this.button1_pressed_);      builder.append(", ");
      builder.append("button2_pressed=");
      builder.append(this.button2_pressed_);      builder.append(", ");
      builder.append("button3_pressed=");
      builder.append(this.button3_pressed_);      builder.append(", ");
      builder.append("button4_pressed=");
      builder.append(this.button4_pressed_);      builder.append(", ");
      builder.append("button_up_pressed=");
      builder.append(this.button_up_pressed_);      builder.append(", ");
      builder.append("button_down_pressed=");
      builder.append(this.button_down_pressed_);      builder.append(", ");
      builder.append("button_left_pressed=");
      builder.append(this.button_left_pressed_);      builder.append(", ");
      builder.append("button_right_pressed=");
      builder.append(this.button_right_pressed_);      builder.append(", ");
      builder.append("e_stop_pressed=");
      builder.append(this.e_stop_pressed_);      builder.append(", ");
      builder.append("battery_level=");
      builder.append(this.battery_level_);
      builder.append("}");
      return builder.toString();
   }
}
