package org.apache.jsp;

import com.dommoni.roundtable.AccountProfile;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.imaging.ImageScaler;
import java.text.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import com.keypoint.PngEncoderB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class getProfileImage extends HttpJspBase {


    static {
    }
    public getProfileImage( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws java.io.IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                synchronized (this) {
                    if (_jspx_inited == false) {
                        _jspx_init();
                        _jspx_inited = true;
                    }
                }
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html;ISO-8859-1");
            pageContext = _jspxFactory.getPageContext(this, request, response,
            			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="/getProfileImage.jsp";from=(0,57);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(1,66);to=(2,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(2,61);to=(4,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(4,31);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(5,31);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(6,29);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(7,30);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(8,36);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(9,33);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(10,44);to=(11,0)]
                out.write("\r\n");

            // end
            // begin [file="/getProfileImage.jsp";from=(11,2);to=(59,0)]
                
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
            // end
            // HTML // begin [file="/getProfileImage.jsp";from=(59,2);to=(60,0)]
                out.write("\r\n");

            // end

        } catch (Throwable t) {
            if (out != null && out.getBufferSize() != 0)
                out.clearBuffer();
            if (pageContext != null) pageContext.handlePageException(t);
        } finally {
            if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
        }
    }
}
