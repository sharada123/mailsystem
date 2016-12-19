package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class newjspleft_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("        <link href=\"css/images/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/leftjspcss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head> \n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <section class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-4 leftside\">\n");
      out.write("                    <div class=\"topmargin\">\n");
      out.write("                        ");


                            if (session.getAttribute("username") != null) {
                                String username = (String) session.getAttribute("username");
                                String pwd = (String) session.getAttribute("pwd");
                                db.NewClass ns = new db.NewClass();

                                ResultSet rs = ns.selectData("select profile from users where email='" + username + "'");
                                if (rs.next()) {
                        
      out.write("\n");
      out.write("                        <form id=\"UploadForm\" action=\"fileupload1?id=");
out.print(username);
      out.write("\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                            <img src=\"");
 out.print(rs.getString("profile"));
      out.write(" \"alt=\"your profile\"  id=\"img\" style=\" width: 100px; height: 130px; margin-left: 30px; margin-right: 10px;\" onclick=\"showfile()\"/>\n");
      out.write("\n");
      out.write("                            <div class=\"wrapper\" > \n");
      out.write("                                <!--<input type=\"file\" id=\"uploadfile\" name=\"file\" onchange=\"readURL(this);\" />\n");
      out.write("                                <input type=\"submit\" id=\"submit\" value=\"Upload\" class=\"btn btn-success\" style=\"display: none;\">\n");
      out.write("                                -->\n");
      out.write("\n");
      out.write("                                <input type=\"file\" size=\"60\" id=\"myfile\" name=\"myfile\" style=\" display: none;\"> \n");
      out.write("                                <input type=\"submit\" value=\"Upload\">\n");
      out.write("\n");
      out.write("                                <div id=\"progressbox\">\n");
      out.write("                                    <div id=\"progressbar\"></div>\n");
      out.write("                                    <div id=\"percent\">0%</div>\n");
      out.write("                                </div>\n");
      out.write("                                <br />\n");
      out.write("\n");
      out.write("                                <div id=\"message\"></div>\n");
      out.write("                                         \n");
      out.write("                                <br><a href=\"edit.jsp?username=");
out.print(username);
      out.write("&pwd=");
out.print(pwd);
      out.write("\" target=\"middleframe\" >Edit Profile</a>\n");
      out.write("                                ");

                                    }
      out.write("\n");
      out.write("                                <label style=\" margin-left: 30px;\">");
out.print(username);
      out.write("</label>\n");
      out.write("                                <input type=\"text\" placeholder=\"Enter email or subject\" name=\"search\"><input type=\"submit\" value=\"search\" onclick=\"showsearch()\">\n");
      out.write("                                <a href=\"#\" style=\" display: none;\" class=\"search\">View result</a>\n");
      out.write("                                ");
} else {
                                    request.setAttribute("Error1", "Plz Do login First");
                                
      out.write("\n");
      out.write("                                ");
      if (true) {
        _jspx_page_context.forward("index.jsp");
        return;
      }
      out.write("\n");
      out.write("                                ");
}
                                
      out.write("\n");
      out.write("                            </div></form>\n");
      out.write("                        <hr>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"inbox.jsp\" target=\"middleframe\"style=\"color: #034ea2;\">Inbox</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"sent.jsp\"target=\"middleframe\" style=\"color: #034ea2;\">Sent Mail </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>    <a href=\"draft.jsp\"target=\"middleframe\" style=\"color: #034ea2;\">Draft</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <hr>\n");
      out.write("                    <h4 style=\"color: #b52570;\"> <center>Chat</center></h4>\n");
      out.write("                            ");

                                String username = (String) session.getAttribute("username");
                                db.NewClass ns = new db.NewClass();
                                ResultSet rs = ns.selectData("select receiveremail from chat where email='" + username + "'");
                                while (rs.next()) {
      out.write("\n");
      out.write("                    <a href=\"#\">");
out.print(rs.getString("receiveremail"));
      out.write("</a>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <script src=\"js/fileUploadScript.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"js/jquery.form.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.js\" ></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"jquery.1.8.3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script>\n");
      out.write("                                $(\"#btnimg\").click(function () {\n");
      out.write("                                    $(\"#uploadfile\").click();\n");
      out.write("                                });\n");
      out.write("                                function readURL(input) {\n");
      out.write("                                    if (input.files && input.files[0]) {\n");
      out.write("                                        var reader = new FileReader();\n");
      out.write("\n");
      out.write("                                        reader.onload = function (e) {\n");
      out.write("                                            $('#img')\n");
      out.write("                                                    .attr('src', e.target.result)\n");
      out.write("                                                    .width(100)\n");
      out.write("                                                    .height(130);\n");
      out.write("                                        };\n");
      out.write("\n");
      out.write("                                        reader.readAsDataURL(input.files[0]);\n");
      out.write("                                    }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    $(\"#submit\").show();\n");
      out.write("\n");
      out.write("                                }\n");
      out.write("                                function showfile() {\n");
      out.write("                                    $(\"#myfile\").show();\n");
      out.write("\n");
      out.write("                                }\n");
      out.write("                                function showsearch(){\n");
      out.write("                                    \n");
      out.write("                                    $(\".search\").show();\n");
      out.write("                                }\n");
      out.write("</script>\n");
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
