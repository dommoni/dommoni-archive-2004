using System;

namespace SL_Send
{
	/// <summary>
	/// Summary description for Recipient.
	/// </summary>
	public class Recipient
	{
		private string emailAddress;
		private string name;
		private string company;
		private string intro;
		private string contactStatement;

		private bool isValid;

		public string EmailAddress
		{
			get {return this.emailAddress;}
			set {this.emailAddress = value;}
		}

		public string Name
		{
			get {return this.name;}
			set {this.name = value;}
		}

		public string Company
		{
			get {return this.company;}
			set {this.company = value;}
		}

		public string Intro
		{
			get {return this.intro;}
			set {this.intro = value;}
		}

		public string ContactStatement
		{
			get {return this.contactStatement;}
			set {this.contactStatement = value;}
		}

		public bool IsValid()
		{
			// TODO: Add recipient validation code here.
			return true;
		}
	}
}
