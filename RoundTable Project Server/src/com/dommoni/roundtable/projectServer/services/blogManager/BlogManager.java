/*
 * Created on Mar 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.blogManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dommoni.roundtable.Blog;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BlogManager implements IBlogManager
{
   public void addBlog(Blog blog)
   {
      Connection connection = null;
      
      if(blog == null)
      {
         return;
      }
      
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ece");
         PreparedStatement pstmt = connection.prepareStatement("insert into blog (userId,projectId) values (?,?)");
      }
      catch(SQLException se)
      {
         se.printStackTrace();
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
   
   public void dropBlog(int blogId)
   {
   }
   
   public void modifyBlog(Blog blog)
   {
   }
   
   public Blog getBlog(int blogId)
   {
      return null;
   }
   
   public Blog[] getAllBlogs()
   {
      return null;
   }
   
   public Blog getBlogForAccount(int accountId)
   {
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ece");
         PreparedStatement pstmt = connection.prepareStatement("select id from blog where account_id=?");
         pstmt.setInt(1, accountId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first());
         {
            return getBlog(rs.getInt(1));
         }
      }
      catch(SQLException se)
      {
         se.printStackTrace();
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
      return null;
   }
}
