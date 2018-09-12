/*
 * Created on Apr 18, 2004
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
public class MeetingFollowupItem
{
   int id;
   int meetingId;
   /** Item Title */
   private String title;
   /** In-depth description */
   private String text;
   /** Order of occurence */
   private int ordinal;
   
  
   public String getTitle()
   {
      return this.title;
   }
   
   public void setTitle(String _title)
   {
      this.title = _title;
   }
   
   public String getText()
   {
      return this.text;
   }
   
   public void setText(String _text)
   {
      this.text = _text;
   }
   
   public int getOrdinal()
   {
      return this.ordinal;
   }
   
   public void setOrdinal(int _ordinal)
   {
      this.ordinal = _ordinal;
   }
}
/*
 * 
 * $Log: MeetingFollowupItem.java,v $
 * Revision 1.2  2005/03/26 19:03:00  brian
 * Added footer.
 *
 * 
 */