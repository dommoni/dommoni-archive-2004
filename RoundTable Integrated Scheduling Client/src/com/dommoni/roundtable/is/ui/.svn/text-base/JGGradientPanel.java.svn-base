package com.dommoni.roundtable.is.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.UIManager;

public class JGGradientPanel extends JPanel
{
   public JGGradientPanel() 
   {
      super();
   }
   
   public JGGradientPanel(boolean isDoubleBuffered) 
   {
      super(isDoubleBuffered);
   }
   
   public JGGradientPanel(LayoutManager layout) 
   {
      super(layout);
   }
   
   public JGGradientPanel(LayoutManager layout, 
         boolean isDoubleBuffered) 
   {
      super(layout, isDoubleBuffered);
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      Dimension d = getSize();
      Color control = UIManager.getColor("control");
      
      float whiteX = d.width -250;//- 200;
      float whiteY = d.height - 35;// - 200;

      GradientPaint gradient =
         new GradientPaint(d.width, d.height, new Color(210, 213, 242), whiteX, whiteY, Color.white, false);

      Graphics2D g2D = (Graphics2D) g;
      g2D.setPaint(gradient);
      g2D.fillRect(0, 0, d.width, d.height);
      setForeground(Color.white);
   }
}
