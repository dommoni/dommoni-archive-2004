package com.dommoni.roundtable.is.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import sun.security.krb5.internal.bn;

import com.dommoni.roundtable.is.model.ScheduleTask;
import com.dommoni.roundtable.is.tmp.TempTask;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttException;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttPanel;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ControlsActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ControlsActionListener;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionListener;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ZoomActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ZoomActionListener;

public class ControlToolBar extends JToolBar
   implements TaskActionListener, ZoomActionListener
{
   GanttPanel ganttPanel;
   ScheduleTask selectedTask;
   
   ImageIcon icoAddTask;
   ImageIcon icoSaveSchedule;
   //ImageIcon icoPrintSchedule;
   ImageIcon icoDelTask;
   ImageIcon icoZoomIn;
   ImageIcon icoZoomOut;
   //ImageIcon icoResources;
      
   JButton bnAddTask;
   JButton bnSaveSchedule;
   //JButton bnPrintSchedule;
   JButton bnDelTask;
   JButton bnZoomIn;
   JButton bnZoomOut;
   //JButton bnResources;
   
   List controlsActionListeners;
   
   public ControlToolBar(GanttPanel ganttPanel, Map images)
   {
      this.ganttPanel = ganttPanel;
      
      this.setFloatable(false);
      this.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
    
      // Configure Icons
      icoAddTask = new ImageIcon((Image)images.get("NewTask_ICO.jpg"));
      icoSaveSchedule = new ImageIcon((Image)images.get("SaveSchedule_ICO.jpg"));
      //icoPrintSchedule = null;
      icoDelTask = new ImageIcon((Image)images.get("DeleteTask_ICO_FW.jpg"));
      icoZoomIn = new ImageIcon((Image)images.get("ZoomIn_ICO.jpg"));
      icoZoomOut = new ImageIcon((Image)images.get("ZoomOut_ICO.jpg"));
      //icoResources = null;

      // Add Task Button
      bnAddTask = new JButton(icoAddTask); 
      bnAddTask.setToolTipText("Create a new Task");
      bnAddTask.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               ScheduleTask t = new ScheduleTask();
               t.setName("t-" + ControlToolBar.this.ganttPanel.lineModel.size());
               
               ControlToolBar.this.ganttPanel.addTask(t);
            }
            catch(GanttException ex)
            {
               ex.printStackTrace();
            }
         }
      });
      add(bnAddTask);
      
      // Save Schedule Button
      bnSaveSchedule = new JButton(icoSaveSchedule);
      bnSaveSchedule.setToolTipText("Save Schedule");
      bnSaveSchedule.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            fireSaveActionPerformed(new ControlsActionEvent(ControlToolBar.this.ganttPanel.getCurrentSchedule()));
         }
      });
      add(bnSaveSchedule);
      
      // Print Schedule Button
      //bnPrintSchedule = new JButton("Print");
      //bnPrintSchedule.setToolTipText("Print Schedule");
      //add(bnPrintSchedule);
      
      // Delete Task Button
      bnDelTask = new JButton(icoDelTask);
      bnDelTask.setToolTipText("Delete Selected Task");
      bnDelTask.setEnabled(false);
      bnDelTask.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            // TODO: Add delete handling code... 
            try
            {
               if (ControlToolBar.this.selectedTask != null)
               {
                  ControlToolBar.this.ganttPanel.removeTask(
                        ControlToolBar.this.selectedTask);
               }
            }
            catch(GanttException ge)
            {
               ge.printStackTrace();
            }
            catch(Exception exc)
            {
               // TODO: Add Warning/Err Handling here...
               exc.printStackTrace();
            }
         }
      });
      add(bnDelTask);
      
      this.addSeparator();
      
      //
      // Zoom-In Button
      //
      bnZoomIn = new JButton(icoZoomIn);
      bnZoomIn.setToolTipText("Zoom In");
      bnZoomIn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            ControlToolBar.this.ganttPanel.zoomIn();
         }
      });
      add(bnZoomIn);
      
      //
      // Zoom-Out Button
      //
      bnZoomOut = new JButton(icoZoomOut);
      bnZoomOut.setToolTipText("Zoom Out");
      bnZoomOut.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            ControlToolBar.this.ganttPanel.zoomOut();
         }
      });
      add(bnZoomOut);
      
      this.addSeparator();
      
      //
      // Resources Button
      //
      //bnResources = new JButton("Resources");
      //bnResources.setToolTipText("View Project Resources");
      //add(bnResources);
      
      // Filler...
      add(Box.createGlue());
      
      ganttPanel.addTaskActionListener(this);
      ganttPanel.addZoomActionListener(this);
      
      this.controlsActionListeners = new Vector();
   }
   
   public void addControlsActionListener(ControlsActionListener listener)
   {
      if (listener != null)
         controlsActionListeners.add(listener);
   }
   
   public void removeControlsActionListener(ControlsActionListener listener)
   {
      controlsActionListeners.remove(listener);
   }
   
   public void fireSaveActionPerformed(ControlsActionEvent event)
   {
      Iterator it = controlsActionListeners.iterator();
      while (it.hasNext())
      {
         ControlsActionListener cal = 
            (ControlsActionListener)it.next();
         
         if (cal != null)
            cal.saveActionPerformed(event);
      }
   }
   
   public void firePrintActionPerformed(ControlsActionEvent event)
   {
      Iterator it = controlsActionListeners.iterator();
      while (it.hasNext())
      {
         ControlsActionListener cal = 
            (ControlsActionListener)it.next();
         
         if (cal != null)
            cal.saveActionPerformed(event);
      }
   }
   
   //--------------------------------------------------------------------------
   // TaskActionListener
   
   public void taskSelected(TaskActionEvent evt)
   {
      this.selectedTask = (ScheduleTask)evt.getSource();
      bnDelTask.setEnabled(true);
   }
   
   public void taskDeselected(TaskActionEvent evt)
   {
      this.selectedTask = null;
      bnDelTask.setEnabled(false);
   }
   
   public void taskAdded(TaskActionEvent evt) {}
   public void taskDeleted(TaskActionEvent evt) {}
   public void taskModified(TaskActionEvent evt) {}
   
   //--------------------------------------------------------------------------
   // ZoomActionListener
   
   public void zoomAction(ZoomActionEvent evt)
   {
      int zoomTo = evt.getZoomTo();
      if (zoomTo == GanttPanel.ZOOM_MAX)
      {
         bnZoomOut.setEnabled(false);
      }
      else
      {
         bnZoomOut.setEnabled(true);
      }
      
      if (zoomTo == GanttPanel.ZOOM_MIN)
      {
         bnZoomIn.setEnabled(false);
      }
      else
      {
         bnZoomIn.setEnabled(true);
      }
   }
}
