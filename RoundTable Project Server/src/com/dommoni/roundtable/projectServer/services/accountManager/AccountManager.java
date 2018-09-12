/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.accountManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountContact;
import com.dommoni.roundtable.AccountProfile;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountManager implements IAccountManager
{
   static Logger logger = Logger.getLogger(AccountManager.class.getName());
   
   //public int addAccount(Event event, Account account)
   public int addAccount(Account account)
      throws Exception
   {
      logger.log(Level.INFO, "Entering AccountManager.addAccount");
      
      Connection connection = null;
      int accountId = -1;
      
      if(account == null)
         return -1;
         
      try
      {
         connection = ConnectionManager.getConnection();
         connection.setAutoCommit(false);
         
         PreparedStatement pstmt = connection.prepareStatement("insert into accounts (name,nick_name,username,password,account_type) values (?,?,?,?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setString(1, account.getName());
         pstmt.setString(2, account.getNickName());
         pstmt.setString(3, account.getUsername());
         pstmt.setString(4, account.getPassword());
         pstmt.setInt(5, account.getAccountType());
         pstmt.executeUpdate();
         pstmt.close();
         //old mysql version: pstmt = connection.prepareStatement("select LAST_INSERT_ID() from accounts");
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from accounts", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {   
            accountId = rs.getInt(1);
            
            pstmt = connection.prepareStatement("insert into account_settings (account_id) values (?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, accountId);
            pstmt.executeUpdate();
            pstmt.close();
            
            pstmt = connection.prepareStatement("insert into account_profiles (account_id) values (?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, accountId);
            pstmt.executeUpdate();
            
            pstmt = connection.prepareStatement("insert into account_contacts (account_id) values (?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, accountId);
            pstmt.executeUpdate();
         }
         connection.commit();
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         try
         {
            connection.rollback();
         }
         catch(SQLException sqe)
         {
            DebugUtils.GI().logException(sqe);
         }
         DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      return accountId;
   }
   
   /*
   public int addAccount(Account account)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public void dropAccount(Event event, int accountId)
   public void dropAccount(int accountId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from accounts where id=?");
         pstmt.setInt(1, accountId);
         pstmt.executeUpdate();
         
         // remove from account settings table
         pstmt = connection.prepareStatement("delete from account_settings where account_id=?");
         pstmt.setInt(1, accountId);
         pstmt.executeUpdate();
         
         // remove from account profiles table
         pstmt = connection.prepareStatement("delete from account_profiles where account_id=?");
         pstmt.setInt(1, accountId);
         pstmt.executeUpdate();
         
         // remove from account contacts table
         pstmt = connection.prepareStatement("delete from account_contacts where account_id=?");
         pstmt.setInt(1, accountId);
         pstmt.executeUpdate();
         
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   /*public void dropAccount(int accountId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyAccount(Event event, Account account)
   public void modifyAccount(Account account)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update accounts set name=?,nick_name=?,username=?,password=?,account_type=? where id=?");
         pstmt.setString(1, account.getName());
         pstmt.setString(2, account.getNickName());
         pstmt.setString(3, account.getUsername());
         pstmt.setString(4, account.getPassword());
         pstmt.setInt(5, account.getAccountType());
         pstmt.setInt(6, account.getId());
         
         pstmt.executeUpdate();
         
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   /*public void modifyAccount(Account account) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Account getAccount(Event event, int accountId)
   public Account getAccount(int accountId)
   throws Exception
   {
      Connection connection = null;
      Account account = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         
         PreparedStatement pstmt = connection.prepareStatement("select id, name, nick_name, username, password, account_type from accounts where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, accountId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            account = getAccountFromResultSet(rs);
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      
      return account;
   }
   
   /*public Account getAccount(int accountId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Account getAccountFromUsername(Event event, String username)
   public Account getAccountFromUsername(String username)
   throws Exception
   {
      Connection connection = null;
      Account account = null;
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select id,name,nick_name,username,password,account_type from accounts where username=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setString(1, username);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            account = getAccountFromResultSet(rs);
         }
            
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      
      return account;
   }
   
   /*public Account getAccountFromUsername(String username) 
   throws Exception
   {
      return this.getAccountFromUsername(null, username);
      //throw new ContextNotFoundException();
   }*/
   //public Account[] getAllAccounts(Event event)
   public Account[] getAllAccounts()
   throws Exception
   {
      Connection connection = null;
      Vector accounts = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id,name,nick_name,username,password,account_type from accounts");
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            accounts.add(getAccountFromResultSet(rs));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      
      return (Account[])accounts.toArray(new Account[accounts.size()]);
   }
   
   /*public Account[] getAllAccounts() 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Account[] getAllAccountsForProject(Event event, int projectId)
   public Account[] getAllAccountsForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      Vector accounts = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select account_id from project_accounts where project_id=?");
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            accounts.add(getAccount(rs.getInt(1))); //getAccount(event, rs.getInt(1)));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      
      return (Account[])accounts.toArray(new Account[accounts.size()]);
   }
   
   /*public Account[] getAllAccountsForProject(int projectId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   // Account Settings Operations ---------------------------------------------
   //
   //public void modifyAccountSettings(Event event, AccountSettings accountSettings)
   public void modifyAccountSettings(AccountSettings accountSettings)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         
         PreparedStatement pstmt = connection.prepareStatement("update account_settings set notification_system_message=?, notification_desktop_pager=?, notification_email=?, email_address=? where account_id=?");
         pstmt.setBoolean(1, accountSettings.getNotificationsSystemMessage());
         pstmt.setBoolean(2, accountSettings.getNotificationsDesktopPager());
         pstmt.setBoolean(3, accountSettings.getNotificationsEmail());
         pstmt.setString(4, accountSettings.getPrimaryEmailAddress());
         
         pstmt.setInt(5, accountSettings.getAccountId());
         
         pstmt.executeUpdate();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   /*public void modifyAccountSettings(AccountSettings accountSettings) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public AccountSettings getAccountSettings(Event event, int accountId)
   public AccountSettings getAccountSettings(int accountId)
   throws Exception
   {
      Connection connection = null;
      AccountSettings accountSettings = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select notification_system_message,notification_desktop_pager,notification_email,email_address from account_settings where account_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, accountId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            accountSettings = new AccountSettings();
            accountSettings.setAccountId(accountId);
            
            accountSettings.setNotificationsSystemMessage(rs.getBoolean(1));
            accountSettings.setNotificationsDesktopPager(rs.getBoolean(2));
            accountSettings.setNotificationsEmail(rs.getBoolean(3));
            
            accountSettings.setPrimaryEmailAddress(rs.getString(4));
         }
         
         /*if(accountSettings != null)
         {
            pstmt = connection.prepareStatement("select contact,type from account_contacts where account_id=?");
            pstmt.setInt(1, accountId);
            rs = pstmt.executeQuery();
            Vector contacts = new Vector();
            while(rs.next())
            {
               AccountContact ac = new AccountContact();
               ac.setAddress(rs.getString(1));
               ac.setType(rs.getInt(2));  
               contacts.add(ac);   
            }
            accountSettings.setAccountContacts((AccountContact[])contacts.toArray(new AccountContact[contacts.size()]));
         }*/
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      return accountSettings;
   }
   
   /*public AccountSettings getAccountSettings(int accountId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
         
   // Account Profile Operations-----------------------------------------------
   //
   //public void modifyAccountProfile(Event event, AccountProfile accountProfile)
   public void modifyAccountProfile(AccountProfile accountProfile)
   throws Exception
   {
      Connection connection = null;
      
      if(accountProfile == null)
      {
         return;
      }
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update account_profiles set profile_text=?, picture=? where account_id=?");
         pstmt.setString(1, accountProfile.getProfileText());
         
         if(accountProfile.getImage() != null && accountProfile.getImage().length > 0)
         {   
            pstmt.setBinaryStream(2, new ByteArrayInputStream(accountProfile.getImage()), accountProfile.getImage().length);
         }
         else
         {   
            pstmt.setBinaryStream(2, null, 0);
         }
         
         pstmt.setInt(3, accountProfile.getAccountId());   
            
         pstmt.executeUpdate();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   /*public void modifyAccountProfile(AccountProfile accountProfile) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public AccountProfile getAccountProfile(Event event, int accountId)      
   public AccountProfile getAccountProfile(int accountId)
   throws Exception
   {
      Connection connection = null;
      AccountProfile accountProfile = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select profile_text,picture from account_profiles where account_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, accountId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            accountProfile = new AccountProfile();
            accountProfile.setProfileText(rs.getString(1));
            accountProfile.setImage(getBytes(rs.getBinaryStream(2)));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      
      return accountProfile;
   }
   
   /*public AccountProfile getAccountProfile(int accountId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
         
   //
   // Account Contact Operations
   //
   //public void addAccountContact(Event event, AccountContact contact)
   
   public void addAccountContact(AccountContact contact)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into account_contacts (account_id,phone_number,office_address,city,state,zip) values (?,?,?,?,?,?)");
         pstmt.setInt(1, contact.getAccountId());
         pstmt.setString(2, contact.getPhoneNumber());
         pstmt.setString(3, contact.getOfficeAddress());
         pstmt.setString(4, contact.getCity());
         pstmt.setString(5, contact.getState());
         pstmt.setString(6, contact.getZip());
         
         pstmt.executeUpdate();
         
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
      }
      finally
      {
         try
         {
            if(connection != null)
               connection.close();
         }
         catch(Exception e)
         {
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   /*public void addAccountContact(AccountContact contact)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public void dropAccountContact(Event event, int accountContactId)
   public void dropAccountContact(int accountContactId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from account_contacts where account_id=?");
         pstmt.setInt(1, accountContactId);
         pstmt.executeUpdate();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   /*public void dropAccountContact(int accountContactId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public void modifyAccountContact(Event event, AccountContact contact)
   public void modifyAccountContact(AccountContact contact)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update account_contacts set phone_number=?,office_address=?,city=?,state=?,zip=? where account_id=?");
         pstmt.setString(1, contact.getPhoneNumber());
         pstmt.setString(2, contact.getOfficeAddress());
         pstmt.setString(3, contact.getCity());
         pstmt.setString(4, contact.getState());
         pstmt.setString(5, contact.getZip());
         
         pstmt.setInt(6, contact.getAccountId());
         pstmt.executeUpdate();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
      }
   }
   
   /*public void modifyAccountContact(AccountContact contact) 
   throws Exception
   {
      this.modifyAccountContact(null, contact);
   }*/
   //public AccountContact getAccountContact(Event event, int accountId)
   public AccountContact getAccountContact(int accountId)
   throws Exception
   {
      Connection connection = null;
      AccountContact contact = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select phone_number,office_address,city,state,zip from account_contacts where account_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, accountId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            contact = new AccountContact();
            contact.setAccountId(accountId);
            contact.setPhoneNumber(rs.getString(1));
            contact.setOfficeAddress(rs.getString(2));
            contact.setCity(rs.getString(3));
            contact.setState(rs.getString(4));
            contact.setZip(rs.getString(5));
         }
         
         rs.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	DebugUtils.GI().logException(e);
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
      }
      
      return contact;
   }
   
   /*public AccountContact getAccountContact(int accountId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/

   /**
    * internal helper function to extract an single account from a 
    * RecordSet object.
    * 
    * @param rs - the java.sql.RecordSet containing the account.
    * @return An Account object representing the account in the DB.
    * 
    * @author Brian Abbott
    */
   private Account getAccountFromResultSet(ResultSet rs) 
      throws SQLException
   {
      Account account = new Account();
   
      account.setId(rs.getInt("id"));
      account.setName(rs.getString("name"));
      account.setNickName(rs.getString("nick_name"));
      account.setUsername(rs.getString("username"));
      account.setPassword(rs.getString("password")); 
      account.setAccountType(rs.getInt("account_type"));
   
      return account;
   }
   
   private byte[] getBytes(InputStream ins)
   {
      try
      {
         int count = ins.available();
         byte[] data = new byte[count];
         ins.read(data);
         return data;
      }
      catch (Exception e)
      {
      	DebugUtils.GI().logException(e);
      }
      return null;
   }
}
/*
 * 
 * $Log: AccountManager.java,v $
 * Revision 1.2  2005/03/26 19:25:38  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
