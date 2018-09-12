using System;

namespace RoundTable
{
	/// <summary>
	/// Summary description for RecentChange.
	/// </summary>
	[System.Xml.Serialization.SoapTypeAttribute("RecentChange", "http://www.dommoni.com/ROUNDTABLE")]
	public class RecentChange 
	{
		/// <remarks/>
		public string changeMessage;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public int projectId;
    
		/// <remarks/>
		public System.DateTime timestamp;
	}
}
/*
 * 
 * $Log: RecentChange.cs,v $
 * Revision 1.1  2005/03/26 17:48:46  brian
 * Initial Revision.
 *
 * 
 */