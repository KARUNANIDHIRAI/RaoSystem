<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.raoSystem.createUser.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <%
	request.getAttribute("listCategory");
%> --%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
<link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
<link rel="stylesheet" href='webjars/jquery-ui/1.12.1/jquery-ui.css'>

<link rel="stylesheet" href="css/Custom.css" type="text/css">
<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" 	src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" 	src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" 	src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

	<link rel="stylesheet"  type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/dataTables.buttons.min.js"></script>
	
<script type="text/javascript"	src="webjars/datatables.net-select/1.3.1/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>

		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>



			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>


	<body>
		<div class="container-flucid" > 
			<div class="row" >
 				<div class="col-sm-12 "> 
					<nav class="navbar navbar-expand-sm navbar-light sticky-top" style="background: linear-gradient(90deg, rgba(2,0,36,1) 3%, rgba(9,83,121,1) 57%, rgba(0,160,255,1) 100%)">
						<a class="navbar-brand text-light" href="#" >KBS</a>
						<button class="navbar-toggler " data-toggle="collapse" data-target="#navmenubar">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse " id ="navmenubar"> 
							<ul class="navbar-nav ml-auto">
								<li class="active nav-item "><a href="LoginPage.jsp" class="nav-link text-light"	> <%= Information.signout%> </a> </li> 
								<li class="nav-item"><a href="#" class="nav-link text-light"><%= Information.joinPartner%> </a> </li> 
								<li class="nav-item"><a href="#" class="nav-link text-light"> <%= Information.reachus%> </a> </li> 
							</ul>
						</div>
					</nav>

				</div>
			</div>
		</div>		
		<div class="container">
			<div class="row">
				<div class="col-sm-7">
					<img src="images/KSB.png" class="img-responsive " />
				</div>
			</div>
		</div>
	<form id="abc" name="knrai" action="SchoolInfo?Action=rInformation" method="post" 	class="form-horizontal needs-validation" autocomplete="off" novalidate>
		<div class="row justify-content-md-center">
			<div class="col-sm-12">
				<div class="form-row">
				
					<table id="example" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>Name</th>
				                <th>Position</th>
				                <th>Office</th>
				                <th>Age</th>
				                <th>Start date</th>
				                <th>Salary</th>
				            </tr>
				        </thead>
				        <tbody>
				            <tr>
				                <td>Tiger Nixon</td>
				                <td>System Architect</td>
				                <td>Edinburgh</td>
				                <td>61</td>
				                <td>2011/04/25</td>
				                <td>$320,800</td>
				            </tr>
				            <tr>
				                <td>Herrod Chandler</td>
				                <td>Sales Assistant</td>
				                <td>San Francisco</td>
				                <td>59</td>
				                <td>2012/08/06</td>
				                <td>$137,500</td>
				            </tr>
				            <tr>
				                <td>Donna Snider</td>
				                <td>Customer Support</td>
				                <td>New York</td>
				                <td>27</td>
				                <td>2011/01/25</td>
				                <td>$112,000</td>
				            </tr>
				        </tbody>
				        <tfoot>
				            <tr>
				                <th>Name</th>
				                <th>Position</th>
				                <th>Office</th>
				                <th>Age</th>
				                <th>Start date</th>
				                <th>Salary</th>
				            </tr>
				        </tfoot>
				    </table>
				</div>
				<div class="form-row">
					<div class="col-sm-5 offset-sm-0">
						<input type="text" class="form-control blinebl " id="RegDate" name="RegDate" 
						placeholder="Registration Date*" required>
					</div>
					<div class="col-sm-5">
						<button type="submit" 	class="form-control h5 text-white text-center "
							style="background-color: #38ACEC" id="submit01" name="submit01"><%=Information.Submit%>
						</button>
					</div>
				</div>
			</div>
		</div>


	</form>

	<script>
		$(document).ready(function() {
			$("#RegDate").datepicker();	
			 $("#select option[value=1]").attr('selected', 'selected'); 
		    var events = $('#events');
		    alert(events);
		    var table = $('#example').DataTable( {
		        dom: 'Bfrtip',
		        select: true,
		        buttons: []
		    } );
		    $('#example tbody').on( 'click', 'tr', function () {
		        if ( $(this).hasClass('selected') ) {
// 		        	var data = $('#example').DataTable().row(this).data();
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
		   $("#datepicker").datepicker(); 
		} );
	</script>

</body>
</html>