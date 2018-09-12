<%@page import="com.dommoni.roundtable.AccountProfile" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.ece.webui.imaging.ImageScaler" %>

<%@page import="java.text.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.awt.*" %>
<%@page import="java.awt.image.*" %>
<%@page import="javax.swing.*" %>
<%@page import="com.keypoint.PngEncoderB" %>
<%
  try
  {
  response.setHeader("Cache-Control", "no-cache");
  response.addHeader("Pragma", "no-cache");

  ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
  
  String accountId = request.getParameter("accountid");
  AccountProfile profile = psc.getAccountManager().getAccountProfile(Integer.parseInt(accountId));
  
  ImageIcon image = new ImageIcon(profile.getImage());

  BufferedImage bufferedImage = new BufferedImage(image.getIconWidth(),
              image.getIconHeight(),
              BufferedImage.TYPE_INT_RGB);
			  
  if(bufferedImage.getWidth() > 250 || bufferedImage.getHeight() > 250)
  {
     System.out.println("IMAGE IS TOOO BIG!, TIME TO SHRINK IT!");
	 bufferedImage = ImageScaler.scale(bufferedImage, 250, 250);
	 System.out.println("IMAGE SCALED");
  }
  Graphics2D g2D = (Graphics2D)bufferedImage.getGraphics();
  g2D.drawImage(image.getImage(), 0, 0, null);
  


  try
  {
     // write encoded gif to servlet's output stream
     //GIFEncoder gif = new GIFEncoder( bufferedImage );
     //gif.Write(response.getOutputStream());
	 
     response.setContentType("image/png");
     PngEncoderB encoder = new PngEncoderB(bufferedImage);
     response.getOutputStream().write(encoder.pngEncode());
  }
  catch ( Throwable t )
  {
     System.out.println( "Caught throwable: " + t.getMessage() );
     t.printStackTrace();
  }
  }
  catch(Exception e)
  {
     e.printStackTrace();
  }
%>
<%--

$Log: getProfileImage.jsp,v $
Revision 1.2  2005/10/16 06:53:23  brian
Removed print statement.


--%>