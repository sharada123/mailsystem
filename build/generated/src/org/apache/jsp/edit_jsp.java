package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            background-color: #007294;\n");
      out.write("            \n");
      out.write("        }    \n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <section>\n");
      out.write("            <form method=\"post\" action=\"update\" enctype=\"multipart/form-data\">\n");
      out.write("                <table>\n");
      out.write("                    \n");
      out.write("                   ");
  
                   String uname=request.getParameter("username");
                    String pwd=request.getParameter("pwd");
                    db.NewClass ns=new db.NewClass();
                    ResultSet rs=ns.selectData("select * from users where email='"+uname+"' and password='"+pwd+"'");
                    if(rs.next()){
                   
      out.write("\n");
      out.write("                   \n");
      out.write("                   <tr><td><img src=\"");
out.print(rs.getString("profile"));
      out.write("\"/></td></tr>\n");
      out.write("                   <tr style=\" display:  none;\"><td><input type=\"file\" name=\"file\" id=\"dpfile\"></td></tr>\n");
      out.write("                   <tr><td> <input type=\"hidden\" name=\"hiddenid\" value=\"");
out.print(rs.getString("id"));
      out.write("\"/><br/><br/></td></tr>\n");
      out.write("                   \n");
      out.write("                    <tr><td>Email Id:</td><td> <input type=\"email\" name=\"email\" value=\"");
out.print(uname);
      out.write("\"/><br/><br/></td></tr>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <tr id=\"link\"><td><a href=\"#\" onclick=\"showpwd()\">Change password</a></td></tr>\n");
      out.write("                                        <tr style=\" display: none;\" id=\"old\" ><td>Password: </td><td><input  type=\"password\" name=\"oldpwd\"/><br/><br/></td></tr>\n");
      out.write("                                       \n");
      out.write("                                        <tr style=\" display: none;\"id=\"new\" ><td>New password </td><td><input type=\"password\" name=\"newpwd\"/><br/><br/></td></tr>\n");
      out.write("                                        <tr><td>Name: </td><td><input type=\"text\" name=\"name\" placeholder=\"Enter Full name\" value=\"");
out.print(rs.getString("name"));out.print(" "+rs.getString("middlename")+" ");out.print(rs.getString("lastname"));
      out.write("\"/><br/><br/></td></tr>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <tr><td>Contact Number:</td><td> <input type=\"text\" name=\"mobileno\" value=\"");
out.print(rs.getString("contactno"));
      out.write("\"/><br/><br/></td></tr>\n");
      out.write("\t\t\t\t\t<tr><td>Country: </td><td><input type=\"text\" name=\"country\" value=\"");
out.print(rs.getString("country"));
      out.write("\"/><br/><br/></td></tr>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <tr><td></td><td><input type=\"submit\" value=\"Submit\"/></td></tr>\n");
      out.write("                                ");
}
      out.write("</table>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </section>\n");
      out.write("                                <script src=\"jquery.1.8.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                                <script>\n");
      out.write("                                    function showpwd(){\n");
      out.write("                                        $(\"#old\").show();\n");
      out.write("                                        $(\"#new\").show();\n");
      out.write("                                        $(\"#link\").hide();\n");
      out.write("                                    }\n");
      out.write("                                    \n");
      out.write("                                </script>\n");
      out.write("                                \n");
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
