<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script> -->

<!-- 			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'> -->
<!-- 		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'> -->
<!-- 			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
<!-- 			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script> -->
		
<!-- 		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script> -->
<!-- 			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script> -->
		
 
<!-- 			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	 -->
<!-- 			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	 -->

<!-- 			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script> -->
<!-- 		  	<script type="text/javascript" src="../../js/SMCF.js"></script> -->

<!-- 			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script> -->
<!-- 			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'> -->

		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>



			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>

			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>

			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		 
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>


	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container">
			<form id="SchInfo" name="SchInfo" action="../../SchoolInfo?Action=information" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">

								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.RWA%> <%=Information.Registration%> <%=Information.Info%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
			    		</div>
			  		</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<p class ="h5">School Information </p>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="RegNo" 	name="RegNo" placeholder="School Registration No*" required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char"  value="MK12708">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control blinebl " id="RegDate" name="RegDate" 
							placeholder="Registration Date*" required>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="SchName" 	name="SchName" placeholder="School Name*" required
							pattern="[A-Za-z0-9,-_.\s]{5,40}" title="Enter character between a-z or A-Z Min 5 char" value="DAV PUBLIC SCHOOL">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="email" name="email" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Email*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " value="MK12708@GMAIL.COM">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="mobileNo" 	name="mobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" value="9811557160" >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl  " id="phoneNo" 	name="phoneNo" 
							pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*" value="9811557161" >
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-1">
							<p class ="h5 text-danger">User Login Credentials </p>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebr " id="LoginId" name="LoginId" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" 
							placeholder="Enter Login Id*" readonly >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="password" class="form-control   blinebr " id="Password" name="Password" required 
						   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
						   title="Must contain at least one number and one uppercase and lowercase letter,
						    and at least 8 or more characters" placeholder="Enter Login Password*" value="$MKabc12708$">
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5">Address </p>
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
							<input type="text" class="form-control   blinew " id="State" 	name="State" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*" value="KARNATAKA">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="country" name="country" 	class="form-control    blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>


						<div class="col-sm-3">
							<input type="number" class="form-control   blinew" id="postalCode" 	name="postalCode"  
							pattern="[0-9]{6,8}" title=""placeholder="Postal Code*" value="560100">
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5 ">Head Office Conact Information </p>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="email" class="form-control   blinebl " id="HoEmail" name="HoEmail" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Email*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="HoMobileNo" 	name="HoMobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control   blinebl  " id="HoPhoneNo" 	name="HoPhoneNo" 
							pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*" >
						</div>
					</div>
					<br />					
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h6">Address </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control    " id="HoAddress" 	name="HoAddress"
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="Head Office Address*" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control    " id="HoSector" name="HoSector" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="Street/Sector*" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control    " id="HoCity" 	name="HoCity" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="City*" style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control    " id="HoState" 	name="HoState" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="State*" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="athCountry" name="athCountry" 	class="form-control  " style="border-top: 1px solid blue;" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control    " id="HOPostalCode" 	name="HOPostalCode" 
							pattern="[0-9]{8,8}" title=""placeholder="Postal Code*" style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />					
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5">Social Media </p>
						</div>
					</div>
					<br />					
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control    " id="Facebook" 	name="Facebook"
							  placeholder="Facebook Link" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control    " id="Linkdin" name="Linkdin" 
							 placeholder="Linkdin" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control    " id="Twitter*" 	name="Twitter" 
							 placeholder="Twitter" style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />
				</div>
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
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=Information.Submit %></button>
						</div>
					</div>
				</div>
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">

/* 	var vDate = curDate();
	function curDate(){
		var cdate = new Date();
		var dd = cdate.getDate()<10 ? cdate.getDate() : "0" +cdate.getDate() ;
		var mm = cdate.getMonth()<10 ?cdate.getMonth(): "0" +(cdate.getMonth().toString()) ;
		var yyyy=cdate.getFullYear();
		var currdate = dd+ "/"+ mm +"/" + yyyy;
		return currdate;		
	}
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
 */	
	$(document).ready(function(){
		$("#RegDate").datepicker();
		$("#email").keypress(function(){
			$("#LoginId").val($("#email").val())
		});
	});// document.ready eof
	</script>
</html>
