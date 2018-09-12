/*
 * IDocumentManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.DocumentManager
{
	/// <summary>
	/// Summary description for IDocumentManager.
	/// </summary>
	public interface IDocumentManager
	{
		int addDocument(Document document);
   
		void dropDocument(int documentId);
   
		void modifyDocument(Document document);
   
		Document getDocumentDeep(int documentId);
   
		Document getDocumentShallow(int documentId);
   
		Document[] getAllDocumentsDeep();
   
		Document[] getAllDocumentsShallow();
   
		Document[] getAllDocumentsForProject(int projectId);
   
		Document[] getAllDocumentsForProjectDeep(int projectId);
   
		Document[] getAllDocumentsForProjectShallow(int projectId);

		Document[] getDocumentsForProjectFromDocumentType(int projectId, int documentType);
   
		Document[] getDocumentsForProjectFromDocumentTypeDeep(int projectId, int documentType);
   
		Document[] getDocumentsForProjectFromDocumentTypeShallow(int projectId, int documentType);

		// Comments Convenience Methods
		int addCommentForDocument(Document document, Comment comment);
   
		//public void dropCommentForDocument(Document document, Comment comment);
   
		Comment[] getCommentsForDocument(Document document);
	}
}
/*
 * 
 * $Log: IDocumentManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */