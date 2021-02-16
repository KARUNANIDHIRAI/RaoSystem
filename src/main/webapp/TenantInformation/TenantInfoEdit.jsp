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
			<form id="TNTInfoXXI" name="TNTInfoXXI" action="../TenantInfo?Action=TNTNewI" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
										<option value ="Active">Active</option>
										<option value ="Closed">Closed</option>
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
										<input type = "text" id="apartment" name="apartment" class="form-control blinebl"
										 placeholder ="Apartment / Towre No*" required readonly >
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-12 offset-sm-0 " >
										<input type="text" id="flatInfo" name="flatInfo" class="form-control blinebl" 
										 placeholder ="Flat No*" required readonly >
									</div>
								</div>
								<br />
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
										<input type = "text" id="country" name="country" class="form-control blinebl" required
											data-toggle="tooltip" data-placement="bottom" title=" Select Country Name"
											placeholder="Country Name*" readonly>
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
										title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " readonly>
									</div>
								</div>
								<hr class="bg-danger"/>
								<div class="row">
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="shiftInOn">Shifted On*</label>
										<input type="text" class="form-control   blinebl  text-dark" 
										id="shiftInOn" name="shiftInOn" 	 readonly >
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 offset-sm-0 form-group">
									    <label for="shiftOutOn">Shifted Out On</label>
										<input type="text" class="form-control   blinebl  text-dark"  
											   id="shiftOutOn" name="shiftOutOn"  placeholder=""  
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
						<div class="col-sm-2 offset-sm-5 ">
							<button type="submit" id ="subOwnInfo01" name="subOwnInfo01" class="form-control  text-light 
							text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							<%=Information.SaveBtn %> </button>
						</div>
					</div>
				</div>
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
			var request =$.ajax({
				type:'POST',
				data:{"Action":"TNTInfoEDit",  "TNTIDNO" : 1},
			 	dataType: 'Json',
				url:'../TenantInfo',
				success:function(result){
					$.each( result, function(key,value) {
						$('#fName').val(value.FName);
						$('#lName').val(value.LName);
						$('#gender').val(value.Gender);
						$('#fFName').val(value.FFName);
						$('#fFLname').val(value.FFLName);

						
						$('#MobileNo').val(value.MobileNo);
						$('#phoneNo').val(value.Phone);
						$('#email').val(value.EmailID);
						$("#shiftInOn").val(value.ShiftOn);
				    	$("#shiftOutOn").val(value.ShiftOutOn);
						$('#Active').val(value.TNTStatus);
				    //	$("#Active option[value="+value.TNTStatus+"]").val(value.TNTStatus);	
				   // 	$("#Active option[value=Closed]").attr('selected', 'selected'); 			    	
				    	$('#apartment').val(value.AptartmentNo);
						$('#flatInfo').val(value.FlatNo);
/*	                    $("#Sector").val(value.Sector);
				    	$("#City").val(value.City) ;
				    	$("#State").val(value.State);
				    	$("#country option[value='"+value.Country+"']+").attr('selected', 'selected');				    	
				    	$("#postalCode").val(value.PinCode);
 */
					}); 	
				}	
			});	 // eof AJAX
	</script>
</html>
