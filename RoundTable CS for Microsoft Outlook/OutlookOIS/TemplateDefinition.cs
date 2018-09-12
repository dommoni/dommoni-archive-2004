using System;

namespace OutlookOIS
{
	public class TemplateDefinition
	{
		private string tag; 
		private string displayName; 
		private string description; 
		private TemplateFieldDefinition[] fieldDefinitions;

		public TemplateDefinition()
		{
		}

		public string Tag {
			get {return this.tag;}
			set {this.tag = value;}
		}

		public string DisplayName {
			get {return this.displayName;}
			set {this.displayName = value;}
		}
		
		public string Description {
			get {return this.description;}
			set {this.description = value;}
		} 
		
		public TemplateFieldDefinition[] FieldDefinitions {
			get {return this.fieldDefinitions;}
			set {this.fieldDefinitions = value;}
		}
	}
}
