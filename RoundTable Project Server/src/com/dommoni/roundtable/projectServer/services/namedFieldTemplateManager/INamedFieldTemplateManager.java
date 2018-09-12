package com.dommoni.roundtable.projectServer.services.namedFieldTemplateManager;

import com.dommoni.roundtable.NamedFieldTemplate;
import com.dommoni.roundtable.Project;

public interface INamedFieldTemplateManager
{
   public int addNamedFieldTemplate(Project project, Object typeContext, NamedFieldTemplate template)
      throws Exception; 
   
   public void dropNamedFieldTemplate(int namedFieldTemplateId)
      throws Exception;
   
   public void modifyNamedFieldTemplate(NamedFieldTemplate template)
      throws Exception;
   
   public NamedFieldTemplate getNamedFieldTemplate(int namedFieldTemplateId)
      throws Exception;
   
   public NamedFieldTemplate[] getAllNamedFieldTemplatesForProjectAndType(Project project, Object typeContext)
      throws Exception;
}
/*
 *
 * $Log: INamedFieldTemplateManager.java,v $
 * Revision 1.1  2005/10/17 07:45:59  brian
 * Initial Revision.
 *
 *
 */