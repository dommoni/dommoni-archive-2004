/*
 * Created on Mar 29, 2004
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
public class MeetingFolder
{
   private String folderName;
   private int meetingIds[];
   private MeetingFolder childFolders[];
   
   public String getFolderName()
   {
      return this.folderName;
   }
   
   public void setFolderName(String _folderName)
   {
      this.folderName = _folderName;
   }
   
   public int[] getMeetingIds()
   {
      return this.meetingIds;
   }
   
   public void setMeetingIds(int _meetingIds[])
   {
      this.meetingIds = _meetingIds;
   }
   
   public MeetingFolder[] getChildFolders()
   {
      return this.childFolders;
   }
   
   public void setChildFolders(MeetingFolder _childFolders[])
   {
      this.childFolders = _childFolders;
   }
}
