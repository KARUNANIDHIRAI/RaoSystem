<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>
	 	<link rel="stylesheet" 	href='../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
	 	<link rel="stylesheet" 	href='../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

		<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

		<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" 	src="../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		<script type="text/javascript"	src="../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
	  	<script type="text/javascript" src="../js/SMCF.js"></script>
		<link rel="stylesheet" href="../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
 	</head>
	<body >
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="xfmInfo" name="SchInfo" action="../BookPurchase?Action=xBookPurchase" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.PURCHASE%> <%=SMFixedValue.New%>   <%=SMFixedValue.SPORTS%>    <%=SMFixedValue.ITEM%>   </a></li>
									<li class="nav-item " id="XrBKView"><a class="nav-link text-light" href="">
										<%=SMFixedValue.View%>  <%=SMFixedValue.SPORTS%> <%=SMFixedValue.ITEM%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0 ">
						<p class ="h5  text-center">Fill <%=SMFixedValue.New%> <%=SMFixedValue.SPORTS%>  <%=SMFixedValue.ITEM%> <%=SMFixedValue.PURCHASE%> <%=SMFixedValue.INFORMATION%>  </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0 ">
					<div class="row">
						<div class="col-sm-4 offset-sm-0">
						    <label for="spPONO" class ="h6 "><%=SMFixedValue.BOOKPONO%> </label>
							<input type="text" class="form-control blineTlw" id="spPONO" name="spPONO"  value="12" required>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="spSource" class="form-label h6"><%=SMFixedValue.SOURCE%>*</label>
							<input type="text" class="form-control blineTlw" id="spSource" name="spSource" value= "Purchase"  required>
						</div>
 						<div class="col-sm-4 offset-sm-0">
						    <label for="supplier" class ="h6"><%=SMFixedValue.SUPPLIER%> </label>
							<input type="text" class="form-control  blineTlw " id="supplier" name="supplier" value="Supplies" >
						</div>
					</div>	
 					<div class="row">
						<div class="col-sm-4 offset-sm-0">
						    <label for="invDate" class ="h6"><%=SMFixedValue.Invoice%> <%=SMFixedValue.DATE%></label>
							<input type="text" class="form-control blineTlw" id="invDate" name="invDate"  required>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="InvNo" class ="h6 "><%=SMFixedValue.INVNO%> </label>
							<input type="text" class="form-control blineTlw" id="InvNo" name="InvNo" value="123"  required>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="invAmt" class ="h6 "><%=SMFixedValue.Invoice%> <%=SMFixedValue.Amount%></label>
							<input type="text" class="form-control   blineTlw" id="invAmt" 	name="invAmt" value= "20" required>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="totQty" class ="h6 "><%=SMFixedValue.TOTAL%> <%=SMFixedValue.QUANTITY%></label>
							<input type="text" class="form-control   blineTlw" id="totQty" 	name="totQty" value= "200" required>
						</div>
					</div>
					<br />
				</div>	
				<br />
				<div class="bg-light col-sm-12 offset-sm-0" >
 					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="itmCode" class ="h6"><%=SMFixedValue.ITEM%> <%=SMFixedValue.Code%> </label>
							<input type="text" class="form-control blineTl" id="itmCode" name="itmCode"  required
							pattern="[A-Za-z0-9]{4,100}" title=""  value="BK101">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="itmName" class ="h6"><%=SMFixedValue.ITEM%> <%=SMFixedValue.Name%> </label>
							<input type="text" class="form-control   blineTl " id="itmName" name="itmName" placeholder="Name*" required
							pattern="[A-Za-z0-9,-_.\s]{4,100}" title="Enter character between a-z or A-Z.Min 4 char"  value="K N RAI">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="make" class ="h6"><%=SMFixedValue.MAKE%> </label>
							<input type="text" class="form-control   blineTl " id="make" name="make" 
							 title="Enter character between a-z or A-Z.Min 4 char"  value="RAIG ">
						</div>
					</div>	
 					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="MfcDate" class ="h6"><%=SMFixedValue.MANUFACTURING_YEAR%></label>
							<input type="text" class="form-control   blineTl " id="MfcDate" 	name="MfcDate"  
							pattern="[A-Za-z0-9]{4,100}" title=""  value="">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="ExpiryDate" class ="h6"><%=SMFixedValue.EXPIRY_DATE%> </label>
							<input type="text" class="form-control   blineTl " id="ExpiryDate" 	name="ExpiryDate" 
							pattern="[A-Za-z0-9,-_.\s]{4,100}" title="Enter character between a-z or A-Z.Min 4 char" >
						</div>
					</div>	
				</div>	
				<br />
				<div class="bg-light col-sm-12 offset-sm-0" >
 					<div class="row" >	
						<div class="col-sm-2 offset-sm-0">
						    <label for="itmPrice" class ="h6"><%=SMFixedValue.PRICE%></label>
							<input type="text" class="form-control   blineTl " id="itmPrice" 	name="itmPrice"  required
							  value="1000">
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="itmQty" class ="h6"><%=SMFixedValue.QUANTITY%> </label>
							<input type="text" class="form-control   blineTl " id="itmQty" 	name="itmQty"  required
							 pattern="[0-9]{1,5}" value="50">
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="Unit" class ="h6 "><%=SMFixedValue.UNIT%>* </label>
								<select id="Unit" name="Unit" 	class="form-control blineTl"  >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.UNIT%> *</option>
							</select>
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="itmDiscount" class="form-label h6"><%=SMFixedValue.Discount%>*</label>
							<input type="text" class="form-control   blineTl " id="itmDiscount" 	name="itmDiscount" 
							       placeholder="" required  value="11.24 ">
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="itmTax" class="form-label h6"><%=SMFixedValue.TAX%>*</label>
							<input type="text" class="form-control   blineTl " id="itmTax" 	name="itmTax" 
							       required  value="33.50 ">
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="itmNetAmt" class="form-label h6"><%=SMFixedValue.NETAMT%>*</label>
							<input type="text" class="form-control   blineTl " id="itmNetAmt" 	name="itmNetAmt" 
							       required  value="33.50 ">
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="form-row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
							<button type="button" id ="itmpruch10" name="itmpruch10" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=SMFixedValue.SUBMIT %></button>
						</div>
					</div>
					<br />
				</div>
				<br />
				<hr class="bg-warning" id="inv02"/>
				<div class="form-row">
					<div class="col-sm-12 offset-sm-0" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="BookList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$("#BookList").hide();
		$(document).ready(function(){
			$(document).on('click', "Button[name='DelBookInfo']", function(){ 
				var con = confirm("Do you really want to delete? ");
				if(con){
					var bookDelIDDNo  = $(this).val();
					var request =$.ajax({
						type:'POST',
						data:{ bkIDDNO : bookDelIDDNo, Action:"xBkRmDATA"},
					 	dataType: 'json',
						url:'../BookPurchase',
						success:function(result){
							BookList(result);
						}	
					});	 // eof AJAX
				}
			});
			
			$("#XrBKView").click(function(){ 
				var invNo = $("#bkInvNo").val();
				alert("knrawah :" + invNo);
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"xRBKList", invoice:invNo},
				 	dataType: 'Json',
					url:'../BookPurchase',
					success:function(result){
						alert(result);
						//StudentMarksList(result);
					}	
				});	 // eof AJAX
			});
 			function booksList(result){
				$("#BookList").show();
				$('#BookList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
					     { title:	'SNo'	    ,data:"SNO"},
						 { title:	'School '   ,data:"RegNo"},
						 { title:	'PONO'      ,data:"PONO"},  
						 { title:	'ISBN'      ,data:"ISBN"},  
						 { title:	'BookCode'  ,data:"BookCode"},  
						 { title:	'Title'     ,data:"Title" },  
						 { title:	'Auther'    ,data:"Author" },  
						 { title:	'Qty'       ,data:"Qty"},  
						 { title:	'Price'     ,data:"Price"},
						 { title:	'Discount'  ,data:"Discount"},
						 { title:	'Tax'       ,data:"Tax"},
						 { title:	'NetAmount' ,data:"NetAmount"},  
						 { title:	'Publisher' ,data:"Publisher" },  
						 { title:	'Source'    ,data:"Source"},  
						 { title:	'Edition'   ,data:"Edition"},
						 { title:	'Invoice'   ,data:"invoceNo"},
			    		 { title:	'Remove'    ,data:"IDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xrBKData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
			        		},
				        }
					]
				}); 
			}// EOF table FUNCTION	
			$("#itmpruch10").click(function(){  
 				var xitmpruch10 = [];
 				xitmpruch10 = updateItmPurData(xitmpruch10);
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"xNritemPurchase", xitempruch :  xitmpruch10},
				 	dataType: 'Json',
					url:'../SportItemPurchase',
					success:function(result){
						SprotItemList(result);
						scrollPageUP(6000);
						resetBKBorredData()
					}	
				});					
			});
			function updateItmPurData(xitmpruch10){ 
				xitmpruch10.push($("#spPONO").val());
				xitmpruch10.push($("#spSource").val());
				xitmpruch10.push($("#supplier").val());
				xitmpruch10.push($("#invDate").val());
				xitmpruch10.push($("#InvNo").val());
				xitmpruch10.push($("#invAmt").val());
				xitmpruch10.push($("#totQty").val());

				xitmpruch10.push($("#itmCode").val());
				xitmpruch10.push($("#itmName").val());
				xitmpruch10.push($("#make").val());
				xitmpruch10.push($("#MfcDate").val());
				xitmpruch10.push($("#ExpiryDate").val());
				xitmpruch10.push($("#itmPrice").val());
				xitmpruch10.push($("#itmQty").val());
				xitmpruch10.push($("#Unit").val());
				xitmpruch10.push($("#itmDiscount").val());
				xitmpruch10.push($("#itmTax").val());
				xitmpruch10.push($("#itmNetAmt").val());
				return xitmpruch10;
			}
			function resetBKBorredData(){ 
				$("#itmCode").val("")    ;
				$("#itmName").val("")    ;
				$("#make").val("")       ;
				$("#MfcDate").val("")    ;
				$("#ExpiryDate").val("") ;
				$("#itmPrice").val("")   ;
				$("#itmQty").val("")     ;
				$("#Unit").val("")       ;
				$("#itmDiscount").val("");
				$("#itmTax").val("")     ;
				$("#itmNetAmt").val("")  ;

			}
 		});// document.ready eof
	</script>
</html>
