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
		                <li class="list-inline-item "><a class="text-light" href="HomePage.jsp"> <%= Information.home%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reqdemo%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
	                </ul>
	        	</div>
			</div>
		</div>

		<div class="container" style="background:0,16,100"> 
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
		   	<form id="login" name="login" action="LoginCheck" method="post" class="form-signin form-horizontal" autocomplete="off">
				<div class="row justify-content-md-center " >
	 				<div class="col-sm-8">

		    		    <div class="card ">
							<div class="card-header bg-primary text-white text-center" style="max-height: 60px; padding-top:0px; padding-bottom:0px;" >
				    			<h5 class="card-title"><%= Information.LoginTitle%></h5>
						  	</div>
 						  	<div class="card-body bg-light">
								<div class="form-row justify-content-md-center" > 
									<div class="form-group col-sm-8 h6">
						    			<p class="text-danger "><%= session.getAttribute("InvalidLoginMsg")== null?"":session.getAttribute("InvalidLoginMsg") %></p>
																<%session.removeAttribute("InvalidLoginMsg");%>
						    			<p class="text-info"><%= Information.LoginTitle1%></p>
										<hr class="bg-warning"/>
									</div>
								</div>	

								<div class="form-row"> 
									<div class="form-group col-sm-2 offset-sm-2">
										<label for="inputLogin" ><%= Information.loginId%></label>
									</div>
									<div class="form-group col-sm-6 offset-sm-0">
				 				 		<input class="form-control input-sm" type ="text" id="inputLogin" name="inputLogin" placeholder=<%= Information.loginId%> autocomplete="off" title="Enter Emailid [Example@yahoo.com]" data-toggle="tooltip" required>
									</div>
								</div>	

								<div class="form-row"> 
									<div class="form-group col-sm-2 offset-sm-2">
										<label for="inputPassword" ><%= Information.loginPwd%></label>
									</div>
									<div class="form-group col-sm-6 offset-sm-0">
							    		<input class="form-control" type="password" id="inputPassword" name ="inputPassword" placeholder=<%= Information.loginPwd%> required>
									</div>
							     	<span class="input-group-btn">
										<button id= "showPasswd" class="btn btn-secondary" type="button" >?	
											<span data-toggle="tooltip" title="click to view Password" ></span>
							       		</button>
							        </span>

								</div>	
								<br />
								<div class="form-row"> 
									<div class="form-group col-sm-2 offset-sm-2">
							 			<label for="txtCaptcha"></label>
									</div>
									<div class="form-group col-sm-2 offset-sm-0  text-center h4">
						 				<img class="text-light" alt="captcha" src="http://localhost:8085/RAOSystem/LoginCheck">
						 			<!-- <img class="text-light" alt="captcha" src="http://localhost:8085/RAOSystem/CaptchServlet"> -->
									</div>
									<div class="form-group col-sm-3 offset-sm-1  text-right text-danger">
						    			<p class="text-danger "><%= session.getAttribute("CaptchaErrMsg")== null?"":session.getAttribute("CaptchaErrMsg") %></p>
																<%session.removeAttribute("CaptchaErrMsg");%>
	 								</div>
								</div>	
								<div class="form-row"> 
									<div class="form-group col-sm-2 offset-sm-2">
						 			<label for="txtCaptcha"><%= Information.loginCaptcha%></label>
									</div>
									<div class="form-group col-sm-6 offset-sm-0">
					 			 		<input class="form-control input-sm" type ="text" id="txtCaptcha" name="txtCaptcha" placeholder=<%= Information.loginCaptcha%> autocomplete="off" >
									</div>
									
								</div>	
								<div class="form-row"> 
									<div class="form-group col-sm-2 offset-sm-6">
				 				 		<input class="form-control input-sm btn btn-warning" type ="submit" value="Submit"  >
									</div>
								</div>	
								<div class="form-row"> 
									<div class="form-group col-sm-6 offset-sm-4">
										<p>	<a href="forgetpwd.jsp" data-toggle="tooltip" title="click to Reset Password"><%= Information.forgetpwd%></a></p>						
										<p>	<%=Information.FirstTimeUser %><a href="UserRegistration.jsp" data-toggle="tooltip" title="click for Registertion"><span class ="h6 col-xs-5"><%= Information.RegisterNow%></span></a> </p>						
									</div>
								</div>	

				 			</div>	
						</div>
		       		</div>
	           	</div>
           	</form>
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
			    	$("#inputPassword").attr("type", "text");
			    	$(".glyphicon").$(this)
			      	.removeClass("glyphicon-eye-open")
			      	.addClass("glyphicon-eye-close");
			  	},
			  	function() {
				    $("#inputPassword").attr("type", "password");
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




 
 