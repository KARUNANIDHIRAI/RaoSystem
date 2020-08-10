<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<% ArrayList<TankerModel> WaterTankerList = (ArrayList) request.getAttribute("WaterTanker"); %> 
	<%@page import="com.raoSystem.constants.Information"%>
	<%@page import="com.rao.System.WaterTankerEntry.DAOWaterTankerDetails"%>
	<%@page import="com.rao.System.WaterTankerEntry.TankerModel"%>
	<%@page import="java.util.Iterator"%> 
	<%@page import="java.util.ArrayList"%> 

<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	<link rel="stylesheet" href="css/Custom.css" type="text/css">
	<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript"	src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"	src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>


	<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
	<script type="text/javascript" 	src="webjars/jquery/3.4.1/jquery.min.js"></script>
	
	<script type="text/javascript" 	src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<link rel="stylesheet"  type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

	<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

	<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/dataTables.buttons.min.js"></script>
	<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/dataTables.buttons.min.js"></script>
	
	<script type="text/javascript"	src="webjars/datatables.net-select/1.3.1/js/dataTables.select.min.js"></script>


	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
 
	<script  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	







</head>
<body>
	<!-- Page Header -->
	<div class="container-flucid">
		<div class="row">
			<div class="col-lg-12 text-right  margin-left:0  margin-right:0px" style="background-color:#000080">
				<ul class="list-inline">
					<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%=Information.raoHome%> </a></li>
					<li class="list-inline-item "><a class="text-light"	href="LoginPage.jsp"> <%=Information.LogoutTitle%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.joinPartner%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"> <%=Information.reachus%>	</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<img src="../images/KSB.png" class="img-responsive " />
			</div>
		</div>
	</div>
	<!-- Page Body -->
	<div class="container">
		<form id="TNTInfo" name="TNTInfo" action="../WaterTankerMainInfo" method="post" class="form-horizontal needs-validation" autocomplete="off">
			<div class="row justify-content-md-center">
				<div class="col-sm-12">
					<div class="card" Style="Padding-top:0px">
						<div class="card-header text-white" id="headingOne"
							style="background-color: #38ACEC">
							<ul class="nav nav-tabs card-header-tabs">
								<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
									style="background-color: #000080" href="#"> <%=Information.WaterTankViewInfo%></a></li>
								<li class="nav-item " id="WtrTankNEW"><a class="nav-link text-light" href="NewWaterTankInfo.jsp">
									<%=Information.WaterTankNewInfo%></a></li>
								<li class="nav-item " id="WtrTankInfoSummary"><a class="nav-link text-light"
									href="../MIS/WaterSupplySumSearch.jsp">Water Tanker	Summary</a></li>
							</ul>
						</div>
						<div class="card-body text-dark h6">
							<br />
							<div class="form-row">
								<div class="col-sm-9 offset-sm-3">
									<p class="text-danger h6"><%=session.getAttribute("Message") == null ? "" : session.getAttribute("Message")%></p>
									<%session.removeAttribute("Message"); %>
								</div>
							</div>
							<br />
							<div class="form-row ">
								<div class="col-sm-4 offset-sm-2">
								<label for="RwaRegNo"><%=Information.RWARegNo%></label>
									<div class="input-group">
										<input type="text" class="form-control " id="RwaRegNo" 	name="RwaRegNo" readonly>
									</div>
								</div>
								<div class="col-sm-4 offset-sm-0">
									<label for="ActionType"><%=Information.ActionType%></label>
									<select id="ActionType" name="ActionType" 	class="form-control is-invalid">
										<option selected value="0">Select Action Type</option>
										<option selected value="1">View Info</option>
										<option value="2">Remove Information</option>
									</select>
								</div>
							</div>
							<br />
							<div class="form-row ">
								<div class="col-sm-4 offset-sm-2">
									<label for="TankerNo"><%=Information.TankerNo%></label>
									<div class="input-group">
										<input type="text" class="form-control is-invalid" 	id="TankerNo" name="TankerNo" required>
									</div>
								</div>
								<div class="col-sm-4 offset-sm-0">
									<label for="DateFrom"><%=Information.DateFrom%></label>
									<div class="input-group">
										<input type="date" class="form-control " id="DateFrom" 	name="DateFrom" required>
									</div>
								</div>
							</div>
							<br /> 	<br />
							<div class="form-row">
								<div class="col-sm-2 offset-sm-4 ">
									<p>
										<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
											style="background-color: #000080"><%=Information.Cancel%></a>
									</p>
								</div>
								<div class="col-sm-2 offset-sm-0 ">
									<button type="submit" class="form-control h5 text-white text-center "
										style="background-color: #38ACEC" id="submit01" name="submit01"><%=Information.Submit%>
									</button>
								</div>
							</div>
							<br />
							<div class="form-row ">
								<div class="col-sm-12 offset-sm-0">
									<%	if (request.getAttribute("WaterTanker") != null) { %>
									<table id="WtrTanker" class="hover display nowrap" style="width: 100%">
										<thead style="background-color: #38ACEC; color: white">
											<tr class="text-center">
												<%--<th><%=Information.SNo%></th> --%>
												<th><%=Information.RwaCode%></th>
												<%--<th><%=Information.WtrSuplrNum%></th>--%>
												<th><%=Information.TankerNo%></th>
												<th><%=Information.TankerArrivalOn%></th>
												<th><%=Information.VerifiedByTankerIn%></th>
												<th><%=Information.TankerInTime%></th>
												<th><%=Information.DriverName%></th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<%if (request.getAttribute("WaterTanker") != null) {
												session.setAttribute("TankerInfo", WaterTankerList);
												
												Iterator<TankerModel> iterators = WaterTankerList.iterator();
												while (iterators.hasNext()) {
													TankerModel WTList = iterators.next();
												%>
												<tr>
<%-- 												<td><%=WTList.getTankerId()%></td> --%>
												<td><%=WTList.getRwaRegNo()%></td>
												<%-- <td><%=WTList.getWaterSupplier()%></td>--%>
												<td><%=WTList.getTankerNo()%></td>
												<td><%=WTList.getTankerArrivalDateFrom()%></td>
												<td><%=WTList.getVerifiedByTankerIn()%></td>
												<td><%=WTList.getTankerInTime()%></td>
												<td><%=WTList.getDriverName()%></td>
	 											<td><a href="WaterSupplierInfo/EditWaterTankerInfo.jsp?Id=	<%=WTList.getTankerId()%> 
	 											"><%=Information.Edit%></a></td>
	 <%-- 											<td><a href="<%=request.getContextPath()%>/WaterTankerMainInfo?type=getDetails"><%=Information.Edit%></a></td> --%>
	<%-- 											<td><a href="<%=request.getContextPath()%>/RwaSubscriptionReport?id=<%=WTList.getTankerId()%>"><%=Information.Edit%></a></td>--%>
												</tr>
												<%	}
											}%>
										</tbody>
										<%}	%>
									</table>
								</div>
							</div>
						</div>
					</div><!--   end of card -->
				</div>
			</div>
		</form>
	</div>

	<!--Footer  -->
	<br />
	<div class="container-flucid bg-dark">
		<div class="row ">
			<div class="card-group text light">
				<div class="card text-center col-sm-6">
					<div class="card-body">
						<h5 class="card-title text-warning"><%=Information.FooterHeadLine1%></h5>
						<p class="card-text">
							<%=Information.GloablfooterLeft%>
						<p>
							<a href="#" class="btn text-white" style="background-color:#000080">Go somewhere</a>
						</p>
					</div>
				</div>
				<div class="card text-center col-sm-6">
					<div class="card-body">
						<h5 class="card-title text-warning"><%=Information.GloalResponsibility%></h5>
						<p class="card-text">
							<%=Information.GloablfooterRight%>
						<p>
							<a href="#" class="btn text-white" style="background-color:#000080" >Go somewhere</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
	<div class="container-flucid">
		<div class="row  header_for_fix">
			<div class="col-lg-12 bg-dark" Style="padding-bottom: 0px">
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
							<%=Information.TC%>
					</a></li>
				</ul>
			</div>
			<div class="col-lg-12 text-center text-white bg-dark"
				Style="padding-top: 0px">
				<%=Information.Browser%>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	$(document).ready(function() {
	    var events = $('#events');
	    var table = $('#WtrTanker').DataTable( {
	        "scrollY": 275,
	        "scrollX": true,
	        dom: 'Bfrtip',
	        select: true,
	        buttons: ['copyHtml5', 'excelHtml5','pdfHtml5','print'],
	        "order": [],
	        "ordering": false, 
	        "pageLength": 15
	    });
	    $('#WtrTanker tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
//		        	var data = $('#example').DataTable().row(this).data();
	        	var data = table.row(this).data();
	        	alert(data[0]); 
	        	alert(data[1]);
	        	alert(table.row( this ).data());
	        	var x=data[0];
	        	session.setAttribute('sno',data[0]);
	        	alert(session.getAttribute('sno'))
	        	$(this).removeClass('selected');
	        }
	        else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	    });
	    
	
	
	
	
	
	
/* 	$(document).ready(function() {
	    var events = $('#events');
	    alert(events);
	    var table = $('#example').DataTable( {
	        dom: 'Bfrtip',
	        select: true,
	        buttons: []
	    } );
	    $('#example tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	        	var data = table.row(this).data();
	        	alert(data[0]); 
	        	alert(data[1]);
	        	alert(table.row( this ).data());
	        	$(this).removeClass('selected');
	        	session.setAttribute('sno',data[0]);
	        	alert('sno : '+ session.getAttribute('sno'))
	        }
	        else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	        }
	    } );
	    
 */	    
	    
	    
/* 	    
			var table = $('#datatable').dataTable({
		        "scrollY": 300,
		        "scrollX": true,
		        dom: 'Bfrtip',
		        buttons: ['copyHtml5', 'excelHtml5','pdfHtml5','print'],
		        select: true,
		        "order": [],
		        "ordering": false, 
	            "pageLength": 15,
			});
			$(tableTools.fnContainer()).insertBefore('#datatable_wrapper'); 

			$( "#ViewUserIfon" ).click(function() {
		    	$("#EmailId").focus();
			});	
			$( "#EditUserIfon" ).click(function() {
		    	$("#EmailId").focus();
			});	

		    $('#datatable tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
// 		        	var data = table.row(this).data();
		        	alert(table.row( this ).data());

					var data = $('#datatable').DataTable().row(this).data()

		        	alert(data[0]); 
		        	alert(data[1]);
		        	alert(data[0] +',' +data[1] +',' +data[2] +',' +data[3] +',' +data[4] +',' +data[5] ); 
		        	
		        	$(this).removeClass('selected');
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		        }
		    } );			
			
 */
 	});
	</script>
</body>
</html>




























