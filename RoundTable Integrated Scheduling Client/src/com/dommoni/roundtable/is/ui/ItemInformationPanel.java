package com.dommoni.roundtable.is.ui;

import java.awt.Component;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicBorders;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.ScheduleItem;
import com.dommoni.roundtable.is.ISResourceRegistry;
import com.dommoni.roundtable.is.model.ScheduleTask;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttPanel;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttTask;
import com.dommoni.roundtable.is.ui.ganttpanel.Line;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ResourceUpdateEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ResourceUpdateListener;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.TaskActionListener;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class ItemInformationPanel extends JPanel 
   implements TaskActionListener, ResourceUpdateListener //, ZoomActionListener
{
   private GanttPanel ganttPanel;
   private JFrame parentFrame;
   private ScheduleTask currentTask  = null;
   
   
   private JLabel lbTaskName;
   private JTextField tfTaskName;
   
   private JLabel lbStartDate;
   private JTextField tfStartDate;
   private JButton bnStartDateCtl;
   
   private JLabel lbEndDate;
   private JTextField tfEndDate;
   private JButton bnEndDateCtl;
   
   private JLabel lbDuration;
   private JTextField tfDuration;
   
   //--------------------------------
   private JLabel lbAssignedResources;
   private JTextField tfAssignedResources;
   private JButton bnAssignedResourcesCtl;
   
   private JLabel lbPercentComplete;
   private JSpinner tfPercentComplete;
   
   private JLabel lbPriority;
   private JSpinner tfPriority;
   
   //--------------------------------
   private JLabel lbNotes;
   private JButton bnNotes;
   
   //private JLabel lbUserComments;
   //private JButton bnUserComments;
   
   private JButton bnCancel;
   private JButton bnSave;
   
   public ItemInformationPanel(JFrame parentFrame, GanttPanel ganttPanel, Map resources)
   {
      this.ganttPanel = ganttPanel;
      this.parentFrame = parentFrame;
      
      ImageIcon icoCalendarControl = 
         new ImageIcon((Image)resources.get("CalendarCtl_ICO.jpg"));//"CalendarCtl_ICO.jpg"));
      ImageIcon icoResourcesControl = 
         new ImageIcon((Image)resources.get("TaskResources_ICO_SM_14x14.jpg"));
      
      FormLayout formLayout = new FormLayout(
            "5, pref, 10, pref:grow,4px, pref, 5", 
            "pref, 4px, pref, 4px, pref, 4px, " +
            "pref, 4px, pref, 4px, pref, 4px, " +
            "pref, 4px, pref, 4px, pref, 4px, " +
            "pref, 4px, pref");
      JPanel container = new JPanel(formLayout);
      
      CellConstraints cc = new CellConstraints();
      
      lbTaskName = new JLabel("Task Name");
      tfTaskName = new JTextField(10);
      container.add(lbTaskName, cc.xy(2, 1));
      container.add(tfTaskName, cc.xy(4, 1));
      
      lbStartDate = new JLabel("Start Date");
      tfStartDate = new JTextField(10);
      bnStartDateCtl = new JButton(icoCalendarControl);
      configureControlButton(bnStartDateCtl);
      bnStartDateCtl.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            DateChooser dc = new DateChooser(ItemInformationPanel.this.parentFrame, 
                  "Select Start Date");
            dc.setLocation(ItemInformationPanel.this.parentFrame.getLocation().x + 200, 
                  ItemInformationPanel.this.parentFrame.getLocation().y + 125);
            Date startDate = dc.select(currentTask.getStartDate().getTime());
            
            if (startDate != null)
            {
               SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
               tfStartDate.setText(sdf.format(startDate));
               
               currentTask.getStartDate().setTime(startDate);
               
               long days = ((currentTask.getEndDate().getTimeInMillis() -
                  currentTask.getStartDate().getTimeInMillis()) / (24 * 60 * 60 * 1000));
               
               if ((currentTask.getDuration() % (int)currentTask.getDuration()) > 0 ||
                     currentTask.getDuration() < 1) 
               {
                  float fdays = (float)days + 0.5f;
                  currentTask.setDuration(fdays);
               }
               else        
               {
                  currentTask.setDuration((float)days);
               }
               
               ItemInformationPanel.this.ganttPanel.updateTaskFromControlChange();
            }
         }
      });

      container.add(lbStartDate, cc.xy(2, 3));
      container.add(tfStartDate, cc.xy(4, 3));
      container.add(bnStartDateCtl, cc.xy(6, 3));
      
      lbEndDate = new JLabel("End Date");
      tfEndDate = new JTextField(10);
      bnEndDateCtl = new JButton(icoCalendarControl);
      configureControlButton(bnEndDateCtl);
      bnEndDateCtl.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            DateChooser dc = new DateChooser(ItemInformationPanel.this.parentFrame, 
                  "Select End Date");
            dc.setLocation(ItemInformationPanel.this.parentFrame.getLocation().x + 200, 
                  ItemInformationPanel.this.parentFrame.getLocation().y + 149);
            Date endDate = dc.select(currentTask.getEndDate().getTime());
            
            if (endDate != null)
            {
               SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
               tfEndDate.setText(sdf.format(endDate));
               
               currentTask.getEndDate().setTime(endDate);
               
               long days = ((currentTask.getEndDate().getTimeInMillis() -
                  currentTask.getStartDate().getTimeInMillis()) / (24 * 60 * 60 * 1000));
               
               if ((currentTask.getDuration() % (int)currentTask.getDuration()) > 0 ||
                     currentTask.getDuration() < 1) 
               {
                  float fdays = (float)days + 0.5f;
                  currentTask.setDuration(fdays);
               }
               else        
               {
                  currentTask.setDuration((float)days);
               }
               
               ItemInformationPanel.this.ganttPanel.updateTaskFromControlChange();
            }
         }
      });
      
      container.add(lbEndDate, cc.xy(2, 5));
      container.add(tfEndDate, cc.xy(4, 5));
      container.add(bnEndDateCtl, cc.xy(6, 5));
      
      lbDuration = new JLabel("Duration");
      tfDuration = new JTextField(10);
      tfDuration.addKeyListener(new KeyListener() {
         public void keyPressed(KeyEvent e) {}
         public void keyTyped(KeyEvent e) {}
         
         public void keyReleased(KeyEvent e)
         {
            if (e.getKeyCode() == KeyEvent.VK_ENTER || 
                  e.getKeyCode() == KeyEvent.VK_TAB)
            {
               try
               {
                  Float f = new Float(tfDuration.getText());
                  currentTask.setDuration(f.floatValue());
                  handleTaskDurationChange();
                  
                  ItemInformationPanel.this.ganttPanel.updateTaskFromControlChange();
                  
                  loadTask(currentTask);
               }
               catch(Exception exc)
               {
                  JOptionPane.showMessageDialog(null, "Error: Invalid Value");
                  tfDuration.setText(Float.toString(currentTask.getDuration()));
               }
            }
         }
      });
      container.add(lbDuration, cc.xy(2, 7));
      container.add(tfDuration, cc.xy(4, 7));
      
      // res---
      lbAssignedResources = new JLabel("Resources");
      tfAssignedResources = new JTextField(10);
      tfAssignedResources.setEditable(false);
      bnAssignedResourcesCtl = new JButton(icoResourcesControl);
      configureControlButton(bnAssignedResourcesCtl);
      bnAssignedResourcesCtl.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            TaskResourcesEditorDialog tred = null;
            try
            {
               ProjectServerConnection psc = 
                  (ProjectServerConnection)ISResourceRegistry.getInstance().getResource("psc");
               Account[] projectMembers = 
                  psc.getAccountManager().getAllAccountsForProject(psc.getCurrentProject().getId());
            
               tred = new TaskResourcesEditorDialog(
                     ItemInformationPanel.this.parentFrame, currentTask, projectMembers);
  
               tred.addResourceUpdateListener(ItemInformationPanel.this);
               tred.setVisible(true);              
            }
            catch(Exception ex)
            {
               if (tred != null)
               {   
                  tred.setVisible(false);
               }
               JOptionPane.showMessageDialog(null, "Error Retrieving Project Members List.", 
                     "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
         }
      });
      container.add(lbAssignedResources, cc.xy(2, 9));
      container.add(tfAssignedResources, cc.xy(4, 9));
      container.add(bnAssignedResourcesCtl, cc.xy(6, 9));
      
      lbPercentComplete = new JLabel("Pct. Complete");
      tfPercentComplete = new JSpinner();
      tfPercentComplete.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e)
         {
            Object val = ((JSpinner)e.getSource()).getValue();
            
            if (val instanceof Integer)
            {
               int iVal = ((Integer)val).intValue();
               if (iVal > 100)
               {   
                  iVal = 100;
                  ((JSpinner)e.getSource()).setValue(new Integer(iVal));
               }
               if (iVal < 0)
               {   
                  iVal = 0;
                  ((JSpinner)e.getSource()).setValue(new Integer(iVal));
               }
               
               if (currentTask != null)
                  currentTask.setPercentComplete(iVal);
            }
         }
      });
      container.add(lbPercentComplete, cc.xy(2, 11));
      container.add(tfPercentComplete, cc.xy(4, 11));
      
      lbPriority = new JLabel("Priority");
      tfPriority = new JSpinner();
      tfPriority.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e)
         {
            Integer iVal = (Integer)((JSpinner)e.getSource()).getValue();
            //currentTask.setPriority(iVal.intValue());
         }
      });
      container.add(lbPriority, cc.xy(2, 13));
      container.add(tfPriority, cc.xy(4, 13));
      
      // comments---
      lbNotes = new JLabel("Description");
      bnNotes = new JButton("Edit");
      bnNotes.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            TaskDescriptionEditor tde = new TaskDescriptionEditor(
                  ItemInformationPanel.this.parentFrame, currentTask);
            tde.setVisible(true);
         }
      });
      container.add(lbNotes, cc.xy(2, 15));
      container.add(bnNotes, cc.xy(4, 15));
      
      //lbUserComments = new JLabel("User Comments");
      //bnUserComments = new JButton("Comments");
      //container.add(lbUserComments, cc.xy(2, 17));
      //container.add(bnUserComments, cc.xy(4, 17));
      
      container.add(Box.createVerticalStrut(10), cc.xy(2, 19));
      
      bnSave = new JButton("Save");
      bnSave.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            
            ItemInformationPanel.this.ganttPanel.updateTaskFromControlChange();
         }
      });
      
      bnCancel = new JButton("Cancel");
      //container.add(bnSave, cc.xy(2, 21));
      //container.add(bnCancel, cc.xy(4, 21));
      
      add(container);
      ganttPanel.addTaskActionListener(this);
      
      unloadTask();
   }
   
   public synchronized void loadTask(ScheduleTask task)
   {
      currentTask = task;
      
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      
      tfTaskName.setEnabled(true);
      tfTaskName.setText(task.getName());
      
      tfStartDate.setText(sdf.format(task.getStartDate().getTime()));
      tfStartDate.setEnabled(true);
      
      tfEndDate.setText(sdf.format(task.getEndDate().getTime()));
      tfEndDate.setEnabled(true);
      
      tfDuration.setText(Float.toString(task.getDuration()));
      tfDuration.setEnabled(true);
      
      tfAssignedResources.setText("");
      tfAssignedResources.setEnabled(true);
      setResourcesText(task.getResources());
      
      tfPercentComplete.setEnabled(true);
      tfPercentComplete.setValue(task.getPercentComplete());
      
      tfPriority.setEnabled(true);
      tfPriority.setValue(task.getPriority());
      
      bnSave.setEnabled(true);
      bnCancel.setEnabled(true);
      bnNotes.setEnabled(true);
      //bnUserComments.setEnabled(true);
      bnStartDateCtl.setEnabled(true);
      bnEndDateCtl.setEnabled(true);
      bnAssignedResourcesCtl.setEnabled(true);
   }
   
   public synchronized void unloadTask()
   {
      currentTask = null;
      
      tfTaskName.setText("");
      tfTaskName.setEnabled(false);
      
      tfStartDate.setText("");
      tfStartDate.setEnabled(false);
      
      tfEndDate.setText("");
      tfEndDate.setEnabled(false);
      
      tfDuration.setText("");
      tfDuration.setEnabled(false);
      
      tfAssignedResources.setText("");
      tfAssignedResources.setEnabled(false);
      
      tfPercentComplete.setValue(new Integer(0));
      tfPercentComplete.setEnabled(false);

      tfPriority.setValue(new Integer(0));
      tfPriority.setEnabled(false);

      bnSave.setEnabled(false);
      bnCancel.setEnabled(false);
      bnNotes.setEnabled(false);
      //bnUserComments.setEnabled(false);
      bnStartDateCtl.setEnabled(false);
      bnEndDateCtl.setEnabled(false);
      bnAssignedResourcesCtl.setEnabled(false);
   }
   
   private void configureControlButton(JButton bn)
   {
      if (bn != null)
      {
         bn.setRolloverEnabled(true);
         bn.setMargin(new Insets(0,0,0,0));
         bn.setBorder(createRolloverBorder());
      }
   }
   
   private void handleTaskDurationChange()
   {
      long time = currentTask.getStartDate().getTimeInMillis() + 
         (long)(currentTask.getDuration() * (24 * 60 * 60 * 1000));
      currentTask.getEndDate().setTimeInMillis(time);
   }
   
   public void setResourcesText(Account[] resources)
   {
      if (resources != null && resources.length > 0)
      {
         // Build a name string and set it to tfRes...
         StringBuffer sb = new StringBuffer();
         for (int i = 0; i < resources.length; i++)
         {
            try
            {
               if (i > 0)
                  sb.append(", ");
               
               sb.append(resources[i].getName());
            }
            catch(Exception ex)
            {
            }
         }
         tfAssignedResources.setText(sb.toString());
      }
   }
   
   //--------------------------------------------------------------------------
   // TaskActionListener
   
   public void taskAdded(TaskActionEvent evt)
   {
      if (evt != null && evt.getSource() != null)
      {
         // deselect all existing tasks
         List lines = ganttPanel.lineModel.getLines();
         for (int i = 0; i < lines.size(); i++)
         {
            try
            {
               ((Line)lines.get(i)).task.setSelected(false);
            }
            catch(Exception e)
            {
            }
         }
         
         ScheduleTask task = (ScheduleTask)evt.getSource();
         task.setSelected(true);
         loadTask(task);
      }
   }
   
   public void taskDeleted(TaskActionEvent evt)
   {
   }
   
   public void taskDeselected(TaskActionEvent evt)
   {
      unloadTask();
   }
   
   public void taskModified(TaskActionEvent evt)
   {
      GanttTask task = (GanttTask)evt.getSource();
      if (task != null && task.equals(currentTask))
         loadTask((ScheduleTask)evt.getSource());
   }
   
   public void taskSelected(TaskActionEvent evt)
   {
      loadTask((ScheduleTask)evt.getSource());
   }
   
   //--------------------------------------------------------------------------
   // ResourceUpdateListener
   
   public void resourcesUpdated(ResourceUpdateEvent evt)
   {
      if (evt != null)
      {
         ScheduleTask task = (ScheduleTask)evt.getSource();
         Account[] resources = task.getResources();
         setResourcesText(resources);
      }
   }
   
   //--------------------------------------------------------------------------
   // Border
   
   /**
    * A border which is like a Margin border but it will only honor the margin
    * if the margin has been explicitly set by the developer.
    * 
    * Note: This is identical to the package private class
    * MetalBorders.RolloverMarginBorder and should probably be consolidated.
    */
   static class MyRolloverMarginBorder extends javax.swing.border.EmptyBorder 
   {
      public MyRolloverMarginBorder() 
      {
          super(0, 0, 0, 0); // hardcoded margin for JLF requirements.
      }
   
      public Insets getBorderInsets(Component c) 
      {
          return getBorderInsets(c, new Insets(0,0,0,0));
      }
   
      public Insets getBorderInsets(Component c, Insets insets) 
      {
          Insets margin = null;
   
          if (c instanceof AbstractButton) 
          {
             margin = ((AbstractButton)c).getMargin();
          }
          if (margin == null || margin instanceof UIResource) 
          {
               // default margin so replace
               insets.left = left;
               insets.top = top;
               insets.right = right;
               insets.bottom = bottom;
          } 
          else 
          {
               // Margin which has been explicitly set by the user.
               insets.left = margin.left;
               insets.top = margin.top;
               insets.right = margin.right;
               insets.bottom = margin.bottom;
          }
          return insets;
      }
   }
   
   private Border createRolloverBorder() 
   {
      Object border = UIManager.get("ToolBar.rolloverBorder");
      if (border != null) 
      {
          return (Border)border;
      }
      
      UIDefaults table = UIManager.getLookAndFeelDefaults();
      
      return new CompoundBorder(
            new BasicBorders.RolloverButtonBorder(
                  table.getColor("controlShadow"), table.getColor("controlDkShadow"),
                  table.getColor("controlHighlight"), table.getColor("controlLtHighlight")),
              new MyRolloverMarginBorder());
   }
}
