package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/images/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>search</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("  <style>\n");
      out.write("         body{\n");
      out.write("       background-color:  #cfd2da;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div id=\"main\">\n");
      out.write("\t\t\t<div class=\"5grid\">\n");
      out.write("\t\t\t\t<div class=\"main-row\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"4u\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t");
 
									db.NewClass ns=new db.NewClass();
								if(session.getAttribute("username")!=null){
								String username=(String)session.getAttribute("username");		
								
                          
      out.write("\n");
      out.write("                                                <table class=\"table\">\n");
      out.write("                            <tr>\n");
      out.write("                            <td><input type=\"hidden\" name=\"hidden\"></td>\n");
      out.write("                                <td><strong>Sender</strong></td>\n");
      out.write("                                <td><strong>Subject</strong></td>\n");
      out.write("                                                        <td><strong>Message</strong></td>\n");
      out.write("                                                         <td></td>\n");
      out.write("                                                        <td><strong>Date</strong></td>\n");
      out.write("                                <td> </td>\n");
      out.write("                            </tr>                 \n");
      out.write("                                                                \n");
      out.write("                                                                \n");
      out.write("\t\t\t\t\t\t\t\t");
try {
		 String searchdata=request.getParameter("textdata");
                 
			//String sql="select * from inbox where sender='"+searchdata+"' or subject='"+searchdata+"' where receiver='"+username+"'";
                       String sql="select * from inbox where sender='komal@gmail.com' where receiver='sharada@gmail.com'";
                       ResultSet rs= ns.selectData(sql);
                        while(rs.next())
                        {
                        
                        
      out.write("\n");
      out.write("                       \n");
      out.write("                           <tr>\n");
      out.write("                               \n");
      out.write("                                \n");
      out.write("                           <td><input type=\"hidden\" name=\"hidden\" value=\"");
out.print(rs.getString("id")); 
      out.write("\"></td>\n");
      out.write("                               <td>");
out.print(rs.getString("sender")); 
      out.write("</td>\n");
      out.write("                               <td><a href=\"open.jsp?sub=");
out.print(rs.getString("id")); 
      out.write('"');
      out.write('>');
out.print(rs.getString("subject")); 
      out.write("</a></td>\n");
      out.write("                                <td>");
out.print(rs.getString("msg")); 
      out.write("</td>\n");
      out.write("                                 <td><a href=\"forword.jsp?id=");
out.print(rs.getString("id")); 
      out.write("\">Fwd</a></td>\n");
      out.write("                                <td>");
out.print(rs.getString("date")); 
      out.write("</td>\n");
      out.write("                                <td> <a href=\"delete.jsp?val=");
out.print(rs.getString("id")); 
      out.write("\">Delete</a></td>\n");
      out.write("                                 \n");
      out.write("                           </tr>  \n");
      out.write("                            \n");
      out.write("                     \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                                        </table>\n");
      out.write("                        ");
} catch (SQLException e) {
			e.printStackTrace();
		}
		
                }						
								
								
								else{
								request.setAttribute("Error1","Plz Do login First");
								
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (true) {
        _jspx_page_context.forward("index.jsp");
        return;
      }
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t");

									
									}
								
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("</body>\n");
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
