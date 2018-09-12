using System;
using System.IO;

namespace OutlookOIS
{
	/// <summary>
	/// Default logger class for PX Tasks.
	/// </summary>
	class Logger
	{
		StreamWriter sw;
		string sLogFile;

		public Logger(string _sLogFile)
		{
			try
			{
				sLogFile = _sLogFile;

				// if file doesn't already exist, create it
				if ( ! File.Exists(sLogFile) )
				{
					sw = File.CreateText(sLogFile);

					sw.WriteLine("=================================================");
					sw.WriteLine("LOG FILE CREATED " + Timestamp().Trim());
					sw.WriteLine("=================================================");
					sw.WriteLine();
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, "Error in Logger constructor:");
			}
			finally
			{
				try
				{
					if ( sw != null )
					{
						sw.Close();
					}
				}
				catch{}
			}

		}
		
		public void LogMessage(string sMessage)
		{
			try
			{
				sw = File.AppendText(sLogFile);

				sw.WriteLine(Timestamp() +  sMessage);

				sw.Close();
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex);
			}
		}

		private string Timestamp()
		{
			return DateTime.Now.ToString("MM-dd-yyyy  hh:mm:ss").PadRight(25); // general time with seconds, padded to 25 chars
		}
	}
}
