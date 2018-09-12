using System;
using System.Collections;

using RoundTable;

namespace OutlookOIS
{
	/// <summary>
	/// Helper class to associate existing fields and 
	/// collections to un-referenced user-properties 
	/// from Outlook.
	/// </summary>
	public class FieldMappingHelper
	{
		private RoundTable.Task mappedTask;
		private Hashtable hshFields;
		private Hashtable hshCollections;

		public FieldMappingHelper(RoundTable.Task _mappedTask)
		{
			this.mappedTask = _mappedTask;
			
			BuildFieldsMap();
			BuildCollectionsMap();
		}

		private void BuildFieldsMap() 
		{
			if (mappedTask != null)
			{
				hshFields = new Hashtable(mappedTask.customFields.Length);

				CustomField[] fields = mappedTask.customFields;
				foreach (CustomField field in fields)
				{
					string keyName = new string(field.name.ToCharArray(0, 
						field.name.Length));
					hshFields.Add(keyName, field);
				}
			}
		}
		
		private void BuildCollectionsMap() 
		{
			if (mappedTask != null)
			{
				hshCollections = new Hashtable(mappedTask.namedFieldCollections.Length);
				NamedFieldCollection[] collections = mappedTask.namedFieldCollections;
				foreach (NamedFieldCollection collection in collections)
				{
					string keyName = new string(collection.name.ToCharArray(0, 
						collection.name.Length));
					hshCollections.Add(keyName, collection);
				}
			}
		}
		
		public CustomField FindFieldFromName(string fieldName) 
		{
			return (CustomField)hshFields[fieldName];
		}

		public NamedFieldCollection FindCollectionFromName(string collectionName) 
		{
			return (NamedFieldCollection)hshCollections[collectionName];
		}
		
		public CustomField FindCollectionFieldFromName(string collectionName,
			string fieldName) 
		{
			NamedFieldCollection collection = 
				(NamedFieldCollection)hshCollections[collectionName];
			if (collection != null)
			{
				CustomField[] fields = collection.fields;
				foreach (CustomField field in fields)
				{
					if (field.name.Equals(fieldName))
					{
						return field;
					}
				}
			}
			return null;
		}
	}
}
