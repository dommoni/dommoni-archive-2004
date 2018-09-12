using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("AccountSettings", "http://www.dommoni.com/ROUNDTABLE")]
	public class AccountSettings 
	{
    
		/// <remarks/>
		public int accountId;
    
		/// <remarks/>
		public bool notificationsDesktopPager;
    
		/// <remarks/>
		public bool notificationsEmail;
    
		/// <remarks/>
		public bool notificationsSystemMessage;
    
		/// <remarks/>
		public string primaryEmailAddress;
	}
}
/*
 * 
 * $Log: AccountSettings.cs,v $
 * Revision 1.1  2005/03/26 17:48:44  brian
 * Initial Revision.
 *
 * 
 */