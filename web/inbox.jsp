<%@page import="java.sql.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/images/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Inbox</title>
    </head>

  <style>
         body{
       background-color:  #cfd2da;
            
        }
</style>

<body>
<div id="main">
			<div class="5grid">
				<div class="main-row">
					
					<div class="4u">
									
									<% 
									db.NewClass ns=new db.NewClass();
								if(session.getAttribute("username")!=null){
								String username=(String)session.getAttribute("username");		
								if(session.getAttribute("sentmsg")!=null){
                                                                    String sentmsg=session.getAttribute("sentmsg").toString();
                                                                    out.print("<font style='color:red'><center>"+sentmsg+"</center></font>");
                                                                    session.setAttribute("sentmsg", "");
                                                                }
								if(request.getAttribute("deletemsg")!=null){
								String delete=(String)session.getAttribute("deletemsg");		
								out.print("<font style='color:navy'>"+delete+"</font>");
								}
                          %>
                                                <table class="table">
                            <tr>
                            <td><input type="hidden" name="hidden"></td>
                                <td><strong>Sender</strong></td>
                                <td><strong>Subject</strong></td>
                                                        <td><strong>Message</strong></td>
                                                         <td></td>
                                                        <td><strong>Date</strong></td>
                                <td> </td>
                            </tr>                 
                                                                
                                                                
								<%try {
		
			String sql="select * from inbox where receiver='"+username+"'";
                       
                       ResultSet rs= ns.selectData(sql);
                        while(rs.next())
                        {
                        
                        %>
                       
                           <tr>
                               
                                <%
                                 if(username.equals(rs.getString("sender")))
                                 {
                                  %>
                                     
                               <td><input type="hidden" name="hidden" value="<%out.print(rs.getString("id")); %>"></td>
                               <td>me</td>
                               <td><a href="open.jsp?sub=<%out.print(rs.getString("id")); %>"><%out.print(rs.getString("subject")); %></a></td>
                                <td><%out.print(rs.getString("msg")); %></td>
                                <td><a href="forword.jsp?id=<%out.print(rs.getString("id")); %>">Fwd</a></td>
                                <td><%out.print(rs.getString("date")); %></td>
                                <td> <a href="delete.jsp?val=<%out.print(rs.getString("id")); %>">Delete</a></td>
                               <%
                                 }else{
                                     
                               %> 
                           <td><input type="hidden" name="hidden" value="<%out.print(rs.getString("id")); %>"></td>
                               <td><%out.print(rs.getString("sender")); %></td>
                               <td><a href="open.jsp?sub=<%out.print(rs.getString("id")); %>"><%out.print(rs.getString("subject")); %></a></td>
                                <td><%out.print(rs.getString("msg")); %></td>
                                 <td><a href="forword.jsp?id=<%out.print(rs.getString("id")); %>">Fwd</a></td>
                                <td><%out.print(rs.getString("date")); %></td>
                                <td> <a href="delete.jsp?val=<%out.print(rs.getString("id")); %>">Delete</a></td>
                                 <%
                                 }
                             %>
                           </tr>  
                            
                     
                        
                        
                        
                        <%}%>
                                        </table>
                        <%} catch (SQLException e) {
			e.printStackTrace();
		}
		
                }						
								
								
								else{
								request.setAttribute("Error1","Plz Do login First");
								%>
								<jsp:forward page="index.jsp"></jsp:forward>
									<%
									
									}
								%>
								
								
								</div>
									
						
		
							
					
					
					</div>
			
				</div>
				
			</div>

</body>
</html>
