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
public class PollVoteRecord
{
   private int accountId;        // who voted 
   private int pollId;           // what poll
   private int outcomeId;        // what outcome was voted for
   private Calendar timestamp;   // time they voted.
   
   public int getAccountId()
   {
      return this.accountId;
   }
   
   public void setAccountId(int _accountId)
   {
      this.accountId = _accountId;
   }
   
   public int getPollId()
   {
      return this.pollId;
   }
   
   public void setPollId(int _pollId)
   {
      this.pollId = _pollId;
   }
   
   public int getOutcomeId()
   {
      return this.outcomeId;
   }
   
   public void setOutcomeId(int _outcomeId)
   {
      this.outcomeId = _outcomeId;
   }
   
   public Calendar getTimestamp()
   {
      return this.timestamp;
   }
   
   public void setTimestamp(Calendar _timestamp)
   {
      this.timestamp = _timestamp;
   }
}
/*
 * 
 * $Log: PollVoteRecord.java,v $
 * Revision 1.2  2005/03/26 19:17:12  brian
 * Added footer.
 *
 * 
 */