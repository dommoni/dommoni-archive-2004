using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("Discussion", "http://www.dommoni.com/ROUNDTABLE")]
	public class Discussion : NotificationContextObject 
	{
    
		/// <remarks/>
		public System.DateTime date;
    
		/// <remarks/>
		public int[] memberIds;
    
		/// <remarks/>
		public DiscussionMessage[] messages;
    
		/// <remarks/>
		public int projectId;
    
		/// <remarks/>
		public string title;
	}
}
/*
 * 
 * $Log: Discussion.cs,v $
 * Revision 1.1  2005/03/26 17:48:45  brian
 * Initial Revision.
 *
 * 
 */