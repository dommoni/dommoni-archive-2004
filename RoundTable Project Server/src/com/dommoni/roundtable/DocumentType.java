/*
 * Created on Mar 23, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocumentType
{
   //
   // Generic Documents (Group 0x00)
   //
   
   public static final int UNKNOWN     = 0x0000;
   public static final int PLAIN_TEXT  = 0x0001;
   public static final int PDF         = 0x0002;
   
   // Left for Backwards compatibility.
   public static final int DOC         = 0x0003;
   
   //
   // Microsoft Office Documents (Group 0x01)
   //
   
   public static final int MSOFFICE_ACCESS = 0x0101;
   public static final int MSOFFICE_EXCEL = 0x0102;
   public static final int MSOFFICE_INFOPATH = 0x0103;
   public static final int MSOFFICE_ONENOTE = 0x0104;
   public static final int MSOFFICE_POWERPOINT = 0x0105;
   public static final int MSOFFICE_PROJECT = 0x0106;
   public static final int MSOFFICE_PUBLISHER = 0x0107;
   public static final int MSOFFICE_VISIO = 0x0108;
   public static final int MSOFFICE_WORD = 0x0109;
   public static final int MSOFFICE_OUTLOOK_MSG = 0x0110;
   
   /*
    * JAR
    * EXE
    * DLL
    * IMAGE
    * JAVA
    * C_CPLUSPLUS
    * CSHARP
    * VISUALBASIC
    * C_HEADER
    * RTF
    * HTML
    * COMPRESSED_ARCHIVE
    * */
}
/*
 *
 * $Log: DocumentType.java,v $
 * Revision 1.1.1.1  2005/03/14 21:02:38  Brian Abbott
 * no message
 *
 *
 */