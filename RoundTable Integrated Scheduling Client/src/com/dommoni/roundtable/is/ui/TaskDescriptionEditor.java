package com.dommoni.roundtable.is.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dommoni.roundtable.ScheduleItem;

public class TaskDescriptionEditor extends JDialog
{
   private ScheduleItem scheduleItem;
   private JTextArea textArea;
   private JButton bnOkay;
   private JButton bnCancel;
   
   public TaskDescriptionEditor(JFrame parentFrame, ScheduleItem scheduleItem)
   {
      super((Frame)null, "Edit Description", true);
      
      setResizable(false);
      this.scheduleItem = scheduleItem;
      
      JPanel container = new JPanel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
      
      bnOkay = new JButton("Okay");
      bnOkay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            TaskDescriptionEditor.this.scheduleItem.setDescription(textArea.getText());
            setVisible(false);
         }
      });
      
      bnCancel = new JButton("Cancel");
      bnCancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            setVisible(false);
         }
      });
      
      textArea = new JTextArea(10, 40);
      textArea.setLineWrap(true);
      if (this.scheduleItem != null)
      {
         textArea.setText(this.scheduleItem.getDescription());
      }
      
      JScrollPane jsp = new JScrollPane(textArea);
      jsp.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10),
            jsp.getBorder()
      ));
      
      Box bx0 = Box.createHorizontalBox();
      bx0.add(jsp);
      container.add(bx0);
      
      Box bx1 = Box.createHorizontalBox();
      bx1.add(Box.createHorizontalGlue());
      bx1.add(bnOkay);
      bx1.add(Box.createHorizontalStrut(15));
      bx1.add(bnCancel);
      bx1.add(Box.createHorizontalGlue());
      
      container.add(bx1);
      
      Box bx2 = Box.createHorizontalBox();
      bx2.add(Box.createVerticalStrut(10));
      container.add(bx2);
      
      getContentPane().add(container);
      
      if (parentFrame != null)
      {
         setLocation(parentFrame.getLocation().x + 200, 
               parentFrame.getLocation().y + 200);
      }
      
      pack();
   }
}
