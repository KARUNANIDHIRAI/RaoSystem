<%@page import="javax.sound.midi.MidiDevice.Info"%>
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
   		<script type="text/javascript" src="../webjars/query-validation/1.19.0/jquery.validate.min.js"></script>
   		<script type="text/javascript" src="../webjars/query-validation/1.19.0/jquery.validate.js"></script>

   		<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>

   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
  		
  		
	<body>
	<div class="container-flucid">
		<div class="row">
			<div class="col-lg-12 text-right  margin-left:0  margin-right:0px" style="background-color:#000080">
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
		   	<form id="DwellerNEW" name="DwellerNEW" action="../DwellerUpdateInformation" method="post" class="form-horizontal needs-validation" autocomplete="off">		
			<div class="row">
			    <div class="col-xs-12">
			    	<div class="card" style="width:72rem;">
			    		<div class="card-header text-center " style="background-color:#FFFFFF">
			    			<h5 class="card-title text-center"><%=Information.TNTInfo%></h5>			
			    		</div>
			    	</div>
					<div id="accordion">
  						<div class="card">
    						<div class="card-header  text-white" id="headingOne" style="background-color:#2EA2E2">
	  								<ul class="nav nav-tabs card-header-tabs nav nav-pills nav-fill">
					      			<li class="nav-item " data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					      			 <a class="nav-link active  text-white " href="#" style="background-color:#000080"><%=Information.OwnPersonalInfo %></a> </li>

	                                <li class="nav-item " id="Owner" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="true" aria-controls="collapseSeven"> 
						      			<a class="nav-link text-light" href="#"><%= Information.OwnerInfo%></a> </li>
	
					      			<li class="nav-item " id="House"data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
					      			 <a class="nav-link text-light" href="#"><%= Information.OwnFLTnfo%></a> </li>

					      			<li class="nav-item " id="Employment" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree"> 
					      			<a class="nav-link text-light" href="#"><%= Information.HKMEmpolyment%></a> </li>
				
					      			<li class="nav-item " id="Vehicel" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour"> 
					      			<a class="nav-link text-light" href="#"><%= Information.OwnVehicleInfo%></a> </li>

					      			<li class="nav-item " id="Driver" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive"> 
						      			<a class="nav-link text-light" href="#"><%= Information.OwnDriverInfo%></a> </li>
	
					      			<li class="nav-item " id="Maid" data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" aria-controls="collapseSix"> 
						      			<a class="nav-link text-light" href="#"><%= Information.OwnMaidInfo%></a> </li>
	
					      			<li class="nav-item " data-toggle="collapse " data-target=".multi-collapse" aria-expanded="false" aria-controls="collapseOne collapseTwo "> 
					      			<a class="nav-link text-light" href="PreviewDwellerInfo.jsp">Preview </a> </li>
	    						</ul>
 
    						</div>
     						<div id="collapseOne" class="collapse multi-collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      							<div class="card-body " style="background-color: #FAF7F5 ;" >
									
									<div class="form-row ">
   										<div class="col-lg-4 offset-sm-1">
     										 <label for="inpuFfName"><%=Information.fname%></label>
      										 <input type="text" class="form-control is-invalid" id="inputFName" name="inputFName" placeholder=""  
      										 value = <%=session.getAttribute("inputFName") %> required>
  										</div>
  										<div class="col-lg-3 offset-sm-0">
  											<label  for="inputName"><%=Information.lname%></label>
      										 <input type="text" class="form-control is-invalid" id="inputLName" name="inputLName" placeholder="" 
      										  value = <%=session.getAttribute("inputLName") %> >
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

 									<div class="form-row">
    									<div class="form-group col-lg-4 offset-sm-1">
    										<label for="inputEmail4"><%=Information.email%></label>
     										<input type="email" class="form-control is-invalid" id="inputEmail4" name="inputEmail4" placeholder="email@example.com"  
   											data-toggle="tooltip" data-placement="top" title="We'll never share your email with anyone else." 
      										  value = <%=session.getAttribute("inputEmail4") %> required>

   										</div>
   										<div class="form-group col-lg-3 ">
     										<label for="inputMobile"><%=Information.mobile%></label>
      										 <input type="text" class="form-control is-invalid" id="inputMobile" name="inputMobile" placeholder="" 
      										  value = <%=session.getAttribute("inputMobile") %> required>
  										</div>
 									</div>
									<br/>
									<div class="form-row">
 										<div class="col-lg-4 offset-sm-1 h6">
   										 	<label for="inputFFName"><%=Information.FatherFName%></label>
    										 <input type="text" class="form-control is-invalid" id="inputFFName" name="inputFFName" placeholder="" 
      										  value = <%=session.getAttribute("inputFFName") %> required>
   									</div>
										<div class="col-lg-3 offset-sm-0 h6">
											<label  for="inputFLName"><%=Information.lname%></label>
    										 <input type="text" class="form-control is-invalid" id="inputFLName" name="inputFLName" placeholder="" 
      										  value = <%=session.getAttribute("inputFLName") %> >
										</div>
										<div class="form-group col-lg-3 offset-sm-0 h6">
      										<label for="inputFMobile"><%=Information.MobileNo%></label>
    									   	 <input type="text" class="form-control is-invalid" id="inputFMobile" name="inputFMobile" placeholder="" 
      										  value = <%=session.getAttribute("inputFMobile") %> >
    									</div>
									</div>

									<br />
 									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control text-white" id="cont01" name = "cont01" 
									      	data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" 
									      	aria-controls="collapseTwo" style="background-color:#2EA2E2">Continue... </button>
									    </div>
								  	</div>

    							</div>
  							</div>
  						</div> 
  						<div class="card" id="Address">
  							<div id="collapseTwo" class="collapse multi-collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      							<div class="card-body " style="background-color:#FAF7F5  ;">
    								<br />
	       							<div class="form-row">
										<div class="form-group col-md-6 offset-md-1">
	 									 	<label for="inputPAddress" class=""><%= Information.TNTCurInfo%></label>
	 									 	<input type="text" class="form-control  is-invalid " id="inputPAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" 
     										 name="inputPAddress"  value = <%=session.getAttribute("inputPAddress") %> >
 
										</div>
							
										<div class="form-group col-md-2">
	 							 			<label for="inputBlock"><%= Information.Block%></label>
	  										<input type="text" class="form-control   " id="inputBlock" placeholder="" name="inputBlock"	
	  										  value = <%=session.getAttribute("inputBlock") %> >
   									</div>
										<div class="form-group col-md-2">
	 							 			<label for="inputSector"><%= Information.sector%></label>
	  									<input type="text" class="form-control   " id="inputSector" placeholder="" name="inputSector"
	  										  value = <%=session.getAttribute("inputSector") %> >
  									</div>
	  								</div>
	  								<div class="form-row">
	 									<div class="form-group col-md-3 offset-sm-1">
	     									<label for="inputCity"><%= Information.city%></label>
	     									<input type="text" class="form-control  is-invalid " id="inputCity" name="inputCity"
	  										  value = <%=session.getAttribute("inputCity") %> >
	   									</div>
	   									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputState"><%= Information.state%></label>
	      									<input type="text" class="form-control is-invalid  " id="inputState" name="inputState" 
	  										  value = <%=session.getAttribute("inputState") %> >
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputCountry"><%= Information.country%></label>
	      									<input type="text" class="form-control  is-invalid " id="inputCountry" name="inputCountry"
	  										  value = <%=session.getAttribute("inputCountry") %> >
	    								</div>
	    								<div class="form-group col-md-2">
	    									<label for="inputPincode"><%= Information.pinCode%></label>
	     									<input type="text" class="form-control   " id="inputPincode" name="inputPincode"
	  										  value = <%=session.getAttribute("inputPincode") %> >
	   									</div>
									</div>
	  								<div class="form-row">
 										<div class="col-lg-3 offset-sm-1 ">
   										 	<label for="inputShiftIn"><%=Information.ShiftIn%></label>
    										 <input type="date" class="form-control is-invalid" id="inputShiftIn" name="inputShiftIn" placeholder="" 
	  										  value = <%=session.getAttribute("inputShiftIn") %> required>
    									</div>
										<div class="col-lg-3 offset-sm-0 ">
											<label  for="inputShiftOut"><%=Information.ShiftOut%></label>
    										 <input type="date" class="form-control" id="inputShiftOut" name="inputShiftOut" placeholder="" 
	  										  value = <%=session.getAttribute("inputShiftOut") %> >
    									</div>
									</div>
									<br /> <br />
									<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputTAddress" class=""><%= Information.PAddress%></label>
   										 	<input type="text" class="form-control  is-invalid " id="inputTAddress" placeholder="Flat NO/ Floor no/ Apartment / towerNO" 
   										 	name="inputTAddress"  
   										 	value = <%=session.getAttribute("inputTAddress") %> >
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputTBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control   " id="inputTBlock" placeholder="" name="inputTBlock"
    										 value = <%=session.getAttribute("inputTBlock") %>	>
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputTSector"><%= Information.sector%></label>
    										<input type="text" class="form-control   " id="inputTSector" placeholder="" name="inputTSector" 
    										value = <%=session.getAttribute("inputTSector") %>>
  										</div>
	  								</div>
	  								<div class="form-row">
									 <br />
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputTCity"><%= Information.city%></label>
      										<input type="text" class="form-control  is-invalid " id="inputTCity" name="inputTCity"
      										 value = <%=session.getAttribute("inputTCity") %> >
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputTState"><%= Information.state%></label>
	      										<input type="text" class="form-control is-invalid  " id="inputTState" name="inputTState"
	      										 value = <%=session.getAttribute("inputTState") %> >
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputTCountry"><%= Information.country%></label>
	      										<input type="text" class="form-control  is-invalid " id="inputTCountry" name="inputTCountry" 
	      										 value = <%=session.getAttribute("inputTCountry") %>>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputTPincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control   " id="inputTPincode" name="inputTPincode" 
      										 value = <%=session.getAttribute("inputTPincode") %>>
    									</div>
									</div>
									<br />
									<br /> <br/>
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control text-white" id="cont02" name = "cont02" 
									      	data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" 
									      	aria-controls="collapseThree" style="background-color:#2EA2E2">Continue... </button>
									    </div>
								  	</div>

								</div>
   							</div>
  						</div>
  						<div class="card" id="Employer">
    						<div id="collapseThree" class="collapse multi-collapse" aria-labelledby="headingThree" data-parent="#accordion">
      							<div class="card-body " style="background-color:#FAF7F5  ;">
									<div class="form-row">
  									 	<div class="form-group col-md-4 offset-sm-1 h6">
   										 	<label for="inputPreOrgName"><%= Information.preOrgName%></label>
							 				<input type="text" class="form-control   " id="inputPreOrgName" name="inputPreOrgName" placeholder="" 
							 				 value = <%=session.getAttribute("inputPreOrgName") %>>
							 					
  										 </div>
  										 <div class="form-group col-md-3">
   							 				<label for="inputEmpNO"><%= Information.EmplNoLBL%></label>
    										<input type="text" class="form-control   " id="inputEmpNO" name="inputEmpNO" placeholder="" 
    										 value = <%=session.getAttribute("inputEmpNO") %>>
  										</div>
  										<div class="form-group col-md-3">
   							 				<label for="inputDesignation"><%= Information.DesignationLBL%></label>
    										<input type="text" class="form-control   " id="inputDesignation" name="inputDesignation" placeholder=""
    										 value = <%=session.getAttribute("inputDesignation") %>>
  										</div>
 	  								</div>
									<div class="form-row">
  										<div class="form-group col-md-6 offset-md-1">
   										 	<label for="inputOAddress" class=""><%= Information.OrgAddress%></label>
   										 	<input type="text" class="form-control   " id="inputOAddress" name= "inputOAddress"
   										 	 placeholder="Flat NO/ Floor no/ Apartment / towerNO" 
   										 	  value = <%=session.getAttribute("inputOAddress") %>>
  										</div>
  						
  										<div class="form-group col-md-2">
   							 				<label for="inputOBlock"><%= Information.Block%></label>
    										<input type="text" class="form-control   " id="inputOBlock" placeholder="" name="inputOBlock"
    										 value = <%=session.getAttribute("inputOBlock") %>>
  										</div>
  										<div class="form-group col-md-2">
   							 				<label for="inputOSector"><%= Information.sector%></label>
    										<input type="text" class="form-control" id="inputOSector" placeholder="" name="inputOSector" 
    										 value = <%=session.getAttribute("inputOSector") %>>
  										</div>
	  								</div>
	  								<div class="form-row">
  										<div class="form-group col-md-3 offset-sm-1">
      										<label for="inputOCity"><%= Information.city%></label>
      										<input type="text" class="form-control   " id="inputOCity" name="inputOCity" 
      										 value = <%=session.getAttribute("inputOCity") %>>
    									</div>
    									<div class="form-group col-md-3 offset-sm-0">
	      									<label for="inputOState"><%= Information.state%></label>
     										<input type="text" class="form-control   " id="inputOState" name="inputOState" 
     										 value = <%=session.getAttribute("inputOState") %>>
	    								</div>
	    								<div class="form-group col-md-2">
	      									<label for="inputOCountry"><%= Information.country%></label>
     										<input type="text" class="form-control   " id="inputOCountry" name="inputOCountry" 
     										value = <%=session.getAttribute("inputOCountry") %>>
	    								</div>
	    								<div class="form-group col-md-2">
     										<label for="inputOpincode"><%= Information.pinCode%></label>
      										<input type="text" class="form-control   " id="inputOpincode" name="inputOpincode"
      										 value = <%=session.getAttribute("inputOpincode") %> >
    									</div>
									</div>
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control text-white" id="cont03" name = "cont03" 
									      	data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" 
									      	aria-controls="collapseFour" style="background-color:#2EA2E2">Continue... </button>
									    </div>
								  	</div>

								</div>	
							</div>
  						</div>
   	  					<div class="card" id="Vehicle">
    						<div id="collapseFour" class="collapse multi-collapse" aria-labelledby="headingFour" data-parent="#accordion">
      							<div class="card-body " style="background-color:#FAF7F5  ;">
      								<br />	
     								<div class="form-row">
				 						<div class="form-group col-lg-2 offset-sm-0">
				 							<label for="inputVehTypel1"><%= Information.VehicleType%></label>
    										<input type="text" class="form-control" id="inputVehTypel1" name="inputVehTypel1"
    										 value = <%=session.getAttribute("inputVehTypel1") %>>
    									</div>
    									<div class="form-group col-lg-3 offset-sm-0">
				 							<label for="inputVehManufacture1"><%= Information.VehicleManufacturer%></label>
    										<input type="text" class="form-control" id="inputVehManufacture1" name="inputVehManufacture1"
    										 value = <%=session.getAttribute("inputVehManufacture1") %>>
    									</div>
	   									<div class="form-group col-lg-3 offset-sm-0">
				 							<label for="inputVehModel1"><%= Information.VehicleModel%></label>
    										<input type="text" class="form-control" id="inputVehModel1" name="inputVehModel1"
    										 value = <%=session.getAttribute("inputVehModel1") %>>
    									</div>
 				 						<div class="form-group col-lg-2 offset-sm-0">
				 							<label for="inputVehNo1"><%= Information.VehicleNo%></label>
    											<input type="text" class="form-control" id="inputVehNo1" name="inputVehNo1"
    											 value = <%=session.getAttribute("inputVehNo1") %>>
    									</div>
    									<div class="form-group col-lg-2 offset-sm-0">
				 							<label for="inputVehColor1"><%= Information.VehicleColor%></label>
    										<input type="text" class="form-control" id="inputVehColor1" name="inputVehColor1"
    										 value = <%=session.getAttribute("inputVehColor1") %>>
    									</div>
  									</div>
  									<br />
     								<div class="form-row">
				 						<div class="form-group col-lg-2 offset-sm-0">
				 							<label for="inputVehTypel2"><%= Information.VehicleType%></label>
    										<input type="text" class="form-control" id="inputVehTypel2" name="inputVehTypel2"
    										 value = <%=session.getAttribute("inputVehTypel2") %>>
    									</div>
    									<div class="form-group col-lg-3 offset-sm-0">
				 							<label for="inputVehManufacture2"><%= Information.VehicleManufacturer%></label>
    										<input type="text" class="form-control" id="inputVehManufacture2" name="inputVehManufacture2"
    										 value = <%=session.getAttribute("inputVehManufacture2") %>>
    									</div>
	   									<div class="form-group col-lg-3 offset-sm-0">
				 							<label for="inputVehModel2"><%= Information.VehicleModel%></label>
    										<input type="text" class="form-control" id="inputVehModel2" name="inputVehModel2"
    										 value = <%=session.getAttribute("inputVehModel2") %>>
    									</div>
 				 						<div class="form-group col-lg-2 offset-sm-0">
				 							<label for="inputVehNo2"><%= Information.VehicleNo%></label>
    											<input type="text" class="form-control" id="inputVehNo2" name="inputVehNo2"
    											 value = <%=session.getAttribute("inputVehNo2") %>>
    									</div>
    									<div class="form-group col-lg-2 offset-sm-0">
				 							<label for="inputVehColor2"><%= Information.VehicleColor%></label>
    										<input type="text" class="form-control" id="inputVehColor2" name="inputVehColor2"
    										 value = <%=session.getAttribute("inputVehColor2") %>>
    									</div>
  									</div>
									<br />									
									<br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control text-white" id="cont04" name = "cont04" 
									      	data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" 
									      	aria-controls="collapseFive" style="background-color:#2EA2E2">Continue... </button>
									    </div>
								  	</div>
  	
  								</div>
  							</div>
  						</div>
   	  					<div class="card" id="Driver">
    						<div id="collapseFive" class="collapse multi-collapse" aria-labelledby="headingFive" data-parent="#accordion">
      							<div class="card-body " style="background-color:#FAF7F5  ;">
									<br />
									<div class="form-row ">
   										<div class="col-lg-4 offset-sm-1">
     										 <label for="inputDRVFName"><%=Information.fname%></label>
      										 <input type="text" class="form-control " id="inputDRVFName" name="inputDRVFName" placeholder=""  
      										  value = <%=session.getAttribute("inputDRVFName") %>>
  										</div>
  										<div class="col-lg-3 offset-sm-0">
  											<label  for="inputDRVLName"><%=Information.lname%></label>
      										 <input type="text" class="form-control " id="inputDRVLName" name="inputDRVLName" placeholder="" 
      										  value = <%=session.getAttribute("inputDRVLName") %> >
										</div>
										<div class="form-group col-lg-3 offset-sm-0">
		      								<label for="inputDRVGender"><%=Information.gender%></label>
		      								<select id="inputDRVGender" name="inputDRVGender" class="form-control ">
		        								<option selected>Male</option>
		        								<option>Female</option>
		        								<option>Transg</option>
		      								</select>
		    							</div>
 									</div>
 									<div class="form-row">
    									<div class="form-group col-lg-4 offset-sm-1">
    										<label for="inputDRVAadharNo"><%=Information.AadharNo%></label>
     										<input type="text" class="form-control " id="inputDRVAadharNo" name="inputDRVAadharNo" placeholder=""  
   											data-toggle="tooltip" data-placement="top" title="Pls enter Valid Aadhar No." 
   											 value = <%=session.getAttribute("inputDRVAadharNo") %>>
   										</div>
   										<div class="form-group col-lg-3 ">
     										<label for="inputDRVMobile"><%=Information.mobile%></label>
      										 <input type="text" class="form-control " id="inputDRVMobile" name="inputDRVMobile" placeholder="" 
      										  value = <%=session.getAttribute("inputDRVMobile") %> >
  										</div>
   										<div class="form-group col-lg-3 ">
     										<label for="inputDRVDlNo"><%=Information.DlNo%></label>
      										 <input type="text" class="form-control " id="inputDRVDlNo" name="inputDRVDlNo" placeholder="" 
      										  value = <%=session.getAttribute("inputDRVDlNo") %> >
  										</div>
 									</div>
									<div class="form-row ">
								    	<div class="col-sm-11 offset-sm-1">
	 										<label>*All fields are mandatory </label>
									    </div>
								  	</div>
 									<br/> <br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control text-white" id="cont05" name = "cont05" 
									      	data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" 
									      	aria-controls="collapseSix" style="background-color:#2EA2E2">Continue... </button>
									    </div>
								  	</div>
  	
  								</div>
  							</div>
  						</div>
   	  					<div class="card" id="Maid">
    						<div id="collapseSix" class="collapse multi-collapse" aria-labelledby="headingSix" data-parent="#accordion">
      							<div class="card-body " style="background-color:#FAF7F5  ;">
      								<br />
									<div class="form-row ">
   										<div class="col-lg-4 offset-sm-1">
     										 <label for="inputHKMName"><%=Information.fname%></label>
      										 <input type="text" class="form-control " id="inputHKMName" name="inputHKMName" placeholder="" 
      										  value = <%=session.getAttribute("inputHKMName") %> >
  										</div>
  										<div class="col-lg-3 offset-sm-0">
  											<label  for="inputHKMLName"><%=Information.lname%></label>
      										 <input type="text" class="form-control " id="inputHKMLName" name="inputHKMLName" placeholder="" 
      										  value = <%=session.getAttribute("inputHKMLName") %> >
										</div>
										<div class="form-group col-lg-3 offset-sm-0">
		      								<label for="inputHKMGender"><%=Information.gender%></label>
		      								<select id="inputHKMGender" name="inputHKMGender" class="form-control ">
		        								<option selected>Male</option>
		        								<option>Female</option>
		        								<option>Transg</option>
		      								</select>
		    							</div>
 									</div>
 									<div class="form-row">
    									<div class="form-group col-lg-4 offset-sm-1">
    										<label for="inputHKMAadharNo"><%=Information.AadharNo%></label>
     										<input type="text" class="form-control " id="inputHKMAadharNo" name="inputHKMAadharNo" placeholder=""  
   											data-toggle="tooltip" data-placement="top" title="Pls enter Valid Aadhar No." 
   											value = <%=session.getAttribute("inputHKMAadharNo") %>>
   										</div>
   										<div class="form-group col-lg-3 ">
     										<label for="inputHKMMobile"><%=Information.mobile%></label>
      										 <input type="text" class="form-control " id="inputHKMMobile" name="inputHKMMobile" placeholder="" 
      										  value = <%=session.getAttribute("inputHKMMobile") %> >
  										</div>
 									</div>
									<div class="form-row ">
								    	<div class="col-sm-11 offset-sm-1">
	 										<label>*All fields are mandatory </label>
									    </div>
								  	</div>
									<br/>
									<br />
 									<br/> <br />
									<div class="form-row ">
								    	<div class="col-sm-2 offset-sm-8">
									      	<button type="button" class="form-control text-white" id="cont06" name = "cont06" 
									      	data-toggle="collapse" data-target="#collapseSeven" aria-expanded="true" 
									      	aria-controls="collapseSeven" style="background-color:#2EA2E2">Continue... </button>
									    </div>
								  	</div>
  	
  								</div>
  							</div>
  						</div>
   						<div id="collapseSeven" class="collapse multi-collapse" aria-labelledby="headingSeven " data-parent="#accordion">
    						<div class="card-body " style="background-color: #FAF7F5 ;" >
								<div class="form-row">
									<br /> <br />
   									<div class="form-group col-lg-4 offset-sm-2">
   										<label for="inputOwnEmail4"><%=Information.email%></label>
    										<input type="email" class="form-control is-invalid" id="inputOwnEmail4" name="inputOwnEmail4" placeholder="email@example.com"  
  											data-toggle="tooltip" data-placement="top" title="We'll never share your email with anyone else." 
  											 value = <%=session.getAttribute("inputOwnEmail4") %> required>
  									</div>
  									<div class="form-group col-lg-4 ">
    									<label for="inputOwnMobile"><%=Information.mobile%></label>
     									 <input type="text" class="form-control is-invalid" id="inputOwnMobile" name="inputOwnMobile" placeholder="" 
     									  value = <%=session.getAttribute("inputOwnMobileNo") %> required>
 									</div>
								</div>
<%-- 								<div class="form-row ">
 									<div class="col-lg-4 offset-sm-2">
   										 <label for="inputOwnFName"><%=Information.fname%></label>
    									 <input type="text" class="form-control is-invalid" id="inputOwnFName" name="inputOwnFName" placeholder=""  required>
									</div>
									<div class="col-lg-4 offset-sm-0">
										<label  for="inputOwnLName"><%=Information.lname%></label>
    									 <input type="text" class="form-control is-invalid" id="inputOwnLName" name="inputOwnLName" placeholder=""  >
									</div>
								</div>
 --%>     										

								<div class="form-row ">
							    	<div class="col-sm-11 offset-sm-2">
 										<label>*All fields are mandatory </label>
								    </div>
							  	</div>
								<br/>
								<br />
								<div class="form-row" id="Final">
							    	<div class="col-sm-2 offset-sm-8">
								      	<button type="submit" class="form-control  text-white" id="submit01" 
								      	name = "submit01" style="background-color:#38ACEC" ><%=Information.Submit %> </button>
								    </div>
							  	</div>
   							</div>
						</div>
 
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
		                	<li class="list-inline-item "><a class="text-light" href="#"> <%=Information.MTC%>/ </a> </li>
		                	<li class="list-inline-item "><a class="text-light" href="#"> <%=Information.PP %>/ </a> </li>
		                	<li class="list-inline-item "><a class="text-light" href="#"> <%=Information.OTC%> </a> </li>
		                	<li class="list-inline-item "><a class="text-light" href="#"> %=Information.TC %> </a> </li>
		                </ul>
		        	</div>
					<div class="col-lg-12 text-center text-white bg-dark"> 
			        	%=Information.Browser %>
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

			
			$('#House').click(function(){
	            $('#House').attr("background-color", "red"); 
			});
			$('#Employment').click(function(){
				$('.panel-collapse.collapse').collapse('hide');	
			});


			
 			
			$('#SameAddress').click(function(event){
	            $('#inputCAddress').val($('#inputPAddress').val()); 
	            $('#inputCBlock').val($('#inputBlock').val()); 
	            $('#inputCSector').val($('#inputSector').val()); 
	            $('#inputCCity').val($('#inputCity').val()); 
	            $('#inputCState').val($('#inputState').val()); 
	            $('#inputCCountry').val($('#inputCountry').val()); 
	            $('#inputCPincode').val($('#inputpincode').val()); 
				

	            $('#inputCAddress').attr("readonly", "readonly"); 
	            $('#inputCBlock').attr("readonly", "readonly"); 
	            $('#inputCSector').attr("readonly", "readonly"); 
	            $('#inputCCity').attr("readonly", "readonly"); 
	            $('#inputCState').attr("readonly", "readonly"); 
	            $('#inputCCountry').attr("readonly", "readonly"); 
	            $('#inputCPincode').attr("readonly", "readonly"); 
			});

			
 
			 $('form[id="DwellerNEW"]').validate({
				    rules: {
				    	inpuFfName: {
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
					  },
					  inputOwnEmail4: {
						  minlength:4
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

</html>

