/*
 * Created on Jan 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.utils;

import java.util.Vector;

import com.dommoni.roundtable.Announcement;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AnnouncementSorter
{
   /*
    * Sorts a RecentChange Array in Desc. order... 
    */
   public Announcement[] sort(Announcement[] announcements)
   {
      Vector sorted = new Vector();
      Vector unsorted = new Vector();
      
      // build the unsorted vector
      for(int i = 0; i < announcements.length; i++)
         unsorted.add(announcements[i]);
      
      int greatest = 0;
      while(unsorted.size() > 0)
      {
         for(int i = 0; i < unsorted.size(); i++)
         {
            if(((Announcement)unsorted.get(i)).getCreatedOn().getTimeInMillis() > greatest)
               greatest = i;
         }
         sorted.add(unsorted.remove(greatest));
      }
      
      return (Announcement[])sorted.toArray(new Announcement[sorted.size()]);
   }
   
   public Announcement[] sort(Announcement[] changes, int length)
   {
      Announcement[] sortedChanges = sort(changes);
      Announcement newArr[] = null;
      
      if(sortedChanges != null)
      {
         // find the longer of the two arrays...
         if(length < sortedChanges.length)
         {
            newArr = new Announcement[length];
         }
         else
         {   
            newArr = new Announcement[sortedChanges.length];
         }
         
         for(int i = 0; i < length && i < sortedChanges.length; i++)
         {
            newArr[i] = sortedChanges[i];
         }
      }
      return newArr;
   }

}
