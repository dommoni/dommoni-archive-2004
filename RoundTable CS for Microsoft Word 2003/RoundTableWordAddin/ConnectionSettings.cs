using System;
using System.IO;
using System.Reflection;
using System.Runtime.Serialization.Formatters;
using System.Runtime.Serialization.Formatters.Binary;
using System.Windows.Forms;

namespace RoundTableWordAddin
{
	[Serializable]
	public class ConnectionSettings
	{
		private string ipAddr;
		private int port;
		private string username;
		private string password;
		private bool savePassword;
		
		public string IPAddr 
		{
			get 
			{
				return this.ipAddr;
			}
			
			set 
			{
				this.ipAddr = value;
			}
		}
		
		public int Port 
		{
			get 
			{
				return this.port;
			}

			set 
			{
				this.port = value;
			}
		}
		
		public string Username 
		{
			get 
			{
				return this.username;
			}
			
			set 
			{
				this.username = value;
			}
		}
		
		public string Password
		{
			get
			{
				return this.password;
			}

			set
			{
				this.password = value;
			}
		}
		
		public bool SavePassword
		{
			get
			{
				return this.savePassword;
			}

			set
			{
				this.savePassword = value;
			}
		}

		public ConnectionSettings()
		{
		}

		public void SaveSettings()
		{
			Stream stream = new FileStream(Utils.SETTINGS_FILE, System.IO.FileMode.OpenOrCreate);

			if ( stream != null )
			{
				try
				{
					// Serialize the Settings file
					BinaryFormatter formatter = new BinaryFormatter();
					formatter.AssemblyFormat = FormatterAssemblyStyle.Simple;

					formatter.Serialize( stream, (ConnectionSettings)this );
				}
				finally
				{
					stream.Close();
				}
			}
		}

		public bool isValid()
		{
			if (this.username != null && this.username.Length > 0 &&
				this.ipAddr != null && this.ipAddr.Length > 0 &&
				this.port > 0) // passwords can be blank.
				return true;
			return false;
		}
		
		public static ConnectionSettings LoadSettings()
		{
			// get the current users local application directory
			
			if ( ! File.Exists( Utils.SETTINGS_FILE ))
			{
				// File not exists. Return a new instance.
				return new ConnectionSettings();
			}
            
			//Logger logger = new Logger(Utils.LogFile);

			Stream stream = new FileStream( Utils.SETTINGS_FILE, System.IO.FileMode.Open );

			FileInfo fi = new FileInfo(Utils.SETTINGS_FILE);

			if ( stream != null )
			{
				try
				{
					// DeSerialize the from stream.
					BinaryFormatter formatter = new BinaryFormatter();
					formatter.AssemblyFormat = FormatterAssemblyStyle.Simple;

					// register the assembly resolution handler
					ResolveEventHandler resolveHander = new ResolveEventHandler(MyResolveEventHandler);
					AppDomain.CurrentDomain.AssemblyResolve += resolveHander;
					
					ConnectionSettings settings = (ConnectionSettings) formatter.Deserialize(stream);

					// unregister the handler
					AppDomain.CurrentDomain.AssemblyResolve -= resolveHander;

					//settings.logger = new Logger(Utils.LogFile);
					
					return settings;
				}
				catch (System.Exception ex)
				{
					//ErrorHandler.PublishError(ex,logger);
					return new ConnectionSettings();
				}
				finally
				{
					// We are done with it.
					stream.Close();
				}
			}
			else 
			{ 
				return new ConnectionSettings();
			}
		}

		public static Assembly MyResolveEventHandler(object sender, ResolveEventArgs args)
		{
			// TODO: Review later. this makes a big assumption: that all referenced assemblies
			//       will be in the same folder as the calling assembly.

			// NOTE: The danger was reduced by calling adding this handler immediately before 
			//       deserializing the settings file and removing it immediately afterwards

			//Logger logger = new Logger(LogFile);
			//logger.LogMessage("Entering ResolveEventHandler with args: " + args.Name);

			string[] strProps = args.Name.Split(new char[] {','});

			string sFile = typeof(RoundTableWordAddin.ConnectionSettings).Assembly.Location;
			FileInfo fi = new FileInfo(sFile);
			string path = fi.DirectoryName;


			string sPath = path + "\\" + strProps[0] + ".dll";
			
			if ( File.Exists(sPath) )
			{
				return Assembly.LoadFrom(sPath);
			}

			return null;
		}
	}
}
