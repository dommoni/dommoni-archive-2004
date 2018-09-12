/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.transporters;

import com.dommoni.roundtable.projectServer.notificationEngine.NotificationMessage;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DesktopPagerTransporter
{
   NotificationMessage message;
   
   public DesktopPagerTransporter(NotificationMessage message)
   {
      this.message = message;
   }
   
   public void transport()
   {
   }
}
