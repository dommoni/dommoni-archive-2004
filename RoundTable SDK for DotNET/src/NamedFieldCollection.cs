using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("NamedFieldCollection", "http://www.dommoni.com/ROUNDTABLE")]
	public class NamedFieldCollection 
	{
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public string description;
    
		/// <remarks/>
		public CustomField[] fields;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public string name;
    
		/// <remarks/>
		public int projectId;
	}

}
