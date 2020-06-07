package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.isd.model.*;
import uts.isd.controller.LogoutController;

public final class CustomerMain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Main Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            Customer customer = (Customer)session.getAttribute("name");

        
      out.write("\n");
      out.write("        \n");
      out.write("       \n");
      out.write("            <img src=\"css/IoTBay_Logo.png\" class=\"logo\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"topRight\">\n");
      out.write("            <a class=\"bttn\" href=\"LogoutController\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("                      \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"center\">\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <input class=\"searchTb\" type=\"search\" placeholder=\"Search...\" name=\"search\">\n");
      out.write("            </form>\n");
      out.write("            <div class=\"cart\">\n");
      out.write("                <a href=\"cart.jsp\">View cart</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <table class=\"dashboardTable\">\n");
      out.write("            <tr>\n");
      out.write("                <th class=\"tabBorder\">Profile</th>\n");
      out.write("                <th class=\"tabBorder\">Categories</th>\n");
      out.write("                <th class=\"tabBorder\">Sales</th>\n");
      out.write("                <th class=\"tabBorder\">About us</th>\n");
      out.write("                <th class=\"tabBorder\">Contact us</th>                \n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
