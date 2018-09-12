package com.dommoni.ece.webui;

import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.dommoni.ece.webui.menus.MenuItemList;
import com.dommoni.ece.webui.menus.MenuItemMap;

public class UIConfigurationParser
{
   HashMap configuration;

   public UIConfigurationParser(File xmlFile)
   {
      try
      {
         // Get SAX Parser Factory
         SAXParserFactory factory = SAXParserFactory.newInstance();
         
         // Turn on validation and turn off namespaces
         factory.setValidating(true);
         factory.setNamespaceAware(false);
         
         SAXParser parser = factory.newSAXParser();
         XmlHandler xmlHandler = new XmlHandler();
         parser.parse(xmlFile, xmlHandler);

         configuration = xmlHandler.getConfiguration();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public HashMap getConfiguration()
   {
      return this.configuration;
   }
}

class XmlHandler extends DefaultHandler 
{
   // SAX callback implementations from DocumentHandler, ErrorHandler, etc.
   HashMap configuration = new HashMap();
   
   HashMap pagelinks = new HashMap();  // "pagelinks"
   HashMap texts = new HashMap();      // "texts"
   HashMap operationmenus = new HashMap(); // "operationmenus"
   MenuItemMap menus = new MenuItemMap(); // "menus"
   
   // text helper variables
   String textName;
   
   // operation helper variables
   Vector currentOperationMenu;
   String currentOperationMenuName;
   
   // menu helper variables 
   String currentMenuName;
   MenuItemList currentMenu;
   MenuItem currentMenuItem;

   final int TITLE      = 1;
   final int ORDINAL    = 2;
   final int LINK       = 3;
   final int TEXT       = 4;

   int op = 0;
   int id = 0;

   public void characters(char[] ch, int start, int length) 
   {
      switch(op)
      {
      case TITLE:
         currentMenuItem.title = new String(ch, start, length).trim();
         break;

      case ORDINAL:
         currentMenuItem.ordinal = Integer.parseInt(new String(ch, start, length));
         break;
         
      case LINK:
         currentMenuItem.link = new String(ch, start, length).trim();
         break;
         
      case TEXT:
         System.out.println("Adding to text: " + new String(ch, start, length));
         texts.put(textName, new String(ch, start, length).trim());   

      default:
         break;
      }
   }

   public void startElement(String uri, String localName, String qName, Attributes atts) 
   {
      if(qName.trim().equals("menu"))
      {
         currentMenuName = atts.getValue("name");
         currentMenu = new MenuItemList();
      }
      if(qName.trim().equals("menuitem"))
      {
         currentMenuItem = new MenuItem();
         currentMenuItem.id = ++id;
      }
      if(qName.trim().equals("title"))
      {   
         op = TITLE;
      }
      if(qName.trim().equals("ordinal"))
      {   
         op = ORDINAL;
      }
      if(qName.trim().equals("link"))
      {   
         op = LINK;
      }
      if(qName.trim().equals("pagelink"))
      {
         pagelinks.put(atts.getValue("name"), atts.getValue("value"));
      }
      if(qName.trim().equals("text"))
      {
         textName = atts.getValue("name");
         op = TEXT;
      }
      if(qName.trim().equals("operationmenu"))
      {
         currentOperationMenu = new Vector();
         currentOperationMenuName = atts.getValue("name");
      }
      if(qName.trim().equals("operationmenuitem"))
      {
         // name,link,state
         String opMenuItem[] = {
            atts.getValue("name"),
            atts.getValue("link"),
            atts.getValue("state") 
         };
         currentOperationMenu.add(opMenuItem);
      }  
   }

   public void endElement(String uri, String localName, String qName) 
   {
      if(qName.trim().equals("menu"))
      {   
         menus.put(currentMenuName, currentMenu);
      }
      if(qName.trim().equals("menus"))
      {
         configuration.put("menus", menus);
      }
      if(qName.trim().equals("pagelinks"))
      {
         configuration.put("pagelinks", pagelinks);
      }

      if(qName.trim().equals("menuitem"))
      {   
         currentMenu.add(currentMenuItem);
      }
      
      if(qName.trim().equals("operationmenu"))
      {
         operationmenus.put(currentOperationMenuName, currentOperationMenu);
      }
      if(qName.trim().equals("operationmenus"))
      {
         configuration.put("operationmenus", operationmenus);
      }
      if(qName.trim().equals("texts"))
      {
         configuration.put("texts", texts);
      }
   }

   public HashMap getConfiguration()
   {
      return this.configuration;
   }
}
