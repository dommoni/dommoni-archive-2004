/*
 * IRecentChangesManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.RecentChangesManager
{
	/// <summary>
	/// Summary description for IRecentChangesManager.
	/// </summary>
	public interface IRecentChangesManager
	{
		RecentChange[] getRecentChangesForProject(int projectId);
	}
}
/*
 * 
 * $Log: IRecentChangesManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */