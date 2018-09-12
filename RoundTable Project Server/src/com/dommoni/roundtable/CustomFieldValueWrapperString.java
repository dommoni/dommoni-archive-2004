/*
 * Created on May 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CustomFieldValueWrapperString extends CustomFieldValueWrapper
{
   public String value;
   
   public CustomFieldValueWrapperString() 
   {
   }
   
   public CustomFieldValueWrapperString(String value)
   {
      this.value = value;
   }
   
   public String getValue()
   {
      return this.value;
   }
   
   public void setValue(String value)
   {
      this.value = value;
   }
}
