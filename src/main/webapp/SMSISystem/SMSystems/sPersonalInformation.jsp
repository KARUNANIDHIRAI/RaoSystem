<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.MaintWork.MaintConstant"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 			<link rel="stylesheet" href="css/custom.css" type="text/css"> -->
<!-- 			<link rel="stylesheet" href="../css/custom.css" type="text/css"> -->
			<link rel="stylesheet" href="../../css/custom.css" type="text/css">
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
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>			

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
										style="background-color: #000080" href="#"><%=MaintConstant.New%> <%=MaintConstant.User%> <%=MaintConstant.Login%> <%=MaintConstant.Info%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 text-center offset-sm-0">
						<p class ="h5 text-center">Student and Parent's Personal Informations </p>
					</div>
				</div>
				<div class="col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
 								<%session.removeAttribute("Message");%> 
			    		</div>
			  		</div>
					<div class="row"> 
						<br />
						<div class="col-sm-8 offset-sm-0 bg-light ">
							<div class="row">	
								<div class="col-sm-8 offset-sm-0">
									<p class="h5 text-primary">Personal Information</p>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<label for="sMobileNo" class="form-label h6">First Name*</label>
									<input type="text" class="form-control blinebl " id="fName" name="fName"
									pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 4 char" 
									placeholder="" required >
								</div>
								<div class="col-sm-5 offset-sm-0">
									<label for="sMobileNo" class="form-label h6">Last Name*</label>
									<input type="text" class="form-control   blinew " id="lName" 	name="lName" 
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 3 char"							
									placeholder="" required>
								</div>
							</div>
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<label for="dob" class="form-label">Gender*</label>
									<select id="gender" name="gender" class="form-control blinew" required>
										<option selected value ="Zero">Choose Gender*</option>
										<option value ="Male">Male</option>
										<option value ="Female">Female</option>
										<option value ="Trans">TransGender</option>
									</select>
								</div>
								<div class="col-sm-5 offset-sm-0">
									<label for="dob" class="form-label">Date of Birth*</label>
									<input type="text" class="form-control   blinew " id="dob" 	name="dob" 
											placeholder="" required>
								</div>
							</div>
							<div class="row">		
								<div class="col-sm-7 offset-sm-0">
									<label for="sIdProofNo" class="form-label">Id Proof No.*</label>
									<input type="text" class="form-control   blinew " id="sIdProofNo" name="sIdProofNo" required> 
								</div>
								<div class="col-sm-5 offset-sm-0">
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
								<div class="col-sm-7 offset-sm-0">
									<label for="admNo" class="form-label text-danger">Admission No.*</label>
									<input type="text" class="form-control   blinew " id="admNo" 	name="admNo" 
										 title="Enter character between [a-z, A-Z, 0-9] Min 5 char"							
										placeholder="" >
								</div>
								<div class="col-sm-5 offset-sm-0">
									<label for="dob" class="form-label">Admission Date*</label>
									<input type="text" class="form-control   blinew " id="admDate" 	name="admDate" 
										placeholder="" required>
								</div>
							</div>
							<div class="row">	
 								<div class="col-sm-3 offset-sm-0">
									<label for="admClass" class="form-label ">Adm.In Class*</label>
									<input type="text" class="form-control   blinew " id="admClass" 	name="admClass" 
										 title="Enter Admission taken in Class " placeholder=""  >
								</div>
								<div class="col-sm-4 offset-sm-0">
									<label for="sSection" class="form-label ">Section*</label>
									<input type="text" class="form-control   blinew " id="sSection" 	name="sSection" 
										 title="Enter Admission taken in Class " placeholder=""  >
								</div>
								<div class="col-sm-5 offset-sm-0">
									<label for="sRollNo" class="form-label">Roll No.*</label>
									<input type="text" class="form-control   blinew " id="sRollNo" 	name="sRollNo" 
										placeholder="" required>
								</div>
							</div>
							<div class="row">		
								<div class="col-sm-3 offset-sm-0 form-group form-check">
									<input type="checkbox" class="" id="confToSibling"
										   data-toggle="tooltip" data-placement="bottom"
									       title="clik to check box if your sibling studying in this school">
								    <label class=" text-danger" for="exampleCheck1">Sibling Studing</label>
								</div>
								<div class="col-sm-4 offset-sm-0">
									<label for="siblingNo" class="form-label">Number of sibling Studing*</label>
									<input type="text" class="form-control   blinew " id="siblingNo" 	name="siblingNo"  
									pattern="[0-9]" title="" placeholder="">
								</div>
								<div class="col-sm-5 offset-sm-0">
									<label for="curClass" class="form-label">Promoted in Class*</label>
									<input type="text" class="form-control   blinew " id="curClass" 	name="curClass" 
										placeholder="" required>
								</div>
							</div>
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<label for="course" class="form-label">Adimission in Course*</label>
									<select id="course" name="course" class="form-control blinew" required>
										<option selected value ="0" >Choose Course Name *</option>
										<option  value ="Arts">Arts</option>
										<option  value ="PanCard">Science</option>
										<option  value ="PAadharCArd">PCM</option>
										<option  value ="PVoterId">PCM with BIO</option>
										<option  value ="Other">Arts with Political Science </option>
									</select>
								</div>
							</div>
						</div>
						<br />
						<div class="col-sm-4 offset-sm-0"> 
							<div class="row">		
								<div class="col-sm-12 offset-sm-0 bg-light text-dark">
									<p class ="h5 text-center">Contact Details  </p>
								</div>
							</div>
							<br />
							<div class="col-sm-12 offset-sm-0 bg-light text-dark" id = "father">
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
										<label for="sMobileNo" class="form-label h6">Mobile No*</label>
										<input type="text" class="form-control blinebl" id="sMobileNo" 	name="sMobileNo" required 
									   pattern="[0-9\s]{10,100}"	>
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
										<label for="sEmail" class="form-label h6">Email ID</label>
										<input type="email" class="form-control   blinebl " id="sEmail" name="sEmail"  
										pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Student Email"
										title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
									</div>
								</div>
								<div class="row">		
									<div class="col-sm-12 offset-sm-0">
										<label for="pMobileNo" class="form-label h6">Parent Mobile No*</label>
										<input type="text" class="form-control blinebl" id="pMobileNo" 	name="pMobileNo" required 
									   pattern="[0-9\s]{10,100}">
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
										<label for="pEmail" class="form-label h6">Email ID</label>
										<input type="email" class="form-control   blinebl " id="pEmail" name="pEmail"  
										pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="parent Email"
										title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
									</div>
								</div>
								<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /> <br /> <br />
							</div>
						</div>	<!--  end ofparent -->
					</div>
				</div>	
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-12 offset-sm-0">
							<p class ="h5 text-primary">Parent Information </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<label for="mFName" class="form-label">Father First Name</label>
							<input type="text" class="form-control   blinew " id="fFName" 	name="fFName" required
							title="" placeholder="" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="mFName" class="form-label">Last Name</label>
							<input type="text" class="form-control    " id="fLName" name="fLName" 
							 placeholder="" style="border-top: 1px solid blue;" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<label for="mProfession" class="form-label">Profession</label>
							<select id="fprofession" name="fprofession" class="form-control blinew" required>
								<option selected value ="0" >Choose father profession*</option>
								<option  value ="Service">Service</option>
								<option  value ="Business">Business</option>
								<option  value ="Farming">Farming</option>
								<option  value ="Self Employed">Self Employed</option>
								<option  value ="Other">None </option>
							</select>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<label for="fIdDocType" class="form-label">Father ID Document Type</label>
							<select id="fIdDocType" name="fIdDocType" class="form-control blinew" required>
								<option selected value ="0" >Choose Father Id Doc Type *</option>
								<option  value ="AadharCard">Aadhar Card</option>
								<option  value ="PanCard">Pan Card</option>
								<option  value ="PAadharCArd">Parent Aadhar ID</option>
								<option  value ="PVoterId">Parent Voter ID</option>
								<option  value ="Other">None </option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="fIdDocType" class="form-label">ID Number</label>
							<input type="text" class="form-control   blinew " id="fIdProofNo" 	name="fIdProofNo" required 
							       placeholder="" >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<label for="mFName" class="form-label">Mother First Name</label>
							<input type="text" class="form-control   blinew " id="mFName" 	name="mFName" required
							    placeholder="" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="mFName" class="form-label">Last Name</label>
							<input type="text" class="form-control    " id="mLName" name="mLName" 
							       placeholder="" style="border-top: 1px solid blue;" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<label for="mProfession" class="form-label">Profession</label>
							<select id="mProfession" name="mProfession" class="form-control blinew" required>
								<option selected value ="0" >Choose Mother profession*</option>
								<option  value ="Service">Service</option>
								<option  value ="Business">Business</option>
								<option  value ="Farming">Farming</option>
								<option  value ="Self Employed">Self Employed</option>
								<option  value ="House Maker">House Maker</option>
								<option  value ="Other">None </option>
							</select>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<label for="mIdProofNo" class="form-label">ID Document Type</label>
							<select id="mIdDocType" name="mIdDocType" class="form-control blinew" required>
								<option selected value ="0" >Choose Mother Id Doc Type *</option>
								<option  value ="AadharCard">Aadhar Card</option>
								<option  value ="PanCard">Pan Card</option>
								<option  value ="PAadharCArd">Parent Aadhar ID</option>
								<option  value ="PVoterId">Parent Voter ID</option>
								<option  value ="Other">None </option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="mIdProofNo" class="form-label">ID Number</label>
							<input type="text" class="form-control   blinew " id="mIdProofNo" 	name="mIdProofNo" required 
							 placeholder="" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<label for="sPAIncome" class="form-label text-danger">Parent Annual Income*</label>
							<input type="number" class="form-control   blinew" id="sPAIncome" 	name="sPAIncome"  
							pattern="[0-9]{5,8}" >
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-12 offset-sm-0">
							<p class ="h5 text-primary">Residence Address </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="Address" 	name="Address" required
							       placeholder="Student Residential Address*" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control    " id="Sector" name="Sector" 
							        placeholder="Street/Sector*" style="border-top: 1px solid blue;" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control   blinew " id="City" 	name="City" required 
							 placeholder="City*" >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<select id="country" name="country" 	class="form-control    blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinew " id="State" 	name="State" required 
							 title="" placeholder="State*" >
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control   blinew" id="PostalCode" 	name="PostalCode"  
							pattern="[0-9]{6,8}" title=""placeholder="Pin Code" >
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-12 offset-sm-0">
							<p class ="h5 text-primary">Bank Details </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="bName" name="bName"  
							 placeholder="Bank Name" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="bBNnkName" name="bBNnkName" 
							 placeholder="Branch Place" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="bankCity" name="bankCity"  
							 placeholder="City Name" >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="acHName" name="acHName"  
							 placeholder="Account Holder Name"  >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="acNo" name="acNo"  
							 placeholder="Account number"  >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<select id="acType" name="acType" class="form-control blinew" >
								<option selected value ="0" >Choose Account Type *</option>
								<option  value ="Saving">Saving</option>
								<option  value ="Current">Current</option>
								<option  value ="Other">None </option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="ifsCode" name="ifsCode"  
							 placeholder="Bank IFSCODE" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="athCountry" name="athCountry" 	class="form-control    blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light text-dark">	
					<div class="row">		
						<br />
						<div class="col-sm-3 offset-sm-3 ">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
						</div>
						<div class="col-sm-3 offset-sm-0 ">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
						</div>
					</div>
				</div>	
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

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