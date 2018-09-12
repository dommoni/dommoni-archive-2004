using System;

namespace RoundTable
{
	[System.Xml.Serialization.SoapTypeAttribute("TaskStatus", "http://www.dommoni.com/ROUNDTABLE")]
	public class TaskStatus 
	{
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public int projectId;
    
		/// <remarks/>
		public string title;
	}
}
