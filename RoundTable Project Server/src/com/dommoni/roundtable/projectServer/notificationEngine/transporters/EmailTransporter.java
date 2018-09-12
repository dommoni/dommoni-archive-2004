/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.transporters;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dommoni.roundtable.projectServer.utils.DebugUtils;


/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EmailTransporter
{
   private String subject;
   private String message;
   private String emailAddress;
      
   public EmailTransporter(String subject, String message, String emailAddress)
   {
      this.subject = subject;
      this.message = message;
      this.emailAddress = emailAddress;
   }
   
   public void send()
   {
      System.out.println("Sending Message to: " + emailAddress);
       
      String htmlMessage = "<center>" +
         "<table><tr><td>" +
           "<table>" +
             "<tr><td>&nbsp;</td></tr>" + 
             "<tr><td><font face=\"verdana\"><b>"+subject+"</b><font></td></tr>" +
           "</table>" +
   
           "<!-- #d0d0e0 -->" +
   
           "<table cellspacing=\"0\" cellpadding=\"20\" border=\"1\" bordercolor=\"#9090a0\">" +
   
             "<tr>" +
               "<td width=\"350\" bgcolor=\"#efefff\"><font face=\"arial\" size=\"2\">" +
                  message + "</font><br><br><br>" +
   
               "<font face=\"verdana\" size=\"1\">RoundTable Collaboration Environment</font></td>" +
             "</tr>" +
   
           "</table>" + 
         "</td></tr>" +
         "</table>" +
         "</center>";      
       
      try
      {        
         if(emailAddress != null)
         {  
            Properties props = new Properties();
            props.put("mail.smtp.host", "mail.dommoni.com");
      
            Session session = Session.getDefaultInstance(props);
            Message eMessage = new MimeMessage(session);
      
            eMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            //eMessage.setFrom(new InternetAddress("roundtable-temp@dommoni.com"));
            eMessage.setFrom(new InternetAddress("", "RoundTable Collaboration Environment"));
            eMessage.setSubject(subject);
            
            // TODO: Need to allow the user to set weather they want HTML Messages or not.
            eMessage.setContent(htmlMessage, "text/html");
      
            Transport.send(eMessage);
         }
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
      }
   }
}
