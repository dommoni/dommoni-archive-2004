/*
 * Created on Jan 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.attachmentManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.BinaryAttachment;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.ForumReply;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.MeetingAgendaItem;
import com.dommoni.roundtable.MeetingFollowupItem;
import com.dommoni.roundtable.MeetingNoteItem;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.ObjectAttachment;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AttachmentManager implements IAttachmentManager
{
   /*
    * `id` INT NOT NULL AUTO_INCREMENT,
      `project_id` INT NOT NULL,
      `created_by` INT NOT NULL,
      `created_on` TIMESTAMP NOT NULL,
      `object_id
      `object_context`
      `attachment` BLOB,
      `notes 
    */
   
   public int addBinaryAttachment(BinaryAttachment attachement)
   throws Exception
   {
      Connection connection = null;
      int attachementId = 0;
      
      if(attachement == null)
         return -1;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("insert into binary_attachments (" +
                  "project_id, created_by, created_on, object_id, object_context, attachment, notes) values (?,?,?,?,?,?,?)");
         pstmt.setInt(1, attachement.getProjectId());
         pstmt.setInt(2, attachement.getCreatedBy());
         pstmt.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         
         final int posObjectId = 4;
         final int posObjectContext = 5;
         pstmt.setInt(4, attachement.getObjectId());
         pstmt.setString(5, attachement.getObjectContext());
         
         /*if(object instanceof Account) 
         {
            pstmt.setInt(posObjectId, ((Account)object).getId()); 
            pstmt.setString(posObjectContext, "ACCOUNT");
         }
         else if(object instanceof Comment) 
         {
            pstmt.setInt(posObjectId, ((Comment)object).getId());
            pstmt.setString(posObjectContext, "COMMENT");
         }
         else if(object instanceof Discussion) 
         {
            pstmt.setInt(posObjectId, ((Discussion)object).getId());
            pstmt.setString(posObjectContext, "DISCUSSION");
         }
         else if(object instanceof Document) 
         {
            pstmt.setInt(posObjectId, ((Document)object).getId());
            pstmt.setString(posObjectContext, "DOCUMENT");
         }
         else if(object instanceof Forum) 
         {
            pstmt.setInt(posObjectId, ((Forum)object).getId());
            pstmt.setString(posObjectContext, "FORUM");
         }
         else if(object instanceof ForumReply) 
         {
            pstmt.setInt(posObjectId, ((ForumReply)object).getId());
            pstmt.setString(posObjectContext, "FORUMREPLY");
         }
         else if(object instanceof Meeting) 
         {
            pstmt.setInt(posObjectId, ((Meeting)object).getId());
            pstmt.setString(posObjectContext, "MEETING");
         }
         else if(object instanceof MeetingAgendaItem) 
         {
            pstmt.setInt(posObjectId, ((MeetingAgendaItem)object).getId());
            pstmt.setString(posObjectContext, "MEETINGAGENDAITEM");
         }
         /*else if(object instanceof MeetingFollowupItem) 
         {
            pstmt.setInt(posObjectId, ((MeetingFollowupItem)object).getId());
            pstmt.setString(posObjectContext, "MEETINGFOLLOWUPITEM");
         }
         else if(object instanceof MeetingNoteItem) 
         {
            pstmt.setInt(posObjectId, ((MeetingNoteItem)object).getId());
            pstmt.setString(posObjectContext, "MEETINGNOTEITEM");
         }
         else if(object instanceof Project) 
         {
            pstmt.setInt(posObjectId, ((Project)object).getId());
            pstmt.setString(posObjectContext, "PROJECT");
         }
         else if(object instanceof ToDo) 
         {
            pstmt.setInt(posObjectId, ((ToDo)object).getId());
            pstmt.setString(posObjectContext, "TODO");
         }*/         
         
         pstmt.setBinaryStream(6, new ByteArrayInputStream(attachement.getAttachment()), attachement.getAttachment().length);
         pstmt.setString(7, attachement.getNotes());
         
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from binary_attachments", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {   
            attachementId = rs.getInt(1);
         }
         
         rs.close();
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
      
      return attachementId;
   }
   
   public void dropBinaryAttachment(int attachementId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("delete from binary_attachments where id=?");
         pstmt.setInt(1, attachementId);
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
   
   public void modifyBinaryAttachment(BinaryAttachment attachement) 
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("update binary_attachments set attachment=?, notes=? where id=?");
         pstmt.setBinaryStream(1, new ByteArrayInputStream(attachement.getAttachment()), attachement.getAttachment().length);
         pstmt.setString(2, attachement.getNotes());
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
   
   public BinaryAttachment getBinaryAttachment(int attachmentId) 
   throws Exception
   {
      Connection connection = null;
      BinaryAttachment attachment = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select project_id, created_by, created_on, object_id, object_context, attachment, notes from binary_attachments where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, attachmentId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            attachment = new BinaryAttachment();
            
            attachment.setId(attachmentId);
            attachment.setProjectId(rs.getInt("project_id"));
            attachment.setCreatedBy(rs.getInt("created_by"));
            
            if(rs.getTimestamp("created_on") != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTime(rs.getTimestamp("created_on"));
               attachment.setCreatedOn(clCreatedOn);
            }
            attachment.setObjectId(rs.getInt("object_id"));
            attachment.setObjectContext(rs.getString("object_context"));
            attachment.setAttachment(getBytes(rs.getBinaryStream("attachment")));
            attachment.setNotes(rs.getString("notes"));
         }
         
         rs.close();
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
      
      return attachment;
   }
   
   public BinaryAttachment[] getAllBinaryAttachmentsForObject(Object object) 
   throws Exception
   {
      Connection connection = null;
      List attachments = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();      
         PreparedStatement pstmt = connection.prepareStatement("select id from binary_attachments where object_id=? and object_context=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         final int posObjectId = 1;
         final int posObjectContext = 2;
         
         if(object instanceof Account) 
         {
            pstmt.setInt(posObjectId, ((Account)object).getId()); 
            pstmt.setString(posObjectContext, "ACCOUNT");
         }
         else if(object instanceof Comment) 
         {
            pstmt.setInt(posObjectId, ((Comment)object).getId());
            pstmt.setString(posObjectContext, "COMMENT");
         }
         else if(object instanceof Discussion) 
         {
            pstmt.setInt(posObjectId, ((Discussion)object).getId());
            pstmt.setString(posObjectContext, "DISCUSSION");
         }
         else if(object instanceof Document) 
         {
            pstmt.setInt(posObjectId, ((Document)object).getId());
            pstmt.setString(posObjectContext, "DOCUMENT");
         }
         else if(object instanceof Forum) 
         {
            pstmt.setInt(posObjectId, ((Forum)object).getId());
            pstmt.setString(posObjectContext, "FORUM");
         }
         else if(object instanceof ForumReply) 
         {
            pstmt.setInt(posObjectId, ((ForumReply)object).getId());
            pstmt.setString(posObjectContext, "FORUMREPLY");
         }
         else if(object instanceof Meeting) 
         {
            pstmt.setInt(posObjectId, ((Meeting)object).getId());
            pstmt.setString(posObjectContext, "MEETING");
         }
         else if(object instanceof MeetingAgendaItem) 
         {
            pstmt.setInt(posObjectId, ((MeetingAgendaItem)object).getId());
            pstmt.setString(posObjectContext, "MEETINGAGENDAITEM");
         }
         /*else if(object instanceof MeetingFollowupItem) 
         {
            pstmt.setInt(posObjectId, ((MeetingFollowupItem)object).getId());
            pstmt.setString(posObjectContext, "MEETINGFOLLOWUPITEM");
         }*/
         else if(object instanceof MeetingNoteItem) 
         {
            pstmt.setInt(posObjectId, ((MeetingNoteItem)object).getId());
            pstmt.setString(posObjectContext, "MEETINGNOTEITEM");
         }
         else if(object instanceof Project) 
         {
            pstmt.setInt(posObjectId, ((Project)object).getId());
            pstmt.setString(posObjectContext, "PROJECT");
         }
         else if(object instanceof Task) 
         {
            pstmt.setInt(posObjectId, ((Task)object).getId());
            pstmt.setString(posObjectContext, "TODO");
         }
         
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            attachments.add(getBinaryAttachment(rs.getInt("id")));
         }
         
         rs.close();
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
      
      return (BinaryAttachment[])attachments.toArray(new BinaryAttachment[attachments.size()]);
   }

   
   //
   // Object Attachements....
   //
   
   
   /**
    * Creates an attachment between two roundtable objects.
    */
   public ObjectAttachment createObjectAttachment(Object targetObject, 
                                                   Object attachmentObject, 
                                                   ObjectAttachment attachment) 
   throws Exception
   {
      Connection connection = null;
      ObjectAttachment objAttachment = null;
      
      if(targetObject == null || attachmentObject == null)
         return null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into object_attachments (" +
               "project_id, created_by, created_on, object_id, " +
               "object_context, attachment_object_id, attachment_object_context, " +
               "notes) values (?, ?, ?, ?, ?, ?)");
         pstmt.setInt(1, attachment.getProjectId());
         pstmt.setInt(2, attachment.getCreatedBy());
         pstmt.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
        
         AttachmentObjectDescriptor aod = getAttachmentObjectDescriptor(targetObject);
         pstmt.setInt(4, aod.objectId);
         pstmt.setString(5, aod.objectContext);
         
         aod = getAttachmentObjectDescriptor(attachmentObject);
         pstmt.setInt(6, aod.objectId);
         pstmt.setString(7, aod.objectContext);
         
         pstmt.setString(8, attachment.getNotes());
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from object_attachments");
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            objAttachment = getObjectAttachment(rs.getInt(1));
         }
         
         rs.close();
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
      
      return objAttachment;
   }
   
   public void dropObjectAttachment(int attachmentId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("delete from object_attachments where id=?");
         pstmt.setInt(1, attachmentId);
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
   
   public void modifyObjectAttachment(ObjectAttachment attachement) 
   throws Exception
   {
   }
   
   public ObjectAttachment getObjectAttachment(int attachmentId) 
   throws Exception
   {
      
      return null;
   }
   
   public ObjectAttachment[] getAllObjectAttachmentsForObject(Object obj) 
   throws Exception
   {
      return null;
   }
   
   private byte[] getBytes(InputStream ins)
   throws Exception
   {
      try
      {
         int count = ins.available();
         byte[] data = new byte[count];
         ins.read(data);
         return data;
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return null;
   }
   
   private AttachmentObjectDescriptor getAttachmentObjectDescriptor(Object object)
   throws Exception
   {
      AttachmentObjectDescriptor aod = new AttachmentObjectDescriptor();
      
      if(object instanceof Account) 
      {
         aod.objectId = ((Account)object).getId(); 
         aod.objectContext = "ACCOUNT";
      }
      else if(object instanceof Comment) 
      {
         aod.objectId = ((Comment)object).getId();
         aod.objectContext = "COMMENT";
      }
      else if(object instanceof Discussion) 
      {
         aod.objectId =  ((Discussion)object).getId();
         aod.objectContext = "DISCUSSION";
      }
      else if(object instanceof Document) 
      {
         aod.objectId = ((Document)object).getId();
         aod.objectContext = "DOCUMENT";
      }
      else if(object instanceof Forum) 
      {
         aod.objectId = ((Forum)object).getId();
         aod.objectContext = "FORUM";
      }
      else if(object instanceof ForumReply) 
      {
         aod.objectId = ((ForumReply)object).getId();
         aod.objectContext = "FORUMREPLY";
      }
      else if(object instanceof Meeting) 
      {
         aod.objectId = ((Meeting)object).getId();
         aod.objectContext = "MEETING";
      }
      else if(object instanceof MeetingAgendaItem) 
      {
         aod.objectId = ((MeetingAgendaItem)object).getId();
         aod.objectContext = "MEETINGAGENDAITEM";
      }
      /*else if(object instanceof MeetingFollowupItem) 
      {
         pstmt.setInt(posObjectId, ((MeetingFollowupItem)object).getId());
         pstmt.setString(posObjectContext, "MEETINGFOLLOWUPITEM");
      }*/
      else if(object instanceof MeetingNoteItem) 
      {
         aod.objectId = ((MeetingNoteItem)object).getId();
         aod.objectContext = "MEETINGNOTEITEM";
      }
      else if(object instanceof Project) 
      {
         aod.objectId = ((Project)object).getId();
         aod.objectContext = "PROJECT";
      }
      else if(object instanceof Task) 
      {
         aod.objectId = ((Task)object).getId();
         aod.objectContext = "TODO";
      }
      
      return aod;
   }
}

class AttachmentObjectDescriptor
{
   public int objectId;
   public String objectContext;
}
/*
 * 
 * $Log: AttachmentManager.java,v $
 * Revision 1.3  2005/10/17 05:57:38  brian
 * Various corrections.
 *
 * Revision 1.2  2005/03/23 07:22:10  brian
 * Corrected spelling of attachment.
 *
 * 
 */
