using System;

namespace RoundTable.ProjectServer.Services.NamedFieldTemplateManager
{
	public interface INamedFieldTemplateManager
	{
		int addNamedFieldTemplate(Project project, Object typeContext, NamedFieldTemplate template);
   
		void dropNamedFieldTemplate(int namedFieldTemplateId);
   
		void modifyNamedFieldTemplate(NamedFieldTemplate template);
   
		NamedFieldTemplate getNamedFieldTemplate(int namedFieldTemplateId);
   
		NamedFieldTemplate[] getAllNamedFieldTemplatesForProjectAndType(Project project, Object typeContext);
	}
}
