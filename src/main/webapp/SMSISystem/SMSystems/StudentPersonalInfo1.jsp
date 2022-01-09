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
	
		<div class="container">
			<form id="SPInfo" name="SPInfo" action="../../StudentPInformation?Action=spInformation" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light " >
								<div class="row">	
									<div class="col-sm-8 offset-sm-0">
										<p class="h5 text-primary">Admission Information</p>
									</div>
								</div>
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
							<div class="col-sm-12 offset-sm-0 bg-light " >
								<div class="row">	
									<div class="col-sm-8 offset-sm-0">
										<p class="h5 text-primary">Personal Information</p>
									</div>
								</div>
							</div>
							<br />
							<div class="col-sm-12 offset-sm-0 bg-light " style="padding-right: 5px">
								<div class="row">	
									<div class="col-sm-5 offset-sm-0">
										<label for="sFName" class="form-label h6">First Name*</label>
										<input type="text" class="form-control blineTl " id="sFName" name="sFName"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 4 char" 
										placeholder="" required >
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="sLName" class="form-label h6">Last Name*</label>
										<input type="text" class="form-control   blineTl " id="sLName" 	name="sLName" 
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
									<div class="col-sm-5 offset-sm-0">
										<label for="dob" class="form-label">Date of Birth*</label>
										<input type="text" class="form-control   blineTl " id="dob" 	name="dob" 
												placeholder="" required>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="idProofNo" class="form-label">Id Proof No.*</label>
										<input type="text" class="form-control   blineTl " id="idProofNo" name="idProofNo" required> 
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="sIdDocType" class="form-label">Document Type*</label>
										<select id="sIdDocType" name="sIdDocType" class="form-control blinew" required>
											<option selected value ="0" >Choose Id Document Type *</option>
											<option  value ="AadharCard">Aadhar Card</option>
											<option  value ="PanCard">Pan Card</option>
											<option  value ="PAadharCArd">Parent Aadhar ID</option>
											<option  value ="PVoterId">Parent Voter ID</option>
											<option  value ="Other">None </option>
										</select>
									</div>
								</div>
								<div class="row">		
									<div class="col-sm-5 offset-sm-0">
										<label for="siblingNo" class="form-label">Number of sibling Studing*</label>
										<input type="text" class="form-control   blineTl " id="siblingNo" 	name="siblingNo"  
										pattern="[0-9]" title="" placeholder="">
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="curClass" class="form-label">Promoted in Class*</label>
										<input type="text" class="form-control   blineTl " id="curClass" 	name="curClass" 
											placeholder="" required>
									</div>
								</div>
								<br />
							</div>
						</div>	
						<br />
						<div class="row" style="padding-right: 5px; margin-left: 0px;"> 
							<div class="col-sm-12 offset-sm-0 bg-light text-dark " >
								<div class="row">	
									<div class="col-sm-2  offset-sm-8 ">
										<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
										text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="button" id ="subRwa01" name="subRwa01" class="form-control  text-light 
										text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=SMFixedValue.SAVE_CONT %></button>
									</div>
								</div>
							</div>
						</div>	
					</div>	
				</div>
				<br />
			</form>
		</div>					
	</body>
	<script type="text/javascript">
/* 	$("#dob").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
 */
	$(document).ready(function(){
/* 	 	$("#dob").datetimepicker({
			timepicker: false,
			datepicker: true,
			format: 'd-m-yy', // formate date
			step: 5,	
			yearStart:yearStart(),
			yearEnd:'2030',
			weeks:true	
		});
 */
 		$("#dob").datepicker();
		$("#admDate").datepicker();
	});
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	</script>
</html>