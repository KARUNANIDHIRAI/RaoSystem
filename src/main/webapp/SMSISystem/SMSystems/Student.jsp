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
			<link rel="stylesheet" href="../../css/Custom.css" type="text/css">
			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>			

	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="SPInfo" name="SPInfo" action="../../StudentInfoPersonal?Action=student" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
				<div class="bg-light text-dark">	
					<div class="row">		
						<br />
						<div class="col-sm-3 offset-sm-3 ">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
						</div>
						<div class="col-sm-3 offset-sm-0 ">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
						</div>
					</div>
				</div>	
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
/* 	$("#dob").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
 */
	$(document).ready(function(){
/* 	 	$("#dob").datetimepicker({
			timepicker: false,
			datepicker: true,
			format: 'd-m-yy', // formate date
			step: 5,	
			yearStart:yearStart(),
			yearEnd:'2030',
			weeks:true	
		});
 */
 		$("#dob").datepicker();
		$("#admDate").datepicker();
	});
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	</script>
</html>