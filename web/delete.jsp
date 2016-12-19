<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>


<%
    db.NewClass ns=new db.NewClass();
  
String n=request.getParameter("val");
boolean i=false;
if(n.length()>0){
try{
    
    i=ns.deleteData("delete from inbox where id='"+n+"'");
if(i==true){
session.setAttribute("deletemsg","Mail has been successfully deleted");
response.sendRedirect("inbox.jsp");
}


}catch(Exception e){e.printStackTrace();}
}
%>
