/*
 * Created on Apr 24, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.utils;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DateHandler
{
   /**
    * This method is a simplistic way to determine weather
    * a System.DateTime Structure in the .NET Framework was
    * given a value or not. For whatever reason, in Outlook
    * or COM Interop, the System.DateTime comes back with a 
    * year of 4051 when you do not deliberately set the date.
    * I dont believe this holds true for all instances of 
    * .NET DateTime handling....?
    * 
    * This method is a Java Implementation of the same logic
    * we're using on the .NET Office Clients for RoundTable CS.
    * 
    * @param date
    * @return
    */
   public boolean isSetDotNET(Calendar date)
   {
      Calendar now = Calendar.getInstance();
      
      if (date != null)
      {
         if (now.get(Calendar.YEAR) + 100 > date.get(Calendar.YEAR) && 
               now.get(Calendar.YEAR) - 100 < date.get(Calendar.YEAR))
         {
            return true;
         }
      }
      return false;
   }
}
