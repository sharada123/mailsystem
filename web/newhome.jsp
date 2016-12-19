<%-- 
    Document   : newhome
    Created on : 13 Nov, 2016, 3:53:03 PM
    Author     : sai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <frameset rows="25%,*,10%" cols="*" frameborder="yes" border="1" framespacing="0">
         <frame src="header.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" style="border-bottom: 2px #35c0e5 ridge;"/>
    <frameset cols="15%,75%">
  
  <frame src="newjspleft.jsp" id="rightFrame" scrolling="yes" name="leftFrame" style=" margin-top:500px;border-right: 2px #35c0e5 ridge;"/>
    <frame src="inbox.jsp" id="middleframe" scrolling="yes" name="middleframe" style="margin-top:500px;"/> 

  

</frameset>
     
      </frameset>
    
    
    <body>
       
    </body>
</html>
