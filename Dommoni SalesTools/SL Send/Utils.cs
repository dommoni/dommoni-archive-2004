using System;
using System.IO;
using System.Reflection;

namespace SL_Send
{
	/// <summary>
	/// Summary description for Utils.
	/// </summary>
	public class Utils
	{
		public static string appPath;

		public const string SettingsFile = "SLSendSettings.dat";
		
		public static string GetFileLoc(string sFile) 
		{
			FileInfo fi = new FileInfo(sFile);
			return fi.DirectoryName;
		}

		public static void SetAppPath()
		{
			appPath = GetFileLoc(typeof(SL_Send.Utils).Assembly.Location);
		}

		public static string GetAppPath
		{
			get {
				if (appPath == null || appPath.Length < 1)
					SetAppPath();
				return appPath;
			}
		}

		public static Assembly MyResolveEventHandler(object sender, ResolveEventArgs args)
		{
			// TODO: Review later. this makes a big assumption: that all referenced assemblies
			//       will be in the same folder as the calling assembly.

			// NOTE: The danger was reduced by calling adding this handler immediately before 
			//       deserializing the settings file and removing it immediately afterwards

//			Logger logger = new Logger(LogFile);
//			logger.LogMessage("Entering ResolveEventHandler with args: " + args.Name);

			string[] strProps = args.Name.Split(new char[] {','});
			string sPath = GetAppPath + "\\" + strProps[0] + ".dll";
			
			if ( File.Exists(sPath) )
			{
				return Assembly.LoadFrom(sPath);
			}

			return null;
		}
	}
}
