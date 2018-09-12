/*
 * Created on Mar 16, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.projectManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProjectManager implements IProjectManager
{
   //public int addProject(Event event, Project project)
   public int addProject(Project project)
   throws Exception
   {
      Connection connection = null;
      int projectId = -1;
      
      if(project == null)
         return -1;
         
      try
      {
         connection = ConnectionManager.getConnection();
         connection.setAutoCommit(false);
         
         PreparedStatement pstmt = connection.prepareStatement("insert into projects (name) values (?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setString(1, project.getName());
         pstmt.executeUpdate();
         
         Account members[] = project.getMembers();
         System.out.println("members.length: " + members.length);
         
         if(members != null && members.length > 0)
         {
            // mysql version: pstmt = connection.prepareStatement("select LAST_INSERT_ID() from projects");
            pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from projects", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery();
            rs.first();
            projectId = rs.getInt(1);
            
            pstmt = connection.prepareStatement("insert into project_accounts (project_id,account_id) values (?,?)");
            for(int i = 0; i < members.length; i++)
            {
               pstmt.setInt(1, projectId);
               pstmt.setInt(2, members[i].getId());
               pstmt.addBatch();
            }
            pstmt.executeBatch();
         }
         connection.commit();
      }
      catch(SQLException se)
      {
         try
         {
            connection.rollback();
         }
         catch(SQLException se2)
         {
            se2.printStackTrace();
         }
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
      return projectId;
   }
   
   /*public int addProject(Project project)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /**
    * Removes the specified project from the system.
    * 
    * @author Brian Abbott - brian@dommoni.com
    */
   //public void dropProject(Event event, int projectId)
   public void dropProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from projects where id=?");
         pstmt.setInt(1, projectId);
         pstmt.executeUpdate();

         pstmt = connection.prepareStatement("delete from project_accounts where project_id=?");
         pstmt.setInt(1, projectId);
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
         }
      }
   }
   
   /*public void dropProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyProject(Event event, Project project)
   public void modifyProject(Project project)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         connection.setAutoCommit(false);
         
         PreparedStatement pstmt = connection.prepareStatement("update projects set name=? where id=?");
         pstmt.setString(1, project.getName());
         pstmt.setInt(2, project.getId());
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from project_accounts where project_id=?");
         pstmt.setInt(1, project.getId());
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("insert into project_accounts (project_id, account_id) values (?,?)");
         Account accounts[] = project.getMembers();
         for(int i = 0; i < accounts.length; i++)
         {
            pstmt.setInt(1, project.getId());
            pstmt.setInt(2, accounts[i].getId());
            pstmt.addBatch();
         }
         pstmt.executeBatch();
         
         connection.commit();
      }
      catch(SQLException se)
      {
         try
         {
            connection.rollback();
         }
         catch(SQLException sqe)
         {
            sqe.printStackTrace();
         }
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
   }
   
   /*public void modifyProject(Project project)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Project getProject(Event event, int projectId)
   public Project getProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      Project project = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select name from projects where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            project = new Project();
            project.setId(projectId);
            project.setName(rs.getString(1));
            
            pstmt = connection.prepareStatement("select account_id from project_accounts where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, projectId);
            ResultSet rs2 = pstmt.executeQuery();
            
            AccountManager accountManager = new AccountManager();
            Vector accounts = new Vector();
            while(rs2.next())
            {
               try
               {
                  accounts.add(accountManager.getAccount(rs2.getInt(1)));//(event, rs2.getInt(1)));
               }
               catch(Exception e)
               {
                  e.printStackTrace();
               }
            }
            project.setMembers((Account[])accounts.toArray(new Account[accounts.size()]));
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
      return project;
   }
   
   /*public Project getProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Project[] getAllProjects(Event event)
   public Project[] getAllProjects()
   throws Exception
   {
      Vector projects = new Vector();
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from projects");
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            projects.add(getProject(rs.getInt(1)));//event, rs.getInt(1)));
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
      return (Project[])projects.toArray(new Project[projects.size()]);
   }
   
   /*public Project[] getAllProjects() 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
//   /public Project[] getAllProjectsForAccount(Event event, int accountId)
   public Project[] getAllProjectsForAccount(int accountId)
   throws Exception
   {
      Vector projects = new Vector();
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select project_id from project_accounts where account_id=?");
         pstmt.setInt(1, accountId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            projects.add(getProject(rs.getInt(1)));//event, rs.getInt(1)));
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
      return (Project[])projects.toArray(new Project[projects.size()]);
   }
   
   /*public Project[] getAllProjectsForAccount(int accountId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
}
