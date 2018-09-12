package com.dommoni.roundtable.tools.objectBrowser;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.RepaintManager;

import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.tools.objectBrowser.components.ObjectViewerPanel;
import com.dommoni.roundtable.tools.objectBrowser.components.ObjectsTree;
import com.dommoni.roundtable.tools.objectBrowser.events.RepaintRequestListener;

public class ObjectBrowserMain extends JFrame implements RepaintRequestListener
{
   ProjectServerConnection connection = null;
   String username;
   String password;
   String ipaddress;
   int port;
   
   public ObjectBrowserMain()
   {
      username = "administrator";
      password = "dommoni";
      ipaddress = "localhost";
      port = 8080;
      connect();
      
      setContentPane(buildContentPane());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(640, 480);
   }
   
   JSplitPane split;
   private JComponent buildContentPane()
   {
      split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
            buildLeftTreeBar(), buildRightFormsArea());
      ((JTree)split.getLeftComponent()).
         addTreeSelectionListener((ObjectViewerPanel)split.getRightComponent());
      
      return split;
   }
   
   public JComponent buildLeftTreeBar() 
   {
      return new ObjectsTree(this.connection);
   }
   
   public JComponent buildRightFormsArea() 
   {
      ObjectViewerPanel panel  = new ObjectViewerPanel();
      panel.addRepaintRequestListener(this);
      return panel;
   }
   
   private void connect()
   {
      try
      {
         connection = new ProjectServerConnection(username, password, ipaddress, port);
         connection.login();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void doRepaint()
   {
      RepaintManager rm = RepaintManager.currentManager(this);
      rm.addDirtyRegion(split, 0, 0, getWidth(), getHeight());

      paintAll(getGraphics());
   }
   
   public static void main(String args[])
   {
      ObjectBrowserMain obMain = new ObjectBrowserMain();
      obMain.setVisible(true);
   }
}
