package alex_msgs.msg.dds;

/**
* 
* Topic data type of the struct "FortRoboticsRCHandheldState" defined in "FortRoboticsRCHandheldState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FortRoboticsRCHandheldState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FortRoboticsRCHandheldState_.idl instead.
*
*/
public class FortRoboticsRCHandheldStatePubSubType implements us.ihmc.pubsub.TopicDataType<alex_msgs.msg.dds.FortRoboticsRCHandheldState>
{
   public static final java.lang.String name = "alex_msgs::msg::dds_::FortRoboticsRCHandheldState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "eee51b5736c52f4d5483a7a5dd761e4e74667b9caba7e60e5a1092268d973c27";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, alex_msgs.msg.dds.FortRoboticsRCHandheldState data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.FortRoboticsRCHandheldState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(data.getLeftJoystickXNormalized());

      cdr.write_type_6(data.getLeftJoystickYNormalized());

      cdr.write_type_6(data.getRightJoystickXNormalized());

      cdr.write_type_6(data.getRightJoystickYNormalized());

      cdr.write_type_6(data.getLeftTriggerNormalized());

      cdr.write_type_6(data.getRightTriggerNormalized());

      cdr.write_type_7(data.getButton1Pressed());

      cdr.write_type_7(data.getButton2Pressed());

      cdr.write_type_7(data.getButton3Pressed());

      cdr.write_type_7(data.getButton4Pressed());

      cdr.write_type_7(data.getButtonUpPressed());

      cdr.write_type_7(data.getButtonDownPressed());

      cdr.write_type_7(data.getButtonLeftPressed());

      cdr.write_type_7(data.getButtonRightPressed());

      cdr.write_type_7(data.getEStopPressed());

   }

   public static void read(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, us.ihmc.idl.CDR cdr)
   {
      data.setLeftJoystickXNormalized(cdr.read_type_6());
      	
      data.setLeftJoystickYNormalized(cdr.read_type_6());
      	
      data.setRightJoystickXNormalized(cdr.read_type_6());
      	
      data.setRightJoystickYNormalized(cdr.read_type_6());
      	
      data.setLeftTriggerNormalized(cdr.read_type_6());
      	
      data.setRightTriggerNormalized(cdr.read_type_6());
      	
      data.setButton1Pressed(cdr.read_type_7());
      	
      data.setButton2Pressed(cdr.read_type_7());
      	
      data.setButton3Pressed(cdr.read_type_7());
      	
      data.setButton4Pressed(cdr.read_type_7());
      	
      data.setButtonUpPressed(cdr.read_type_7());
      	
      data.setButtonDownPressed(cdr.read_type_7());
      	
      data.setButtonLeftPressed(cdr.read_type_7());
      	
      data.setButtonRightPressed(cdr.read_type_7());
      	
      data.setEStopPressed(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("left_joystick_x_normalized", data.getLeftJoystickXNormalized());
      ser.write_type_6("left_joystick_y_normalized", data.getLeftJoystickYNormalized());
      ser.write_type_6("right_joystick_x_normalized", data.getRightJoystickXNormalized());
      ser.write_type_6("right_joystick_y_normalized", data.getRightJoystickYNormalized());
      ser.write_type_6("left_trigger_normalized", data.getLeftTriggerNormalized());
      ser.write_type_6("right_trigger_normalized", data.getRightTriggerNormalized());
      ser.write_type_7("button1_pressed", data.getButton1Pressed());
      ser.write_type_7("button2_pressed", data.getButton2Pressed());
      ser.write_type_7("button3_pressed", data.getButton3Pressed());
      ser.write_type_7("button4_pressed", data.getButton4Pressed());
      ser.write_type_7("button_up_pressed", data.getButtonUpPressed());
      ser.write_type_7("button_down_pressed", data.getButtonDownPressed());
      ser.write_type_7("button_left_pressed", data.getButtonLeftPressed());
      ser.write_type_7("button_right_pressed", data.getButtonRightPressed());
      ser.write_type_7("e_stop_pressed", data.getEStopPressed());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, alex_msgs.msg.dds.FortRoboticsRCHandheldState data)
   {
      data.setLeftJoystickXNormalized(ser.read_type_6("left_joystick_x_normalized"));
      data.setLeftJoystickYNormalized(ser.read_type_6("left_joystick_y_normalized"));
      data.setRightJoystickXNormalized(ser.read_type_6("right_joystick_x_normalized"));
      data.setRightJoystickYNormalized(ser.read_type_6("right_joystick_y_normalized"));
      data.setLeftTriggerNormalized(ser.read_type_6("left_trigger_normalized"));
      data.setRightTriggerNormalized(ser.read_type_6("right_trigger_normalized"));
      data.setButton1Pressed(ser.read_type_7("button1_pressed"));
      data.setButton2Pressed(ser.read_type_7("button2_pressed"));
      data.setButton3Pressed(ser.read_type_7("button3_pressed"));
      data.setButton4Pressed(ser.read_type_7("button4_pressed"));
      data.setButtonUpPressed(ser.read_type_7("button_up_pressed"));
      data.setButtonDownPressed(ser.read_type_7("button_down_pressed"));
      data.setButtonLeftPressed(ser.read_type_7("button_left_pressed"));
      data.setButtonRightPressed(ser.read_type_7("button_right_pressed"));
      data.setEStopPressed(ser.read_type_7("e_stop_pressed"));
   }

   public static void staticCopy(alex_msgs.msg.dds.FortRoboticsRCHandheldState src, alex_msgs.msg.dds.FortRoboticsRCHandheldState dest)
   {
      dest.set(src);
   }

   @Override
   public alex_msgs.msg.dds.FortRoboticsRCHandheldState createData()
   {
      return new alex_msgs.msg.dds.FortRoboticsRCHandheldState();
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
   
   public void serialize(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(alex_msgs.msg.dds.FortRoboticsRCHandheldState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(alex_msgs.msg.dds.FortRoboticsRCHandheldState src, alex_msgs.msg.dds.FortRoboticsRCHandheldState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FortRoboticsRCHandheldStatePubSubType newInstance()
   {
      return new FortRoboticsRCHandheldStatePubSubType();
   }
}
