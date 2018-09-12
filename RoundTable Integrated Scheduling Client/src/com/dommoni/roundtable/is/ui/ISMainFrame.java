package com.dommoni.roundtable.is.ui;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.ScheduleItem;
import com.dommoni.roundtable.is.ISLoadException;
import com.dommoni.roundtable.is.ISResourceRegistry;
import com.dommoni.roundtable.is.model.ScheduleTask;
import com.dommoni.roundtable.is.ui.ganttpanel.CursorController;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttException;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttPanel;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ControlsActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ControlsActionListener;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;

public class ISMainFrame extends JFrame implements ControlsActionListener
{
   GanttPanel ganttPanel;
   Schedule currentSchedule;
   
   public ISMainFrame(Map imageMap) throws ISLoadException
   {
      if (imageMap == null)
      {
         throw new ISLoadException("Image Data Unavailable.");
      }
           
      this.setSize(740, 480);
      this.setTitle("RoundTable Shared Scheduling Client");
      
      CursorController cursorController = new CursorController(this);
      ganttPanel = new GanttPanel(cursorController, imageMap);   
      
      ControlToolBar toolBar = new ControlToolBar(ganttPanel, imageMap);
      toolBar.addControlsActionListener(this);
      
      FormLayout formLayout = new FormLayout(
            "min(240px;pref), pref:grow, 10px",
            "10px, t:pref:grow, 10px");
      JPanel ganttContainer = new JPanel(formLayout);
      
      ItemInformationPanel iip = new ItemInformationPanel(this, ganttPanel, imageMap);
      SimpleInternalFrame sif = new SimpleInternalFrame("Task Information", null, iip);
      sif.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 10, 0, 10), 
            sif.getBorder()));
      
      /*ganttPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 0, 10, 10),
            ganttPanel.getBorder()));
      */
      CellConstraints cc = new CellConstraints();
      ganttContainer.add(sif, cc.xywh(1,2,1,1, 
            CellConstraints.DEFAULT, CellConstraints.FILL));
      ganttContainer.add(ganttPanel, cc.xywh(2,2,1,1, 
            CellConstraints.FILL, CellConstraints.FILL));
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      Box bx1 = Box.createHorizontalBox();
      bx1.add(toolBar);
      //bx1.add(Box.createHorizontalGlue());
      container.add(bx1, BorderLayout.WEST);
      container.add(ganttContainer);
      getContentPane().add(container);
            
      addComponentListener(new ComponentListener() {
         public void componentResized(ComponentEvent e)
         {
            ganttPanel.remapXCoords();
            ganttPanel.doResize();
            ganttPanel.doLayout();
         }
         public void componentMoved(ComponentEvent e) {}
         public void componentHidden(ComponentEvent e) {}
         public void componentShown(ComponentEvent e) {}
      });     
   }
   
   public ISMainFrame(Map imageMap, Schedule schedule) throws ISLoadException
   {
      this(imageMap);
      this.currentSchedule = schedule;
      
      if (currentSchedule != null)
         loadSchedule();
   }
   
   public void loadSchedule()
   {
      /*
       * What to do here:
       *   - go through foreach SchedItem and loadit...
       *   - 
       * */
      if (currentSchedule != null)
      {
         this.ganttPanel.setCurrentSchedule(currentSchedule);
         this.setTitle("RoundTable Shared Scheduling Client - " + currentSchedule.getName());
         
         // how to gaurantee ordinal?
         //    TODO: I think I need to add an Ord. Attr on item objs.
         ScheduleItem[] items = currentSchedule.getScheduleItems();
         if (items != null)
         {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            for (int i = 0; i < items.length; i++)
            {
               try
               {
                  ScheduleTask task = new ScheduleTask(items[i]);
                  this.ganttPanel.loadTask(task);
               }
               catch(Exception e)
               {
                  e.printStackTrace();
               }
            }
         }
      }
   }
   
   public void loadSchedule(Schedule schedule)
   {
      this.currentSchedule = schedule;
      this.loadSchedule();
   }
   
   public void close()
   {
      
   }
   
   // Controls Action Listener ------------------------------------------------
   //
   public void saveActionPerformed(ControlsActionEvent event)
   {
      boolean success = true;
      try
      {
         Schedule recentSched = ganttPanel.extractCurrentSchedule();
         ProjectServerConnection psc = 
            (ProjectServerConnection)ISResourceRegistry.getInstance().getResource("psc");
      
         psc.getScheduleManager().modifySchedule(recentSched);
      }
      catch (Exception e)
      {
         success = false;
         e.printStackTrace();
      }
      
      if (success)
      {   
         JOptionPane.showMessageDialog(null, 
               "Successfully Saved Schedule.");
      }
      else
      {   
         JOptionPane.showMessageDialog(null, 
               "Unable to Save Schedule to RoundTable. " +
               "Please contact your Administrator.");
      }
   }
   
   public void printActionPerformed(ControlsActionEvent event)
   {
   }
}
