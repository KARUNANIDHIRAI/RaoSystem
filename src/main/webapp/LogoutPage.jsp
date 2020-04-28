<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="css/Custom.css" type="text/css">
   		<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
   		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>	

	</head>
	<body>
		<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate") ; %>
		<div class="container-flucid" data-spy="affix" data-offset-top="50"> 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px" style="background:linear-gradient(to right, #020024, #793909, #00a0ff); color:white"> 
	                <ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reqdemo%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
	                </ul>
	        	</div>
			</div>
		</div>

		<div class="container" > 
			<div class="row "> 
                <div class="col-lg-7 " > 
 					<img src="images/KSB.png" class="img-responsive "/>
				</div>
				<div class="col-lg-5 text-right text-white"> 
	        	</div>
 			</div>
		</div>
		<br />

		<div class="container" > 
			<div class="row justify-content-md-center" >
 				<div class="col-sm-8">
	    		    <div class="card text-center" >
						<div class="card-header text-white text-center" style="max-height: 70px; padding-top:0px; padding-bottom:0px; background:linear-gradient(to right, #020024, #793909, #00a0ff); color:white" >
			    			<h5 class="panel-title"><%= Information.LogoutTitle%></h5>
					  	</div>
						 <br />
						<div class="card-body">
			        		<h5 class="card-title text-dark"><%= Information.LogoutMsg%></h5>
			        		<br />
			        		<a href="HomePage.jsp" class="btn btn-primary" style="background:linear-gradient(to right, #020024, #793909, #00a0ff); color:white">Go somewhere</a>
			 			</div>	
						 <br />
					</div>
	       		</div>
           	</div>
		</div>

 		<br />
		<div class ="container-flucid bg-dark" >  
			<div class="row ">
				<div class="card-group ">
			    	<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.FooterHeadLine1%></h5>
			        		<p class="card-text"><%= Information.FooterHeadLine2%> <a href=<%= Information.EmailId%> target="_blank"><%= Information.EmailId%></a> </p>
			        		<p class="card-text"> <%= Information.FooterHeadLine3%> <small><%= Information.FooterHeadLine4%> , <%= Information.EmailId%>,</small	><%= Information.FooterHeadLine5%></p>
			        		<a href="#" class="btn btn-secondary text-white">Go somewhere</a>
			      		</div>
			    	</div>
			  		<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.GloalResponsibility%></h5>
			        		<p class="card-text"><%= Information.CompanyName%> is committed to operating its business with the goal of creating value for all our stakeholders. Our sustainability strategy focuses on social, environmental, and economic responsibility.</p>
			        		<a href="#" class="btn btn-secondary text-white">Go somewhere</a>
			      		</div>
			    	</div>
				 </div>	
			</div>		
		</div>
			
		<br />
		<br />

		<div class="container-flucid bg-dark" > 
			<div class="row" >
				<div class="col-sm-12"> 
	    		    <div class="card bg-dark text-white text-center">
					  	<div class="card-body">
			                <ul class="list-inline " >
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.MTC%>/ </a> </li>
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.PP%>/ </a> </li>
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.OTC%> </a> </li>
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.TC%> </a> </li>
			                </ul>
			                <h6><%= Information.Browser%></h6>
					  	</div>
					</div>
	       		</div>
           	</div>
		</div>

		
	</body>
</html>




 
 