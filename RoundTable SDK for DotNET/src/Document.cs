using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("Document", "http://www.dommoni.com/ROUNDTABLE")]
	public class Document : NotificationContextObject 
	{
    
		/// <remarks/>
		public System.DateTime createdOn;
    
		/// <remarks/>
		public string description;
    
		/// <remarks/>
		[System.Xml.Serialization.SoapElementAttribute(DataType="base64Binary")]
		public System.Byte[] document;
    
		/// <remarks/>
		public int documentType;
    
		/// <remarks/>
		public string filename;
    
		/// <remarks/>
		public int ownerId;
    
		/// <remarks/>
		public int projectId;
	}
}
/*
 * 
 * $Log: Document.cs,v $
 * Revision 1.1  2005/03/26 17:48:45  brian
 * Initial Revision.
 *
 * 
 */