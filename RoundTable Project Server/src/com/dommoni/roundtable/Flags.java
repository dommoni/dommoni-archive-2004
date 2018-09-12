/*
 * Created on Mar 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.Vector;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Flags
{
   public static final int NO_FLAG  = 0;
   public static final int RED_FLAG = 1;
   public static final int BLUE_FLAG = 2; 
   public static final int YELLOW_FLAG = 3;
   public static final int GREEN_FLAG = 4;
   public static final int ORANGE_FLAG = 5;
   public static final int PURPLE_FLAG = 6;
   
   public static Flag flags[];
   
   static
   {
      Vector vFlags = new Vector();
      
      Flag noFlag = new Flag(NO_FLAG, "NO FLAG");
      vFlags.add(noFlag);
      
      Flag redFlag = new Flag(RED_FLAG, "RED FLAG");
      vFlags.add(redFlag);
      
      Flag blueFlag = new Flag(BLUE_FLAG, "BLUE FLAG");
      vFlags.add(blueFlag);
      
      Flag yellowFlag = new Flag(YELLOW_FLAG, "YELLOW FLAG");
      vFlags.add(yellowFlag);
      
      Flag greenFlag = new Flag(GREEN_FLAG, "GREEN FLAG");
      vFlags.add(greenFlag);
      
      Flag orangeFlag = new Flag(ORANGE_FLAG, "ORANGE FLAG");
      vFlags.add(orangeFlag);
      
      Flag purpleFlag = new Flag(PURPLE_FLAG, "PURPLE FLAG");
      vFlags.add(purpleFlag);
      
      flags = (Flag[])vFlags.toArray(new Flag[vFlags.size()]);
   }
   
   // dumb inner class to hold name/id mapping.
   public static class Flag
   {
      public int id;
      public String name;
      
      Flag(int _id, String _name)
      {
         this.id = _id;
         this.name = _name;
      }
   }
}
/*
 * 
 * $Log: Flags.java,v $
 * Revision 1.2  2005/03/26 19:01:47  brian
 * Added footer.
 *
 * 
 */