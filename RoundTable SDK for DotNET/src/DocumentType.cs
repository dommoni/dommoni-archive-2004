using System;

namespace RoundTable
{
	public class DocumentType
	{
		//
		// Generic Documents (Group 0x00)
		//
   
		public const int UNKNOWN     = 0x0000;
		public const int PLAIN_TEXT  = 0x0001;
		public const int PDF         = 0x0002;
   
		//
		// Microsoft Office Documents (Group 0x01)
		//
   
		public const int MSOFFICE_ACCESS = 0x0101;
		public const int MSOFFICE_EXCEL = 0x0102;
		public const int MSOFFICE_INFOPATH = 0x0103;
		public const int MSOFFICE_ONENOTE = 0x0104;
		public const int MSOFFICE_POWERPOINT = 0x0105;
		public const int MSOFFICE_PROJECT = 0x0106;
		public const int MSOFFICE_PUBLISHER = 0x0107;
		public const int MSOFFICE_VISIO = 0x0108;
		public const int MSOFFICE_WORD = 0x0109;
		public const int MSOFFICE_OUTLOOK_MSG = 0x0110;
	}
}
/*
 * 
 * $Log: DocumentType.cs,v $
 * Revision 1.1  2005/03/26 17:48:45  brian
 * Initial Revision.
 *
 * 
 */