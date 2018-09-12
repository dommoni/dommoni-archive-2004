using System;
using System.IO;
using System.Collections;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters;
using System.Runtime.Serialization.Formatters.Binary;

namespace OutlookOIS
{
	/// <summary>
	/// Provides access to simple hashtable setting properties using
	/// Microsoft.ApplicationBlocks.ConfigurationManagement.
	/// </summary>
	[Serializable]
	class Settings
	{
		// private AppStorage appSettings = null;
		[NonSerialized]	private Logger logger;

		private string sUser = "";
		private string sPassword = "";
		private string sServerAddress = "";
		private int iPort = Utils.DEFAULT_PORT;
		private bool bSavePassword = true;
		private bool bIsSuccessfulConnection = false;
		private int iAccountID = 0;
		private bool bAutoSyncEnabled = true;
		private int iAutoSyncInterval = 5;
		private bool bSyncCompleted = true;
		private bool bRemoveDeletedTasks = false;
		private Hashtable hshProjectInfoTable = new Hashtable();
		private ArrayList lstLastSyncIDs = new ArrayList();
		private ArrayList lstIgnoredFolders = new ArrayList();
		
		const string DEFAULT_PORT = "8080";

		private Settings()
		{
			try
			{
				logger = new Logger(Utils.LogFile);
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}


		public void SaveSettings() 
		{
			Stream stream = new FileStream( Utils.SettingsFile, System.IO.FileMode.OpenOrCreate);

			if ( stream != null )
			{
				try
				{
					// Serialize the Settings file
					BinaryFormatter formatter = new BinaryFormatter();
					formatter.AssemblyFormat = FormatterAssemblyStyle.Simple;

					formatter.Serialize( stream, (Settings)this );
				}
				finally
				{
					stream.Close();
				}
			}
		}
		
		public static Settings LoadSettings()
		{
			// in the event of an error (e.g., old, invalid settings file from 
			// a previous version that won't desrialize), return a new instance
			if ( ! File.Exists( Utils.SettingsFile ))
			{
				// File not exists. Return a new instance.
				return new Settings();
			}
            
			Logger logger = new Logger(Utils.LogFile);

			Stream stream = new FileStream( Utils.SettingsFile, System.IO.FileMode.Open );

			FileInfo fi = new FileInfo(Utils.SettingsFile);

			if ( stream != null )
			{
				try
				{
					// DeSerialize the from stream.
					BinaryFormatter formatter = new BinaryFormatter();
					formatter.AssemblyFormat = FormatterAssemblyStyle.Simple;

					// register the assembly resolution handler
					ResolveEventHandler resolveHander = new ResolveEventHandler(Utils.MyResolveEventHandler);
					AppDomain.CurrentDomain.AssemblyResolve += resolveHander;
					
					Settings settings = (Settings) formatter.Deserialize(stream);

					// unregister the handler
					AppDomain.CurrentDomain.AssemblyResolve -= resolveHander;

					settings.logger = new Logger(Utils.LogFile);
					
					return settings;
				}
				catch (System.Exception ex)
				{
					ErrorHandler.PublishError(ex,logger);
					return new Settings();
				}
				finally
				{
					// We are done with it.
					stream.Close();
				}
			}
			else { return new Settings();}
		}

		public string User
		{
			get	{ return sUser; }
			set	{ sUser = value; }
		}

		public string Password
		{
			get	{ return sPassword; }
			set	{ sPassword = value; }
		}

		public string ServerAddress
		{
			get	{ return sServerAddress; }
			set	{ sServerAddress = value ; }
		}
		public int Port
		{
			get	{ return iPort; }
			set	{ iPort = value; }
		}
		
		public bool SavePassword
		{
			get	{ return bSavePassword; }
			set	{ bSavePassword = value ; }
		}
		public bool IsSuccessfulConnection
		{
			get	{ return bIsSuccessfulConnection; }
			set	{ bIsSuccessfulConnection = value ; }
		}

		public int AccountID
		{
			get	{ return iAccountID; }
			set	{ iAccountID = value ; }
		}

		public bool AutoSyncEnabled
		{
			get	{ return bAutoSyncEnabled; }
			set	{ bAutoSyncEnabled = value; }
		}
		public int AutoSyncInterval
		{
			get	{ return iAutoSyncInterval; }
			set	{ iAutoSyncInterval = value; }
		}

		public bool SyncCompleted
		{
			get	{ return bSyncCompleted; }
			set	{ bSyncCompleted = value; }
		}
		public bool RemoveDeletedTasks
		{
			get	{ return bRemoveDeletedTasks; }
			set	{ bRemoveDeletedTasks = value; }
		}

		public Hashtable ProjectInfoTable
		{
			get { return hshProjectInfoTable;}
			set { hshProjectInfoTable = value; }
		}
		
		// LastSyncTaskIDs contains an array of Todo/Task ID's for all RoundTable
		// tasks on the Outlook client as of the last sync. This includes tasks
		// that were created on the client and those created on the RoundTable
		// server, and is recreated each time the client syncs.
		public ArrayList LastSyncIDs
		{
			get { return lstLastSyncIDs; }
			set { lstLastSyncIDs = value; }
		}
		public ArrayList IgnoredFolders
		{
			get { return lstIgnoredFolders; }
			set { lstIgnoredFolders = value; }
		}
	}
}
