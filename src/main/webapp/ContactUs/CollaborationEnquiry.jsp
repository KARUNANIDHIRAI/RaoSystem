<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="css/custom.css" type="text/css">

	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>

	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

		<script type="text/javascript" 	src="../webjars/jquery-validation/1.19.0/jquery.validate.js"></script>	
		<script type="text/javascript" 	src="../webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
		<script type= "text/javascript" src="../webjars/bootstrap-maxlength/1.10.0/src/bootstrap-maxlength.js"></script>
	  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body>
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us -->
		<div class="container">
			<form id="BusInfo" name="BusInfo" action="../ContactUsInfo?Action=CLBEnquiry" method="post"
			 class="form-horizontal form-horizontal needs-validation" autocomplete="off" >
				<div class="row justify-content-md-center">
					<div class="col-sm-10 offset-sm-1 text-center">
						<h4> Collaboration Enquiry: Contact to our team</h4>
					</div>
				</div>
				<div class="row ">
					<div class="col-sm-10 offset-sm-1 text-center">
						<p>Please fill the form for general enquiry. </p>
					</div>
				</div>
				<div class="row ">
					<div class="col-sm-10 offset-sm-1 text-center">
			    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
						<%session.removeAttribute("Message");%>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-10 offset-sm-1">
					<br />
					<div class="form-row ">
						<div class="col-lg-3 offset-sm-1">
							<select id="title" name="title" class="form-control" style="border-top: 1px solid blue;border-left: 1px solid blue" required >
								<option selected value="Title" >Title*</option>
								<option  value="Mr">Mr</option>
								<option value="Mrs">Mrs</option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-lg-5 offset-sm-1">
							<input type="text" class="form-control  " id="fName" 	name="fName" placeholder="First Name*" required
								   style="border-top: 1px solid blue;border-left: 1px solid blue" 
								    pattern="[A-Za-z\s+]{3,100}" title="Enter character between a-z or A-Z name max 	length 100 char">
						</div>
						<div class="col-lg-5 offset-sm-0">
							<input type="text" class="form-control " id="lName" 	name="lName" placeholder="Last Name*" required
							style="border-top: 1px solid blue;border-left: 1px solid blue" 
							pattern="[A-Za-z\s+]{3,100}" title="Enter character between a-z or A-Z lname max length 100 char">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="email" class="form-control " id="email" name="email" required
							placeholder="Email*" style="border-top: 1px solid blue;border-left: 1px solid blue">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control " id="companyName" 	name="companyName" placeholder="Company Name**"
							pattern="[A-Za-z\s+]{0,40}" title="Enter character between a-z or A-Z name max 	length 40 char" 
							style="border-top: 1px solid blue;border-left: 1px solid blue" >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<select id="country" name="country" 	class="form-control in-valid" required style="border-top: 1px solid blue;">
								<option selected value ="0">Select Country Name</option>
							</select>
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control " id="city" 	name="city" required
							pattern="[A-Za-z\s+]{4,40}" title="Enter character between a-z or A-Z name max 	length 40 char"
							placeholder="City Name*" style="border-top: 1px solid blue;border-left: 1px solid blue">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="number" class="form-control " id="postalCode" 	name="postalCode" 
							pattern="[0-9]{6,10}" title="Enter digits between 0-9 max length 6-8 digits" 
							placeholder="Postal Code*" style="border-top: 1px solid blue;border-left: 1px solid blue">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control" id="phoneNo" 	name="phoneNo" 
							pattern="[0-9\S+]{6,20}" title="Enter digits between 0-9 " required
							placeholder="Phone (+91 XXXXXXXXXX)*" style="border-top: 1px solid blue;border-left: 1px solid blue">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<select id="Collaboration" name="Collaboration" class="form-control " 
							style="border-top: 1px solid blue;border-left: 1px solid blue"
							data-toggle="tooltip" title="">
								<option selected value ="0">Choose Collaboration Option</option>
							</select>
						</div>
					</div>	
					<br />
					<div class="row">		
						<div class="form-group col-sm-10 offset-sm-1">
							<label>Enter your Message*</label>
							<textarea class="form-control" maxlength="500" rows="5" id="textareaMsg" 	name="textareaMsg" 
								style="border-top: 1px solid blue;border-left: 1px solid blue;"> </textarea>
					            <span style ="font-size:11px; color:blue">Your full message should be maximum <strong> 500 character </strong> and  <span style ="font-size:11px;color:red" id="rchars"><strong> 0 </strong></span> </span> 
					            <span style ="font-size:11px;color:blue">Character(s) Remaining </span>
						</div>
					</div>
					<br />
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
								<button type="submit" id ="clSub01" name="clSub01" class="form-control text-light text-center h5 btn btn-secondary" 
								style="border-top: 1px solid blue;border-left: 1px solid blue;" >Send</button>
						</div>
					</div>
				</div>
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		<script type = "text/javaScript">
		</script>	
	</body>
</html>


