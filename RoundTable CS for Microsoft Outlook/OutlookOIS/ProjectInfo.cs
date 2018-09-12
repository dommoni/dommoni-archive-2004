using System;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for ProjectInfo.
	/// </summary>
	[Serializable()]
	class ProjectInfo
	{

		int iProjID;
		string sProjName = "";
		bool bSyncEnabled = true;
		string sSyncFolder = "";
		bool bSyncCompletedTasks = false;

		public int ProjID
		{
			get { return iProjID; }
			set { iProjID = value; }
		}
		public string ProjectName
		{
			get { return sProjName; }
			set { sProjName = value; }
		}
		public bool SyncEnabled
		{
			get { return bSyncEnabled ; }
			set { bSyncEnabled = value; }
		}
		public string SyncFolder
		{
			get { return sSyncFolder; }
			set { sSyncFolder = value; }
		}
		public string SyncFolderShort
		{
			get { return Utils.GetShortOutlookFolderName(sSyncFolder); }
		}

		public bool SyncCompletedTasks
		{
			get { return bSyncCompletedTasks;}
			set { bSyncCompletedTasks = value;}
		}
		
		public override string ToString()
		{
			return ProjectName;
		}

	}
}
