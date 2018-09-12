using System;

namespace RoundTable
{
	/// <summary>
	/// Summary description for Schedule.
	/// </summary>
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("Schedule", "http://www.dommoni.com/ROUNDTABLE")]
	public class Schedule 
	{
		/// <remarks/>
		public int accessMode;
    
		/// <remarks/>
		public Comment[] comments;
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public string name;
    
		/// <remarks/>
		public int projectId;
    
		/// <remarks/>
		public ScheduleItem[] scheduleItems;
	}
}
