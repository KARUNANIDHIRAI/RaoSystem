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
			<link rel="stylesheet" href="../../css/custom.css" type="text/css">
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
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
			<form id="TNTInfo" name="TNTInfo" action="../../SFeePaymentInfo?Action=sFPInfo" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
						<p class ="h5 text-center">Student Fee Payment information page </p>
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
						<div class="col-sm-4 offset-sm-0 bg-light ">
							<div class="card" Style="Padding-top:0px">
								<div class="card-header text-white bg-info" id="headingOne">
									<div class="row">	
										<div class="col-sm-12 offset-sm-0">
											<p class="h6">Student Personal Information</p>
										</div>
									</div>
								</div>
								<div class="card-body text-dark bg-light" id="headingOne">
									<div class="row">	
										<div class="col-sm-12 offset-sm-0">
											<input type="text" class="form-control blinew " id="vFname" name="vFname"
											pattern="[A-Za-z\s]{3,40}" title="School Name " 
											placeholder="School First Name*" readonly value="KaruNanidhiRai">
										</div>
									</div>
									<div class="row">		
										<div class="col-sm-12 offset-sm-0 ">
										    <label for="sAdmNo" >Admission No</label>
											<input type="text" class="form-control blinew " id="sAdmNo" name="sAdmNo" required placeholder = "Enter Admission Number*" > 
										</div>
									</div>
								<div class="row">		
									<div class="col-sm-6 offset-sm-0 ">
									    <label for="sClass" >Student Class</label>
										<input type="text" class="form-control blinew " id="sClass" name="sClass" readonly value="10"> 
										
									</div>
									<div class="col-sm-6 offset-sm-0 ">
									    <label for="sSection" >Section</label>
										<input type="text" class="form-control blinew " id="sSection" name="sSection" readonly value="A" > 
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
									    <label for="sRollNo" >Roll Number*</label>
										<input type="text" class="form-control blinew " id="sRollNo" name="sRollNo" readonly value="101" >
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0">
									    <label for="sFLName" >Student Name </label>
										<input type="text" class="form-control   blinew " id="sFlName" 	name="sFlName" 
											placeholder="Student  Name" readonly value="PKRAI">
									</div>
								</div>
								<div class="row">		
									<div class="col-sm-12 offset-sm-0">
									    <label for="sClass" >Mobile No. </label>
										<input type="text" class="form-control   blinebl" id="sMobileNo" 	name="sMobileNo"  
									         placeholder="Mobile No (+91 XXXXXXXXXX)*" readonly>
									</div>
								</div>
								<div class="row">		
									<div class="col-sm-12 offset-sm-0">
									    <label for="sClass">Email ID </label>
										<input type="text" class="form-control   blinew " id="sEmail" 	name="sEmail"  
									            placeholder="Email id *" readonly >
									</div>
								</div>
									
								</div><!-- eof card body -->
							</div> <!-- EOF card  -->	

						</div>	


						<div class="col-sm-8 offset-sm-0 " > 
							<div class="card" Style="Padding-top:0px">
								<div class="card-header text-dark bg-light" id="headingOne">
									<div class="row">	
										<div class="col-sm-12 offset-sm-0">
											<p class="h6">Payment Information</p>
										</div>
									</div>
								</div>
								<div class="card-body text-dark bg-light" id="headingOne">
									<div class="col-sm-12 offset-sm-0 bg-light text-dark" id = "father">								
										<div class="row" id ="sCP12">		
											<div class="col-sm-4 offset-sm-0 ">
											    <label for="sClass">Fee Amount Due </label>
												<input type="text" class="form-control blinew " id="tFeeDue" name="tFeeDue" readonly> 
											</div>
											<div class="col-sm-4 offset-sm-0 ">
											    <label for="sClass">Fee Received </label>
												<input type="text" class="form-control blinew " id="feeAmtRecd" name="feeAmtRecd" required> 
											</div>
											<div class="col-sm-4 offset-sm-0 ">
											    <label for="sClass">Outstanding Fee Amount </label>
												<input type="text" class="form-control blinew " id="bFfeeAmt" name="bFfeeAmt" required> 
											</div>
										</div>
										<div class="row">		
											<div class="col-sm-8 offset-sm-0 ">
											    <label for="feeDepName" >Fee Depositor Name</label>
												<input type="text" class="form-control blinew " id="feeDepName" name="feeDepName" required value="Prashant Kumar Rai"> 
											</div>
											<div class="col-sm-4 offset-sm-0 ">
											    <label for="DepMobileNo" >Mobile No. </label>
												<input type="text" class="form-control blinew " id="DepMobileNo" name="DepMobileNo" required value="8929030202"> 
											</div>
										</div>
										<div class="row" id ="sPcxh">		
											<div class="col-sm-8 offset-sm-0 ">
											    <label for="dIdno" >Depositor ID No. </label>
												<input type="text" class="form-control blinew " id="dIdno" name="dIdno" required value="Aelpr301"> 
											</div>
											<div class="col-sm-4 offset-sm-0 ">
											    <label for="DepPanNo"  class="h6">Pan No. </label>
												<input type="text" class="form-control blinew " id="DepPanNo" name="DepPanNo" required value="A505"> 
											</div>
										</div>
										<div class="row" id ="sPcxh">		
											<div class="col-sm-8 offset-sm-0">
											    <label for="paymode" >Mode of Payment </label>
											    <select id="paymode" name="paymode" class="form-control"> 
											    	<option selected value ="None" > Choose mode of payment </option>
											    	<option  value ="Cash"> Cash </option>
											    	<option  value ="Cheque"> Cheque </option>
											    	<option  value ="DD"> Demand Draft </option>
											    </select>
											</div>
											<div class="col-sm-4 offset-sm-0 sFchq">
											    <label for="sFeeAmt" class ="text-danger h6">Fee Amount Paid </label>
												<input type="text" class="form-control   blinew " id="sFeeAmt" 	name="sFeeAmt" required
												pattern="[0-9]{1,8}"  placeholder="Fee Amount">
											</div>
											<br />
										</div>
										<br >
										<div id="sFchq">					
											<div class="row">		
												<br >
												<div class="col-sm-12 offset-sm-0">
													<p class ="h5 ">Cheque / Demand Draft Details</p>
												</div>
											</div>
											<div class="row">		
												<div class="col-sm-6 offset-sm-0">
												    <label for="sFChqNo" >Cheque Number* </label>
													<input type="text" class="form-control   blinew " id="ChqNo" 	name="ChqNo" required
													pattern="[A-Za-z[0-9]]{5,15}" title="" placeholder="" value="20200">
												</div>
												<div class="col-sm-6 offset-sm-0">
												   	<label for="ChqDate" >Cheque Issue Date*</label>
													<input type="text" class="form-control   blinew " id="ChqDate" 	name="ChqDate" required >
												</div>
											</div>
											<div class="row">		
												<div class="col-sm-6 offset-sm-0">
												    <label for="BankName" >Bank Name*</label>
													<input type="text" class="form-control   blinew" id="BankName" 	name="BankName" required 
													pattern="[A-Za-z\s]{3,100}"  value="HDFC BANK">
												</div>
												<div class="col-sm-6 offset-sm-0">
												    <label for="BranchName" >Branch Name*</label>
													<input type="text" class="form-control   blinew " id="BranchName" 	name="BranchName" required 
													 placeholder="" value="VASANT VIHAR">
												</div>
											</div>
											<div class="row">		
												<div class="col-sm-6">
												    <label for="City" >City Name*</label>
													<input type="text" class="form-control   blinew " id="City" 	name="City" required 
													pattern="[A-Za-z\s]{3,100}" value = "NEW DELHI">
												</div>
												<div class="col-sm-6">
												    <label for="sFchqIFSCode" >Bank IFSCode*</label>
													<input type="text" class="form-control   blinew " id="IFSCode" 	name="IFSCode" required 
													pattern="[A-Za-z[0-9]{5,50}" VALUE="HDFC000011">
												</div>
											</div>
										</div>
										<br />
									</div>	
								</div>	<!-- eof card body -->
							</div> <!--  eof card -->
						</div>	<!--  end of Visitor to be meet -->
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-5 offset-sm-1 ">
						<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
						text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
					</div>
					<div class="col-sm-5 offset-sm-0 ">
						<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
						text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
					</div>
				</div>
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
		$("#sClass").click(function(){
		countryOptions+=" <option value=0>Choose Student Class</option>";
			var classOptions="";
			for (var ctr=1; ctr<=12;+ctr){
				classOptions+=" <option value='"+ctr.toString() +"'>"+ ctr.toString() + "</option>";
			}
			$("#sClass").html(classOptions);
		});
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
		$("#ChqDate").datepicker();

	});
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	</script>
</html>