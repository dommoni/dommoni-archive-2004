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
public class MeetingAgendaItem
{
   private int id;
   private String title;
   private String notes;
   private int ordinal;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public String getTitle()
   {
      return this.title;
   }
   
   public void setTitle(String _title)
   {
      this.title = _title;
   }
   
   public String getNotes()
   {
      return this.notes;
   }
   
   public void setNotes(String _notes)
   {
      this.notes = _notes;
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
 * $Log: MeetingAgendaItem.java,v $
 * Revision 1.2  2005/03/26 19:02:44  brian
 * Added footer.
 *
 * 
 */