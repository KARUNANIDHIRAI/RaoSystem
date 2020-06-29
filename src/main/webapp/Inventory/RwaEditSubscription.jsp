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
		<form id="AptEditInfo" name="AptEditInfo" action="../EditRwaSubscriptions" method="post" class="form-horizontal needs-validation" autocomplete="off">
			<div class="row justify-content-md-center" >
				<div class="col-sm-12">
					<div class="accordion" id="accordionDriver">

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
									<div class="card" >
										<div class="card-header">
										    <h6 class="card-title text-center">Common Expenses for All Residents</h6>
										</div>
										<div class="card-body">
											<div class="form-row">
												<div class="col-sm-4 offset-sm-1">
													<label for="inputTowerNo"><%=Information.RwaMonthlyPlan%></label>
				      								<select id="inputRwaPlan" name="inputRwaPlan" class="form-control is-invalid">
				        								<option value=0 >Select Subscription Type</option>
				        								<option value = 1>Apartment Size basis Charges</option>
				        								<option value=2>Fixed Charges</option>
				      								</select>
												</div>
												<div class="col-sm-3 offset-sm-0">
													<label for="inputValidFrom"><%=Information.ValidFrom%></label>
													<div class="input-group">
														<input type="date" class="form-control is-invalid" 	id="inputValidFrom" name="inputValidFrom"
														   value = <%=session.getAttribute("ValidDateFrom") %>>
													</div>
												</div>
												<div class="col-sm-3 offset-sm-1">
													<label for="inputValidTo"><%=Information.ValidTo%></label>
													<div class="input-group">
														<input type="date" class="form-control is-invalid" id="inputValidTo" name="inputValidTo"
														 value = <%=session.getAttribute("ValidDateTo") %>>
													</div>
												</div>

											</div>	
											<br />
											<div id ="RwaFixedPlan">
												<div class="form-row">
													<div class="col-sm-3 offset-sm-1">
														<label  for="inputFlatCharge"><%=Information.FlatCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
	 														<input type="text" class="form-control is-invalid" id="inputFlatCharge" 
															name="inputFlatCharge" value = <%=session.getAttribute("Fixcharge") %>>
	 													</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputAMCCharge"><%=Information.AmcCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" 	id="inputAMCCharge" name="inputAMCCharge"
															value = <%=session.getAttribute("AmcCharge") %>>
	 													</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputAuditCharge"><%=Information.AuditCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" id="inputAuditCharge" name="inputAuditCharge"
															value = <%=session.getAttribute("AuditCharge") %>>
														</div>
													</div>
												</div>
												<div class="form-row">
													<div class="col-sm-3 offset-sm-1">
														<label for="inputGymCharge"><%=Information.GymCharges%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" 	id="inputGymCharge" name="inputGymCharge"
															value = <%=session.getAttribute("GymCharge") %>>
														</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputSwmPoolCharge"><%=Information.SwimmingPoolCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" id="inputSwmPoolCharge" name="inputSwmPoolCharge"
															value = <%=session.getAttribute("SwimmingPoolCharge") %>>
														</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputMiscCharge"><%=Information.MiscCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" 	id="inputMiscCharge" name="inputMiscCharge"
															value = <%=session.getAttribute("MiscCharge") %>>
	 													</div>
													</div>
												</div>
											</div> <!-- end of fixed div -->
											<div id ="RwaFloatingPlan">            <!-- Start Floating  div -->
												<div class="form-row">
													<div class="col-sm-3 offset-sm-1">
														<label  for="inputFloatCharge"><%=Information.FlatCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
	 														<input type="text" class="form-control is-invalid" id="inputFloatCharge" 
															name="inputFloatCharge" value = <%=session.getAttribute("Fixcharge") %>>
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text"><sub >FT</sub> 2</div>
														    </div>
														</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputAMCFloatCharge"><%=Information.AmcCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" id="inputAMCFloatCharge" name="inputAMCFloatCharge"
															value = <%=session.getAttribute("AmcCharge") %>>
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text"><sub >FT</sub> 2</div>
														    </div>
														</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputAuditCharge"><%=Information.AuditCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" id="inputAuditCharge" name="inputAuditCharge"
															value = <%=session.getAttribute("AuditCharge") %>>
														</div>
													</div>
							
												</div>
												<div class="form-row">
													<div class="col-sm-3 offset-sm-1">
														<label for="inputGymFloatCharge"><%=Information.GymCharges%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" 	id="inputGymFloatCharge" name="inputGymFloatCharge"
															value = <%=session.getAttribute("GymCharge") %>>
														</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputSwmPoolFloatCharge"><%=Information.SwimmingPoolCharge%></label>
														<div class="input-group">
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" id="inputSwmPoolFloatCharge" name="inputSwmPoolFloatCharge"
															value = <%=session.getAttribute("SwimmingPoolCharge") %>>
														</div>
													</div>
													<div class="col-sm-3 offset-sm-1">
														<label for="inputMiscFloatCharge"><%=Information.MiscCharge%></label>
														<div class="input-group">
														     
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text">&#8377</div>
														    </div>
															<input type="text" class="form-control is-valid" 	id="inputMiscFloatCharge" name="inputMiscFloatCharge" 
															value = <%=session.getAttribute("MiscCharge") %>>
	 												    	<div class="input-group-prepend">
														        <div class="input-group-text"> <sub >FT</sub> 2</div>
														    </div>
														</div>
													</div>
												</div>
											</div> <!-- end of floating div -->
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
										</div> <!-- end of card body -->
									</div><!-- end of card -->
								</div>
							</div>
	
	
<%-- 							<div id="collapseOne" class="collapse show"
								aria-labelledby="headingOne" data-parent="#accordionDriver">
								<div class="card-body text-dark ">
									<div class="form-row">
										<div class="col-sm-9 offset-sm-3">
											<p class="text-danger h6"><%=session.getAttribute("Message") == null ? "" : session.getAttribute("Message")%></p>
											<%session.removeAttribute("Message");%>
										</div>
									</div>
								</div>  <!--end of card BODY -->
							</div>
 --%>
						</div>
					</div>
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