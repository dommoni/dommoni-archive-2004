using System;

namespace Dommoni.SalesTools.ExcelAddin
{
	/// <summary>
	/// Holds Contact information once its been converted from PinPointer.
	/// </summary>
	public class CallLogEntry
	{
		private string companyName;
		private string contactAndTitle;
		private string phoneNumber;
		private string industryEmployeeCount;

		public string CompanyName 
		{
			get {return this.companyName;}
			set {this.companyName = value;}
		}
		
		public string ContactAndTitle 
		{
			get {return this.contactAndTitle;}
			set {this.contactAndTitle = value;}
		}
		
		public string PhoneNumber 
		{
			get {return this.phoneNumber;}
			set {this.phoneNumber = value;}
		}

		public string IndustryEmployeeCount 
		{
			get {return this.industryEmployeeCount;}
			set {this.industryEmployeeCount = value;}
		}
	}
}
