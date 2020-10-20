<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

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

			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		 
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->

		<div class="container" >
			<form id="AptInfo01" name="AptInfo01" action="../AptInfo" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="card" style="background-color:#FFFFFF">
							<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC ;
							    padding-right:-1px">
	
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a 	class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.NewAPTInfo%></a></li>
										<li class="nav-item "><button type="button" class="nav-link text-white" id="ViewAptIntr"
										    style="background-color: #000080">
											<%=Information.View%> <%=Information.APTFaltInventory%> 
										</button> </li>
								</ul>
							</div>
							<br />
							<div class="row">
								<div class="col-sm-12  offset-sm-0" style="padding-left:20px; padding-right:20px">
								    <h5 class="card-title text-center">Appartment Inventory Information</h5>
					    			<p class="text-danger text-center"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
																	<%session.removeAttribute("Message");%>
								</div>									
		        				<br />
							</div>
							<div class="bg-light col-sm-12 offset-sm-0">
								<br />
								<div class="row">		
									<div class="col-sm-4 offset-sm-1  form-group">
										<label for="inputTowerNo"><%=Information.AptTowerNo%></label>
										<input type="text" class="form-control blinebl " id="inputTowerNo" name="inputTowerNo" 
										data-toggle="tooltip" data-placement="top"	title="Enter Tower/Appartment No"required>
									</div>
									<div class="col-sm-4 offset-sm-0  form-group">
									    <label for="inputFlatCategoryNo"><%=Information.FlatCategoryNo%></label>
										<input type="text" class="form-control blinebl " id="inputFlatCategoryNo" 
										name="inputFlatCategoryNo" data-toggle="tooltip" data-placement="top"
										title="Enter Flat Category(based on size of Flat)" required>
									</div>
									<div class="col-sm-3 offset-sm-0">
										<label for="inputSizeOfFlat"><%=Information.SizeOfFlat%></label>
										<div class="input-group">
											<input type="text" class="form-control blinebl " id="inputSizeOfFlat" 
											name="inputSizeOfFlat" data-toggle="tooltip" data-placement="top"
											title="Enter Flat size in square feet" required>
									    	<div class="input-group-prepend">
									        	<div class="input-group-text"><sub >FT</sub> 2</div>
									    	</div>
										</div>
									</div>
								</div>	
								<div class="row">		
									<div class="col-sm-4 offset-sm-1  form-group">
										<label for="inputFltStartNo"><%=Information.FlatStartingNo%></label>
										<input type="text" class="form-control blinebl " id="inputFltStartNo" name="inputFltStartNo" 
										data-toggle="tooltip" data-placement="top" pattern= "[0-9]{1,4}"	
										title="Enter Flat Number starting in  above entered category" required>
									</div>
									<div class="col-sm-4 offset-sm-0  form-group">
									    <label for="inputFltEndNo" class="col-form-label"><%=Information.FlatEndingNo%></label>
										<input type="text" class="form-control blinebl " id="inputFltEndNo" 
										name="inputFltEndNo" data-toggle="tooltip" data-placement="top" pattern= "[0-9]{1,4}"	
										title="Enter Flat Number ending in  above entered category" required>
									</div>
								</div>	
								<br />
								<div class="row">
									<div class="col-sm-2 offset-sm-4 ">
										<p><a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
											style="background-color: #000080"><%=Information.Cancel%></a></p>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="submit" 	class="form-control h5 text-white text-center "
											style="background-color: #38ACEC" id="aptInvtAdd" name="aptInvtAdd"><%=Information.Add%>
										</button>
									</div>
								</div>
								<br />
							</div>
							<div class="row">
								<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
									<div class="table-responsive ">
										<table id="nwItm" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
									</div>
								</div>
							</div>	
						</div>  <!--end of card BODY -->
					</div>
				</div>
			</form>
		</div>
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#ViewAptIntr").click(function(){
			alert("india");
			var request =$.ajax({
				type:'POST',
				data:{Action:"aptInvtrView"},
			 	dataType: 'Json',
				url:'../AptInfo',
				success:function(result){
					aptInvtList(result);
				}	
			});	 // eof AJAX
		});

		$(document).on('click', "Button[name='DelAptInventory']", function(){ 
			var con = confirm("Do you really want to delete? ");
			if(con){
				var aptInvDelID  = $(this).val();
				var request =$.ajax({
					type:'POST',
					data:{ aptInvdel : aptInvDelID, Action:"aptInventoryDel"},
				 	dataType: 'json',
					url:'../AptInfo',
					success:function(result){
						aptInvtList(result);
					}	
				});	 // eof AJAX
			}
		});
				
		function aptInvtList(result){
			$('#nwItm').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [
					 {	targets: -1, className: 'dt-body-right'	},
				 ],
			    "columns": [
					 { title:	'SNO'	            ,data:"SNO"},
					 { title:	'RWA Reg No'        ,data:"RwaNo"},
					 { title:	'Tower No'          ,data:"TowerNo"},  
					 { title:	'Category'          ,data:"FCategory"},
					 { title:	'Flat Size'	        ,data:"FSize"}, 
					 { title:	'Flats In Category'	,data:"TFinCategory"}, 
					 { title:	'Flat Starting No'	,data:"FSNo"}, 
					 { title:	'Flat Ending No'	,data:"FENO"}, 
		    		 { title:	'Del'		  ,data:"iDNO",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="DelAptInventory"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	

		$("#aptInvtAdd").click(function(){
			var inputTowerNo  = $("#inputTowerNo").val();
			var inputFlatCategoryNo = $("#inputFlatCategoryNo").val();
			var inputSizeOfFlat  = $("#inputSizeOfFlat").val();
			var inputFltStartNo = $("#inputFltStartNo").val();
			var inputFltEndNo  = $("#inputFltEndNo").val();
			if(aptInvtValid(inputTowerNo, inputFlatCategoryNo , inputSizeOfFlat,inputFltStartNo, inputFltEndNo )){
				addAptInvt(inputTowerNo, inputFlatCategoryNo , inputSizeOfFlat,inputFltStartNo, inputFltEndNo);
			}
		});
		function aptInvtValid(inputTowerNo, inputFlatCategoryNo , inputSizeOfFlat,inputFltStartNo, inputFltEndNo ){
			alert("itemValid");
			if(inputTowerNo==0){
				$("#inputTowerNo").focusin();
				$("#inputTowerNo").val("Tower No can't be blank");
				return false;
			}else if(inputFlatCategoryNo==0){
				$("#inputFlatCategoryNo").focusin();
				$("#inputFlatCategoryNo").val("Flat Category can't be blank");
				return false;
			}else if(inputSizeOfFlat==0){
				$("#inputSizeOfFlat").focusin();
				$("#inputSizeOfFlat").val("Size of flat can't be blank");
				return false;
			}else if(inputFltStartNo==0){
				$("#inputFltStartNo").focusin();
				$("#inputFltStartNo").val("Flat Start no can't be blank");
				return false;
			}else if(inputFltEndNo==0){
				$("#inputFltEndNo").focusin();
				$("#inputFltEndNo").val("Flat end no can't be blank");
				return false;
			}
			$("#inputTowerNo").val("");
			$("#inputFlatCategoryNo").val("");
			$("#inputSizeOfFlat").val("");
			$("#inputFltStartNo").val("");
			$("#inputFltEndNo").val("");
			return true;
		}
		function addAptInvt(inputTowerNo, inputFlatCategoryNo , inputSizeOfFlat,inputFltStartNo, inputFltEndNo){
			var request =$.ajax({
				type:'POST',
				data:{Action:"AddAptInv", "inputTowerNo" : inputTowerNo, "inputFlatCategoryNo" : inputFlatCategoryNo,
					 "inputSizeOfFlat" :inputSizeOfFlat, "inputFltStartNo" :inputFltStartNo ,"inputFltEndNo" :inputFltEndNo},
			 	dataType: 'Json',
				url:'../AptInfo',
				success:function(result){
					aptInvtList(result);
				}	
			});	 // eof AJAX
		}// eof ValidateUserEmail()	
	});
	</script>
</html>


