/*
 * Created on Sep 11, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.sessions.axis;

import java.util.Iterator;

import javax.xml.soap.SOAPMessage;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.SOAPPart;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeader;
import org.apache.axis.message.SOAPHeaderElement;

import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.projectServer.sessions.SessionRegistry;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SessionHandler extends BasicHandler
{
   public void invoke(MessageContext msgContext) 
      throws AxisFault
   {
      Session session = null;
      
      try
      {
         SOAPMessage soapMessage = msgContext.getMessage();
         SOAPPart soapPart =(SOAPPart)soapMessage.getSOAPPart();  
         SOAPEnvelope soapEnvelope = (SOAPEnvelope)soapPart.getEnvelope();
         SOAPHeader soapHeader = (SOAPHeader)soapEnvelope.getHeader();
         
         Iterator it = soapHeader.getChildElements();
         while(it.hasNext())
         {   
            SOAPHeaderElement she = (SOAPHeaderElement)it.next();
            if(she.getName().equalsIgnoreCase("sessionid"))
            {
               // found sessoin id
               session = (Session)SessionRegistry.getInstance().get(she.getValue());
               
               if(session != null)
               {
               	  DebugUtils.GI().printDbg("FOUND SESSION!!!");
                  msgContext.setProperty("session", session); 
               }
               return;
            }
         }
         //throw new AxisFault("No Session found.");
      }
      catch(Exception e)
      {
         //e.printStackTrace();
      }
   }
}
