/*
 * Created on Apr 9, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.ece.webui.MultipartRequestHandler;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountContact;
import com.dommoni.roundtable.AccountProfile;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountController
{
   public void createAccount(HttpServletRequest request, HttpServletResponse response)
   {
      String name;
      String username;
      String password;
      int accountType;
      
      try
      {
         name = request.getParameter("name");
         username = request.getParameter("username");
         password = request.getParameter("password");
         accountType = Integer.parseInt(request.getParameter("type"));
      }
      catch(Exception e)
      {
         // error
         e.printStackTrace();
         return;
      }
      
      if(username != null && password != null)
      {
         try
         {
            ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         
            IAccountManager accountManager = psc.getAccountManager();
            Account newAccount = new Account();
            newAccount.setName(name);
            newAccount.setUsername(username);
            newAccount.setPassword(password);
            newAccount.setAccountType(accountType);
            
            accountManager.addAccount(newAccount);
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
         try
         {
            // this page forwarding and redirecting NEEDS to be dynamically configured from the UI Config files.
            response.sendRedirect("../adminAccounts.jsp");
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
   }
   
   public void deleteAccount(HttpServletRequest request, HttpServletResponse response)
   {
      int accountId = -1;
      String parentLink = request.getParameter("parentlink");
      
      try
      {
         accountId = Integer.parseInt(request.getParameter("accountid"));
      }
      catch(NumberFormatException nfe)
      {
         nfe.printStackTrace();
      }
      
      try
      {
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         IAccountManager accountManager = psc.getAccountManager();
         accountManager.dropAccount(accountId);
         
         try
         {   
            response.sendRedirect("../projectConfirmDeleteDlgSuccess.jsp?parentlink=" + parentLink);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   public void editAccount(HttpServletRequest request, HttpServletResponse response)
   {
      // TODO: Implement ME!!!
   }
   
   public void saveAccountSettings(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         Account userAccount = (Account)request.getSession().getAttribute("useraccount");
         
         //
         // Account Settings
         //
         AccountSettings as = new AccountSettings();
         as.setAccountId(userAccount.getId());
         as.setPrimaryEmailAddress(request.getParameter("primaryEmail"));
         
         String nSystemMessage = request.getParameter("nSystemMessage");
         String nDesktopPager = request.getParameter("nDesktopPager");
         String nEmail = request.getParameter("nEmail");
         
         if(nSystemMessage != null && nSystemMessage.equals("yes"))
         {   
            as.setNotificationsSystemMessage(true); 
         } 
         else
         {   
            as.setNotificationsSystemMessage(false); 
         } 
            
         if(nDesktopPager != null && nDesktopPager.equals("yes"))
         {   
            as.setNotificationsDesktopPager(true); 
         } 
         else
         {   
            as.setNotificationsDesktopPager(false); 
         } 
         
         if(nEmail != null && nEmail.equals("yes"))
         {   
            as.setNotificationsEmail(true); 
         } 
         else
         {   
            as.setNotificationsEmail(false); 
         } 
         
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         IAccountManager accountManager = psc.getAccountManager();
         accountManager.modifyAccountSettings(as);
         
         //
         // Account Contact
         //
         AccountContact ac = new AccountContact();
         ac.setAccountId(userAccount.getId());
         ac.setPhoneNumber(request.getParameter("phonenumber"));
         ac.setOfficeAddress(request.getParameter("address"));
         ac.setCity(request.getParameter("city"));
         ac.setState(request.getParameter("state"));
         ac.setZip(request.getParameter("zip"));
         
         accountManager.modifyAccountContact(ac);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
      try
      {
         response.sendRedirect("../projectUserSettings.jsp");
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   public void changePassword(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         String newPass = request.getParameter("newpass");
         String retypePass = request.getParameter("retypepass");
         
         if(!newPass.equals(retypePass))
         {
            // they dont match...
            try
            {
               response.sendRedirect("../accountChangePassword.jsp?ec=1");
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
            return;
         }
         
         Account account = (Account)request.getSession().getAttribute("useraccount");
         account.setPassword(newPass);
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         IAccountManager accountManager = psc.getAccountManager();
         accountManager.modifyAccount(account);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
      try
      {
         response.sendRedirect("../projectUserSettings.jsp");
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   public void updateProfile(MultipartRequestHandler mrh, 
         HttpSession session, 
         HttpServletResponse response)
   {
      try
      {
         // profileText
         String profileText = mrh.getParameter("profileText");
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)session.getAttribute("psc");
         Account account = (Account)session.getAttribute("useraccount");
         
         AccountProfile newAccountProfile = new AccountProfile();
         newAccountProfile.setAccountId(account.getId());
         newAccountProfile.setProfileText(profileText);
         newAccountProfile.setImage(mrh.getReceivedFile());
         
         psc.getAccountManager().modifyAccountProfile(newAccountProfile);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
      try
      {
         response.sendRedirect("../accountEditProfile.jsp");
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
}
