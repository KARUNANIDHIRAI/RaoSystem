<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
	
<% ArrayList<TankerModel> WaterTankerList = (ArrayList) request.getAttribute("WaterTanker"); %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
	<link rel="stylesheet" href="css/Custom.css" type="text/css">
	
	<script type="text/javascript" 	src="webjars/jquery/3.4.1/jquery.min.js"></script>
	
	<script type="text/javascript" 	src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet"  type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
 
	<script  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	


</head>
	<body>
	<%@page import="com.raoSystem.constants.Information"%>
	<%@page import="com.rao.System.WaterTankerEntry.DAOWaterTankerDetails"%>
	<%@page import="com.rao.System.WaterTankerEntry.TankerModel"%>
	<%@page import="java.util.Iterator"%> 
	<%@page import="java.util.ArrayList"%> 
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
	
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-hearder text-center">
							<h5 class="card-title text-center"><%=Information.RwaSubscriptionType%> </h5>
							<strong><a href="<%=request.getContextPath()%>/SummaryWaterTanker?type=getDetails"><%=Information.RwaSubscriptionType%></a></strong>
						</div>
					</div>
				</div>
				<div class="col-sm-2 offset-sm-8">
					<button type="button" class="form-control  text-white"
						id="Button1" name="Button1" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"><%=Information.GoToBack%>
					</button>
				</div>
			</div>
					<div class="col-sm-12 offset-sm-0">
						<table id="datatable" class="hover display nowrap" style="width: 100%">
							<thead style="background-color:#38ACEC; color:white" >
								<tr class="text-center"> 
                                	<th ><%=Information.RwaCode %> </th>
                                	<th ><%=Information.WaterTankNo %> </th>
                                	<th ><%=Information.WtrSuplrNum %> </th>
                                   	<th > <%=Information.TankerNo%>  </th>
   
                                   	<th ><%=Information.TankCapcity %> </th>
                                   	<th ><%=Information.TankerArrivalOn %> </th>
                                   	<th ><%=Information.VerifiedByTankerIn %> </th>
                                   	<th ><%=Information.WaterLevelIn %> </th>
                                   	<th > <%=Information.TankerInTime%>  </th>
                                   	<th ><%=Information.VerifiedByTankerOut %> </th>
                                   	<th ><%=Information.WaterLevelOut %> </th>
                                   	<th ><%=Information.DriverName %> </th>
                                   	<th > <%=Information.DlNo%>  </th>
                                   	<th ><%=Information.MobileNo %> </th>
 
								</tr>
 							</thead>
							<tbody>
								<%
								if(request.getAttribute("WaterTanker") != null) {
									Iterator<TankerModel> iterators = WaterTankerList.iterator();
									
									while(iterators.hasNext()) 	{
										TankerModel  WTList = iterators.next();
									%>
									<tr>
										<td><%=WTList.getRwaRegNo()%></td>
										<td><%=WTList.getWaterTankNo() %> </td>
										<td><%=WTList.getWaterSupplier() %> </td>
										<td><%=WTList.getTankerNo() %> </td>
										<td><%=WTList.getTankerCapacity() %> </td>
										<td><%=WTList.getTankerArrivalDateFrom() %> </td>
										<td><%=WTList.getVerifiedByTankerIn()%> </td>
										<td><%=WTList.getWaterLevelIn()%> </td>
										<td><%=WTList.getTankerInTime()%> </td>
										<td><%=WTList.getVerifiedByTankerOut()%> </td>
										<td><%=WTList.getWaterLevelOut()%> </td>
										<td><%=WTList.getDriverName()%> </td>
										<td><%=WTList.getDLNO()%> </td>
										<td><%=WTList.getDrvMobilNo()%> </td>
									</tr>
									<%	}
								}
								%>

							</tbody>
						</table>
					</div>
					<div class="form-row" id="Final">
						<div class="col-sm-2 offset-sm-5">
							<button type="submit" class="form-control  text-white"
								id="Button1" name="Button1" style="background:linear-gradient(to right, #00008B, #6ebce2); color:white"><%=Information.GoToBack%>
							</button>
						</div>
					</div>
		
		</div>
	</body>
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
		        "scrollY": 300,
		        "scrollX": true,
		        dom: 'Bfrtip',
		        buttons: ['copyHtml5', 'excelHtml5','csvHtml5','pdfHtml5','print'],
		        "order": [],
		    "ordering": false, 
	        "pageLength": 15
			
			});
			$(tableTools.fnContainer()).insertBefore('#datatable_wrapper'); 

	});
	
	</script>	

</html>