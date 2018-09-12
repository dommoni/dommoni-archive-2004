/*
 * TestProjectServerConnection.cs
 * 
 * Created on Mar 20, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

using NUnit.Framework;

namespace RoundTable.DotNETSDK.TestCases
{
	/// <summary>
	/// Summary description for TestProjectServerConnection.
	/// </summary>
	[TestFixture]
	public class TestProjectServerConnection
	{
		private ProjectServerConnection adminPsc = null;
		private string testUsername = "administrator";
		private string testPassword = "dommoni";
		private int testSessionType = 1;
		private string testHost = "localhost";
		private int testPort = 8080;

		[SetUp]
		public void Setup()
		{
			adminPsc = new ProjectServerConnection(testUsername, testPassword, testSessionType, testHost, testPort);
			adminPsc.login();
		}

		[TearDown]
		public void TearDown()
		{
			adminPsc.logout();
			adminPsc = null;

			GC.Collect();
			GC.WaitForPendingFinalizers();
			GC.Collect();
			GC.WaitForPendingFinalizers();
		}

		[Test]
		public void Test1PSCInit()
		{
			// Test Properties
			Assert.IsNotNull(adminPsc.SessionID);
			Assert.IsNotNull(adminPsc.Username);
			Assert.IsNotNull(adminPsc.Password);
			Assert.IsNotNull(adminPsc.SessionType);
			Assert.IsNotNull(adminPsc.IPAddr);
			Assert.IsNotNull(adminPsc.Port);
			Assert.IsNotNull(adminPsc.Account);
			// havent set a project yet so, should be null.
			Assert.IsNull(adminPsc.CurrentProject);

			// test vars
			Assert.AreEqual(this.testUsername, adminPsc.Username);
			Assert.AreEqual(this.testPassword, adminPsc.Password);
			Assert.AreEqual(this.testSessionType, adminPsc.SessionType);
			Assert.AreEqual(this.testHost, adminPsc.IPAddr);
			Assert.AreEqual(this.testPort, adminPsc.Port);

			// Test Account 
			Assert.AreEqual(testUsername, adminPsc.Account.username);
			Assert.AreEqual(testPassword, adminPsc.Account.password);

			// Test Services
			Assert.IsNotNull(adminPsc.AccountManager);
			Assert.IsNotNull(adminPsc.AnnouncementManager);
			//Assert.IsNotNull(adminPsc.AttachmentManager);
			Assert.IsNotNull(adminPsc.CommentManager);
			Assert.IsNotNull(adminPsc.DiscussionManager);
			Assert.IsNotNull(adminPsc.DocumentManager);
			Assert.IsNotNull(adminPsc.EventLogManager);
			Assert.IsNotNull(adminPsc.ForumManager);
			Assert.IsNotNull(adminPsc.MeetingManager);
			Assert.IsNotNull(adminPsc.NotificationManager);
			Assert.IsNotNull(adminPsc.ProjectManager);
			Assert.IsNotNull(adminPsc.RecentChangesManager);
			//Assert.IsNotNull(adminPsc.SessionLogManager);
			Assert.IsNotNull(adminPsc.SessionManager);
			Assert.IsNotNull(adminPsc.TaskManager);
		}
	}
}
/*
 * 
 * $Log: TestProjectServerConnection.cs,v $
 * Revision 1.1  2005/03/26 17:46:31  brian
 * Initial Revision.
 *
 * 
 */