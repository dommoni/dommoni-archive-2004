/*
 * Created on Apr 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.HashMap;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationObjectRegistry
{
   private static NotificationObjectRegistry instance = new NotificationObjectRegistry();
   HashMap registry = new HashMap();
   
   private NotificationObjectRegistry()
   {
      registry.put(Task.class, "TASK");
   }
   
   public Object get(Object key)
   {
      return registry.get(key);
   }
   
   public static NotificationObjectRegistry getInstance()
   {
      if(instance == null)
      {   
         instance = new NotificationObjectRegistry(); 
      } 
      return instance;
   }
}
/*
 * 
 * $Log: NotificationObjectRegistry.java,v $
 * Revision 1.1.1.1  2005/03/14 21:02:38  Brian Abbott
 * no message
 *
 * 
 */
//id, op_id, event_type
