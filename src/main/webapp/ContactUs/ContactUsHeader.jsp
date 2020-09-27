<%@page import="com.rao.System.MaintWork.MaintConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
  <style type="text/css"> 
        .dropdown:hover .dropdown-menu { 
            display: block; 
        }    
        #dropdn:hover .dropdown-menu { 
            display: block; 
        } 
    </style>
 	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light col-sm-12">
		  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    	<span class="navbar-toggler-icon"></span>
		  	</button>
			<div class="collapse navbar-collapse col-sm-11  offset-sm-0 bg-light" id="navbarSupportedContent" style="padding-left:0; margin-left:58px; padding-right:58px">
				<ul class="navbar-nav mr-auto">
			      	<li class="nav-item dropdown active">
			        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			        		<%= Information.contactus%>
			        	</a>
						<div class="dropdown-menu "  style ="width:500px;padding-left:20px; margin-bottom:1em" aria-labelledby="navbarDropdown" >
							<div class="row">
								<div class="col-sm-4">
								    <a class="dropdown-item" href="../ContactUs/GeneralEnquiry.jsp">General Enquiry</a>
						      		<a class="dropdown-item" href="../ContactUs/BusinessEnquiry.jsp">Business Enquiry</a>
								    <a class="dropdown-item" href="../ContactUs/ProdDemoEnquiry.jsp">Product Demo Enquiry</a>
								    <a class="dropdown-item" href="../ContactUs/CollaborationEnquiry.jsp">Collaboration Enquiry</a>
						      		<a class="dropdown-item" href="../ContactUs/JobsAndCareers.jsp">Jobs and Careers Enquiry</a>
								    <a class="dropdown-item" href="../ContactUs/ComplianceEnquiry.jsp">Compliance Enquiry</a>
								</div>
						    </div>
						</div>
			      	</li>
				</ul>
			</div>
		</nav>				
	</body>
</html>




























