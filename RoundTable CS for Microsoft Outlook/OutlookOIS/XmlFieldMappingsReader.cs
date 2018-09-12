using System;
using System.Collections;
using System.IO;
using System.Text;
using System.Xml;

using System.Windows.Forms;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for XmlCustomFieldReader.
	/// </summary>
	public class XmlFieldMappingsReader
	{
		FileStream xmlFileStream = null;

		public XmlFieldMappingsReader(FileStream xmlFileStream)
		{
			this.xmlFileStream = xmlFileStream;
		}

		public Hashtable ReadXml()
		{
			Hashtable hshCustomFields = new Hashtable();
			
			using (StreamReader reader = new StreamReader(xmlFileStream))
			{
				XmlTextReader xmlReader = new XmlTextReader(reader);

				while(xmlReader.Read())
				{	
					string elementName = xmlReader.Name;

					if (elementName.Equals("templateDefinition") && xmlReader.IsStartElement())
					{
						TemplateDefinition currentTemplate = new TemplateDefinition();
						if (xmlReader.HasAttributes)
						{
							currentTemplate.Tag = xmlReader.GetAttribute("tag");
							currentTemplate.DisplayName = xmlReader.GetAttribute("displayName");
							currentTemplate.Description = xmlReader.GetAttribute("description");
						}
						
						ArrayList arrFields = new ArrayList();
						string fieldXml = xmlReader.ReadInnerXml();
						XmlTextReader fieldsReader = new XmlTextReader(fieldXml, XmlNodeType.Element, (XmlParserContext)null);
						while (fieldsReader.Read())
						{
							if (fieldsReader.Name.Equals("templateFieldDefinition") && 
								fieldsReader.HasAttributes)
							{
								TemplateFieldDefinition tfd = new TemplateFieldDefinition();
								tfd.Tag = fieldsReader.GetAttribute("tag"); 
								tfd.Name = fieldsReader.GetAttribute("name");
								tfd.Type = fieldsReader.GetAttribute("type"); 

								// ordinal is optional.
								string ordinal = fieldsReader.GetAttribute("ordinal");
								if (ordinal != null)
								{
									try {
										tfd.Ordinal = Int32.Parse(ordinal);
									} catch {
									}
								}

								string hidden = fieldsReader.GetAttribute("hidden");
								if (hidden != null && hidden.Length > 0)
								{
									if (hidden.ToLower().Equals("yes"))
									{	
										tfd.Hidden = true;
									}
									else
									{	
										tfd.Hidden = false;
									}
								}
								
								tfd.Description = fieldsReader.GetAttribute("description");

								arrFields.Add(tfd);
							}
						}
						fieldsReader.Close();

						currentTemplate.FieldDefinitions = 
							(TemplateFieldDefinition[])arrFields.ToArray(Type.GetType("OutlookOIS.TemplateFieldDefinition"));
					
						hshCustomFields.Add(currentTemplate.Tag, currentTemplate);
					}
					else if (elementName.Equals("fieldDefinition") && xmlReader.IsStartElement())
					{
						CustomFieldDefinition fieldDefinition = new CustomFieldDefinition();
						if (xmlReader.HasAttributes)
						{
							fieldDefinition.Tag = xmlReader.GetAttribute("tag");
							fieldDefinition.Name = xmlReader.GetAttribute("name");
							
							string type = xmlReader.GetAttribute("type");
							if ( type.Equals("INTEGER") )
							{	
								fieldDefinition.Type = RoundTable.CustomField.T_INTEGER;
							}
							else
							{	
								fieldDefinition.Type = RoundTable.CustomField.T_STRING;
							}

							fieldDefinition.Ordinal = Int32.Parse(xmlReader.GetAttribute("ordinal"));
							
							string hidden = xmlReader.GetAttribute("hidden");
							if (hidden != null && hidden.Length > 0)
							{
								if (hidden.ToLower().Equals("yes"))
								{	
									fieldDefinition.Hidden = true;
								}
								else
								{	
									fieldDefinition.Hidden = false;
								}
							}
						}

						hshCustomFields.Add(fieldDefinition.Tag, fieldDefinition);
					}
					else
					{
						// Unknown..., error.
					}
				}
				
				return hshCustomFields;
			}
		}
	}
}
