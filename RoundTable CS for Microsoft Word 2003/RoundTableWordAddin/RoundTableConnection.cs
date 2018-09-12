using System;
using System.Collections;
using RoundTable;

namespace RoundTableWordAddin
{
	public class RoundTableConnection
	{
		bool connected;
		ConnectionSettings settings;
		ProjectServerConnection serverConnection;

		public RoundTableConnection(ConnectionSettings settings)
		{
			connected = false;
			serverConnection = new ProjectServerConnection(settings.Username, 
				settings.Password, 1, settings.IPAddr, settings.Port);
		}
		
		//---------------------------------------------------------------------
		// Properties
		//

		public ProjectServerConnection Connection
		{
			get
			{
				return this.serverConnection;
			}
		}

		public bool Connected
		{
			get
			{
				return this.connected;
			}
		}

		//---------------------------------------------------------------------
		// Methods
		//

		public void Connect()
		{
			serverConnection.login();
			connected = true;
		}

		public Hashtable GetProjects()
		{
			Project[] projects = serverConnection.ProjectManager.getAllProjectsForAccount(serverConnection.Account.id);
			Hashtable hshProjects = new Hashtable();
			foreach(Project p in projects)
			{
				hshProjects.Add(p.name, p);
			}
			return hshProjects;
		}
	}
}
