import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ComposeServlet extends HttpServlet {

	db.NewClass ns=new db.NewClass();
	//public void doGet(HttpServletRequest request, HttpServletResponse response, Object parse)
	//		throws ServletException, IOException {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
boolean i=false;

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
		
		String sender=(String)session.getAttribute("username");
		
		
		String reciever=request.getParameter("reciever_id");
		String msg=request.getParameter("message");
                String subject=request.getParameter("subject");
                java.util.Date sqdate=Calendar.getInstance().getTime();
	java.sql.Date dat =new java.sql.Date(sqdate.getTime());
        i=ns.insertData("insert into inbox(`receiver`,`sender`,`subject`,`msg`,`date`)values('"+reciever+"','"+sender+"','"+subject+"','"+msg+"','"+dat+"')");
		
		if(i==true){
                ResultSet rs1=ns.selectData("select receiveremail from chat where email='"+sender+"'");
    try {
        while(rs1.next()){
            if(rs1.getString("receiveremail").equals(reciever)){
            }else{
            ns.insertData("insert into chat(`email`,`receiveremail`)value('"+sender+"','"+reciever+"')");}
        }} catch (SQLException ex) {
        Logger.getLogger(ComposeServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
                 session.setAttribute("sentmsg","Message Successfully Sent");
        response.sendRedirect("inbox.jsp");}
		else{
			session.setAttribute("sentmsg","Message Sending Fail");
                         response.sendRedirect("inbox.jsp");
		}
		
    	}

}
