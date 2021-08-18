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
		<div class="container-flucid">
			<div class="row">
				<div class="col-lg-12 text-right  margin-left:0px  margin-right:0px" style="background-color:#000080">
					<ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="../RwaHomePage.jsp"> <%= Information.raoHome%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="../UserLogin/UserLogin.jsp"> <%= Information.LogoutTitle%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="../ContactUs/CollaborationEnquiry.jsp"> <%= Information.joinPartner%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="../ContactUs/ContactUsMainPage.jsp"> <%= Information.reachus%> </a> </li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" >
			<div class="row">
                <div class="col-lg-2" > 
 					<img src="../images/KSB.png" class="img-responsive "/>
				</div>
		         <div class="col-lg-5 offset-sm-1" > 
		              <br /> <p class="h6"><%= session.getAttribute("School")== null?"":session.getAttribute("School") %>
				</div>
			</div>
		</div>
	
	</body>
</html>