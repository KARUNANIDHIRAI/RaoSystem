<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/Custom.css" type="text/css">
	
		<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
		<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	
		<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	 
		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
	
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

		<script type="text/javascript" 	src="../webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
	 
	  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body>
		<div class="container">
			<form id="BusInfo" name="BusInfo" action="../ContactUs/ContactUsHeader.jsp" method="post"
			 class="" autocomplete="off" >
				<div class="row justify-content-md-center">
					<div class="col-sm-10 offset-sm-1 text-center">
						<h4> Business Enquiry : Contact to our team</h4>
					</div>
				</div>
				<div class="row ">
					<div class="col-sm-10 offset-sm-1 text-center">
						<p>Please fill the form for general enquiry </p>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-10 offset-sm-1">
					<br />
					<div class="form-row ">
						<div class="col-lg-3 offset-sm-1">
							<select id="title" name="title" class="form-control" style="border-bottom: 1px solid blue;"	 required >
								<option  value="0">Select Title</option>
								<option  value="Mr">Mr</option>
								<option value="Mrs">Mrs</option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-lg-5 offset-sm-1">
							<input type="text" class="form-control " id="fName" 	name="fName" placeholder="First Name*"
							pattern="[A-Za-z\S+]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char"
							style="border-bottom: 1px solid blue;" required >
						</div>
						<div class="col-lg-5 offset-sm-0">
							<input type="text" class="form-control is-invalid" id="lName" 	name="lName" placeholder="Last Name*"
							pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z name lenght max 40 char"
							style="border-bottom: 1px solid blue;" >
						</div>
					</div>
					<br />
					<br />
					<div class="row">		
						<div class="col-sm-10 offset-sm-1">
							<textarea rows="4" class="form-control" id="enquiryMsg" 	name="enquiryMsg" 
							style="border-bottom: 1px solid blue;"> Enter your Message*</textarea>
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
</html>