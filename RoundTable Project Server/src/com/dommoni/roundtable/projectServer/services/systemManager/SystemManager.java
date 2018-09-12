/*
 * Created on Feb 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.systemManager;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SystemManager implements ISystemManager
{
   public String getServerIpAddr()
   {
      try
      {
         System.out.println("SystemManager.getServerIpAddr(): " +
               InetAddress.getLocalHost().getHostAddress());
         
         return InetAddress.getLocalHost().getHostAddress();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
      return null;
   }
   
   public int getServerPort()
   {
      // TODO: Make sure this is eventually set dynamically and from actual Tomcat
      // information... 
      return 8080; 
   }
   
   public void setMXExchange(Event event, String mxExchange)
   throws Exception
   {
   }
   
   public void setMXExchange(String mxExchange)
   throws Exception
   {
      throw new ContextNotFoundException();
   }
   
   public String getMXExchange(Event event)
   throws Exception
   {
      return null;
   }
   
   public String getMXExchange()
   throws Exception
   {
      throw new ContextNotFoundException();
   }
   
   public void addBlockedIP(Event event, String ipAddress) 
   throws Exception
   {
      Connection connection = null;
      
      // access rules:
      /*if(event != null)
      {
         /*AccountManager am = new AccountManager();
         Account user = am.getAccount(event, event.getInstigatorId());
         if(user.getAccountType() != AccountType.SYSTEM_ADMINISTRATOR)
         {   
            throw new Exception("Invalid Operation: You must be an administrator to perform this operation");
         }
      }
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into blocked_ips (ip_address, blocked_on) values (?,?)");
         pstmt.setString(1, ipAddress);
         pstmt.setTimestamp(2, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         pstmt.executeUpdate();
         
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {   
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }*/
   }
   
   public void addBlockedIP(String ipAddress) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }
   
   public void dropBlockedIP(Event event, String ipAddress) 
   throws Exception
   {
      
   }
   
   public void dropBlockedIP(String ipAddress) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }
   
   public String[] getAllBlockedIPs(Event event) 
   throws Exception
   {
      return null;
   }
   
   public String[] getAllBlockedIPs() 
   throws Exception
   {
      throw new ContextNotFoundException();
   }
}
