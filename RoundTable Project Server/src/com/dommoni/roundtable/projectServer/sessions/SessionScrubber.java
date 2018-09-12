/*
 * Created on Feb 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.sessions;

import java.util.Calendar;
import java.util.Iterator;

import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * Cleans out expired sessions.
 * 
 * @author Brian Abbott
 */
public class SessionScrubber extends Thread
{
   public void run()
   {
      while(true)
      {
         DebugUtils.GI().printDbg("Running SessionScrubber...");
         
         try
         {
            Calendar cl = Calendar.getInstance();
            cl.setTimeInMillis(cl.getTimeInMillis() - (30 * 60 * 1000));
           
            SessionRegistry sr = SessionRegistry.getInstance();
            synchronized(sr)
			{
	            Iterator it = sr.values().iterator();
	            while(it.hasNext())
	            {
	               try
	               {
	                  Session session = (Session)it.next();
	                  if(session.getLastActivityTime().getTimeInMillis() < 
	                        cl.getTimeInMillis())
	                  {
	                     sr.remove(session.getSessionId());
	                  }
	               }
	               catch(Exception e)
	               {
	                  DebugUtils.GI().logException(e);
	               }
	            }
			}
            
            sleep(60 * 1000);
         }
         catch(Exception e)
         {
         	DebugUtils.GI().logException(e);
         }
      }
   }
}
/*
 * 
 * $Log: SessionScrubber.java,v $
 * Revision 1.2  2005/03/26 19:27:48  brian
 * no message
 *
 * 
 */
