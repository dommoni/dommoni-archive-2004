using System;

namespace RoundTable
{
	[System.Xml.Serialization.SoapTypeAttribute("Announcement", "http://www.dommoni.com/ROUNDTABLE")]
	public class Announcement 
	{
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public int projectId;
    
		/// <remarks/>
		public string text;
    
		/// <remarks/>
		public string title;

	}
}
/*
 * 
 * $Log: Announcement.cs,v $
 * Revision 1.1  2005/03/26 17:48:44  brian
 * Initial Revision.
 *
 * 
 */