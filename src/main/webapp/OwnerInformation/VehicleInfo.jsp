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

			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>


	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../HFlatOwnerInfo?Action=fONew" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
					<div class="col-sm-10 offset-sm-0">
						<p  class="h6 text-center"> Vehicle Info Linke with Apartment / Flat number</p>
					</div>
					<div class="col-sm-2 offset-sm-0 ">
						<button type="submit" id ="subOwnInfo01" name="subOwnInfo01" class="form-control  text-light 
						text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
						<%=Information.SaveBtn %> </button>
					</div>
				<br />
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
							<div class="col-sm-12 offset-sm-0 bg-light text-dark">
								<br />
								<div class="row">	
									<div class="col-sm-12 offset-sm-1">
										<p  class="text-center"> Apartment / Flat number</p>
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
									<div class="col-sm-11 offset-sm-0 " style="padding-right:0px">
										<select id="flatInfo" name="flatInof" class="form-control blinebl" required>
											<option selected value ="0">Select Flat No*</option>
										</select>
									</div>
									<div class="col-sm-1 offset-sm-0 " style="padding-left:0px">
										<button type="button" id ="vehlist01" name="vehlist01" 
										        class="form-control  text-light text-center h5 btn text-dark"
										 		data-toggle="tooltip" data-placement="left"
										 title="Click to view Vehicle List linked with this flat" >&#128065;</button>
									</div>
								</div>
				  		 	</div>
				  		 	<br />
			  		 	</div>
						<div class="col-sm-8 offset-sm-0 ">
							<div class="col-sm-12 offset-sm-0 bg-light text-dark">
								<div class="row">	
									<br />
									<div class="col-sm-12 offset-sm-1">
										<p  class="text-center"> Vehicle information</p>
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-6 offset-sm-0 ">
										<select id="VehType" name="VehType" class="form-control blinebl" required>
											<option selected value ="0">Select Vehicle Type*</option>
<!-- 											<option value ="1">SUV</option>
											<option value ="2">CAR</option>
											<option value ="3">SCOTTER</option>
											<option value ="4">Motor Cycle</option>
 -->									
 										</select>

<!-- 										<input type="text" class="form-control blinebl " id="VehType" name="VehType"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
										placeholder="Vehicle Types*" required>
 -->
									</div>
									<div class="col-sm-6 offset-sm-0 ">
										<input type="text" class="form-control blinebl " id="vehManfacturer" name="vehManfacturer"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
										placeholder="Vehicle Manufacturer*" required>
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-6 offset-sm-0">
										<input type="text" class="form-control   blinebl " id="vehModel" name="vehModel" required 
									   	placeholder="vehicle Name" >
									</div>
									<div class="col-sm-6 offset-sm-0 ">
										<input type="text" class="form-control blinebl " id="vehNo" name="vehNo"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
										placeholder="Vehicle Number*" required>
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-6 offset-sm-0">
										<input type="text" class="form-control   blinebl " id="vehColor" 	name="vehColor" 
											pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char"							
										placeholder="Vehicle Color*" required>
									</div>
								</div>
	 							<div class="row">	
									<div class="col-sm-3 offset-sm-9 ">
										<button type="button" id ="vehAdd01" name="vehAdd01" class="form-control  text-light 
										text-center h5 btn bg-secondary text-light" >	<%=Information.Add%><%=Information.info%></button>
									</div>
					  		 	</div>
 							</div>
						</div>
					</div>	
				</div>
				<div class="row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="vehOwnerList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
//	var flatOption=" ";
	$(document).ready(function(){
	});

 

 	
	</script>
</html>



