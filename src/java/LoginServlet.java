import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

	db.NewClass ns=new db.NewClass();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("email");
		String password=request.getParameter("password");
		ResultSet rs=ns.selectData("select * from users where email='"+uname+"' and password='"+password+"'");
            try {
                if(rs.next()){
                    if(uname.equals(rs.getString("email")) && password.equals(rs.getString("password"))){
                        HttpSession session=request.getSession();
                        session.setAttribute("username",uname);
                          session.setAttribute("pwd",password);
                        out.print("Welcome    " + uname);
                        ns.updateData("update users set state='1' where email='"+uname+"'");
                        //RequestDispatcher rd=request.getRequestDispatcher("/newhome.jsp");
                        //rd.include(request, response);
                        response.sendRedirect("newhome.jsp");
                    }
                }
                
                else{
                    String Error="Please check your EMail and Password";
                    request.setAttribute("Error", Error);
                    
                    //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                    //rd.include(request, response);
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
		out.close();
	}

}
