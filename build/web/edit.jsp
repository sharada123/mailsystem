<%-- 
    Document   : edit
    Created on : 17 Nov, 2016, 12:39:22 PM
    Author     : sai
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <section>
            <form method="post" action="update" enctype="multipart/form-data">
                <table>
                    
                   <%  
                   String uname=request.getParameter("username");
                    String pwd=request.getParameter("pwd");
                    db.NewClass ns=new db.NewClass();
                    ResultSet rs=ns.selectData("select * from users where email='"+uname+"' and password='"+pwd+"'");
                    if(rs.next()){
                   %>
                   
                   <tr><td><img src="<%out.print(rs.getString("profile"));%>"/></td></tr>
                   <tr style=" display:  none;"><td><input type="file" name="file" id="dpfile"></td></tr>
                   <tr><td> <input type="hidden" name="hiddenid" value="<%out.print(rs.getString("id"));%>"/><br/><br/></td></tr>
                   
                    <tr><td>Email Id:</td><td> <input type="email" name="email" value="<%out.print(uname);%>"/><br/><br/></td></tr>
					
                                        <tr id="link"><td><a href="#" onclick="showpwd()">Change password</a></td></tr>
                                        <tr style=" display: none;" id="old" ><td>Password: </td><td><input  type="password" name="oldpwd"/><br/><br/></td></tr>
                                       
                                        <tr style=" display: none;"id="new" ><td>New password </td><td><input type="password" name="newpwd"/><br/><br/></td></tr>
                                        <tr><td>Name: </td><td><input type="text" name="name" placeholder="Enter Full name" value="<%out.print(rs.getString("name"));out.print(" "+rs.getString("middlename")+" ");out.print(rs.getString("lastname"));%>"/><br/><br/></td></tr>
					
                                        <tr><td>Contact Number:</td><td> <input type="text" name="mobileno" value="<%out.print(rs.getString("contactno"));%>"/><br/><br/></td></tr>
					<tr><td>Country: </td><td><input type="text" name="country" value="<%out.print(rs.getString("country"));%>"/><br/><br/></td></tr>
					
                                        <tr><td></td><td><input type="submit" value="Submit"/></td></tr>
                                <%}%></table>
                
            </form>
            
        </section>
                                <script src="jquery.1.8.3.min.js" type="text/javascript"></script>
                                <script>
                                    function showpwd(){
                                        $("#old").show();
                                        $("#new").show();
                                        $("#link").hide();
                                    }
                                    
                                </script>
                                
    </body>
</html>
