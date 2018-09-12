package com.dommoni.roundtable.is;

import java.applet.Applet;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JApplet;

import com.dommoni.roundtable.is.ui.ISMainFrame;

public class ISClientApplet extends Applet
{
   public ISClientApplet()
   {
   }
   
   public void init()
   {
   }
   
   public void start()
   {
      try
      {
         /**
          * Need to read SessionID Param. Create Special 
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
         
         Iterator it = imageMap.values().iterator();
         for (int i = 0; it.hasNext(); i++)
         {
            tracker.addImage((Image)it.next(), i);
         }
         
         // TODO: Add "Loading Application..." Dialog.
         while(!tracker.checkAll(true));
         
         ISMainFrame isFrame = new ISMainFrame(imageMap);
         
         isFrame.setVisible(true);
      }
      catch(ISLoadException ile)
      {
         ile.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}
