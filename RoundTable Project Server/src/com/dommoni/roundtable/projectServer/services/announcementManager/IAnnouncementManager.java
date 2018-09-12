/*
 * Created on Dec 30, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.announcementManager;

import com.dommoni.roundtable.Announcement;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IAnnouncementManager
{
   public int addAnnouncement(Announcement announcement)
   throws Exception;
   
   public void dropAnnouncement(int announcementId)
   throws Exception;
   
   public void modifyAnnouncement(Announcement announcement)
   throws Exception;
   
   public Announcement getAnnouncement(int announcementId)
   throws Exception;
   
   public Announcement[] getAllAnnouncementsForProject(int projectId)
   throws Exception;
}