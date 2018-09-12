/*
 * Created on May 18, 2004
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
public class PollOutcome
{
   private int id;
   private String title;
   private int votes;
   
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
   
   public int getVotes()
   {
      return this.votes;
   }
   
   public void setVotes(int _votes)
   {
      this.votes = _votes;
   }
}
/*
 * 
 * $Log: PollOutcome.java,v $
 * Revision 1.2  2005/03/26 19:17:01  brian
 * Added footer.
 *
 * 
 */