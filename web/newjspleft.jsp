<%-- 
    Document   : newjspleft
    Created on : 11 Nov, 2016, 12:04:45 PM
    Author     : sai
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/images/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/leftjspcss.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head> 

    <body>
        <section class="container">

            <div class="row">

                <div class="col-lg-4 leftside">
                    <div class="topmargin">
                        <%

                            if (session.getAttribute("username") != null) {
                                String username = (String) session.getAttribute("username");
                                String pwd = (String) session.getAttribute("pwd");
                                db.NewClass ns = new db.NewClass();

                                ResultSet rs = ns.selectData("select profile from users where email='" + username + "'");
                                if (rs.next()) {
                        %>
                        <form id="UploadForm" action="fileupload1?id=<%out.print(username);%>" method="post" enctype="multipart/form-data">
                            <img src="<% out.print(rs.getString("profile"));%> "alt="your profile"  id="img" style=" width: 100px; height: 130px; margin-left: 30px; margin-right: 10px;" onclick="showfile()"/>

                            <div class="wrapper" > 
                                <!--<input type="file" id="uploadfile" name="file" onchange="readURL(this);" />
                                <input type="submit" id="submit" value="Upload" class="btn btn-success" style="display: none;">
                                -->

                                <input type="file" size="60" id="myfile" name="myfile" style=" display: none;"> 
                                <input type="submit" value="Upload">

                                <div id="progressbox">
                                    <div id="progressbar"></div>
                                    <div id="percent">0%</div>
                                </div>
                                <br />

                                <div id="message"></div>
                                         
                                <br><a href="edit.jsp?username=<%out.print(username);%>&pwd=<%out.print(pwd);%>" target="middleframe" >Edit Profile</a>
                                <%
                                    }%>
                                <label style=" margin-left: 30px;"><%out.print(username);%></label>
                                
                                <%} else {
                                    request.setAttribute("Error1", "Plz Do login First");
                                %>
                                <jsp:forward page="index.jsp"></jsp:forward>
                                <%}
                                %>
                            </div></form>
                        <hr>

                    </div>
                    <ul>
                        <li><a href="inbox.jsp" target="middleframe"style="color: #034ea2;">Inbox</a>
                        </li>
                        <li><a href="sent.jsp"target="middleframe" style="color: #034ea2;">Sent Mail </a>
                        </li>
                        <li>    <a href="draft.jsp"target="middleframe" style="color: #034ea2;">Draft</a>
                        </li>
                    </ul>
                    <hr>
                    <h4 style="color: #b52570;"> <center>Chat</center></h4>
                            <%
                                String username = (String) session.getAttribute("username");
                                db.NewClass ns = new db.NewClass();
                                ResultSet rs = ns.selectData("select receiveremail from chat where email='" + username + "'");
                                while (rs.next()) {%>
                    <a href="#"><%out.print(rs.getString("receiveremail"));%></a>
                    <%
                        }
                    %>


                </div>
            </div>

        </div>
    </section>

    <script src="js/fileUploadScript.js" type="text/javascript"></script>
    <script src="js/jquery.form.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.js" ></script>
</body>



<script src="jquery.1.8.3.min.js" type="text/javascript"></script>
<script src="bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js" type="text/javascript"></script>
<script>
                                $("#btnimg").click(function () {
                                    $("#uploadfile").click();
                                });
                                function readURL(input) {
                                    if (input.files && input.files[0]) {
                                        var reader = new FileReader();

                                        reader.onload = function (e) {
                                            $('#img')
                                                    .attr('src', e.target.result)
                                                    .width(100)
                                                    .height(130);
                                        };

                                        reader.readAsDataURL(input.files[0]);
                                    }



                                    $("#submit").show();

                                }
                                function showfile() {
                                    $("#myfile").show();

                                }
                               
</script>
</html>
