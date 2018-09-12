package com.dommoni.roundtable.is.ui.ganttpanel;


/**
 * Manages Configuration for the Gantt Display.
 * @author Brian Abbott
 *
 */
public class DisplayConfiguration
{
   /*
    * Gantt Settings:
    *    - show_ledger_lines
    *  
    * 
    **/
   
   private boolean showLedgerLines;
   
   public boolean getShowLedgerLines()
   {
      return this.showLedgerLines;
   }
   
   public void setShowLedgerLines(boolean showLedgerLines)
   {
      this.showLedgerLines = showLedgerLines;
   }
   
   public static DisplayConfiguration getInstance()
   {
      return null;
   }
}
