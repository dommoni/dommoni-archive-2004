/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.documentManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Document;
/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IDocumentManager
{
   public int addDocument(Document document)
   throws Exception;
   
   public void dropDocument(int documentId)
   throws Exception;
   
   public void modifyDocument(Document document)
   throws Exception;
   
   public Document getDocumentDeep(int documentId)
   throws Exception;
   
   public Document getDocumentShallow(int documentId)
   throws Exception;
   
   public Document[] getAllDocumentsDeep()
   throws Exception;
   
   public Document[] getAllDocumentsShallow()
   throws Exception;
   
   public Document[] getAllDocumentsForProject(int projectId)
   throws Exception;
   
   public Document[] getAllDocumentsForProjectDeep(int projectId)
   throws Exception;
   
   public Document[] getAllDocumentsForProjectShallow(int projectId)
   throws Exception;
   
   public Document[] getDocumentsForProjectFromDocumentType(int projectId, int documentType)
   throws Exception;
   
   public Document[] getDocumentsForProjectFromDocumentTypeDeep(int projectId, int documentType)
   throws Exception;
   
   public Document[] getDocumentsForProjectFromDocumentTypeShallow(int projectId, int documentType)
   throws Exception;
   
   // Comments Convenience Methods
   public int addCommentForDocument(Document document, Comment comment)
   throws Exception;
   
   //public void dropCommentForDocument(Document document, Comment comment);
   
   public Comment[] getCommentsForDocument(Document document)
   throws Exception;
}
/*
 * 
 * $Log: IDocumentManager.java,v $
 * Revision 1.3  2005/10/17 07:39:25  brian
 * Added new API Calls:
 *    -  getDocumentsForProjectFromDocumentType()
 *    -  getDocumentsForProjectFromDocumentTypeDeep()
 *    -  getDocumentsForProjectFromDocumentTypeShallow()
 *
 * 
 */
