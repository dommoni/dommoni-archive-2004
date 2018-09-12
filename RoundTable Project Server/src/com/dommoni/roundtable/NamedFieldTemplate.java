package com.dommoni.roundtable;

import java.util.Calendar;

public class NamedFieldTemplate
{
   private int id;
   private String name;
   private int projectId;
   private String context;
   private int createdBy;
   private Calendar createdOn;
   private String description;
   
   private NamedTemplateFieldDefinition[] fieldDefinitions;
   
   public NamedFieldTemplate()
   {
   }
   
   public NamedFieldTemplate(String name)
   {
      this.name = name;
   }
   
   public NamedFieldTemplate(String name, NamedTemplateFieldDefinition[] fields)
   {
      this.name = name;
      this.fieldDefinitions = fields;
   }
   
   public int getId() {return this.id;}
   public void setId(int _id) {this.id = _id;}
   
   public String getName() {return this.name;}
   public void setName(String _name) {this.name = _name;}
   
   public int getProjectId() {return this.projectId;}
   public void setProjectId(int _projectId) {this.projectId = _projectId;}
   
   public String getContext() {return this.context;}
   public void setContext(String _context) {this.context = _context;}
   
   public int getCreatedBy() {return this.createdBy;}
   public void setCreatedBy(int _createdBy) {this.createdBy = _createdBy;}
   
   public Calendar getCreatedOn() {return this.createdOn;}
   public void setCreatedOn(Calendar _createdOn) {this.createdOn = _createdOn;}
   
   public String getDescription() {return this.description;}
   public void setDescription(String _description) {this.description = _description;}
   
   public NamedTemplateFieldDefinition[] getFieldDefinitions() {return this.fieldDefinitions;}
   public void setFieldDefinitions(NamedTemplateFieldDefinition[] _fieldDefinitions) {this.fieldDefinitions = _fieldDefinitions;}
}
