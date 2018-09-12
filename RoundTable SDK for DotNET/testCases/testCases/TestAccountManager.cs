/*
 * TestAccountManager.cs
 * 
 * Created on Mar 19, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;
using RoundTable;
using RoundTable.ProjectServer.Services.AccountManager;
using NUnit.Framework;

namespace RoundTable.DotNETSDK.TestCases
{
	/*
	 * int addAccount(Account account);
	 * void dropAccount(int accountId);
	 * void modifyAccount(Account account);
	 * Account getAccount(int accountId);
	 * Account getAccountFromUsername(String username);
	 * Account[] getAllAccounts();
	 * Account[] getAllAccountsForProject(int projectId);
	 * 
	 * // AccountSettings Operations
	 * void modifyAccountSettings(AccountSettings accountSettings);
	 * AccountSettings getAccountSettings(int accountId);
	 * 
	 * // AccountProfile Operations
	 * void modifyAccountProfile(AccountProfile accountProfile);
	 * AccountProfile getAccountProfile(int accountId);
	 * 
	 * // Account Contact Operations
	 * void addAccountContact(AccountContact contact);
	 * void dropAccountContact(int accountContactId); // need to drop this!
	 * void modifyAccountContact(AccountContact contact);
	 * AccountContact getAccountContact(int accountId);
	 * 
	 * 
	 * //----------------------------------------------------
	 * Overall Testing Strategy:
	 *   Setup: create a project.
	 * 
	 *	 TearDown: Delete the Accounts, Project.
	 * 
	 *   Login as admin, create 10 accounts. 
	 *      retrieve each one, verify the values for each are correct.
	 * 
	 *   Login as each created account.
	 * 
	 * */
	[TestFixture]
	public class TestAccountManager
	{
		ProjectServerConnection adminPsc = null;

		Account account1 = null;
		Account account2 = null;
		Account account3 = null;
		Account account4 = null;
		Account account5 = null;
		Account account6 = null;
		Account account7 = null;
		Account account8 = null;
		Account account9 = null;
		Account account10 = null;

		[SetUp]
		public void Setup()
		{
			adminPsc = new ProjectServerConnection("administrator", "dommoni", 1, "localhost", 8080);
			adminPsc.login();
		}

		[TearDown]
		public void TearDown()
		{
			adminPsc.logout();
		}

		[Test]
		public void Test1AdminLogin()
		{
           
			/*Assert.IsNotNull(adminPsc.SessionLogManager);
			Assert.IsNotNull(adminPsc.TodoManager);
			*/
		}

		[Test]
		public void Test2AddAccounts()
		{
			Console.WriteLine("Test2AddAccounts: " + adminPsc.SessionID);
			account1 = new Account();
			account1.name = "Account1";
			account1.username = "account1";
			account1.password = "pass1";
			account1.accountType = AccountType.END_USER;
		
			IAccountManager am = adminPsc.AccountManager;
			Assert.IsNotNull(am);

			int accountId = am.addAccount(account1);
			account1.id = accountId;
			Assert.IsTrue(accountId > 0);
			
			Account createdAccount1 = am.getAccount(accountId);
			Assert.IsNotNull(createdAccount1);
			
			Account createdAccount2 = am.getAccountFromUsername(account1.username);
			Assert.IsNotNull(createdAccount2);

			Assert.AreEqual(account1.name, createdAccount1.name);
			Assert.AreEqual(account1.username, createdAccount1.username);

			Assert.AreEqual(account1.name, createdAccount2.name);
			Assert.AreEqual(account1.username, createdAccount2.username);
		}
		
		[Test]
		public void Test3DropAccounts()
		{
			IAccountManager am = adminPsc.AccountManager;
			am.dropAccount(account1.id);
			Account acc = am.getAccount(account1.id);
			Assert.IsNull(acc);
		}


		[Test]
		public void TestAdminLogout()
		{

		}
	}
}
/*
 * 
 * $Log: TestAccountManager.cs,v $
 * Revision 1.1  2005/03/26 17:46:30  brian
 * Initial Revision.
 *
 * 
 */
