package com.dommoni.roundtable.is.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import com.dommoni.roundtable.is.tmp.TempTask;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttException;
import com.dommoni.roundtable.is.ui.ganttpanel.GanttPanel;

public class ControlToolBar extends JToolBar
{
   GanttPanel ganttPanel;
   ImageIcon ii;
   
   public ControlToolBar(GanttPanel ganttPanel, Map images)
   {
      this.ganttPanel = ganttPanel;
      
      this.setFloatable(false);
      this.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
      
      ii = new ImageIcon((Image)images.get("NewTask_ICO.jpg"));
      JButton bnAddTask = new JButton(ii); 
      bnAddTask.setToolTipText("Create a new Task");
      
      bnAddTask.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               TempTask t = new TempTask();
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
      
      JButton bnZoomIn = new JButton("In");
      bnZoomIn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            ControlToolBar.this.ganttPanel.zoomIn();
         }
      });
      add(bnZoomIn);
      
      JButton bnZoomOut = new JButton("Out");
      bnZoomOut.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            ControlToolBar.this.ganttPanel.zoomOut();
         }
      });
      add(bnZoomOut);
   }
   
   @Override
   public void paint(Graphics g)
   {
      // TODO Auto-generated method stub
      super.paint(g);
      
   }
}
