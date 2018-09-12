package com.dommoni.ece.webui;

import java.util.HashMap;

/**
 * Registry to hold ui-configuration information.
 *
 */
public class WebUIConfiguration //implements Cloneable
{
   private static WebUIConfiguration instance = new WebUIConfiguration();
   HashMap configuration = null;

   private WebUIConfiguration()
   {
   }

   public synchronized Object get(Object key)
   {
      return configuration.get(key);
   }
   
   public void setConfigurationVar(String name, Object value)
   {
      configuration.put(name, value);
   }
   
   public void consumeParser(UIConfigurationParser parser)
   {
      configuration = parser.getConfiguration();
   }

   private void setConfiguration(HashMap _configuration)
   {
      this.configuration = _configuration;
   }
   
   public static WebUIConfiguration getInstance()
   {
      if(instance == null)
      {
         instance = new WebUIConfiguration();
      }
      return instance;
   }
}
/*
 *
 * $Log: WebUIConfiguration.java,v $
 * Revision 1.2  2005/10/16 05:43:29  brian
 * Added helper method for locating SharedScheduling resources.
 *
 *
 */