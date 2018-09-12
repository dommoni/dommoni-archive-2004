using System;
using System.IO;
using System.Reflection;

namespace ProjectAddin
{
	/// <summary>
	/// Summary description for Utils.
	/// </summary>
	public class Utils
	{
		public static string sSettingsFile;
	    public static string sAppPath;
	
		public const string CONNECTION_PROGRESS_TITLE = "Connection Progress";
		public const string CONNECTION_PROGRESS_MESSAGE = "Connection Progress Message";
		public const string SETTINGS_FILE = "Settings.dat";
	

		public static Assembly MyResolveEventHandler(object sender, ResolveEventArgs args)
		{
			// TODO: Review later. this makes a big assumption: that all referenced assemblies
			//       will be in the same folder as the calling assembly.

			// NOTE: The danger was reduced by calling adding this handler immediately before 
			//       deserializing the settings file and removing it immediately afterwards

			//Logger logger = new Logger(LogFile);
			//logger.LogMessage("Entering MyResolveEventHandler with args: " + args.Name);

			string[] strProps = args.Name.Split(new char[] {','});
			string sPath = GetAppPath + "\\" + strProps[0] + ".dll";
			
			if ( File.Exists(sPath) )
			{
				return Assembly.LoadFrom(sPath);
			}

			return null;
		}

		public static string GetFileLoc(string sFile) 
		{
			FileInfo fi = new FileInfo(sFile);
			return fi.DirectoryName;
		}

		public static string GetAppPath
		{
			get {return sAppPath;}
		}

		public static void SetAppPath()
		{
			sAppPath = GetFileLoc(typeof(ProjectAddin.Utils).Assembly.Location);
		}

		public static string SettingsFile
		{
			get {return sSettingsFile;}
			set {sSettingsFile = value;}
		}
	}
}
