using System;

namespace RoundTable
{
	[System.Xml.Serialization.SoapTypeAttribute("TaskReminder", "http://www.dommoni.com/ROUNDTABLE")]
	public class TaskReminder 
	{
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public int[] recipients;
    
		/// <remarks/>
		public System.DateTime reminderTime;
    
		/// <remarks/>
		public int taskId;
	}
}
