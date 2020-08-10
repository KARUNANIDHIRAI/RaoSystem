<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<%-- <% ArrayList<TankerModel> WaterTankerUpdate = (ArrayList) request.getAttribute("WaterTanker"); %> 
 --%>
	<%@page import="com.rao.System.WaterTankerEntry.TankerModel"%>
	<%@page import="java.util.ArrayList"%> 
	<%@page import="java.util.Iterator"%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="css/Custom.css" type="text/css">
   		<script type="text/javascript" src="../webjars/query-validation/1.19.0/jquery.validate.min.js"></script>
   		<script type="text/javascript" src="../webjars/query-validation/1.19.0/jquery.validate.js"></script>

   		<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>

   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
  	</head>	

<body>
	<div class="container-flucid">
		<div class="row">
			<div class="col-lg-12 text-right  margin-left:0  margin-right:0px" style="background-color:#000080">
				<ul class="list-inline">
                	<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%= Information.raoHome%> </a> </li>
                	<li class="list-inline-item "><a class="text-light" href="LoginPage.jsp"> <%= Information.LogoutTitle%> </a> </li>
                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%> </a> </li>
                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
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
<%-- 	<%ArrayList<TankerModel> TankerList =  (ArrayList) session.getAttribute("TankerSupplierList");%> --%>
	<div class="container" >
		<form id="WaterTanker" name="WaterTanker" action="../EditWaterTanker" method="post" class="form-horizontal needs-validation" autocomplete="off">
			<div class="row justify-content-md-center" >
				<div class="col-sm-12">
					<div class="card" style="background-color:#FFFFFF; Padding-top:0px">
						<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC ;  padding-right:-1px; ">
							<ul class="nav nav-tabs card-header-tabs">
								<li class="nav-item " id="ViewUser"><a 	class="nav-link active text-white "
									style="background-color: #000080" href="#"><%=Information.Edit%> <%=Information.WaterTankSuplrPageTitle%></a></li>
							</ul>
						</div>
  						<div class="form-row ">
							<div class="col-sm-12  offset-sm-0" style="padding-left:20px; padding-right:20px">
								<p class="text-danger text-center"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
																<%session.removeAttribute("Message");%>
							</div>
						</div>
						<br /> 
							<% ArrayList<TankerModel> wTanker = (ArrayList)session.getAttribute("TankerInfo");%>
							<%if (wTanker.size()>0) {
								Iterator<TankerModel> iterators = wTanker.iterator();
								while (iterators.hasNext()) {
									TankerModel WTList = iterators.next();
									if(!request.getParameter("Id").equals(WTList.getTankerId())){
										continue;
									}
								%>	
								<div class="card" Style="Padding-top:0px" >
									<div class="card-header" style="padding-right:-1px;padding-top:0px ">
										<input type="hidden" id="IDNO" name="IDNO" value=<%=WTList.getTankerId() %>> 
										<div class="form-group row" >
											<label class ="col-sm-2 offset-sm-1 h6 col-form-label" for="RwaRegNo"><%=Information.RWARegNo%></label>
										    <div class="col-sm-2 offset-sm-0 h6">
				 								<input type="text" class="form-control-plaintext  is-valid"	id="RwaRegNo" name="RwaRegNo" 
				 								readonly value= ShowWaterTankerDataForUpdate>
										    </div>
											<label for="WaterTankNo" class="col-sm-2 offset-sm-0 h6 col-form-label"><%=Information.WaterTankNo%></label>
											<div class="col-sm-1 offset-sm-0 h6">
												<input type="text" class="form-control-plaintext is-valid"	id="WaterTankNo" name="WaterTankNo" 
				 								readonly value=<%=WTList.getTankerId()%>>
											</div>
											<label for="TankerNo" class="col-sm-2 offset-sm-0 h6 col-form-label"><%=Information.TankerNo%></label>
											<div class="col-sm-2 offset-sm-0 h6">
												<input type="text" readonly class="form-control-plaintext is-valid" 	id="TankerNo" name="TankerNo" 
												value=<%=WTList.getTankerNo() %> >
											</div>
										</div>
		
										<div class="form-group row" >
											<label class ="col-sm-2 offset-sm-1 h6 col-form-label" for="TankerArrivalOn"><%=Information.TankerArrivalOn%></label>
										    <div class="col-sm-2 offset-sm-0 h6">
												<input type="date" readonly class="form-control-plaintext"	id="TankerArrivalOn"name="TankerArrivalOn" 
													value=<%=WTList.getTankerArrivalDateFrom() %> readonly>
										    </div>
											<label class ="col-sm-2 offset-sm-0 h6 col-form-label" for="WtrSuplrNum"><%=Information.WtrSuplrNum %></label>
										    <div class="col-sm-3 offset-sm-0 h6">
				 								<input type="text" class="form-control-plaintext  is-valid"	id="WtrSuplrNum" name="WtrSuplrNum" 
				 								readonly value= <%=WTList.getWaterSupplier() %>>
										    </div>
										</div>
									</div>
									<div class="card-body" >
										<div class="form-row">
											<div class="col-sm-3 offset-sm-1">
												<label for="VerifiedBy" class="col-form-label"><%=Information.VerifiedByTankerIn%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="VerifiedBy"	name="VerifiedBy" 
													value=<%=WTList.getVerifiedByTankerIn() %>>
												</div>
											</div>
											<div class="col-sm-3 offset-sm-1">
												<label for="TankerInTime"><%=Information.TankerInTime%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid" 	id="TankerInTime"name="TankerInTime" 
													value=<%=WTList.getTankerInTime() %>>
												</div>
											</div>
			
											<div class="col-sm-2 offset-sm-1">
												<label for="WaterLevelIn" class="col-form-label"><%=Information.WaterLevelIn%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="WaterLevelIn" name= "WaterLevelIn"
													value=<%=WTList.getWaterLevelIn() %>>
												</div>
											</div>
										</div>
										<div class="form-row">
											<div class="col-sm-3 offset-sm-1">
												<label for="VerifiedByTankerOutTime" class="col-form-label"><%=Information.VerifiedByTankerOut%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="VerifiedByTankerOutTime" 
													value=<%=WTList.getVerifiedByTankerOut() %>>
												</div>
											</div>
											<div class="col-sm-3 offset-sm-1">
												<label for="WaterLevelOut" class="col-form-label"><%=Information.WaterLevelOut%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="WaterLevelOut" name ="WaterLevelOut"
													value=<%=WTList.getWaterLevelOut() %>>
												</div>
											</div>
											<div class="col-sm-2 offset-sm-1">
												<label for="TankCapcity"><%=Information.TankCapcity%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="TankCapcity" name="TankCapcity"	
													value=<%=WTList.getTankerCapacity() %>  >
												</div>
											</div>
										</div>
										<div class="form-row">
											<div class="col-sm-3 offset-sm-1">
												<label for="DriverName"><%=Information.DriverName%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"		id="DriverName"name="DriverName" 
													value=<%=WTList.getDriverName() %>>
												</div>
											</div>
											<div class="col-sm-3 offset-sm-1">
												<label for="DlNo" class="col-form-label"><%=Information.DlNo%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="DlNo"	name="DlNo" 
													value=<%=WTList.getDLNO() %>>
												</div>
											</div>
											<div class="col-sm-2 offset-sm-1">
												<label for="MobileNo" class="col-form-label"><%=Information.MobileNo%></label>
												<div class="input-group">
													<input type="text" class="form-control is-invalid"	id="MobileNo" name="MobileNo"
													value=<%=WTList.getDrvMobilNo() %>>
												</div>
											</div>
										</div>
									</div> <!-- closing of inner card body -->
								</div> <!-- closing of inner card -->

								<% }   /* closing of while loop  */
							}%>   <!--  closing of if statement --> 
 						<br />   
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
					</div><!-- col -->
				</div> <!-- rwo -->
			</div>  <!--end of card BODY -->
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
			<div class="col-lg-12 text-center text-white bg-dark" Style="padding-top: 0px">
				<%=Information.Browser%>
			</div>
		</div>
	</div>
</body>
</html>