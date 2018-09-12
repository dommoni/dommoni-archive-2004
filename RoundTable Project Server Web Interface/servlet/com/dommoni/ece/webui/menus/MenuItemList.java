/*
 * Created on Oct 7, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.menus;

import java.util.Vector;

import com.dommoni.ece.webui.MenuItem;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MenuItemList extends Vector implements Cloneable
{
   public Object clone()
   {
      MenuItemList newList = new MenuItemList();
      for(int i = 0; i < size(); i++)
      {
         newList.add(((MenuItem)get(i)).clone());
      }
      return newList;
   }
}
