/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProjectServerServlet extends HttpServlet
{
   ProjectServer projectServer;
   
   public void init(ServletConfig config) throws ServletException
   {
      super.init();
     
      projectServer = ProjectServer.getInstance();
      projectServer.init();
      
      projectServer.setConfig(config);
   }
   
   public void destroy() 
   {
      if(projectServer != null)
      {
         projectServer.shutdown();
      }
      
      super.destroy();
   }
}
/*
 * 
 * $Log: ProjectServerServlet.java,v $
 * Revision 1.2  2005/03/23 08:50:27  brian
 * Added footer.
 *
 * 
 */