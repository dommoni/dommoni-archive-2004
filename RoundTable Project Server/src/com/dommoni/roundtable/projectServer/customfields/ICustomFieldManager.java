package com.dommoni.roundtable.projectServer.customfields;

import com.dommoni.roundtable.CustomField;

public interface ICustomFieldManager
{
   public int addCustomField(Object parentObj, CustomField field) 
      throws Exception;
   
   public void dropCustomField(int fieldId) 
      throws Exception;
   
   public void modifyCustomField(Object parentObject, CustomField field) 
      throws Exception;
   
   public CustomField getCustomField(int customFieldId) 
      throws Exception;
   
   public CustomField getCustomFieldForObject(Object parentObject, String fieldName)
      throws Exception;
   
   public CustomField[] getAllCustomFieldsForObject(Object parentObject) 
      throws Exception;
}
/*
 * 
 * $Log: ICustomFieldManager.java,v $
 * Revision 1.1  2005/10/17 04:20:24  brian
 * Initial Revision.
 *
 * 
 */
