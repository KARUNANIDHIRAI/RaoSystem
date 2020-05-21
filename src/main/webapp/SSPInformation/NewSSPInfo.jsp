<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="css/Custom.css" type="text/css">
   		<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
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
	<!-- Body -->
	<div class="container"> 

		   	<form id="SSPNEW" name="SSPNEW" action="../SSPInfoCheck" method="post" class="form-signin form-horizontal needs-validation" autocomplete="off">		
			<div class="row">
			    <div class="col-xs-12">
			    	<div class="card" style="width:72rem;">
			    		<div class="card-header text-center bg-primary text-light" style="max-height:60px;padding top:0px">
			    			<h5 class="card-title text-center"><%=Information.SecurityStaffInfo%></h5>			
			    		</div>
			    	</div>
					<div id="accordion">
  						<div class="card">
    						<div class="card-header bg-primary text-white" id="headingOne">
  								<ul class="nav nav-tabs card-header-tabs ">
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> <a class="nav-link active text-dark " href="#">SSP Information</a> </li>
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> <a class="nav-link text-light" href="#">Address Details</a> </li>
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree"> <a class="nav-link text-light" href="#">Last Employer </a> </li>
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive"> <a class="nav-link text-light" href="#">Driving License </a> </li>
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour"> <a class="nav-link text-light" href="#">Arms License</a> </li>
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" aria-controls="collapseSix"> <a class="nav-link text-light" href="#">KYC Dcos.</a> </li>
					      			<li class="nav-item " data-toggle="collapse " data-target=".multi-collapse" aria-expanded="true" aria-controls="collapseOne collapseTwo collapseThree collapseFour collapseFive"> <a class="nav-link text-light" href="#">Preview Information</a> </li>
	    						</ul>
 
    						</div>
     						<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      							<div class="card-body " style="background-color:#EFEBE9  ;" >
									<div class="form-row ">
   										<div class="col-lg-4 offset-sm-1">
     										 <label for="inputName"><%=Information.fname%></label>
      										 <input type="text" class="form-control is-invalid" id="inputFName" name="inputFName" placeholder=""  required>
  										</div>
  										<div class="col-lg-3 offset-sm-0">
  											<label  for="inputName"><%=Information.lname%></label>
      										 <input type="text" class="form-control is-invalid" id="inputLName" name="inputLName" placeholder=""  >
										</div>
										<div class="form-group col-lg-3 offset-sm-0">
		      								<label for="inputGender"><%=Information.gender%></label>
		      								<select id="inputGender" name="inputGender" class="form-control is-invalid">
		        								<option selected>Male</option>
		        								<option>Female</option>
		        								<option>Transg</option>
		      								</select>
		    							</div>
 									</div>
 
 									<div class="form-row ">
   										<div class="col-lg-4 offset-sm-1">
     										 <label for="inputDOB"><%=Information.dob%></label>
      										 <input type="date" class="form-control is-invalid" id="inputDOB" name="inputDOB" placeholder=""  required>
  										</div>
   										<div class="form-group col-lg-3">
     										 <label for="inputPanCardNo"><%=Information.PanNo%></label>
      										 <input type="text" class="form-control is-invalid " id="inputPanCardNo" name="inputPanCardNo" placeholder=""  required>
  										</div>
 									</div>

 									<div class="form-row">
    									<div class="form-group col-lg-4 offset-sm-1">
    										<label for="inputEmail4"><%=Information.email%></label>
     										<input type="email" class="form-control is-invalid" id="inputEmail4" name="inputEmail4" placeholder="email@example.com"  
   											data-toggle="tooltip" data-placement="top" title="We'll never share your email with anyone else." required>
   										</div>
   										<div class="form-group col-lg-3 ">
     										<label for="inputMobile"><%=Information.mobile%></label>
      										 <input type="text" class="form-control is-invalid" id="inputMobile" name="inputMobile" placeholder=""  required>
  										</div>
  										<div class="form-group col-lg-3">
      										<label for="inputAadharNO"><%=Information.aadhar%></label>
     										<input type="text" class="form-control is-invalid" id="inputAadharNO" name="inputAadharNO" placeholder=""  required>
   										</div>
 									</div>
									<br/>
									<div class="form-row">
 										<div class="col-lg-4 offset-sm-1 h6">
   										 	<label for="inputFFName"><%=Information.FatherFName%></label>
    										 <input type="text" class="form-control is-invalid" id="inputFFName" name="inputFFName" placeholder=""  required>
										</div>
										<div class="col-lg-3 offset-sm-0 h6">
											<label  for="inputFLName"><%=Information.lname%></label>
    										 <input type="text" class="form-control is-invalid" id="inputFLName" name="inputFLName" placeholder=""  >
										</div>
										<div class="form-group col-lg-3 offset-sm-0 h6">
      										<label for="inputFGender"><%=Information.gender%></label>
      											<select id="inputFGender" name="inputFGender" class="form-control is-invalid">
        											<option selected>Male</option>
        											<option>Female</option>
        											<option>Transg</option>
      											</select>
    									</div>
									</div>
									<div class="form-row">
  										<div class="form-group col-lg-4 offset-sm-1">
  											<label for="inputFEmail"><%=Information.email%></label>
   											<input type="email" class="form-control " id="inputFEmail" name="inputFEmail" placeholder="email@example.com" 
   											data-toggle="tooltip" data-placement="top" title="Tooltip on top"  required>
   											<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 										</div>
 										<div class="form-group col-lg-3 offset-sm-0">
   											<label for="inputFMobile"><%=Information.mobile%></label>
    										 <input type="text" class="form-control " id="inputFMobile" name="inputFMobile" placeholder=""  required>
										</div>
										<div class="form-group col-lg-3 offset-sm-0">
    										<label for="inputFAadharNO"><%=Information.aadhar%></label>
   											<input type="text" class="form-control " id="inputFAadharNO" name="inputFAadharNO" placeholder=""  required>
 										</div>
									</div>
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control bg-primary text-white" id="cont01" name = "cont01" 
									      	data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo" >Continue... </button>
									    </div>
								  	</div>

    							</div>
  							</div>
  						</div> 
  						<div class="card" id="Address">
  							<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      							<div class="card-body " style="background-color:#EFEBE9  ;">
       								<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputPAddress" class="h6"><%= Information.paddress%></label>
   										 	<input type="text" class="form-control  is-invalid " id="inputPAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" 
   										 	name="inputPAddress" >
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control   " id="inputBlock" placeholder="" name="inputBlock"	>
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputSector"><%= Information.sector%></label>
    										<input type="text" class="form-control   " id="inputSector" placeholder="" name="inputSector" >
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputCity"><%= Information.city%></label>
      										<input type="text" class="form-control  is-invalid " id="inputCity" name="inputCity" >
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputState"><%= Information.state%></label>
	      										<input type="text" class="form-control is-invalid  " id="inputState" name="inputState" >

	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputCountry"><%= Information.country%></label>
	      										<input type="text" class="form-control  is-invalid " id="inputCountry" name="inputCountry" >
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control   " id="inputpincode" name="inputpincode" value=<%=session.getAttribute("inputPPincode") %>>
    									</div>
									</div>

      								<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputCAddress" class="h6"><%= Information.caddress%></label>
   										 	<input type="text" class="form-control   " id="inputCAddress" name="inputCAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO">
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputCBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control   " id="inputCBlock" placeholder="" name="inputCBlock" >
    											
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputCSector"><%= Information.sector%></label>
    										<input type="text" class="form-control   " id="inputCSector" placeholder="" name="inputCSector" >
    										
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputCCity"><%= Information.city%></label>
      										<input type="text" class="form-control   " id="inputCCity" name="inputCCity" >
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">

	      									<label for="inputCState"><%= Information.state%></label>
      										<input type="text" class="form-control " id="inputCState" name="inputCState" >
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputCCountry"><%= Information.country%></label>
      										<input type="text" class="form-control " id="inputCCountry" name="inputCCountry" >
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputCPincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control   " id="inputCPincode" name="inputCPincode">
      										  	
    									</div>
									</div>
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control bg-primary text-white" id="cont02" name = "cont02" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree" >Continue... </button>
									    </div>
								  	</div>

								</div>
   							</div>
  						</div>
  						<div class="card" id="Employer">
    						<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
      							<div class="card-body " style="background-color:#EFEBE9  ;">
									<div class="form-row">
  									 	<div class="form-group col-md-4 offset-sm-1 h6">
   										 	<label for="inputPreOrgName"><%= Information.preOrgName%></label>
							 				<input type="text" class="form-control   " id="inputPreOrgName" name="inputPreOrgName" placeholder="" >
							 					
  										 </div>
  										 <div class="form-group col-md-3">
   							 				<label for="inputEmpNO"><%= Information.EmplNoLBL%></label>
    										<input type="text" class="form-control   " id="inputEmpNO" name="inputEmpNO" placeholder="" >
  										</div>
  										<div class="form-group col-md-3">
   							 				<label for="inputDesignation"><%= Information.DesignationLBL%></label>
    										<input type="text" class="form-control   " id="inputDesignation" name="inputDesignation" placeholder="">
  										</div>
 	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-2 offset-sm-1">
      										<label for="inputDateJoin"><%= Information.DOJLBL%></label>
      										<input type="date" class="form-control   " id="inputDateJoin" name="inputDateJoin" >
    									</div>
    									<div class="form-group col-md-2 offset-sm-0">
	      									<label for="inputDateRelev"><%= Information.DORLBL%></label>
	      									<input type="date" class="form-control   " id="inputDateRelev" name="inputDateRelev" >
	    								</div>
	    								<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputReproting"><%= Information.ReportingLBL%></label>
	      									<input type="text" class="form-control   " id="inputReproting" name="inputReproting">
	    								</div>
	    								<div class="form-group col-md-3 offset-sm-0">
     										<label for="inputRepEmail"><%= Information.email%></label>
      										<input type="text" class="form-control   " id="inputRepEmail" name="inputRepEmail" placeholder="reporting officer Email">
    									</div>
									</div>   
									<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputOAddress" class="h6"><%= Information.OrgAddress%></label>
   										 	<input type="text" class="form-control   " id="inputOAddress" name= "inputOAddress"
   										 	 placeholder="Flat NO/ Floor no/ Apartment / towerNO" >
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputOBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control   " id="inputOBlock" placeholder="" name="inputOBlock">
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputOSector"><%= Information.sector%></label>
    										<input type="text" class="form-control" id="inputOSector" placeholder="" name="inputOSector" >
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputOCity"><%= Information.city%></label>
      										<input type="text" class="form-control   " id="inputOCity" name="inputOCity" >
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputOState"><%= Information.state%></label>
     										<input type="text" class="form-control   " id="inputOState" name="inputOState" >
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputOCountry"><%= Information.country%></label>
     										<input type="text" class="form-control   " id="inputOCountry" name="inputOCountry" >
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputOpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control   " id="inputOpincode" name="inputOpincode" >
    									</div>
									</div>
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control bg-primary text-white" id="cont03" name = "cont03" 
									      	data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour" >Continue... </button>
									    </div>
								  	</div>

								</div>	
							</div>
  						</div>
  						<div class="card" id="Arms">
     						<div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordion">
      							<div class="card-body" style="background-color:#EFEBE9  ;">
									<div class="form-row">
  									 	<div class="form-group col-md-3 offset-sm-1">
   										 	<label for="inputGunNo"><%= Information.GunNo%></label>
   										 	<input type="text" class="form-control   " id="inputGunNo" name="inputGunNo" placeholder="">
  										</div>
  										<div class="form-group col-md-3 offset-sm-0">
   							 				<label for="inputGunType"><%= Information.GunType%></label>
    										<input type="text" class="form-control   " id="inputGunType" name="inputGunType" placeholder="" >
  										</div>
  										<div class="form-group col-md-4 offset-sm-0">
   							 				<label for="inputGunMadeCity"><%= Information.GunMadeCity%></label>
    										<input type="text" class="form-control   " id="inputGunMadeCity" name="inputGunMadeCity" placeholder="" >
  										</div>
  									</div>
  									<div class="form-row">
	  									<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputPurchaseFrom"><%= Information.PurchaseFrom%></label>
      										<input type="text" class="form-control   " id="inputPurchaseFrom" name="inputPurchaseFrom" >
    									</div>
    									<div class="form-group col-md-3 offset-sm-0 ">
	      									<label for="inputPurchaseYear"><%= Information.PurchaseYear%></label>
	      									<input type="text" class="form-control   " id="inputPurchaseYear" name="inputPurchaseYear">
	    								</div>
	    								<div class="form-group col-md-4 offset-sm-0">
	      									<label for="inputGunIssuedName"><%= Information.GunIssuedInName%></label>
	      									<input type="text" class="form-control   " id="inputGunIssuedName" name="inputGunIssuedName">
	    								</div>
									</div>
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control bg-primary text-white" id="cont04" name = "cont04" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive" >Continue... </button>
									    </div>
								  	</div>

    							</div>
  							</div>
  						</div>
  						<div class="card" id="DLInfo">

    						<div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordion">
      							<div class="card-body" style="background-color:#EFEBE9  ;">
      								<br />
									<div class="form-row">
 										<div class="col-sm-3 offset-sm-1">
   										 	<label for="inputLicenseNO"><%= Information.DlNoLBL%></label>
    										 <input type="text" class="form-control  " id="inputLicenseNO" name="inputLicenseNO" placeholder="" >
										</div>
										<div class="col-sm-3">
											<label for="inputLicenseCity"><%= Information.DLIssueCity%></label>
    										 <input type="text" class="form-control  " id="inputLicenseCity" name="inputLicenseCity" placeholder="" >
										</div>
 										<div class="col-sm-2 ">
   										 	<label for="inputLicenseDate"><%= Information.DLIssueDtLBL%></label>
    										 <input type="date" class="form-control  " id="inputLicenseDate" name="inputLicenseDate" placeholder="" >
										</div>
										<div class="col-sm-2">
											<label for="inputExpiryDate"><%= Information.DLExpiryDtLBL%></label>
    										 <input type="date" class="form-control  " id="inputExpiryDate" name="inputExpiryDate" placeholder="" >
										</div>
									</div>


 <%--      								<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputDLAddress" class="h6"><%= Information.Address%></label>
   										 	<input type="text" class="form-control   " id="inputDLAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" 
   										 	name="inputDLAddress" value=<%=session.getAttribute("inputDLAddress") %>>
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputDLBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control   " id="inputDLBlock" placeholder="" name="inputDLBlock"
    											value=<%=session.getAttribute("inputDLBlock") %>>
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputDLSector"><%= Information.sector%></label>
    										<input type="text" class="form-control   " id="inputDLSector" placeholder="" name="inputDLSector" 
    											value=<%=session.getAttribute("inputDLSector") %>>
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputDLCity"><%= Information.city%></label>
      										<input type="text" class="form-control   " id="inputDLCity" name="inputDLCity" 
      											value=<%=session.getAttribute("inputDLCity") %>>
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputDLState"><%= Information.state%></label>
	      										<select id="inputDLState" name="inputDLState"class="form-control   ">
	        										<option selected value=<%=session.getAttribute("inputDLState") %>><%=session.getAttribute("inputDLState") %></option>
	      										</select>
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputDLCountry"><%= Information.country%></label>
	      									<select id="inputDLCountry" name="inputDLCountry"class="form-control   ">
	        									<option selected value=<%=session.getAttribute("inputDLCountry") %>><%=session.getAttribute("inputDLCountry") %></option>
	        								</select>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputDLpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control   " id="inputDLpincode" name="inputDLpincode" value=<%=session.getAttribute("inputPPincode") %>>
    									</div>
									</div>
 --%>


									<br />
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control bg-primary text-white" id="cont05" name = "cont05" data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" aria-controls="collapseSix" >Continue... </button>
									    </div>
								  	</div>

 								</div>
							</div>
  						</div>
  						<div class="card" id="KYC">
    						<div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordion">
      							<div class="card-body " style="background-color:#EFEBE9  ;">
      								<div class="form-row">
				 						<div class="form-group col-sm-3 offset-sm-1">
				 							<label for="exampleFormControlFile1"><%= Information.Uploadphoto%></label>
    										<input type="file" class="form-control-file" id="exampleFormControlFile1">
    									</div>
    									<div class="form-group col-sm-3 offset-sm-1">
				 							<label for="exampleFormControlFile1"><%= Information.UploadPanCard%></label>
    										<input type="file" class="form-control-file" id="exampleFormControlFile1">
    									</div>
    									<div class="form-group col-sm-3 offset-sm-1">
				 							<label for="exampleFormControlFile1"><%= Information.UploadDL%></label>
    										<input type="file" class="form-control-file" id="exampleFormControlFile1">
    									</div>
  									</div> 
  									<div class="form-row">
				 						<div class="form-group col-sm-3 offset-sm-1">
				 							<label for="exampleFormControlFile1"><%= Information.UploadAadhar%></label>
    											<input type="file" class="form-control-file" id="exampleFormControlFile1">
    									</div>
    									<div class="form-group col-sm-3 offset-sm-1">
				 							<label for="exampleFormControlFile1"><%= Information.UploadSignature%></label>
    										<input type="file" class="form-control-file" id="exampleFormControlFile1">
    									</div>
  									</div>
									<div class="form-row" id="Final">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="submit" class="form-control bg-primary text-white" id="submit01" name = "submit01"  ><%=Information.Submit %> </button>
									    </div>
								  	</div>
  	
  								</div>
  							</div>
  						</div>
  						<br/>

	  				</div>
				</div>
			</div>
		</form>
	</div>

<!-- Body Footer -->
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

	<script type="text/javascript">
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
		});
	
		$(document).ready(function() {

			
			$('#btnExpandAll').click(function(){
				$('.panel-collapse.collapse').collapse('show');	
			});
			$('#btnCollapseAll').click(function(){
				$('.panel-collapse.collapse').collapse('hide');	
			});

			$('#Address').hide(function(){});
			$('#Employer').hide(function(){});
			$('#Arms').hide(function(){});
			$('#DLInfo').hide(function(){});

			$('#cont01').click(function(){
				$('#Address').show(function(){});
			});
			$('#cont02').click(function(){
				$('#Employer').show(function(){});
			});
			$('#cont03').click(function(){
				$('#Arms').show(function(){});
			});
			$('#cont04').click(function(){
				$('#DLInfo').show(function(){});
			});
			$('#cont05').click(function(){
				$('#KYC').show(function(){});
			});

			
 			
			$('#SameAddress').click(function(event){
	            $('#caddress').val($('#paddress').val()); 
	            $('#cblock').val($('#pblock').val()); 
	            $('#csector').val($('#psector').val()); 
	            $('#ccity').val($('#pcity').val()); 
	            $('#cstate').val($('#pstate').val()); 
	            $('#ccountry').val($('#pcountry').val()); 
	            $('#cpincode').val($('#ppincode').val()); 
				
	            $('#caddress').attr("readonly", "readonly"); 
	            $('#cblock').attr("readonly", "readonly"); 
	            $('#csector').attr("readonly", "readonly"); 
	            $('#ccity').attr("readonly", "readonly"); 
	            $('#cstate').attr("readonly", "readonly"); 
	            $('#ccountry').attr("readonly", "readonly"); 
	            $('#cpincode').attr("readonly", "readonly"); 
			});

			
			$(document).ready(function() {
				// Function to change form action.
				$("#db").change(function() {
					var selected = $(this).children(":selected").text();
					switch (selected) {
					case "My-Sql":
						$("#myform").attr('action', 'mysql.html');
						alert("Form Action is Changed to 'mysql.html'n Press Submit to Confirm");
						break;
					case "Oracle":
						$("#myform").attr('action', 'oracle.html');
						alert("Form Action is Changed to 'oracle.html'n Press Submit to Confirm");
						break;
					case "MS-Access":
						$("#myform").attr('action', 'msaccess.html');
						alert("Form Action is Changed to 'msaccess.html'n Press Submit to Confirm");
						break;
					default:
						$("#myform").attr('action', '#');
					}
				});
			
			
			
 
 
			 $('form[id="HoseMaid"]').validate({
				    rules: {
				      FName: {
					        required: true,
					        minlength: 4,
					        },
					  LName: {
					        required: true,
					        minlength: 3,
					        },
					  EmailId: {
				           required: true,
				           email: true,
				           },
				      MobileNO: {
				           required: true,
				           minlength: 10,
				           },
				      AaDhar: {
				           required: true,
				           minlength: 12,
				           },
				      Dob: {
					       required: true,
					      },
					  FfName: {
					     required: true,
					     minlength: 4,
					     },
					  FLName: {
					    required: true,
					    minlength: 3,
					    },
				      FInitial: {
					     required: true,
					    },
					  PerAddPinCode : {
						  digits :true,
						  minlength: 8,
					  },  
					  CorAddPinCode : {
							  digits :true,
							  minlength: 8,
					  }  

				    },
				  messages: {
					  FName   : 'First Name must be 4 Character long',
					  LName   : 'First Name must be 3 Character long',
			          Initial : 'Initial is Required',
				      EmailId : 'Email ID id Required',
				      MobileNO: 'Mobile No. Must be 10 character long',
			          AaDhar  : 'Aadhar No. Must be 12 character Long',
			          Dob     : 'Date of Birth is Required',
			          FfName  : 'Father First Name must be 5 Character long',
				      FLName  : 'Father Last Name must be 3 Character long',
			          FInitial: 'Initial is Required',
			          PerAddPinCode:'Enter only digits',
			          CorAddPinCode:'Enter only digits',
				  },
				  submitHandler: function(form) {
				      form.submit();
				  }
			});	
			 
					$('#two').addClass("disabled");
		            $('#dis').removeClass("disabled");

		            $("#file").change(function () {
		                filePreview(this);
		            });            
		            $("#file1").change(function () {
		                sigFilePreview(this);
		            });            
		            $("#file2").change(function () {
		                aadFilePreview(this);
		            });            

		            function filePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
/* 		                        $('#uploadForm + img').remove();
		                        $('#uploadForm').after('<img src="'+e.target.result+'" width="90" height="90"/>');
		                        
 */		                      
 							$('#photo')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
	
		            function sigFilePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
		                        $('#Signature')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
		            
		            function aadFilePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
		                        $('#Aadhar')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
			 
		});
</script>

// Function For Back Button
$(".back").click(function() {
parent.history.back();
return false;
});
});

</html>

