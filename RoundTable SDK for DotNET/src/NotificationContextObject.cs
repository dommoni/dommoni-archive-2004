using System;

namespace RoundTable
{
	/// <remarks/>
	[System.Xml.Serialization.SoapTypeAttribute("NotificationContextObject", "http://roundtable.dommoni.com")]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(Forum))]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(Discussion))]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(Task))]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(Document))]
	[System.Xml.Serialization.SoapIncludeAttribute(typeof(Meeting))]
	public abstract class NotificationContextObject 
	{
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public string name;
	}
}
/*
 * 
 * $Log: NotificationContextObject.cs,v $
 * Revision 1.1  2005/03/26 17:48:45  brian
 * Initial Revision.
 *
 * 
 */