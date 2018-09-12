/*
 * Created on May 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountSettings
{
   private int accountId;
   
   // Contact info...
   //private AccountContact accountContacts[];
   private String primaryEmailAddress;
   
   // notification settings (this is not mutually exclusive)
   private boolean notificationsSystemMessage;
   private boolean notificationsDesktopPager;
   private boolean notificationsEmail;
   
   public int getAccountId()
   {
      return this.accountId;
   }
   
   public void setAccountId(int _accountId)
   {
      this.accountId = _accountId;
   }
   
   public String getPrimaryEmailAddress()
   {
      return this.primaryEmailAddress;
   }
   
   public void setPrimaryEmailAddress(String _primaryEmailAddress)
   {
      this.primaryEmailAddress = _primaryEmailAddress;
   }
   
   /*public AccountContact[] getAccountContacts()
   {
      return this.accountContacts;
   }
   
   public void setAccountContacts(AccountContact _accountContacts[])
   {
      this.accountContacts = _accountContacts;
   }*/
   
   public boolean getNotificationsSystemMessage()
   {
      return this.notificationsSystemMessage;
   }
   
   public void setNotificationsSystemMessage(boolean _notificationsSystemMessage)
   {
      this.notificationsSystemMessage = _notificationsSystemMessage;
   }
   
   public boolean getNotificationsDesktopPager()
   {
      return this.notificationsDesktopPager;
   }
   
   public void setNotificationsDesktopPager(boolean _notificationsDesktopPager)
   {
      this.notificationsDesktopPager = _notificationsDesktopPager;
   }
   
   public boolean getNotificationsEmail()
   {
      return this.notificationsEmail;
   }
   
   public void setNotificationsEmail(boolean _notificationsEmail)
   {
      this.notificationsEmail = _notificationsEmail;
   }
}
/*
 * 
 * $Log: AccountSettings.java,v $
 * Revision 1.2  2005/03/23 08:57:07  brian
 * Added footer.
 *
 * 
 */