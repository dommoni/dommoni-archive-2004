package com.dommoni.roundtable;

public class NamedTemplateFieldDefinition
{
   private String name;
   private int type;
   private int ordinal;
   private boolean hidden;
   private String description;
   
   public NamedTemplateFieldDefinition() 
   {
   }
   
   public NamedTemplateFieldDefinition(String name) 
   {
      this.name = name;
   }
   
   public NamedTemplateFieldDefinition(String name, int type) 
   {
      this.name = name;
      this.type = type;
   }
   
   public NamedTemplateFieldDefinition(String name, int type, int ordinal) 
   {
      this.name = name;
      this.type = type;
      this.ordinal = ordinal;
   }
   
   public String getName() {return this.name;}
   public void setName(String _name) {this.name = _name;}
   
   public int getType() {return this.type;}
   public void setType(int _type) {this.type = _type;}
   
   public int getOrdinal() {return this.ordinal;}
   public void setOrdinal(int _ordinal) {this.ordinal = _ordinal;}
   
   public boolean getHidden() {return this.hidden;}
   public void setHidden(boolean hidden) {this.hidden = hidden;}
   
   public String getDescription() {return this.description;}
   public void setDescription(String _description) {this.description = _description;}
}
