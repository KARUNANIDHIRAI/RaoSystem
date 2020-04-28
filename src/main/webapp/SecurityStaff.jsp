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
  		<script type="text/javascript" src="webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="webjars/popper.js/1.14.3/popper.js"></script>
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
		<form>
			<div class="row">
			    <div class="col-xs-12">
			    	<div class="card" style="width:72rem;">
			    		<div class="card-header text-center bg-primary text-light" style="max-height:45px;padding top:0px">
			    			<h3 class="card-title text-center"><%=Information.SecurityStaffInfo%></h3>			
			    		</div>
			    	</div>
					<div id="accordion">
  						<div class="card">
    						<div class="card-header" id="headingOne">
      							<h5 class="mb-0">
        							<button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        							 	<%=Information.PersonalDetail%>
        							</button>
      							</h5>
    						</div>
    						<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      							<div class="card-body bg-light">
									<div class="form-row ">
   										<div class="col-lg-4 offset-sm-1">
     										 <label class="form-control-sm" for="inputName"><%=Information.fname%></label>
      										 <input type="text" class="form-control " id="inputFName" name="inputFName" placeholder="" required>
  										</div>
  										<div class="col-lg-3 offset-sm-0">
  											<label class="form-control-sm" for="inputName"><%=Information.lname%></label>
      										 <input type="text" class="form-control " id="inputLName" name="inputLName" placeholder="" >
										</div>
										<div class="form-group col-lg-2 offset-sm-1">
		      								<label for="inputGender"><%=Information.gender%></label>
		      								<select id="inputGender" name="inputGender" class="form-control  form-control-sm">
		        								<option selected>Male</option>
		        								<option>Female</option>
		        								<option>Transg</option>
		      								</select>
		    							</div>
 									</div>
 									<br/>
									<div class="form-row">
    									<div class="form-group col-lg-3 offset-sm-1">
    										<label for="inputEmail4"><%=Information.email%></label>
     										<input type="email" class="form-control " id="inputEmail4" name="inputEmail4" placeholder="email@example.com" 
   											data-toggle="tooltip" data-placement="top" title="We'll never share your email with anyone else." required>
   										</div>
   										<div class="form-group col-lg-3 ">
     										<label for="inputMobile"><%=Information.mobile%></label>
      										 <input type="text" class="form-control " id="inputMobile" name="inputMobile" placeholder="" required>
  										</div>
  										<div class="form-group col-lg-2">
      										<label for="inputAadharNO."><%=Information.aadhar%></label>
     										<input type="text" class="form-control " id="inputAadharNO." name="inputAadharNO." placeholder="" required>
   										</div>
   										<div class="form-group col-lg-2">
     										 <label for="inputPanCard No."><%=Information.PanNo%></label>
      										 <input type="text" class="form-control " id="inputPanCard No." name="inputPanCard No." placeholder="" reuired>
  										</div>
 									</div>
									<div class="form-row">
 										<div class="col-lg-4 offset-sm-1 h6">
   										 	<label for="inputFName"><%=Information.FatherFName%></label>
    										 <input type="text" class="form-control " id="inputFName" name="inputFName" placeholder="" required>
										</div>
										<div class="col-lg-3 offset-sm-0">
											<label  for="inputLName"><%=Information.lname%></label>
    										 <input type="text" class="form-control " id="inputLName" name="inputLName" placeholder="" >
										</div>
										<div class="form-group col-lg-2 offset-sm-1">
      										<label for="inputFGender"><%=Information.gender%></label>
      											<select id="inputFGender" name="inputFGender" class="form-control ">
        											<option selected>Male</option>
        											<option>Female</option>
        											<option>Transg</option>
      											</select>
    									</div>
									</div>
									<div class="form-row">
  										<div class="form-group col-lg-3 offset-sm-1">
  											<label for="inputFEmail"><%=Information.email%></label>
   											<input type="email" class="form-control " id="inputFEmail" name="inputFEmail" placeholder="email@example.com" 
   											data-toggle="tooltip" data-placement="top" title="Tooltip on top" required>
   											<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 										</div>
 										<div class="form-group col-lg-3 offset-sm-1">
   											<label for="inputFMobile"><%=Information.mobile%></label>
    										 <input type="text" class="form-control " id="inputFMobile" name="inputFMobile" placeholder="" required>
										</div>
										<div class="form-group col-lg-2 offset-sm-1">
    										<label for="inputFAadharNO."><%=Information.aadhar%></label>
   											<input type="text" class="form-control " id="inputFAadharNO." name="inputFAadharNO." placeholder="" required>
 										</div>
									</div>
    							</div>
  							</div>
  						</div>
  						<div class="card">
    						<div class="card-header" id="headingTwo">
       							<button class="btn btn-link collapsed h5" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
   									<%=Information.Address%>
       							</button>
    						</div>
    						<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      							<div class="card-body bg-light">
       								<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputPAddress" class="h6"><%= Information.paddress%></label>
   										 	<input type="text" class="form-control  form-control-sm" id="inputPAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" name="inputPAddress">
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputBlock" placeholder="" name="inputBlock">
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputSector"><%= Information.sector%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputSector" placeholder="" name="inputSector">
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputCity"><%= Information.city%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputCity" name="inputCity">
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputState"><%= Information.state%></label>
	      										<select id="inputState" name="inputState"class="form-control  form-control-sm">
	        										<option selected>Choose...</option>
	        										<option>...</option>
	      										</select>
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputCountry"><%= Information.country%></label>
	      									<select id="inputCountry" name="inputCountry"class="form-control  form-control-sm">
	        									<option selected>Choose...</option>
	        									<option>...</option>
	      									</select>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputpincode" name="inputpincode">
    									</div>
									</div>

      								<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputCAddress" class="h6"><%= Information.caddress%></label>
   										 	<input type="text" class="form-control  form-control-sm" id="inputCAddress" name="inputCAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" >
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputCBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputCBlock" placeholder="" name="inputCBlock">
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputCSector"><%= Information.sector%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputCSector" placeholder="" name="inputCSector">
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputCCity"><%= Information.city%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputCCity" name="inputCCity">
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputCState"><%= Information.state%></label>
	      										<select id="inputCState" name="inputCState"class="form-control  form-control-sm">
	        										<option selected>Choose...</option>
	        										<option>...</option>
	      										</select>
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputCCountry"><%= Information.country%></label>
	      									<select id="inputCCountry" name="inputCCountry"class="form-control  form-control-sm">
	        									<option selected>Choose...</option>
	        									<option>...</option>
	      									</select>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputCPincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputCPincode" name="inputCPincode">
    									</div>
									</div>
								</div>
   							</div>
  						</div>
  						<div class="card">
    						<div class="card-header" id="headingThree">
        						<button class="btn btn-link collapsed h6" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          							<%= Information.EXOrgaDetail%></button>        									
 	  						</div>
    						<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
      							<div class="card-body bg-light">
									<div class="form-row">
  									 	<div class="form-group col-md-4 offset-sm-1 h6">
   										 	<label for="inputPreOrgName"><%= Information.preOrgName%></label>
							 				<input type="text" class="form-control  form-control-sm" id="inputPreOrgName" name="inputPreOrgName" placeholder="" >
  										 </div>
  										 <div class="form-group col-md-3">
   							 				<label for="inputEmpNO"><%= Information.EmplNoLBL%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputEmpNO" name="inputEmpNO" placeholder="" >
  										</div>
  										<div class="form-group col-md-3">
   							 				<label for="inputDesignation"><%= Information.DesignationLBL%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputDesignation" name="inputDesignation" placeholder="" >
  										</div>
 	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-2 offset-sm-1">
      										<label for="inputDateJoin"><%= Information.DOJLBL%></label>
      										<input type="date" class="form-control  form-control-sm" id="inputDateJoin" name="inputDateJoin">
    									</div>
    									<div class="form-group col-md-2 offset-sm-0">
	      									<label for="inputDateRelev"><%= Information.DORLBL%></label>
	      									<input type="date" class="form-control  form-control-sm" id="inputDateRelev" name="inputDateRelev">
	    								</div>
	    								<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputReproting"><%= Information.ReportingLBL%></label>
	      									<input type="text" class="form-control  form-control-sm" id="inputReproting" name="inputReproting">
	    								</div>
	    								<div class="form-group col-md-3 offset-sm-0">
     										<label for="inputRepEmail"><%= Information.email%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputRepEmail" name="inputRepEmail" placeholder="reporting officer Email">
    									</div>
									</div>   
									<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputOAddress" class="h6"><%= Information.OrgAddress%></label>
   										 	<input type="text" class="form-control  form-control-sm" id="inputOAddress" name= "inputOAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" >
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputOBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputOBlock" placeholder="" name="inputOBlock">
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputOSector"><%= Information.sector%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputOSector" placeholder="" name="inputOSector">
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputOCity"><%= Information.city%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputOCity" name="inputOCity">
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputOState"><%= Information.state%></label>
	      									<select id="inputOState" name="inputOState"class="form-control  form-control-sm">
	        									<option selected>Choose...</option>
	        									<option>...</option>
	      									</select>
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputOCountry"><%= Information.country%></label>
	      									<select id="inputOCountry" name="inputOCountry"class="form-control  form-control-sm">
	        									<option selected>Choose...</option>
	        									<option>...</option>
	      									</select>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputOpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputOpincode" name="inputOpincode">
    									</div>
									</div>
								</div>	
							</div>
  						</div>
  						<div class="card">
    						<div class="card-header" id="headingfour">
      							<h5 class="mb-0">
        							<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapsefour" aria-expanded="true" aria-controls="collapsefour">
          									<%= Information.ArmDetails%> </button>       									
      							</h5>
    						</div>
    						<div id="collapsefour" class="collapse" aria-labelledby="headingfour" data-parent="#accordion">
      							<div class="card-body bg-light">
									<div class="form-row">
  									 	<div class="form-group col-md-3 offset-sm-1">
   										 	<label for="inputGunNo"><%= Information.GunNo%></label>
   										 	<input type="text" class="form-control  form-control-sm" id="inputGunNo" name="inputGunNo" placeholder="" >
  										</div>
  										<div class="form-group col-md-3 offset-sm-0">
   							 				<label for="inputGunType"><%= Information.GunType%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputGunType" name="inputGunType" placeholder="" >
  										</div>
  										<div class="form-group col-md-4 offset-sm-0">
   							 				<label for="inputGunMadeCity"><%= Information.GunMadeCity%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputGunMadeCity" name="inputGunMadeCity" placeholder="" >
  										</div>
  									</div>
  									<div class="form-row">
	  									<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputPurchaseFrom"><%= Information.PurchaseFrom%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputPurchaseFrom" name="inputPurchaseFrom">
    									</div>
    									<div class="form-group col-md-3 offset-sm-0 ">
	      									<label for="inputPurchaseYear"><%= Information.PurchaseYear%></label>
	      									<input type="text" class="form-control  form-control-sm" id="inputPurchaseYear" name="inputPurchaseYear">	
	    								</div>
	    								<div class="form-group col-md-4 offset-sm-0">
	      									<label for="inputGunIssuedName"><%= Information.GunIssuedInName%></label>
	      									<input type="text" class="form-control  form-control-sm" id="inputGunIssuedName" name="inputGunIssuedName">
	    								</div>
									</div>
    							</div>
  							</div>
  						</div>
  						<div class="card">
    						<div class="card-header" id="headingFive">
      							<h5 class="mb-0">
        							<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
          								<%= Information.DLDetails%></button>        									
      							</h5>
    						</div>
    						<div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordion">
      							<div class="card-body">
      								<br />
									<div class="form-row">
 										<div class="col-sm-3 offset-sm-1">
   										 	<label for="inputLicenseNO"><%= Information.DlNoLBL%></label>
    										 <input type="text" class="form-control form-control-sm" id="inputLicenseNO" name="inputLicenseNO" placeholder="" required>
										</div>
										<div class="col-sm-3">
											<label for="inputLicenseCity"><%= Information.DLIssueCity%></label>
    										 <input type="text" class="form-control form-control-sm" id="inputLicenseCity" name="inputLicenseCity" placeholder="" >
										</div>
 										<div class="col-sm-2 ">
   										 	<label for="inputLicenseDate"><%= Information.DLIssueDtLBL%></label>
    										 <input type="date" class="form-control form-control-sm" id="inputFName" name="inputLicenseDate" placeholder="" required>
										</div>
										<div class="col-sm-2">
											<label for="inputExpiryDate"><%= Information.DLExpiryDtLBL%></label>
    										 <input type="date" class="form-control form-control-sm" id="inputExpiryDate" name="inputExpiryDate" placeholder="" >
										</div>
									</div>
									<br />
<%-- 					
									<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputRTOAddress" class="h6"><%= Information.DLIssueRTOAddressLBL%></label>
   										 	<input type="text" class="form-control  form-control-sm" id="inputRTOAddress" name= "inputRTOAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" >
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputRTOBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputRTOBlock" name="inputRTOBlock" placeholder="" >
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputRTOSector"><%= Information.sector%></label>
    										<input type="text" class="form-control  form-control-sm" id="inputRTOSector"  name="inputRTOSector" placeholder="">
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputRTOCity"><%= Information.city%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputRTOCity" name="inputRTOCity">
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputRTOState"><%= Information.state%></label>
	      									<select id="inputRTOState" name="inputRTOState"class="form-control  form-control-sm">
	        									<option selected>Choose...</option>
	        									<option>...</option>
	      									</select>
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputRTOCountry"><%= Information.country%></label>
	      									<select id="inputRTOCountry" name="inputRTOCountry"class="form-control  form-control-sm">
	        									<option selected>Choose...</option>
	        									<option>...</option>
	      									</select>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputRTOpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control  form-control-sm" id="inputRTOpincode" name="inputRTOpincode">
    									</div>
									</div>
 --%>						
 								</div>
							</div>
  						</div>
  						<div class="card">
    						<div class="card-header" id="headingSix">
      							<h5 class="mb-0">
        							<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
          								<%= Information.KYCDetails%></button>        									
      							</h5>
    						</div>
    						<div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordion">
      							<div class="card-body bg-light">
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
  									<div class="form-row">
	  									<div class=" offset-sm-5">
	 										<button type="submit" class="btn btn-primary"><%= Information.Submit%></button> 									
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
</html>

