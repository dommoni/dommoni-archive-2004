/*
 * Created on Oct 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine;

import java.util.List;
import java.util.Vector;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationOperationRegistry
{
   private static List operations;
   
   // maintains the methods that should send 
   // an event to the notification engine.
   public NotificationOperationRegistry()
   {
      operations = new Vector();
      operations.add(new String("addDocument"));
      operations.add(new String("dropDocument"));
      operations.add(new String("modifyDocument"));
      operations.add(new String("getDocumentDeep"));
      operations.add(new String("getDocumentShallow"));
   }
   
   public boolean contains(String str)
   {
      return operations.contains(str);
   }
}
/*
 * 
 * $Log: NotificationOperationRegistry.java,v $
 * Revision 1.2  2005/03/26 19:25:11  brian
 * no message
 *
 * 
 */