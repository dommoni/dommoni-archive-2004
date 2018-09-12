/*
 * Created on Apr 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.ece.webui.MultipartRequestHandler;
import com.dommoni.roundtable.BinaryAttachment;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.attachmentManager.IAttachmentManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AttachmentController
{
   public void createFileAttachment(MultipartRequestHandler mrh, 
         HttpSession session,
         HttpServletResponse response) 
   {
      System.out.println("Entering AttachmentController.createFileAttachment()");
      
      try
      {
         String objectId = mrh.getParameter("opparam");
         String context = mrh.getParameter("context");
         String parentLink = mrh.getParameter("parentlink");
         String name = mrh.getParameter("name");
         String filename = mrh.getParameter("file");
         String notes = mrh.getParameter("notes");
         
         System.out.println("ObjectID: " + objectId);
         System.out.println("Context: " + context);
         System.out.println("ParentLink: " + parentLink);
         System.out.println("Name: " + name);
         System.out.println("Filename: " + filename);
         System.out.println("Notes: " + notes);
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)session.getAttribute("psc");
         IAttachmentManager attachmentManager = psc.getAttachmentManager();
         
         BinaryAttachment attachment = new BinaryAttachment();
         attachment.setAttachment(mrh.getReceivedFile());
         attachment.setProjectId(psc.getCurrentProject().getId());
         attachment.setObjectContext(context.toUpperCase());
         attachment.setObjectId(Integer.parseInt(objectId));
         attachment.setName(name);
         attachment.setNotes(notes);
         //attachment.setFilename(filename);
         
         attachmentManager.addBinaryAttachment(attachment);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void deleteFileAttachment(HttpServletRequest request, 
         HttpServletResponse response) 
   {
      System.out.println("Entering AttachmentController.deleteFileAttachment()");
   }
   
   public void modifyFileAttachment(HttpServletRequest request, 
         HttpServletResponse response) 
   {
      System.out.println("Entering AttachmentController.modifyFileAttachment()");
   }
   
   public void createObjectAttachment(HttpServletRequest request, 
         HttpServletResponse response)
   {
      System.out.println("Entering AttachmentController.createObjectAttachment()");
   }
   
   public void deleteObjectAttachment(HttpServletRequest request, 
         HttpServletResponse response)
   {
      System.out.println("Entering AttachmentController.deleteObjectAttachment()");
   }
   
   public void modifyObjectAttachment(HttpServletRequest request, 
         HttpServletResponse response)
   {
      System.out.println("Entering AttachmentController.modifyObjectAttachment()");
   }
}
/*
 *
 * $Log: AttachmentController.java,v $
 * Revision 1.1  2005/10/16 05:55:22  brian
 * Initial Revision.
 *
 *
 */