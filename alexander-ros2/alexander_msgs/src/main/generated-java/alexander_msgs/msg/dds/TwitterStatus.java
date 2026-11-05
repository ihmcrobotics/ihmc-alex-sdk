package alexander_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class TwitterStatus extends Packet<TwitterStatus> implements Settable<TwitterStatus>, EpsilonComparable<TwitterStatus>
{
   /**
            * Holds the name of the twitter as well as the status and error code of that twitter
            */
   public java.lang.StringBuilder twitter_name_;
   public int status_code_;
   public int error_code_;

   public TwitterStatus()
   {
      twitter_name_ = new java.lang.StringBuilder(255);
   }

   public TwitterStatus(TwitterStatus other)
   {
      this();
      set(other);
   }

   public void set(TwitterStatus other)
   {
      twitter_name_.setLength(0);
      twitter_name_.append(other.twitter_name_);

      status_code_ = other.status_code_;

      error_code_ = other.error_code_;

   }

   /**
            * Holds the name of the twitter as well as the status and error code of that twitter
            */
   public void setTwitterName(java.lang.String twitter_name)
   {
      twitter_name_.setLength(0);
      twitter_name_.append(twitter_name);
   }

   /**
            * Holds the name of the twitter as well as the status and error code of that twitter
            */
   public java.lang.String getTwitterNameAsString()
   {
      return getTwitterName().toString();
   }
   /**
            * Holds the name of the twitter as well as the status and error code of that twitter
            */
   public java.lang.StringBuilder getTwitterName()
   {
      return twitter_name_;
   }

   public void setStatusCode(int status_code)
   {
      status_code_ = status_code;
   }
   public int getStatusCode()
   {
      return status_code_;
   }

   public void setErrorCode(int error_code)
   {
      error_code_ = error_code;
   }
   public int getErrorCode()
   {
      return error_code_;
   }


   public static Supplier<TwitterStatusPubSubType> getPubSubType()
   {
      return TwitterStatusPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TwitterStatusPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TwitterStatus other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.twitter_name_, other.twitter_name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.status_code_, other.status_code_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.error_code_, other.error_code_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TwitterStatus)) return false;

      TwitterStatus otherMyClass = (TwitterStatus) other;

      if (!us.ihmc.idl.IDLTools.equals(this.twitter_name_, otherMyClass.twitter_name_)) return false;

      if(this.status_code_ != otherMyClass.status_code_) return false;

      if(this.error_code_ != otherMyClass.error_code_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TwitterStatus {");
      builder.append("twitter_name=");
      builder.append(this.twitter_name_);      builder.append(", ");
      builder.append("status_code=");
      builder.append(this.status_code_);      builder.append(", ");
      builder.append("error_code=");
      builder.append(this.error_code_);
      builder.append("}");
      return builder.toString();
   }
}
