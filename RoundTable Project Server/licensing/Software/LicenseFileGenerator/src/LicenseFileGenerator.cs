using System;
using System.Windows.Forms;

class LicenseFileGenerator : Form
{
	LicenseFileGenerator()
	{
		// set the title.
		Text = "License File Generator";

		
	}

	public void writeFile()
	{
	}

	static void Main()
	{
		Application.Run(new LicenseFileGenerator());
	}
}
