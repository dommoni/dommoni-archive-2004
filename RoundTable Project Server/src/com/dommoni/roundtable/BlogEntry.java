/*
 * Created on Mar 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BlogEntry
{
   private int id;
   private int userId;
   private int projectId;
   private String title;
   private Calendar entryDate;
   private String entry;
   private BlogEntryComment comments[];
}
/*
 * 
 * $Log: BlogEntry.java,v $
 * Revision 1.2  2005/03/23 09:06:25  brian
 * Added footer.
 *
 * 
 */