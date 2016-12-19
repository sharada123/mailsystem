<%@page import="java.sql.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/images/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Compose Message</title>
    </head>

  <style>
         body{
       background-color:  #cfd2da;
            
        }
</style>



<div id="main">
			<div class="5grid">
				<div class="main-row">
					
					<div class="4u">
									
									<% 
									
								if(session.getAttribute("username")!=null){
								String username=(String)session.getAttribute("username");		
								
                                                                %>
                                                <table class="table">
                                                    <tr>
                                                        <td><strong>Receiver</strong></td>
                                                       
                                                        <td><strong>Message</strong></td>
                                                        <td><strong>Date</strong></td>
                                <td> </td>
                                </tr>                
                                                                
                                                                
								<%
                                                                try {
		    db.NewClass ns= new db.NewClass();
			String sql="select receiver,msg,date from inbox where sender='"+username+"'";
                 
                       ResultSet rs=ns.selectData(sql);
                        while(rs.next())
                        {
                        
                        %>
                       
                           <tr>
                               <%
                                 if(username.equals(rs.getString("receiver")))
                                 {
                                     %>
                                     
                                      <td>me</td>
                                      <td><%out.print(rs.getString("msg")); %></td>
                                     <td><%out.print(rs.getString("date")); %></td>
                                     <%
                                 }else{
                                     
                               %>
                               <td><%out.print(rs.getString("receiver")); %></td>
                               
                                <td><%out.print(rs.getString("msg")); %></td>
                                <td><%out.print(rs.getString("date")); %></td>
                             <%
                                 }
                             %>
                            </tr>  
                            
                      
                        
                        
                        
                        <%
                                 }
                        
			
		%>
                        
                              </table>
                            
                            <%
                                                                } catch (SQLException e) {
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

