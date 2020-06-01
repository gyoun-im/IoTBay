package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index.css\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        
      out.write("\r\n");
      out.write("         <div class=\"container\">\r\n");
      out.write("            <img src=\"css/IoTBay_Logo.png\">\r\n");
      out.write("        </div>\r\n");
      out.write("         <h1>Login </h1>\r\n");
      out.write("         <p><span>");
      out.print((existErr != null ? existErr : ""));
      out.write("</span></p>\r\n");
      out.write("        <div class=\"center\">\r\n");
      out.write("        <form method=\"post\" action=\"LoginServlet\">\r\n");
      out.write("            <table class=\"center\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><input class=\"tb\" type=\"text\" placeholder=\"");
      out.print((emailErr != null ? emailErr : "Enter email"));
      out.write("\" name=\"email\" ></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Username</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><input class=\"tb\" type=\"text\" placeholder=\"");
      out.print((passErr != null ? emailErr : "Enter password"));
      out.write("\" name=\"password\" ></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Password</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <div class=\"center\">\r\n");
      out.write("                <a href=\"CancelServlet\" class=\"bttn\" class=\"a\">Cancel</button></a>\r\n");
      out.write("                <a><input class=\"bttn\" type=\"submit\" value=\"Login\"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"center\">\r\n");
      out.write("            <p>Don't have account? Sign up. Are you a <a href=\"customer_register.jsp\">customer</a> or a <a href =\"staff_register.jsp\">staff</a></p>\r\n");
      out.write("            <p>or continue as guest <a href=\"mainPage.jsp\">click here</a> </p>\r\n");
      out.write("        </div>\r\n");
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
