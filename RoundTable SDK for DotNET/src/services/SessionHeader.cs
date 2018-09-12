using System;
using System.Web.Services.Protocols;
using System.Xml.Serialization;


/// <summary>
/// Summary description for SessionHeader.
/// </summary>
public class SessionHeader : SoapHeader
{
	[XmlText]public string SessionID;
}

