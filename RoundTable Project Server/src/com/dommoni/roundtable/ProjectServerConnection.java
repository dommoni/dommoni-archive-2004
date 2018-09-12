/*
 * Created on Mar 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.message.SOAPHeaderElement;

import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.logging.SessionLogEntry;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.announcementManager.IAnnouncementManager;
import com.dommoni.roundtable.projectServer.services.attachmentManager.IAttachmentManager;
import com.dommoni.roundtable.projectServer.services.commentManager.ICommentManager;
import com.dommoni.roundtable.projectServer.services.discussionManager.IDiscussionManager;
import com.dommoni.roundtable.projectServer.services.documentManager.IDocumentManager;
import com.dommoni.roundtable.projectServer.services.forumManager.IForumManager;
import com.dommoni.roundtable.projectServer.services.logging.eventlogManager.IEventLogManager;
import com.dommoni.roundtable.projectServer.services.logging.sessionlogManager.ISessionLogManager;
import com.dommoni.roundtable.projectServer.services.meetingManager.IMeetingManager;
import com.dommoni.roundtable.projectServer.services.namedFieldTemplateManager.INamedFieldTemplateManager;
import com.dommoni.roundtable.projectServer.services.notificationManager.INotificationManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.roundtable.projectServer.services.recentChangesManager.IRecentChangesManager;
import com.dommoni.roundtable.projectServer.services.scheduleManager.IScheduleManager;
import com.dommoni.roundtable.projectServer.services.sessionManager.*;
import com.dommoni.roundtable.projectServer.services.systemManager.ISystemManager;
import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProjectServerConnection
{
   String sessionId;
   String username;
   String password;
   int sessionType;
   
   String ipAddr;
   int port;
   
   private IAccountManager accountManager;
   private IAnnouncementManager announcementManager;
   private IAttachmentManager attachmentManager;
   // TODO: Determine if this should be exposed...
   private ICommentManager commentManager;
   
   private IDiscussionManager discussionManager;
   private IDocumentManager documentManager;
   private IEventLogManager eventLogManager;
   private IForumManager forumManager;
   private IMeetingManager meetingManager;
   private INamedFieldTemplateManager namedFieldTemplateManager;
   private INotificationManager notificationManager;
   private IProjectManager projectManager;
   private IRecentChangesManager recentChangesManager;
   private IScheduleManager scheduleManager;
   private ISessionManager sessionManager;
   private ISessionLogManager sessionLogManager;
   private ISystemManager systemManager;
   private ITaskManager taskManager;
   
   //
   // Local copy of the current project. This is to reduce demand on the server.
   //
   private Project currentProject = null;
   
   public String getUsername()
   {
      return this.username;
   }
   
   public String getPassword()
   {
      return this.password;
   }
   
   public int getSessionType()
   {
      return this.sessionType;
   }
   
   // Exposed Managers---------------------------------------------------------
   public IAccountManager getAccountManager()
   {
      return this.accountManager;
   }
   
   public IAnnouncementManager getAnnouncementManager()
   {
      return this.announcementManager;
   }
   
   public IAttachmentManager getAttachmentManager()
   {
      return this.attachmentManager;
   }
   
   public ICommentManager getCommentManager()
   {
      return this.commentManager;
   }
      
   public IDiscussionManager getDiscussionManager()
   {
      return this.discussionManager;
   }
   
   public IDocumentManager getDocumentManager()
   {
      return this.documentManager;
   }
   
   public IEventLogManager getEventLogManager()
   {
      return eventLogManager;
   }
   
   public IForumManager getForumManager()
   {
      return this.forumManager;
   }
   
   public IMeetingManager getMeetingManager()
   {
      return this.meetingManager;
   }
   
   public INamedFieldTemplateManager getNamedFieldTemplateManager()
   {
      return this.namedFieldTemplateManager;
   }
   
   public INotificationManager getNotificationManager()
   {
      return this.notificationManager;
   }
   
   public IProjectManager getProjectManager()
   {
      return this.projectManager;
   }
   
   public IRecentChangesManager getRecentChangesManager()
   {
      return this.recentChangesManager;
   }
   
   public IScheduleManager getScheduleManager()
   {
      return this.scheduleManager;
   }
   
   public ISessionManager getSessionManager()
   {
      return this.sessionManager;
   }
   
   public ISessionLogManager getSessionLogManager()
   {
      return sessionLogManager;
   }
   
   public ISystemManager getSystemManager()
   {
      return this.systemManager;
   }
   
   public ITaskManager getTaskManager()
   {
      return this.taskManager;
   }
   
   public ProjectServerConnection(String username, String password, String ipAddr, int port)
   {
      this(username, password, SessionType.GENERIC_SESSION, ipAddr, port);
   }
   
   // TODO: need a way to extend session types.
   public ProjectServerConnection(String username, String password, int sessionType, String ipAddr, int port)
   {
      this.username = username;
      this.password = password;
      this.sessionType = sessionType;
      
      this.ipAddr = ipAddr;
      this.port = port;
      
      accountManager = (IAccountManager)Proxy.newProxyInstance(IAccountManager.class.getClassLoader(),
                                                               new Class[]{IAccountManager.class}, 
                                                               new SOAPInvocationHandler("AccountManager"));
      
      announcementManager = (IAnnouncementManager)Proxy.newProxyInstance(IAnnouncementManager.class.getClassLoader(),
                                                                         new Class[]{IAnnouncementManager.class}, 
                                                                         new SOAPInvocationHandler("AnnouncementManager"));

      attachmentManager = (IAttachmentManager)Proxy.newProxyInstance(IAttachmentManager.class.getClassLoader(),
                                                                     new Class[]{IAttachmentManager.class}, 
                                                                     new SOAPInvocationHandler("AttachmentManager"));

      commentManager = (ICommentManager)Proxy.newProxyInstance(ICommentManager.class.getClassLoader(),
                                                               new Class[]{ICommentManager.class}, 
                                                               new SOAPInvocationHandler("CommentManager"));
  
      discussionManager = (IDiscussionManager)Proxy.newProxyInstance(IDiscussionManager.class.getClassLoader(),
                                                                     new Class[] {IDiscussionManager.class},
                                                                     new SOAPInvocationHandler("DiscussionManager"));

      documentManager = (IDocumentManager)Proxy.newProxyInstance(IDocumentManager.class.getClassLoader(),
                                                                 new Class[] {IDocumentManager.class},
                                                                 new SOAPInvocationHandler("DocumentManager"));
      
      eventLogManager = (IEventLogManager)Proxy.newProxyInstance(IEventLogManager.class.getClassLoader(),
                                                                 new Class[] {IEventLogManager.class},
                                                                 new SOAPInvocationHandler("EventLogManager"));
         
      forumManager = (IForumManager)Proxy.newProxyInstance(IForumManager.class.getClassLoader(),
                                                           new Class[] {IForumManager.class},
                                                           new SOAPInvocationHandler("ForumManager"));

      meetingManager = (IMeetingManager)Proxy.newProxyInstance(IMeetingManager.class.getClassLoader(),
                                                               new Class[] {IMeetingManager.class},
                                                               new SOAPInvocationHandler("MeetingManager"));
                                      
      namedFieldTemplateManager = (INamedFieldTemplateManager)Proxy.newProxyInstance(INamedFieldTemplateManager.class.getClassLoader(),
                                                                                     new Class[] {INamedFieldTemplateManager.class},
                                                                                     new SOAPInvocationHandler("NamedFieldTemplateManager"));
      
      notificationManager = (INotificationManager)Proxy.newProxyInstance(INotificationManager.class.getClassLoader(),
                                                                         new Class[] {INotificationManager.class},
                                                                         new SOAPInvocationHandler("NotificationManager"));
                               
      projectManager = (IProjectManager)Proxy.newProxyInstance(IProjectManager.class.getClassLoader(),
                                                               new Class[] {IProjectManager.class},
                                                               new SOAPInvocationHandler("ProjectManager"));
  
      recentChangesManager = (IRecentChangesManager)Proxy.newProxyInstance(IRecentChangesManager.class.getClassLoader(),
                                                                           new Class[] {IRecentChangesManager.class},
                                                                           new SOAPInvocationHandler("RecentChangesManager"));
  
      scheduleManager = (IScheduleManager)Proxy.newProxyInstance(IScheduleManager.class.getClassLoader(),
                                                                 new Class[]{IScheduleManager.class}, 
                                                                 new SOAPInvocationHandler("ScheduleManager"));
      
      sessionManager = (ISessionManager)Proxy.newProxyInstance(ISessionManager.class.getClassLoader(),
                                                               new Class[]{ISessionManager.class}, 
                                                               new SOAPInvocationHandler("SessionManager"));
      
      sessionLogManager = (ISessionLogManager)Proxy.newProxyInstance(ISessionLogManager.class.getClassLoader(),
                                                                     new Class[]{ISessionLogManager.class}, 
                                                                     new SOAPInvocationHandler("SessionLogManager"));
      
      systemManager = (ISystemManager)Proxy.newProxyInstance(ISystemManager.class.getClassLoader(),
                                                                     new Class[]{ISystemManager.class}, 
                                                                     new SOAPInvocationHandler("SystemManager"));
      
      taskManager = (ITaskManager)Proxy.newProxyInstance(ITaskManager.class.getClassLoader(),
                                                         new Class[] {ITaskManager.class},
                                                         new SOAPInvocationHandler("TaskManager"));
   }
   
   public void login() throws Exception // will be security exception
   {
      sessionId = getSessionManager().getSession(username, password, sessionType);
      if(sessionId == null)
      {
         throw new Exception("Unable to Authenticate with the ProjectServer.");
      }
   }
   
   public Project getCurrentProject()
   {
      return this.currentProject;
   }
   
   public Account getAccount()
   {
      try
      {
         return getSessionManager().getAccountForSession(sessionId);
      }
      catch(Exception e) {}
      return null;
   }
   
   public void setCurrentProject(Project currentProject)
   {
      try
      {
         getSessionManager().setCurrentProjectForSession(sessionId, currentProject);
      
         // assuming this went well,
         this.currentProject = currentProject;
      }
      catch(Exception e) {}
   }
   
   public void registerTypeMappings(Call call)
   {
      // Account
      call.registerTypeMapping(Account.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Account"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
                               
      // Account Settings
      call.registerTypeMapping(AccountSettings.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "AccountSettings"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
                               
      // Account Profile
      call.registerTypeMapping(AccountProfile.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "AccountProfile"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
                               
      // Account Contact
      call.registerTypeMapping(AccountContact.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "AccountContact"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // Announcement
      call.registerTypeMapping(Announcement.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Announcement"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // Announcement
      call.registerTypeMapping(BinaryAttachment.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "BinaryAttachment"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // Comment
      call.registerTypeMapping(Comment.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Comment"), 
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // CommentAttachment
      call.registerTypeMapping(CommentAttachment.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "CommentAttachment"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);

      // CustomField
      call.registerTypeMapping(CustomField.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "CustomField"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // CustomFieldAttribute
      call.registerTypeMapping(CustomFieldAttribute.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "CustomFieldAttribute"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // CustomFieldValueWrapper
      call.registerTypeMapping(CustomFieldValueWrapper.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "CustomFieldValueWrapper"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // CustomFieldValueWrapperInt
      call.registerTypeMapping(CustomFieldValueWrapperInt.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "CustomFieldValueWrapperInt"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // CustomFieldValueWrapperString
      call.registerTypeMapping(CustomFieldValueWrapperString.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "CustomFieldValueWrapperString"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // Discussion
      call.registerTypeMapping(Discussion.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Discussion"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // DiscussionMessage
      call.registerTypeMapping(DiscussionMessage.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "DiscussionMessage"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
           
      // Document
      call.registerTypeMapping(Document.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Document"),
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      
      // Forum
      call.registerTypeMapping(Forum.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Forum"),
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
      // ForumReply
      call.registerTypeMapping(ForumReply.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "ForumReply"),
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
                                  
      // Meeting
      call.registerTypeMapping(Meeting.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Meeting"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
                               
      // MeetingAgendaItem
      call.registerTypeMapping(MeetingAgendaItem.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "MeetingAgendaItem"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // MeetingFollowupItem
      call.registerTypeMapping(MeetingFollowupItem.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "MeetingFollowupItem"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // MeetingNoteItem
      call.registerTypeMapping(MeetingNoteItem.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "MeetingNoteItem"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
                               
      // NamedFieldCollection
      call.registerTypeMapping(NamedFieldCollection.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "NamedFieldCollection"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // NamedFieldTemplate
      call.registerTypeMapping(NamedFieldTemplate.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "NamedFieldTemplate"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // NamedTemplateFieldDefinition
      call.registerTypeMapping(NamedTemplateFieldDefinition.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "NamedTemplateFieldDefinition"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // Notification
      call.registerTypeMapping(Notification.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Notification"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // ObjectAttachment
      call.registerTypeMapping(ObjectAttachment.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "ObjectAttachment"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
     
      // Project
      call.registerTypeMapping(Project.class, 
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Project"), 
                               BeanSerializerFactory.class, 
                               BeanDeserializerFactory.class);
                               
      // RecentChange
      call.registerTypeMapping(RecentChange.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "RecentChange"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);

      // Schedule
      call.registerTypeMapping(Schedule.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Schedule"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      // ScheduleItem
      call.registerTypeMapping(ScheduleItem.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "ScheduleItem"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // Session
      call.registerTypeMapping(Session.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Session"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
                               
      // Task
      call.registerTypeMapping(Task.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "Task"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
                               
      // Task Reminder
      call.registerTypeMapping(TaskReminder.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "TaskReminder"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);

      // Task Status
      call.registerTypeMapping(TaskStatus.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "TaskStatus"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      //
      // com.dommoni.roundtable.logging package serialization
      //
      
      // EventLogEntry
      call.registerTypeMapping(EventLogEntry.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "EventLogEntry"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
      
      // SessionLogEntry
      call.registerTypeMapping(SessionLogEntry.class,
                               new QName("http://www.dommoni.com/ROUNDTABLE", "SessionLogEntry"),
                               BeanSerializerFactory.class,
                               BeanDeserializerFactory.class);
   }
   
   class SOAPInvocationHandler implements InvocationHandler
   {
      String endpoint;
      Service service;
      Call call;
      SOAPHeaderElement sessionHeader = null;
               
      public SOAPInvocationHandler(String _endpoint)
      {
         endpoint = _endpoint;
         service = new Service();
         try
         {
            call = (Call)service.createCall();
         
            registerTypeMappings(call);
         }
         catch(ServiceException se)
         {
            se.printStackTrace();
         }
      }
      
      public Object invoke(Object proxy, Method method, Object[] args) 
         throws Throwable 
      {
         call.clearHeaders();
         if(sessionHeader == null)
         {   
            sessionHeader = new SOAPHeaderElement("http://www.dommoni.com/ROUNDTABLE", "SessionID", sessionId); 
         } 
       
         // problem if this is null!
         if(sessionHeader.getObjectValue() == null)
         {
            sessionHeader.setObjectValue(sessionId);
         }
         call.addHeader(sessionHeader);
         
         call.setTargetEndpointAddress(new URL("http://"+ipAddr+":"+port+"/ProjectServer/services/" + endpoint));
         call.setOperationName(new QName(method.getName()));
         
         return call.invoke(args);
      }
   }
}
/*
 *
 * $Log: ProjectServerConnection.java,v $
 * Revision 1.2  2005/03/23 07:10:32  brian
 * Corrected spelling of attachmentmanager and removed printfs.
 *
 *
 */