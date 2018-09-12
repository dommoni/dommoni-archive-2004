/*
 * TestDiscussionManager.cs
 * 
 * Created on Mar 20, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;
using System.Reflection;

using NUnit.Framework;

using RoundTable.ProjectServer.Services.DiscussionManager;

namespace RoundTable.DotNETSDK.TestCases
{
	/// <summary>
	/// Summary description for TestDiscussionManager.
	/// </summary>
	[TestFixture]
	public class TestDiscussionManager
	{
		/// <summary>
		/// Verify that the methods on the interface are equal to service are equal to list.
		/// </summary>
		[Test]
		public void TestVerifyMethods()
		{
			Type dm = Type.GetType("RoundTable.ProjectServer.Services.DiscussionManager.IDiscussionManager");
			MethodInfo[] mi =  dm.GetMethods();
			for(int i = 0; i < mi.Length; i++)
				Console.WriteLine(mi[i].Name);
		}
	}
}
/*
 * 
 * $Log: TestDiscussionManager.cs,v $
 * Revision 1.1  2005/03/26 17:46:30  brian
 * Initial Revision.
 *
 * 
 */
