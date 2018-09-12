using System;
using System.Xml.Serialization;

namespace RoundTable
{
	[System.Xml.Serialization.SoapTypeAttribute("CustomFieldAttribute", "http://www.dommoni.com/ROUNDTABLE")]
	public class CustomFieldAttribute 
	{
		/// <remarks/>
		public string name;
    
		/// <remarks/>
		public string value;
	}
}
