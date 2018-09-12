package com.dommoni.ece.webui;

import java.io.IOException;

import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.ece.webui.menus.MenuItemMap;

public class MenuController
{
   private int currentPageId = -1;

   public void handleMenuRequest(HttpServletRequest request, HttpServletResponse response)
   {
      int menuId = Integer.parseInt(request.getParameter("mid"));
      MenuItemMap menus = (MenuItemMap)request.getSession().getAttribute("menus");

      // set current menu to false if it's been initialized.
      if(currentPageId != -1)
      {   
         getMenuItemFromId(currentPageId, menus).current = false;
      }
      else // never been initialized
      {
         // just set everything to false...
         Vector vAdminMenu = (Vector)menus.get("adminmenu");
         for(int i = 0; i < vAdminMenu.size(); i++)
         {
            ((MenuItem)vAdminMenu.get(i)).current = false;
         }
         
         // manager menus
         Vector vManagerMenu = (Vector)menus.get("managermenu");
         for(int i = 0; i < vManagerMenu.size(); i++)
         {
            ((MenuItem)vManagerMenu.get(i)).current = false;
         }
         
         // main menu
         Vector vMainMenu = (Vector)menus.get("mainmenu");
         for(int i = 0; i < vMainMenu.size(); i++)
         {
            ((MenuItem)vMainMenu.get(i)).current = false;
         }
      }
      
      MenuItem newMenu = getMenuItemFromId(menuId, menus);
      currentPageId = newMenu.id;
      newMenu.current = true;

      try
      {
         response.sendRedirect("../" + newMenu.link);
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }

   public MenuItem getMenuItemFromId(int menuId, HashMap menus)
   {
      //
      // search Admin first as it should be shorter.
      Vector vAdminMenu = (Vector)menus.get("adminmenu");
      for(int i = 0; i < vAdminMenu.size(); i++)
      {
         if(((MenuItem)vAdminMenu.get(i)).id == menuId)
         {   
            return (MenuItem)vAdminMenu.get(i);
         }
      }
      
      // manager menu
      Vector vManagerMenu = (Vector)menus.get("managermenu");
      for(int i = 0; i < vManagerMenu.size(); i++)
      {
         if(((MenuItem)vManagerMenu.get(i)).id == menuId)
         {   
            return (MenuItem)vManagerMenu.get(i);
         }
      }
      
      // main menu
      Vector vMainMenu = (Vector)menus.get("mainmenu");
      for(int i = 0; i < vMainMenu.size(); i++)
      {
         if(((MenuItem)vMainMenu.get(i)).id == menuId)
         {   
            return (MenuItem)vMainMenu.get(i);   
         }
      }
      return null;
   }

   public int getCurrentPageId()
   {
      return this.currentPageId;
   }
   
   // this is used for 'user settings' page and other pages that
   // need to turn the menu null. I dont want to expose the ability 
   // to actually set the page ID as that could open the system
   // up to vulnerabilities. So, this is the best way I can think
   // of for now.
   public void setCurrentPageIdToNull(HttpSession session)
   {
      this.currentPageId = -1;
      
      // just set everything to false...
      HashMap menus = (HashMap)session.getAttribute("menus");
      Vector vAdminMenu = (Vector)menus.get("adminmenu");
      for(int i = 0; i < vAdminMenu.size(); i++)
      {
         ((MenuItem)vAdminMenu.get(i)).current = false;
      }
      
      // manager menu
      Vector vManagerMenu = (Vector)menus.get("managermenu");
      for(int i = 0; i < vManagerMenu.size(); i++)
      {
         ((MenuItem)vManagerMenu.get(i)).current = false;
      }
      
   
      // main menu
      Vector vMainMenu = (Vector)menus.get("mainmenu");
      for(int i = 0; i < vMainMenu.size(); i++)
      {
         ((MenuItem)vMainMenu.get(i)).current = false;
      }
   }
}
