package com.dommoni.roundtable.is;

import java.util.HashMap;

/**
 * General registry for application resources...
 * @author Brian Abbott
 */
public class ISResourceRegistry
{
   private static ISResourceRegistry resourceRegistry = null;
   private HashMap registry;
   
   private ISResourceRegistry()
   {
      registry = new HashMap();
   }
   
   public static ISResourceRegistry getInstance()
   {
      if (resourceRegistry == null)
         resourceRegistry = new ISResourceRegistry();
      
      return resourceRegistry;
   }
   
   public void addResource(String resourceName, Object resource) 
   {
      registry.put(resourceName, resource);
   }
   
   public void removeResource(String resourceName) 
   {
      registry.remove(resourceName);
   }
   
   public Object getResource(String resourceName) 
   {
      return registry.get(resourceName);
   }
   
   public void close()
   {
      registry.clear();
      registry = null;
      resourceRegistry = null;
   }
}
