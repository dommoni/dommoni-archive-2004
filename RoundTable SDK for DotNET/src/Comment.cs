using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("Comment", "http://www.dommoni.com/ROUNDTABLE")]
	public class Comment 
	{
    
		/// <remarks/>
		public string comment;
    
		/// <remarks/>
		public string context;
    
		/// <remarks/>
		public int createdBy;
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public int objectId;
    
		/// <remarks/>
		public int projectId;
	}
}
/*
 * 
 * $Log: Comment.cs,v $
 * Revision 1.1  2005/03/26 17:48:45  brian
 * Initial Revision.
 *
 * 
 */