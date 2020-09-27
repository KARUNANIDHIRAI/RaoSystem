<%@page import="com.rao.System.MaintWork.MaintConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>

 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
   	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
 
 
 	</head>
	<body>
		<!-- Page Header -->
			<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<!-- Page Body -->
			<jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include>

		<br />
		<div class="container">
			<form id="ContMainPage" name="ContMainPage" action="#" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="row">
						  	<div class="col-sm-4">
						  		<div class="card text-center alert alert-secondary" >
						      		<h3> <span class="badge badge-secondary">General Enquiry</span></h3>
					        		<a href="../ContactUs/GeneralEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						  	<div class="col-sm-4">
						  		<div class="card text-center alert alert-secondary">
						      		<h3> <span class="badge badge-secondary">Business Enquiry</span></h3>
					        		<a href="../ContactUs/BusinessEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						  	<div class="col-sm-4">
						  		<div class="card text-center alert alert-secondary">
						      		<h3> <span class="badge badge-secondary">Product Demo Enquiry</span></h3>
					        		<a href="../ContactUs/ProdDemoEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						</div>
						<div class="row">
						  	<div class="col-sm-4">
						  		<div class="card text-center alert alert-secondary">
						      		<h3> <span class="badge badge-secondary">Collaboration Enquiry</span></h3>
					        		<a href="../ContactUs/CollaborationEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						  	<div class="col-sm-4">
						  		<div class="card text-center alert alert-secondary">
						      		<h3> <span class="badge badge-secondary">Job & Career Enquiry</span></h3>
					        		<a href="../ContactUs/JobsAndCareers.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						  	<div class="col-sm-4">
						  		<div class="card text-center alert alert-secondary">
						      		<h3> <span class="badge badge-secondary">Compliance Enquiry</span></h3>
					        		<a href="../ContactUs/ComplianceEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<br />
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../ContactUsInfo?Action=GenEnquiry" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-10 offset-sm-1 text-center">
						<h4> Contact : Contact to our team</h4>
					</div>
				</div>
				<div class="row ">
					<div class="col-sm-10 offset-sm-1 text-center">
						<p>Please fill the form and send us an enquiry concerning general question about KBS Technology </p>
					</div>
				</div>
				<br />
				<div class="row ">
					<div class="col-sm-10 offset-sm-1 text-center">
			    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
						<%session.removeAttribute("Message");%>
						<p id="er"> </p>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-10 offset-sm-1">
					<br />
					<div class="form-row ">
						<div class="col-sm-3 offset-sm-1">
							<select id="title" name="title" class="form-control blineb" required >
								<option selected value="0">Title</option>
								<option  value="Mr">Mr</option>
								<option value="Mrs">Mrs</option>
							</select>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control blineb"  id="fName" 	name="fName" placeholder="First Name*"
							pattern="[A-Za-z\s]{4,40}" title="Enter character between [a-z or A-Z ]." required>
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control blineb" id="lName" 	name="lName" placeholder="Last Name*"
							pattern="[A-Za-z\s]{3,40}" title="Enter character between [a-z or A-Z]." required>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="email" class="form-control blineb" id="email" name="email" 
							placeholder="Email*" title="xxxxxx@xxxx.xxx" required>
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control blineb" id="companyName" 
							name="companyName" placeholder="Company Name**"
							pattern="[A-Za-z\s]{4,40}" title="Enter character between a-z or A-Z " >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<select id="country" name="country"	class="form-control blineb" >
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control  blineb" id="city" 	name="city" 
							placeholder="City Name*" required>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="number" class="form-control  blineb" id="postalCode" name="postalCode" 
							placeholder="Postal Code*" >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control blineb" id="phoneNo" name="phoneNo" 
							placeholder="Phone (+91 XXXXXXXXXX)*" >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="form-group col-sm-10 offset-sm-1">
							<label>Enter your Message*</label>
							<textarea class="form-control blineb" maxlength="500" rows="5" id="textareaMsg" name="textareaMsg" >
							</textarea>
					        <span style ="font-size:11px; color:blue">Your full message should be maximum <strong> 500 character </strong> and  <span style ="font-size:11px;color:red" id="rchars"><strong> 0 </strong></span> </span> 
					        <span style ="font-size:11px;color:blue">Character(s) Remaining </span>
						</div>
					</div>
					<br />
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
								<button type="button" id ="contUsX" name="contUsX" class="form-control text-light 
								text-center h5 btn btn-warning" >Send</button>
						</div>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-10 offset-sm-1">
						<p class="h5">Hotline : India</p>
						<br />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-10 offset-sm-1">
						<p ><span class="h6">New Delhi :</span> +95 9999988888</p>
						<p ><span class="h6">Bangalore :</span> +95 7777766666</p>
						<br />
						<P># Charges vary depending on service provider and country/region</P>
						<br />
						<P>## callers from abroad, please use the international number</P>
					</div>
				</div>
				<br />
			</form>
		</div>
		<!--Footer  -->
		<jsp:include page="../Common/FooterPageKBS.jsp"></jsp:include>
		<jsp:include page="../FooterPage.jsp"></jsp:include>

	</body>
</html>





























