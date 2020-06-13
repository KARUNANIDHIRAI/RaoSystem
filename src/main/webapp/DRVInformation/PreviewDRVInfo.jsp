<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
<link rel="stylesheet"
	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
<link rel="stylesheet" href="css/Custom.css" type="text/css">

<script type="text/javascript"
	src="../webjars/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript"
	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
<script type="text/javascript"
	src="../webjars/datatables-buttons/1.6.1/js/dataTables.buttons.min.js"></script>


<script
	src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script	src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>

<style type="text/css">
div.dataTables_wrapper {
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
					<li class="list-inline-item "><a class="text-light"
						href="RwaHomePage.jsp"> <%=Information.raoHome%></a></li>
					<li class="list-inline-item "><a class="text-light"
						href="LoginPage.jsp"> <%=Information.LogoutTitle%>
					</a></li>
					<li class="list-inline-item "><a class="text-light" href="#">
							<%=Information.joinPartner%></a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.reachus%></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Body -->
	<div class="container">
		<form id="DRVNEW" name="DRVNEW" action="" method="post"	class="form-horizontal needs-validation" autocomplete="off">
			<div class="row">
				<div class="col-xs-12">
					<div class="card" style="width: 72rem;">
						<div class="card-header text-center bg-light">
							<h5 class="card-title text-center"><%=Information.OwnDriverInfo%></h5>
						</div>
					</div>
					<div class="card">
						<div class="form-row" id="Final">
							<div class="col-sm-2 offset-sm-8">
								<button type="button" class="form-control  text-white"
									id="Button1" name="Button1"
									style="background: linear-gradient(to right, #00008B, #6ebce2); color: white"><%=Information.GoToBack%>
								</button>
							</div>
						</div>
<!-- 						<div class="table-responsive "> -->
							<table id="datatable"
								class=" table table-hover table-border display table-responsive nowrap "
								style="width: 100%">
								<thead 	style="background: linear-gradient(to right, #00008B, #6ebce2); color: white">
									<tr>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<tr class="h6 bg-info text-white" >
										<td><%=Information.Name%></td>
										<td><%=Information.gender%></td>
										<td><%=Information.dob%></td>
										<td><%=Information.mobile%></td>
										<td><%=Information.email%></td>
										<td><%=Information.PanNo%></td>
										<td><%=Information.AadharNo%></td>
									</tr>
									<tr>
										<td><%=session.getAttribute("inputFName")%> <%=session.getAttribute("inputLName")%></td>
										<td><%=session.getAttribute("inputGender")%></td>
										<td><%=session.getAttribute("inputDOB")%></td>
										<td><%=session.getAttribute("inputPanCardNo")%></td>
										<td><%=session.getAttribute("inputEmail4")%></td>
										<td><%=session.getAttribute("inputMobile")%></td>
										<td><%=session.getAttribute("inputAadharNO")%></td>
									</tr>
									<tr >
										<td><%=Information.FatherFName%></td>
										<td></td>
										<td><%=Information.gender%></td>
										<td><%=Information.email%></td>
										<td><%=Information.mobile%></td>
										<td><%=Information.AadharNo%></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td><%=session.getAttribute("inputFFName")%> <%=session.getAttribute("inputFLName")%></td>
										<td><%=session.getAttribute("inputFGender")%></td>
										<td><%=session.getAttribute("inputFEmail")%></td>
										<td><%=session.getAttribute("inputFMobile")%></td>
										<td><%=session.getAttribute("inputFAadharNO")%></td>
										<td></td>
										</tr>
									<tr class='h6 '>
										<td><%=Information.PAddress%></td>
										<td><%=session.getAttribute("inputPAddress")%></td>
										<td><%=session.getAttribute("inputPBlock")%></td>
										<td><%=session.getAttribute("inputPSector")%></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td><%=session.getAttribute("inputPCity")%></td>
										<td><%=session.getAttribute("inputPState")%></td>
										<td><%=session.getAttribute("inputPCountry")%></td>
										<td><%=session.getAttribute("inputPPincode")%></td>
										<td></td>
										<td></td>
									</tr>

									<tr class='h6'>
										<td class="h6 "><%=Information.CAddress%></td>
										<td><%=session.getAttribute("inputCAddress")%></td>
										<td><%=session.getAttribute("inputCBlock")%></td>
										<td><%=session.getAttribute("inputCSector")%></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>

									<tr>
										<td></td>
										<td><%=session.getAttribute("inputCCity")%></td>
										<td><%=session.getAttribute("inputCState")%></td>
										<td><%=session.getAttribute("inputCCountry")%></td>
										<td><%=session.getAttribute("inputCPincode")%></td>
										<td></td>
										<td></td>
									</tr>

									<tr class='h6 bg-info text-white'>
										<td><%=Information.Employment%></td>
										<td><%=Information.EmployeeNo%> </td>
										<td> <%=Information.DesignationLBL%></td>
										<td><%=Information.DOJLBL%></td>
										<td><%=Information.DORLBL%></td>
										<td><%=Information.ReportingLBL%></td>
										<td><%=Information.email%></td>
									</tr>
									<tr>
										<td></td>
										<td><%=session.getAttribute("inputEmpNO")%></td>
										<td><%=session.getAttribute("inputDesignation")%></td>
										<td><%=session.getAttribute("inputDateJoin")%></td>
										<td><%=session.getAttribute("inputDateRelev")%></td>
										<td><%=session.getAttribute("inputReproting")%></td>
										<td><%=session.getAttribute("inputRepEmail")%></td>
									</tr>
									<tr >
										<td class='h6'><%=Information.EmployerName%></td>
										<td><%=session.getAttribute("inputPreOrgName")%></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr >
										<td class='h6'><%=Information.Address%></td>
										<td><%=session.getAttribute("inputOAddress")%></td>
										<td><%=session.getAttribute("inputOBlock")%></td>
										<td><%=session.getAttribute("inputOSector")%></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr >
										<td></td>
										<td><%=session.getAttribute("inputOCity")%></td>
										<td><%=session.getAttribute("inputOState")%></td>
										<td><%=session.getAttribute("inputOCountry")%></td>
										<td><%=session.getAttribute("inputOpincode")%></td>
										<td></td>
										<td></td>
									</tr>

 									<tr class='h6'>
										<td><%=Information.DLDetails%></td>
										<td><%=Information.DlNo%></td>
										<td><%=Information.DLIsDt%></td>
										<td><%=Information.DLExpiryDtLBL%></td>
										<td><%=Information.DLIssueCity%></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td><%=session.getAttribute("inputLicenseNO")%></td>
										<td><%=session.getAttribute("inputLicenseDate")%></td>
										<td><%=session.getAttribute("inputExpiryDate")%></td>
										<td><%=session.getAttribute("inputLicenseCity")%></td>
										<td></td>
										<td></td>
									</tr>
									<tr class='h6'>
										<td><%=Information.Address%></td>
										<td><%=session.getAttribute("inputDLAddress")%></td>
										<td><%=session.getAttribute("inputDLBlock")%></td>
										<td><%=session.getAttribute("inputDLSector")%></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
<%-- 									<tr class='h6'>
										<td></td>
										<td><%=Information.Block%></td>
										<td><%=Information.Sector%></td>
										<td><%=Information.City%></td>
										<td><%=Information.State%></td>
										<td><%=Information.country%></td>
										<td><%=Information.PinCode%></td>
									</tr>
									<tr>
										<td><%=session.getAttribute("inputDLAddress")%></td>
										<td><%=session.getAttribute("inputDLBlock")%></td>
										<td><%=session.getAttribute("inputDLSector")%></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
 --%>								
									<tr>
										<td></td>
										<td><%=session.getAttribute("inputDLCity")%></td>
										<td><%=session.getAttribute("inputDLState")%></td>
										<td><%=session.getAttribute("inputDLCountry")%></td>
										<td><%=session.getAttribute("inputDLpincode")%></td>
										<td></td>
										<td></td>
									</tr>

								</tbody>
							</table>
							<div class="row " id="Final">
								<div class="col-sm-2 offset-sm-5">
									<button type="button" class="form-control  text-white"
										id="Button1" name="Button1"
										style="background: linear-gradient(to right, #00008B, #6ebce2); color: white"><%=Information.GoToBack%>
									</button>
								</div>
							</div>
<!-- 						</div> -->
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
						<a href="#" class="btn "
							style="background: linear-gradient(to right, #00008B, #6ebce2); color: white">Go
							somewhere</a>
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
						<a href="#" class="btn "
							style="background: linear-gradient(to right, #00008B, #6ebce2); color: white">Go
							somewhere</a>
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
		$(document).ready(
				function() {

					var table = $('#datatable').dataTable(
							{
								dom : 'Bfrtip',
								buttons : [ 'copyHtml5', 'excelHtml5',
										'csvHtml5', 'pdfHtml5', 'print' ],
								"order" : [],
								"ordering" : false,
								"scrollY" : 600,
								"scrollX" : true,
								"scrollCollapse" : true,
								"pageLength" : 10
							});

					$(tableTools.fnContainer()).insertBefore(
							'#datatable_wrapper');

				});
	</script>
<body>
</html>
