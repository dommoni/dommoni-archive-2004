/*
 * Created on Apr 10, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UIState
{
   public static final int LOGGED_IN = 1;
   public static final int SESSION_EXPIRED = 2;
   public static final int WORKSPACE_SELECTED = 3;
   public static final int WORKSPACE_NOT_SELECTED = 4;
   
   int state;
   
   public UIState()
   {
      System.out.println("Creating UIState Object.");
   }
   
   public UIState(int currentState)
   {
      System.out.println("Creating UIState Object(INT).");
      
      state = currentState;
   }
   
   public int getState()
   {
      System.out.println("Calling UIState.getState()");
      
      return this.state;
   }
   
   public void setState(int _state)
   {
      System.out.println("Calling UIState.setState()");
      
      this.state = _state;
   }
   
   public static int getStateFromString(String stateString)
   {
      System.out.println("Calling UIState.getStateFromString()");
      
      if(stateString.equals("LOGGED_IN"))
      {
         return LOGGED_IN;
      }
      else if(stateString.equals("SESSION_EXPIRED"))
      {
         return SESSION_EXPIRED;
      }
      else if(stateString.equals("WORKSPACE_SELECTED"))
      {
         return WORKSPACE_SELECTED;
      }
      else if(stateString.equals("WORKSPACE_NOT_SELECTED"))
      {
         return WORKSPACE_NOT_SELECTED;
      }
      return 0;
   }
}
