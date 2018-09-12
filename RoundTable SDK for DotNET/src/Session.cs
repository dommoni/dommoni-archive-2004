using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("Session", "http://www.dommoni.com/ROUNDTABLE")]
	public class Session 
	{
		/// <remarks/>
		public Account account;
    
		/// <remarks/>
		public Project currentProject;
    
		/// <remarks/>
		public System.DateTime endTime;
    
		/// <remarks/>
		public System.DateTime lastActivityTime;
    
		/// <remarks/>
		public string remoteIPAddress;
    
		/// <remarks/>
		public string sessionId;
    
		/// <remarks/>
		public System.DateTime startTime;
    
		/// <remarks/>
		public int type;
	}
}
/*
 * 
 * $Log: Session.cs,v $
 * Revision 1.1  2005/03/26 17:48:46  brian
 * Initial Revision.
 *
 * 
 */