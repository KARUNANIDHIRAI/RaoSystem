<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	<link rel="stylesheet" href="css/Custom.css" type="text/css">
	
	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
 
	<script  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>


	<style type="text/css">
	   div.dataTables_wrapper {
       		width: 1100px;
       		margin: 0 auto;
   		}             
		td.highlight {
		    background-color: whitesmoke !important;
		}
	</style>
</head>
<body>
	<div class="container-flucid">
		<div class="row">
			<div class="col-lg-12 text-right  margin-left:0  margin-right:0px"
				style="background-color: #000080">
				<ul class="list-inline">
					<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%=Information.raoHome%></a></li>
					<li class="list-inline-item "><a class="text-light" href="LoginPage.jsp"> <%=Information.LogoutTitle%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"> <%=Information.joinPartner%></a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.reachus%></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container">
		<form id="DwellerNEW" name="DwellerNEW" action="" method="post"	class="form-horizontal needs-validation" autocomplete="off">
			<div class="row">
				<div class="col-xs-12">
					<div class="card" style="width: 72rem;">
						<div class="card-header text-center " style="background-color: #FFFFFF">
							<h5 class="card-title text-center"><%=Information.TNTInfo%></h5>
						</div>
					</div>
					<div class="card">
						<div class="form-row" id="Final">
							<div class="col-sm-2 offset-sm-8">
								<button type="button" class="form-control  text-white"
									id="Button1" name="Button1" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"><%=Information.GoToBack%>
								</button>
							</div>
						</div>
						<table id="datatable" class="hover display " style="width: 100%">
							<thead style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"" >
								<tr> 
                                	<th> </th>
                                   	<th> </th>
                                  	<th> </th>
                                   	<th> </th>
                                   	<th> </th>
                                   	<th> </th>
                                   	<th> </th>
                                   	<th> </th>
								</tr>
							</thead>

							<tbody>
								<tr class="h6">
									<td>Personal Details</td>
									<td><%=session.getAttribute("inputFName")%>  <%=session.getAttribute("inputLName")%></td>
									<td><%=session.getAttribute("inputGender")%></td>
									<td><%=session.getAttribute("inputEmail4")%></td>
									<td>(M):<%=session.getAttribute("inputMobile")%></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>Father's Name :</td>
									<td><%=session.getAttribute("inputFFName")%></td>
									<td><%=session.getAttribute("inputFLName")%></td>
									<td></td>
									<td>(M) <%= session.getAttribute("inputFMobile")== null?"": session.getAttribute("inputFMobile") %></td>
									<td></td>
									<td ></td>
									<td ></td>
								</tr>

								<tr class='h6'>
									<td>Dweller's Address </td>
									<td><%=session.getAttribute("inputPAddress")%></td>
									<td><%=session.getAttribute("inputBlock")%></td>
									<td><%=session.getAttribute("inputSector")%> </td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td><%=session.getAttribute("inputCity")%></td>
									<td><%=session.getAttribute("inputState")%></td>
									<td><%=session.getAttribute("inputCountry")%> </td>
									<td><%=session.getAttribute("inputPincode")%></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr class='h6'>
									<td ></td>
									<td>Shifted In : </td>
									<td><%=session.getAttribute("inputShiftIn")%></td>
									<td>Shifting Out :</td>
									<td> <%=session.getAttribute("inputShiftOut")%></td>
									<td ></td>
									<td ></td>
									<td></td>
								</tr>
								<tr class='h6'>
									<td>Dweller Permanent Address </td>
									<td><%=session.getAttribute("inputPAddress")%></td>
									<td><%=session.getAttribute("inputBlock")%></td>
									<td><%=session.getAttribute("inputSector")%> </td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td><%=session.getAttribute("inputCity")%></td>
									<td><%=session.getAttribute("inputState")%></td>
									<td><%=session.getAttribute("inputCountry")%> </td>
									<td><%=session.getAttribute("inputPincode")%></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>

								<tr>
									<td Class="h6">Dweller Employment Details </td>
									<td>Organization Name :</td>
									<td><%=session.getAttribute("inputPreOrgName")%></td>
									<td>Employee No : </td>
									<td><%=session.getAttribute("inputEmpNO")%></td>
									<td> </td>
									<td></td>
									<td></td>
								</tr>
								<tr class=''>
									<td></td>
									<td><%=session.getAttribute("inputPAddress")%></td>
									<td><%=session.getAttribute("inputBlock")%></td>
									<td><%=session.getAttribute("inputSector")%> </td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td><%=session.getAttribute("inputCity")%></td>
									<td><%=session.getAttribute("inputState")%></td>
									<td><%=session.getAttribute("inputCountry")%> </td>
									<td><%=session.getAttribute("inputPincode")%></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							   <%  if ( session.getAttribute("inputVehTypel1")!="" || session.getAttribute("inputVehTypel1")!= null) {
								   %><tr>
										<td> </td>
										<td><%=session.getAttribute("inputVehTypel1")%>	</td>
										<td> <%=session.getAttribute("inputVehManufacture1")%></td>
										<td><%=session.getAttribute("inputVehModel1")%>	</td>
										<td> <%=session.getAttribute("inputVehNo1")%></td>
										<td><%=session.getAttribute("inputVehColor1")%>	</td>
										<td ></td>
										<td></td>
									</tr> <%   } 
	    						%>
							   <%  if ( !session.getAttribute("inputVehTypel2").equals(null)  && !session.getAttribute("inputVehTypel2").equals("") ) {
								   %><tr>
										<td> </td>
										<td><%=session.getAttribute("inputVehTypel2")%>	</td>
										<td> <%=session.getAttribute("inputVehManufacture2")%></td>
										<td><%=session.getAttribute("inputVehModel2")%>	</td>
										<td> <%=session.getAttribute("inputVehNo2")%></td>
										<td><%=session.getAttribute("inputVehColor2")%>	</td>
										<td ></td>
										<td></td>
									</tr> <%   } 
	    						%>
								
							   <%  if ( session.getAttribute("inputDRVFName")!="" && session.getAttribute("inputDRVFName")!= null) {
 								   %><tr>
										<td class='h6'>Driver Personal Information</td>
										<td><%=session.getAttribute("inputDRVFName")%> <%=session.getAttribute("inputDRVLName")%></td>
										<td>(M)  <%=session.getAttribute("inputDRVMobile")%></td>
										<td>(Aadhar)  <%=session.getAttribute("inputDRVAadharNo")%></td>
										<td>(DLNO) <%=session.getAttribute("inputDRVDlNo")%></td>
										<td></td>
										<td ></td>
										<td></td>
									</tr> <%   } 
	    						%>

							   <%  if ( session.getAttribute("inputHKMName")!="" && session.getAttribute("inputHKMName")!= null) {
 								   %><tr>
									<td class='h6'>House Maid Information </td>
									<td><%=session.getAttribute("inputHKMName")%> <%=session.getAttribute("inputHKMLName")%> </td>
									<td><%=session.getAttribute("inputHKMGender")%></td>
									<td>(M) <%=session.getAttribute("inputHKMMobile")%></td>
									<td>(Adhaar) <%=session.getAttribute("inputHKMAadharNo")%></td>
									<td></td>
									<td></td>
									<td></td>
									</tr> <%   } 
	    						%>
	
								<tr>
									<td class="h6" >Owner Detials</td>
									<td><%=session.getAttribute("inputOwnEmail4")%> </td>
									<td>(M) <%=session.getAttribute("inputOwnMobileNo")%></td>
									<td></td>
									<td></td>
									<td></td>
									<td ></td>
									<td></td>
								</tr>
							</tbody>
						</table>
						<div class="form-row" id="Final">
							<div class="col-sm-2 offset-sm-5">
								<button type="button" class="form-control  text-white"
									id="Button1" name="Button1" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"><%=Information.GoToBack%>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- Body Footer -->
	<br />
	<div class="container bg-light text-dark">
		<div class="row">
			<div class="col-sm-6">
				<div class="card text-center">
					<div class="card-body">
						<h5 class="card-title"><%=Information.FooterHeadLine1%></h5>
						<p class="card-text"><%=Information.FooterHeadLine2%>
							<a href=<%=Information.EmailId%> target="_blank"><%=Information.EmailId%></a>
						</p>
						<p class="card-text">
							<%=Information.FooterHeadLine3%>
							<small><%=Information.FooterHeadLine4%> , <%=Information.EmailId%>,</small><%=Information.FooterHeadLine5%></p>
						<a href="#" class="btn " style="background:linear-gradient(to right, #00008B, #6ebce2); color:white">Go somewhere</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card text-center">
					<div class="card-body">
						<h5 class="card-title"><%=Information.GloalResponsibility%></h5>
						<p class="card-text"><%=Information.CompanyName%>
							is committed to operating its business with the goal of creating
							value for all our stakeholders. Our sustainability strategy
							focuses on social, environmental, and economic responsibility.
						</p>
						<a href="#" class="btn " style="background:linear-gradient(to right, #00008B, #6ebce2); color:white">Go somewhere</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
	<div class="container-flucid">
		<div class="row  header_for_fix">
			<div class="col-lg-12 bg-dark">
				<ul class="list-inline text-center">
					<li class="list-inline-item "><a class="text-light" href="#">
							<%=Information.MTC%>/
					</a></li>
					<li class="list-inline-item "><a class="text-light" href="#">
							<%=Information.PP%>/
					</a></li>
					<li class="list-inline-item "><a class="text-light" href="#">
							<%=Information.OTC%>
					</a></li>
					<li class="list-inline-item "><a class="text-light" href="#">
							%=Information.TC %> </a></li>
				</ul>
			</div>
			<div class="col-lg-12 text-center text-white bg-dark">
				%=Information.Browser %></div>
		</div>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function() {
		
			var table = $('#datatable').dataTable({
		        dom: 'Bfrtip',
		        buttons: ['copyHtml5', 'excelHtml5','csvHtml5','pdfHtml5','print'],
		        "order": [],
		    "ordering": false,    
	        "scrollY": 600,
	        "scrollX": true,
	        "scrollCollapse": true,
	        "pageLength": 10
		
			});
			$(tableTools.fnContainer()).insertBefore('#datatable_wrapper'); 

	});
	
	</script>
	<body>	
</html>
