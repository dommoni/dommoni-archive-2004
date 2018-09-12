package com.dommoni.roundtable.is.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.is.ISResourceRegistry;
import com.dommoni.roundtable.is.model.ScheduleTask;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ResourceUpdateEvent;
import com.dommoni.roundtable.is.ui.ganttpanel.events.ResourceUpdateListener;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class TaskResourcesEditorDialog extends JDialog
{
   private ScheduleTask task;
   private JFrame parentFrame;
   
   JList lstAllMembers;
   JList lstSelectedMembers;
   
   Vector allMembers;
   Vector selectedMembers;
   
   List resourceListeners;
   
   public TaskResourcesEditorDialog(JFrame parentFrame, ScheduleTask task, Account[] projectMembers)
   {
      super(parentFrame, "Assign Task Resources");
      
      int xloc, yloc;
      if (parentFrame != null)
      {   
         Point parentLocation = parentFrame.getLocation();
         xloc = (int)parentLocation.getX() + 150;
         yloc = (int)parentLocation.getY() + 150;
         //parentLocation
      }
      else
      {   
         xloc = 150;
         yloc = 150;
      }
      setLocation(xloc, yloc);
      
      //setSize(400, 300);
      this.parentFrame = parentFrame;
      this.task = task;
      
      // TODO: Create a ProgressBar showing activity during connection...
      allMembers = new Vector();
      for (int i =0; i < projectMembers.length; i++)
         allMembers.add(projectMembers[i]);
      
      Account[] actualResources = task.getResources();
      selectedMembers = new Vector();
      for (int i = 0; i < actualResources.length; i++)
         selectedMembers.add(actualResources[i]);
      
      // Find duplicate resources in 'ALL' List and remove them.
      if (actualResources != null && actualResources.length > 0)
      {
         for (int i = 0; i < actualResources.length; i++)
         {
            for (int j = 0; j < allMembers.size(); j++)
            {
               Account acc = (Account)allMembers.get(j);
               if (acc.getId() == actualResources[i].getId())
               {   
                  allMembers.remove(j);
               }
            }  
         }
      }
      
      resourceListeners = new Vector();
      
      JPanel outerContainer = new JPanel();
      outerContainer.setLayout(new BoxLayout(outerContainer, BoxLayout.Y_AXIS));
      
      //
      // Gradient Header Panel...
      //
      FormLayout flGradientLayout = new FormLayout(
            "30px, pref, 30px, pref:grow", 
            "15px, pref, 10px");
      JPanel grdHeaderPanel = new JGGradientPanel(flGradientLayout);
      grdHeaderPanel.setSize(this.getWidth(), 60);
      grdHeaderPanel.setBackground(Color.WHITE);
      Map imageMap = (Map)ISResourceRegistry.getInstance().getResource("images");
      Image imgTaskResources = (Image)imageMap.get("TaskResources_ICO_MDSM.jpg");
      JLabel lbResourcesIcon = new JLabel(new ImageIcon(imgTaskResources));
      CellConstraints grdCell = new CellConstraints();
      
      grdHeaderPanel.add(lbResourcesIcon, grdCell.xy(2, 2));
      grdHeaderPanel.add(new JLabel("<html><b><font size=4>Assign Task Resources</font></b></html>"), grdCell.xy(4, 2));
      
      FormLayout formLayout = new FormLayout(
            "35px, pref, 15px, pref, 15px, pref, 35px", 
            "15px, pref, 15px");
      JPanel container = new JPanel(formLayout);
      CellConstraints cc = new CellConstraints();
      
      lstAllMembers = new JList();
      lstAllMembers.setFixedCellWidth(90);
      lstAllMembers.setVisibleRowCount(10);
      lstAllMembers.setDragEnabled(true);
      lstAllMembers.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      lstAllMembers.setListData(allMembers);
      JScrollPane jspListAllMembers = new JScrollPane(lstAllMembers, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      
      lstSelectedMembers = new JList();
      lstSelectedMembers.setFixedCellWidth(90);
      lstSelectedMembers.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      lstSelectedMembers.setVisibleRowCount(10);
      lstSelectedMembers.setListData(selectedMembers);
      JScrollPane jspSelectedMembers = new JScrollPane(lstSelectedMembers, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      
      JButton bnToSelected = new JButton(">");
      bnToSelected.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            Object[] selection = lstAllMembers.getSelectedValues();
            for (int i = 0; i < selection.length; i++)
            {
               allMembers.remove(selection[i]);
               selectedMembers.add(selection[i]);
            }
            lstAllMembers.setListData(allMembers);
            lstSelectedMembers.setListData(selectedMembers);
         }
      });
      
      JButton bnAllToSelected = new JButton(">>");
      bnAllToSelected.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            Account[] members = 
               (Account[])allMembers.toArray(new Account[allMembers.size()]);
            allMembers.clear();
            for (int i = 0; i < members.length; i++)
            {
               selectedMembers.add(members[i]);
            }
            lstAllMembers.setListData(allMembers);
            lstSelectedMembers.setListData(selectedMembers);
         }
      });
      
      JButton bnFromSelected = new JButton("<");
      bnFromSelected.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            Object[] selection = lstSelectedMembers.getSelectedValues();
            for (int i = 0; i < selection.length; i++)
            {
               allMembers.add(selection[i]);
               selectedMembers.remove(selection[i]);
            }
            lstAllMembers.setListData(allMembers);
            lstSelectedMembers.setListData(selectedMembers);
         }
      });
      
      JButton bnAllFromSelected = new JButton("<<");
      bnAllFromSelected.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            Account[] members = 
               (Account[])selectedMembers.toArray(new Account[allMembers.size()]);
            selectedMembers.clear();
            for (int i = 0; i < members.length; i++)
            {
               allMembers.add(members[i]);
            }
            lstAllMembers.setListData(allMembers);
            lstSelectedMembers.setListData(selectedMembers);
         }
      });
      
      FormLayout flControlsLayout = new FormLayout(
            "pref:grow", 
            "pref, 10px, pref, 10px, pref, 10px, pref");
      JPanel controlsPanel = new JPanel(flControlsLayout);
      CellConstraints ccButtons = new CellConstraints();
      controlsPanel.add(bnToSelected, ccButtons.xy(1, 1));
      controlsPanel.add(bnAllToSelected, ccButtons.xy(1, 3));
      controlsPanel.add(bnFromSelected, ccButtons.xy(1, 5));
      controlsPanel.add(bnAllFromSelected, ccButtons.xy(1, 7));
      
      container.add(jspListAllMembers, cc.xy(2, 2));
      container.add(controlsPanel, cc.xy(4, 2));
      container.add(jspSelectedMembers, cc.xy(6, 2));
      
      FormLayout flSaveCancel = new FormLayout(
            "pref:grow, pref, 25px, pref , pref:grow", 
            "10px, pref, 25px");
      JPanel saveCancelControls = new JPanel();
      JButton bnSave = new JButton("Save");
      bnSave.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            // grab the selecteds as an array...
            Account[] selectedResources = 
               (Account[])selectedMembers.toArray(new Account[selectedMembers.size()]);
            TaskResourcesEditorDialog.this.task.setResources(selectedResources);
         
            TaskResourcesEditorDialog.this.setVisible(false);
            
            fireResourceUpdateEvent(
                  new ResourceUpdateEvent(TaskResourcesEditorDialog.this.task));
         }
      });
      
      JButton bnCancel = new JButton("Cancel");
      bnCancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            TaskResourcesEditorDialog.this.setVisible(false);
         }
      });
      
      CellConstraints ccSaveCancel = new CellConstraints();
      saveCancelControls.add(bnSave, cc.xy(2,2));
      saveCancelControls.add(Box.createHorizontalStrut(25), cc.xy(3, 2));
      saveCancelControls.add(bnCancel, cc.xy(4, 2));
      saveCancelControls.add(Box.createVerticalGlue(), cc.xy(2, 3));
      
      // add the gradient
      Box bx1 = Box.createHorizontalBox();
      bx1.add(grdHeaderPanel);
      outerContainer.add(bx1);
      
      // add a one pixel spacer...
      JPanel spacer = new JPanel() {
         public java.awt.Dimension getPreferredSize() 
         {
            return new Dimension(TaskResourcesEditorDialog.this.getWidth(), 1);
         }
      };
      spacer.setBackground(Color.black);
      bx1 = Box.createHorizontalBox();
      bx1.add(spacer);
      outerContainer.add(bx1);
      
      // add selection
      bx1 = Box.createHorizontalBox();
      bx1.add(container);
      outerContainer.add(bx1);
      
      // add save/close
      bx1 = Box.createHorizontalBox();
      bx1.add(saveCancelControls);
      outerContainer.add(bx1);
      
      getContentPane().add(outerContainer);
      
      pack();
      setResizable(false);
   }
   
   public void addResourceUpdateListener(ResourceUpdateListener resourceUpdateListener)
   {
      this.resourceListeners.add(resourceUpdateListener);
   }
   
   public void removeResourceUpdateListener(ResourceUpdateListener resourceUpdateListener)
   {
      this.resourceListeners.remove(resourceUpdateListener);
   }
   
   private void fireResourceUpdateEvent(ResourceUpdateEvent evt)
   {
      if (evt != null)
      {
         Iterator it = resourceListeners.iterator();
         while (it.hasNext())
         {
            try
            {
               ResourceUpdateListener rul = (ResourceUpdateListener)it.next();
               if (rul != null)
               {
                  rul.resourcesUpdated(evt);
               }
            }
            catch(Exception e)
            {
               // just eat it... 
            }
         }
      }
   }
}
