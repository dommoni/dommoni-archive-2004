using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("ScheduleItem", "http://www.dommoni.com/ROUNDTABLE")]
	public class ScheduleItem 
	{
    
		/// <remarks/>
		public Comment[] comments;
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public string description;
    
		/// <remarks/>
		public System.Single duration;
    
		/// <remarks/>
		public System.DateTime endDate;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public int ordinal;
    
		/// <remarks/>
		public int percentComplete;
    
		/// <remarks/>
		public int priority;
    
		/// <remarks/>
		public Account[] resources;
    
		/// <remarks/>
		public System.DateTime startDate;
    
		/// <remarks/>
		public string title;
	}
}
