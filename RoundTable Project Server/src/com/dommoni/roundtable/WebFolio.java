/*
 * Created on Mar 24, 2004
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
public class WebFolio
{
   private int id;
   private String name;
   private WebFolioFolder collections[];
   private WebFolioEntry entries[];
   
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
   
   public WebFolioFolder[] getCollections()
   {
      return this.collections;
   }
   
   public void setCollections(WebFolioFolder[] _collections)
   {
      this.collections = _collections;
   }
   
   public WebFolioEntry[] getEntries()
   {
      return this.entries;
   }
   
   public void setEntries(WebFolioEntry _entries[])
   {
      this.entries = _entries;
   }
}
/*
 * 
 * $Log: WebFolio.java,v $
 * Revision 1.2  2005/03/26 19:18:35  brian
 * Added footer.
 *
 * 
 */