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

		<div class="container-flucid" data-spy="affix" data-offset-top="50"> 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px"> 
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


		<%-- <div class="container" > 
			<div class="row justify-content-md-center" >
 				<div class="col-sm-8">

					<div class="form-group row ">
	 				 	<label class="control-label col-sm-12 text-right" >
	 				 	<a href="HomePage.jsp " class="bg-dark text-white" data-toggle="tooltip" title="click to Go Home Page"><%= Information.home%></a>
	 				 	</label>
					</div>
					<div class="card-group">
		    		    <div class="card ">
							<div class="card-header bg-primary text-white text-center" style="max-height: 60px; padding-top:0px; padding-bottom:0px;" >
				    			<h5 class="card-title"><%= Information.LoginTitle%></h5>
				    			<p><%= Information.LoginTitle1%></p>
						  	</div>
						</div>
					</div>
	       		</div>
           	</div>
		</div> --%>

	
		<div class ="container" >  
			<div class="row justify-content-md-center">
<!-- 					  <img src="..." class="card-img" alt="..."> -->
					  <br />
				<div class="card bg-secondary text-white row col-xl-10 text-right" style="max-height: 60px; padding-top:0px; padding-bottom:0px;background:linear-gradient(to right, #020024, #793909, #00a0ff); color:white">
					    <h5 class="card-title"><%= Information.contacTitles%></h5>
				</div>	

				<div class="card-group">
			    	<div class="card text-center col-sm-6">
<!-- 				    	<img src="images/emailContact.png" class="card-img-top" alt="..."> -->
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.contacThruSMS%></h5>
			        		<p class="card-text"> <%= Information.ContTele%></p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
			  		<div class="card text-center col-sm-6">
<!-- 				    	<img src="images/telephoneCall.png" class="card-img-top" alt="..." > -->
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.contacThruTel%></h5>
			        		<p class="card-text"><%= Information.ContTele%> </p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
					</div>
			  		<div class="card text-center col-sm-6">
<!-- 				    	<img src="images/address.png" class="card-img-top" alt="..."> -->
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.contacThruEmail%></h5>
			        		<p class="card-text"><%= Information.ContEmail%> <a href=<%= Information.EmailId%> ><%= Information.EmailId%></a> </p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
			    	
			  		<div class="card text-center col-sm-6">
<!-- 				    	<img src="images/sms.png" class="card-img-top" alt="..."> -->
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.contacThruAddress%></h5>
			        		<p class="card-text"><%=Information.CompanyName%></p>
			        		<p> <%= Information.ContAdd%> </p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>

				</div>	
			</div>		
		</div>






 		<br />
		<div class ="container-flucid bg-dark" >  
			<div class="row ">
				<div class="card-group text light">
			    	<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.FooterHeadLine1%></h5>
			        		<p class="card-text"><%= Information.FooterHeadLine2%> <a href=<%= Information.EmailId%> target="_blank"><%= Information.EmailId%></a> </p>
			        		<p class="card-text"> <%= Information.FooterHeadLine3%> <small><%= Information.FooterHeadLine4%> , <%= Information.EmailId%>,</small	><%= Information.FooterHeadLine5%></p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
			  		<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.GloalResponsibility%></h5>
			        		<p class="card-text"><%= Information.CompanyName%> is committed to operating its business with the goal of creating value for all our stakeholders. Our sustainability strategy focuses on social, environmental, and economic responsibility.</p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
				 </div>	
			</div>		
		</div>
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


		<!-- style="background-color:#0085be; color:#fff" -->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#showPasswd").hover(
				function functionName() {
			    	$("#passwd").attr("type", "text");
			    	$(".glyphicon").$(this)
			      	.removeClass("glyphicon-eye-open")
			      	.addClass("glyphicon-eye-close");
			  	},
			  	function() {
				    $("#passwd").attr("type", "password");
				    $(".glyphicon").$(this)
				     .removeClass("glyphicon-eye-close")
				    .addClass("glyphicon-eye-open");
				  }
			);
		
			$('[data-toggle="tooltip"]').tooltip();
			 
		});
	</script>
		
		
		
	</body>
</html>




 
 