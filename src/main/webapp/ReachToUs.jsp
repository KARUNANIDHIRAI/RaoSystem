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
	   	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
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
		<div class="container" > 
		   	<form id="login" name="login" action="getLoginChecking" method="post" class="form-horizontal" autocomplete="off">
				<div class="row justify-content-md-center">
		    		<div class="col-sm-12"  >
						<div class="card" >
		    				<div class="card-header text-center bg-primary text-light" style="max-height:45px;padding top:0px">
		    					<h5 class="card-title text-center"><%= Information.ReachToUs%></h5>
		    				</div>
		    				<div class="card-body">
								<div class="form-row">
<!-- 									<div class="col-sm-4 offset-sm-1">  -->
<%--      									<label class="form-control-sm" for="inputRno."> <%= Information.RAORegNo%></label> --%>
<!--     									<input type="text" class="form-control form-control-sm" id="inputRno." name="inputRno." placeholder="" required> -->
<!-- 									</div> -->
									<div class="col-sm-3 offset-sm-3">
  										 <label class="form-control-sm" for="inputFName"><%=Information.fname%></label>
   										 <input type="text" class="form-control form-control-sm" id="inputFName" name="inputFName"placeholder="" required>
									</div>
									<div class="col-sm-3">
										<label class="form-control-sm" for="inputName"><%= Information.lname%></label>
   										 <input type="text" class="form-control form-control-sm" id="inputLName" placeholder="" required>
									</div>
								</div>
								<br/>
								<div class="form-row">
  									<div class="form-group col-md-3 offset-sm-3">
    										<label for="inputEmail4"><%= Information.email%></label>
   									<input type="email" class="form-control  form-control-sm" id="inputEmail4" placeholder=<%= Information.EmailId%> required>
   										<small id="emailHelp" class="form-text text-muted"><%=Information.Emailmsg%></small>
 									</div>
 										<div class="form-group col-md-3">
   											 <label for="inputPassword4"><%= Information.Mobile%></label>
    										 <input type="password" class="form-control  form-control-sm" id="inputMobile" placeholder="" required>
									</div>
								</div>
								<div class="form-row">
  								 	<div class="form-group col-md-4 offset-sm-1">
   									 	<label for="inputAddress"><%= Information.Address%></label>
   									 	<input type="text" class="form-control  form-control-sm" id="inputAddress" placeholder="">
  									</div>
 									<div class="form-group col-md-3">
   							 			<label for="inputAddress2"><%= Information.Block%></label>
    									<input type="text" class="form-control  form-control-sm" id="inputBlock" placeholder="">
  									</div>
  									<div class="form-group col-md-3">
   							 			<label for="inputAddress2"><%= Information.Sector%></label>
    									<input type="text" class="form-control  form-control-sm" id="inputSector" placeholder="">
  									</div>
  								</div>
  								<div class="form-row">
    								<div class="form-group col-md-4 offset-sm-1">
      									<label for="inputCity"><%= Information.City%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputCity">
    								</div>
    								<div class="form-group col-md-2 ">
	      								<label for="inputState"><%= Information.State%></label>
	      								<select id="inputState" class="form-control  form-control-sm">
	        								<option selected>Choose...</option>
	        								<option>...</option>
	      								</select>
	    							</div>
									<div class="form-group col-md-2">
	      								<label for="inputState"><%= Information.Coutry%></label>
	      								<select id="inputState" class="form-control  form-control-sm">
	        								<option selected>Choose...</option>
	        								<option>...</option>
	      								</select>
	    							</div>
	    							<div class="form-group col-md-2 ">
     									<label for="inputZip"><%= Information.PinCode%></label>
      									<input type="text" class="form-control  form-control-sm" id="inputpincode">
    								</div>
								</div>
<!-- 								 <div class="form-row"> -->
<!-- 	    							<div class="form-group col-md-2 offset-sm-1"> -->
<%--      									<label for="inputZip"><%= Information.PinCode%></label> --%>
<!--       									<input type="text" class="form-control  form-control-sm" id="inputpincode"> -->
<!--     								</div> -->
<!-- 								</div> -->
									<br />
									<hr class="h3">
  								<div class="form-row">
	  								<div class=" offset-sm-5 col-sm2">
	 								<button type="submit" class="btn btn-warning"><%= Information.Submit%></button> 									
	  								</div>
 								</div>
 								<br/>
							</div>
 						</div>
		 			</div>
		 		</div>
			</form>
		</div>
			<br/>
		<div class ="container bg-light text-dark" >  
			<div class="row">
				<div class="col-sm-6">
		    		<div class="card text-center">
		      			<div class="card-body">
		        			<h5 class="card-title"><%= Information.FooterHeadLine1%></h5>
		        			<p class="card-text"><%= Information.FooterHeadLine2%> <a href=<%= Information.EmailId%> target="_blank"><%= Information.EmailId%></a> </p>
		        			<p class="card-text"> <%= Information.FooterHeadLine3%> <small><%= Information.FooterHeadLine4%> , <%= Information.EmailId%>,</small><%= Information.FooterHeadLine5%></p>
		        			<a href="#" class="btn btn-primary">Go somewhere</a>
		      			</div>
		    		</div>
				</div>
		  		<div class="col-sm-6">
		  			<div class="card text-center">
		      			<div class="card-body">
		        			<h5 class="card-title"><%= Information.GloalResponsibility%></h5>
		        			<p class="card-text"><%= Information.CompanyName%> is committed to operating its business with the goal of creating value for all our stakeholders. Our sustainability strategy focuses on social, environmental, and economic responsibility.</p>
		        			<a href="#" class="btn btn-primary">Go somewhere</a>
		      			</div>
		    		</div>
		  		</div>
			</div>		
		</div>
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
	</body>
</html>

