/*
 * Created on Apr 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;

/**
 * Maps Operations to their Event Type and 
 * possibly more if ever needed.
 * 
 * @author Brian Abbott
 */
public class OperationMap
{
   private static OperationMap instance = new OperationMap();
   private HashMap reg = new HashMap();
   private Class operationClasses[] = {
      ITaskManager.class
   };
   
   private OperationMap()
   {
      // this should work. But, to be safe, always use the 
      // method name and not the ID when possible.
      int opId = 0;
      for(int i = 0; i < operationClasses.length; i++)
      {
         Method methods[] = operationClasses[i].getMethods();
         for(int j = 0; j < methods.length; j++)
         {
            String methodName = methods[j].getName();
            System.out.println("Adding method: " + methodName);
            ++opId;
            
            OperationDescriptor od = new OperationDescriptor();
            od.id = opId;
            
            if(methodName.startsWith("add"))
            {   
               od.type = Notification.CREATE_OPERATION; 
            } 
            else if(methodName.startsWith("drop"))
            {   
               od.type = Notification.DELETION_OPERATION; 
            } 
            else if(methodName.startsWith("modify"))
            {   
               od.type = Notification.MODIFICATION_OPERATION; 
            } 
            else if(methodName.startsWith("get"))
            {   
               od.type = Notification.RETRIEVAL_OPERATION; 
            } 
            
            reg.put(methods[j].getName(), od);
         }
      }
   }
   
   public Object get(Object key)
   {
      return reg.get(key);
   }
   
   public static OperationMap getInstance()
   {
      if(instance == null)
      {   
         instance = new OperationMap(); 
      }
      return instance; 
   }
}
/*
 * 
 * $Log: OperationMap.java,v $
 * Revision 1.2  2005/03/26 19:12:11  brian
 * Added footer.
 *
 * 
 */