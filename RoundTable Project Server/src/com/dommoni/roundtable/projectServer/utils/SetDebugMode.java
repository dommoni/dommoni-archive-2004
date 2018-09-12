/*
 * Created on Mar 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SetDebugMode 
{
	/*
	 * True turns it on, false off
	 */
	public void setMode(boolean isDebug) throws Exception
	{
		Connection connection = null;
		
		try
		{
			// load the Derby Driver...
	      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	           
			connection = DriverManager.getConnection("jdbc:derby:./db/core", "", "");
			
			PreparedStatement pstmt = connection.prepareStatement("update debug set do_debug=?");
			pstmt.setBoolean(1, isDebug);
			pstmt.executeUpdate();
			
			pstmt.close();
		}
		finally
		{
			try
			{
				if(connection != null)
					connection.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		SetDebugMode sdm = new SetDebugMode();
		if(args[0].equals("on"))
		{	
			try
			{
				sdm.setMode(true);
				System.out.println("Successfully enabled debug-mode.");
			}
			catch(Exception e)
			{
				System.out.println("Enabling debug mode failed. Message was: " + e.getMessage());
			}
		}
		else
		{	
			try
			{
				sdm.setMode(false);
				System.out.println("Successfully disabled debug-mode.");
			}
			catch(Exception e)
			{
				System.out.println("Disabling debug mode failed. Message was: " + e.getMessage());
			}
		}
	}
}
/*
 *
 * $Log$
 *
 */