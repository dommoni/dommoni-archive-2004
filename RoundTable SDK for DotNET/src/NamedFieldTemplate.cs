using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("NamedFieldTemplate", "http://www.dommoni.com/ROUNDTABLE")]
	public class NamedFieldTemplate 
	{
		/// <remarks/>
		public string context;
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public string description;
    
		/// <remarks/>
		public NamedTemplateFieldDefinition[] fieldDefinitions;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public string name;
    
		/// <remarks/>
		public int projectId;
	}
}
