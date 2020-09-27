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
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

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

			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		 
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body id = "ULInfoLoad" onload="ulInfo()">
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../UserLoginInfo?Action=EditUser" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=MaintConstant.Edit%> <%=MaintConstant.User%> <%=MaintConstant.Login%> <%=MaintConstant.Info%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
 								<%session.removeAttribute("Message");%> 
			    		</div>
			  		</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<p class ="h5"><%=MaintConstant.User%> <%=MaintConstant.Info%> </p>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="RwaNo" 	name="RwaNo" placeholder="Rwa Registration No*" required readonly
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char" >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="UserType" 	name="UserType" value="Site User" required readonly
							pattern="[A-Za-z0-9,-_.\s]{5,40}" title="Enter character between a-z or A-Z Min 5 char">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control blinebl " id="Fname" name="Fname" 
							placeholder="First Name*" required>

						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl " id="Lname" 	name="Lname" placeholder="Last Name*" required>
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="text" class="form-control   blinebl " id="mobileNo" 	name="mobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinebl  " id="SecurityNo" 	name="SecurityNo" required
							pattern="[0-9]{4,4}" placeholder="Security No* " >
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<input type="email" class="form-control   blinebl " id="email" name="email" required  readonly
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Login User Id[EmailId]*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
						</div>
						<div class="col-sm-5 offset-sm-0">
							<input type="password" class="form-control   blinebr " id="Password" name="Password" required 
						   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
						   title="Must contain at least one number and one uppercase and lowercase letter,
						    and at least 8 or more characters" placeholder="Login Password*" >
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5">RWA Address </p>
						</div>
					</div>
					<br />
					
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="Address" 	name="Address" required readonly
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="RWA Registration Address*">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<input type="text" class="form-control   blinew  " id="Sector" name="Sector"  readonly
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="Sector">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<input type="text" class="form-control   blinew " id="City" 	name="City" required readonly
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="City*">
						</div>
					</div>
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<input type="text" class="form-control   blinew " id="State" 	name="State" required readonly
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<select id="country" name="country" 	class="form-control    blinew" required readonly>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-3">
							<input type="number" class="form-control   blinew" id="postalCode" 	name="postalCode"  readonly
							pattern="[0-9]{6,8}" title=""placeholder="Postal Code">
						</div>
					</div>
					<br />
				</div>
				<br />
				<br />
				<div class="row">		
					<div class="col-sm-2 offset-sm-4 ">
						<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
						text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
					</div>
					<div class="col-sm-2 offset-sm-0 ">
						<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
						text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
					</div>
				</div>
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">

 	</script>
</html>
