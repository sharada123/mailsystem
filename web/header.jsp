<%@page import="org.w3c.dom.Document"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Mail Services</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
<script src="css/5grid/viewport.js"></script>
<script src="css/5grid/ie.js"></script>
<link rel="stylesheet" href="css/5grid/core.css" />
		<link rel="stylesheet" href="css/style.css" />
		
	</head>
	<body>
	<!-- ********************************************************* -->
		<div id="header-wrapper">
			<div class="5grid">
				<div class="12u-first">
					
					<header id="header">
                                            <h1><a href="#">Mail.com</a></h1>
						<nav>
                                                   
                                                        <a href="compose.jsp" target="middleframe">Compose Mail</a>
                                                        <a href="inbox.jsp" target="middleframe">Inbox</a>
                                                        <a href="sent.jsp" target="middleframe">Sent Mail</a>
                                                        <a href="draft.jsp" target="middleframe">Draft</a>
                                                        <a href="index.jsp" target="newhome">Logout</a>
                                                        <input type="text"  name="searchdata" id="searchdata">
                                                        <a id="link" href="search.jsp" onclick="addTextBoxData(this)" target="middleframe">Search</a>
                                                       
                                                        </nav>
                                                
					</header>
                                    
                                    
				</div>
			</div>
		</div>
     
      
                    <script src="jquery.1.8.3.min.js" type="text/javascript"></script>
                    <script>
                        function addTextBoxData(e){
                           e.href=e.href+"?textdata="+document.getElementById('searchdata').value();
                         alert(e.href);   
                        }
                        
            function searchmail1(){
                //alert(1);
                var data=$("#searchdata").val();
                //alert(data);
                $.post("search.jsp",{searchdata:data},function(success){
                    alert(success)
                });
            }
            function searchmail(){
                
                $("#link").show();
            }
            function showmail(){
                var data=$("#searchdata").val();
                $("#link").attr("href","search.jsp?id="+document.getElementById('searchdata')).html();
                
            }
        </script>
        
        </body>
</html>