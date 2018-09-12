package com.dommoni.roundtable.projectServer.utils;

public class RoundTableContextHelper
{
   public static synchronized String getContext(Object obj)
   {
      try
      {
         return obj.getClass().getName().toUpperCase();
      }
      catch(Exception e)
      {
      }
      
      return null;
   }
}
