/*
 * Created on Apr 22, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.DocumentType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.documentManager.IDocumentManager;

import com.dommoni.ece.webui.MultipartRequestHandler;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocumentController
{
   public void uploadDocument(MultipartRequestHandler mrh, 
                              HttpSession session, 
                              HttpServletResponse response)
   {
      try
      {
         ProjectServerConnection psc = 
            (ProjectServerConnection)session.getAttribute("psc");
         Account userAccount = (Account)session.getAttribute("useraccount");
         Project currentProject = (Project)session.getAttribute("currentproject");
            
         String documentName = mrh.getParameter("name");
         String documentDescription = mrh.getParameter("description");
         
         Document document = new Document();
         
         document.setDocument(mrh.getReceivedFile());
         
         String filename = mrh.getFilename();
         document.setFilename(filename);
         document.setDocumentType(getDocumentType(filename));         
         document.setOwnerId(userAccount.getId());
         document.setProjectId(currentProject.getId());
         document.setName(documentName);
         document.setDescription(documentDescription);
            
         IDocumentManager documentManager = psc.getDocumentManager();
         documentManager.addDocument(document);
         
         try
         {
            response.sendRedirect("../projectDocuments.jsp");
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void downloadDocument(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         int docId = -1;
         String documentId = request.getParameter("documentid");
         try
         {
            docId = Integer.parseInt(documentId);
         }
         catch(NumberFormatException nfe)
         {
            nfe.printStackTrace();
         }
         
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         Document document = psc.getDocumentManager().getDocumentDeep(docId);
         
         ServletOutputStream sos = null;
         try
         {
            response.setHeader("Content-Disposition", "attachment;filename=" + document.getFilename());
            //response.encodeURL(document.getFilename());
            response.setContentType("application/octet-stream");
            
            sos = response.getOutputStream();
            sos.write(document.getDocument());
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         finally
         {
            try
            {
               if(sos != null)
                  sos.close();
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void deleteDocument(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         String stDocumentId = request.getParameter("documentid");
         String parentLink = request.getParameter("parentlink");
         
         int did = -1;
         
         try
         {
            did = Integer.parseInt(stDocumentId);
         }
         catch(NumberFormatException nfe)
         {
            nfe.printStackTrace();
         }
         
         if(did != -1)
         {
            ProjectServerConnection psc = 
               (ProjectServerConnection)request.getSession().getAttribute("psc");
            
            psc.getDocumentManager().dropDocument(did);
         }
         
         try
         {   
            response.sendRedirect("../projectConfirmDeleteDlgSuccess.jsp?parentlink=" + parentLink);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void editDocument(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         String documentId = request.getParameter("documentid");
         String name = request.getParameter("name");
         String fileName = request.getParameter("filename");
         
         String respath = request.getParameter("respath");
         
         try
         {
            int iDocumentId = Integer.parseInt(documentId);
            
            ProjectServerConnection psc = 
                        (ProjectServerConnection)request.getSession().getAttribute("psc");
            Document doc = psc.getDocumentManager().getDocumentShallow(iDocumentId);
            
            doc.setName(name);
            doc.setFilename(fileName);
            
            psc.getDocumentManager().modifyDocument(doc);
            
            StringBuffer sb = new StringBuffer();
            if(respath.startsWith("/"))
               sb.append("..");
            else if(!respath.startsWith("../"))
               sb.append("../");
               
            sb.append(respath);
            
            response.sendRedirect(sb.toString() + "?documentId=" + documentId);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   private int getDocumentType(String filename)
   {
      if(filename.toLowerCase().endsWith(".pdf"))
      {
         return DocumentType.PDF;
      }
      else if(filename.toLowerCase().endsWith(".txt"))
      {
         return DocumentType.PLAIN_TEXT;
      }
      else if (filename.toLowerCase().endsWith(".mdb"))
      {
         return DocumentType.MSOFFICE_ACCESS;
      }
      else if (filename.toLowerCase().endsWith(".xls"))
      {
         return DocumentType.MSOFFICE_EXCEL;
      }
      else if (filename.toLowerCase().endsWith(".xsn"))
      {
         return DocumentType.MSOFFICE_INFOPATH;
      }
      else if (filename.toLowerCase().endsWith(".one"))
      {
         return DocumentType.MSOFFICE_ONENOTE;
      }
      else if (filename.toLowerCase().endsWith(".ppt"))
      {
         return DocumentType.MSOFFICE_POWERPOINT;
      }
      else if (filename.toLowerCase().endsWith(".mpp"))
      {
         return DocumentType.MSOFFICE_PROJECT;
      }
      else if (filename.toLowerCase().endsWith(".pub"))
      {
         return DocumentType.MSOFFICE_PUBLISHER;
      }
      else if (filename.toLowerCase().endsWith(".vsd"))
      {
         return DocumentType.MSOFFICE_VISIO;
      }
      else if (filename.toLowerCase().endsWith(".doc"))
      {
         return DocumentType.MSOFFICE_WORD;
      }
      else
      {
         return DocumentType.UNKNOWN;
      }
   }
}
/*
 * 
 * $Log: DocumentController.java,v $
 * Revision 1.2  2005/10/16 06:03:17  brian
 * Added support for all Microsoft Office File Types (Office 2003 + infopath and onenote).
 *
 * 
 */
