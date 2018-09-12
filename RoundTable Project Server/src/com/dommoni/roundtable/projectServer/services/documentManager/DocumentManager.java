/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.documentManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.commentManager.CommentManager;
import com.dommoni.roundtable.projectServer.services.commentManager.ICommentManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocumentManager implements IDocumentManager
{
	//public int addDocument(Event event, Document document)
   public int addDocument(Document document)
   throws Exception
   {
      Connection connection = null;
      int documentId = -1;
      
      if(document == null)
      {   
         return -1; 
      } 
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into documents (name,filename,owner_id,project_id,document_type,document,createdon,description) values (?,?,?,?,?,?,?,?)");
         
         pstmt.setString(1, document.getName());
         pstmt.setString(2, document.getFilename());
         pstmt.setInt(3, document.getOwnerId());
         pstmt.setInt(4, document.getProjectId());
         pstmt.setInt(5, document.getDocumentType());
         pstmt.setBinaryStream(6, new ByteArrayInputStream(document.getDocument()),document.getDocument().length);
         
         // createdon
         Timestamp tsCreatedOn = new Timestamp(System.currentTimeMillis());
         pstmt.setTimestamp(7, tsCreatedOn);
         
         // description
         pstmt.setString(8, document.getDescription());
         
         pstmt.executeUpdate();
         
         //
         // retrieve and return the id..
         //
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from documents", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            documentId = rs.getInt(1);
         }
         
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      return documentId;
   }
   
   /*public int addDocument(Document document)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public void dropDocument(Event event, int documentId)
   public void dropDocument(int documentId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from documents where id=?");
         pstmt.setInt(1, documentId);
         pstmt.executeUpdate();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();  
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }
   
   /*public void dropDocument(int documentId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyDocument(Event event, Document document)
   public void modifyDocument(Document document)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update documents set name=?, filename=?, description=? where id=?");
         pstmt.setString(1, document.getName());
         pstmt.setString(2, document.getFilename());
         pstmt.setString(3, document.getDescription());
         
         pstmt.setInt(4, document.getId());
         
         pstmt.executeUpdate();
         
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {   
               connection.close(); 
            } 
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }
   
   /*public void modifyDocument(Document document)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /**
    * A deep document retrieval will return all attributes of
    * the document including the byte[] document attribute that 
    * could be rather large. This should only be used when the 
    * end-user needs access to the actual contents of a document
    * 
    * @author Brian Abbott
    */
   //public Document getDocumentDeep(Event event, int documentId)
   public Document getDocumentDeep(int documentId)
   throws Exception
   {
      Connection connection = null;
      Document document = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select name,filename,owner_id,project_id,document_type,document,createdon,description from documents where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, documentId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            document = new Document();
            document.setId(documentId);
            document.setName(rs.getString(1));
            document.setFilename(rs.getString(2));
            document.setOwnerId(rs.getInt(3));
            document.setProjectId(rs.getInt(4));
            document.setDocumentType(rs.getInt(5));
            document.setDocument(getBytes(rs.getBinaryStream(6)));
            
            Calendar clCreatedOn = Calendar.getInstance();
            clCreatedOn.setTimeInMillis(rs.getTimestamp(7).getTime());
            document.setCreatedOn(clCreatedOn);
            
            document.setDescription(rs.getString(8));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      return document;
   }
   
   /*public Document getDocumentDeep(int documentId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Document getDocumentShallow(Event event, int documentId)
   public Document getDocumentShallow(int documentId)
   throws Exception
   {
      Connection connection = null;
      Document document = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select name,filename,owner_id,project_id,document_type,createdon,description from documents where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, documentId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            document = new Document();
            document.setId(documentId);
            document.setName(rs.getString(1));
            document.setFilename(rs.getString(2));
            document.setOwnerId(rs.getInt(3));
            document.setProjectId(rs.getInt(4));
            document.setDocumentType(rs.getInt(5));
            
            Calendar clCreatedOn = Calendar.getInstance();
            clCreatedOn.setTimeInMillis(rs.getTimestamp(6).getTime());
            document.setCreatedOn(clCreatedOn);
            
            document.setDescription(rs.getString(7));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      return document;
   }
   
   /*public Document getDocumentShallow(int documentId) //throws Exception
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //
   // These two methods are not currently impemented (and need to stay that way).
   //
   
   public Document[] getAllDocumentsDeep()
   throws Exception
   {
      return null;
   }
   
   public Document[] getAllDocumentsShallow()
   throws Exception
   {
      return null;
   }
   
   //public Document[] getAllDocumentsForProjectDeep(Event event, int projectId)
   public Document[] getAllDocumentsForProjectDeep(int projectId)
   throws Exception
   {
      Connection connection = null;
      Vector documents = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from documents where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            documents.add(getDocumentDeep(rs.getInt(1)));//event, rs.getInt(1)));      
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      return (Document[])documents.toArray(new Document[documents.size()]);
   }
   
   /*public Document[] getAllDocumentsForProjectDeep(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Document[] getAllDocumentsForProject(Event event, int projectId)
   public Document[] getAllDocumentsForProject(int projectId)
   throws Exception
   {
      return getAllDocumentsForProjectShallow(projectId);
   }
   
   /*public Document[] getAllDocumentsForProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public Document[] getAllDocumentsForProjectShallow(Event event, int projectId)
   public Document[] getAllDocumentsForProjectShallow(int projectId)
   throws Exception
   {
      Connection connection = null;
      Vector documents = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from documents where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            documents.add(getDocumentShallow(rs.getInt(1)));//event, rs.getInt(1)));      
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      return (Document[])documents.toArray(new Document[documents.size()]);
   }

   public Document[] getDocumentsForProjectFromDocumentType(int projectId, int documentType)
      throws Exception
   {
      return getDocumentsForProjectFromDocumentTypeShallow(projectId, documentType);
   }
   
   public Document[] getDocumentsForProjectFromDocumentTypeDeep(int projectId, int documentType) 
      throws Exception
   {
      Connection connection = null;
      List documents = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from documents where project_id=? and document_type=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         pstmt.setInt(2, documentType);
         
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            documents.add(getDocumentDeep(rs.getInt(1)));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return (Document[])documents.toArray(new Document[documents.size()]);
   }
   
   public Document[] getDocumentsForProjectFromDocumentTypeShallow(int projectId, int documentType)
      throws Exception
   {
      Connection connection = null;
      List documents = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from documents where project_id=? and document_type=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         pstmt.setInt(2, documentType);
         
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            documents.add(getDocumentShallow(rs.getInt(1)));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return (Document[])documents.toArray(new Document[documents.size()]);
   }

   /*public Document[] getAllDocumentsForProjectShallow(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public int addCommentForDocument(Event event, Document document, Comment comment)
   public int addCommentForDocument(Document document, Comment comment)
   throws Exception
   {
      ICommentManager cm = new CommentManager();
      return cm.addComment(document, comment);
   }
   
   /*public int addCommentForDocument(Document document, Comment comment)
   throws Exception
   {
      throw new ContextNotFoundException();
   }   */
   
   //public Comment[] getCommentsForDocument(Event event, Document document)
   public Comment[] getCommentsForDocument(Document document)
   throws Exception
   {
      ICommentManager cm = new CommentManager();
      return cm.getCommentsForObject(document);
   }

   /*public Comment[] getCommentsForDocument(Document document)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   private byte[] getBytes(InputStream ins)
   {
      try
      {
         int count = ins.available();
         byte[] data = new byte[count];
         ins.read(data);
         return data;
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return null;
   }
}
/*
 * 
 * $Log: DocumentManager.java,v $
 * Revision 1.3  2005/10/17 07:40:25  brian
 * Added new API Calls:
 *    -  getDocumentsForProjectFromDocumentType()
 *    -  getDocumentsForProjectFromDocumentTypeDeep()
 *    -  getDocumentsForProjectFromDocumentTypeShallow()
 *
 * Revision 1.2  2005/03/26 19:26:09  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
