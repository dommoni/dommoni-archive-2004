/*
 * Created on May 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CustomField
{
   public static final int T_STRING = 0;
   public static final int T_INTEGER = 1;
   
   private int id;
   private String name;
   private int createdBy;
   private Calendar createdOn;
   private int type;
   private CustomFieldValueWrapper valueWrapper;
   private int ordinal;
      
   /**
    * Determines weather or not client applications should display
    * this field. It is up to the client application to respect the
    * value of this field.
    */
   private boolean hidden;
   
   /**
    * Allows client systems to embed their unique IDs for this
    * field to later uniquely identify/re-sync. This allows multiple
    * client systems with differant IDs for a single peice of data
    * to map the information stored in RoundTable to their own systems.
    * 
    * (Clients refering to Client/Server relationship)
    */
   //private NameValue[] clientIds;
   private CustomFieldAttribute[] attributes;
   
   public CustomField()
   {
   }
   
   public CustomField(String name) 
   {
      this.name = name;
   }
   
   public CustomField(String name, int type) 
   {
      this.name = name;
      this.type = type;
   }
   
   public CustomField(String name, int type, int ordinal) 
   {
      this.name = name;
      this.type = type;
      this.ordinal = ordinal;
   }

   public CustomField(String name, int type, CustomFieldValueWrapper valueWrapper) 
   {
      this.name = name;
      this.type = type;
      this.valueWrapper = valueWrapper;
   }
   
   public CustomField(String name, int type, int ordinal, 
         CustomFieldValueWrapper valueWrapper) 
   {
      this.name = name;
      this.type = type;
      this.ordinal = ordinal;
      this.valueWrapper = valueWrapper;
   }
   
   public int getId() 
   {
      return this.id;
   }
   
   public void setId(int id) 
   {
      this.id = id;
   }
   
   public String getName() 
   {
      return this.name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public int getCreatedBy() 
   {
      return this.createdBy;
   }
   
   public void setCreatedBy(int createdBy) 
   {
      this.createdBy = createdBy;
   }
   
   public Calendar getCreatedOn() 
   {
      return this.createdOn;
   }
   
   public void setCreatedOn(Calendar createdOn) 
   {
      this.createdOn = createdOn;
   }
   
   public int getType() 
   {
      return this.type;
   }
   
   public void setType(int type) 
   {
      this.type = type;
   }
   
   public CustomFieldValueWrapper getValueWrapper() 
   {
      return this.valueWrapper;
   }
   
   public void setValueWrapper(CustomFieldValueWrapper valueWrapper) 
   {
      this.valueWrapper = valueWrapper;
   }
   
   public int getOrdinal() 
   {
      return this.ordinal;
   }
   
   public void setOrdinal(int ordinal) 
   {
      this.ordinal = ordinal;
   }
   
   public boolean getHidden()
   {
      return this.hidden;
   }
   
   public void setHidden(boolean hidden)
   {
      this.hidden = hidden;
   }
   
   public CustomFieldAttribute[] getAttributes()
   {
      return attributes;
   }
   
   public void setAttributes(CustomFieldAttribute[] attributes)
   {
      this.attributes = attributes;
   }
}
