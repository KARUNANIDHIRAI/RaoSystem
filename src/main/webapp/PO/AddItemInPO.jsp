<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.rao.System.PO.ConstPO"%>    
 <%@page import="com.raoSystem.constants.Information"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
 
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>

	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
 	<script type="text/javascript" src="../js/PO.js"></script>
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">

	</head>
	<body>
		<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<div class="container" >
			<form id="PurMatId" name="WaterTanker" action="../NewPO" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12" >
						<div class="card " Style="Padding-top:0px" id="">
							<div class="card-header text-light " style="background-color: #38ACEC"  >
									<h5 class=" card-title text-center"><%=ConstPO.New%> <%=ConstPO.PO%></h5>
							</div><!--  End of card header -->
<%-- 							<div class="card-body">
								 <div class="form-row">
									<div class="col-sm-4 offset-sm-0">
										<label for="CustomerName"><%=Information.CustomerName%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id=CustomerName name="CustomerName" 
											pattern="[A-Za-z]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char">
										</div>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="CMobileNo"><%=Information.CMobileNo%></label>
										<div class="input-group">
											<input type="text" class="form-control " 	id="CMobileNo" name="CMobileNo" 
											pattern="[0-9]{10,44}" title="Enter digit between 0-9 with min 10 digit to max 40 digit " >
										</div>
									</div>
								</div>
								 <div class="form-row">
									<div class="col-sm-4 offset-sm-0">
										<label for="VAddress"><%=Information.Address%></label>
										<div class="input-group">
											<input type="text" class="form-control " 	id="VAddress" name="VAddress" >
										</div>
									</div>	
									<div class="col-sm-3 offset-sm-0">
										<label for="City"><%=Information.City%></label>
										<div class="input-group is-invalid">
											<input type="text" class="form-control is-invalid"	id=City name="City" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="State"><%=Information.State%></label>
										<div class="input-group">
											<input type="text" class="form-control " 	id="State" name="State" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="Country"><%=Information.country%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id="Country" name="Country"	 >
										</div>
									</div>
									<div class="col-sm-1	 offset-sm-0">
										<label for="ZipCode"><%=Information.PinCode%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id=ZipCode name="ZipCode" pattern="[0-9]{6,6}">
										</div>
									</div>
								</div>
							</div><!-- end of card body --> 
 --%>							<div class="card-footer">
								<div class="form-row">
									<div class="text-center h6 col-sm-3 offset-sm-0" >
										Purchase Item Detail Information
									</div>
									<div class="col-sm-2 offset-sm-4">
										<label for="PONo" class="h6"><%=ConstPO.PO%> <%=ConstPO.No%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id="PONo" name="PONo"	value=<%=request.getParameter("Id") %>
											readonly pattern="[0-9]{3,20}" title="Enter digit between 0-9 with min 3 digit to max 20 digit ">
										</div>
								   	</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="PODate" class="h6"><%=ConstPO.Date%></label>
										<div class="input-group">
											<input type="date" class="form-control "	id=PODate name="PODate" readonly >
										</div>
									</div>
								</div>
								<hr class="bg-warning" />
								 <div class="form-row ">
									<div class="col-sm-1 offset-sm-0">
										<label for="ItemCode"><%=ConstPO.ItemCode%></label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm" 	id="ItmCode" name="ItmCode"  pattern="[A-Za-z0-9]{4,40}"
											title="Enter character between a-z or A-Z and digit between 0-9 name lenght max 40 char" >
										</div>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="ItemName"><%=Information.ItemName%></label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm" 	id="ItemName" name="ItemName"  pattern="[A-Za-z]{4,40}"
											title="Enter character between a-z or A-Z name lenght max 40 char" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="Brand"><%=ConstPO.Brand%></label>
										<div class="input-group ">
											<input type="text" class="form-control form-control-sm"	id="Brand"	name="Brand" 
											pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char" >
										</div>
									</div>
									<div class="col-sm-1 offset-sm-0">
										<label for="Quantity"><%=Information.Quantity%></label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm"	id="Quantity" name="Quantity"
											pattern="[0-9]+([\.,][0-9]+)?" step="0.01" title="Enter the digit between 0-9" >
										</div>
									</div>
									<div class="col-sm-1 offset-sm-0">
										<label for="Unit"><%=Information.Unit%></label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm"	id="Unit"name="Unit" 
											pattern="[A-Za-z]{1,10}" title="Enter character between a-z or A-Z name lenght max 10 char" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="Note"><%=ConstPO.Note%> </label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm"	id="Note" name="Note"
											pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char" >
										</div>
									</div>
									<div class="col-sm-1 offset-sm-1 ">
										<label for="addTempPOItem" ></label>
										<button type="button" 	class="form-control form-control-sm h5 text-white text-center bg-primary "	 id="addTempPOItem"
											name="addTempPOItem"  data-toggle="tooltip" data-placement="left" title="Click to Add Item In List"><%=Information.SaveBtn%>
										</button>
									</div>
								</div>
								<hr class="h5 bg-warning"/>
								<div class="card-footer  text-dark" id ="ItemHd1">
									<div class="form-row">
										<div class="col-sm-10 offset-sm-1">  <!--  showing data into table -->
											<div class="table-responsive">
												<table id="POItemDetails" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
											</div>
										</div>
									</div>	
								</div>
								<br />
								<div id="sub01">
									<div class="form-row" >
										<div class="col-sm-2 offset-sm-4 ">
											<p>	<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
												style="background-color: #000080"><%=Information.Cancel%></a>
											</p>
										</div>
										<div class="col-sm-2 offset-sm-0 ">
											<button type="submit" 	class="form-control h5 text-white text-center "
												style="background-color: #38ACEC" id="submit01"	name="submit01"><%=Information.Submit%>
											</button>
										</div>
									</div>
								</div>
							</div> <!-- end of card footer  -->
						</div><!-- end of card  -->
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="../FooterPage.jsp"></jsp:include>
	</body>
</html>

