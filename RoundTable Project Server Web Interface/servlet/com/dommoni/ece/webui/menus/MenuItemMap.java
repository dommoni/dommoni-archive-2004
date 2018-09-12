/*
 * Created on Oct 7, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.menus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.dommoni.ece.webui.MenuItem;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MenuItemMap extends HashMap implements Cloneable
{
   public Object clone()
   {
      MenuItemMap newMap = new MenuItemMap();
      
      Set keys = keySet();
      Iterator it = keys.iterator();
      while(it.hasNext())
      {
         String key = (String)it.next();
         newMap.put(new String(key), ((MenuItemList)get(key)).clone());
      }
      return newMap;
   }
}
