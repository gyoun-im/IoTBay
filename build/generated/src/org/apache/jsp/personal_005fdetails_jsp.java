package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class personal_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Personal Details Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"topRight\">\n");
      out.write("            <a href=\"dashboard.jsp\"><button class=\"bttn\">Go back to main dashboard</button></a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <img src=\"css/IoTBay_Logo.png\">\n");
      out.write("        </div>\n");
      out.write("        <h1>Personal details</h1>\n");
      out.write("        <p>Enter the new details in the textbox and click update if you would like to change your details</p>\n");
      out.write("        <table>\n");
      out.write("            <tr><td>Full name: </td><td><input class=\"tb\" type=\"text\" name=\"name\" ></td></tr>                \n");
      out.write("            <tr><td>Date of birth: </td><td><input class=\"tb\" type=\"date\" name=\"dob\" ></td></tr>\n");
      out.write("            <tr><td>Email: </td><td><input class=\"tb\" type=\"text\" name=\"email\" ></td></tr>\n");
      out.write("            <tr><td>Contact number: </td><td><input class=\"tb\" type=\"text\" name=\"number\" ></td></tr>\n");
      out.write("            <tr><td>Password: </td><td><input class=\"tb\" type=\"password\" name=\"password\" ></td></tr>\n");
      out.write("        </table>\n");
      out.write("        <div class=\"center\">\n");
      out.write("                <a><input class=\"bttn\" type=\"submit\" value=\"Update\"></a>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <p>If you wish to delete your account click <input class=\"sbttn\" type=\"submit\" value=\"Delete\"></p>\n");
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
