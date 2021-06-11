<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<link rel="stylesheet" href="../css/custom.css" type="text/css">
			<link rel="stylesheet" href="../css/SMST.css" type="text/css">
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
 
 
 	</head>
	<body >
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="xfmInfo" name="SchInfo" action="../BookPurchase?Action=xBookPurchase" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.New%>  <%=SMFixedValue.PURCHASE%> <%=SMFixedValue.BOOK%>   </a></li>
									<li class="nav-item " id="XrBKView"><a class="nav-link text-light" href="">
										<%=SMFixedValue.View%>  <%=SMFixedValue.BOOK%> <%=SMFixedValue.INFORMATION%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0 ">
						<p class ="h5  text-center">Fill <%=SMFixedValue.New%> <%=SMFixedValue.BOOK%> <%=SMFixedValue.PURCHASE%> <%=SMFixedValue.INFORMATION%>  </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0 blinew" Style="border:1px solid">
					<div class="row">
						<div class="col-sm-4 offset-sm-0">
						    <label for="RegNo" class ="h6 "><%=SMFixedValue.School%> <%=SMFixedValue.Code%></label>
							<input type="text" class="form-control   blinew " id="RegNo" 	name="RegNo" readonly>
						</div>
						<div class="col-sm-4 offset-sm-4">
						    <label for="supplier" class ="h6 "><%=SMFixedValue.SUPPLIER%> </label>
							<input type="text" class="form-control  blinew " id="supplier" name="supplier" value="Supplies" >
						</div>
					</div>	
 					<div class="row">
						<div class="col-sm-4 offset-sm-0">
						    <label for="dor" class ="h6"><%=SMFixedValue.Invoice%> <%=SMFixedValue.DATE%></label>
							<input type="text" class="form-control blinebl" id="dor" name="dor"  required>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkInvNo" class ="h6 "><%=SMFixedValue.INVNO%> </label>
							<input type="text" class="form-control   blinebl " id="bkInvNo" 	name="bkInvNo" value="123"  required>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="invAmt" class ="h6 "><%=SMFixedValue.Invoice%> <%=SMFixedValue.Amount%></label>
							<input type="text" class="form-control   blinew " id="invAmt" 	name="invAmt" value= "20" required>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="totQty" class ="h6 "><%=SMFixedValue.TOTAL%> <%=SMFixedValue.QUANTITY%></label>
							<input type="text" class="form-control   blinew " id="totQty" 	name="totQty" value= "200" required>
						</div>
					</div>
					<br />
				</div>	
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
 					<div class="row">	
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkISBN" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.ISBN%> </label>
							<input type="text" class="form-control   blinebl " id="bkISBN" 	name="bkISBN"  required
							pattern="[A-Za-z0-9,-_.\s]{4,100}" title="Enter character between a-z or A-Z.Min 4 char"  value="12345678">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkPubName" class ="h6"><%=SMFixedValue.PUBLICATION%> <%=SMFixedValue.Name%></label>
							<input type="text" class="form-control   blinebl " id="bkPubName" 	name="bkPubName"  required
							pattern="[A-Za-z0-9,-_.\s]{4,100}" title="Enter character between a-z or A-Z.Min 4 char"  value="Geeta Publication Ghorakhpur">
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="bkEdition" class="form-label h6"><%=SMFixedValue.EDITION%>*</label>
							<input type="text" class="form-control   blinebl " id="bkEdition" 	name="bkEdition" placeholder="First Edition" required
							 title="Enter character between a-z or A-Z.Min 4 char"  value="RAIG ">
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkCode" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.Code%> </label>
							<input type="text" class="form-control   blinebl " id="bkCode" 	name="bkCode"  required
							pattern="[A-Za-z0-9]{4,100}" title=""  value="BK101">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkTitle" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.TITLE%> </label>
							<input type="text" class="form-control   blinebl " id="bkTitle" 	name="bkTitle" placeholder="Name*" required
							pattern="[A-Za-z0-9,-_.\s]{4,100}" title="Enter character between a-z or A-Z.Min 4 char"  value="K N RAI">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkAuthor" class ="h6"><%=SMFixedValue.AUTHOR%> </label>
							<input type="text" class="form-control   blinebl " id="bkAuthor" name="bkAuthor" placeholder="last Name*" required
							 title="Enter character between a-z or A-Z.Min 4 char"  value="RAIG ">
						</div>
					</div>	
					<br />
 					<div class="row">	
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkPONO" class ="h6 "><%=SMFixedValue.BOOKPONO%> </label>
							<input type="text" class="form-control   blinebl " id="bkPONO" 	name="bkPONO"  value="12" required>
						</div>
						<div class="col-sm-4 offset-sm-0">
							<label for="bkSource" class="form-label h6"><%=SMFixedValue.SOURCE%>*</label>
							<input type="text" class="form-control blinebl" id="bkSource" name="bkSource" value= "Purchase"  required>
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
 					<div class="row">	
						<div class="col-sm-3 offset-sm-0">
						    <label for="bkPrice" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.PRICE%></label>
							<input type="text" class="form-control   blinebl " id="bkPrice" 	name="bkPrice"  required
							  value="1000">
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkQty" class ="h6"><%=SMFixedValue.BOOKCOPIES%> </label>
							<input type="text" class="form-control   blinebl " id="bkQty" 	name="bkQty"  required
							 pattern="[0-9]{1,5}" value="50">
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="bkDiscount" class="form-label h6"><%=SMFixedValue.Discount%>*</label>
							<input type="text" class="form-control   blinebl " id="bkDiscount" 	name="bkDiscount" 
							       placeholder="First Edition" required  value="11.24 ">
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="bkTax" class="form-label h6"><%=SMFixedValue.TAX%>*</label>
							<input type="text" class="form-control   blinebl " id="bkTax" 	name="bkTax" 
							       required  value="33.50 ">
						</div>
						<div class="col-sm-3 offset-sm-0">
							<label for="bkNetAmt" class="form-label h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.NETAMT%>*</label>
							<input type="text" class="form-control   blinebl " id="bkNetAmt" 	name="bkNetAmt" 
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
							<button type="submit" id ="subSch01" name="subSch01" class="form-control     text-light 
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
 	 			alert("wait books list");
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
		});// document.ready eof
	</script>
</html>
