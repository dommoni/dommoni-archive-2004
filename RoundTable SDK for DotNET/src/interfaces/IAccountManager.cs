/*
 * IAccountManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.AccountManager
{
	/// <summary>
	/// Summary description for IAccountManager.
	/// </summary>
	public interface IAccountManager
	{
		//
		// Account Operations
		//
		int addAccount(Account account);
   
		void dropAccount(int accountId);
   
		void modifyAccount(Account account);
   
		Account getAccount(int accountId);
   
		Account getAccountFromUsername(String username);
   
		Account[] getAllAccounts();
   
		Account[] getAllAccountsForProject(int projectId);
   
		//
		// AccountSettings Operations
		//
		void modifyAccountSettings(AccountSettings accountSettings);
   
		AccountSettings getAccountSettings(int accountId);
   
		//
		// AccountProfile Operations
		//
		void modifyAccountProfile(AccountProfile accountProfile);
   
		AccountProfile getAccountProfile(int accountId);
   
		//
		// Account Contact Operations
		//
		void addAccountContact(AccountContact contact);
   
		void dropAccountContact(int accountContactId);
   
		void modifyAccountContact(AccountContact contact);
   
		AccountContact getAccountContact(int accountId);
	}
}
/*
 * 
 * $Log: IAccountManager.cs,v $
 * Revision 1.2  2005/03/20 02:09:33  brian
 * Initial Revision.
 *
 * 
 */
