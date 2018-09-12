using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("CustomFieldValueWrapperString", "http://www.dommoni.com/ROUNDTABLE")]
	public class CustomFieldValueWrapperString : CustomFieldValueWrapper 
	{    
		/// <remarks/>
		public string value;
	}
}
