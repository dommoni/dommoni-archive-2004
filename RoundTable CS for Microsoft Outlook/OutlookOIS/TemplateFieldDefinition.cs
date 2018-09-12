using System;

namespace OutlookOIS
{
	public class TemplateFieldDefinition
	{
		// Name of outlook field or property.
		private string tag;

		// name from RoundTable.
		private string name; 
		private string type;
		private int ordinal;
		private bool hidden;
		private string description;
		
		public TemplateFieldDefinition()
		{
		}

		public string Tag {
			get {return this.tag;}
			set {this.tag = value;}
		}

		public string Name {
			get {return this.name;}
			set {this.name = value;}
		}
		
		public string Type {
			get {return this.type;}
			set {this.type = value;}
		}
		
		public int Ordinal {
			get {return this.ordinal;}
			set {this.ordinal = value;}
		}
		
		public bool Hidden {
			get {return this.hidden;}
			set {this.hidden = value;}
		}
		
		public string Description {
			get {return this.description;}
			set {this.description = value;}
		}
	}
}
