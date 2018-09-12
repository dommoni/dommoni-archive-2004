/*
 * Created on Jul 11, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.forumManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Vector;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.ForumReply;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.commentManager.CommentManager;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ForumManager implements IForumManager
{
	//public int addForum(Event event, Forum forum)
   public int addForum(Forum forum)
   throws Exception
   {
      Connection connection = null;
      int forumId = -1;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into forums (subject,message,project_id,created_by,created_on) values (?,?,?,?,?)");
         pstmt.setString(1, forum.getSubject());
         pstmt.setString(2, forum.getMessage());
         pstmt.setInt(3, forum.getProjectId());
         pstmt.setInt(4, forum.getCreatedBy());
         
         Timestamp tsCreatedOn = new Timestamp(System.currentTimeMillis());
         pstmt.setTimestamp(5, tsCreatedOn);
         
         pstmt.executeUpdate();
         
         //
         // retrieve and return the id..
         //
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from forums", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            forumId = rs.getInt(1);
         }
         
         pstmt.close();
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
      
      return forumId;
   }
   
   /*public int addForum(Forum forum)
   throws Exception
   {
      throw new ContextNotFoundException();   
   }*/
   
   //public void dropForum(evy, int forumId)
   public void dropForum(int forumId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from forums where id=?");
         pstmt.setInt(1, forumId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from forum_replies where forum_id=?");
         pstmt.setInt(1, forumId);
         pstmt.executeUpdate();
         
         pstmt.close();
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
   
   /*public void dropForum(int forumId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyForum(Event event, Forum forum)
   public void modifyForum(Forum forum)
   throws Exception
   {
      Connection connection = null;
      
      if(forum == null)
         return;
         
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update forums set subject=?, message=? where id=?");
         pstmt.setString(1, forum.getSubject());
         pstmt.setString(2, forum.getMessage());
         pstmt.setInt(3, forum.getId());
         pstmt.executeUpdate();
         
         pstmt.close();
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

   /*public void modifyForum(Forum forum)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Forum getForum(Event event, int forumId)
   public Forum getForum(int forumId)
   throws Exception
   {
      Connection connection = null;
      Forum forum = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select subject,message,project_id,created_by,created_on from forums where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, forumId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            forum = new Forum();
            forum.setId(forumId);
            forum.setSubject(rs.getString(1));
            forum.setMessage(rs.getString(2));
            forum.setProjectId(rs.getInt(3));
            forum.setCreatedBy(rs.getInt(4));
            
            Timestamp ts = rs.getTimestamp(5);
            Calendar createdOn = Calendar.getInstance();
            createdOn.setTime(ts);
            forum.setCreatedOn(createdOn);
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
      
      return forum;    
   }
   
   /*public Forum getForum(int forumId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Forum[] getAllForumsForProject(Event event, int projectId)
   public Forum[] getAllForumsForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      Vector forums = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from forums where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next())
         {
            forums.add(getForum(rs.getInt(1)));//event, rs.getInt(1)));
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
      
      return (Forum[])forums.toArray(new Forum[forums.size()]);
   }

   /*public Forum[] getAllForumsForProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void addForumReply(Event event, ForumReply forumReply)
   public void addForumReply(ForumReply forumReply)
   throws Exception
   {
      Connection connection = null;
      
      if(forumReply == null)
         return;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into forum_replies (forum_id,reply,account_id,timestamp) values (?,?,?,?)");
         pstmt.setInt(1, forumReply.getForumId());
         pstmt.setString(2, forumReply.getReply());
         pstmt.setInt(3, forumReply.getAccountId());
         
         // the time should always be set on the other end (Client Side) but, if it is null, we dont want MySQL to do it otherwise, it will truncate the time information and only leave date information.
         Calendar clTimestamp;
         if(forumReply.getTimestamp() == null)
         {
            clTimestamp = Calendar.getInstance();
         }
         else
         {
            clTimestamp = forumReply.getTimestamp();
         }
         Timestamp ts = new Timestamp(clTimestamp.getTimeInMillis());
         pstmt.setTimestamp(4, ts);
         
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

   /*public void addForumReply(ForumReply forumReply)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   public void dropForumReply()
   throws Exception
   {
      // is this option usually available in forums?
   }
   //public ForumReply getForumReply(Event event, int id)
   public ForumReply getForumReply(int id)
   throws Exception
   {
      Connection connection = null;
      ForumReply forumReply = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select forum_id,reply,account_id,timestamp from forum_replies where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, id);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            forumReply = new ForumReply();
            forumReply.setId(id);
            forumReply.setForumId(rs.getInt(1));
            forumReply.setReply(rs.getString(2));
            forumReply.setAccountId(rs.getInt(3));
            
            Calendar clTimestamp = Calendar.getInstance();
            clTimestamp.setTimeInMillis(rs.getTimestamp(4).getTime());
            forumReply.setTimestamp(clTimestamp);
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
     
      return forumReply;
   }

   /*public ForumReply getForumReply(int id)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public ForumReply[] getAllRepliesForForum(Event event, int forumId)
   public ForumReply[] getAllRepliesForForum(int forumId)
   throws Exception
   {
      Connection connection = null;
      Vector replies = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from forum_replies where forum_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, forumId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            replies.add(getForumReply(rs.getInt(1)));//event, rs.getInt(1)));
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
      
      return (ForumReply[])replies.toArray(new ForumReply[replies.size()]);
   }

   /*public ForumReply[] getAllRepliesForForum(int forumId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public int addCommentForForum(Event event, Forum forum, Comment comment)
   public int addCommentForForum(Forum forum, Comment comment)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.addComment(forum, comment);
   }

   /*public int addCommentForForum(Forum forum, Comment comment)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Comment[] getCommentsForForum(Event event, Forum forum)
   public Comment[] getCommentsForForum(Forum forum)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.getCommentsForObject(forum);
   }
   
   /*public Comment[] getCommentsForForum(Forum forum)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
}
