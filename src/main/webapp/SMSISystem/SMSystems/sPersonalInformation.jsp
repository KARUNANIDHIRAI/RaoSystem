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
			<link rel="stylesheet" href="../../css/Custom.css" type="text/css">
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

	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
					<div class="col-sm-8 offset-sm-0">
						<p class ="h5 text-center">Student Detail Informations </p>
						<p class ="text-center"> Please fill the form to Generate entry in School ERP  </p>
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
									<p class="h5">Personal Information</p>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<input type="text" class="form-control blinew " id="fName" name="fName"
									pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 4 char" 
									placeholder="Student First Name*" required>
								</div>
								<div class="col-sm-5 offset-sm-0">
									<input type="text" class="form-control   blinew " id="lName" 	name="lName" 
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char"							
									placeholder="Last Name*" required>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<select id="gender" name="gender" class="form-control blinew" required>
										<option selected value ="Zero">Select Gender*</option>
										<option selected value ="Male">Male</option>
										<option selected value ="Female">Female</option>
										<option selected value ="Trans">TransGender</option>
									</select>
								</div>
								<div class="col-sm-5 offset-sm-0">
									<input type="text" class="form-control   blinew " id="dob" 	name="dob" 
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char"							
									placeholder="Date of Birth*" required>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<input type="text" class="form-control   blinew " id="admNo" 	name="admNo" 
										pattern="[A-Za-z\s]{3,40}" title="Enter character between [a-z, A-Z, 0-9] Min 5 char"							
									placeholder="Admission No" >
								</div>
								<div class="col-sm-5 offset-sm-0">
									<input type="text" class="form-control   blinew " id="admDate" 	name="admDate" 
										pattern="" title=""	placeholder="Date of Admission*" required>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-7 offset-sm-0">
									<input type="text" class="form-control   blinew " id="admClass" 	name="admClass" 
										pattern="[A-Za-z\s]{3,40}" title="Enter Admission taken in Class "							
									placeholder="Admission Taken in Class" >
								</div>
								<div class="col-sm-5 offset-sm-0">
									<input type="text" class="form-control   blinew " id="curClass" 	name="curClass" 
										pattern="" title=""	placeholder="Promoted in class" required>
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-7 offset-sm-0">
									<label for="sIdProofNo" class="form-label">Id Proof Number*</label>
									<input type="text" class="form-control   blinew " id="sIdProofNo" 	name="sIdProofNo" required 
									pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="id number">
								</div>
								<div class="col-sm-5 offset-sm-0">
									<label for="sIdProofNo" class="form-label">Id Proof Document Type*</label>
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
							<br />
							<div class="row">		
								<div class="col-sm-3 offset-sm-0 form-group form-check">
									<input type="checkbox" class="form-check-input" id="confToSibling"
										   data-toggle="tooltip" data-placement="bottom"
									       title="clik to check box if your sibling studying in this school">
								    <label class="form-check-label text-danger" for="exampleCheck1">Sibling Studing</label>
								</div>
								<div class="col-sm-4 offset-sm-0">
									<label for="siblingNo" class="form-label">Number of sibling Studing*</label>
									<input type="text" class="form-control   blinew " id="siblingNo" 	name="siblingNo"  
									pattern="[0-9]" title="" placeholder="">
								</div>
							</div>
							<br />
						</div>
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
										<label for="exampleFormControlInput1" class="form-label">Mobile No*</label>
										<input type="text" class="form-control blinebl" id="sMobileNo" 	name="sMobileNo" required 
									   pattern="[0-9\s]{10,100}"	placeholder="" >
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
										<label for="sEmail" class="form-label">Email ID</label>
										<input type="email" class="form-control   blinebl " id="sEmail" name="sEmail"  
										pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Student Email"
										title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
									</div>
								</div>
								<div class="row">		
									<div class="col-sm-12 offset-sm-0">
										<label for="exampleFormControlInput1" class="form-label">Parent Mobile No*</label>
										<input type="text" class="form-control blinebl" id="pMobileNo" 	name="pMobileNo" required 
									   pattern="[0-9\s]{10,100}"	placeholder="" >
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
										<label for="pEmail" class="form-label">Email ID</label>
										<input type="email" class="form-control   blinebl " id="pEmail" name="pEmail"  
										pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="parent Email"
										title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
									</div>
								</div>
								<br /> <br /> <br /> <br /><br /> <br /> <br />
							</div>
						</div>	<!--  end ofparent -->
					</div>
				</div>	
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-12 offset-sm-0">
							<p class ="h5">Parent Information </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="fFName" 	name="fFName" required
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="Father first Name">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control    " id="fLName" name="fLName" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="Father Last Name" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-3 offset-sm-0">
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
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<select id="fatherIdDocType" name="fatherIdDocType" class="form-control blinew" required>
								<option selected value ="0" >Choose Id Document Type *</option>
								<option  value ="AadharCard">Aadhar Card</option>
								<option  value ="PanCard">Pan Card</option>
								<option  value ="PAadharCArd">Parent Aadhar ID</option>
								<option  value ="PVoterId">Parent Voter ID</option>
								<option  value ="Other">None </option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinew " id="mIdProofNo" 	name="mIdProofNo" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="id number">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="mFName" 	name="mFName" required
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="Mother first Name">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control    " id="mLName" name="mLName" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="Mother Last Name" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<select id="mprofession" name="mprofession" class="form-control blinew" required>
								<option selected value ="0" >Choose father profession*</option>
								<option  value ="Service">Service</option>
								<option  value ="Business">Business</option>
								<option  value ="Farming">Farming</option>
								<option  value ="Self Employed">Self Employed</option>
								<option  value ="House Maker">House Maker</option>
								<option  value ="Other">None </option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="mIdProofNo" 	name="mIdProofNo" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="Id number">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="motherIdDocType" name="motherIdDocType" class="form-control blinew" required>
								<option selected value ="0" >Choose Id Document Type *</option>
								<option  value ="AadharCard">Aadhar Card</option>
								<option  value ="PanCard">Pan Card</option>
								<option  value ="PAadharCArd">Parent Aadhar ID</option>
								<option  value ="PVoterId">Parent Voter ID</option>
								<option  value ="Other">None </option>
							</select>
						</div>
						<div class="col-sm-3 offset-sm-0">
							<label for="exampleFormControlInput1" class="form-label">Parent Annual Income</label>
							<input type="number" class="form-control   blinew" id="vPostalCode" 	name="vPostalCode"  
							pattern="[0-9]{5,8}" title=""placeholder="">
						</div>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-12 offset-sm-0">
							<p class ="h5">Residence Address </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="vAddress" 	name="vAddress" required
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="RWA Registration Address*">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control    " id="Sector" name="Sector" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="Street/Sector*" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control   blinew " id="city" 	name="city" required 
							pattern="[A-Za-z\s]{3,100}" title="" placeholder="City*">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<select id="country" name="country" class="form-control blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinew " id="vState" 	name="vState" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*">
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control   blinew" id="vPostalCode" 	name="vPostalCode"  
							pattern="[0-9]{6,8}" title=""placeholder="Pin Code">
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-12 offset-sm-0">
							<p class ="h5">Bank Details </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="email" class="form-control   blinebl " id="bName" name="bName" required 
							pattern="[A-Za-z0-9\s]{3,100}" placeholder="Bank Name" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="email" class="form-control   blinebl " id="bBNnkName" name="bBNnkName" required 
							pattern="[A-Za-z0-9\s]{3,100}" placeholder="Branch Place" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<select id="athCountry" name="athCountry" class="form-control blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="email" class="form-control   blinebl " id="acHName" name="acHName"  
							pattern="[A-Za-z0-9\s]{3,100}" placeholder="Account Holder Name" >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="email" class="form-control   blinebl " id="acNo" name="acNo"  
							pattern="[A-Za-z0-9\s]{3,100}" placeholder="Account number" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<select id="motherIdDocType" name="motherIdDocType" class="form-control blinew" >
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
							<input type="email" class="form-control   blinebl " id="ifsCode" name="ifsCode"  
							pattern="[A-Za-z0-9\s]{3,100}" placeholder="Bank IFSCODE" >
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
	$("#vDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});

	$(document).ready(function(){
		$("#dob").datepicker();
		$("#admDate").datepicker();
	});
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	</script>
</html>