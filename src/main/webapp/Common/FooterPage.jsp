<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
 	   	<link rel="stylesheet" href="../css/custom.css" type="text/css">
 	</head>
	<body>
		<br />
		<div class="container-flucid">
			<div class="row">
				<div class="col-lg-12 bg-dark" Style="padding-bottom: 0px">
					<ul class="list-inline text-center">
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.MTC%>/</a></li>
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.PP%>/</a></li>
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.OTC%></a></li>
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.TC%></a></li>
					</ul>
				</div>
				<div class="col-lg-12 text-center text-white bg-dark"
					Style="padding-top: 0px">
					<%=Information.Browser%>
				</div>
			</div>
		</div>
	
	</body>
</html>