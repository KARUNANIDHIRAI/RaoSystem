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
		<!-- Page Header -->
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
		

		
<!-- Page Body -->

		<div class="container" > 
			<form id="login" name="login" action="getLoginChecking" method="post" class="form-horizontal needs-validation" autocomplete="off"  novalidate>
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="accordion" id="accordionDriver">

							<div class="card">
    							<div class="card-header bg-primary"  id="headingOne">
    							
						    		<ul class="nav nav-tabs card-header-tabs">
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> <a class="nav-link active text-dark " href="#"><%=Information.TenantPersonalInfo %></a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> <a class="nav-link text-light" href="#"><%=Information.TenantAddress %></a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour"> <a class="nav-link text-light" href="#"><%=Information.TenantProfession %></a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree"> <a class="nav-link text-light" href="#"><%=Information.TenantDriver %></a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" aria-controls="collapseSix"> <a class="nav-link text-light" href="#"><%=Information.TenantVehicle %></a> </li>
					      				<li class="nav-item " data-toggle="collapse" data-target="#collapseSeven" aria-expanded="true" aria-controls="collapseSeven"> <a class="nav-link text-light" href="#"><%=Information.TenantMaid %></a> </li>
					      				<li class="nav-item " data-toggle="collapse " data-target=".multi-collapse" aria-expanded="true" aria-controls="collapseOne collapseTwo collapseThree collapseFour collapseFive"> <a class="nav-link text-light" href="#">Preview Information</a> </li>
	    							</ul>
    							</div>

							    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light text-dark">
										<div class="form-row ">
									   		<div class="col-sm-4 offset-sm-1">
										   		<label for="Fname" ><%= Information.fname%></label>
										   		<input type="text" class="form-control " id="Fname"  name="Fname" required>
								    		</div>
 									    	<div class="col-sm-3">
												<label for="lname" ><%= Information.lname%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="lname"name="lname"  required>
												</div>
									    	</div>
									    	<div class="col-sm-3 offset-sm-0">
									      		<label for="Gender" ><%= Information.gender%></label>
									      		<select class="custom-select" id="Gender" name="Gender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>

								  		</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="EmailId" ><%= Information.email%></label>
											      <input type="email" class="form-control " id="EmailId" name="EmailId" placeholder=<%= Information.EmailId%> >
									    	</div>
										    <div class="col-sm-2 offset-sm-1">
											      <label for="mobile" ><%= Information.Mobile%></label>
											      <input type="text" class="form-control " id="mobile" name ="mobile" placeholder="" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="Aadhar" ><%= Information.aadhar%></label>
										      	<input type="text" class="form-control" id="Aadhar" name="Aadhar" value="AadharNO / Voter Id NO" required>
										    </div>
									  	</div>
									  	<br />
										<div class="form-row">
										    <div class="col-sm-4 offset-sm-1">
											      <label for="husFname" class=" h6"><%= Information.hWFfName%></label>
											      <input type="text" class="form-control " id="husFname" name="husFname" >
									    	</div>
											<div class="col-sm-3 ">
												<label for="husLname" class=" h6"><%=Information.lname%></label>
												<div class="input-group">
											        <input type="text" class="form-control" id="husLname" name="husLname" >
												</div>
										    </div>
									    	<div class="col-sm-3 offset-sm-0" >
									      		<label for="hGender" ><%=Information.gender%></label>
									      		<select class="custom-select" id="hGender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>

									  	</div>
	
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="fmailId" ><%= Information.email%></label>
											      <input type="email" class="form-control " id="fEmailId" name="fEmailId" placeholder=<%= Information.EmailId%> >
									    	</div>
									    	<div class="col-sm-2 offset-sm-1">
									      		<label for="hfMobile" ><%=Information.Mobile%></label>
											      <input type="Text" class="form-control " id="hfMobile" name="hfMobile" placeholder="" >
									   		</div>
			
									  	</div>
      								</div>
    							</div>
  							</div>

							<div class="card">
							    <div id="collapseTwo" class="collapse " aria-labelledby="headingTwo" data-parent="#accordionDriver">
									<div class="card-body bg-light text-dark">
										<div class="form-row">
										    <div class="col-sm-6 offset-sm-1">
											      <label for="paddress" class="h6"><%=Information.PAddress%></label>
											      <input type="text" class="form-control  " id="paddress" name="paddress" value=" Falt No/ Floor No/ Apartmen Name" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="pblock" ><%=Information.Block%></label>
										      	<input type="text" class="form-control" id="pblock" name="pblock" required>
										    </div>
									  	</div>

										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
												<label for="psector" ><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control" id="psector" name="psector"  required>
												</div>
										    </div>
	
										    <div class="col-sm-3 offset-sm-0">
											      <label for="pcity" ><%=Information.City%></label>
											      <input type="text" class="form-control " id="pcity" name="pcity" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="pstate" class="" ><%=Information.State%></label>
										      	<input type="text" class="form-control " id="pstate" name ="pstate" required>
										    </div>
									  	</div>
										<div class="form-row">
									       
										    <div class="col-sm-3 offset-sm-1">
												<label for="pcountry" class=" "><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="pcountry" name="pcountry" required >
												</div>
										    </div>
										    <div class="col-sm-2 offset-sm-1">
												<label for="ppincode" class=" "><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="ppincode" name="ppincode" required>
												</div>
										    </div>
									  	</div>
									  	<br />
									<!-- Correspondence Address -->
										<div class="form-row">
										    <div class="col-sm-6 offset-sm-1">
											      <label for="caddress" class=" h6"><%=Information.CAddress%></label>
											      <input type="text" class="form-control  " id="caddress" name="caddress" value=" Falt No/ Floor No/ Apartmen Name" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="cblock" class=" " ><%=Information.Block%></label>
										      	<input type="text" class="form-control  " id="cblock" name="cblock" required>
										    </div>
									  	</div>

										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
												<label for="csector" class=" "><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="csector" name="csector"  required>
												</div>
										    </div>
	
										    <div class="col-sm-3 offset-sm-0">
											      <label for="ccity" class=" "><%=Information.City%></label>
											      <input type="text" class="form-control  " id="ccity" name="ccity" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="cstate" class=" " ><%=Information.State%></label>
										      	<input type="text" class="form-control  " id="cstate" name ="cstate" required>
										    </div>
									  	</div>
										<div class="form-row">
									       
										    <div class="col-sm-3 offset-sm-1">
												<label for="ccountry" class=" "><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="ccountry" name="ccountry" required >
												</div>
										    </div>
										    <div class="col-sm-2 offset-sm-1">
												<label for="cpincode" class=" "><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="cpincode" name="cpincode" required>
												</div>
										    </div>
									  	</div>
						      		</div>
						    	</div>
							</div>

							<div class="card">
							    <div id="collapseThree" class="collapse" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light text-dark">
									<div class="form-row ">
									   		<div class="col-sm-4 offset-sm-1">
										   		<label for="tFname" ><%= Information.fname%></label>
										   		<input type="text" class="form-control " id="tFname"  name="tFname" required>
								    		</div>
 									    	<div class="col-sm-3">
												<label for="tlname" ><%= Information.lname%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="tlname"name="tlname"  required>
												</div>
									    	</div>
									    	<div class="col-sm-3 offset-sm-0">
									      		<label for="tGender" ><%= Information.gender%></label>
									      		<select class="custom-select" id="tGender" name="tGender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>
								  		</div>
										<div class="form-row">
								       		<label class="col-sm-1"></label>
									   		<div class="col-sm-5 ">
										   		<label for="rtoname" class=" "><%= Information.DlIssuedRTONameLBL%></label>
										   		<input type="text" class="form-control  " id="rtoname"  name="rtoname" required>
								    		</div>
 									    	<div class="col-sm-4 offset-sm-1">
												<label for="dlno" class=" "><%= Information.DlNoLBL%></label>
												<div class="input-group">
										       		<input type="text" class="form-control  " id="dlno"name="ddlno"  required>
												</div>
									    	</div>
								  		</div>
										<div class="form-row">
									    	<div class="col-sm-2 offset-sm-1">
												<label for="dlissuedt" class=" "><%= Information.DLIsDt%></label>
												<div class="input-group">
										       		<input type="date" class="form-control  " id="dlissuedt"name="dlissuedt"  required>
												</div>
									   		</div>
									    	<div class="col-sm-2 offset-sm-1">
												<label for="dlexpirydt" class=" "><%= Information.DLExpiryDtLBL%></label>
												<div class="input-group">
										       		<input type="date" class="form-control  " id="dlexpirydt"name="dlexpirydt"  required>
												</div>
									   		</div>
										    <div class="col-sm-4 offset-sm-1">
											      <label for="rtoemailId" class=" "><%= Information.email%></label>
											      <input type="Text" class="form-control " id="rtoemailId" name="rtoemailId" placeholder=<%= Information.EmailId%> >
									    	</div>
								  		</div>
										<div class="form-row">
									    	<div class="col-sm-3 offset-sm-1">
												<label for="dmobile" class=" "><%= Information.Mobile%></label>
												<div class="input-group">
										       		<input type="text" class="form-control  " id="dmobile"name="dmobile"  required>
												</div>
									   		</div>
								  		</div>
								  		<br />
<%--
 										<div class="form-row">
										    <div class="col-sm-6 offset-sm-1">
											      <label for="raddress" class=" h5"><%=Information.DLIssueRTOAddressLBL%></label>
											      <input type="text" class="form-control  " id="raddress" name="raddress" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="rblock" class=" " ><%=Information.Block%></label>
										      	<input type="text" class="form-control  " id="rblock" name="rblock" required>
										    </div>
									  	</div>

										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
												<label for="rsector" class=" "><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="rsector" name="rsector"  required>
												</div>
										    </div>
	
										    <div class="col-sm-2 offset-sm-1">
											      <label for="rcity" class=" "><%=Information.City%></label>
											      <input type="text" class="form-control  " id="rcity" name="rcity" required>
									    	</div>
										    <div class="col-sm-2 offset-sm-1">
										    	<label for="rstate" class=" " ><%=Information.State%></label>
										      	<input type="text" class="form-control  " id="rstate" name ="rstate" required>
										    </div>
									  	</div>
										<div class="form-row">
										    <div class="col-sm-2 offset-sm-1">
												<label for="rcountry" class=" "><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="rcountry" name="rcountry" required >
												</div>
										    </div>
										    <div class="col-sm-1 offset-sm-2">
												<label for="rpincode" class=" "><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="rpincode" name="rpincode" required>
												</div>
										    </div>
									  	</div>
 --%> 
      								</div>
    							</div>
  							</div>
  							<br />
 							<div class="card">
							    <div id="collapseFour" class="collapse" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light text-dark">
										<div class="form-row">
								       		<label class="col-sm-1"></label>
									   		<div class="col-sm-4 ">
										   		<label for="orgname" class=" "><%= Information.CompNameLBL%></label>
										   		<input type="text" class="form-control  " id="orgname"  name="orgname" required>
								    		</div>
 									    	<div class="col-sm-3">
												<label for="empno" class=" "><%= Information.EmplNoLBL%></label>
												<div class="input-group">
										       		<input type="text" class="form-control  " id="empno"name="empno"  required>
												</div>
									    	</div>
									    	<div class="col-sm-3 offset-sm-0">
												<label for="designation" class=" "><%= Information.DesignationLBL%></label>
												<div class="input-group">
										       		<input type="text" class="form-control  " id="designation"name="designation"  required>
												</div>
								  		</div>
									   		</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="EmpmailId" class=" "><%= Information.email%></label>
											      <input type="Text" class="form-control  " id="EmpmailId" name="EmpmailId" placeholder="" >
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
											      <label for="doj" class=" " ><%= Information.DOJLBL%></label>
											      <input type="date" class="form-control  " id="doj" name ="doj" placeholder=<%= Information.dob%> required>
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
										    	<label for="dor" class=" "><%= Information.DORLBL%></label>
										      	<input type="date" class="form-control  " id="dor" name="dor" required>
										    </div>
									  	</div>
										<div class="form-row">
								    	<div class="col-sm-3 offset-sm-1">
									      		<label for="rofficer" class=" "><%= Information.ReportingLBL%></label>
											      <input type="text" class="form-control" id="rofficer" name="rofficer" required>
									   		</div>
											    <div class="col-sm-3 offset-sm-1">
											      <label for="ROEmail" ><%= Information.ReprotingOEmailLBL%></label>
											      <input type="Text" class="form-control" id="ROEmail" name="ROEmail" placeholder="" >
									    	</div>
									  	</div>
									  	<br />
										<div class="form-row">
										    <div class="col-sm-6 offset-sm-1">
											      <label for="eaddress" class=" h5"><%=Information.EAddressLBL%></label>
											      <input type="text" class="form-control  " id="eaddress" name="eaddress" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="eblock" class=" " ><%=Information.Block%></label>
										      	<input type="text" class="form-control  " id="eblock" name="eblock" required>
										    </div>
									  	</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
												<label for="esector" class=" "><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="esector" name="esector"  required>
												</div>
										    </div>
										    <div class="col-sm-3 offset-sm-0">
											      <label for="ecity" class=" "><%=Information.City%></label>
											      <input type="text" class="form-control  " id="ecity" name="ecity" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="estate" class=" " ><%=Information.State%></label>
										      	<input type="text" class="form-control  " id="estate" name ="estate" required>
										    </div>
									  	</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
												<label for="ecountry" class=" "><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="ecountry" name="ecountry" required >
												</div>
										    </div>
										    <div class="col-sm-2 offset-sm-1">
												<label for="epincode" class=" "><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control  " id="epincode" name="epincode" required>
												</div>
										    </div>
									  	</div>
      								</div>
    							</div>
  							</div>

							<div class="card">
							    <div id="collapseSix" class="collapse" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light text-dark">
										<div class="form-row ">
									   		<div class="col-sm-4 offset-sm-2">
										   		<label for="Vehicletype" ><%= Information.VehicleType%></label>
										   		<input type="text" class="form-control " id="Vehicletype"  name="Vehicletype" required>
								    		</div>
 									    	<div class="col-sm-4">
												<label for="Vehicleno" ><%= Information.VehicleNo%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="Vehicleno"name="Vehicleno"  required>
												</div>
									    	</div>
								  		</div>
										<div class="form-row">
									    	<div class="col-sm-4 offset-sm-2">
												<label for="Vehiclename" ><%= Information.VehicleName%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="Vehiclename"name="Vehiclename"  value="maruti / honda/ tata /Nissan/ " required>
												</div>
									    	</div>
									    	<div class="col-sm-4">
												<label for="Vehiclecolor" ><%= Information.VehicleColor%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="Vehiclecolor"name="Vehiclecolor"  required>
												</div>
									    	</div>
								  		</div>
									  		<br />
      								</div>
    							</div>
  							</div>
							<div class="card">
							    <div id="collapseSeven" class="collapse" aria-labelledby="headingOne" data-parent="#accordionDriver">
     							 	<div class="card-body bg-light text-dark">
										<div class="form-row ">
									   		<div class="col-sm-4 offset-sm-1">
										   		<label for="mfname" >Maid <%= Information.fname%></label>
										   		<input type="text" class="form-control " id="mFname"  name="mFname" required>
								    		</div>
 									    	<div class="col-sm-3">
												<label for="mlname" ><%= Information.lname%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="mlname"name="mlname"  required>
												</div>
									    	</div>
									    	<div class="col-sm-3 offset-sm-0">
									      		<label for="mgender" ><%= Information.gender%></label>
									      		<select class="custom-select" id="Gender" name="mgender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>

								  		</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="memailId" ><%= Information.email%></label>
											      <input type="email" class="form-control " id="memailId" name="memailId" placeholder=<%= Information.EmailId%> >
									    	</div>
										    <div class="col-sm-2 offset-sm-1">
											      <label for="mmobile" ><%= Information.Mobile%></label>
											      <input type="text" class="form-control " id="mmobile" name ="mmobile" placeholder="" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="maadhar" ><%= Information.aadhar%></label>
										      	<input type="text" class="form-control" id="maadhar" name="maadhar" value="AadharNO / Voter Id NO" required>
										    </div>
									  	</div>
									  	<br />
										<div class="form-row">
										    <div class="col-sm-4 offset-sm-1">
											      <label for="mhusFname" class=" h6"><%= Information.hWFfName%></label>
											      <input type="text" class="form-control " id="mhusFname" name="mhusFname" >
									    	</div>
											<div class="col-sm-3 ">
												<label for="mhusLname" class=" h6"><%=Information.lname%></label>
												<div class="input-group">
											        <input type="text" class="form-control" id="mhusLname" name="mhusLname" >
												</div>
										    </div>
									    	<div class="col-sm-3 offset-sm-0" >
									      		<label for="mhGender" ><%=Information.gender%></label>
									      		<select class="custom-select" id="mhGender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>
									  	</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="mfmailId" ><%= Information.email%></label>
											      <input type="email" class="form-control " id="mfmailId" name="mfmailId" placeholder=<%= Information.EmailId%> >
									    	</div>
									    	<div class="col-sm-2 offset-sm-1">
									      		<label for="mhfMobile" ><%=Information.Mobile%></label>
											      <input type="Text" class="form-control " id="mhfMobile" name="mhfMobile" placeholder="" >
									   		</div>
			
									  	</div>
      								</div>
    							</div>
  							</div>

  							<div class="card">
							    <div id="collapseFive" class="collapse " aria-labelledby="headingFive" data-parent="#accordionDriver">
									<div class="card-body bg-light text-dark">
										<div class="form-row">
										    <div class="col-md-4 mb-3">
						 						<label class="control-label col-xs-1 " for="photo"><%= Information.UploadPhoto%> </label>
									    		<div class="col-xs-2">
											    	<input class="form-control input-sm" type="file" id="file" name="file"  required>
												</div>
												<div class="col-xs-1">
											 		<img id="photo" src="#" />
												</div>
											</div>
										    <div class="col-md-4 mb-3">
										    	<label class="control-label col-xs-1" for="Signature"><%= Information.UploadSignature%></label>
									    		<div class="col-xs-2">
											    	<input class="form-control input-sm" type="file" id="file1" name="file"  required>
												</div>
												<div class="col-xs-1">
											 		<img id="Signature" src="#"  />
												</div>
										    </div>
										    <div class="col-md-4 mb-3">
												<label class="control-label col-xs-1" for="Aadhar"><%= Information.UploadAadhar%></label>
												<div class="col-xs-2" >
											    	<input class="form-control input-sm" type="file" id="file2" name="file"  required>
													<div class="col-xs-1">
												 		<img id="Aadhar" src="#"  />
													</div>
												</div>
										    </div>
									  	</div>
				 						<div class="form-row">
										    <div class="col-md-4 mb-3">
						 						<label class="control-label col-xs-1 " for="PhotoPanCard"><%= Information.UploadPhotoPanCard%> </label>
									    		<div class="col-xs-2">
											    	<input class="form-control input-sm" type="file" id="file3" name="file"  required>
												</div>
												<div class="col-xs-1">
											 		<img id="PhotoPanCard" src="#" />
												</div>
											</div>
										    <div class="col-md-4 mb-3">
										    	<label class="control-label col-xs-1" for="PhotoDL"><%= Information.UploadPhotoDL%></label>
									    		<div class="col-xs-2">
											    	<input class="form-control input-sm" type="file" id="file4" name="file"   required>
												</div>
												<div class="col-xs-1">
											 		<img id="PhotoDL" src="#"  />
												</div>
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

	<!--Footer  -->	
			<br/>
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

	<script type="text/javascript">
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
		});
	
		$(document).ready(function() {

			 $('form[id="Husemaid01"]').validate({
				    rules: {
				      FName: {
					        required: true,
					        minlength: 4,
					        },
					  LName: {
					        required: true,
					        minlength: 3,
					        },
				      Initial: {
				           required: true,
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
		            $("#file3").change(function () {
		                sigFilePreview(this);
		            });            
		            $("#file4").change(function () {
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

		            function sigFilePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
		                        $('#PhotoPanCard')
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
		                        $('#PhotoDL')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
		            
		            
		            
		            
		            
		});
	</script>

	</body>
</html>