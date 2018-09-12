package com.dommoni.roundtable;

public class CustomFieldValueWrapperInt extends CustomFieldValueWrapper
{
   private int value;
   
   public CustomFieldValueWrapperInt()
   {
   }
   
   public CustomFieldValueWrapperInt(int value)
   {
      this.value = value;
   }
   
   public int getValue() 
   { 
      return this.value; 
   }
   
   public void setValue(int value) 
   {
      this.value = value;
   }
}
