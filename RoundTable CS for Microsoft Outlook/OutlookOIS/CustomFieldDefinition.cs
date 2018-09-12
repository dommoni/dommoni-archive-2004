using System;

namespace OutlookOIS
{
	public class CustomFieldDefinition
	{
		private string tag; 
		private string name;
		private int type;
		private int ordinal;
		private bool hidden;

		public CustomFieldDefinition()
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
		
		public int Type {
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
	}
}
