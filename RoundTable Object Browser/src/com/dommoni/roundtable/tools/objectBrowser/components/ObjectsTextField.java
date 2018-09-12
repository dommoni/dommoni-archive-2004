package com.dommoni.roundtable.tools.objectBrowser.components;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextField;

public class ObjectsTextField extends JTextField implements MouseListener
{
   Object valueObject;
   
   public ObjectsTextField()
   {
      super();
      
      this.addMouseListener(this);
   }
   
   public ObjectsTextField(String val)
   {
      super(val);
      this.addMouseListener(this);
   }
   
   public void mouseClicked(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }
   
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub
      this.setBackground(Color.BLACK);
      this.setForeground(Color.WHITE);
   }
   
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub
      this.setBackground(Color.WHITE);
      this.setForeground(Color.BLACK);
   }
   
   public void mousePressed(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }
}
