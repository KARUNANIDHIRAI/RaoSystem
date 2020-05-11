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
<!-- Page Body Information -->

			<div class="container" > 
				<form>
					<div class="row justify-content-md-center">
			    		<div class="col-xs-12"  >
							<div class="card" style="width:70rem;">
			    				<div class="card-header text-center bg-primary text-light" style="max-height:45px;padding top:0px">
			    					<h3 class="card-title text-center"><%=Information.UserReg%></h3>
			    				</div>
			    				<div class="card-body bg-light text-dark">
									<div class="form-row">
										<div class="col-lg-4 offset-sm-1">
     										 <label  for="inputName"><%=Information.fname%></label>
      										 <input type="text" class="form-control " id="inputFName" name="inputFName" placeholder="" required>
  										</div>
  										<div class="col-lg-4 offset-sm-0">
  											<label  for="inputName"><%=Information.lname%></label>
      										 <input type="text" class="form-control " id="inputLName" name="inputLName" placeholder="" >
										</div>
										<div class="form-group col-lg-2 offset-sm-0">
      										<label for="inputGender"><%=Information.gender%></label>
      										<select id="inputGender" name="inputGender" class="form-control  ">
        										<option selected>Male</option>
        										<option>Female</option>
        										<option>Transg</option>
      										</select>
		    							</div>
 									</div>
   									<div class="form-row">
 										<div class="form-group col-lg-4 offset-sm-1">
    										<label for="inputMobile"><%=Information.mobile%></label>
     									 	<input type="text" class="form-control " id="inputMobile" name="inputMobile" placeholder="" required>
 										</div>
   										<div class="form-group col-lg-4 offset-sm-0">
   											<label for="inputRwaRegNo"><%=Information.RAORegNo%></label>
    										<input type="text" class="form-control " id="inputRwaRegNo" name="inputRwaRegNo" placeholder="" data-toggle="tooltip"  data-placement="bottom" required>
  										</div>
										<div class="form-group col-lg-2 offset-sm-0">
      										<label for="inputUserType"><%=Information.UserType%></label>
      										<select id="inputUserType" name="inputUserType" class="form-control  ">
        										<option selected>Super User</option>
        										<option>Admin User</option>
        										<option>Site User</option>
      										</select>
		    							</div>
  											
 									</div>
									<div class="form-row">
										<div class="form-group col-lg-4 offset-sm-4">
     										<label for="inputUserID"><%=Information.UserID%></label>
    										<input type="email" class="form-control " id="inputUserID" name="inputUserID" placeholder="UserID would be your EmailID" title="We'll never share your email with anyone else." required>
  										</div>
 									</div>
									<div class="form-row">
   										<div class="form-group col-lg-4 offset-sm-4">
     										 <label for="inputPassword"><%=Information.Password%></label>
      										 <input type="password" class="form-control " id="inputPassword" name="inputPassword" placeholder="" 
      										  data-toggle="tooltip" data-placement="top" 
      										  title="Must contain at least one number and one uppercase and lowercase letter,  and at least 8 and max 15 characters" required>
  										</div>
 									</div>
									<div class="form-row">
  										<div class="form-group col-lg-4 offset-sm-4">
     										 <label for="inputSecurityCode"><%=Information.SecCode%></label>
      										 <input type="text" class="form-control " id="inputSecurityCode" name="inputSecurityCode" placeholder="Any 4-5digit no." required>
  										</div>
 									</div>
 									<div class="form-row">
										<div class="offset-sm-1">
											<p>
  											<a class="btn btn-primary " data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    										<%= Information.Address%>[+]</a>
  										</p>
  										
										</div>
 									</div>
  									<div class="collapse " id="collapseExample">
 										<div class="form-row">
  									 		<div class="form-group col-lg-5 offset-sm-1">
   										 		<label for="inputAddress"><%= Information.Address%></label>
   										 		<input type="text" class="form-control " id="inputAddress" name="inputAddress" placeholder="flat No/floor no / appartment name" >
  											</div>
  							
 											<div class="form-group col-lg-2 offset-sm-1">
   							 					<label for="inputBlock"><%= Information.Block%></label>
    											<input type="text" class="form-control " id="inputBlock" placeholder="" name="inputBlock">
  											</div>
  										
  											<div class="form-group col-lg-2 offset-sm-0">
   							 					<label for="inputSector"><%= Information.sector%></label>
    											<input type="text" class="form-control " id="inputSector" placeholder="" name="inputSector">
  											</div>
	  									</div>
	  									<div class="form-row">
    										<div class="form-group col-lg-5 offset-sm-1">
      											<label for="inputCity"><%= Information.city%></label>
      											<input type="text" class="form-control " id="inputCity" name="inputCity">
    										</div>

    										<div class="form-group col-lg-4 offset-sm-1">
	      										<label for="inputState"><%= Information.state%></label>
	      										<select id="inputState" name="inputState"class="form-control">
	        										<option selected>Choose...</option>
	        										<option>...</option>
	      										</select>
	    									</div>
										</div>
										 <div class="form-row">
										 	<div class="form-group col-lg-3 offset-sm-1">
	      										<label for="inputCountry"><%= Information.country%></label>
	      										<select id="inputCountry" name="inputCountry"class="form-control">
	        										<option selected>Choose...</option>
	        										<option>...</option>
	      										</select>
	    									</div>
	    									<div class="form-group col-lg-2 offset-sm-3">
     											<label for="inputpincode"><%= Information.pinCode%></label>
      											<input type="text" class="form-control " id="inputpincode" name="inputpincode">
    										</div>
										</div>
                                       	<div class="form-row">
	  										<div class=" offset-sm-5">
	 											<button type="submit" class="btn btn-primary"><%= Information.Submit%></button> 									
	  										</div>
 										</div>
	                      			</div>
	 							</div>
		 					</div>
		 				</div>
		 			</div>
		 		</form>
		 	</div>

<!-- Page Footer Information -->
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
		<div class="container-flucid" > 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 bg-dark" Style="padding-bottom:0px"> 
	                <ul class="list-inline text-center" >
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.MTC%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.PP%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.OTC%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.TC%> </a> </li>
	                </ul>
	        	</div>
				<div class="col-lg-12 text-center text-white bg-dark" Style="padding-top:0px"> 
		        	<%= Information.Browser%>
           		</div>
			</div>
		</div>

	</body>
</html>