/*
 * Created on Mar 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.net.URL;
import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class WebFolioEntry
{
   private int id;
   private String name;
   private URL url;
   private String notes;
   private Calendar dateCreated;
   private int flag;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String _name)
   {
      this.name = _name;
   }
   
   public URL getUrl()
   {
      return this.url;
   }
   
   public void setUrl(URL _url)
   {
      this.url = _url;
   }
   
   public String getNotes()
   {
      return this.notes;
   }
   
   public void setNotes(String _notes)
   {
      this.notes = _notes;
   }
   
   public Calendar getDateCreated()
   {
      return this.dateCreated;
   }
   
   public void setDateCreated(Calendar _dateCreated)
   {
      this.dateCreated = _dateCreated;
   }
   
   public int getFlag()
   {
      return this.flag;
   }
   
   public void setFlag(int _flag)
   {
      this.flag = _flag;
   }
}
/*
 * 
 * $Log: WebFolioEntry.java,v $
 * Revision 1.2  2005/03/26 19:18:42  brian
 * Added footer.
 *
 * 
 */