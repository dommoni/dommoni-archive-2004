/*
 * Created on Apr 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.sessions;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SessionRegistry
{
   private static SessionRegistry sessionRegistry = new SessionRegistry();
   private static HashMap registry = new HashMap();
   
   private SessionRegistry()
   {
   }
   
   public Object get(Object key)
   {
      return registry.get(key);
   }
   
   public Object put(Object key, Object obj)
   {
      return registry.put(key, obj);
   }
   
   public Collection values()
   {
      return registry.values();
   }
   
   public Object remove(String sessionKey)
   {
      return registry.remove(sessionKey);
   }
   
   public static SessionRegistry getInstance()
   {
      if(sessionRegistry == null)
      {
         sessionRegistry = new SessionRegistry();
      }
      return sessionRegistry;
   }
}
