using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("CustomFieldValueWrapper", "http://www.dommoni.com/ROUNDTABLE")]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(CustomFieldValueWrapperString))]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(CustomFieldValueWrapperInt))]
	public abstract class CustomFieldValueWrapper 
	{
	}
}
