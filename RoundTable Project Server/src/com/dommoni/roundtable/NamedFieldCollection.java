package com.dommoni.roundtable;

import java.util.Calendar;

public class NamedFieldCollection
{
   private int id;
   private String name;
   private int projectId;
/* private int parentId;
   private String context;*/
   private int createdBy;
   private Calendar createdOn;
   private String description;
   
   private CustomField[] fields;
   
   public NamedFieldCollection()
   {
   }
   
   public NamedFieldCollection(String name)
   {
      this.name = name;
   }
   
   public NamedFieldCollection(String name, CustomField[] fields)
   {
      this.name = name;
      this.fields = fields;
   }
   
   public int getId() {return this.id;}
   public void setId(int _id) {this.id = _id;}
   
   public String getName() {return this.name;}
   public void setName(String _name) {this.name = _name;}
   
   public int getProjectId() {return this.projectId;}
   public void setProjectId(int _projectId) {this.projectId = _projectId;}
   
 /*  public int getParentId() {return this.parentId;}
   public void setParentId(int _parentId) {this.parentId = _parentId;}
   
   public String getContext() {return this.context;}
   public void setContext(String _context) {this.context = _context;}
*/   
   public int getCreatedBy() {return this.createdBy;}
   public void setCreatedBy(int _createdBy) {this.createdBy = _createdBy;}
   
   public Calendar getCreatedOn() {return this.createdOn;}
   public void setCreatedOn(Calendar _createdOn) {this.createdOn = _createdOn;}
   
   public String getDescription() {return this.description;}
   public void setDescription(String _description) {this.description = _description;}
   
   public CustomField[] getFields() {return this.fields;}
   public void setFields(CustomField[] _fields) {this.fields = _fields;}
}
