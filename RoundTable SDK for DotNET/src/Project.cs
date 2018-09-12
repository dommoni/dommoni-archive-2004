using System;

namespace RoundTable
{
	/// <summary>
	/// Summary description for Project.
	/// </summary>
	[System.Xml.Serialization.SoapTypeAttribute("Project", "http://www.dommoni.com/ROUNDTABLE")]
	public class Project 
	{
    
		/// <remarks/>
		public int id;
    
		/// <remarks/>
		public Account[] members;
    
		/// <remarks/>
		public string name;
	}
}
/*
 * 
 * $Log: Project.cs,v $
 * Revision 1.2  2005/03/30 11:15:51  brian
 * Added Project fields.
 *
 * Revision 1.1  2005/03/26 17:48:46  brian
 * Initial Revision.
 *
 * 
 */