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
		<link rel="stylesheet" href="../css/Custom.css" type="text/css">
		<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>
	 	<link rel="stylesheet" 	href='../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
	 	<link rel="stylesheet" 	href='../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

		<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

		<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" 	src="../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		<script type="text/javascript"	src="../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
	
		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
	  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
		<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>

	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../TenantInfo?Action=tntNew" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
					<div class="col-sm-12 offset-sm-0">
						<p class ="h5 text-center">Tenant Information </p>
						<p class ="text-center"> Please fill the form to complete the RWA process and future communication  </p>
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
							<br />
							<div class="row">	
								<div class="col-sm-10 offset-sm-1">
									<p  class="h6 text-center"> Personal Information</p>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0 ">
									<input type="text" class="form-control blinebl " id="fName" name="fName"
									pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
									placeholder="First Name" required>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0 ">
									<input type="text" class="form-control blinebl " id="lName" name="lName"
									pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
									placeholder="Last Name*" required>
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinebl " id="gender" 	name="gender" required 
								   	placeholder="Gender" >
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0 ">
									<input type="text" class="form-control blinebl " id="fFName" name="fFName"
									pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
									placeholder="Father /Mother First Name*" required>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinebl " id="fFLname" 	name="fFLname" 
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char"							
									placeholder="Father /Mother Last Name*" required>
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0 ">
									<select id="kncountry" name="kncountry" class="form-control blinebl bg-secondary text-light" required>
										<option selected value ="0">Choose Tenant Status</option>
										<option value ="1">Active</option>
										<option value ="2">Closed</option>
									</select>
								</div>
							</div>
			  		 	</div>
						<div class="col-sm-5 offset-sm-0 ">
							<div class="col-sm-12 offset-sm-0 bg-light text-dark">
								<br />
								<div class="row">	
									<div class="col-sm-10 offset-sm-1">
										<p  class="h6 text-center"> Communication Information</p>
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-12 offset-sm-0 ">
										<select id="apartment" name="apartment" class="form-control blinebl" required>
											<option selected value ="0">Choose Apartment*</option>
										</select>
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-12 offset-sm-0 " >
										<select id="flatInfo" name="flatInfo" class="form-control blinebl" required>
											<option selected value ="0">Select Flat No*</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6 offset-sm-6 " style="padding-left:0px; padding-bottom:0px">
										<button type="button" id ="rwaAddress" name="rwaAddress" 
										        class="form-control  text-primary text-right h5 btn "
										        Style="font-size: 10px; padding-bottom:0px"
										 		data-toggle="tooltip" data-placement="left"
										        title="Click to Retrieve address" > Import Address &#128065;</button>
									</div>
								</div>
								<div class="row">	
									<div class="col-sm-12 offset-sm-0 " style="padding-top:0px">
										<input type="text" class="form-control   blinebl " id="sector" 	name="sector" 
										pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="Block No / Sector*" readonly>
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-12 offset-sm-0 ">
									<input type="text" class="form-control   blinebl " id="city" 	name="city" required 
										pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="City Name *" readonly>
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-12 offset-sm-0 ">
										<select id="country" name="country" class="form-control blinebl" required
											data-toggle="tooltip" data-placement="bottom" title=" Select Country Name" readonly>
											<option selected value ="0">Country Name*</option>
										</select>
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-12 offset-sm-0 ">
										<input type="text" class="form-control   blinebl " id="state" 	name="state" required 
										pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="State Name*" readonly>
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-12 offset-sm-0 ">
										<input type="number" class="form-control   blinebl" id="pinCode" 	name="pinCode"  
										pattern="[0-9]{6,8}" title=""placeholder="Pin Code" readonly>
									</div>
								</div>
								<br />	  
				  		 	</div>
						</div>

						<div class="col-sm-3 offset-sm-0  ">
							<div class="col-sm-12 offset-sm-0 bg-light text-dark h6">
								<br />
								<div class="row">	
									<div class="col-sm-10 offset-sm-0">
										<p  class="h6 text-center"> Other Information</p>
									</div>
								</div>
								<br /> 
								<div class="row">		
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="MobileNo">Mobile Number</label>
										<input type="text" class="form-control   blinebl " id="MobileNo" 	name="MobileNo" required 
									   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="phoneNo">Phone Number</label>
										<input type="text" class="form-control   blinebl  " id="phoneNo" 	name="phoneNo" 
										pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*" >
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="email">Email ID</label>
										<input type="email" class="form-control   blinebl " id="email" name="email" required 
										pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="yyyyy@xxx.zzz"
										title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
									</div>
								</div>
								<hr class="bg-danger"/>
								<div class="row">
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="shiftInOn">Shifted On*</label>
										<input type="text" class="form-control   blinebl bg-secondary text-light" 
										id="shiftInOn" name="shiftInOn" 	 placeholder="" >
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="shiftOutOn">Shifted Out On</label>
										<input type="text" class="form-control   blinebl  text-light"  
											   id="shiftOutOn" name="shiftOutOn"  placeholder=""  readonly
											   title="Enter Date on which Tenant Moved out " >
									</div>
								</div>
				  		 	</div>
				  		 </div>	
			  		</div>
					<br />
				</div>
				<div class="col-sm-12 offset-sm-0 bg-light">
					<div class="row">		
						<div class="col-sm-2 offset-sm-4 ">
							<button type="submit" id ="cancelOwnInfo01" name="cancelOwnInfo01" class="form-control  text-light 
							text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
						</div>
						<div class="col-sm-2 offset-sm-0 ">
							<button type="submit" id ="subOwnInfo01" name="subOwnInfo01" class="form-control  text-light 
							text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							<%=Information.SaveBtn %> & <%=Information.Continue%></button>
						</div>
					</div>
				</div>
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	
	$(document).ready(function(){

		$("#rwaAddress").click(function() {
			countryList();
			var request = $.ajax({
				type:'POST',
				data:{Action:'rwaAddress'},	
				dataTyep:'json',
				url:'../TenantInfo',
				success:function(result){
					var addrResult = jQuery.parseJSON(result);
					$.each(addrResult, function(key,value) {
					   	$('#sector').val(value.Sector);
				    	$('#city').val(value.City) ;
				    	$("#state").val(value.State);
				    	$("#country option[value='"+value.Country+"']+").attr('selected', 'selected');				    	
//				    	$("#country").val(value.Country);				    	
				    	$("#pinCode").val(value.PinCode);
					});
				}	 
			});
		});

	});	

	
	</script>
</html>
