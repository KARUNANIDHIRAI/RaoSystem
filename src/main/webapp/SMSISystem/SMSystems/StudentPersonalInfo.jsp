<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.MaintWork.MaintConstant"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	 	<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
	 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

		<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
		<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="SPInfo" name="SPInfo" action="../../StudentPInformation?Action=spInformation" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.STUDENT%> <%=SMFixedValue.PERSONAL%> <%=MaintConstant.Info%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 offset-sm-3" ><p> fill the  Student peronsonal information to Complete admission process</p></div>
				</div>
				<div class="row">
					<div class="col-sm-12 offset-sm-0 " >
						<div class="btn-group" role="group" aria-label="Basic example" Style ="width: 100%;">
							<button type="button" class="btn" id="1BT" onclick="showHideSI('1')" >Personal Information &#9744;</button>
							<button type="button" class="btn" id="2BT" onclick="showHideSI('2')" disabled>Address &#9744;</button>
							<button type="button" class="btn" id="3BT" onclick="showHideSI('3')" disabled>Parent Details &#9744;</button>
							<button type="button" class="btn" id="4BT" onclick="showHideSI('4')" disabled>Bank Details &#9744;</button>
							<button type="button" class="btn" id="5BT" onclick="showHideSI('5')" disabled>Contacts &#9744;</button>
							<button type="button" class="btn" id="6BT" onclick="showHideSI('6')" disabled>Transport &#9744;</button>
						</div>
					</div>	
				</div>
				<div class="row" id="1Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 1%;">
							</div>
						</div> <!--  progess 1 -->
 						<br />
					    <iframe id="sPInfoIFrame" name="sPInfoIFrame" style="width:100%;height:440px;"></iframe>
				
 						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
 								<div class="row">	
									<div class="col-sm-5 offset-sm-0">
										<label for="admNo" class="form-label text-danger">Admission No.*</label>
										<input type="text" class="form-control   blineTl " id="admNo" 	name="admNo" 
											 title="Enter character between [a-z, A-Z, 0-9] Min 5 char"							
											placeholder="" >
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="admDate" class="form-label">Admission Date*</label>
										<input type="text" class="form-control   blineTl " id="admDate" 	name="admDate" 
											placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="streamName" class="form-label">Adimission in Course*</label>
										<select id="streamName" name="streamName" class="form-control blinew" required>
											<option selected value ="0" >Choose Course Name *</option>
											<option  value ="Arts">Arts</option>
											<option  value ="PanCard">Science</option>
											<option  value ="PAadharCArd">PCM</option>
											<option  value ="PVoterId">PCM with BIO</option>
											<option  value ="Other">Arts with Political Science </option>
										</select>
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-5 offset-sm-0">
										<label for="rollNo" class="form-label">Roll No.*</label>
										<input type="text" class="form-control   blineTl " id="rollNo" 	name="rollNo" 
											placeholder="" required>
									</div>
									<br />
	 								<div class="col-sm-4 offset-sm-0">
										<label for="admInClass" class="form-label ">Admission In Class*</label>
										<input type="text" class="form-control   blineTl " id="admInClass" 	name="admInClass" 
											 title="Enter Admission taken in Class " placeholder=""  >
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="admInSection" class="form-label ">Section*</label>
										<input type="text" class="form-control   blineTl " id="admInSection" 	name="admInSection" 
											 title="Enter Admission taken in Class " placeholder=""  >
									</div>
								</div>
								<br />
							</div>
						</div>	
						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<br />
							<div class="col-sm-12 offset-sm-0 bg-light " style="padding-right: 5px">
								<div class="row">	
									<div class="col-sm-5 offset-sm-0">
										<label for="firstName" class="form-label h6">First Name*</label>
										<input type="text" class="form-control blineTl " id="firstName" name="firstName"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 4 char" 
										placeholder="" required >
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="lastName" class="form-label h6">Last Name*</label>
										<input type="text" class="form-control   blineTl " id="lastName" 	name="lastName" 
											pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 3 char"							
										placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="gender" class="form-label">Gender*</label>
										<select id="gender" name="gender" class="form-control blinew" required>
											<option selected value ="Zero">Choose Gender*</option>
											<option value ="Male">Male</option>
											<option value ="Female">Female</option>
											<option value ="Trans">TransGender</option>
										</select>
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-3 offset-sm-0">
										<label for="studentDob" class="form-label">Date of Birth*</label>
										<input type="text" class="form-control   blineTl " id="studentDob" 	name="studentDob" 
												placeholder="" required>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="siblingNo" class="form-label">Sibling *</label>
										<input type="text" class="form-control   blineTl " id="siblingNo" 	name="siblingNo"  
										pattern="[0-9]" title="" placeholder="">
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="idProofNo" class="form-label">Id Proof No.*</label>
										<input type="text" class="form-control   blineTl " id="idProofNo" name="idProofNo" required> 
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="docType" class="form-label">Document Type*</label>
										<select id="docType" name="docType" class="form-control blinew" required>
											<option selected value ="0" >Choose Id Document Type *</option>
											<option  value ="AadharCard">Aadhar Card</option>
											<option  value ="PanCard">Pan Card</option>
											<option  value ="PAadharCArd">Parent Aadhar ID</option>
											<option  value ="PVoterId">Parent Voter ID</option>
											<option  value ="Other">None </option>
										</select>
									</div>
								</div>
							</div>
						</div>	
						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light text-dark " >
								<div class="row">	
									<div class="col-sm-2  offset-sm-8 ">
										<button type="submit" id ="backSPI01" name="backSPI01" class="form-control  text-light 
										text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); 
										padding-left:0 px" disabled><%=SMFixedValue.BACK%></button>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="button" id ="subSInfo01" name="subSInfo01" class="form-control  text-light 
										text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
										 padding-left:0 px" onclick="saveContSIBtn('1')"><%=SMFixedValue.SAVE_NEXT %></button>
									</div>
								</div>
							</div>
						</div>	
					</div>	
				</div> <!-- End of the First Save And Continue -->
				<div class="row" id="2Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 19%">
							</div>
						</div> <!--  progess 1 -->
 						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
								<br />
 								<div class="row">	
									<div class="col-sm-8 offset-sm-0">
										<p class="h5 text-primary">Address</p>
									</div>
								</div>
 								<div class="row">	
									<div class="col-sm-5 offset-sm-0">
										<label for="houseAptNo" class="form-label text-danger">House/Apt No.*</label>
										<input type="text" class="form-control   blineTl " id="houseAptNo" 	name="houseAptNo" 
											 title="Enter character between [a-z, A-Z, 0-9] Min 5 char"							
											placeholder="" >
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="blockSector" class="form-label">Block/Sector*</label>
										<input type="text" class="form-control   blineTl " id="blockSector" 	name="blockSector" 
											placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="cityName" class="form-label"><%=SMFixedValue.CITY%>*</label>
										<input type="text" class="form-control   blineTl " id="cityName" 	name="cityName" >
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-5 offset-sm-0  form-group">
			 						    <label for="countryName" class ="h6"><%=SMFixedValue.COUNTRY%></label>
			 							<select id="countryName" name="countryName" 	class="form-control  blineTl" required >
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.COUNTRY%>*</option>
										</select>
									</div>
									<div class="col-sm-4 offset-sm-0  form-group">
			 						    <label for="stateName" class ="h6"><%=SMFixedValue.STATE%></label>
			 							<select id="stateName" name="stateName" class="form-control  blineTl" required >
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.STATE%>*</option>
										</select>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="zipCode" class="form-label"><%=SMFixedValue.PINCODE%>*</label>
										<input type="text" class="form-control   blineTl " id="zipCode" 	name="zipCode" 
											placeholder="" required>
									</div>
								</div>
								<br /> 
								<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
									<div class="col-sm-12 offset-sm-0 bg-light text-dark " >
										<div class="row">	
											<div class="col-sm-2  offset-sm-8 ">
												<button type="submit" id ="backSPI02" name="backSPI02" class="form-control  text-light 
												text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												padding-left:0 px" onclick="backNextSIBtn('2')"><%=SMFixedValue.BACK%></button>
											</div>
											<div class="col-sm-2 offset-sm-0 ">
												<button type="button" id ="subSInfo02" name="subSInfo02" class="form-control  text-light 
												text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); 
												padding-left:0 px" onclick="saveContSIBtn('2')"><%=SMFixedValue.SAVE_NEXT %></button>
											</div>
										</div>
										<br />
									</div>
								</div>	
							</div>
						</div>	
						<br /><br /><br />
					</div>
				</div>		
				<div class="row" id="3Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 33%">
							</div>
						</div> <!--  progess 1 -->
 						<br /><br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " style="padding-right: 5px">
								<br />
								<div class="row">	
									<div class="col-sm-4 offset-sm-0">
										<label for="fatherFirstName" class="form-label h6">Father First Name*</label>
										<input type="text" class="form-control blineTl " id="fatherFirstName" name="fatherFirstName"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 4 char" 
										placeholder="" required >
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="fatherLastName" class="form-label h6">Last Name*</label>
										<input type="text" class="form-control   blineTl " id="fatherLastName" 	name="fatherLastName" 
											pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 3 char"							
										placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="fatherProfession" class="form-label">Profession*</label>
										<select id="fatherProfession" name="fatherProfession" class="form-control blinew" required>
											<option selected value ="Zero">Choose Gender*</option>
											<option value ="GE">Government Employee</option>
											<option value ="PS">Private Sector Employee</option>
											<option value ="PBS">Public Sector Employee</option>
											<option value ="SE">Self Employed</option>
											<option value ="OTH">Other</option>
										</select>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="fatherAadhar" class="form-label">Aadhar Card No.*</label>
										<input type="text" class="form-control   blineTl " id="fatherAadhar" name="fatherAadhar" required> 
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-4 offset-sm-0">
										<label for="MotherFName" class="form-label h6">Mother First Name*</label>
										<input type="text" class="form-control blineTl " id="MotherFName" name="MotherFName"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 4 char" 
										placeholder="" required >
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="motherLastName" class="form-label h6">Last Name*</label>
										<input type="text" class="form-control   blineTl " id="motherLastName" 	name="motherLastName" 
											pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 3 char"							
										placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="motherProfession" class="form-label">Profession*</label>
										<select id="motherProfession" name="motherProfession" class="form-control blinew" required>
											<option selected value ="Zero">Choose Gender*</option>
											<option value ="GE">Government Employee</option>
											<option value ="PS">Private Sector Employee</option>
											<option value ="PBS">Public Sector Employee</option>
											<option value ="SE">Self Employed</option>
											<option value ="OTH">Other</option>
										</select>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="motherAadhar" class="form-label">Aadhar Card No.*</label>
										<input type="text" class="form-control   blineTl " id="motherAadhar" name="motherAadhar" required> 
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-2  offset-sm-8 ">
										<button type="submit" id ="backSPI03" name="backSPI03" class="form-control  text-light 
										text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
										 padding-left:0 px" onclick="backNextSIBtn('3')"><%=SMFixedValue.BACK%></button>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="button" id ="subSInfo03" name="subSInfo03" class="form-control  text-light 
										text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
										 padding-left:0 px" onclick="saveContSIBtn('3')"><%=SMFixedValue.SAVE_NEXT %></button>
									</div>
								</div>
								<br />
							</div>
						</div>	
 						<br /><br /><br /> <br />
					</div>	
				</div> <!-- End of the second Save And Continue -->
				<div class="row" id="4Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 51%">
							</div>
						</div> <!--  progess 1 -->
 						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
 								<div class="row">	
									<div class="col-sm-8 offset-sm-0">
										<p class="h5 text-primary">Bank Details</p>
									</div>
								</div>

 								<div class="row">	
									<div class="col-sm-5 offset-sm-0">
										<label for="bank" class="form-label text-danger"><%=SMFixedValue.BANK_NAME%>*</label>
										<input type="text" class="form-control   blineTl " id="bank" 	name="bank" 
											 title="Enter character between [a-z, A-Z, 0-9] Min 5 char"							
											placeholder="" >
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="branch" class="form-label"><%=SMFixedValue.BANK_BRANCH%>*</label>
										<input type="text" class="form-control   blineTl " id="branch" 	name="branch" 
											placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="ifsc" class="form-label"><%=SMFixedValue.BANK_IFSC%>*</label>
										<input type="text" class="form-control   blineTl " id="ifsc" 	name="ifsc" >
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-5 offset-sm-0  form-group">
			 						    <label for="accountHolderName" class ="h6"><%=SMFixedValue.ACCOUNT_HOLDER_NAME%></label>
										<input type="text" class="form-control   blineTl " id="accountHolderName" 	name="accountHolderName" 
											placeholder="" required>
									</div>
									<div class="col-sm-4 offset-sm-0  form-group">
			 						    <label for="bankAccount" class ="h6"><%=SMFixedValue.ACCOUNT_NO%></label>
										<input type="text" class="form-control   blineTl " id="bankAccount" 	name="bankAccount" 
											placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="acType" class="form-label"><%=SMFixedValue.ACCOUNT_TYPE%>*</label>
			 							<select id="acType" name="acType" 	class="form-control  blineTl" required>
											<option selected value ="1">Saving Account</option>
											<option selected value ="2">Current Account</option>
											<option selected value ="3">OD Account</option>
											<option selected value ="4">Salary Account</option>
										</select>
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-2 offset-sm-0  form-group">
			 						    <label for="accountHolderPan" class ="h6"><%=SMFixedValue.PANCARD_NO%></label>
										<input type="text" class="form-control   blineTl " id="accountHolderPan" 	name="accountHolderPan" 
											placeholder="" required>
									</div>
									<div class="col-sm-3 offset-sm-0  form-group">
			 						    <label for="bankCountryName" class ="h6"><%=SMFixedValue.COUNTRY%></label>
			 							<select id="bankCountryName" name="bankCountryName" class="form-control  blineTl" required >
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.COUNTRY%>*</option>
										</select>
									</div>
									<div class="col-sm-4 offset-sm-0  form-group">
			 						    <label for="bankStateName" class ="h6"><%=SMFixedValue.STATE%></label>
			 							<select id="bankStateName" name="bankStateName" 	class="form-control  blineTl" required >
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.STATE%>*</option>
										</select>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="bankCityName" class="form-label"><%=SMFixedValue.CITY%>*</label>
										<input type="text" class="form-control   blineTl " id="bankCityName" 	name="bankCityName" 
											placeholder="" required>
									</div>
								</div>
								<br />
								<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
									<div class="col-sm-12 offset-sm-0 bg-light text-dark " >
										<div class="row">	
											<div class="col-sm-2  offset-sm-8 ">
												<button type="submit" id ="backSPI04" name="backSPI04" class="form-control  text-light 
												text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												  padding-left:0 px" onclick="backNextSIBtn('4')"><%=SMFixedValue.BACK%></button>
											</div>
											<div class="col-sm-2 offset-sm-0 ">
												<button type="button" id ="subSInfo04" name="subSInfo04" class="form-control  text-light 
												text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												 padding-left:0 px" onclick="saveContSIBtn('4')"><%=SMFixedValue.SAVE_NEXT %></button>
											</div>
										</div>
									</div>
								</div>	
							</div>
							<br />
						</div>	
						<br /><br />
					</div>
				</div>		
				<div class="row" id="5Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated text-right" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 68%">
							</div>
						</div> <!--  progess 1 -->
 						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
 								<div class="row">	
									<div class="col-sm-8 offset-sm-0">
										<p class="h5 text-primary">Contact Details</p>
									</div>
								</div>
								<br />
 								<div class="row">	
									<div class="col-sm-4 offset-sm-1  form-group">
			   						    <label for="studentContact" class ="h6"><%=SMFixedValue.STUDENT%> <%=SMFixedValue.CONTACT_NO%>* </label>
										<input type="text" class="form-control   blineTl " id="studentContact" 	name="studentContact"  
										pattern="[0-9]" title="" placeholder="">
									</div>
			 						<div class="col-sm-6 offset-sm-0  form-group">
			  						    <label for="studentEmail" class ="h6"><%=SMFixedValue.EMAIL%>*</label>
										<input type="text" class="form-control   blineTl " id="studentEmail" 	name="studentEmail"  
										pattern="[0-9]" title="" placeholder="">
									</div>
								</div>
 								<div class="row">	
									<div class="col-sm-4 offset-sm-1  form-group">
			   						    <label for="fatherContact" class ="h6"><%=SMFixedValue.FATHER%> <%=SMFixedValue.CONTACT_NO%>* </label>
										<input type="text" class="form-control   blineTl " id="fatherContact" 	name="fatherContact"  
										pattern="[0-9]" title="" placeholder="">
									</div>
			 						<div class="col-sm-6 offset-sm-0  form-group">
			  						    <label for="fatherEmail" class ="h6"><%=SMFixedValue.EMAIL%>*</label>
										<input type="text" class="form-control   blineTl " id="fatherEmail" 	name="fatherEmail"  
										pattern="[0-9]" title="" placeholder="">
									</div>
								</div>
 								<div class="row">	
									<div class="col-sm-4 offset-sm-1  form-group">
			   						    <label for="motherContact" class ="h6"><%=SMFixedValue.MOTHER%> <%=SMFixedValue.CONTACT_NO%>* </label>
										<input type="text" class="form-control   blineTl " id="motherContact" 	name="motherContact"  
										pattern="[0-9]" title="" placeholder="">
									</div>
			 						<div class="col-sm-6	 offset-sm-0  form-group">
			  						    <label for="motherEmail" class ="h6"><%=SMFixedValue.EMAIL%>*</label>
										<input type="text" class="form-control   blineTl " id="motherEmail" 	name="motherEmail"  
										pattern="[0-9]" title="" placeholder="">
									</div>
								</div>
								<br />
								<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
									<div class="col-sm-12 offset-sm-0 bg-light text-dark " >
										<div class="row">	
											<div class="col-sm-2  offset-sm-7 ">
												<button type="submit" id ="backSPI05" name="backSPI05" class="form-control  text-light 
												text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												 padding-left:0 px" onclick="backNextSIBtn('5')"><%=SMFixedValue.BACK%></button>
											</div>
											<div class="col-sm-2 offset-sm-0 ">
												<button type="button" id ="subSInfo05" name="subSInfo05" class="form-control  text-light 
												text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												 padding-left:0 px" onclick="saveContSIBtn('5')"><%=SMFixedValue.SAVE_NEXT %></button>
											</div>
										</div>
									</div>
								</div>	
							</div>
						</div>	
					</div>
				</div>		
				<div class="row" id="6Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 83%"><p>Contact Details </p>
							</div>
						</div> <!--  progess 1 -->
 						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
 								<div class="row">	
									<div class="col-sm-8 offset-sm-0">
										<p class="h5 text-primary">Transport Facility Availing Details</p>
									</div>
								</div>
								<br />
 								<div class="row">	
									<div class="col-sm-4 offset-sm-0  form-group">
			   						    <label for="routeNo" class ="h6"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%>* 
											[<a href="#" target="popup" rel="noopener noreferrer"
											onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/TransportRoute.jsp','Create New Trasnport Route','width=800,height=425, Top=100, left=250')">
											<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%></span></a>]</label>
			 							<select id="routeNo" name="routeNo" 	class="form-control  blineTl" required>
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%> *</option>
										</select>
									</div>
			 						<div class="col-sm-4 offset-sm-0  form-group">
			  						    <label for="pickId" class ="h6"><%=SMFixedValue.PICKUP_POINT%>*
											[<a href="http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp" target="popup" rel="noopener noreferrer"
											onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp','Create New Pickup & Drop','width=950,height=450, Top=100, left=250')">
											<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.PICKUP_POINT%> </span></a>]</label>
			 							<select id="pickId" name="pickId" 	class="form-control  blineTl" required>
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.PICKUP_DROP_TIME%>*</option>
										</select>
									</div>
			 						<div class="col-sm-4 offset-sm-0  form-group">
			  						    <label for="dropId" class ="h6"><%=SMFixedValue.DROP_POINT%>*
											[<a href="http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp" target="popup" rel="noopener noreferrer"
											onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp','Create New Pickup & Drop','width=950,height=450, Top=100, left=250')">
											<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.DROP_POINT%> </span></a>]</label>
			 							<select id="dropId" name="dropId" 	class="form-control  blineTl" required>
											<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.PICKUP_DROP_TIME%>*</option>
										</select>
									</div>
								</div>
								<br />
								<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
									<div class="col-sm-12 offset-sm-0 bg-light text-dark " >
										<div class="row">	
											<div class="col-sm-2  offset-sm-8 ">
												<button type="submit" id ="backSPI06" name="backSPI06" class="form-control  text-light 
												text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												 padding-left:0 px" onclick="backNextSIBtn('6')"><%=SMFixedValue.BACK%></button>
											</div>
											<div class="col-sm-2 offset-sm-0 ">
												<button type="button" id ="subSInfo06" name="subSInfo06" class="form-control  text-light 
												text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
												 padding-left:0 px" onclick="saveContSIBtn('6')"><%=SMFixedValue.SAVE_NEXT %></button>
											</div>
										</div>
									</div>
								</div>
								<br /> 	
							</div>
						</div>	
							<br /> <br /> <br /><br /><br /><br />
					</div>
				</div>	
				<div class="row" id="7Sc">
					<div class="col-sm-12 offset-sm-0">
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
							     aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
							</div>
						</div> <!--  progess 1 -->
 						<br /><br /><br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
 								<div class="row">	
									<br />
									<div class="col-sm-8 offset-sm-3">
										<p class="h5 text-primary">Student Personal Information Summary</p>
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-2  offset-sm-10 ">
										<button type="submit" id ="backSPI06" name="backSPI06" class="form-control  text-light 
										text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
										 padding-left:0 px" onclick="backNextSIBtn('7')"><%=SMFixedValue.BACK%></button>
									</div>
								</div>
								<br /> 	
							</div>
						</div>	
						<br /> <br /> <br /><br /><br /><br /><br /><br /><br /><br />
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		var routeNo="";
 		var pickId ="";
 		var dropId ="";
 		var stateList=" ";
 		var countryList=" ";
 		var bCountryList=" ";
 		
 		var bStateList=" ";
 		$("#studentDob").datepicker({dateFormat: 'yy-dd-mm'});
		$("#admDate").datepicker({dateFormat: 'yy-dd-mm'});
		const backNextIndex = ["#0Sc","#1Sc", "#2Sc", "#3Sc", "#4Sc", "#5Sc" , "#6Sc", "#7Sc"];
		const btnSelectedSi = ["#0BT","#1BT", "#2BT", "#3BT", "#4BT", "#5BT" , "#6BT"];
		const seltectedBtnMsg = ["Student","Personal Information &#9745;", "Address &#9745;", "Parent Details &#9745", "Bank Details &#9745", "Contact &#9745","Transport &#9745"];	
	
		
		function hideDivOnPageLoad(){
			for(var i=2; i<=7 ;i++){
 				$(backNextIndex[i]).hide();
		   	}
		}

		const lblCountry =["#countryName", "#bankCountryName"];
		const lblState =["#stateName", "#bankStateName"];
		const lblPickupDrop =["#pickId","#dropId"]
		var pickUpDrops=[" "," "];
		var states=[" ", " "];
		var countries=[" "," "];
//		var countries=["countryList","bCountryList"];
//		countries[0]=" ";
//		countries[1]=" ";
		
//		var textCountries="";
		$("#sPInfoIFrame").hide();
		$("#subSInfo01").prop('disabled', true)
		
		function showHideSI(indx){
			for(var i=1; i<=7 ;i++){
				i==indx?$(backNextIndex[i]).show():$(backNextIndex[i]).hide();
			}
		}
 	    function backNextSIBtn(btnIndex){
 			if(btnIndex!=1){
 				$(backNextIndex[btnIndex]).hide();
				$(backNextIndex[btnIndex-1]).show();
			}
		}
	    function saveContSIBtn(scIndex){
			$(btnSelectedSi[scIndex]).html(seltectedBtnMsg[scIndex]);
 			if(scIndex<=6){
	    		$(backNextIndex[scIndex]).hide();
	    		$(backNextIndex[parseInt(scIndex)+1]).show();
			}
		}
		function showStudentPersonalInfo(admNo){
			var request =$.ajax({
				type:'GET',
				data:{Action:"XSTProfile"},
			 	dataType: 'json',
				url:'http://localhost:8088/smsi/sInformation/StudentInfo?admNo='+ admNo,
				success:function(result){
					$.each(result.data, function(id, name){
						alert(result.data);
						$("#regNo").text(name.regNo);
						$("#SName").text(name.firstName + "  "+name.lastName);
						$("#gender").text(name.gender);
						$("#studentDob").text(name.studentDob);
						$("#admNo").text(name.admNo );
						$("#admDate").text(name.admDate);
						$("#admInClass").text(name.admInClass + ", Section " + name.admInSection); 
 						$("#Section").text(name.admInSection);
						$("#rollNo").text(name.rollNo);
						$("#streamName").text(name.streamName);
						$("#idProofNo").text(name.idProofNo + "  , Document - "+name.docType );
						$("#docType").text(name.docType);
						$("#siblingNo").text(name.siblingNo);
						$("#emailId").text(name.emailId);

	 					$("#sFName").text(name.fatherFirstName + " " + name.fatherLastName );
						$("#sMName").text(name.motherFirstName + " " + name.motherLastName);

						$("#houseAptNo").text(name.houseAptNo);
						$("#blockSector").text(name.blockSector);
						$("#cityName").text(name.cityName);
						$("#stateName").text(name.stateName);
						$("#countryName").text(name.countryName);
						$("#zipCode").text(name.zipCode);

						$("#bank").text(name.bank);
						$("#branch").text(name.branch);
						$("#ifsc").text(name.ifsc);
						$("#bankAccount").text(name.bankAccount + " , A/c Type -" + name.acType );
						$("#accountHolderName").text(name.accountHolderName);
						$("#acType").text(name.acType);
						$("#accountHolderPan").text(name.accountHolderPan);
						$("#bankCityName").text(name.bankCityName);
						$("#bankStateName").text(name.bankStateName + ", Country - " +name.bankCountryName);
						$("#bankCountryName").text(name.bankCountryName);
						
						$("#studentContact").text(name.studentContact);
						$("#fatherContact").text(name.fatherContact);
						$("#motherContact").text(name.motherContact);
						$("#fatherEmail").text(name.fatherEmail);
						$("#motherEmail").text(name.motherEmail);

						$("#routeName").text(name.routeName);
						$("#pickupPoint").text(name.pickupPoint);
						$("#dropPoint").text(name.dropPoint);
						$("#pickupTime").text(name.pickupTime);
						$("#dropTime").text(name.dropTime);
					});
				}	
			});	 // eof AJAX
		}    	 
 		$(document).ready(function(){
			hideDivOnPageLoad();
			$("#subSInfo01").click(function(){
	    		$("#1BT").html(seltectedBtnMsg[1]);
	            var studentInfo = {};
	            $.each($("form").serializeArray(), function(key, value) {
	            	studentInfo['"'+value.name+'"'] =value.value;
	            });
	            var request =$.ajax({
	    			type:'POST',
	    			headers: { 'Content-Type':'application/json'},	
	//    			data: JSON.stringify(studentInfo),
	     			data: JSON.stringify({"admNo":$("#admNo").val(),           "admDate":$("#admDate").val(),
					                      "streamName":$("#streamName").val(), "rollNo":$("#rollNo").val(),
					 					  "admInClass": $("#admInClass").val(),"admInSection":$("#admInSection").val(),
					 					  "firstName": $("#firstName").val(),  "lastName":$("#lastName").val(),
					                      "gender": $("#gender").val(),         "studentDob":$("#studentDob").val(),
					                      "idProofNo": $("#idProofNo").val(),   "docType":$("#docType").val(),
					                      "siblingNo":$("#siblingNo").val(),    "currentClass":$("#currentClass").val() }),
	 				dataType: 'JSON',
	    			url:'http://localhost:8088/smsi/sInformation/CRStudentInfo',
			   		success:function(result){
			   			$(btnSelectedSi[2]).prop('disabled', false);
			   			xXShowStudentInfoList(result);
	   				}	
	    		});	 
	    	});
			$("#subSInfo02").click(function(){
	    		$("#2BT").html(seltectedBtnMsg[2]);
	            var request =$.ajax({
	    			type:'PUT',
	    			headers: { 'Content-Type':'application/json'},	
	     			data: JSON.stringify({"houseAptNo":$("#houseAptNo").val()   , "blockSector":$("#blockSector").val(),
					 					  "cityName": $("#cityName").val()      , "stateName":$("#stateName").val(),
					 					  "countryName": $("#countryName").val(), "zipCode":$("#zipCode").val()}),
	 				dataType: 'JSON',
	    			url:'http://localhost:8088/smsi/sInformation/SAddress?admNo='+$("#admNo").val(),
			   		success:function(result){
			   			$(btnSelectedSi[3]).prop('disabled', false);
			   			xXShowStudentInfoList(result);
	   				}	
	    		});	 
	    	});

			$("#subSInfo03").click(function(){
	    		$("#3BT").html(seltectedBtnMsg[3]);
	            var request =$.ajax({
	    			type:'PUT',
	    			headers: { 'Content-Type':'application/json'},	
	     			data: JSON.stringify({"fatherFirstName":$("#fatherFirstName").val(), "fatherLastName":$("#fatherLastName").val(),
	 					  "fatherProfession": $("#fatherProfession").val(),"fatherAadhar":$("#fatherAadhar").val(),
	 					  "MotherFName": $("#MotherFName").val(),  "motherLastName":$("#motherLastName").val(),
	 					 "motherProfession": $("#motherProfession").val(),  "motherAadhar":$("#motherAadhar").val()}),
					dataType: 'JSON',
					url:'http://localhost:8088/smsi/sInformation/SParent?admNo='+$("#admNo").val(),
			   		success:function(result){
			   			$(btnSelectedSi[4]).prop('disabled', false);
			   			xXShowStudentInfoList(result);
	   				}	
	    		});	 
	    	});

			$("#subSInfo04").click(function(){
	    		$("#4BT").html(seltectedBtnMsg[4]);
	            var request =$.ajax({
	    			type:'PUT',
	    			headers: { 'Content-Type':'application/json'},	
	     			data: JSON.stringify({"bank":$("#bank").val(), "branch":$("#branch").val(),
	 					                  "ifsc": $("#ifsc").val(),"accountHolderName":$("#accountHolderName").val(),
	 					                  "bankAccount": $("#bankAccount").val(),  "acType":$("#acType").val(),
	 					                  "accountHolderPan": $("#accountHolderPan").val(),  "bankCityName":$("#bankCityName").val(),
	 					                  "bankStateName": $("#bankStateName").val(),  "bankCountryName":$("#bankCountryName").val()}),
					dataType: 'JSON',
					url:'http://localhost:8088/smsi/sInformation/SBank?admNo='+$("#admNo").val(),
			   		success:function(result){
			   			$(btnSelectedSi[5]).prop('disabled', false);
			   			xXShowStudentInfoList(result);
	   				}	
	    		});	 
	    	});
			$("#subSInfo05").click(function(){
	    		$("#5BT").html(seltectedBtnMsg[5]);
	            var request =$.ajax({
	    			type:'PUT',
	    			headers: { 'Content-Type':'application/json'},	
	     			data: JSON.stringify({"studentContact":$("#studentContact").val(), "studentEmail":$("#studentEmail").val(),
	 					                  "fatherContact": $("#fatherContact").val(),"fatherEmail":$("#fatherEmail").val(),
	 					                  "motherContact": $("#motherContact").val(),  "motherEmail":$("#motherEmail").val()}),
					dataType: 'JSON',
					url:'http://localhost:8088/smsi/sInformation/SContact?admNo='+$("#admNo").val(),
			   		success:function(result){
			   			$(btnSelectedSi[6]).prop('disabled', false);
			   			xXShowStudentInfoList(result);
	   				}	
	    		});	 
	    	});
			$("#subSInfo06").click(function(){
	    		$("#6BT").html(seltectedBtnMsg[6]);
	    		var pickUpId= extractInfo($("#pickId").val(),2);
	            var request =$.ajax({
	    			type:'PUT',
	    			headers: { 'Content-Type':'application/json'},	
	     			data: JSON.stringify({"routeNo":$("#routeNo").val(), "pickId":pickUpId,
	 					                  "dropId":extractInfo( $("#dropId").val(),2),"vehicleIdNo":$("#vehicleIdNo").val()}),
					dataType: 'JSON',
					url:'http://localhost:8088/smsi/sInformation/STransport?admNo='+$("#admNo").val(),
			   		success:function(result){
			   			$(btnSelectedSi[1]).prop('disabled', false);
			   			xXShowStudentInfoList(result);
	   				}	
	    		});	 
	    	});
			$("#subSInfo07").click(function(){
	    		$("#7BT").html(seltectedBtnMsg[7]);
	    	});
			$("#routeNo").click(function(){
	    		if (routeNo!=""){	return;	}
	    		routeNo="";
	    		var request =$.ajax({
	    			type:'GET',
	    			data:{},
	    		 	dataType: 'Json',
 	    			url:'http://localhost:8088/smsi/transportInfo/RouteInfo?regNo=MK308',
	    			success:function(result){
	    				routeNo+=" <option selected value=0>Choose Transport Route*</option>";
	    				$.each(result.data, function(id, name){
	    					routeNo+=" <option value='"+name.idNo +"'>"+ name.routeName +" --> "+name.routeDescription+ "</option>";
	    				});
	    				$("#routeNo").html(routeNo);
	    			}	 
	    		});	
	    	}); 
	    	$("#admNo").focusout(function(){
//	    		$("#sPInfoIFrame").show();
				var admNo = $("#admNo").val();
				var request =$.ajax({
					type:'GET',
					data:{Action:"XSTProfile"},
				 	dataType: 'json',
					url:'http://localhost:8088/smsi/sInformation/StudentInfo?admNo='+ admNo,
					success:function(result){
						$.each(result.data, function(id, name){
							if(name.admNo!=null){
								var url = "http://localhost:8085/RAOSystem/SMSISystem/SMSystems/StudentPersonalInfo.html?admNo="+ admNo;
								 window.open(url,"_blank","width=1100,height=550,screenX=50,left=50,screenY=50,top=50");
								 return;
							}else{$("#subSInfo01").prop('disabled', false)}
						});
					}	
				});
	    	});  

			$("#pickId").click(function(){
	     		var routeId = $("#routeNo").val();
	     		pickupDrop(0,routeId);

/* 	     		if (pickId!=""){	return;	}
	    		pickId="";
	    		var request =$.ajax({
	    			type:'GET',
	    			data:{},
	    		 	dataType: 'Json',
	    			url:'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId+"&spd=PP",
	    			success:function(result){
	    				pickId+=" <option selected value=0>Choose Transport Route*</option>";
	    				$.each(result.data, function(id,name){ 
	    						pickId+=" <option value='"+name.rid +"'>"+ name.routePDP +" --> "+name.routePDPTime+ "</option>";
	    				});
	    				$("#pickId").html(pickId);
	    			}	
	    		});	
 */	    		
	    	});  
	    	$("#dropId").click(function(){
	     		var routeId = $("#routeNo").val();
	     		pickupDrop(1,routeId);
/* 	     		if (dropId!=""){	return;	}
	    		dropId="";
	    		var request =$.ajax({
	    			type:'GET',
	    			data:{},
	    		 	dataType: 'Json',
	    			url:'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId+"&spd=DP",
	    			success:function(result){
	    				dropId+=" <option selected value=0>Choose Transport Route*</option>";
	    				$.each(result.data, function(id,name){ 
	    						dropId+=" <option value='"+name.rid +"'>"+ name.routePDP +" --> "+name.routePDPTime+ "</option>";
	    				});
	    				$("#dropId").html(dropId);
	    			}	
	    		});	
 */
	    	}); 

    		function extractInfo(strText, indx){
       			 	return indx==1?strText.substring(0,strText.indexOf("/")):strText.substring(strText.indexOf("/")+1);
	    	};
	    	
	    	function country(indx){
				if (countries[indx]!=" "){	return;}
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/transportInfo/country',	
					success:function(result){
						countries[indx]+=" <option selected value=0>Choose Country *</option>";
						$.each(result.data, function(id, states){
							$.each(states, function(id, name){
								countries[indx]+=" <option value='"+name.name +"'>"+name.name+"</option>";
							});
							$(lblCountry[indx]).html(countries[indx]);
						});
					}	
				});	 // eof AJAX
			}
			$("#countryName").click(function(){
		         country(0);
			});	
			$("#bankCountryName").click(function(){
		         country(1);
			});	
			$("#stateName").click(function(){
				selectState(0);
			});	
			$("#bankStateName").click(function(){
				selectState(1);
			});	
			
			//tbnDisable();					
	    	function selectState(indx){
				if (states[indx]!=" "){	return;}
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/transportInfo/state',	
					success:function(result){
						states[indx]+=" <option selected value=0>Choose State Name *</option>";
						$.each(result.data, function(id, states){
							$.each(states, function(id, name){
								states[indx]+=" <option value='"+name.name +"'>"+name.name+"</option>";
							});
							$(lblState[indx]).html(states[indx]);
						});
					}	
				});	 // eof AJAX
			}
			
	    	function pickupDrop(indx, routeId){
				const PDP=["&spd=PP","&spd=DP"];
				if (pickUpDrops[indx]!=" "){	return;}
				var urlPD ='http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId + PDP[indx];
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
				 	url: 'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId + PDP[indx],
					success:function(result){
						pickUpDrops[indx]+=" <option selected value=0>Choose Transport Route *</option>";
	    				$.each(result.data, function(id,name){ 
	    					pickUpDrops[indx]+=" <option value='"+name.rid +"'>"+ name.routePDP +" --> "+name.routePDPTime+ "</option>";
    					});
 						$(lblPickupDrop[indx]).html(pickUpDrops[indx]);
					}	
				});	 // eof AJAX
			}
 		});// eof doc
	</script>
</html>