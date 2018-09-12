using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("AccountProfile", "http://www.dommoni.com/ROUNDTABLE")]
	public class AccountProfile 
	{
    
		/// <remarks/>
		public int accountId;
    
		/// <remarks/>
		public string city;
    
		/// <remarks/>
		public string emailAddress;
    
		/// <remarks/>
		public string faxNumber;
    
		/// <remarks/>
		public string homePhoneNumber;
    
		/// <remarks/>
		[System.Xml.Serialization.SoapElementAttribute(DataType="base64Binary")]
		public System.Byte[] image;
    
		/// <remarks/>
		public string mailingAddress;
    
		/// <remarks/>
		public string mobilePhoneNumber;
    
		/// <remarks/>
		public string profileText;
    
		/// <remarks/>
		public string state;
    
		/// <remarks/>
		public string workPhoneNumber;
    
		/// <remarks/>
		public string zip;

	}
}
/*
 * 
 * $Log: AccountProfile.cs,v $
 * Revision 1.1  2005/03/26 17:48:44  brian
 * Initial Revision.
 *
 * 
 */