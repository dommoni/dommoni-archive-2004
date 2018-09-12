using System;

namespace RoundTable
{
	/// <summary>
	/// Summary description for Account.
	/// </summary>
	[System.Xml.Serialization.SoapTypeAttribute("Account", "http://www.dommoni.com/ROUNDTABLE")]
	public class Account 
	{
    
		/// <remarks/>
		public int accountType;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public string name;
    
		/// <remarks/>
		public string nickName;
    
		/// <remarks/>
		public string password;
    
		/// <remarks/>
		public string profile;
    
		/// <remarks/>
		public string username;
	}
}
/*
 * 
 * $Log: Account.cs,v $
 * Revision 1.1  2005/03/26 17:48:44  brian
 * Initial Revision.
 *
 * 
 */