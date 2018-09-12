/*
 * IAnnouncementManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.AnnoucementManager
{
	/// <summary>
	/// Summary description for IAnnouncementManager.
	/// </summary>
	public interface IAnnouncementManager
	{
		int addAnnouncement(Announcement announcement);
   
		void dropAnnouncement(int announcementId);
   
		void modifyAnnouncement(Announcement announcement);
   
		Announcement getAnnouncement(int announcementId);
   
		Announcement[] getAllAnnouncementsForProject(int projectId);
	}
}
/*
 * 
 * $Log: IAnnouncementManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */