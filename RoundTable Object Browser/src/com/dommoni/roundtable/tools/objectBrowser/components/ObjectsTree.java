package com.dommoni.roundtable.tools.objectBrowser.components;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Task;
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
import com.dommoni.roundtable.projectServer.services.sessionManager.ISessionManager;
import com.dommoni.roundtable.projectServer.services.systemManager.ISystemManager;
import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;

public class ObjectsTree extends JTree
{
   /*
    *   private IAccountManager accountManager;
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
    */
   DefaultMutableTreeNode tnAccounts;
   DefaultMutableTreeNode tnProjects;

   /*Announcements;
   AttachmentManager;
   Comments;
   
   Discussions;
   Documents;
   EventLogs;
   Forums;
   Meetings;
   namedFieldTemplates;
   tnNotifications;
   tnRecentChanges;
   private IScheduleManager scheduleManager;
   private ISessionManager sessionManager;
   private ISessionLogManager sessionLogManager;
   private ISystemManager systemManager;
   private ITaskManager taskManager;
   */
   ProjectServerConnection connection;
   
   public ObjectsTree(ProjectServerConnection connection)
   {
      this.connection = connection;
      
      tnAccounts = new FolderNode("Accounts");
      tnProjects = new FolderNode("Projects");
      
      DefaultMutableTreeNode tnRoot = new DefaultMutableTreeNode();
      tnRoot.add(tnAccounts);
      tnRoot.add(tnProjects);
      DefaultTreeModel model = new DefaultTreeModel(tnRoot);
      
      setRootVisible(false);
      setModel(model);
      
      buildAccountsNode();
      buildProjectsNode();
   }
   
   private void buildAccountsNode()
   {
      try
      {
         Account[] accounts = connection.getAccountManager().getAllAccounts();
         for (int i = 0; i < accounts.length; i++)
         {
            tnAccounts.add(new DefaultMutableTreeNode(accounts[i]));
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   private void buildProjectsNode()
   {
      try
      {
         Project[] projects = connection.getProjectManager().getAllProjects();
         for (int i = 0; i < projects.length; i++)
         {
            DefaultMutableTreeNode projectNode = 
               new DefaultMutableTreeNode(projects[i]);
            
            //
            // Members...
            //
            DefaultMutableTreeNode membersNode = new DefaultMutableTreeNode("Members");
            projectNode.add(membersNode);
            Account[] projectMembers = projects[i].getMembers();
            
            //
            // Tasks...
            //
            DefaultMutableTreeNode tasksNode = new DefaultMutableTreeNode("Tasks");
            Task[] tasks = connection.getTaskManager().getAllTasksForProject(projects[i].getId());
            for (int ii = 0; ii < tasks.length; ii++)
            {
               tasksNode.add(new DefaultMutableTreeNode(tasks[ii]));
            }
            projectNode.add(tasksNode);
            
            
            tnProjects.add(projectNode);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
