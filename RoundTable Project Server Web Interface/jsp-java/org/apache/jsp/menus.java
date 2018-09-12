package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.menus.MenuItemMap;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class menus extends HttpJspBase {


    static {
    }
    public menus( ) {
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

            // HTML // begin [file="/menus.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(4,54);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(6,66);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(7,96);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(9,50);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(10,52);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/menus.jsp";from=(11,59);to=(13,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/menus.jsp";from=(13,2);to=(18,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account userAccount = (Account)session.getAttribute("useraccount");
                	MenuItemMap menus = (MenuItemMap)session.getAttribute("menus");
            // end
            // HTML // begin [file="/menus.jsp";from=(18,2);to=(20,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/menus.jsp";from=(20,2);to=(28,6)]
                
                	if(userAccount.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR)
                	{
                		// draw admin menu
                		// draw project menu
                		Vector adminMenu = (Vector)menus.get("adminmenu");
                		if(adminMenu != null)
                		{
                		    
            // end
            // HTML // begin [file="/menus.jsp";from=(28,8);to=(28,22)]
                out.write("<ul id=\"Tabs\">");

            // end
            // begin [file="/menus.jsp";from=(28,24);to=(34,7)]
                
                			for(int i = 0; i < adminMenu.size(); i++)
                			{
                				MenuItem mi = (MenuItem)adminMenu.get(i);
                				if(mi.current)
                				{
                				   
            // end
            // HTML // begin [file="/menus.jsp";from=(34,9);to=(34,57)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/menus.jsp";from=(34,60);to=(34,82)]
                out.print(Operations.HANDLE_MENU);
            // end
            // HTML // begin [file="/menus.jsp";from=(34,84);to=(34,89)]
                out.write("&mid=");

            // end
            // begin [file="/menus.jsp";from=(34,92);to=(34,97)]
                out.print(mi.id);
            // end
            // HTML // begin [file="/menus.jsp";from=(34,99);to=(34,117)]
                out.write("\" class=\"current\">");

            // end
            // begin [file="/menus.jsp";from=(34,120);to=(34,128)]
                out.print(mi.title);
            // end
            // HTML // begin [file="/menus.jsp";from=(34,130);to=(34,139)]
                out.write("</a></li>");

            // end
            // begin [file="/menus.jsp";from=(34,141);to=(38,7)]
                
                				}
                				else
                				{
                				   
            // end
            // HTML // begin [file="/menus.jsp";from=(38,9);to=(38,57)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/menus.jsp";from=(38,60);to=(38,82)]
                out.print(Operations.HANDLE_MENU);
            // end
            // HTML // begin [file="/menus.jsp";from=(38,84);to=(38,89)]
                out.write("&mid=");

            // end
            // begin [file="/menus.jsp";from=(38,92);to=(38,97)]
                out.print(mi.id);
            // end
            // HTML // begin [file="/menus.jsp";from=(38,99);to=(38,101)]
                out.write("\">");

            // end
            // begin [file="/menus.jsp";from=(38,104);to=(38,112)]
                out.print(mi.title);
            // end
            // HTML // begin [file="/menus.jsp";from=(38,114);to=(38,123)]
                out.write("</a></li>");

            // end
            // begin [file="/menus.jsp";from=(38,125);to=(41,3)]
                
                				}
                			}
                			
            // end
            // HTML // begin [file="/menus.jsp";from=(41,5);to=(41,10)]
                out.write("</ul>");

            // end
            // begin [file="/menus.jsp";from=(41,12);to=(51,6)]
                
                		}
                	}
                	else if(userAccount.getAccountType() == AccountType.MANAGER)
                	{
                		// draw admin menu
                		// draw project menu
                		Vector managerMenu = (Vector)menus.get("managermenu");
                		if(managerMenu != null)
                		{
                		    
            // end
            // HTML // begin [file="/menus.jsp";from=(51,8);to=(51,22)]
                out.write("<ul id=\"Tabs\">");

            // end
            // begin [file="/menus.jsp";from=(51,24);to=(57,7)]
                
                			for(int i = 0; i < managerMenu.size(); i++)
                			{
                				MenuItem mi = (MenuItem)managerMenu.get(i);
                				if(mi.current)
                				{
                				   
            // end
            // HTML // begin [file="/menus.jsp";from=(57,9);to=(57,57)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/menus.jsp";from=(57,60);to=(57,82)]
                out.print(Operations.HANDLE_MENU);
            // end
            // HTML // begin [file="/menus.jsp";from=(57,84);to=(57,89)]
                out.write("&mid=");

            // end
            // begin [file="/menus.jsp";from=(57,92);to=(57,97)]
                out.print(mi.id);
            // end
            // HTML // begin [file="/menus.jsp";from=(57,99);to=(57,117)]
                out.write("\" class=\"current\">");

            // end
            // begin [file="/menus.jsp";from=(57,120);to=(57,128)]
                out.print(mi.title);
            // end
            // HTML // begin [file="/menus.jsp";from=(57,130);to=(57,139)]
                out.write("</a></li>");

            // end
            // begin [file="/menus.jsp";from=(57,141);to=(61,7)]
                
                				}
                				else
                				{
                				   
            // end
            // HTML // begin [file="/menus.jsp";from=(61,9);to=(61,57)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/menus.jsp";from=(61,60);to=(61,82)]
                out.print(Operations.HANDLE_MENU);
            // end
            // HTML // begin [file="/menus.jsp";from=(61,84);to=(61,89)]
                out.write("&mid=");

            // end
            // begin [file="/menus.jsp";from=(61,92);to=(61,97)]
                out.print(mi.id);
            // end
            // HTML // begin [file="/menus.jsp";from=(61,99);to=(61,101)]
                out.write("\">");

            // end
            // begin [file="/menus.jsp";from=(61,104);to=(61,112)]
                out.print(mi.title);
            // end
            // HTML // begin [file="/menus.jsp";from=(61,114);to=(61,123)]
                out.write("</a></li>");

            // end
            // begin [file="/menus.jsp";from=(61,125);to=(64,3)]
                
                				}
                			}
                			
            // end
            // HTML // begin [file="/menus.jsp";from=(64,5);to=(64,10)]
                out.write("</ul>");

            // end
            // begin [file="/menus.jsp";from=(64,12);to=(74,6)]
                
                		}
                	}
                	
                	if(currentProject != null)
                	{
                		// draw project menu
                		Vector mainMenu = (Vector)menus.get("mainmenu");
                		if(mainMenu != null)
                		{
                		    
            // end
            // HTML // begin [file="/menus.jsp";from=(74,8);to=(74,22)]
                out.write("<ul id=\"Tabs\">");

            // end
            // begin [file="/menus.jsp";from=(74,24);to=(80,7)]
                
                			for(int i = 0; i < mainMenu.size(); i++)
                			{
                				MenuItem mi = (MenuItem)mainMenu.get(i);
                				if(mi.current)
                				{
                				   
            // end
            // HTML // begin [file="/menus.jsp";from=(80,9);to=(80,57)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/menus.jsp";from=(80,60);to=(80,82)]
                out.print(Operations.HANDLE_MENU);
            // end
            // HTML // begin [file="/menus.jsp";from=(80,84);to=(80,89)]
                out.write("&mid=");

            // end
            // begin [file="/menus.jsp";from=(80,92);to=(80,97)]
                out.print(mi.id);
            // end
            // HTML // begin [file="/menus.jsp";from=(80,99);to=(80,117)]
                out.write("\" class=\"current\">");

            // end
            // begin [file="/menus.jsp";from=(80,120);to=(80,128)]
                out.print(mi.title);
            // end
            // HTML // begin [file="/menus.jsp";from=(80,130);to=(80,139)]
                out.write("</a></li>");

            // end
            // begin [file="/menus.jsp";from=(80,141);to=(84,7)]
                
                				}
                				else
                				{
                				   
            // end
            // HTML // begin [file="/menus.jsp";from=(84,9);to=(84,57)]
                out.write("<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/menus.jsp";from=(84,60);to=(84,82)]
                out.print(Operations.HANDLE_MENU);
            // end
            // HTML // begin [file="/menus.jsp";from=(84,84);to=(84,89)]
                out.write("&mid=");

            // end
            // begin [file="/menus.jsp";from=(84,92);to=(84,97)]
                out.print(mi.id);
            // end
            // HTML // begin [file="/menus.jsp";from=(84,99);to=(84,101)]
                out.write("\">");

            // end
            // begin [file="/menus.jsp";from=(84,104);to=(84,112)]
                out.print(mi.title);
            // end
            // HTML // begin [file="/menus.jsp";from=(84,114);to=(84,123)]
                out.write("</a></li>");

            // end
            // begin [file="/menus.jsp";from=(84,125);to=(87,3)]
                
                				}
                			}
                			
            // end
            // HTML // begin [file="/menus.jsp";from=(87,5);to=(87,10)]
                out.write("</ul>");

            // end
            // begin [file="/menus.jsp";from=(87,12);to=(90,0)]
                
                		}
                	}
            // end
            // HTML // begin [file="/menus.jsp";from=(90,2);to=(93,0)]
                out.write("\r\n\r\n\r\n");

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
