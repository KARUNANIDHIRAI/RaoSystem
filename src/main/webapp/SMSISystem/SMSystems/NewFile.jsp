<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
			<link rel="stylesheet" href="../../css/Custom.css" type="text/css">
			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
		
		 
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
		  	<script type="text/javascript" src="../../js/CommonJSFile.js"></script>
	</head>
	<body>
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<p class ="h5">School Information </p>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="RegNo" 	name="RegNo" placeholder="School Registration No*" required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char" >
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
							pattern="[A-Za-z0-9,-_.\s]{5,40}" title="Enter character between a-z or A-Z Min 5 char">
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="email" class="form-control   blinebl " id="email" name="email" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Email*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="mobileNo" 	name="mobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl  " id="phoneNo" 	name="phoneNo" 
							pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*" >
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
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="Street/Sector*">
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
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="country" name="country" 	class="form-control    blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>


						<div class="col-sm-3">
							<input type="number" class="form-control   blinew" id="postalCode" 	name="postalCode"  
							pattern="[0-9]{6,8}" title=""placeholder="Postal Code*">
						</div>
					</div>
					<br />
				</div>
	
	</body>
</html>