/*
 * Created on Feb 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.exceptions;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ContextNotFoundException extends Exception
{
   public ContextNotFoundException()
   {
      super("RoundTable Context Not Found.");
   }
   
   public ContextNotFoundException(String msg)
   {
      this();
   }
}
/*
 * 
 * $Log: ContextNotFoundException.java,v $
 * Revision 1.2  2005/03/23 19:00:14  brian
 * Added footer.
 *
 * 
 */