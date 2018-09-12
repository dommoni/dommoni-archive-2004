using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("Task", "http://www.dommoni.com/ROUNDTABLE")]
	public class Task : NotificationContextObject 
	{
		/// <remarks/>
		public int assignedTo;
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public TaskStatus currentStatus;
    
		/// <remarks/>
		public CustomField[] customFields;
    
		/// <remarks/>
		public string description;
    
		/// <remarks/>
		public System.DateTime dueDate;
    
		/// <remarks/>
		public int flag;
    
		/// <remarks/>
		public bool isPublic;
    
		/// <remarks/>
		public System.DateTime lastModified;
    
		/// <remarks/>
		public NamedFieldCollection[] namedFieldCollections;
    
		/// <remarks/>
		public int percentComplete;
    
		/// <remarks/>
		public int projectId;
    
		/// <remarks/>
		public System.DateTime startDate;
    
		/// <remarks/>
		public TaskReminder taskReminder;
    
		/// <remarks/>
		public string title;
	}
}
