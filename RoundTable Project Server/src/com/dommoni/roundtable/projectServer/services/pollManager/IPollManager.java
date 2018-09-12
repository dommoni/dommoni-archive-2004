/*
 * Created on May 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.pollManager;

import com.dommoni.roundtable.Poll;
import com.dommoni.roundtable.PollVoteRecord;

/**
 * Interface for supporting project based voting and polling. 
 * 
 * @author Brian Abbott
 */
public interface IPollManager
{
   public void addPoll(Poll poll);
   
   public void dropPoll(int pollId);
   
   public void modifyPoll(Poll poll);
   
   public Poll getPoll(int pollId);
   
   public Poll[] getAllPollsForProject(int projectId);
   
   // poll voting
   //addPollVoteRecord(PollVoteRecord pollVoteRecord);
   
   //getPollVoteRecordsForPoll(int pollId);
}
