package com.dommoni.roundtable.projectServer.services.namedFieldTemplateManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.NamedFieldTemplate;
import com.dommoni.roundtable.NamedTemplateFieldDefinition;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.utils.RoundTableContextHelper;

public class NamedFieldTemplateManager implements INamedFieldTemplateManager
{
   public synchronized int addNamedFieldTemplate(Project project, Object typeContext, NamedFieldTemplate template)
      throws Exception
   {
      Connection connection = null;
      int namedFieldTemplateId = -1;
      
      /*
       * TABLE DEFINITION:
       * 
       * create table `named_field_templates` (
       *                              `id` INT NOT NULL AUTO_INCREMENT, 
                                      `name` VARCHAR(255) NOT NULL, 
                                      `project_id` INT,
                                      `context` VARCHAR(255), 
                                      `created_by` INT NOT NULL, 
                                      `created_on` TIMESTAMP, 
                                      `description` TEXT,
                                      PRIMARY KEY(`id`), INDEX(`id`))
       * 
       * -----------------------------------------------------------------------
       * 
       * create table `named_template_field_definitions` (
       *                             `named_field_template_id` INT NOT NULL AUTO_INCREMENT, 
                                     `name` VARCHAR(255), 
                                     `type` INT NOT NULL,
                                     `ordinal`
                                     `description` VARCHAR(255))
       * 
       * */
      
      if (project == null || typeContext == null || template == null)
         throw new NullPointerException("Required Parameter was not provided.");
      
      if (template.getFieldDefinitions() == null || template.getFieldDefinitions().length < 1)
         throw new Exception("Error creating new Named-Template: You must have at least one field contained within the named-template.");
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into named_field_templates " +
               "(name, project_id, context, created_by, created_on, description) " +
               "values (?, ?, ?, ?, ?, ?)");
         pstmt.setString(1, template.getName());
         pstmt.setInt(2, project.getId());
         pstmt.setString(3, RoundTableContextHelper.getContext(typeContext));
         pstmt.setInt(4, template.getCreatedBy());
         pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
         pstmt.setString(6, template.getDescription());
         
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from named_field_templates",
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            namedFieldTemplateId = rs.getInt(1);
         }
         rs.close();
         
         pstmt = connection.prepareStatement("insert into named_template_field_definitions " +
               "(named_field_template_id, name, type, ordinal, hidden, description) values (?, ?, ?, ?, ?, ?)");
         NamedTemplateFieldDefinition[] fieldDefinitions = template.getFieldDefinitions();
         for (int i = 0; i < fieldDefinitions.length; i++)
         {
            pstmt.setInt(1, namedFieldTemplateId);
            pstmt.setString(2, fieldDefinitions[i].getName());
            pstmt.setInt(3, fieldDefinitions[i].getType());
            pstmt.setInt(4, fieldDefinitions[i].getOrdinal());
            pstmt.setBoolean(5, fieldDefinitions[i].getHidden());
            pstmt.setString(6, fieldDefinitions[i].getDescription());
            
            pstmt.addBatch();
         }
         pstmt.executeBatch();
         
         pstmt.close();
      }
      catch (SQLException se)
      {
         se.printStackTrace();
         
         throw new Exception(se.getMessage());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         
         throw new Exception(e.getMessage());
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
      
      return namedFieldTemplateId;
   }

   public synchronized void dropNamedFieldTemplate(int namedFieldTemplateId)
      throws Exception
   {
      Connection connection = null;
      
      // TODO: COMPLETE ME!!!
      
   }
   
   public synchronized void modifyNamedFieldTemplate(NamedFieldTemplate template)
      throws Exception
   {
//    TODO: COMPLETE ME!!!
   }  
   
   public synchronized NamedFieldTemplate getNamedFieldTemplate(int namedFieldTemplateId)
      throws Exception
   {
      Connection connection = null;
      NamedFieldTemplate fieldTemplate = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select " +
               "name, project_id, context, created_by, created_on, description from " +
               "named_field_templates where id=?",
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, namedFieldTemplateId);
         
         ResultSet rsObj = pstmt.executeQuery();
         if (rsObj.first())
         {
            fieldTemplate = new NamedFieldTemplate();
            fieldTemplate.setId(namedFieldTemplateId);
            fieldTemplate.setName(rsObj.getString(1));
            fieldTemplate.setProjectId(rsObj.getInt(2)); // TODO: PRoject ID shouldnt be included...
            fieldTemplate.setContext(rsObj.getString(3));
            fieldTemplate.setCreatedBy(rsObj.getInt(4));
            
            if (rsObj.getTimestamp(5) != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTimeInMillis(rsObj.getTimestamp(5).getTime());
               fieldTemplate.setCreatedOn(clCreatedOn);
            }
            else
            {
               fieldTemplate.setCreatedOn(null);
            }
            fieldTemplate.setDescription(rsObj.getString(6));
            
            pstmt = connection.prepareStatement("select name, type, ordinal, hidden, description from " +
                  "named_template_field_definitions where named_field_template_id=?",
                  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, fieldTemplate.getId());
            ResultSet rsField = pstmt.executeQuery();
            List lFieldDefinitions = new Vector();
            while (rsField.next())
            {
               NamedTemplateFieldDefinition field = new NamedTemplateFieldDefinition();
               
               field.setName(rsField.getString(1));
               field.setType(rsField.getInt(2));
               field.setOrdinal(rsField.getInt(3));
               field.setHidden(rsField.getBoolean(4));
               field.setDescription(rsField.getString(5));
               
               lFieldDefinitions.add(field);
            }
            rsField.close();
            
            fieldTemplate.setFieldDefinitions((NamedTemplateFieldDefinition[])lFieldDefinitions.toArray(new NamedTemplateFieldDefinition[lFieldDefinitions.size()]));
         }
         rsObj.close();
         
         pstmt.close();
      }
      catch (SQLException se)
      {
         se.printStackTrace();
         
         throw new Exception(se.getMessage());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         
         throw new Exception(e.getMessage());
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
      
      return fieldTemplate;
   }
   
   public synchronized NamedFieldTemplate[] getAllNamedFieldTemplatesForProjectAndType(Project project, Object typeContext)
      throws Exception
   {
      Connection connection = null;
      List templates = new Vector();
      
      if (project == null || typeContext == null)
         throw new Exception("Error retrieving Named-Templates: Missing required information");
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from " +
               "named_field_templates where project_id=? and context=?",
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, project.getId());
         pstmt.setString(2, RoundTableContextHelper.getContext(typeContext));
         ResultSet rs = pstmt.executeQuery();
         while (rs.next())
         {
            NamedFieldTemplate nft = getNamedFieldTemplate(rs.getInt(1));
            if (nft != null)
            {   
               templates.add(nft);
            }
         }
         
         rs.close();
         pstmt.close();
      }
      catch (SQLException se)
      {
         se.printStackTrace();
         
         throw new Exception(se.getMessage());
      }
      catch (Exception e)
      {
         e.printStackTrace();
         
         throw new Exception(e.getMessage());
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
      
      return (NamedFieldTemplate[])templates.toArray(new NamedFieldTemplate[templates.size()]);
   }
}
/*
 *
 * $Log: NamedFieldTemplateManager.java,v $
 * Revision 1.1  2005/10/17 07:46:07  brian
 * Initial Revision.
 *
 *
 */