<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<!-- header 
	1.  FPasswordPartA.jsp : [Servelet]GenOTPmailOTP 
	2.  OTPReceipt.jsp 
	3.  FPasswordPartB.jsp : [Servelet] ProcessNewPassword 
	4.  Passwordmsg.jsp 
-->


<!DOCTYPE html>
<html>
	<!-- header -->
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
	   	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
 	</head>
 	<body>
		<div class="container-flucid">
			<div class="row">
				<div class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px">
					<ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%= Information.raoHome%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="LoginPage.jsp"> <%= Information.LogoutTitle%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-sm-7">
					<img src="images/KSB.png" class="img-responsive " />
				</div>
			</div>
		</div>
<!--boody  -->

		<div class="container" > 
			<form id="PWDreset" name="PWDreset" action="GenOTPmailOTP" method="post" class="form-signin form-horizontal" autocomplete="off" >
				<div class="row justify-content-md-center ">
					<div class="col-sm-12">
						<div class="form-row" >
							<div class="h5 bg-primary col-sm-6 offset-sm-3 "> 
								<h5 class="card-title text-center text-white"><%=Information.FortgetPWDPageTitle%></h5>
							</div>
						</div>
						<div class="form-row" >
							<div class="h5  col-sm-6 offset-sm-3 "> 
					    		<p class="text-danger "><%= session.getAttribute("InvalidFPWDMsg")== null?"":session.getAttribute("InvalidFPWDMsg") %></p>
								<%session.removeAttribute("InvalidFPWDMsg");%>
							</div>
							
						</div>
						<br />
						<div class="form-row " >
							<div class=" form-group col-sm-6 offset-sm-3 h5 ">
								<p class="h5"> <%=Information.ForgotPWDorUserID%></p> 									
							</div>
						</div>
 						<div id="email0" >
							<div class="form-row" id="email1">
 								 <div class="form-group col-sm-4 offset-sm-4  ">
								 	 <label  for="inputEmailID"><%=Information.email%></label>
     								<input type="text" class="form-control " id="inputEmailID" name="inputEmailID" placeholder="" required>
 								</div>
							</div>
							<div class="form-row" id="email1">
 								 <div class="form-group col-sm-4 offset-sm-4  ">
								 	 <label  for="inputRwaRegNo"><%=Information.RAORegNo%></label>
     								<input type="text" class="form-control " id="inputRwaRegNo" name="inputRwaRegNo" placeholder="" required>
 								</div>
							</div>
							<br />
  							<div class="form-row" id="email2">
								<div class=" col-sm-1 offset-sm-5 ">
					        		<p>	<a href="LoginPage.jsp" class="form-control bg-light text-dark  text-center h6 ">Cancel</a> </p>
								</div>
								<div class=" col-sm-1 offset-sm-0">
<%-- 									<button id= "cont01" type="button" class="form-control bg-primary text-white h6 "><%=Information.Next%></button> 									 --%>
				 				 	<input id="" type ="submit" class="form-control input-sm btn btn-primary text-white h6" value="Submit" >
								</div>
							</div>
						</div>
 
					</div>
				</div>	
			</form>
		</div>	
<!-- end of body -->
		<div class="progress">
		  	<div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		  	<div class="progress-bar bg-success" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="progress-bar bg-info" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
			<div class="progress-bar bg-warning" role="progressbar" style="width: 25%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
		</div>

<!-- footer -->
		<div class ="container-flucid bg-dark" >  
			<div class="row ">
				<div class="card-group text light">
			    	<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.FooterHeadLine1%></h5>
			        		<p class="card-text"> <%= Information.GloablfooterLeft%> 
			        		<p>	<a href="#" class="btn btn-primary">Go somewhere</a> </p>
			      		</div>
			    	</div>
			  		<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.GloalResponsibility%></h5>
			        		<p class="card-text"> <%= Information.GloablfooterRight%> 
			        		<p><a href="#" class="btn btn-primary">Go somewhere</a> </p>
			      		</div>
			    	</div>
				 </div>	
			</div>		
		</div>
		<br />
		<br />
		<div class="container-flucid" > 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 bg-dark"> 
	                <ul class="list-inline text-center" >
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.MTC%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.PP%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.OTC%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.TC%> </a> </li>
	                </ul>
	        	</div>
				<div class="col-lg-12 text-center text-white bg-dark"> 
		        	<%= Information.Browser%>
           		</div>
			</div>
		</div>
		
		<script type="text/javascript">
		$(document).ready(function() {
			$('#prog1').hide(function(){});
			$('#prog2').hide(function(){});
			$('#Prog3').hide(function(){});
			$('#Prog4').hide(function(){});

			$('#otp0').hide(function(){});
			$('#resetPWD').hide(function(){});
			$('#cont01').click(function(){
				$('#prog1').show();
			    $("#email0").hide();
			   	$("#otp0").show();
			});
			$('#cont02').click(function(){
				$('#prog2').show();
				$('#email0').hide();
			   	$('#otp0').hide();
			   	$('#resetPWD').show();
			});
			$('#resetPWD').click(function(){
				$('#prog3').show();
				
			});

		});
		</script>
		
	</body>
</html>