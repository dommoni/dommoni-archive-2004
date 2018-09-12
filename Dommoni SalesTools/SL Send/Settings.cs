using System;
using System.Collections;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters;
using System.Runtime.Serialization.Formatters.Binary;
using System.IO;

namespace SL_Send
{
	/// <summary>
	/// Provides access to simple hashtable setting properties using
	/// Microsoft.ApplicationBlocks.ConfigurationManagement.
	/// </summary>
	[Serializable]
	class Settings
	{
		private string attachmentFile = "";

		private Settings()
		{
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

//					settings.logger = new Logger(Utils.LogFile);
					
					return settings;
				}
				catch (System.Exception ex)
				{
//					ErrorHandler.PublishError(ex,logger);
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

		public string AttachmentFile
		{
			get	{ return this.attachmentFile; }
			set	{ this.attachmentFile = value; }
		}
	}
}
