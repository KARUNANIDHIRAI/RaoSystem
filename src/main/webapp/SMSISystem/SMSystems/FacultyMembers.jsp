<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>
<!-- 			<link rel="stylesheet" href="../../css/custom.css" type="text/css"> -->
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
		
			<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
		  	<script type="text/javascript" src="../../js/SMFC.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
		  	
	</head>
	<body >
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="xfmInfo" name="SchInfo" action="../../FacultyInformation?Action=XNMFaculty" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.CREATE%> <%=SMFixedValue.FACULTY%> <%=SMFixedValue.MEMBER%>  </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
 					<div class="row">		
						<div class="col-sm-12 offset-sm-0 ">
							<p class ="h5  text-center">Fill <%=SMFixedValue.FACULTY%> <%=SMFixedValue.INFORMATION%> for Creating New Member  </p>
						</div>
					</div>
				<div class="bg-light col-sm-12 offset-sm-0">
 					<div class="row">		
						<div class="col-sm-5 offset-sm-0 ">
							<p class ="h6 "><%=SMFixedValue.EMPLOYMENT%> <%=SMFixedValue.INFORMATION%>  </p>
						</div>
					</div>
 					<div class="row">	
						<div class="col-sm-4 offset-sm-0">
						    <label for="RegNo" class ="h6"><%=SMFixedValue.School%> <%=SMFixedValue.Code%></label>
							<input type="text" class="form-control   blinebl " id="RegNo" 	name="RegNo"  required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char"  value="MK12708">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="faculty" class ="h6"><%=SMFixedValue.FACULTY%> </label>
							<select id="faculty" name="faculty" 	class="form-control    blinew" required>
								<option selected value ="0">Choose Faculty*</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="designation" class ="h6"><%=SMFixedValue.DESIGNATION%> </label>
							<input type="text" class="form-control   blinebl " id="designation" 	name="designation"  required
							pattern="[A-Za-z0-9,-_.\s]{2,40}" title="Enter character between a-z or A-Z.Min 2 char"  value="GM">
						</div>
					</div>
						<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="fmCode" class ="h6"><%=SMFixedValue.EMPLOYEE%> <%=SMFixedValue.CODE%></label>
							<input type="text" class="form-control   blinebl " id="fmCode" 	name="fmCode" placeholder="Employee Code*" required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char"  value="DPS101">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="doj" class="form-label h6"><%=SMFixedValue.DOJ%>*</label>
							<input type="text" class="form-control   blinebl " id="doj" 	name="doj"	placeholder="" required>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="dor" class="form-label h6"><%=SMFixedValue.DOR%>*</label>
							<input type="text" class="form-control   blinebl " id="dor" 	name="dor"	placeholder="" required>
						</div>
					</div>	
						<br />
 				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-0 ">
							<p class ="h5 "><%=SMFixedValue.PERSONAL%> <%=SMFixedValue.DETAILS%>   </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="Name" class ="h6"><%=SMFixedValue.Name%> </label>
							<input type="text" class="form-control   blinebl " id="Name" 	name="Name" placeholder="Name*" required
							pattern="[A-Za-z0-9,-_.\s]{4,40}" title="Enter character between a-z or A-Z.Min 4 char"  value="K N RAI">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="lName" class ="h6"><%=SMFixedValue.LNAME%> </label>
							<input type="text" class="form-control   blinebl " id="lName" 	name="lName" placeholder="last Name*" required
							 title="Enter character between a-z or A-Z.Min 4 char"  value="RAIG ">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="Gender" class="form-label h6"><%=SMFixedValue.GENDER%>*</label>
							<select id="Gender" name="Gender" 	class="form-control    blinew" required>
								<option selected value ="0">Choose Gender*</option>
							</select>
						</div>
					</div>	
						<br />
 					<div class="row">	
						<div class="col-sm-4 offset-sm-0">
							<label for="dob" class="form-label h6"><%=SMFixedValue.DOB%>*</label>
							<input type="text" class="form-control   blinebl " id="dob" 	name="dob"	placeholder="" required>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="fmQaul" class ="h6"><%=SMFixedValue.QUALIFICATION%> </label>
							<input type="text" class="form-control   blinebl " id="fmQaul" 	name="fmQaul"  required
							pattern="[A-Za-z0-9,-_.\s]{2,100}" title="Enter character between a-z or A-Z.Min 2 char"  value="BSC">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="skillArea" class ="h6"><%=SMFixedValue.SKILLS%> </label>
							<input type="text" class="form-control   blinebl " id="skillArea" 	name="skillArea"  required
							pattern="[A-Za-z0-9,-_.\s]{4,40}" title="Enter character between a-z or A-Z.Min 4 char"  value="PHYSICS, MATHS">
						</div>

					</div>
					<br />
				</div>
				<br />				
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5 "><%=SMFixedValue.CONTACT%> <%=SMFixedValue.INFORMATION%> </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="email" class ="h6"><%=SMFixedValue.EMAIL%> </label>
							<input type="email" class="form-control   blinebl " id="email" name="email" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Email*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="MobileNo" class ="h6"><%=SMFixedValue.MOBILE%> </label>
							<input type="text" class="form-control   blinebl " id="MobileNo" 	name="MobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" value="9811557160">
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="PhoneNo" class ="h6"><%=SMFixedValue.PHONE%> </label>
							<input type="text" class="form-control   blinebl  " id="PhoneNo" 	name="PhoneNo" 
							pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*" value="9811557161">
						</div>
					</div>
					<br />					
				</div>
				<br />					
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5 "><%=SMFixedValue.ADDRESS%> </p>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blineTl" id="Address" 	name="Address" required
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="School Registration Address*">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blineTl  " id="Sector" name="Sector" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="Street/Sector*" value="NEW DELHI">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control   blineTl " id="City" 	name="City" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="City*">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="State" 	name="State" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*" value="KARNATAKA">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="country" name="country" 	class="form-control    blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control   blinebl" id="postalCode" 	name="postalCode"  
							pattern="[0-9]{6,8}" title=""placeholder="Postal Code*" value="560100">
						</div>
					</div>
					<br />
				</div>
				<br />
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
							<button type="submit" id ="subSch01" name="subSch01" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=SMFixedValue.SUBMIT %></button>
						</div>
					</div>
				</div>
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$(document).ready(function(){
		});// document.ready eof
	</script>
</html>
