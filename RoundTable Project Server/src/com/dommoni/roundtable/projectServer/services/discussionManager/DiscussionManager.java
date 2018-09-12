/*
 * Created on May 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.discussionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.DiscussionMessage;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.commentManager.CommentManager;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DiscussionManager implements IDiscussionManager
{
	//public int addDiscussion(Event event, Discussion discussion)
   public int addDiscussion(Discussion discussion)
   throws Exception
   {
      Connection connection = null;
      int discussionId = -1;
      
      if(discussion == null)
      {   
         return -1; 
      } 
      
      // we dont want add it if no messages where transmitted.
      if(discussion.getMessages() == null)
      {   
         return -1; 
      } 
         
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into discussions (project_id, title, date) values (?,?,?)");
         pstmt.setInt(1, discussion.getProjectId());
         pstmt.setString(2, discussion.getTitle());
         
         if(discussion.getDate() != null)
         {
            pstmt.setDate(3, new Date(discussion.getDate().getTimeInMillis()));
         }
         else
         {
            pstmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
         }
         pstmt.executeUpdate();
         
         // pstmt = connection.prepareStatement("select LAST_INSERT_ID() from discussions", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from discussions", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            discussionId = rs.getInt(1);
            
            // Members
            pstmt = connection.prepareStatement("insert into discussion_members (discussion_id, account_id) values (?,?)");
            int memberIds[] = discussion.getMemberIds();
            for(int i = 0; i < memberIds.length; i++)
            {
               pstmt.setInt(1, discussionId);
               pstmt.setInt(2, memberIds[i]);
               pstmt.addBatch();
            }
            pstmt.executeBatch();
            
            // Messages
            pstmt = connection.prepareStatement("insert into discussion_messages (discussion_id, account_id, message_text) values (?, ?, ?)");
            DiscussionMessage messages[] = discussion.getMessages();
            for(int i = 0; i < messages.length; i++)
            {
               pstmt.setInt(1, discussionId);
               pstmt.setInt(2, messages[i].getAccountId());
               pstmt.setString(3, messages[i].getMessageText());
               
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
         }
      }
      return discussionId;
   }
   
   /*public int addDiscussion(Discussion discussion) 
   throws Exception
   {
      return this.addDiscussion(null, discussion);
   }*/
   //public void dropDiscussion(Event event, int discussionId)
   public void dropDiscussion(int discussionId)
   throws Exception
   {
      // not sure we want to do this...
      // it might be better to set discussions to "invisible" instead of deleting them.
      
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         
         PreparedStatement pstmt = connection.prepareStatement("delete from discussion_messages where discussion_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, discussionId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from discussion_members where discussion_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, discussionId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from discussions where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, discussionId);
         pstmt.executeUpdate();
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
   
   /*public void dropDiscussion(int discussionId)
   throws Exception
   {
      this.dropDiscussion(null, discussionId);
   }*/
   //public Discussion getDiscussion(Event event, int discussionId)
   public Discussion getDiscussion(int discussionId)
   throws Exception
   {
      Connection connection = null;
      Discussion discussion = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select project_id, title, date from discussions where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, discussionId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            discussion = new Discussion();
            discussion.setId(discussionId);
            discussion.setProjectId(rs.getInt(1));
            discussion.setTitle(rs.getString(2));
            
            if(rs.getDate(3) != null)
            {
               Calendar clDate = Calendar.getInstance();
               clDate.setTime(rs.getDate(3));
               discussion.setDate(clDate);
            }
            
            //
            // members...
            //
            pstmt = connection.prepareStatement("select account_id from discussion_members where discussion_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, discussionId);
            rs = pstmt.executeQuery();
            Vector vMemberIds = new Vector();
            while(rs.next()) 
            {
               vMemberIds.add(new Integer(rs.getInt(1)));
            }
            int memberIds[] = new int[vMemberIds.size()];  
            for(int i = 0; i < memberIds.length; i++)
            {
               memberIds[i] = ((Integer)vMemberIds.get(i)).intValue();
            }    
            discussion.setMemberIds(memberIds);
            
            //
            // messages...
            //
            pstmt = connection.prepareStatement("select account_id, message_text from discussion_messages where discussion_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, discussionId);
            rs = pstmt.executeQuery();
            Vector vMessages = new Vector();
            while(rs.next())
            {
               DiscussionMessage message = new DiscussionMessage();
               message.setAccountId(rs.getInt(1));
               message.setMessageText(rs.getString(2));
               vMessages.add(message);   
            }
            discussion.setMessages((DiscussionMessage[])vMessages.toArray(new DiscussionMessage[vMessages.size()]));
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
         }
      }
      
      return discussion;
   }
   
   /*public Discussion getDiscussion(int discussionId)
   throws Exception
   {
      return this.getDiscussion(null, discussionId);
   }*/
   //public Discussion[] getAllDiscussionsForProject(Event event, int projectId)
   public Discussion[] getAllDiscussionsForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      Vector discussions = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from discussions where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            discussions.add(getDiscussion(rs.getInt(1)));
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
      
      return (Discussion[])discussions.toArray(new Discussion[discussions.size()]);
   }
   
   /*public Discussion[] getAllDiscussionsForProject(int projectId)
   throws Exception
   {
      return this.getAllDiscussionsForProject(null, projectId);
   }*/
   //public int addCommentForDiscussion(Event event, Discussion discussion, Comment comment)
   public int addCommentForDiscussion(Discussion discussion, Comment comment)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.addComment(discussion, comment);
   }
   
   /*public int addCommentForDiscussion(Discussion discussion, Comment comment)
   throws Exception
   {
      return this.addCommentForDiscussion(null, discussion, comment);
   }*/
   //public Comment[] getCommentsForDiscussion(Event event, Discussion discussion)
   public Comment[] getCommentsForDiscussion(Discussion discussion)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.getCommentsForObject(discussion);
   }

   /*public Comment[] getCommentsForDiscussion(Discussion discussion)
   throws Exception
   {
       return this.getCommentsForDiscussion(null, discussion);
   }*/  
}
