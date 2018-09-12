package com.dommoni.ece.webui;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class WebUIServlet extends HttpServlet
{
   public void init(ServletConfig config) throws ServletException
   {
      // read the menu-items from menu-config.xml
      UIConfigurationParser parser = new UIConfigurationParser(new File(config.getServletContext().getRealPath("/WEB-INF") + "/ui-configuration.xml"));
      WebUIConfiguration.getInstance().consumeParser(parser);
      
      // Set the scheduling applets path property...
      findSchedulingResources(config);
      
      try
      {
         XMLProperties xmlp = new XMLProperties(new File(config.getServletContext().getRealPath("/ini") + "/server-configuration.xml"));
         
         config.getServletContext().setAttribute("projectServerIpAddress", xmlp.getProperty("projectServerIpAddress"));
         config.getServletContext().setAttribute("projectServerPort", xmlp.getProperty("projectServerPort"));
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   private void findSchedulingResources(ServletConfig config) 
   {
      try
      {
         String varVal = "ssc_path";
         String ssDir = "sslib";
         
         StringBuffer sb = new StringBuffer();
         File sslibDir = new File(config.getServletContext().getRealPath("/sslib"));
         File[] files = sslibDir.listFiles();
         for (int i = 0; i < files.length; i++)
         {
            if (i > 0)
               sb.append(",");
            sb.append(ssDir + "/" + files[i].getName());
         }
         
         WebUIConfiguration.getInstance().setConfigurationVar(varVal, sb.toString());
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}
/*
 *
 * $Log: WebUIServlet.java,v $
 * Revision 1.2  2005/10/16 05:46:00  brian
 * Added helper method for storing SharedScheduling resources.
 *
 *
 */