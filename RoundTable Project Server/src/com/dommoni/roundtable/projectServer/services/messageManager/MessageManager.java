/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.messageManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dommoni.roundtable.Message;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MessageManager implements IMessageManager
{
   public void addMessage(Message message)
   {
      Connection connection = null;
      
      if(message == null)
         return;
         
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ece", "root", "");
         PreparedStatement pstmt = connection.prepareStatement("insert into messages (to_id,from_id,text,type) values (?,?,?,?)");
         pstmt.setInt(1, message.getToId());
         pstmt.setInt(2, message.getFromId());
         pstmt.setString(3, message.getText());
         pstmt.setInt(4, message.getType());
         pstmt.executeUpdate();
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
         }
      }
   }
   
   public void dropMessage(int messageId)
   {
      Connection connection = null;
   }
   
   public void modifyMessage(Message message)
   {
      
   }
   
   public Message getMessage(int messageId)
   {
      Connection connection = null;
      Message message = null;
      
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://locashost:3306/ece", "root", "");
         PreparedStatement pstmt = connection.prepareStatement("select id,to_id,from_id,text,type from messages where id=?");
         pstmt.setInt(1, messageId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            message = new Message();
            message.setId(rs.getInt(1));
            message.setToId(rs.getInt(2));
            message.setFromId(rs.getInt(3));
            message.setText(rs.getString(4));
            message.setType(rs.getInt(5));
         }
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
         }
      }
      
      return message;
   }
   
   /**
    * retrieves all messages sent to this account.
    * 
    * @author Brian Abbott
    */
   public Message[] getAllMessagesToAccount(int accountId)
   {
      Connection connection = null;
      Vector messages = new Vector();
      
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://locashost:3306/ece", "root", "");
         PreparedStatement pstmt = connection.prepareStatement("select id from messages where to_id=?");
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            messages.add(getMessage(rs.getInt(1)));
         }
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
         } 
      }
      return (Message[])messages.toArray(new Message[messages.size()]);
   }
   
   /**
    * retrieves all messages sent from this account.
    * 
    * @author Brian Abbott
    */
   public Message[] getAllMessagesFromAccount(int accountId)
   {
      Connection connection = null;
      Vector messages = new Vector();
      
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://locashost:3306/ece", "root", "");
         PreparedStatement pstmt = connection.prepareStatement("select id from messages where from_id=?");
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            messages.add(getMessage(rs.getInt(1)));
         }
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
         } 
      }
      return (Message[])messages.toArray(new Message[messages.size()]);
   }
}
