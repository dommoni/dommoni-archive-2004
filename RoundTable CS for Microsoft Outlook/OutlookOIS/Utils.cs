using System;
using System.IO;
using System.Reflection;
using Microsoft.Office.Interop.Outlook;

namespace OutlookOIS
{
	/// <summar>
	/// Summary description for Defaults.
	/// </summary>
	class Utils
	{
		// NOTE: STATIC REFS ARE VERY VERY BAD. NOT SURE WHY DAN DID THIS.
		//public static Microsoft.Office.Core.CommandBar menuBar;

		public static string sLogFile;
		public static string sSettingsFile;
		public static string sAppPath;

		public const string LOG_FILE= "OutlookOIS.log";
		public const string SETTINGS_FILE = "OutlookOISSettings.dat";
		public const string FIELD_MAPPINGS_FILE = "RoundTableFieldMappings.xml";

		// Default values
		public const int DEFAULT_PORT = 8080;

		// Menu Items
		public const string MENU_ITEM_ROUNDTABLE = "&RoundTable";
		public const string MENU_ITEM_SYNC = "&Synchronize Tasks ...";
		public const string MENU_ITEM_SETTINGS = "&Edit Settings ...";
		public const string MENU_ITEM_ABOUT = "&About Round Table OIS";
		
		// MessageBox text
		public const string MESSAGE_CONNECT_SUCCESS = "Successfully connected to RoundTable Project Server.";
		public const string MESSAGE_CONNECT_SUCCESS_TITLE = "Connection Success";
		public const string MESSAGE_CONNECT_FAILURE = "Unable to connect to RoundTable Project Server.";
		public const string MESSAGE_CONNECT_FAILURE_TITLE = "Connection Failed";
		public const string MESSAGE_CONNECT_FAILURE_REVIEW = "Unable to connect to the RoundTable Project Server. Please review your connection settings.";
		public const string MESSAGE_NO_SUCCESSFUL_CONNECTION_TITLE = "Not Yet Connected";
		public const string MESSAGE_NO_SUCCESSFUL_CONNECTION = "You have not yet connected to the RoundTable Project Server. \r\n\r\n" +
			                      "To connect, please provide the following information:\r\n\r\n" +
			                      "    1. IP Address of the RoundTable Project Server\r\n" +
								  "    2. The port of the server \r\n" +
								  "    3. Your RoundTable account username \r\n" +
								  "    4. Your RoundTable account password";

		// Outlook Item UserProperty Names
		public const string RT_TODO_ID_PROP_NAME = "RoundTable Todo ID";
		public const string RT_TODO_PROJID_PROP_NAME = "RoundTable Project ID";

		public const string RT_CUSTOM_FIELD_TAGS = "RoundTable Custom Field Tags";
		public const string RT_TEMPLATE_TAGS = "RoundTableTemplateTags";
		public const string RT_TEMPLATE_TAG_DELIMETER = ";";
		public const string RT_SHARED_OFTFILE_TAG = "ol-shared-oft";
		public const string RT_EMBEDDED_PROPERTY = "ol_property_name";

		// Form Control Text
		public const string CONNECTION_PROGRESS_MESSAGE = "Connecting to the RoundTable Project Server. Please wait ...";
		public const string SYNC_PROGRESS_MESSAGE = "Synchronizing Outlook with the RoundTable Server. Please wait ...";
		public const string CONNECTION_PROGRESS_TITLE = "Please Wait";

		// Other
		public const string NON_RT_TASK = "None (Not a RoundTable Task)";

		// TODO: Finish adding app-wide settings
		/*
			 * SYSTEM SETTINGS
			 * AppName
			 * 
			 * 
			 * GUI SPECIFIC
			 * SettingsFormTitle
			 * 
			 * 
			 * COLORS
			 * Border
			 * GradHeaderLight
			 * GradHeaderDark
			 * FormBackColor
			 * ButtonBackColor
			 * 
			 * 
			 */

		public static string GetFileLoc(string sFile) 
		{
			FileInfo fi = new FileInfo(sFile);
			return fi.DirectoryName;
		}

		public static void SetAppPath()
		{
			sAppPath = GetFileLoc(typeof(OutlookOIS.Utils).Assembly.Location);
		}

		public static string GetAppPath
		{
			get {return sAppPath;}
		}


		public static string LogFile
		{
			get {return sLogFile;}
			set {sLogFile = value;}
		}

		public static string SettingsFile
		{
			get {return sSettingsFile;}
			set {sSettingsFile = value;}
		}

		public static bool HasUserProperty(TaskItem taskItem, string sPropName)
		{
			// TODO: extend this to work with items other than tasks (overloads?)
			try
			{
				UserProperty prop = taskItem.UserProperties.Find(sPropName, Type.Missing);

				if ( prop == null ) { return false; }
				else { return true; }
			}
			catch(System.Exception ex)
			{ 
				ErrorHandler.PublishError(ex);
				return false;
			}
		}

		public static string GetShortOutlookFolderName(string sFolder)
		{

			if ( sFolder == null || sFolder == string.Empty ) return "";

			sFolder = sFolder.Replace("\\\\","");

			return sFolder.Substring(sFolder.IndexOf("\\") + 1);
		}

		public static OlUserPropertyType GetOlTypeForFieldType(int fieldType)
		{
			if (fieldType == RoundTable.CustomField.T_INTEGER)
				return OlUserPropertyType.olNumber;
			else if (fieldType == RoundTable.CustomField.T_STRING)
				return OlUserPropertyType.olText;
			else
				return OlUserPropertyType.olCombination;
		}


		public static Assembly MyResolveEventHandler(object sender, ResolveEventArgs args)
		{
			// TODO: Review later. this makes a big assumption: that all referenced assemblies
			//       will be in the same folder as the calling assembly.

			// NOTE: The danger was reduced by calling adding this handler immediately before 
			//       deserializing the settings file and removing it immediately afterwards

			Logger logger = new Logger(LogFile);
			logger.LogMessage("Entering ResolveEventHandler with args: " + args.Name);

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
