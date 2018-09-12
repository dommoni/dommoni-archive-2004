/*
 * Created on Mar 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.blogManager;

import com.dommoni.roundtable.Blog;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IBlogManager
{
   public void addBlog(Blog blog);
   
   public void dropBlog(int blogId);
   
   public void modifyBlog(Blog blog);
   
   public Blog getBlog(int blogId);
   
   public Blog[] getAllBlogs();
   
   public Blog getBlogForAccount(int accountId);
}
