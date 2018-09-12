using System;
using System.Windows.Forms;
using SL_Send;

namespace SL_Send_Exec
{
	/// <summary>
	/// Summary description for SLSendExec.
	/// </summary>
	public class SLSendExec
	{
		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new SLSend(AppMode.WindowsApplication));
		}
	}
}
