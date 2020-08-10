<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	</head>
	<body>
	<body>
		<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<div class="container" >
			<form id="PurMatId" name="WaterTanker" action="../NewPurMaterial" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12" >

							<div class="card" Style="Padding-top:0px" id="">
								<div class="card-header" style="padding-right:-1px;padding-top:0px ">
									 <div class="form-row">
										<div class="col-sm-2 offset-sm-7">
											<label for="InvoiceNo" class="h6"><%=Information.InvoiceNo%></label>
											<div class="input-group">
												<input type="text" class="form-control  is-invalid"	id="InvoiceNo" name="InvoiceNo"	
												pattern="[0-9]{3,20}" title="Enter digit between 0-9 with min 3 digit to max 20 digit ">
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="InvoiceDate" class="h6"><%=Information.InvoiceDate%></label>
											<div class="input-group">
												<input type="date" class="form-control is-invalid "	id=InvoiceDate name="InvoiceDate"  >
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
												<input type="text" class="form-control is-invalid"	id=CustomerName name="CustomerName" 
												pattern="[A-Za-z]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char">
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="CMobileNo"><%=Information.CMobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid" 	id="CMobileNo" name="CMobileNo" 
												pattern="[0-9]{10,44}" title="Enter digit between 0-9 with min 10 digit to max 40 digit " >
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="OrderNO"><%=Information.OrderNO%></label>
											<div class="input-group">
												<input type="text" class="form-control" 	id="OrderNO" name="OrderNO"  
												pattern="[A-Za-z0-9-\]{4,40}" title="Enter the alphabet between A-Z or a-z,digit between 0-9 with min 4 digit to max 40 digit and Special character -\ ">
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="PaymentMode"><%=Information.PaymentMode%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="PaymentMode" name="PaymentMode"	 >
											</div>
										</div>
									</div>
								</div><!--  End of card header -->
								<div class="card-footer" style="padding-right:-1px;padding-top:0px ">
									<br />
									<div class="form-row" >
										<div class="col-sm-4 offset-sm-0">
												<p class="h5"><%=Information.Vendor%> <%=Information.Info%></p>
										</div>
									</div>
									<hr class="bg-warning h5" />
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="VendorName"><%=Information.VendorName%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid "	id="VendorName" name="VendorName"  
												minlength="3" pattern="[A-Za-z]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char">
												
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="VMobileNo"><%=Information.MobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control " 	id="VMobileNo" name="VMobileNo" >
											</div>
										</div>
										<div class="col-sm-4 offset-sm-0">
											<label for="HsnNo"><%=Information.TinNo%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="HsnNo" name="HsnNo"	 >
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
								</div><!--  end of card Body -->
								<br />
							</div><!--  end of card -->



								<div class="card" Style="Padding-top:0px" >
									<div class="card-header text-dark" id="inv02" style="">
										<div class="text-center h6 ">
											Purchase Item Detail Information
										</div>
									</div>
									<div class="card-body"  >
										 <div class="form-row ">
											<div class="col-sm-3 offset-sm-0">
												<label for="ItemName"><%=Information.ItemName%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm" 	id="ItemName" name="ItemName"  pattern="[A-Za-z]{4,40}"
													title="Enter character between a-z or A-Z name lenght max 40 char" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-1">
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
											<div class="col-sm-1 offset-sm-0">
												<label for="Price"><%=Information.Price%></label>
												<div class="input-group ">
													<input type="text" class="form-control form-control-sm"	id="Price"	name="Price" 
													pattern="[0-9]+([\.,][0-9]+)?" title="Enter the digit between 0-9" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="BAmount"><%=Information.Amount%> </label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="BAmount" name="BAmount"	readonly>
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="DisRate" ><%=Information.Dis%> <%=Information.Percentage%></label>
											  	<div class="input-group">
														<input type="text" class="form-control form-control-sm"	id="DisRate"	name="DisRate" pattern="[0-9]+([\.,][0-9]+)?" title="Enter the digit between 0-9" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="GSTRate"><%=Information.GST%> <%=Information.Percentage%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="GSTRate" name="GSTRate" pattern="[0-9]+([\.,][0-9]+)?" title="Enter the digit between 0-9">
												</div>
											</div>

											<div class="col-sm-1 offset-sm-0">
												<label for="NetAmount" ><%=Information.NetAmount%></label>
											  	<div class=" input-group ">
													<input type="text" class="form-control form-control-sm"	id="NetAmount" name= "NetAmount" pattern="[0-9]+([\.,][0-9]+)?" readonly >
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
									<div class="card-footer" id ="ItemHd1">
										<div class="form-row">
											<div class="col-sm-12">  <!--  showing data into table -->
												<div class="table-responsive">
													<table id="InvItemDetails" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
												</div>
											</div>
										</div>	
										<div id="tablfooter01"> <!--  showing data into table footer total -->
											<br />
											<div class="form-row " >
												<label for="blbTotBillAmount" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.Bill%><%=Information.Amount%></label>
												<div class="input-group col-sm-3 offset-sm-0 ">
												  	<div class="input-group-prepend">
												        <div class="input-group-text ">&#8377</div>
												    </div>
													<input type="text" class="form-control bg-secondary text-light h5 " 	id="TotBillAmount" name="TotBillAmount" Readonly  >
												</div>
											</div>
											<div class="form-row " >
												<label for="TotDisAmount" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.Dis%> <%=Information.Amount%>(-)</label>
												<div class="input-group col-sm-3 offset-sm-0">
												  	<div class="input-group-prepend">
												        <div class="input-group-text ">&#8377</div>
												    </div>
													<input type="text" class="form-control bg-secondary text-light h5"	id="TotDisAmount" name="TotDisAmount" Readonly   >
												</div>
											</div>	
											<div class="form-row " >
												<label for="TotGSTAmt" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.GST%> <%=Information.Amount%>(+)</label>
												<div class="input-group col-sm-3 offset-sm-0">
												  	<div class="input-group-prepend">
												        <div class="input-group-text ">&#8377</div>
												    </div>
													<input type="text" class="form-control bg-secondary text-light h5"	id="TotGSTAmt" name="TotGSTAmt"  Readonly >
												</div>
											</div>	
											<div class="form-row " >
												<label for="TNetAmount" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.Net%> <%=Information.Amount%> </label>
												<div class="input-group col-sm-3 offset-sm-0">
												  	<div class="input-group-prepend">
												        <div class="input-group-text ">&#8377</div>
												    </div>
													<input type="text" class="form-control bg-secondary text-light h5"	id="TotNetAmount" name="TotNetAmount" Readonly >
												</div>
											</div>	
											<br /> <br />  
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
									</div>
								</div>	
								
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="../FooterPage.jsp"></jsp:include>

	
	
 	   <script type="text/javascript">      
		   	$(document).ready(function(){
	               $("#Price").focusout(function(){
						if($("#Quantity").val()>0 &&  $("#Price").val()>0 ){
							$("#BAmount").val(parseFloat($("#Quantity").val()) * parseFloat( $("#Price").val()));
					      	$("#DisRate").focus();
						}
				  	});
	                $("#ItemHd1").hide();
	               	$('#addInvItem').click(function(){
						if($("#ItemName").val()!="" && $("#Unit").val()!="" && $("#BAmount").val()!="" && $("#InvoiceNo").val()!=""){
			                $("#ItemHd1").show();
					   		IName= $('#ItemName').val();
					   		Qty= $('#Quantity').val();
					   		Unt=$('#Unit').val();
					   		IPrice= $('#Price').val();
					   		Amt= $('#BAmount').val();
					   		DiscountRate= $('#DisRate').val();
					   		GSTRT= $('#GSTRate').val();
		        			DiscountRate = (parseFloat( $("#DisRate").val()) >0 ) ?  $("#DisRate").val() : "0";
							GSTRT=  (parseFloat( $("#GSTRate").val()) >0 ) ?  $("#GSTRate").val() : "0";

					   		InvNo=$("#InvoiceNo").val();
					   		txtInit();
							var request =$.ajax({
					   			type:'POST',
					   			data:{ItemName:IName, Quantity:Qty, Unit:Unt, Price:IPrice,Amount:Amt,DisRate:DiscountRate,GSTRate:GSTRT,
				   				InvoiceNo:InvNo, Action:"NEW"},
				   	   		    dataType: 'json',
					   			url:'../test',
					   			success:function(result){
					   				tableItems(result);
					   			}	
	 						});// End Of the $.Ajax()
				   		
				   			request.done(function(msg) {
								/* 	$.each(msg.d, function(key, value) {
								 alert(key +" : "+ value);
								});
								 */				
							});		   		

						}
	            	   alert("moorkh 1");
		   			});	// End Of Add New Item

               $(document).on('click', "Button[name='invitemList']", function(){ 
    				alert($(this).val());
			   		InvNo=$("#InvoiceNo").val();
					var SNo=$(this).val();
 					var request =$.ajax({
			   			type:'POST',
			   			data:{SerialNo:SNo,  InvoiceNo:InvNo, Action:"DELETE"},
		   	   		    dataType: 'json',
			   			url:'../test',
			   			success:function(result){
			   				tableItems(result);
			   			}	

 					});// End Of the $.Ajax()
			   		request.done(function(msg) {
			   			alert(msg);
			   			$.each(msg.d, function(key, value) {
			   				    alert(key +" : "+ value);
			   			});
			   		});		   		
 					
               	});// end of remove item

				$("#InvoiceNo").focusout(function(){
          			InvNo=$("#InvoiceNo").val();
          			var Sno="1";
          			alert(InvNo);
 					var request =$.ajax({
			   			type:'POST',
			   			data:{SerialNo:Sno,  InvoiceNo:InvNo, Action:"EXIST"},
		   	   		    dataType: 'json',
			   			url:'../test',
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

 
		   		
		   		function txtInit(){
					$("#ItemName").val("");
		            $("#Quantity").val("");
		            $("#Price").val("");
		            $("#Unit").val("");
		            $("#BAmount").val("");
		            $("#DisRate").val("");
		            $("#GSTRate").val("");
		            $("#NetAmount").val("");
				}
		   		function tableItems(result){
					$('#InvItemDetails').dataTable({
					    destroy: true,
						"data":result,
						 columnDefs: [
							    		{	targets: -1,
							        		className: 'dt-body-right'
							    		},
							    		{
							    		    data: 'Amount',
							    		    render: $.fn.dataTable.render.number( ',', '.', 2 )
							    		},							    		
							    		{ "width": "4%", "targets": 0 },
							    		{ "width": "23%", "targets": 1 },
							    		{ "width": "8%", "targets": 2 },
							    		{ "width": "6%", "targets": 3 },
							    		{ "width": "7%", "targets": 4 },
							    		{ "width": "10%", "targets": 5 },
							    		{ "width": "7%", "targets": 6 },
							    		{ "width": "8%", "targets": 7 },
							    		{ "width": "7%", "targets": 8 },
							    		{ "width": "9%", "targets": 9 },
							    		{ "width": "11%", "targets": 10 },
							    		
							  		],
					    "columns": [
					    			 { title:	'SNO'             ,data:"Sno"      },
					    			 { title:	'Item Name'       ,data:"ItemName" },  
					    			 { title:	'Quantity'		  ,data:"Quantity" }, 
					    			 { title:	'Unit '           ,data:"Unit"     },
					    			 { title:	'Price'		      ,data:"Price"    },
					    			 { title:	'Amount'          ,data:"Amount"   },
					    			 { title:	'Dis Rate'		  ,data:"DisRate"  },  
					   				 { title:	'Dis Amt'		  ,data:"DisAmount"},
					    			 { title:	'GST Rate'		  ,data:"GSTRate"  },
					    			 { title:	'GST Amt'         ,data:"GSTAmount"},
					    			 { title:	'Net Amt'		  ,data:"NetAmount"}, 

					    			 { title:	'Remove'		  ,data:"Sno",
					    			 	"render": function(data,type,row,meta){
					    			 	return	'<button type="button" name="invitemList"  value="'+data+'" class="btn btn-warning btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					    				 
					    			 	},
					    			 }
					    			 
					    		],
					    "footerCallback": function( row, data, start, end, display ) {
					    	// Remove the formatting to get integer data for summation
					          var api = this.api(), data;
					          
					            // converting to interger to find total
					            var intVal = function ( i ) {
					                return typeof i === 'string' ?
					                    i.replace(/[\$,]/g, '')*1 :
					                    typeof i === 'number' ?
					                        i : 0;
					            };
					 
					            // computing column Total of the complete result 
					            var Amount = api
					                .column( 5 )
					                .data()
					                .reduce( function (a, b) {
					                    return intVal(a) + intVal(b);
					                }, 0 );
									
						    	var Discount = api
					                .column( 7 )
					                .data()
					                .reduce( function (a, b) {
					                    return intVal(a) + intVal(b);
					                }, 0 );
									
					            var GST = api
					                .column( 9 )
					                .data()
					                .reduce( function (a, b) {
					                    return intVal(a) + intVal(b);
					                }, 0 );
									
						     	var NetAmount = api
					                .column( 10 )
					                .data()
					                .reduce( function (a, b) {
					                    return intVal(a) + intVal(b);
					                }, 0 );
					            // Update footer by showing the total with the reference of the column index 
							    $( api.column( 1 ).footer() ).html('Total');								
								$("#TotBillAmount").val(Amount);
								$("#TotDisAmount").val(Discount);
								$("#TotGSTAmt").val(GST);
								$("#TotNetAmount").val(NetAmount);

					    }, // end of footercallback
					}); // end of data table
		   		}// end of the table items function
		   	});// End of Document.ready()

		   	
		   	</script>
		   		
			/* 		   		alert("moorkh");
					   		var agents = [
					               {"id": "007", "agent": "James Bond", "City": "delhi" },                  
					               {"id": "006", "agent": "John Wick","City": "Allahabad" }
					             ]
							 $('#InvItemDetails').dataTable({
								"data":agents,
							    "columns": [{title:'RWA Registration', data:'id'},{title:'Residents Name', data:'agent'}, {title:'City', data:'City'}]
							});
			 */
					   		// iterate over the JSON array
			
			/* 				$.each(agents , function(index, item) { 
							    alert("Agent Id: " + item.id + " Agent Name: " + item.agent);
							});		   	
			 */		   	



	</body>
</html>

