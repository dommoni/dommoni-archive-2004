using System;

namespace OutlookOIS
{
	/// <summary>
	/// Generic error handler for publishing exceptions raised in PX Task classes.
	/// </summary>
	abstract class ErrorHandler
	{
		public static void PublishError(System.Exception ex, string sMessage, Logger logger)
		{
			try
			{
				if ( ! ( logger == null ) ) 
				{
					if ( sMessage != string.Empty )  
					{
						logger.LogMessage(sMessage);
						Console.WriteLine(sMessage);
					}
					if ( ex != null ) 
					{
						logger.LogMessage(ex.ToString());
						Console.WriteLine(ex.ToString());
					}
				}
				else
				{
					if ( ex == null ) 
					{
						Console.WriteLine(sMessage);
					}
					else
					{
						Console.WriteLine(sMessage + "\n\r" + ex.ToString());
					}
				}

			}
			catch
			{
				// do nothing
			}
		}

		// OVERLOADS
		public static void PublishError(System.Exception ex)
		{
			PublishError(ex, string.Empty, null);
		}
		public static void PublishError(System.Exception ex, string sMessage)
		{
			PublishError(ex, sMessage, null);
		}
		public static void PublishError(System.Exception ex, Logger logger)
		{
			PublishError(ex, string.Empty, logger);
		}
		public static void PublishError(string sMessage, Logger logger)
		{
			PublishError(null, sMessage, logger);
		}
	}
}
/*
 * 
 * $Log: ErrorHandler.cs,v $
 * Revision 1.1.1.1  2005/03/14 22:38:38  Brian Abbott
 * no message
 *
 * Revision 1.3  2004/12/02 23:58:00  dan.hochee
 * *** empty log message ***
 *
 * Revision 1.2  2004/12/02 16:23:38  dan.hochee
 * *** empty log message ***
 *
 * Revision 1.1  2004/11/24 00:41:22  dan.hochee
 * *** empty log message ***
 *
 * Revision 1.3  2004/11/23 23:22:27  dan.hochee
 * *** empty log message ***
 *
 * Revision 1.2  2004/11/22 22:52:06  dan.hochee
 * Created ErrorHandler class with stub. Doesn't do anything yet.
 *
 * 
 */
