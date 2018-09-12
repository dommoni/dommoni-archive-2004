using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("NamedTemplateFieldDefinition", "http://www.dommoni.com/ROUNDTABLE")]
	public class NamedTemplateFieldDefinition 
	{
		/// <remarks/>
		public string description;
    
		/// <remarks/>
		public string name;
    
		/// <remarks/>
		public int ordinal;
    
		/// <remarks/>
		public int type;
	}
}
