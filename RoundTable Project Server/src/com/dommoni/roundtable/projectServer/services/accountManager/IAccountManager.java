/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.accountManager;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountContact;
import com.dommoni.roundtable.AccountProfile;
import com.dommoni.roundtable.AccountSettings;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IAccountManager
{
   //
   // Account Operations
   //
   public int addAccount(Account account)
      throws Exception;
   
   public void dropAccount(int accountId)
      throws Exception;
   
   public void modifyAccount(Account account)
      throws Exception;
   
   public Account getAccount(int accountId)
      throws Exception;
   
   public Account getAccountFromUsername(String username)
      throws Exception;
   
   public Account[] getAllAccounts()
      throws Exception;
   
   public Account[] getAllAccountsForProject(int projectId)
      throws Exception;
   
   //
   // AccountSettings Operations
   //
   public void modifyAccountSettings(AccountSettings accountSettings)
      throws Exception;
   
   public AccountSettings getAccountSettings(int accountId)
      throws Exception;
   
   //
   // AccountProfile Operations
   //
   public void modifyAccountProfile(AccountProfile accountProfile)
      throws Exception;
   
   public AccountProfile getAccountProfile(int accountId)
      throws Exception;
   
   //
   // Account Contact Operations
   //
   public void addAccountContact(AccountContact contact)
      throws Exception;
   
   public void dropAccountContact(int accountContactId)
      throws Exception;
   
   public void modifyAccountContact(AccountContact contact)
      throws Exception;
   
   public AccountContact getAccountContact(int accountId)
      throws Exception;
}
