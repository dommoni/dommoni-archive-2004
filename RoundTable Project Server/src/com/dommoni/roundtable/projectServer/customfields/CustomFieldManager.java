/*
 * Created on May 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.customfields;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import org.apache.axis.AxisFault;

import com.dommoni.roundtable.CustomField;
import com.dommoni.roundtable.CustomFieldAttribute;
import com.dommoni.roundtable.CustomFieldValueWrapper;
import com.dommoni.roundtable.CustomFieldValueWrapperInt;
import com.dommoni.roundtable.CustomFieldValueWrapperString;
import com.dommoni.roundtable.NamedFieldCollection;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.utils.RoundTableContextHelper;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CustomFieldManager implements ICustomFieldManager
{
   public synchronized int addCustomField(Object parentObj, CustomField field) 
      throws Exception 
   {
      Connection connection = null;
      int fieldId = -1;
      
      if (parentObj == null || field == null)
         throw new Exception("One or more parameters was empty");
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into custom_fields (" +
               "project_id, " +
               "context, " +
               "parent_id, " +
               "name, " +
               "created_by, " +
               "created_on, " +
               "type, " +
               "ordinal, hidden) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

         if (parentObj instanceof Task)
         {
            Task taskParent = (Task)parentObj;
            pstmt.setInt(1, taskParent.getProjectId());
            pstmt.setString(2, RoundTableContextHelper.getContext(taskParent));
            pstmt.setInt(3, taskParent.getId());
         }
         else if (parentObj instanceof NamedFieldCollection)
         {
            NamedFieldCollection nfcParent = (NamedFieldCollection)parentObj;
            
            pstmt.setInt(1, nfcParent.getProjectId());
            pstmt.setString(2, RoundTableContextHelper.getContext(nfcParent));
            pstmt.setInt(3, nfcParent.getId());
         }
         else
         {
            throw new Exception ("Unknown Parent for Custom Field: " + parentObj.getClass().getName());
         }
         
         pstmt.setString(4, field.getName());
         pstmt.setInt(5, field.getCreatedBy());
         pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
         pstmt.setInt(7, field.getType());
         pstmt.setInt(8, field.getOrdinal());
         pstmt.setBoolean(9, field.getHidden());
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from custom_fields", 
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rsId = pstmt.executeQuery();
         if (rsId.first())
         {
            fieldId = rsId.getInt(1);
            
            if (field.getValueWrapper() != null)
            {   
               if (field.getType() == CustomField.T_INTEGER)
               {
                  pstmt = connection.prepareStatement(
                        "insert into custom_fields_int_values (custom_field_id, value) values (?,?)");
                  pstmt.setInt(1, fieldId);
                  pstmt.setInt(2, ((CustomFieldValueWrapperInt)field.getValueWrapper()).getValue());
                  pstmt.executeUpdate();
               }
               else if (field.getType() == CustomField.T_STRING)
               {
                  pstmt = connection.prepareStatement(
                        "insert into custom_fields_string_values (custom_field_id, value) values (?,?)");
                  pstmt.setInt(1, fieldId);
                  pstmt.setString(2, ((CustomFieldValueWrapperString)field.getValueWrapper()).getValue());
                  pstmt.executeUpdate();
               }
               else
               {
                  // error...
               }
            }
            
            // Attributes
            if (field.getAttributes() != null && field.getAttributes().length > 0)
            {
               CustomFieldAttribute[] attributes = field.getAttributes();
               for (int i = 0; i < attributes.length; i++)
               {
                  addCustomFieldAttribute(connection, fieldId, attributes[i]);
               }
            }
         }
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
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return fieldId;
   }

   public synchronized void dropCustomField(int fieldId) 
      throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from custom_fields where id=?");
         pstmt.setInt(1, fieldId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from custom_fields_string_values where custom_field_id=?");
         pstmt.setInt(1, fieldId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from custom_fields_int_values where custom_field_id=?");
         pstmt.setInt(1, fieldId);
         pstmt.executeUpdate();
         
         pstmt.close();
         
         dropAllAttributesForField(connection, fieldId);
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
   }

   public synchronized void modifyCustomField(Object parentObject, CustomField field) 
      throws Exception
   {
      System.out.println("Entering CustomFieldManager.modifyCustomField()...");
      Connection connection = null;
      
      if (parentObject == null || field == null)
         return; // TODO: NEED TO THROW AN EXCEPTION HERE!
      
      try
      {
         connection = ConnectionManager.getConnection();
         
         
         PreparedStatement pstmt = connection.prepareStatement("update custom_fields set " +
               //"project_id=?, " +
               //"parent_id=?, " +
               //"context=?, " +               
               "name=?, " +
               "type=?, " +
               "ordinal=?," +
               "hidden=? where id=?");
         
    /*     if (parentObject instanceof Task)
         {
            Task tParent = (Task)parentObject;
            pstmt.setInt(1, tParent.getProjectId());
            pstmt.setInt(2, tParent.getId());
         }
         else
         {
            // need to throw an exc... 
         }*/
         
         //pstmt.setString(3, RoundTableContextHelper.getContext(parentObject));
         pstmt.setString(1, field.getName());
         pstmt.setInt(2, field.getType());
         pstmt.setInt(3, field.getOrdinal());
         pstmt.setBoolean(4, field.getHidden());
         
         pstmt.setInt(5, field.getId());
         
         pstmt.executeUpdate();
         
         //
         // Ensure a 'Clean Slate'... Manually Delete all possible data...
         //
         
         pstmt = connection.prepareStatement("delete from custom_fields_int_values where custom_field_id=?");
         pstmt.setInt(1, field.getId());
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from custom_fields_string_values where custom_field_id=?");
         pstmt.setInt(1, field.getId());
         pstmt.executeUpdate();
         
         //
         // Set the Data Fields...
         //
         
         // TODO: We could potentially be throwing ClassCast Exceptions here...
         if (field.getType() == CustomField.T_INTEGER)
         {
            System.out.println("Setting INT_VALUE: " + ((CustomFieldValueWrapperInt)field.getValueWrapper()).getValue());
            pstmt = connection.prepareStatement(
                  "insert into custom_fields_int_values (custom_field_id, value) values (?,?)");
            pstmt.setInt(1, field.getId());
            pstmt.setInt(2, ((CustomFieldValueWrapperInt)field.getValueWrapper()).getValue());
            pstmt.executeUpdate();
         }
         else if (field.getType() == CustomField.T_STRING)
         {
            System.out.println("Setting STRING_VALUE: " + ((CustomFieldValueWrapperString)field.getValueWrapper()).getValue());
            pstmt = connection.prepareStatement(
                  "insert into custom_fields_string_values (custom_field_id, value) values (?,?)");
            pstmt.setInt(1, field.getId());
            pstmt.setString(2, ((CustomFieldValueWrapperString)field.getValueWrapper()).getValue());
            pstmt.executeUpdate();
         }
         else
         {
            // error...
         }
         
         //
         // Handle Attribute Modifications...
         //
         dropAllAttributesForField(connection, field.getId());
         CustomFieldAttribute[] attributes = field.getAttributes();
         if (attributes != null && attributes.length > 0)
         {
            for (int i = 0; i < field.getAttributes().length; i++)
            {   
               addCustomFieldAttribute(connection, field.getId(), field.getAttributes()[i]);
            }
         }
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
   }

   public synchronized CustomField getCustomField(int customFieldId) 
      throws Exception
   {
      Connection connection = null;
      CustomField field = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement(
               "select project_id, " +
               "context, " +
               "parent_id, " +
               "name, " +
               "created_by, " +
               "created_on, " +
               "type, " +
               "ordinal," +
               "hidden " +
               "from custom_fields where id=?",
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, customFieldId);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            field = new CustomField();
            field.setId(customFieldId);
            field.setName(rs.getString("name"));
            field.setCreatedBy(rs.getInt("created_by"));
            
            if (rs.getTimestamp("created_on") != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTimeInMillis(rs.getTimestamp("created_on").getTime());
               field.setCreatedOn(clCreatedOn);
            }
            field.setType(rs.getInt("type"));
            field.setOrdinal(rs.getInt("ordinal"));
            field.setHidden(rs.getBoolean("hidden"));
            
            if (field.getType() == CustomField.T_INTEGER)
            {
               CustomFieldValueWrapperInt valueWrapper = null;
               PreparedStatement psTypedValue = connection.prepareStatement("select value from custom_fields_int_values where custom_field_id=?", 
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
               psTypedValue.setInt(1, field.getId());
               
               ResultSet rsTypedValue = psTypedValue.executeQuery();
               if (rsTypedValue.first())
               {
                  int value = rsTypedValue.getInt(1);
                  valueWrapper = new CustomFieldValueWrapperInt();
                  valueWrapper.setValue(value);
               }
               field.setValueWrapper(valueWrapper);
               
               rsTypedValue.close();
               psTypedValue.close();
            }
            else if (field.getType() == CustomField.T_STRING)
            {
               CustomFieldValueWrapperString valueWrapper = null;
               PreparedStatement psTypedValue = connection.prepareStatement("select value from custom_fields_string_values where custom_field_id=?", 
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
               psTypedValue.setInt(1, field.getId());
               
               ResultSet rsTypedValue = psTypedValue.executeQuery();
               if (rsTypedValue.first())
               {
                  String value = rsTypedValue.getString(1);
                  valueWrapper = new CustomFieldValueWrapperString();
                  valueWrapper.setValue(value);
               }
               field.setValueWrapper(valueWrapper);
               
               rsTypedValue.close();
               psTypedValue.close();
            }
            
            field.setAttributes(getAllAttributesForField(connection, field.getId()));
         }
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
      
      return field;
   }

   public synchronized CustomField getCustomFieldForObject(Object parentObject, String fieldName)
      throws Exception
   {
      Connection connection = null;
      CustomField field = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from custom_fields where " +
               "parent_id=? and context=? and name=?", 
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         if (parentObject instanceof Task)
         {
            Task taskParent = (Task)parentObject;
            pstmt.setInt(1, taskParent.getId());
         }
         
         pstmt.setString(2, RoundTableContextHelper.getContext(parentObject));
         pstmt.setString(3, fieldName);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            field = getCustomField(rs.getInt(1));
         }
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
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return field;
   }
   
   public synchronized CustomField[] getAllCustomFieldsForObject(Object parentObject) 
      throws Exception
   {
      Connection connection = null;
      List customFields = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement(
               "select id from custom_fields where parent_id=? and context=?", 
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         if (parentObject instanceof Task)
         {
            Task taskParent = (Task)parentObject;
            pstmt.setInt(1, taskParent.getId());
         }
         else if (parentObject instanceof NamedFieldCollection)
         {
            NamedFieldCollection nfcParent = (NamedFieldCollection)parentObject;
            pstmt.setInt(1, nfcParent.getId());
         }
         else
         {
            // Unknown Type... need to throw an exception here...
         }
         
         pstmt.setString(2, RoundTableContextHelper.getContext(parentObject));
         
         ResultSet rs = pstmt.executeQuery();
         while (rs.next())
         {
            customFields.add(getCustomField(rs.getInt(1)));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
         
         throw new Exception(se.getMessage());
      }
      catch(Exception e)
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
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
      }
      
      return (CustomField[])customFields.toArray(new CustomField[customFields.size()]);
   }
   
   
   //--------------------------------------------------------------------------
   // CustomFieldAttribute Helper Methods... 
   
   private void addCustomFieldAttribute(Connection connection, int fieldId, CustomFieldAttribute attribute)
      throws Exception
   {
      // we have to reuse our connection obj., a long loop could kill our pool.
      if (connection != null && attribute != null)
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("insert into custom_field_attributes " +
                  "(field_id, name, value) values (?, ?, ?)");
         pstmt.setInt(1, fieldId);
         pstmt.setString(2, attribute.getName());
         pstmt.setString(3, attribute.getValue());
         pstmt.executeUpdate();
         
         pstmt.close();
      }
   }
   
   private void dropAllAttributesForField(Connection connection, int fieldId) 
      throws Exception
   {
      if (connection != null)
      {
         PreparedStatement pstmt = 
            connection.prepareStatement("delete from custom_field_attributes where field_id=?");
         pstmt.setInt(1, fieldId);
         pstmt.executeUpdate();
         
         pstmt.close();
      }
   }
   
   // No modify... just drop and add... should work... ?
   //private void modifyCustomFieldAttribute() {}
   
   private CustomFieldAttribute[] getAllAttributesForField(Connection connection, int fieldId) 
      throws Exception 
   {
      if (connection != null)
      {
         List lAttributes = new Vector();
         PreparedStatement pstmt = 
            connection.prepareStatement("select name,value from " +
                  "custom_field_attributes where field_id=?",
                  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, fieldId);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next())
         {
            CustomFieldAttribute attribute = new CustomFieldAttribute();
            attribute.setName(rs.getString(1));
            attribute.setValue(rs.getString(2));
            
            lAttributes.add(attribute);
         }
         rs.close();
         pstmt.close();
         
         return (CustomFieldAttribute[])lAttributes.toArray(new CustomFieldAttribute[lAttributes.size()]);
      }
      return null;
   }
}
/*
 *
 * $Log: CustomFieldManager.java,v $
 * Revision 1.1  2005/10/17 04:20:23  brian
 * Initial Revision.
 *
 *
 */