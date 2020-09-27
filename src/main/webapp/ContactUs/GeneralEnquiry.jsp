<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="../css/Custom.css" type="text/css">
			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
		 
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
		 
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body onload="GenEnqPageLoad();">
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../ContactUsInfo?Action=GenEnquiry" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-10 offset-sm-1 text-center">
						<h4> General Enquiry : Contact to our team</h4>
					</div>
				</div>
				<div class="row ">
					<div class="col-sm-10 offset-sm-1 text-center">
						<p>Please fill the form for general enquiry </p>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-10 offset-lg-1">
					<br />
					<div class="form-row ">
						<div class="col-lg-3 offset-lg-1">
							<select id="title" name="title" class="form-control form-control-lg is-invalid " style="border-top: 1px solid blue;">
								<option selected value="0">Title</option>
								<option  value="Mr">Mr</option>
								<option value="Mrs">Mrs</option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-lg-5 offset-lg-1">
							<input type="text" class="form-control form-control-lg" id="fName" 	name="fName" placeholder="First Name*"
							pattern="[A-Za-z\s]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char"
							style="border-top: 1px solid blue;">
						</div>
						<div class="col-lg-5 offset-lg-0">
							<input type="text" class="form-control form-control-lg" id="lName" 	name="lName" placeholder="Last Name*"
							pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z name lenght max 40 char"
							style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="email" class="form-control form-control-lg" id="email" name="email" 
							placeholder="Email*" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control form-control-lg" id="companyName" 	name="companyName" placeholder="Company Name**"
							pattern="[A-Za-z\s]{4,40}" title="Enter character between a-z or A-Z name 
							lenght max 40 char" style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<select id="country" name="country" 	class="form-control form-control-lg is-invalid" style="border-top: 1px solid blue;">
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control form-control-lg" id="city" 	name="city" 
							placeholder="City Name*" style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="number" class="form-control form-control-lg" id="postalCode" 	name="postalCode" 
							placeholder="Postal Code*" style="border-top: 1px solid blue;">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control form-control-lg" id="phoneNo" 	name="phoneNo" 
							placeholder="Phone (+91 XXXXXXXXXX)*" style="border-top: 1px solid blue;">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-10 offset-sm-1">
							<textarea rows="4" class="form-control form-control-lg" id="enquiryMsg" 	name="enquiryMsg" 
							style="border-top: 1px solid blue;"> Enter your Message*</textarea>
						</div>
					</div>
					<br />
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
								<button type="submit" id ="sub01" name="sub01" class="form-control form-control-lg text-light 
								text-center h5 btn btn-secondary" >Send</button>
						</div>
					</div>
					</div>
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	</script>
	

	
</html>