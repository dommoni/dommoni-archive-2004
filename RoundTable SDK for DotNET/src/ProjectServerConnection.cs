using System;

using RoundTable.ProjectServer.Services.AccountManager;
using RoundTable.ProjectServer.Services.AnnoucementManager;
using RoundTable.ProjectServer.Services.AttachmentManager;
using RoundTable.ProjectServer.Services.CommentManager;
using RoundTable.ProjectServer.Services.DiscussionManager;
using RoundTable.ProjectServer.Services.DocumentManager;
using RoundTable.ProjectServer.Services.ForumManager;
using RoundTable.ProjectServer.Services.Logging.EventLogManager;
using RoundTable.ProjectServer.Services.Logging.SessionLogManager;
using RoundTable.ProjectServer.Services.MeetingManager;
using RoundTable.ProjectServer.Services.NamedFieldTemplateManager;
using RoundTable.ProjectServer.Services.NotificationManager;
using RoundTable.ProjectServer.Services.ProjectManager;
using RoundTable.ProjectServer.Services.RecentChangesManager;
using RoundTable.ProjectServer.Services.ScheduleManager;
using RoundTable.ProjectServer.Services.SessionManager;
using RoundTable.ProjectServer.Services.TaskManager;

namespace RoundTable
{
	/// <summary>
	/// Summary description for ProjectServerConnection.
	/// </summary>
	public class ProjectServerConnection
	{
		const string INACTIVE_SESSION_EXMSG = "No Active Session found. You must call .login() first.";

		private string sessionId = null; // readonly
		private string username = null;
		private string password = null;
		private int sessionType;
   
		private string ipAddr = null;
		private int port;
   
		private IAccountManager accountManager = null;
		private IAnnouncementManager announcementManager = null;
		private IAttachmentManager attachmentManager = null;
		private ICommentManager commentManager = null;
		private IDiscussionManager discussionManager = null;
		private IDocumentManager documentManager = null;
		private IEventLogManager eventLogManager = null;
		private IForumManager forumManager = null;
		private IMeetingManager meetingManager = null;
		private INamedFieldTemplateManager namedFieldTemplateManager = null;
		private INotificationManager notificationManager = null;
		private IProjectManager projectManager = null;
		private IRecentChangesManager recentChangesManager = null;
		private IScheduleManager scheduleManager = null;
		private ISessionManager sessionManager = null;
		private ISessionLogManager sessionLogManager = null;
		private ITaskManager taskManager = null;
   
		// Local copy of the current project. This is to reduce demand on the server.
		private Project currentProject = null;
		private Account account = null;
   
		// properties
		public string SessionID
		{
			get{return this.sessionId;}
		}

		public string Username 
		{
			get{return this.username;}
			set{this.username = value;}
		}
   
		public string Password
		{
			get{return this.password;}
			set{this.password = value;}
		}
   
		public int SessionType
		{
			get{return this.sessionType;}
			set{this.sessionType = value;}
		}	

		public string IPAddr
		{
			get{return this.ipAddr;}
			set{this.ipAddr = value;}
		}

		public int Port 
		{
			get{return this.port;}
			set{this.port = value;}
		}

		public Account Account
		{
			get
			{
				if(account == null)
				{	
					account = SessionManager.getAccountForSession(sessionId);
				}
				return account;
			}
		}

		public Project CurrentProject
		{
			get{return this.currentProject;}
			set
			{
				try
				{
					SessionManager.setCurrentProjectForSession(sessionId, value);

					// assuming this went well,
					this.currentProject = currentProject;
				}
				catch(Exception e) 
				{}
			}
		}

		// Exposed Managers---------------------------------------------------------
		// 
		// Note: The session checks and exceptions should stay here rather than the
		//       services themselves in order to minimize the required changes 
		//       necessary when the service code is regenerated.

		public IAccountManager AccountManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(accountManager == null)
					{	
						accountManager = new AccountManagerService(this.ipAddr, this.port, sessionId);
					}
					return accountManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IAnnouncementManager AnnouncementManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(announcementManager == null)
					{	
						announcementManager = new AnnouncementManagerService(this.ipAddr, this.port, sessionId);
					}
					return announcementManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IAttachmentManager AttachmentManager
		{
			get
			{
				/*if(sessionId != null)
				{	
					if(attachmentManager == null)
					{	
						attachmentManager = new AttachmentManagerService(this.ipAddr, this.port, sessionId);
					}
					return attachmentManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}*/
				return null;
			}
		}
   
		public ICommentManager CommentManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(commentManager == null)
					{	
						commentManager = new CommentManagerService(this.ipAddr, this.port, sessionId);
					}
					return commentManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
      
		public IDiscussionManager DiscussionManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(discussionManager == null)
					{	
						discussionManager = new DiscussionManagerService(this.ipAddr, this.port, sessionId);
					}
					return discussionManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IDocumentManager DocumentManager
		{
			get 
			{
				if(sessionId != null)
				{	
					if(documentManager == null)
					{	
						documentManager = new DocumentManagerService(this.ipAddr, this.port, sessionId);
					}
					return documentManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IEventLogManager EventLogManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(eventLogManager == null)
					{	
						eventLogManager = new EventLogManagerService(this.ipAddr, this.port, sessionId);
					}
					return eventLogManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IForumManager ForumManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(forumManager == null)
					{	
						forumManager = new ForumManagerService(this.ipAddr, this.port, sessionId);
					}
					return forumManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IMeetingManager MeetingManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(meetingManager == null)
					{	
						meetingManager = new MeetingManagerService(this.ipAddr, this.port, sessionId);
					}
					return meetingManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public INamedFieldTemplateManager NamedFieldTemplateManager 
		{
			get
			{
				if (sessionId != null)
				{
					if (namedFieldTemplateManager == null)
					{
						namedFieldTemplateManager = new NamedFieldTemplateManagerService(this.ipAddr, this.port, sessionId);
					}
					return namedFieldTemplateManager;
				}
				else
				{
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}

		public INotificationManager NotificationManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(notificationManager == null)
					{	
						notificationManager = new NotificationManagerService(this.ipAddr, this.port, sessionId);
					}
					return notificationManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IProjectManager ProjectManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(projectManager == null)
					{	
						projectManager = new ProjectManagerService(this.ipAddr, this.port, sessionId);
					}
					return projectManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public IRecentChangesManager RecentChangesManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(recentChangesManager == null)
					{	
						recentChangesManager = new RecentChangesManagerService(this.ipAddr, this.port, sessionId);
					}
					return recentChangesManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}

		public IScheduleManager ScheduleManager
		{
			get
			{
				if(sessionId != null)
				{	
					if(scheduleManager == null)
					{	
						scheduleManager = new ScheduleManagerService(this.ipAddr, this.port, sessionId);
					}
					return scheduleManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		public ISessionManager SessionManager
		{
			get
			{	// sessionId can be null... (at first)... 
				sessionManager = new SessionManagerService(this.ipAddr, this.port, sessionId);
				return this.sessionManager;
			}
		}
   
		public ISessionLogManager SessionLogManager
		{
			get 
			{
				/*if(sessionId != null)
				{	
					if(sessionLogManager == null)
					{	
						sessionLogManager = new SessionLogManagerService(this.ipAddr, this.port, sessionId);
					}
					return sessionLogManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}*/
				return null;
			}
		}
 
		public ITaskManager TaskManager
		{
			get 
			{
				if(sessionId != null)
				{	
					if(taskManager == null)
					{	
						taskManager = new TaskManagerService(this.ipAddr, this.port, sessionId);
					}
					return taskManager;
				}
				else
				{	
					throw new Exception(INACTIVE_SESSION_EXMSG);
				}
			}
		}
   
		//
		// Constructors
		//

		public ProjectServerConnection(string username, string password, string ipAddr, int port)
			:this(username, password, 1, ipAddr, port)
		{
		}
   
		// TODO: need a way to extend session types.
		public ProjectServerConnection(string username, string password, int sessionType, string ipAddr, int port)
		{
			this.username = username;
			this.password = password;
			this.sessionType = sessionType;
      
			this.ipAddr = ipAddr;
			this.port = port;
			/*
				  accountManager = 
				  announcementManager = 
				  attachmentManager = 
				  commentManager = 
				  discussionManager = 
				  documentManager = 
				  eventLogManager = 
				  forumManager = 
				  meetingManager = 
				  notificationManager = 
				  projectManager = 
				  recentChangesManager = 
				  sessionManager = 
				  sessionLogManager = 
				  todoManager = */
		}
   
		public void login() // will be security exception
		{
			sessionId = SessionManager.getSession(username, password, sessionType);
			ISessionManager sm = this.SessionManager;
			((SessionManagerService)sm).sessionHeader.SessionID = sessionId;
			
			if(sessionId == null)
			{
				throw new Exception("Unable to Authenticate with the ProjectServer.");
			}
		}

		public void logout()
		{
			ISessionManager sm = SessionManager;
			sm.closeSession(sessionId);
			sessionId = null;
		}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													
	}
}
/*
 * 
 * $Log: ProjectServerConnection.cs,v $
 * Revision 1.1  2005/03/26 17:48:46  brian
 * Initial Revision.
 *
 * 
 */