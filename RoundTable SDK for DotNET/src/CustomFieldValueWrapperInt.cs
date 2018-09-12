using System;

namespace RoundTable
{
	[System.Xml.Serialization.SoapTypeAttribute("CustomFieldValueWrapperInt", "http://www.dommoni.com/ROUNDTABLE")]
	public class CustomFieldValueWrapperInt : CustomFieldValueWrapper 
	{
		/// <remarks/>
		public int value;
	}
}
