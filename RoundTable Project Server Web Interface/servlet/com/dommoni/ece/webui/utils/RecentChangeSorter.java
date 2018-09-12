/*
 * Created on Nov 29, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.utils;

import java.util.Arrays;
import java.util.Vector;

import com.dommoni.roundtable.RecentChange;

/**
 * Sorts RecentChanges from the most recent to the last
 * @author Brian Abbott
 */
public class RecentChangeSorter
{
   /*
    * Sorts a RecentChange Array in Desc. order... 
    */
   public RecentChange[] sort(RecentChange[] changes)
   {
      Vector sorted = new Vector();
      Vector unsorted = new Vector();
      
      // build the unsorted vector
      for(int i = 0; i < changes.length; i++)
         unsorted.add(changes[i]);
      
      int greatest = 0;
      while(unsorted.size() > 0)
      {
         for(int i = 0; i < unsorted.size(); i++)
         {
            if(((RecentChange)unsorted.get(i)).getTimestamp().getTimeInMillis() > greatest)
               greatest = i;
         }
         sorted.add(unsorted.remove(greatest));
      }
      
      return (RecentChange[])sorted.toArray(new RecentChange[sorted.size()]);
   }
   
   public RecentChange[] sort(RecentChange[] changes, int length)
   {
      RecentChange[] sortedChanges = sort(changes);
      RecentChange newArr[] = null;
      
      if(sortedChanges != null)
      {
         // find the longer of the two arrays...
         if(length < sortedChanges.length)
         {
            newArr = new RecentChange[length];
         }
         else
         {   
            newArr = new RecentChange[sortedChanges.length];
         }
         
         for(int i = 0; i < length && i < sortedChanges.length; i++)
         {
            newArr[i] = sortedChanges[i];
         }
      }
      return newArr;
   }
}
