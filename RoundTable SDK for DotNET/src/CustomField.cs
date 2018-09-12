using System;

namespace RoundTable
{
	[System.Xml.Serialization.SoapTypeAttribute("CustomField", "http://www.dommoni.com/ROUNDTABLE")]
	public class CustomField 
	{
		public const int T_STRING = 0;
		public const int T_INTEGER = 1;
    
		/// <remarks/>
		public CustomFieldAttribute[] attributes;

		/// <remarks/>
		public int createdBy;

		/// <remarks/>
		public System.DateTime createdOn;

		/// <remarks/>
		public bool hidden;

		/// <remarks/>
		public int id;

		/// <remarks/>
		public string name;

		/// <remarks/>
		public int ordinal;

		/// <remarks/>
		public int type;

		/// <remarks/>
		public CustomFieldValueWrapper valueWrapper;
	}
}
