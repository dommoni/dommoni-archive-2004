using System;

namespace RoundTable
{
	/// <summary>
	/// Summary description for AccountContact.
	/// </summary>
	[System.Xml.Serialization.SoapTypeAttribute("AccountContact", "http://www.dommoni.com/ROUNDTABLE")]
	public class AccountContact 
	{
    
		/// <remarks/>
		public int accountId;
    
		/// <remarks/>
		public string city;
    
		/// <remarks/>
		public string officeAddress;
    
		/// <remarks/>
		public string phoneNumber;
    
		/// <remarks/>
		public string state;
    
		/// <remarks/>
		public string zip;
	}
}
/*
 * 
 * $Log: AccountContact.cs,v $
 * Revision 1.1  2005/03/26 17:48:44  brian
 * Initial Revision.
 *
 * 
 */