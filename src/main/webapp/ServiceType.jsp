
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.rao.System.PO.ConstPO"%>   
 <%@page import="com.rao.System.MaintWork.MaintConstant"%>   
  
 <%@page import="com.raoSystem.constants.Information"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/Custom.css" type="text/css">

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
  	<script type="text/javascript" src="../js/ServWork.js"></script>
	</head>
	<body>
		<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<div class="container" >
			<form id="NewSWoker" name="NewSWoker" action="../NewMaintWork" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12" >
						<div class="card " Style="Padding-top:0px" id="">
							<div class="card-header text-light " style="background-color: #38ACEC" >
								<h5 class=" card-title text-center"><%=MaintConstant.New%> <%=MaintConstant.Service%> <%=MaintConstant.Provider%></h5>
							</div><!--  End of card header -->
							<div class="card-body">
								<div class="form-row">
									<div class="col-sm-4 offset-sm-0">
										<label for="CustomerName " class="h6"><%=MaintConstant.Service%> <%=MaintConstant.Info%></label>
									</div>
									<div class="col-sm-3 offset-sm-3">
										<label for="SerType " class="h6"><%=MaintConstant.Service%> <%=MaintConstant.Type%></label>
								        <select class="service custom-select h6" name="ServiceType">
								            <option value="1">select option</option>
								            <option value="101">Electricity</option>
								            <option value="102">Plumbering</option>
								            <option value="103">Apartment Maintenance</option>
								        </select>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="SerCharge" class="h6"><%=MaintConstant.Service%> <%=MaintConstant.Charge%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id="SerCharge" name="SerCharge"	
											pattern="[0-9]{1,20}" title="Enter Service charge amount greater than zero">
										</div>
								   	</div>
								</div>
								<hr class="bg-warning h5" id=""/> 
								<div class="form-row">
									<div class="col-sm-3 offset-sm-0">
										<label for="SerNo" class=""><%=MaintConstant.Service%> <%=MaintConstant.NO%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id="SerNo" name="SerNo"	
											pattern="[0-9]{3,20}" title="Enter digit between 0-9 with min 3 digit to max 20 digit ">
										</div>
								   	</div>
									<div class="col-sm-3 offset-sm-1">
										<label for="SDate" class=""><%=MaintConstant.Start%> <%=MaintConstant.Date%></label>
										<div class="input-group">
											<input type="date" class="form-control "	id="SDate" name="SDate" >
										</div>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="EDate" class=""><%=MaintConstant.End%> <%=MaintConstant.Date%></label>
										<div class="input-group">
											<input type="date" class="form-control "	id="EDate" name="EDate" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="SerStatus" class=""><%=MaintConstant.Service%> <%=MaintConstant.Status%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id="SerStatus" name="SerStatus"	
													pattern="[A-Za-z]{4,40}" title="Enter character [a-z or A-Z] and length[min 4- max 40]">
										</div>
								   	</div>
								</div>
								<hr class="bg-warning h5" id=""/> <br />
								 <div class="form-row">
									<div class="col-sm-3 offset-sm-0">
										<label for="CustomerName " class=" h6"><%=MaintConstant.Service%> <%=MaintConstant.Provider%> <%=MaintConstant.Info%></label>
									</div>
									<div class="col-sm-4 offset-sm-2">
										<label for="SPName"><%=MaintConstant.Service%> <%=MaintConstant.Provider%> <%=MaintConstant.Name%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id=SPName name="SPName" 
											pattern="[A-Za-z\s]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char">
										</div>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="CMobileNo"><%=MaintConstant.Mobile%></label>
										<div class="input-group">
											<input type="text" class="form-control " 	id="CMobileNo" name="CMobileNo" 
											pattern="[0-9]{10,44}" title="Enter digit between 0-9 with min 10 digit to max 40 digit " >
										</div>
									</div>
								</div>
								 <div class="form-row">
									<div class="col-sm-4 offset-sm-0">
										<label for="VAddress"><%=MaintConstant.Address%></label>
										<div class="input-group">
											<input type="text" class="form-control " 	id="VAddress" name="VAddress" >
										</div>
									</div>	
									<div class="col-sm-3 offset-sm-0">
										<label for="City"><%=MaintConstant.City%></label>
										<div class="input-group is-invalid">
											<input type="text" class="form-control is-invalid"	id=City name="City" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="State"><%=MaintConstant.State%></label>
										<div class="input-group">
											<input type="text" class="form-control " 	id="State" name="State" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="Country"><%=MaintConstant.Country%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id="Country" name="Country"	 >
										</div>
									</div>
									<div class="col-sm-1	 offset-sm-0">
										<label for="ZipCode"><%=MaintConstant.PinCode%></label>
										<div class="input-group">
											<input type="text" class="form-control "	id=ZipCode name="ZipCode" pattern="[0-9]{6,6}">
										</div>
									</div>
								</div>
							</div><!-- end of card body --> 
							<div class="card-footer">
								 <div class="form-row ">
									<div class="col-sm-3 offset-sm-0 input-group">
									<label for="CustomerName " class=" form-control bg-secondary text-light h6"><%=MaintConstant.Service%> <%=MaintConstant.Worker%> <%=MaintConstant.Info%></label>
									</div>
								</div>
								 <div class="form-row ">
									<div class="col-sm-3 offset-sm-0">
										<label for="wName"><%=MaintConstant.Name%></label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm" 	id="wName" name="wName"  pattern="[A-Za-z\s]{4,40}"
											title="Enter character between a-z or A-Z name lenght max 40 char" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="Note"><%=MaintConstant.Mobile%> </label>
										<div class="input-group">
											<input type="text" class="form-control form-control-sm"	id="wMobile" name="wMobile" pattern="[0-9]+([\,][0-9]{10,40}" title="" >
										</div>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="wDate"><%=MaintConstant.Date%></label>
										<div class="input-group">
											<input type="date" class="form-control form-control-sm" id="wDate" name="wDate"  pattern=""
											title="Enter working Date" >
										</div>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<label for="wCharge"><%=MaintConstant.Wages%></label>
										<div class="input-group ">
											<input type="text" class="form-control form-control-sm"	id="wCharge" name="wCharge" 
											pattern="[0-9]+([\.,][0-9]+)?" step="0.01" title="Enter the digit between 0-9" >
										</div>
									</div>
									<div class="col-sm-1 offset-sm-1 " id="AddSW">
										<label for="addTempSW" ><%=MaintConstant.Action%></label>
										<button type="button" 	class="form-control form-control-sm h5 text-white text-center bg-primary "	 id="addTempSW"
											name="addTempSW"  data-toggle="tooltip" data-placement="left" title="Click to Add Item In List"><%=Information.Add%>
										</button>
									</div>
								</div>
								<hr class="bg-warning h5" id=""/> 
								<div class="card-footer  text-dark" id ="ItemHd1">
									<div class="form-row">
										<div class="col-sm-12">  <!--  showing data into table -->
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

	
	
 	   <script type="text/javascript">      

				$("#PONo").focusout(function(){
          			PONo=$("#PONo").val();
          			var Sno="1";
          			alert(PONo);
 					var request =$.ajax({
			   			type:'POST',
			   			data:{SNo:Sno,  PONO:PONo, Action:"EXIST"},
		   	   		    dataType: 'json',
			   			url:'../TempPOInfo',
			   			success:function(result){
			   				tableItems(result);
			   			}	

 					});// End Of the $.Ajax()
          		});// end of exist Invoice   
/*
          		function calTotalAmount(result){
			   		// iterate over the JSON array
     				$.each(result , function(index, item) { 
     					alert("Amount: " + item.Amount + " Dis Amt: " + item.DisAmount + "GST: " + item.GSTAmountt + " Net Amt: " + item.NetAmount);
     				});		   	
          		}	
*/

 
		   		
/* 		   		function txtInit(){
				    $("#ItmCode").val("");
					$("#ItemName").val("");
		            $("#Brand").val("");
		            $("#Quantity").val("");
		            $("#Unit").val("");
		            $("#Note").val("");
				}
 */
		   	});// End of Document.ready()

		   	
		   	</script>
		   		
	</body>
</html>



<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	    <title>Dynamic Drop Down List Demo (AJAX) - CodeJava.net</title>
	    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("click", "#buttonLoad", function() {
                $.get("../MainMWorkPage", function(responseJson) {
                    var $select = $("#dropdownlist");
                    $select.find("option").remove();  
                    $.each(responseJson, function(index, category) {
                        $("<option>").val(category.id).text(category.name).appendTo($select);
                    });                   
                });
            });
             
            $(document).on("click", "#buttonSubmit", function() {
                var params = {category : $("#dropdownlist option:selected").text()};
                $.post("../MainMWorkPage", $.param(params), function(responseText) {
                    alert(responseText);                   
                });
            });
        </script>
	</head>
	<body>
		<div align="center">
		    <h2>Dynamic Drop Down List (AJAX) Demo</h2>
		    <button id="buttonLoad">Load</button> &nbsp;
		    <select id="dropdownlist"></select>
		    <br/><br/>
		    <button id="buttonSubmit">Submit</button>
		</div>
	</body>
</html>
 --%>