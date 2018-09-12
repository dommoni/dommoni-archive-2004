/*
 * Created on Oct 10, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.utils;


/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class StringUtils
{
   /**
    * Adds an escape character in front of 's and "s
    * 
    * @param srcStr
    * @return
    */
   public static String getJSString(String srcStr)
   {
      char cStr[] = srcStr.toCharArray();
      StringBuffer sb = new StringBuffer();
      
      for(int i = 0; i < cStr.length; i++) 
      {   
         if(cStr[i] == '\'' || cStr[i] == '\"')
         {
            sb.append("\\");
            if(cStr[i] == '\"')
               cStr[i] = '\''; // we cant have "s in a JavaScript string.
         }
         sb.append(cStr[i]);
      }
      return sb.toString();
   }
   
}
/*
 *
 * $Log: StringUtils.java,v $
 * Revision 1.2  2005/10/16 06:15:39  brian
 * Added Footer.
 *
 *
 */