/*
 * Created on May 18, 2004
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
public class Poll
{
   private int id;
   private int createdBy; // who created the poll
   private String pollQuestion;
   private PollOutcome outcomes[];
   private Calendar timestamp;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getCreatedBy()
   {
      return this.createdBy;
   }
   
   public void setCreatedBy(int _createdBy)
   {
      this.createdBy = _createdBy;
   }
   
   public String getPollQuestion()
   {
      return this.pollQuestion;
   }
   
   public void setPollQuestion(String _pollQuestion)
   {
      this.pollQuestion = _pollQuestion;
   }
   
   public PollOutcome[] getOutcomes()
   {
      return this.outcomes;
   }
   
   public void setOutcomes(PollOutcome _outcomes[])
   {
      this.outcomes = _outcomes;
   }
   
   public Calendar getTimestamp()
   {
      return timestamp;
   }
   
   public void setTimestamp(Calendar _timestamp)
   {
      this.timestamp = _timestamp;
   }
}
/*
 * 
 * $Log: Poll.java,v $
 * Revision 1.2  2005/03/26 19:13:07  brian
 * Added footer.
 *
 * 
 */