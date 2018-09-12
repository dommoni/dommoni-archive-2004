package org.apache.jsp;

import com.dommoni.roundtable.Project;
import com.dommoni.ece.webui.Operations;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class openProjectMenu extends HttpJspBase {


    static {
    }
    public openProjectMenu( ) {
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

            // HTML // begin [file="/openProjectMenu.jsp";from=(0,50);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/openProjectMenu.jsp";from=(1,52);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/openProjectMenu.jsp";from=(3,2);to=(5,0)]
                
                	Project currentProject = (Project)session.getAttribute("currentproject");
            // end
            // HTML // begin [file="/openProjectMenu.jsp";from=(5,2);to=(7,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/openProjectMenu.jsp";from=(7,2);to=(10,3)]
                
                if(currentProject == null)
                {
                   
            // end
            // HTML // begin [file="/openProjectMenu.jsp";from=(10,5);to=(10,61)]
                out.write("<li><a href=\"selectProjects.jsp\">Open a Project</a></li>");

            // end
            // begin [file="/openProjectMenu.jsp";from=(10,63);to=(14,3)]
                
                }
                else
                {
                   
            // end
            // HTML // begin [file="/openProjectMenu.jsp";from=(14,5);to=(14,53)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/openProjectMenu.jsp";from=(14,56);to=(14,80)]
                out.print(Operations.CLOSE_PROJECT);
            // end
            // HTML // begin [file="/openProjectMenu.jsp";from=(14,82);to=(14,106)]
                out.write("\">Close Project</a></li>");

            // end
            // begin [file="/openProjectMenu.jsp";from=(14,108);to=(16,0)]
                
                }
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
