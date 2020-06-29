<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.raoSystem.constants.Information"%>
<%-- <% ArrayList<DaoRWASubscriptionList> employeeList = (DaoRWASubscriptionList)  request.getAttribute("EmpList"); %> --%>

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
 
 </head>
<body>
<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="java.util.List"%>
<%@page import="com.rao.System.Apartment.DAOAPTInventory"%>
<%@page import="com.rao.System.Apartment.DaoRWASubscriptionList"%>
<%@page import="java.util.Iterator"%> 
<%@page import="com.rao.System.Apartment.EmployeeDetails"%>

<%-- <% ArrayList<EmployeeDetails> employeeList = (ArrayList) request.getAttribute("EmpList"); %> Assigning ArrayList object containing Employee data to the local object --%>

<%ArrayList<DaoRWASubscriptionList> products = (ArrayList)request.getAttribute("products");%>

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
		<form id="RwaList" name="RwaList" action="../RwaSubscriptionList" method="post"	class="form-horizontal needs-validation" autocomplete="off">
			<div class="row">
				<div class="col-sm-12">
 					<div class="card" >
						<div class="card-header text-center " >
							<h5 class="card-title text-center"><%=Information.APTFaltInventory%></h5>
						</div>
					</div>
					<div class="col-sm-2 offset-sm-8">
						<button type="button" class="form-control  text-white"
							id="Button1" name="Button1" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"><%=Information.GoToBack%>
						</button>
					</div>
					<div class="col-sm-12 offset-sm-0">
						<h3>Product List</h3>
						<c:set var="total" value="0"></c:set>
						<table border=1>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Photo</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Sub Total</th>
							</tr>
							<c:forEach var="product" items="${Emplist}">
								<c:set var="total" value="${total + product.price * product.quantity }"></c:set>
								<tr>
									<td>${product.id }</td>
									<td>${product.name }</td>
									<td></td>
									<td>${product.price }</td>
									<td>${product.quantity }</td>
									<td>${product.price * product.quantity }</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right">Total</td>
								<td>${total }</td>
							</tr>
						</table>




<%-- 						<table id="datatable" class="hover display nowrap" style="width: 100%">
							<thead style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"" >
								<tr> 
                                	<th><%=Information.RwaRegNO %> </th>
                                	<th><%=Information.towerNo %> </th>
                                   	<th><%=Information.FlatCategoryNo %> </th>
                                   	<th> <%=Information.SizeOfFlat%>  </th>
                                   	<th><%=Information.FlatStartingNo %> </th>
                                   	<th><%=Information.FlatEndingNo %> </th>
								</tr>
 							</thead>
							<tbody>
							    <tr>
									<td><%=session.getAttribute("RwaRegNo")%></td>
									<td><%=session.getAttribute("inputTowerNo")%></td>
									<td><%=session.getAttribute("inputFlatCategoryNo")%> </td>
									<td><%=session.getAttribute("inputSizeOfFlat")%></td>
									<td><%=session.getAttribute("inputFltStartNo")%></td>
									<td><%=session.getAttribute("inputFltEndNo")%></td>
								</tr>
								 <%ArrayList<DaoRWASubscriptionList> RwaSubscriptionList =   (ArrayList<DaoRWASubscriptionList>) request.getAttribute("employeeList"); 
							        for(DaoRWASubscriptionList SubsList:RwaSubscriptionList){%> 
					            <tr>
					            <td><%=SubsList.getRwaRegNo()%> </td>
					            <td><%=SubsList.get()%> </td>
					            <td><%=SubsList.getFlatFixCharge()%> </td>
					            <td><%=SubsList.getAuditCharge()%> </td>
					            <td><%=SubsList.getSwmPoolCharge()%> </td>
					            <td> </td>
					            </tr>
					            <td><%=SubsList.getRwaRegNo()%></td>
					            <td><%=SubsList.getFlatFixCharge()%> </td> 
					            <td><%=SubsList.getRwaRegNo()%></td>
					            <td><%=SubsList.getAuditCharge()%></td>
					            <td><%=SubsList.getSwmPoolCharge()%></td>
					            <td><%=SubsList.getGymCharge()%></td>
					            <td><%=SubsList.getMiscCharge()%> </td>
					            
                					<td><%=SubsList.getAuditCharge()%></td> 
                					<td><%=SubsList.getSwmPoolCharge()%></td> 
                					<td><%=SubsList.getGymCharge()%></td> 
                					<td><%=SubsList.getMiscCharge()%> </td> 
            						</tr> 
            						<%}%>
  
							</tbody>
						</table>
 --%>	
 				</div>
					<div class="form-row" id="Final">
						<div class="col-sm-2 offset-sm-5">
							<button type="button" class="form-control  text-white"
								id="Button1" name="Button1" type ="submit" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"><%=Information.GoToBack%>
							</button>
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
		        "scrollY": 100,
		        "scrollX": true,
		        dom: 'Bfrtip',
		        buttons: ['copyHtml5', 'excelHtml5','csvHtml5','pdfHtml5','print'],
		        "order": [],
		    "ordering": false, 
	        "pageLength": 10
		
			});
			$(tableTools.fnContainer()).insertBefore('#datatable_wrapper'); 

	});
	
	</script>
	<body>	
</html>
