/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Message
{
   public static final int SYSTEM_MESSAGE = 0x01;
   public static final int USER_MESSAGE = 0x02;
   public static final int NOTIFICATION_MESSAGE = 0x03;
   
   private int id;
   private int toId;
   private int fromId;
   private String text;
   private int type;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getToId()
   {
      return this.toId;
   }
   
   public void setToId(int _toId)
   {
      this.toId = _toId;
   }
   
   public int getFromId()
   {
      return this.fromId;
   }
   
   public void setFromId(int _fromId)
   {
      this.fromId = _fromId;
   }
   
   public String getText()
   {
      return this.text;
   }
   
   public void setText(String _text)
   {
      this.text = _text;
   }
   
   public int getType()
   {
      return this.type;
   }
   
   public void setType(int _type)
   {
      this.type = _type;
   }
}
/*
 * 
 * $Log: Message.java,v $
 * Revision 1.2  2005/03/26 19:03:25  brian
 * Added footer.
 *
 * 
 */
