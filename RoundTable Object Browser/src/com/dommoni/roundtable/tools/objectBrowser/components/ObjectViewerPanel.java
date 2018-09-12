package com.dommoni.roundtable.tools.objectBrowser.components;

import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.RepaintManager;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.dommoni.roundtable.tools.objectBrowser.events.RepaintRequestListener;

public class ObjectViewerPanel extends JPanel implements TreeSelectionListener
{
   private Object displayObject;
   private EventListenerList repaintRequestListeners;
   
   public ObjectViewerPanel()
   {
      this.repaintRequestListeners = new EventListenerList();
      buildIntroPanel();
   }
   
   public void setDisplayObject(Object displayObject)
   {
      this.displayObject = displayObject;
      buildPanel();
   }
   
   public void buildIntroPanel()
   {
      add(new JLabel("<html><b>RoundTable Object Browser</b></html>"), BorderLayout.CENTER);
   }
   
   private void buildPanel()
   {
      System.out.println("BUilding PANLE");
      if (displayObject != null)
      {
         Class displayClass = displayObject.getClass();
         Field[] fields = displayClass.getDeclaredFields(); //displayClass.getFields(); 
         
         removeAll();
         update(getGraphics());
         
         JPanel scrollerp = new JPanel();
         scrollerp.setLayout(new BoxLayout(scrollerp, BoxLayout.Y_AXIS));
         JScrollPane scroller = new JScrollPane(scrollerp);
         
         //scroller.setLayout(new BoxLayout(scroller, BoxLayout.Y_AXIS));
         
         for (int i = 0; i < fields.length; i++)
         {
            System.out.println("Building Field: " + fields[i].getName());
            // 
            Box myBox = Box.createHorizontalBox();
            myBox.add(new JLabel(fields[i].getName() + ":"));
            
            try {
               int mod = fields[i].getModifiers();
               if (Modifier.isPrivate(mod))
               {
                  Method[] methods = displayClass.getMethods();
                  for (int j = 0; j < methods.length; j++)
                  {
                     if (methods[j].getName().toLowerCase().equals("get"+fields[i].getName().toLowerCase()))
                     {
                        // we've got our man...
                        System.out.println("RETNAME: " + methods[j].getReturnType().getName() + " || " + methods[j].getReturnType().isPrimitive());
                        Object val = 
                           methods[j].invoke(displayObject, new Object[] {});
                        if (val != null)
                        {   
                           if (methods[j].getReturnType().isPrimitive() || methods[j].getReturnType() == String.class)
                           {
                              myBox.add(new ObjectsTextField(val.toString()));
                           }
                           else if (val instanceof Calendar)
                           {
                              SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                              String szDate = sdf.format(((Calendar)val).getTime());
                              myBox.add(new ObjectsTextField(szDate));
                           }
                           else
                           {   
                              myBox.add(new ObjectsTextField("COMPLEX TYPE"));
                           }
                        }
                        else
                        {   
                           myBox.add(new ObjectsTextField("<NO VALUE>"));
                        }
                     }
                  }
               }
               else
               {
                  myBox.add(new JTextField( )); //fields[i].get(new Object()).toString()
               }
            } catch (Exception e) {
               e.printStackTrace();
            }
            scrollerp.add(myBox);
            
         }
         add(scroller);
      }
      else
      {
         JOptionPane.showMessageDialog(null, "Selected Object was Null");
      }
      fireRepaintRequest();
   }
   
   public void valueChanged(TreeSelectionEvent e)
   {
      JTree tree = (JTree)e.getSource();
      DefaultMutableTreeNode node = 
         (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
      Object selection = node.getUserObject();
      System.out.println("Selection: " + selection.getClass().getName());
      
      if (!(selection instanceof DefaultMutableTreeNode) && 
            !(selection instanceof String))
         setDisplayObject(selection); 
   }
   
   public void addRepaintRequestListener(RepaintRequestListener listener)
   {
      repaintRequestListeners.add(RepaintRequestListener.class, listener);
   }
   
   private void fireRepaintRequest()
   {
      RepaintRequestListener[] listeners = 
         repaintRequestListeners.getListeners(RepaintRequestListener.class);
      for (RepaintRequestListener listener : listeners)
      {
         listener.doRepaint();
      }
   }
}
