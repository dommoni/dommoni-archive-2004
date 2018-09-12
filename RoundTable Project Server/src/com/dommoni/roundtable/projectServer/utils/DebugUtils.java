/*
 * Created on Mar 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;

/**
 * @author Brian Abbott
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class DebugUtils
{
   private static DebugUtils debug = new DebugUtils();

   private boolean doDebug;

   private DebugUtils()
   {
      Connection connection = null;

      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement(
               "select do_debug from debug", ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            doDebug = rs.getBoolean(1);
         }
      }
      catch (Exception e)
      {
         doDebug = true;
         logException(e);
      }
      finally
      {
         if (connection != null)
         {
            try
            {
               connection.close();
            }
            catch (Exception e1)
            {
               doDebug = true;
               logException(e1);
            }
         }
      }

   }

   public void printDbg(String str)
   {
      synchronized (str)
      {
         if (doDebug)
         {
            System.out.println(str);
         }
      }
   }

   public void logException(Exception ex)
   {
      synchronized (ex)
      {
         if (doDebug)
         {
            ex.printStackTrace();
         }
      }
   }

   public static DebugUtils GI()
   {
      synchronized (debug)
      {
         if (debug == null)
         {
            debug = new DebugUtils();
         }
         return debug;
      }
   }
}