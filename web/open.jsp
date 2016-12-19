
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Message</title>
    </head>
    
      <style>
         body{
       background-color:  #cfd2da;
            
        }</style>
    <body>
<div id="main">
			<div class="5grid">
				<div class="main-row">
					<div class="4u-first">
						
						
					
					</div>
					<div class="4u">
						
						<section>
							
							<ul class="small-image-list">
								
							
								
						<li>
                                                    
                                                    <%
                                                    db.NewClass ns=new db.NewClass();
                                                    String id=request.getParameter("sub");
                                                    ResultSet rs=ns.selectData("select * from inbox where id='"+id+"'");
                                                    if(rs.next())
                                                    {
                                                    %>
                                                    <h4><strong> Message</strong></h4>
						 <form method="post" action="reply?id=<%out.print(request.getParameter("sub"));%>"><table>
                                                    <tr><td>Sender: <% out.print(rs.getString("sender")); %><br/></td></tr>
                                <tr><td>Subject:  <% out.print(rs.getString("subject")); %><br/></td></tr>
			 	<tr><td>Message: <% out.print(rs.getString("msg")); %><br/></td></tr>
			 	<tr><td><input type="button" value="Reply" onclick="open()"></td></tr>
                                    
			 	<%
                                 }
                                %>
                      
                                
			 	</table>
                                
                               
                                        
                                    </form>
						</li>
							</span>
										 
		
							
								
							</ul>
						</section>
					
					</div>
					
			</div>
		</div>
</div>
                                        
    </body>
</html>