/*
 * Created on Mar 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.updateManager;

import com.dommoni.roundtable.Update;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IUpdateManager
{
   public void addUpdate(Update update);
   
   public void dropUpdate(int updateId);
   
   public void modifyUpdate(Update update);
   
   public Update getUpdate(int updateId);
   
   public Update[] getAllUpdates();
   
   public Update[] getAllUpdatesForProject();
}
