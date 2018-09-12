
using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Web.Services.Protocols;

/// <summary>
/// Summary description for SessionHandlerExtension.
/// </summary>
public class SessionHandlerExtension : SoapExtension
{
	Stream newStream = null;
	Stream oldStream = null;

	public SessionHandlerExtension()
	{
	}

	public override void Initialize(object initializer) 
	{
	}

	public override object GetInitializer(LogicalMethodInfo methodInfo, SoapExtensionAttribute attribute) 
	{
		return null;
	}
	
	public override object GetInitializer(Type WebServiceType) 
	{
		return null;
	}

	public override Stream ChainStream( Stream stream )
	{
		// Save the passed in Stream in a member variable.
		oldStream = stream;

		// Create a new instance of a Stream and save that in a member
		// variable.
		newStream = new MemoryStream();
		return newStream;
	}

	private void Copy(Stream fromStream , Stream toStream)
	{
		try
		{
			StreamReader reader = new StreamReader(fromStream);
			StreamWriter writer = new StreamWriter(toStream);
			writer.WriteLine(reader.ReadToEnd());
			writer.Flush();
		}
		catch(Exception e)
		{
			Console.WriteLine(e.Message);
		}
	}


	public override void ProcessMessage(SoapMessage message) 
	{
		switch (message.Stage) 
		{
			case SoapMessageStage.BeforeSerialize:
				break;

			case SoapMessageStage.AfterSerialize:
				// what we want to do here is to re-write the 
				// session id. to do this, we first need to extract the 
				// variable, then reinsert it with the correct XML.
				newStream.Position = 0;
				StreamReader rdr = new StreamReader(newStream);
				string content = rdr.ReadToEnd();
				
				Regex reg = new Regex("<types:SessionHeader\\s*id\\s*=\\s*(?:\"(?<1>[^\"]*)\")>");
				content = reg.Replace(content, "");

				content = content.Replace("</types:SessionHeader>", "");
				newStream = new MemoryStream();
				newStream.Position = 0;
				StreamWriter swr = new StreamWriter(newStream);
				swr.Write(content);
				swr.Flush();

				newStream.Position = 0;
				Copy(newStream, oldStream);
				break;

			case SoapMessageStage.BeforeDeserialize:
				newStream.Position = 0;
				Copy(oldStream, newStream);
				newStream.Position = 0;
				break;

			case SoapMessageStage.AfterDeserialize:
				break;

			default:
				throw new Exception("invalid stage");
		}
	}
}
/*
 * 
 * $Log: SessionHandlerExtension.cs,v $
 * Revision 1.1  2005/03/26 17:51:42  brian
 * Initial Revision
 *
 * 
 */
