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
<script type="text/javascript"
	src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var counter = 1;
		$("#flatDetails").hide();
		$("#RwaFixedPlan").hide();
		$("#RwaFloatingPlan").hide();
		$("#AptDetails").hide();
		$("#removeButton").click(function() {
		var ctr = $("#inputTotFlatInCategory").val();
		for (var counter = ctr; counter > 0; counter--) {
			if (counter == 0) {
				alert("No more textbox to remove");
				return false;
			}
			$("#TextBoxDiv" + counter).remove();
			$("#TextBoxDivFlatSize" + counter).remove();
		}
		$("#addButton").attr('disabled', false);

		});

		$("#inputRwaPlan").change(function() {
			$("#AptDetails").show();		
			switch (parseInt($('#inputRwaPlan').val())){
			case 1:
				$('#RwaFixedPlan').hide();	
				$('#RwaFloatingPlan').show();	
				break;			
			case 2:
				$('#RwaFloatingPlan').hide();	
				$("#AptDetails").show();		
				$('#RwaFixedPlan').show();	
				break;	
			default :
				alert('Please Choose option' );
				
			}
		});

		$("#inputRwaPlan").change(function(){
	        var selectedinputRwaPlan = $(this).children("option:selected").val();
			switch(selectedinputRwaPlan){
			case 1:	
				break;
			case 2:	
				break;
			default:
				break;
			}
	
	   
	   });		
	
		
		$("#submit01").click(function(){
			if($("#inputFlatCharge").val()>0){
				$("#inputFloatCharge").val()=$("#inputFlatCharge").val();
				
			}
		});
				
		
	
	});
</script>


</head>
<!--  style="background-color:#0769AD" -->
<body >
	<!-- Page Header -->
	<div class="container-flucid">
		<div class="row">
			<div class="col-lg-12 text-right  margin-left:0  margin-right:0px" 	style="background-color: #000080">
				<ul class="list-inline">
					<li class="list-inline-item "><a class="text-light" href="../RwaHomePage.jsp"> <%=Information.raoHome%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="../LoginPage.jsp"> <%=Information.LogoutTitle%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.joinPartner%></a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.reachus%>	</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container" >
		<div class="row">
			<div class="col-sm-7">
				<img src="../images/KSB.png" class="img-responsive " />
			</div>
		</div>
	</div>

	<div class="container" >
		<form id="AptInfo" name="AptInfo" action="../NewAPTInventory" method="post" class="form-horizontal needs-validation" autocomplete="off">
			<div class="row justify-content-md-center" >
				<div class="col-sm-12">
					<div class="card" style="background-color:#FFFFFF">
						<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC ;
						    padding-right:-1px">

							<ul class="nav nav-tabs card-header-tabs">
								<li class="nav-item " id="ViewUser"><a 	class="nav-link active text-white "
									style="background-color: #000080" href="#"><%=Information.NewAPTInfo%></a></li>
							</ul>
						</div>
						<br /> <br />
						<div class="form-row ">
							<div class="col-sm-12  offset-sm-0" style="padding-left:20px; padding-right:20px">
							    <h6 class="card-title text-center">Common Expenses for All Residents</h6>
				    			<p class="text-danger text-center"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
																<%session.removeAttribute("Message");%>
	        					<br />
								<div class="form-row">
									<div class="col-sm-3 offset-sm-1">
										<label for="inputTowerNo"><%=Information.AptTowerNo%></label>
										
										<div class="input-group">
											<input type="text" class="form-control is-invalid"
												id="inputTowerNo" name="inputTowerNo" >
										</div>
									</div>
									<div class="col-sm-3 offset-sm-1">
										<label for="inputFlatCategoryNo"><%=Information.FlatCategoryNo%></label>
										<div class="input-group">
											<input type="text" class="form-control is-invalid"
												id="inputFlatCategoryNo" name="inputFlatCategoryNo"
												data-toggle="tooltip" data-placement="top"
												title="Enter Flat Type Number" >
										</div>
									</div>
									<div class="col-sm-3 offset-sm-1">

										<label for="inputSizeOfFlat"><%=Information.SizeOfFlat%></label>
										<div class="input-group">
											<input type="text" class="form-control is-invalid"
												id="inputSizeOfFlat" name="inputSizeOfFlat"
												data-toggle="tooltip" data-placement="top"
												title="Enter Flat Type Number" >
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-sm-3 offset-sm-1">
										<label for="inputFltStartNo"><%=Information.FlatStartingNo%></label>
										<div class="input-group">
											<input type="text" class="form-control is-invalid"
												id="inputFltStartNo"
												name="inputFltStartNo" data-toggle="tooltip"
												data-placement="top"
												title="Enter Total Numbsers of Flat in Flat Type">
										</div>
									</div>
									<div class="col-sm-3 offset-sm-1">
										<label for="inputFltEndNo" class="col-form-label"><%=Information.FlatEndingNo%></label>
										<div class="input-group">
											<input type="text" class="form-control is-invalid"	id="inputFltEndNo"
												name="inputFltEndNo" data-toggle="tooltip" data-placement="top"
												title="Enter Total Numbsers of Flat in Flat Type" 	>
										</div>
									</div>
								</div>
								<br /> <br />  
								<div class="form-row">
			     					
									<div class="col-sm-2 offset-sm-4 ">
										<p>
											<a href="rwaHomePage.jsp"
											class="form-control text-white text-center h5"
											style="background-color: #000080"><%=Information.Cancel%></a>
										</p>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="submit" 	class="form-control h5 text-white text-center "
											style="background-color: #38ACEC" id="submit01"
											name="submit01"><%=Information.Submit%>
										</button>
									</div>
								</div>
								<br />
							</div><!-- col -->
						</div> <!-- rwo -->
					</div>  <!--end of card BODY -->
				</div>
			</div>
		</form>
	</div>


	<!-- Page Footer -->
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
							<a href="#" class="btn text-white"
								style="background-color: #000080">Go somewhere</a>
						</p>
					</div>
				</div>
				<div class="card text-center col-sm-6">
					<div class="card-body">
						<h5 class="card-title text-warning"><%=Information.GloalResponsibility%></h5>
						<p class="card-text">
							<%=Information.GloablfooterRight%>
						<p>
							<a href="#" class="btn text-white"
								style="background-color: #000080">Go somewhere</a>
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
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.MTC%>/</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.PP%>/</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.OTC%></a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.TC%></a></li>
				</ul>
			</div>
			<div class="col-lg-12 text-center text-white bg-dark"
				Style="padding-top: 0px">
				<%=Information.Browser%>
			</div>
		</div>
	</div>


</body>
</html>