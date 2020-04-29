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
			<form id="login" name="login" action="getLoginChecking" method="post" class="form-horizontal needs-validation" autocomplete="off"  novalidate>
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="accordion" id="accordionDriver">
							<div class="card">
    							<div class="card-header bg-primary"  id="headingOne">
    							
						    		<ul class="nav nav-tabs card-header-tabs nav-tabs nav-fill">
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> <a class="nav-link active text-dark " href="#">Company Info.</a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> <a class="nav-link text-light" href="#">Contact Person Info</a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree"> <a class="nav-link text-light" href="#">Bank Details</a> </li>
					      				<li class="nav-item " data-toggle="collapse " data-target=".multi-collapse" aria-expanded="true" aria-controls="collapseOne collapseTwo collapseThree collapseFour collapseFive"> <a class="nav-link text-light" href="#">Preview Information</a> </li>
	    							</ul>
    							</div>

							    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light">
										<div class="form-row" >
											<br />	
	   										<div class="form-group col-sm-5 offset-sm-1">
	     										 <label   for="inputVenderCompanyName">Supplier Name</label>
	      										 <input type="text" class="form-control " id="inputVenderCompanyName" name="inputVenderCompanyName" placeholder="" required>
	  										</div>
	  										<div class="form-group col-sm-3 offset-sm-0">
	  											<label  for="inputSupplierType">Supplier Type</label>
	      								    	<select class="form-control" id="inputSupplierType" name="inputSupplierType">
											    	<option>Select Supplier</option>
											    	<option>Water Tanker</option>
											      	<option>Diesel </option>
											      	<option>Electrical Spare Part</option>
											      	<option>Home Appliances</option>
											      	<option>Stationary</option>
											    </select>
											</div>

	  										<div class="form-group col-sm-2 offset-sm-0">
	  											<label  for="inputGSTNo">GST No</label>
	      										 <input type="email" class="form-control" id="inputGSTNo" name="inputGSTNo" placeholder="" >
											</div>
										</div>
										<div class="form-row ">
	  										<div class="form-group col-sm-4 offset-sm-1">
	  											<label  for="inputCompanyEmailId"><%= Information.EmailId%></label>
	      										 <input type="email" class="form-control " id="inputCompanyEmailId" name="inputCompanyEmailId" placeholder="" >
											</div>
											<div class="form-group col-sm-3 offset-sm-1">
			      								<label for="inputCompanyPhone">Phone NO</label>
			      								<input type="text" class="form-control " id="inputCompanyCompanyPhone" name="inputCompanyPhone" placeholder="" >
		    								</div>
											<div class="form-group col-sm-2 offset-sm-0">
			      								<label for="inputCompanyMobile"><%= Information.Block%></label>
			      								<input type="text" class="form-control " id="inputCompanyMobile" name="inputCompanyMobile" placeholder="" >
		    								</div>
 										</div>
  											<br />
  										<div class="form-row ">
  									 		<div class="form-group col-md-5 offset-sm-1">
   										 		<label for="inputPAddress" ><%= Information.Address%></label>
   										 		<input type="text" class="form-control " id="inputPAddress" placeholder="" name="inputPAddress">
  											</div>
  											<div class="form-group col-sm-3 offset-sm-0 ">
   							 					<label for="inputBlock"><%= Information.Block%></label>
    											<input type="text" class="form-control " id="inputBlock" placeholder="" name="inputBlock">
  											</div>
  											<div class="form-group col-sm-2 offset-sm-0 ">
   							 					<label for="inputSector"><%= Information.sector%></label>
    											<input type="text" class="form-control  " id="inputSector" placeholder="" name="inputSector">
  											</div>
	  									</div>
	  									<div class="form-row ">
  											<div class="form-group col-sm-3 offset-sm-1 ">
      											<label for="inputCity"><%= Information.city%></label>
      											<input type="text" class="form-control " id="inputCity" name="inputCity">
    										</div>

    										<div class="form-group col-sm-3 offset-sm-0">
	      										<label for="inputState"><%= Information.state%></label>
	      											<select id="inputState" name="inputState"class="form-control ">
	        											<option selected>Choose...</option>
	        											<option>...</option>
	      											</select>
	    									</div>
	    									<div class="form-group col-sm-2 ">
	      										<label for="inputCountry"><%= Information.country%></label>
	      										<select id="inputCountry" name="inputCountry"class="form-control ">
	        										<option selected>Choose...</option>
	        										<option>...</option>
	      										</select>
	    									</div>
	    									<div class="form-group col-sm-2 ">
     											<label for="inputpincode"><%= Information.pinCode%></label>
      											<input type="text" class="form-control  " id="inputpincode" name="inputpincode">
    										</div>
										</div>
									</div>
								</div>
								<div id="collapseTwo" class="collapse" aria-labelledby="headingOne" data-parent="#accordionDriver">
									<br />
     							 	<div class="card-body bg-light">
										<div class="form-row ">
	   										<div class="col-sm-4 offset-sm-1">
	     										 <label for="inputFName"><%=Information.fname%></label>
	      										 <input type="text" class="form-control " id="inputFName" name="inputFName" placeholder="" required>
	  										</div>
	  										<div class="col-sm-3 offset-sm-1">
	  											<label for="inputLName"><%=Information.lname%></label>
	      										 <input type="text" class="form-control " id="inputLName" name="inputLName" placeholder="" >
											</div>
											<div class="form-group col-sm-2 offset-sm-0">
			      								<label for="inputGender"><%=Information.gender%></label>
			      								<select id="inputGender" name="inputGender" class="form-control  form-control-sm">
			        								<option selected>Male</option>
			        								<option>Female</option>
			        								<option>Transg</option>
			      						 		</select>
		    								</div>
 										</div>
										<div class="form-row">
    										<div class="form-group col-sm-4 offset-sm-1">
    											<label for="inputCPEmail"><%=Information.email%></label>
     											<input type="email" class="form-control " id="inputCPEmail" name="inputCPEmail" placeholder="email@example.com" required>
     											<small id="email" class="form-text text-muted">We'll never share your email with anyone else.</small>
   											</div>
   											<div class="form-group col-sm-3 offset-sm-1">
     											<label for="inputCPMobile"><%=Information.mobile%></label>
      											<input type="text" class="form-control  " id="inputCPMobile" name="inputCPMobile" placeholder="" required>
  											</div>
  										</div>
  									</div>
  								</div>
								<div id="collapseThree" class="collapse" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light">
     							 		<br />
										<div class="form-row ">
											<div class="col-sm-4 offset-sm-1">
	     										 <label for="inputHolderName">Account Holder Name</label>
	      										 <input type="text" class="form-control " id="inputHolderName" name="inputHolderName" placeholder="" required>
	  										</div>
	  										<div class="col-sm-3 offset-sm-0">
	  											<label for="inputBankAccountNO">Bank Account NO</label>
	      										 <input type="text" class="form-control " id="inputBankAccountNO" name="inputBankAccountNO" placeholder="" >
											</div>
											<div class="col-sm-2 offset-sm-1">
	     										 <label for="inputaACType">Account Type</label>
	      										 <input type="text" class="form-control " id="inputaACType" name="inputaACType" placeholder="" required>
	  										</div>
	  									</div>
	  									<br />
	  									<div class="form-row ">
											<div class="form-group col-sm-4 offset-sm-1">
			      								<label for="inputBranchName">Bank Name</label>
			      								<select id="inputBranchName" name="inputBranchName" class="form-control">
			        								<option selected>....</option>
			        								<option>HDFC</option>
			        								<option>ICICI</option>
			        								<option>SBI</option>
			      						 		</select>
		    								</div>
											<div class="col-sm-3 offset-sm-0">
	  											<label for="inputIFSCCode">Bank IFSC Code</label>
	      										 <input type="text" class="form-control " id="inputIFSCCode" name="inputIFSCCode" placeholder="" >
											</div>
	  										<div class="col-sm-3 offset-sm-0">
	  											<label for="inputBankCity">Branch City Name</label>
	      										 <input type="text" class="form-control " id="inputBankCity" name="inputBankCity" placeholder="" >
											</div>
		    							</div>
	  									<div class="form-row ">
											<div class="col-sm-3 offset-sm-1">
	  											<label for="inputBankState">State Name</label>
	      										 <input type="text" class="form-control " id="inputBankState" name="inputBankState" placeholder="" >
											</div>
											<div class="form-group col-sm-3 offset-sm-1">
			      								<label for="inputBankCountry">Country</label>
			      								<select id="inputBankCountry" name="inputBankCountry" class="form-control">
			        								<option selected>....</option>
			        								<option>HDFC</option>
			        								<option>ICICI</option>
			        								<option>SBI</option>
			      						 		</select>
		    								</div>
											<div class="col-sm-2 offset-sm-1">
	  											<label for="inputBankPinCode">Pin Code</label>
	      										 <input type="text" class="form-control" id="inputBankPinCode" name="inputBankPinCode" placeholder="" >
											</div>
	
		    							</div>


		    						</div>
		    					</div>
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
			      			<div class="card-body" >
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