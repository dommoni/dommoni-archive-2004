using System;
using System.Collections;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for FieldMappingRegistry.
	/// </summary>
	public class FieldMappingRegistry
	{
		private Hashtable hshFieldMappings;

		public FieldMappingRegistry()
		{
			hshFieldMappings = new Hashtable();
		}

		public FieldMappingRegistry(Hashtable fieldMappings)
		{
			if (fieldMappings != null)
				this.hshFieldMappings = fieldMappings;
		}


		public CustomFieldDefinition FindFieldDefFromName(string name) 
		{
			if (name != null)
			{
				IEnumerator en = hshFieldMappings.GetEnumerator();
				while (en.MoveNext())
				{
					object obj = en.Current;
					if (obj is CustomFieldDefinition)
					{
						CustomFieldDefinition cfd = (CustomFieldDefinition)obj;
						if (cfd.Name.Equals(name))
							return cfd;
					}
				}
			}
			return null;
		}
		
		public CustomFieldDefinition GetFieldDefFromTag(string tag) 
		{
			if (tag != null)
			{
				//hshFieldMappings.Values.GetEnumerator
				IEnumerator en = hshFieldMappings.Values.GetEnumerator();
				while (en.MoveNext())
				{
					object obj = en.Current;
					if (obj is CustomFieldDefinition)
					{
						CustomFieldDefinition cfd = (CustomFieldDefinition)obj;
						if (cfd.Tag.Equals(tag))
							return cfd;
					}
				}
			}
			return null;
		}
		
		public TemplateFieldDefinition GetTemplateFieldDefFromTag(string tag) 
		{
			if (tag != null)
			{
				//hshFieldMappings.Values.GetEnumerator
				IEnumerator en = hshFieldMappings.Values.GetEnumerator();
				while (en.MoveNext())
				{
					object obj = en.Current;
					if (obj is TemplateDefinition)
					{
						TemplateDefinition templateDefinition = 
							(TemplateDefinition)obj;
						TemplateFieldDefinition[] fieldDefinitions = 
							templateDefinition.FieldDefinitions;
						
						foreach (TemplateFieldDefinition def in fieldDefinitions)
						{
							if (def.Tag.Equals(tag))
							{
								return def;
							}
						}
					}
				}
			}
			return null;
		}

		/*
		 * Takes RoundTable defined name and Looks up the Object.
		 * */
		public TemplateDefinition FindTemplateDefFromName(string name) 
		{
			if (name != null)
			{
				try
				{
					IEnumerator en = hshFieldMappings.Values.GetEnumerator();
					while (en.MoveNext())
					{
						object obj = en.Current;
						if (obj is TemplateDefinition)
						{
							TemplateDefinition td = (TemplateDefinition)obj;
							if (td.DisplayName.Equals(name))
								return td;
						}
					}
				}
				catch (System.Exception ex)
				{
				}
			}
			return null;
		}

		/*
		 * Takes XML defined Tag and Looks up the Object.
		 * */
		public TemplateDefinition GetTemplateDefFromTag(string tag) 
		{
			if (tag != null)
			{
				IEnumerator en = hshFieldMappings.Values.GetEnumerator();
				while (en.MoveNext())
				{
					object obj = en.Current;
					if (obj is TemplateDefinition)
					{
						TemplateDefinition td = (TemplateDefinition)obj;
						if (td.Tag.Equals(tag))
							return td;
					}
				}
			}
			return null;
		}
	}
}
