<%-- 
    Document   : Compose
    Created on : 14 Nov, 2016, 10:16:07 AM
    Author     : sai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compose Message</title>
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
						<h4>Compose Message</h4> <form action="ComposeServlet" >
						<table>
			 	<tr><td>To: <input type="text" name="reciever_id"/><br/></td></tr>
                                <tr><td>Subject: <input type="text" name="subject" placeholder="Mention subject compulsory"/><br/></td></tr>
			 	<tr><td>Message:<br/></td></tr>
			 	<tr><td><textarea rows="10" cols="50" name="message"></textarea><br/></td></tr>
			 	<tr><td><input type="submit" value="Send"/></td></tr>
			 	
			 	</table></form>
						</li>
							</span>
										 
		
							
								
							</ul>
						</section>
					
					</div>
					
			</div>
		</div>

    </body>
</html>
