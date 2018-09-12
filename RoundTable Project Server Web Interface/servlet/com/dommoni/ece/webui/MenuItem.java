package com.dommoni.ece.webui;

import java.io.Serializable;

public class MenuItem implements Cloneable, Serializable
{
   public int id;
   public String title;
   public int ordinal;
   public String link;
   public boolean current;
   
   public Object clone()
   {
      MenuItem mi = new MenuItem();
      mi.id = id;
      mi.title = new String(title);
      mi.ordinal = ordinal;
      mi.link = new String(link);
      mi.current = current;
      
      return mi;
   }
}
