
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.MASItem.ItemConstant"%>
<%@page import="java.util.Iterator"%> 
<%@page import="java.util.ArrayList"%> 

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>

 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

	<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
 
  	<script type="text/javascript" src="../js/ServWork.js"></script>
 
 	</head>
	<body>
		<!-- Page Header -->
			<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<!-- Page Body -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../MainItemPage" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=ItemConstant.Rwa%> <%=ItemConstant.Info%></a></li>
									<li class="nav-item " id="NEWPO"><a class="nav-link text-light" href="NewRwaReg.jsp">
										<%=ItemConstant.New%> <%=ItemConstant.Rwa%> <%=ItemConstant.Info%></a></li>
								</ul>
							</div>
							<div class="card-body text-dark h6">
								<div class="form-row">
									<div class="col-sm-9 offset-sm-3">
										<p class="text-danger h6"><%=session.getAttribute("Message") == null ? "" : session.getAttribute("Message")%></p>
										<%session.removeAttribute("Message"); %>
									</div>
								</div>
								<br />
								<div class="form-row ">
									<div class="col-sm-4 offset-sm-2">
										<label for="rwaRegNo"><%=ItemConstant.RwaRegNo%> </label>
										<select id="rwaRegNo" name="rwaRegNo" 	class="form-control is-invalid">
										</select>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="ActionType"><%=Information.ActionType%></label>
										<select id="ActionType" name="ActionType" 	class="form-control is-invalid">
											<option selected value="0">Select Action Type</option>
											<option value="1"><%=ItemConstant.View%> </option>
											<option value="2"><%=ItemConstant.Edit%> </option>
										</select>
									</div>
								</div>
								<br />
								<br /> 	<br />
								<div class="form-row">
									<div class="col-sm-2 offset-sm-4 ">
										<p>
											<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
												style="background-color: #000080"><%=Information.Cancel%></a>
										</p>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<button type="button" id ="submitMainItemPage" name ="submitMainItemPage" class="form-control h5 text-white text-center "
											style="background-color: #38ACEC"><%=Information.Submit%>
										</button>
									</div>
								</div>
								<hr class="bg-warning" id="inv02"/>
								<div class="form-row">
									<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
										<div class="table-responsive ">
											<table id="mwList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
									<div class="col-sm-6">  <!--  showing PO Item List in table -->
										<div class="table-responsive">
											<table id="mwWorkerList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
								</div>	
	
							</div>
						</div><!--   end of card -->
					</div>
				</div>
			</form>
		</div>
		<br> 	
		<!--Footer  -->
		<jsp:include page="../FooterPage.jsp"></jsp:include>
		<script type="text/javascript">
		
		</script>

	</body>
</html>




























