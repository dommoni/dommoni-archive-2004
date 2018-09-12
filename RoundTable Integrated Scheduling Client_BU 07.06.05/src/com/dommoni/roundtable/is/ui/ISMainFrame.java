package com.dommoni.roundtable.is.ui;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.dommoni.roundtable.is.ISLoadException;
import com.dommoni.roundtable.is.ui.ganttpanel.CursorController;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttPanel;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionListener;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ZoomActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ZoomActionListener;

public class ISMainFrame extends JFrame
{
   GanttPanel ganttPanel;
   
   public ISMainFrame(Map imageMap) throws ISLoadException
   {
      if (imageMap == null)
      {
         throw new ISLoadException("Image Mapping Unavailable.");
      }
      
      Image img = (Image)imageMap.get("NewTask_ICO.jpg");
      //getGraphics().drawImage(img, 0, 0, null);
      
      this.setSize(640, 480);
      this.setTitle("RoundTable Integrated Scheduling Client");
      
      CursorController cc = new CursorController(this);
      ganttPanel = new GanttPanel(cc, imageMap);
//      ganttPanel.addTaskActionListener(new TaskActionListener() {
//         public void taskAdded(TaskActionEvent evt)
//         {
//            System.out.println("ISMainFrame.TaskActionListener - taskAdded received");
//         }
//         
//         public void taskDeleted(TaskActionEvent evt)
//         {
//            System.out.println("ISMainFrame.TaskActionListener - taskDeleted received");
//         }
//         
//         public void taskSelected(TaskActionEvent evt)
//         {
//            System.out.println("ISMainFrame.TaskActionListener - taskSelected received");
//         }
//         
//         public void taskDeselected(TaskActionEvent evt)
//         {
//            System.out.println("ISMainFrame.TaskActionListener - taskDeselected received");
//         }
//         
//         public void taskModified(TaskActionEvent evt)
//         {
//            System.out.println("ISMainFrame.TaskActionListener - taskModified received");
//         }
//      });
      
      ganttPanel.addZoomActionListener(new ZoomActionListener() {
         public void zoomAction(ZoomActionEvent evt)
         {
            System.out.println("ISMainFrame.ZoomActionListener - zoomAction received");
         }
      });
      
      ControlToolBar toolBar = new ControlToolBar(ganttPanel, imageMap);
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      container.add(toolBar);
      container.add(ganttPanel);
      
      getContentPane().add(container);
      
      /*addWindowListener(new WindowListener() {
         win
      });*/
      
      
      addComponentListener(new ComponentListener() {
         public void componentMoved(ComponentEvent e) {}
         
         public void componentResized(ComponentEvent e)
         {
            System.out.println("ISMainFrame.cl.componentResized...");
            ganttPanel.remapXCoords();
         }
         
         public void componentHidden(ComponentEvent e) {}
         public void componentShown(ComponentEvent e) {}
      });
   }
}
