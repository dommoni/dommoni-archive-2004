/*
 * Created on Apr 22, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MultipartRequestHandler
{
	private static final int DEFAULT_MAX_POST_SIZE = 1024 * 1024 * 20;

	private ServletRequest req;
	//private int maxSize;
	private byte[] receivedFile;
	private String filename;
   private Hashtable parameters;

	/*public MultipartRequestHandler(ServletRequest request) throws IOException
	{
		this(request, DEFAULT_MAX_POST_SIZE);
	}*/

	public MultipartRequestHandler(ServletRequest request)//, int maxPostSize)
		throws IOException
	{
		if (request == null)
			throw new IllegalArgumentException("request cannot be null");
		//if (maxPostSize <= 0)
			//throw new IllegalArgumentException("maxPostSize must be positive");

		req = request;
		//dir = new File(saveDirectory);
		//maxSize = maxPostSize;
      
      parameters = new Hashtable();

		// Now parse the request saving data to "parameters" and "files"
		readRequest();
	}

   public String getParameter(String parameterName)
   {
      return (String)parameters.get(parameterName);
   }
   
   public ServletRequest getRequest()
   {
      return this.req;
   }
   
	public byte[] getReceivedFile()
	{
		return this.receivedFile;
	}

	public String getFilename()
	{
		return this.filename;
	}

	protected void readRequest() throws IOException
	{
		// Check the content type to make sure it's a "multipart/form-data"
		String type = req.getContentType();
		if (type == null || !type.toLowerCase().startsWith("multipart/form-data"))
		{
			throw new IOException("Posted Content type isnt multipart/formdata");
		}

		// Check the content length to prevent denial of service attacks
		int length = req.getContentLength();
		String boundary = extractBoundary(type);

		// Construct the special input-stream we'll read from.
		MultipartInputStreamHandler in =
			new MultipartInputStreamHandler(req.getInputStream(), boundary, length);

		// read the first line, should be the first boundary
		String line = in.readLine();
		if (line == null)
		{
			throw new IOException("Corrupt form data: premature ending");
		}

		// Verify that the line is the boundary
		if (!line.startsWith(boundary))
		{
			throw new IOException("Corrupt form data: no leading boundary");
		}

		// Now that we're just beyond the first boundary, loop over each part
		boolean done = false;
		while (!done)
		{
			done = readNextPart(in, boundary);
		}
	}

	protected boolean readNextPart(MultipartInputStreamHandler in, String boundary)
		throws IOException
	{
		// read the first line, should look like this:
		// content-disposition: form-data; name="field"; filename="file1.txt"
		String line = in.readLine();
		if (line == null)
		{
			// No parts left, we're done
			return true;
		}

		// parse the content-disposition line
		String dispInfo[] = extractDispositionInfo(line);
		String disposition = dispInfo[0];
		String name = dispInfo[1];
		String filename = dispInfo[2];

		// Now onto the next line. This will either be empty
		// or contain a Content-Type and then an empty line.
		line = in.readLine();
		if (line == null)
		{
			// No parts left, we're done
			return true;
		}

		// Get the content type, or null if none specified
		String contentType = extractContentType(line);
		if (contentType != null)
		{
			// Eat the empty line
			line = in.readLine();
			if (line == null || line.length() > 0)
			{
				throw new IOException("Malformed line after content type: " + line);
			}
		}
		else
		{
			// Assume a default content type
			contentType = "application/octet-stream";
		}

		// Now, finally, we read the content (end after reading the boundary)
		if (filename == null)
		{
			// This is a parameter
			String value = readParameter(in, boundary);
			parameters.put(name, value);
		}
		else
      {
			// This is a file
         this.filename = filename;
			readAndSaveFile(in, boundary, filename);
		}
		return false; // Theres more to read
	}

	protected String readParameter(MultipartInputStreamHandler in, String boundary)
		throws IOException
	{
		StringBuffer sbuf = new StringBuffer();
		String line;

		while ((line = in.readLine()) != null)
		{
			if (line.startsWith(boundary))
				break;
			sbuf.append(line + "\r\n"); // add the \r\n in case there are many lines
		}

		if (sbuf.length() == 0)
		{
			return null; // nothing read.
		}

		sbuf.setLength(sbuf.length() - 2);
		return sbuf.toString();
	}

	protected void readAndSaveFile(MultipartInputStreamHandler in, String boundary, String filename)
		throws IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
      byte bbuf[] = new byte[8 * 1024];
		int result;
		String line;

		boolean rnflag = false;
		while ((result = in.readLine(bbuf, 0, bbuf.length)) != -1)
		{
			// Check for boundary
			if (result > 2 && bbuf[0] == '-' && bbuf[1] == '-')
			{
				line = new String(bbuf, 0, result, "ISO-8859-1");
				if (line.startsWith(boundary))
					break;
			}

			// Are we supposed to write \r\n for the last iteration?
			if (rnflag)
			{
				baos.write('\r');
				baos.write('\n');
				rnflag = false;
			}
			// Write the buffer, postpone any ending \r\n
			if (result >= 2 && bbuf[result - 2] == '\r' && bbuf[result - 1] == '\n')
			{
				baos.write(bbuf, 0, result - 2); // skip the last 2 chars
				rnflag = true;
			}
			else
			{
				baos.write(bbuf, 0, result);
			}
		}
		receivedFile = baos.toByteArray();
	}

	private String extractBoundary(String line)
	{
		int index = line.indexOf("boundary=");
		if (index == -1)
		{
			return null;
		}
		String boundary = line.substring(index + 9); // 9 for "boundary="

		// the real boundary is always proceeded by an extra "--"
		boundary = "--" + boundary;

		return boundary;
	}

	private String[] extractDispositionInfo(String line) throws IOException
	{
		// Return the line's data as an array: disposition, name, filename
		String retval[] = new String[3];

		// Convert the line to a lowercase string without the ending \r\n
		// Keep the original line for error messages and for variable names.
		String origline = line;
		line = origline.toLowerCase();

		// Get the content disposition, should be "form-data"
		int start = line.indexOf("content-disposition: ");
		int end = line.indexOf(";");
		if (start == -1 || end == -1)
		{
			throw new IOException("Content disposition corrupt: " + origline);
		}
		String disposition = line.substring(start + 21, end);
		if (!disposition.equals("form-data"))
		{
			throw new IOException("Invalid content disposition: " + disposition);
		}

		// Get the field name
		start = line.indexOf("name=\"", end); // start at last semicolon
		end = line.indexOf("\"", start + 7); // skip name=\"
		if (start == -1 || end == -1)
		{
			throw new IOException("Content disposition corrupt: " + origline);
		}
		String name = origline.substring(start + 6, end);

		// Get the filename, if given
		String filename = null;
		start = line.indexOf("filename=\"", end + 2); // start after name
		end = line.indexOf("\"", start + 10);

		if (start != -1 && end != -1)
		{
			filename = origline.substring(start + 10, end);
			int slash = Math.max(filename.lastIndexOf('/'), filename.lastIndexOf('\\'));
			if (slash > -1)
			{
				filename = filename.substring(slash + 1);
			}
			if (filename.equals(""))
				filename = "unknown";
		}

		// Return a String array: disposition, name, filname
		retval[0] = disposition;
		retval[1] = name;
		retval[2] = filename;

		return retval;
	}

	private String extractContentType(String line) throws IOException
	{
		String contentType = null;

		// Convert the line to a lowercase string
		String origline = line;
		line = origline.toLowerCase();

		// Get the content type, if any
		if (line.startsWith("content-type"))
		{
			int start = line.indexOf(" ");
			if (start == -1)
			{
				throw new IOException("Content type corrupt: " + origline);
			}
			contentType = line.substring(start + 1);
		}
		else if (line.length() != 0)
		{
			throw new IOException("Malformed line after disposition: " + origline);
		}

		return contentType;
	}
} // Class: MultipartRequest

//    A class to aid in reading multipart/form-data.
class MultipartInputStreamHandler
{
	ServletInputStream in;
	String boundary;
	int totalExpected;
	int totalRead = 0;
	byte buf[] = new byte[8 * 1024];

	public MultipartInputStreamHandler(ServletInputStream in, String boundary, int totalExpected)
	{
		this.in = in;
		this.boundary = boundary;
		this.totalExpected = totalExpected;
	}

	public String readLine() throws IOException
	{
		StringBuffer sbuf = new StringBuffer();
		int result;
		String line;

		do
		{
			result = this.readLine(buf, 0, buf.length);
			if (result != -1)
			{
				sbuf.append(new String(buf, 0, result, "ISO-8859-1"));
			}
		}
		while (result == buf.length); // loop only if the buffre was filled

		if (sbuf.length() == 0)
		{
			return null;
		}

		sbuf.setLength(sbuf.length() - 2); // cut off the trailing \r\n
		return sbuf.toString();
	}

	public int readLine(byte b[], int off, int len) 
      throws IOException
	{
		if (totalRead >= totalExpected)
		{
			return -1;
		}
		else
		{
			int result = in.readLine(b, off, len);
			if (result > 0)
			{
				totalRead += result;
			}
			return result;
		}
	}
}
/*
 *
 * $Log: MultipartRequestHandler.java,v $
 * Revision 1.2  2005/10/16 03:23:21  brian
 * Changed default document size to 20MBs from 1MB.
 *
 *
 */