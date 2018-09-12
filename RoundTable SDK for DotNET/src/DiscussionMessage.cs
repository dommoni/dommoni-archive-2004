using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("DiscussionMessage", "http://www.dommoni.com/ROUNDTABLE")]
	public class DiscussionMessage 
	{
    
		/// <remarks/>
		public int accountId;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public string messageText;
    
		/// <remarks/>
		public System.DateTime timestamp;
	}
}
/*
 * 
 * $Log: DiscussionMessage.cs,v $
 * Revision 1.1  2005/03/26 17:48:45  brian
 * Initial Revision.
 *
 * 
 */