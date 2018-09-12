/*
 * Created on May 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.pollManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dommoni.roundtable.Poll;
import com.dommoni.roundtable.PollOutcome;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PollManager implements IPollManager
{
   public void addPoll(Poll poll)
   {
      Connection connection = null;
      
      if(poll == null)
         return;
         
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ece", "root", "");
         PreparedStatement pstmt = connection.prepareStatement("insert into polls (created_by, poll_question) values (?, ?)");
         pstmt.setInt(1, poll.getCreatedBy());
         pstmt.setString(2, poll.getPollQuestion());
         pstmt.executeUpdate();
         
         // get poll id
         int pollId;
         pstmt = connection.prepareStatement("select LAST_INSERT_ID() from polls");
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            pollId = rs.getInt(1);
            pstmt = connection.prepareStatement("insert into poll_outcomes (poll_id, title) values (?, ?)");
            PollOutcome outcomes[] = poll.getOutcomes();
            for(int i = 0; i < outcomes.length; i++)
            {
               pstmt.setInt(1, pollId);
               pstmt.setString(2, outcomes[i].getTitle());
               pstmt.addBatch();
            }
            pstmt.executeBatch();
         }
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }
   
   public void dropPoll(int pollId)
   {
   }
   
   public void modifyPoll(Poll poll)
   {
   }
   
   public Poll getPoll(int pollId)
   {
      // be sure to add out the PVR's and set the vote count
      // in the outcomes... 
      Connection connection = null;
      
      return null;
   }
   
   public Poll[] getAllPollsForProject(int projectId)
   {
      return null;
   }
}
