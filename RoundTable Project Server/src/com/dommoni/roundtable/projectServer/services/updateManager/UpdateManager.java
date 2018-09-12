/*
 * Created on Mar 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.updateManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dommoni.roundtable.Update;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UpdateManager implements IUpdateManager
{
   public void addUpdate(Update update)
   {
      Connection connection = null;
      
      try
      {
         connection = DriverManager.getConnection("");
      }
      catch(SQLException se)
      {
      }
      finally
      {
      }
   }
   
   public void dropUpdate(int updateId)
   {
   }
   
   public void modifyUpdate(Update update)
   {
   }
   
   public Update getUpdate(int updateId)
   {
      return null;
   }
   
   public Update[] getAllUpdates()
   {
      return null;
   }
   
   public Update[] getAllUpdatesForProject()
   {
      return null;
   }
}
