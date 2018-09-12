/*
 * Created on Feb 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.systemManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ISystemManager
{
   public String getServerIpAddr()
   throws Exception;
   
   public int getServerPort()
   throws Exception;
   
   // MX Exchange
   public void setMXExchange(String mxExchange)
   throws Exception;
   
   public String getMXExchange()
   throws Exception;
   
   // Support for Blocked IP Addresses
   public void addBlockedIP(String ipAddress)
   throws Exception;
   
   public void dropBlockedIP(String ipAddress)
   throws Exception;
   
   public String[] getAllBlockedIPs()
   throws Exception;
}
