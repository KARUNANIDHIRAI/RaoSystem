<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

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


<body>
	<!-- Page Header -->
	<div class="container-flucid">
		<div class="row">
			<div class="col-lg-12 text-right  margin-left:0  margin-right:0px" style="background-color:#000080">
				<ul class="list-inline">
					<li class="list-inline-item "><a class="text-light" href="../RwaHomePage.jsp"> <%=Information.raoHome%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="../LoginPage.jsp"> <%=Information.LogoutTitle%>	</a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.joinPartner%></a></li>
					<li class="list-inline-item "><a class="text-light" href="#"><%=Information.reachus%>	</a></li>
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
		<form id="IndvidualInfo" name="IndvidualInfo" action="../RwaSubscriptionInfo" method="post"
			class="form-horizontal needs-validation" autocomplete="off" >
			<div class="row justify-content-md-center">
				<div class="col-sm-12">
					<div class="accordion" id="accordionDriver">

						<div class="card">
							<div class="card-header text-white" id="headingOne" style="background-color:#38ACEC">

								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser" > 
										<a	class="nav-link active text-white " style="background-color:#000080" href="#"><%= Information.ViewAPTInfo%></a></li>
									<li class="nav-item " id="SSPNEW">
										<a class="nav-link text-light" href="../Inventory/NewRWASubscription.jsp"><%= Information.NewAPTInfo%></a></li>
									<li class="nav-item " id="TestNEW">
										<a class="nav-link text-light" href="../Inventory/NewTest.jsp">Test Array List</a></li>
 								</ul>
							</div>

							<div id="collapseOne" class="collapse show"
								aria-labelledby="headingOne" data-parent="#accordionDriver">
								<div class="card-body text-dark h6" >
									<br /> 
									<div class= "form-row">
										<div class="col-sm-9 offset-sm-3">
						    			<p class="text-danger h6"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
																<%session.removeAttribute("Message");%>
										</div>
									</div>
									<br />
									<div class="form-row ">
									    <div class="col-sm-4 offset-sm-2">
									      	<label for="ActionType" ><%= Information.TransactionType%></label>
										    <select id ="ActionType" name="ActionType" class="form-control  is-invalid " 
										    data-toggle="tooltip" data-placement="top" title="For Individual Apartment Please Enter Apartment / Tower No."  >
												<option value="0">Select Action to Perform</option>
												<option value="1">View RWA Subscription </option>
												<option value="2">Edit RWA Subscription </option>
												<option value="3">Delete RWA Subscription</option>
										    </select>
								    	</div>
										<div class="col-sm-4 offset-sm-0">
											<label for="SubscriptionType" ><%=Information.RwaSubscriptionType%></label>
										    <select id ="SubscriptionType" name="SubscriptionType" class="form-control  is-invalid " 
										    data-toggle="tooltip" data-placement="top" title=""  >
												<option value="0">Select Action to Perform</option>
												<option value="1">Floating Monthly Subscription Charges</option>
												<option value="2">Fixed Monthly Subscription Charges </option>
										    </select>
										</div>
									</div>
									<br />

 									<div class="form-row ">
									    <div class="col-sm-4 offset-sm-2">
									      	<label for="ValidDateFrom" ><%= Information.ValidDateFrom%></label>
											<div class="input-group">
												<input type="date" class="form-control is-invalid"	id="ValidDateFrom" name="ValidDateFrom" required>
											</div>
								    	</div>
									    <div class="col-sm-4 offset-sm-0">
									      	<label for="ValidDateTo" ><%= Information.ValidDateTo%></label>
											<div class="input-group">
												<input type="date" class="form-control is-invalid"	id="ValidDateTo" name="ValidDateTo" required>
											</div>
								    	</div>
									</div>
									<br />
									<br />
									<br /> 
									
									<div class="form-row">
										<div class="col-sm-2 offset-sm-4 ">
											<p>	<a href="rwaHomePage.jsp" class="form-control text-white text-center h5" style="background-color:#000080"><%=Information.Cancel%></a></p>
										</div>
								    	<div class="col-sm-2 offset-sm-0 ">
									      	<button type="submit" class="form-control h5 text-white text-center " style="background-color:#38ACEC" id="submit01" name = "submit01"  ><%=Information.Submit %> </button>
									    </div>
									</div>

								</div>
							</div>
						</div>

					</div>
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
			$( "#ActionType" ).click(function() {
		    	$("#EmailId").focus();
			});	
		});

</script>
-- in case of edit -> 1)SSPINFORMATIONN.JAVA-

</body>
</html>





























