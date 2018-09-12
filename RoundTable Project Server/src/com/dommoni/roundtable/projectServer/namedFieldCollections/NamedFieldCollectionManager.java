package com.dommoni.roundtable.projectServer.namedFieldCollections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.CustomField;
import com.dommoni.roundtable.NamedFieldCollection;
import com.dommoni.roundtable.NamedFieldTemplate;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.customfields.CustomFieldManager;
import com.dommoni.roundtable.projectServer.customfields.ICustomFieldManager;
import com.dommoni.roundtable.projectServer.utils.RoundTableContextHelper;

public class NamedFieldCollectionManager implements INamedFieldCollectionManager
{
   public synchronized int addNamedFieldCollection(Object parentObject, NamedFieldCollection namedFieldCollection) 
      throws Exception
   {
      Connection connection = null;
      int namedFieldId = -1;
      
      if (parentObject == null || namedFieldCollection == null)
      {
         throw new NullPointerException("Required Parameter was Null");
      }
      
      try
      {
         // TODO: ProjectID isn't needed here. Remove it from the controller logic and data model.
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into named_field_collections (" +
               "parent_id, project_id, context, name, created_by, created_on, description) values (?, ?, ?, ?, ?, ?, ?)");
         
         if (parentObject instanceof Task)
         {
            Task parentTask = (Task)parentObject;
            pstmt.setInt(1, parentTask.getId());
            pstmt.setInt(2, parentTask.getProjectId());
         }
         
         pstmt.setString(3, RoundTableContextHelper.getContext(parentObject));
         pstmt.setString(4, namedFieldCollection.getName());
         pstmt.setInt(5, namedFieldCollection.getCreatedBy());
         pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
         pstmt.setString(7, namedFieldCollection.getDescription());
         pstmt.executeUpdate();

         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from named_field_collections", 
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            namedFieldId = rs.getInt(1);
            namedFieldCollection.setId(namedFieldId);
         }
         rs.close();
         
         CustomField[] fields = namedFieldCollection.getFields();
         ICustomFieldManager cfm = new CustomFieldManager();
         for (int i = 0; i < fields.length; i++)
         {
            try
            {
               cfm.addCustomField(namedFieldCollection, fields[i]);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
         
         pstmt.close();
      }
      catch (SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
            {   
               connection.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return namedFieldId;
   }
   
   public synchronized void dropNamedFieldCollection(int namedFieldCollectionId) 
      throws Exception
   {
      Connection connection = null;
      
      try
      {
         NamedFieldCollection namedCollection = getNamedFieldCollection(namedFieldCollectionId);
         
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from named_field_collections where id=?");
         pstmt.setInt(1, namedFieldCollectionId);
         pstmt.executeUpdate();
         
         ICustomFieldManager cfm = new CustomFieldManager();
         CustomField[] fields = namedCollection.getFields();
         for (int i = 0; i < fields.length; i++)
         {
            try
            {
               cfm.dropCustomField(fields[i].getId());
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      }
      catch (SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
            {
               connection.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
   
   public synchronized void modifyNamedFieldCollection(NamedFieldCollection namedFieldCollection) 
      throws Exception
   {
      // mod the nfc table, use CFields Manager to handle fields...
      System.out.println("Entering NamedFieldCollectionManager.modifyNamedFieldCollection()...");
      
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("update named_field_collections set name=?, description=? where id=?");
         pstmt.setString(1, namedFieldCollection.getName());
         pstmt.setString(2, namedFieldCollection.getDescription());
         pstmt.setInt(3, namedFieldCollection.getId());
         pstmt.executeUpdate();
         pstmt.close();
         
         CustomField[] fields = namedFieldCollection.getFields();
         if (fields != null && fields.length > 0)
         {
            ICustomFieldManager fieldManager = new CustomFieldManager();
            for (int i = 0; i < fields.length; i++)
            {
               fieldManager.modifyCustomField(namedFieldCollection, fields[i]);
            }
         }
      }
      catch (SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
            {   
               connection.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
   
   public synchronized NamedFieldCollection getNamedFieldCollection(int namedFieldCollectionId) 
      throws Exception
   {
      Connection connection = null;
      NamedFieldCollection namedCollection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select " +
                  "name, project_id, created_by, created_on, " +
                  "description from named_field_collections where id=?", 
                  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, namedFieldCollectionId);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            namedCollection = new NamedFieldCollection();
            namedCollection.setId(namedFieldCollectionId);
            namedCollection.setName(rs.getString(1));
            namedCollection.setProjectId(rs.getInt(2));
            namedCollection.setCreatedBy(rs.getInt(3));
            if (rs.getTimestamp(4) != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTimeInMillis(rs.getTimestamp(4).getTime());
               namedCollection.setCreatedOn(clCreatedOn);
            }
            else
            {
               namedCollection.setCreatedOn(null);
            }
            namedCollection.setDescription(rs.getString(5));
            
            ICustomFieldManager cfm = new CustomFieldManager();
            namedCollection.setFields(cfm.getAllCustomFieldsForObject(namedCollection));
         }
         
         rs.close();
         pstmt.close();
      }
      catch (SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
            {
               connection.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return namedCollection;
   }
   
   public synchronized NamedFieldCollection getNamedFieldCollectionForObject(Object parentObject, String collectionName) 
      throws Exception
   {
      return null;
   }
   
   public synchronized NamedFieldCollection[] getAllNamedFieldCollectionsForObject(Object parentObject) 
      throws Exception
   {
      Connection connection = null;
      List namedFields = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select id from named_field_collections where parent_id=? and context=?");
         
         if (parentObject instanceof Task)
         {
            Task tParent = (Task)parentObject;
            pstmt.setInt(1, tParent.getId());
         }
         
         pstmt.setString(2, RoundTableContextHelper.getContext(parentObject));
         
         ResultSet rs = pstmt.executeQuery();
         while (rs.next())
         {
            namedFields.add(getNamedFieldCollection(rs.getInt(1)));
         }
         rs.close();
         pstmt.close();
      }
      catch (SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
            {   
               connection.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return (NamedFieldCollection[])namedFields.toArray(new NamedFieldCollection[namedFields.size()]);
   }
}
/*
 *
 * $Log: NamedFieldCollectionManager.java,v $
 * Revision 1.1  2005/10/17 03:25:10  brian
 * Initial Revision.
 *
 *
 */