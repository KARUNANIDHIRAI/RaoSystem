<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>    
<!DOCTYPE html>
<html>
	<head>
	
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
	
	
	
	<link rel="stylesheet"  type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
	
	

	<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='webjars/bootstrap/4.3.1/css/bootstrap.css'>

	<script type="text/javascript" 	src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" 	src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<link rel="stylesheet"  type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css">

	<script type="text/javascript" src="webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>



	
	</head>
	<body>
		<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<div class="container" >
			<form id="PurMatId" name="WaterTanker" action="../test" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12" >

							<div class="card" Style="Padding-top:0px" id="inv02">
								<div class="card-header" style="padding-right:-1px;padding-top:0px ">
									 <div class="form-row">
										<div class="col-sm-2 offset-sm-7">
											<label for="InvoiceNo" class="h6"><%=Information.InvoiceNo%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="InvoiceNo" name="InvoiceNo"	 >
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="InvoiceDate" class="h6"><%=Information.InvoiceDate%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id=InvoiceDate name="InvoiceDate">
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-sm-3 offset-sm-0">
											<label class="h5"><%=Information.Customer%> <%=Information.Info%></label>
										</div>
									</div>	
									<hr class="bg-success"/>
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="CustomerName"><%=Information.CustomerName%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id=CustomerName name="CustomerName">
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="CMobileNo"><%=Information.CMobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control " 	id="CMobileNo" name="CMobileNo" >
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="OrderNO"><%=Information.OrderNO%></label>
											<div class="input-group">
												<input type="text" class="form-control" 	id="OrderNO" name="OrderNO" >
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="PaymentMode"><%=Information.PaymentMode%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="PaymentMode" name="PaymentMode"	 >
											</div>
										</div>
									</div>
									<br />
								</div><!--  End of card header -->
							</div>



								<div class="card" Style="Padding-top:0px" >
									<div class="card-header text-dark" id="inv02">
										<div class="text-center h6 ">
											Purchase Item Detail Information
										</div>
									</div>
									<div class="card-body" >
										 <div class="form-row ">
											<div class="col-sm-3 offset-sm-0">
												<label for="ItemName"><%=Information.ItemName%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm" 	id="ItemName" name="ItemName" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-1">
												<label for="Quantity"><%=Information.Quantity%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="Quantity" name="Quantity"	 >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="Unit"><%=Information.Unit%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="Unit"name="Unit" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="Price"><%=Information.Price%></label>
												<div class="input-group ">
													<input type="text" class="form-control form-control-sm"	id="Price"	name="Price" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="BAmount"><%=Information.Amount%> </label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="BAmount" name="BAmount"	>
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="DisRate" ><%=Information.Dis%> <%=Information.Percentage%></label>
											  	<div class="input-group">
														<input type="text" class="form-control form-control-sm"	id="DisRate"	name="DisRate" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="GSTRate"><%=Information.GST%> <%=Information.Percentage%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="GSTRate" name="GSTRate" >
												</div>
											</div>

											<div class="col-sm-1 offset-sm-0">
												<label for="NetAmount" ><%=Information.NetAmount%></label>
											  	<div class=" input-group ">
													<input type="text" class="form-control form-control-sm"	id="NetAmount" name= "NetAmount" >
											    </div>
											</div>
												
											<div class="col-sm-1 offset-sm-0 ">
												<label for="addInvItem" ><%=Information.Action%></label>
												<button type="button" 	class="form-control form-control-sm h5 text-white text-center bg-primary "	 id="addInvItem"
													name="addInvItem"  data-toggle="tooltip" data-placement="left" title="Click to Add Item In List"><%=Information.Add%>
												</button>
											</div>
										</div>
	
									</div><!-- 	end of card body -->
									<div class="card-footer" id ="result1">
										<div class="form-row">
											<div class="col-sm-10">
												<div class="">
													<table id="InvItemDetails" class="table table-bordered" style="width:100%"> 
														<thead> 
															<tr> 
																<th>Item Name </th>
																<th> Quantity</th>
															</tr>
														</thead>
														<tbody> 
															<tr> 
																<td>Mohan Kumar </td>
																<td> Sohan Kumar</td>
															</tr>
															<tr> 
																<td>Raman Kumar </td>
																<td> Daman Kumar</td>
															</tr>
															<tr> 
																<td>Taman Kumar </td>
																<td> Baman Kumar</td>
															</tr>
														</tbody>
													
													</table>
												</div>
											</div>
										</div>	
									</div>
								</div>	
					</div>
				</div>
			</form>
		</div>

 	   <script type="text/javascript">      
		   	alert("moorkh");
		   	$(document).ready(function(){
		   		$('#addInvItem').click(function(){
				   	alert("moorkh 1");
			   		IName= $('#ItemName').val();
			   		Qty= $('#Quantity').val();
			   		Unt=$('#Unit').val();
			   		IPrice= $('#Price').val();
			   		Amt= $('#BAmount').val();
			   		DiscountRate= $('#DisRate').val();
			   		GSTRT= $('#GSTRate').val();
			   		InvNo=$("#InvoiceNo").val();
//			   		alert("Iname"+IName +" "+" qty "+Qty+ " Price "+IPrice+" Amount "+Amt+ " Discount rate "+DiscountRate+" GST AMOUNT  "+GSTRT );

					var request =$.ajax({
			   			type:'POST',
			   			data:{ItemName:IName, Quantity:Qty, Unit:Unt, Price:IPrice,Amount:Amt,DisRate:DiscountRate,GSTRate:GSTRT, InvoiceNo:InvNo},
			   			url:'../test',
			   			success:function(result){
//			   				$("#InvItemDetails").html(result);
							 $('#InvItemDetails').dataTable({
									"data":result,
								    "columns": [{title:'Item Name', data:'ItemName'},{title:'Quantity', data:'Quantity'}]
							});
				   				
			   			},
			   		});
					request.done(function(msg) {
						alert("Data save :"+msg);
					
					});
					
		   		});
		   	});

		   	function getAllInvoiceItem(result){
				alert("alert getinvoice data ");
		   		$("#InvItemDetails").datatable().fnDestroy();
		   		$.Ajax({

					url:"../test",
					type:"GET",
					DataType:"JSON",
						
					success:function(data){
						$("#InvItemDetails").datatable({
					        "aaData": data,
					        "scrollY": 300,
					        "scrollX": true,
					        "aoColumns": [ 
								        	{"sTitle":"Item Name", "mData":"ItemName"},
								        	{"sTitle":"Quantity", "mData":"Quantity"},
								        	{"sTitle":"Unit", "mData":"Unit"},
								        	{"sTitle":"Price", "mData":"Price"},
								        	{"sTitle":"Amount", "mData":"Amount"},
								        	{"sTitle":"Dis Rate", "mData":"DisRate"},
								        	{"sTitle":"Dis.Amt.", "mData":"DisAmount"},
								        	{"sTitle":"GST Rate", "mData":"GSTRate"},
								        	{"sTitle":"GST Amt.", "mData":"GSTAmount"},
								        	{"sTitle":"Net Amt.", "mData":"NetAmount"},
								        	{"sTitle":"Remove", "mData":"Sno",
								        		"render":function(mData,type,row,meta){
								        			return '<button type="button" class="btn btn-warning" onclick()="get_detail('+mData+')"> Remove</button>'
								        		}	
								        	},
					        			 ]						
						}); // end of success:function(data)
					}	
				}); // end of $.Ajax
		   	} // end of getInvoiceItems
	    </script>
	    		<br /> <br />
	    		<jsp:include page="../FooterPage.jsp"></jsp:include>
	    
	</body>
</html>
<!-- 	  <h4>Example: Form</h4>
	  <form action="../test" method="post" name="form" >
		<div class="from-group offset-sm-2"> 
			<label for="Fn01"> First Name </label>
			<input id ="Fn01" name="Fn01" type= "text" class="form-control  col-sm-4 "  placeholder="First Name">
		</div>
		<div class="form-group offset-sm-2">
		    <label for="Ln01">Last Name</label>
		    <input id="Ln01" name="Ln01"  type="text" class="form-control col-sm-4 " placeholder="last Name">
  		</div>
		<div class="form-group offset-sm-2" >
			<span id="result1"></span>
  		</div>

		<br />
		<br /> 
		<div class="from-group offset-sm-3"> 
			<button id ="but01" name="but01" type= "button"  class="bg-secondary col-sm-2 text-ligth">Add New Rec </button>
		</div>

		<div class="from-group offset-sm-3"> 
			<input id ="subi01" name="sub01" type= "submit" class="form-control bg-primary col-sm-2 " 
			 placeholder="Submit">
		</div>
	  </form>   
 -->

