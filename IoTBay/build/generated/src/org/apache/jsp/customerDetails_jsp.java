package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.isd.model.*;

public final class customerDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index.css\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Personal Details Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            Customer customer = (Customer) session.getAttribute("customer");
            String updated = (String) session.getAttribute("updated");
        
      out.write("\r\n");
      out.write("        <div class=\"topRight\">\r\n");
      out.write("            <a href=\"dashboard.jsp\"><button class=\"bttn\">Go back to main dashboard</button></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <img src=\"css/IoTBay_Logo.png\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <h1>Personal details </h1>\r\n");
      out.write("        <div class=\"center\">\r\n");
      out.write("            <p>Enter the new details in the textbox and click update if you would like to change your details</p>\r\n");
      out.write("            <span>");
      out.print((updated != null ? updated: ""));
      out.write("</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <form method=\"post\" action=\"CustomerUpdateServlet\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr><td>Full name: </td><td><input class=\"tb\" type=\"text\" name=\"name\" ></td></tr>                \r\n");
      out.write("            <tr><td>Date of birth: </td><td><input class=\"tb\" type=\"date\" name=\"dob\" ></td></tr>\r\n");
      out.write("            <tr><td>Email: </td><td><input class=\"tb\" type=\"text\" name=\"email\" ></td></tr>\r\n");
      out.write("            <tr><td>Contact number: </td><td><input class=\"tb\" type=\"text\" name=\"number\" ></td></tr>\r\n");
      out.write("            <tr><td>Gender</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <select name=\"gender\">\r\n");
      out.write("                            <option value=\"male\">Male</option>\r\n");
      out.write("                            <option value=\"female\">Female</option>\r\n");
      out.write("                            <option value=\"Prefer not to say\">Prefer not to say</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr><td>Address: </td><td><input class=\"tb\" type=\"text\" name=\"address\" ></td></tr>\r\n");
      out.write("            <tr><td>Password: </td><td><input class=\"tb\" type=\"password\" name=\"password\" ></td></tr>\r\n");
      out.write("            <tr><td>Would you like to receive a promotional newsletter?</td><td><input type=\"checkbox\" name=\"news\" value=\"yes\"></td></tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <div class=\"center\">\r\n");
      out.write("                <a><input class=\"bttn\" type=\"submit\" value=\"Update\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <p>If you wish to delete your account click <input class=\"sbttn\" type=\"submit\" value=\"Delete\"></p>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
