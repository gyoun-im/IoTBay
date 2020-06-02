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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        
      out.write("\n");
      out.write("         <div class=\"container\">\n");
      out.write("            <img src=\"css/IoTBay_Logo.png\">\n");
      out.write("        </div>\n");
      out.write("         <h1>Login </h1>\n");
      out.write("         <p><span>");
      out.print((existErr != null ? existErr : ""));
      out.write("</span></p>\n");
      out.write("        <div class=\"center\">\n");
      out.write("        <form method=\"post\" action=\"LoginServlet\">\n");
      out.write("            <table class=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><input class=\"tb\" type=\"text\" placeholder=\"");
      out.print((emailErr != null ? emailErr : "Enter email"));
      out.write("\" name=\"email\" ></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Username</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input class=\"tb\" type=\"text\" placeholder=\"");
      out.print((passErr != null ? emailErr : "Enter password"));
      out.write("\" name=\"password\" ></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Password</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <div class=\"center\">\n");
      out.write("                <a href=\"CancelServlet\" class=\"bttn\" class=\"a\">Cancel</button></a>\n");
      out.write("                <a><input class=\"bttn\" type=\"submit\" value=\"Login\"></a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"center\">\n");
      out.write("            <p>Don't have account? Sign up. Are you a <a href=\"customer_register.jsp\">customer</a> or a <a href =\"staff_register.jsp\">staff</a></p>\n");
      out.write("            <p>or continue as guest <a href=\"mainPage.jsp\">click here</a> </p>\n");
      out.write("        </div>\n");
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
