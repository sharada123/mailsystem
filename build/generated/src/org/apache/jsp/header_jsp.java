package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.w3c.dom.Document;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE HTML>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Mail Services</title>\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<meta name=\"description\" content=\"\" />\n");
      out.write("\t\t<meta name=\"keywords\" content=\"\" />\n");
      out.write("<script src=\"css/5grid/viewport.js\"></script>\n");
      out.write("<script src=\"css/5grid/ie.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/5grid/core.css\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("\t\t\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t<!-- ********************************************************* -->\n");
      out.write("\t\t<div id=\"header-wrapper\">\n");
      out.write("\t\t\t<div class=\"5grid\">\n");
      out.write("\t\t\t\t<div class=\"12u-first\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<header id=\"header\">\n");
      out.write("                                            <h1><a href=\"#\">Mail.com</a></h1>\n");
      out.write("\t\t\t\t\t\t<nav>\n");
      out.write("                                                   \n");
      out.write("                                                        <a href=\"compose.jsp\" target=\"middleframe\">Compose Mail</a>\n");
      out.write("                                                        <a href=\"inbox.jsp\" target=\"middleframe\">Inbox</a>\n");
      out.write("                                                        <a href=\"sent.jsp\" target=\"middleframe\">Sent Mail</a>\n");
      out.write("                                                        <a href=\"draft.jsp\" target=\"middleframe\">Draft</a>\n");
      out.write("                                                        <a href=\"index.jsp\" target=\"newhome\">Logout</a>\n");
      out.write("                                                        <input type=\"text\"  name=\"searchdata\" id=\"searchdata\" onmouseout=\"showmail()\">\n");
      out.write("                                                       <a id=\"link\" href=\"\" target=\"middleframe\">Search</a>\n");
      out.write("                                                      \n");
      out.write("                                                        </nav>\n");
      out.write("                                                \n");
      out.write("\t\t\t\t\t</header>\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("     \n");
      out.write("      \n");
      out.write("                    <script src=\"jquery.1.8.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                    <script>\n");
      out.write("            function searchmail1(){\n");
      out.write("                //alert(1);\n");
      out.write("                var data=$(\"#searchdata\").val();\n");
      out.write("                //alert(data);\n");
      out.write("                $.post(\"search.jsp\",{searchdata:data},function(success){\n");
      out.write("                    alert(success)\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            function searchmail(){\n");
      out.write("                \n");
      out.write("                $(\"#link\").show();\n");
      out.write("            }\n");
      out.write("            function showmail(){\n");
      out.write("                var data=$(\"#searchdata\").val();\n");
      out.write("                $(\"#link\").attr(\"href\",\"search.jsp?id=\");\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        </body>\n");
      out.write("</html>");
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
