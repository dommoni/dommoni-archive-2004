package com.dommoni.roundtable.is;

import java.applet.Applet;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.is.ui.ISMainFrame;

import com.jgoodies.looks.LookUtils;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;

public class ISClientApplet extends JApplet implements WindowListener
{
   ISMainFrame isFrame = null;
   String parentPath = null;
   
   public ISClientApplet()
   {
   }
   
   public void init()
   {
      try {
         UIManager.put("ClassLoader", LookUtils.class.getClassLoader());
         LookUtils.setLookAndTheme(new PlasticXPLookAndFeel(), new ExperienceBlue());
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public void start()
   {
      super.start();
      
      try
      {
         /**
          * TODO: Need to read SessionID Param. Create Special 
          * Java WS Proxy. 
          */
         
         // Load our images and send through as a Map.
         MediaTracker tracker = new MediaTracker(this);
         Map imageMap = new HashMap();
         
         imageMap.put("h0_sn100_l60.jpg", 
               getImage(getCodeBase(), "h0_sn100_l60.jpg"));
         imageMap.put("lblue_grad.jpg", 
               getImage(getCodeBase(), "lblue_grad.jpg"));
         imageMap.put("blue_grad.jpg", 
               getImage(getCodeBase(), "blue_grad.jpg"));
         imageMap.put("column_gradient.jpg", 
               getImage(getCodeBase(), "column_gradient.jpg"));
         imageMap.put("column_gradient_spacer.jpg", 
               getImage(getCodeBase(), "column_gradient_spacer.jpg"));
         imageMap.put("NewTask_ICO.jpg", 
               getImage(getCodeBase(), "NewTask_ICO.jpg"));
         imageMap.put("DeleteTask_ICO_FW.jpg",
               getImage(getCodeBase(), "DeleteTask_ICO_FW.jpg"));
         imageMap.put("SaveSchedule_ICO.jpg",
               getImage(getCodeBase(), "SaveSchedule_ICO.jpg"));
         imageMap.put("ZoomIn_ICO.jpg",
               getImage(getCodeBase(), "ZoomIn_ICO.jpg"));
         imageMap.put("ZoomOut_ICO.jpg",
               getImage(getCodeBase(), "ZoomOut_ICO.jpg"));
         imageMap.put("CalendarCtl_ICO.jpg",
               getImage(getCodeBase(), "CalendarCtl_ICO.jpg"));
         imageMap.put("CalendarCtl_ICO_BLUE.jpg",
               getImage(getCodeBase(), "CalendarCtl_ICO_BLUE.jpg"));
         imageMap.put("TaskResources_ICO_SM_14x14.jpg",
               getImage(getCodeBase(), "TaskResources_ICO_SM_14x14.jpg"));
         imageMap.put("TaskResources_ICO_LG.jpg",
               getImage(getCodeBase(), "TaskResources_ICO_LG.jpg"));
         imageMap.put("TaskResources_ICO_MD.jpg",
               getImage(getCodeBase(), "TaskResources_ICO_MD.jpg"));
         imageMap.put("TaskResources_ICO_MDSM.jpg",
               getImage(getCodeBase(), "TaskResources_ICO_MDSM.jpg"));
         
         ISResourceRegistry.getInstance().addResource("images", imageMap);
         
         Iterator it = imageMap.values().iterator();
         for (int i = 0; it.hasNext(); i++)
         {
            tracker.addImage((Image)it.next(), i);
         }
         
         // TODO: Add "Loading Application..." Dialog.
         // TODO: Need to add checks to limit spin time...
         while(!tracker.checkAll(true));
         
         String szCurrentProject = getParameter("currentproject");
         String szUsername = getParameter("username");
         String szPassword = getParameter("password");
         String szScheduleId = getParameter("scheduleid");
         String szIpAddr = getParameter("ipaddr");
         String szPort = getParameter("port");
         
         parentPath = getParameter("parentpath");
         
         int iScheduleId = -1;
         int iProjectId = -1;
         int iPort = -1;
         
         try
         {
            iScheduleId = Integer.parseInt(szScheduleId);
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
         try
         {
            iProjectId = Integer.parseInt(szCurrentProject);
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
         try
         {
            iPort = Integer.parseInt(szPort);
         }
         catch(NumberFormatException nfe)
         {
            nfe.printStackTrace();
         }
         
         ProjectServerConnection psc = 
            new ProjectServerConnection(szUsername, szPassword, szIpAddr, iPort);
         psc.login();
         
         ISResourceRegistry.getInstance().addResource("psc", psc);
         
         psc.setCurrentProject(psc.getProjectManager().getProject(iProjectId));
         Schedule schedule = psc.getScheduleManager().getSchedule(iScheduleId);
         
         isFrame = new ISMainFrame(imageMap);
         isFrame.addWindowListener(this);
         isFrame.setVisible(true);
         
         isFrame.loadSchedule(schedule);
         
         isFrame.requestFocus();
      }
      catch(ISLoadException ile)
      {
         showConnectionFailureDialog();
         
         ile.printStackTrace();
      }
      catch(Exception e)
      {
         showConnectionFailureDialog();
         
         e.printStackTrace();
      }
      
      if (isFrame != null)
      {   
         isFrame.requestFocus();
      }
   }
   
   public void stop()
   {
      super.stop();
   }
   
   public void destroy()
   {
      super.destroy();
   }
   
   private void showConnectionFailureDialog()
   {
      JOptionPane.showMessageDialog(null, 
            "Unable to Connect to RoundTable Server. " +
            "Please contact your System Administrator.", "RoundTable Connection Error", 
            JOptionPane.ERROR_MESSAGE);
   }
   
   //--------------------------------------------------------------------------
   // WindowListener Methods...
   
   public void windowActivated(WindowEvent e) {}
   public void windowDeactivated(WindowEvent e) {}
   public void windowDeiconified(WindowEvent e) {}
   public void windowIconified(WindowEvent e) {}
   public void windowOpened(WindowEvent e) {}

   public void windowClosing(WindowEvent e) 
   {
      if (isFrame != null)
      {
         isFrame.dispose();
         isFrame = null;
      }
   }
      
   public void windowClosed(WindowEvent e) 
   {
      ISResourceRegistry.getInstance().close();
      
      System.gc();
      System.runFinalization();
      System.gc();
      System.runFinalization();
      
      // Unloads Applet? Should... or, at least get the tags out of the current html.
      if (parentPath != null)
      {
         try
         {
            getAppletContext().showDocument(new URL(parentPath), "_self");
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
      }
   }
}
