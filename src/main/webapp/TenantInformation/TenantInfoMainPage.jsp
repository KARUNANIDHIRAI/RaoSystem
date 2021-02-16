<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="../css/Custom.css" type="text/css">
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body>
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<!-- Page Body -->
		<div class="container">
			<form id="HMKInfo" name="HMKInfo" action="../tntInforMPG" method="post"
				class="form-horizontal needs-validation" autocomplete="off" >
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-header text-white" id="headingOne" style="background-color:#38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser" > 
										<a	class="nav-link active text-white " style="background-color:#000080" href="#">
										Tenant Information</a></li>
									<li class="nav-item " id="SSPNEW">
										<a class="nav-link text-light" href="TenantInfoNew.jsp">New Tenant Information</a></li>
								</ul>
							</div>
							<div class="card-body text-dark h6" >
								<br /> 
								<div class= "form-row">
									<div class="col-sm-9 offset-sm-3">
					    			<p class="text-danger h6"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
															<%session.removeAttribute("Message");%>
									</div>
								</div>
								<div class="form-row ">
									<div class="col-sm-4 offset-sm-2">
										<label for="RwaRegNo" ><%=Information.RWARegNo%></label>
										<div class="input-group">
											<input type="text" class="form-control" id="RwaRegNo" name="RwaRegNo" readonly>
										</div>
									</div>
								    <div class="col-sm-4 offset-sm-0">
								      	<label for="ActionType" ><%= Information.TransactionType%></label>
									    <select id ="ActionType" name="ActionType" class="form-control is-invalid">
											<option selected value="1">View Tenant Information </option>
											<option value="2">Edit Tenant Information </option>
											<option value="3">Remove Tenant Information </option>
									    </select>
							    	</div>
								</div>
								<br />
								
<%-- 								<div class="form-row ">
									<div class="col-sm-4 offset-sm-2">
										<label for="apartment" ><%=Information.apartment%></label>
										<input type="text" class="form-control is-invalid"
											id="apartment" name="apartment" placeholder=<%=Information.apartment%> required>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="flatInfo" ><%=Information.flatNo%></label>
										<div class="input-group">
											<input type="text" class="form-control is-invalid"	id="flatInfo" name="flatInfo" 
											placeholder ="Enter Flat No. " required>
										</div>
									</div>
								</div>
 --%>							
 								<div class= "form-row">
									<div class="col-sm-4 offset-sm-2 ">
										<select id="apartment" name="apartment" class="form-control blinebl" required>
											<option selected value ="0">Choose Apartment*</option>
										</select>
									</div>
 									<div class="col-sm-4 offset-sm-0 " >
										<select id="flatInfo" name="flatInfo" class="form-control blinebl" required>
											<option selected value ="0">Select Flat No*</option>
										</select>
									</div>
 								</div>	
								<br />
								<br /><br /><br />
								<div class="form-row">
									<div class="col-sm-2 offset-sm-4 ">
										<p>	<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
										       style="background-color:#000080"><%=Information.Cancel%></a></p>
									</div>
							    	<div class="col-sm-2 offset-sm-0 ">
								      	<button type="button" class="form-control h5 text-white text-center " 
								      	        style="background-color:#38ACEC" id="tntList01" name = "tntList01" >
								      	        <%=Information.Submit %>
								        </button>
								    </div>
								</div>
								<div class="row">
									<div class="col-sm-12 offset-sm-0" >  <!--  showing data into table -->
										<div class="table-responsive ">
											<table id="TNTList" class="table table-striped table-hover compact row-border"
											  style="width:100%; font-size: 12px;">
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
		<!--Footer  -->
		<br />
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		<script type="text/javascript">
			$(document).ready(function() {
				$("#tntList01").click(function(){
					var aptNo = $("#apartment").val();
					var fltNo = $("#flatInfo").val();
					if(tntVeiwInfoValid(aptNo, fltNo)){
						alert("Validation is ok");
						tntInfoSummaryList(aptNo, fltNo);
					}
				});

				function tntVeiwInfoValid(aptNo, fltNo){
					if(aptNo=="" || aptNo==0){
						$("#apartment").focusin();
						$("#apartment").val("Apt No can't be blank");
						return false;
					}else if(fltNo=="" || fltNo==0 ){
						$("#flatInfo").focusin();
						$("#flatInfo").val("Flat No can't be blank");
						return false;
					}
					return true;
				}
				function tntInfoSummaryList(aptNo, fltNo){
					alert("flatNo: "+fltNo+ "AptNo : "+ aptNo);
					var request =$.ajax({
						type:'POST',
						data:{"Action":"TNTInfoSummary", "apartment" : aptNo, "flatInfo" : fltNo},
					 	dataType: 'Json',
						url:'../TenantInfo',
						success:function(result){
							tntInfoTableList(result);
						}
					});	 
				}// eof ViewVehInfo()	
				
				function tntInfoTableList(xresult){
					alert('wah wah');
					$('#TNTList').dataTable({
					    destroy: true,
						"data":xresult,
						 columnDefs: [
							 {	targets: -1, className: 'dt-body-right'	},
						 ],
					    "columns": [
							 { title:	'SNO'	      ,data:"SNO"},
							 { title:	'RWA Reg.No.' ,data:"RwaNo"},
							 { title:	'Apt.No'      ,data:"AptartmentNo"},
							 { title:	'Flat No.'    ,data:"FlatNo"},  
							 { title:	'Name'        ,data:"Name"},
							 { title:	'Email ID'    ,data:"EmailID"},
							 { title:	'Mobile No'   ,data:"MobileNo"},
							 { title:	'Phone'         ,data:"Phone"},
							 { title:	'Shifted On'    ,data:"ShiftOn"},
							 { title:	'Shifted out On',data:"ShiftOutOn"},
				    		 { title:	'Del'		    ,data:"iDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="TNTInfoDel"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					        	},
					        },
				    		 { title:	'Edit'		 ,data:"iDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="TNTInfoEdit"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					        	},
					        }
						]
					}); // EOF table
				}// EOF table FUNCTION	
			});
			$(document).on('click', "Button[name='TNTInfoEdit']", function(){ 
				var tntInfoEditID  = $(this).val();
				var request =$.ajax({
					type:'POST',
					data:{"Action":"TNTInfoEDit",  "TNTIDNO" : tntInfoEditID },
				 	dataType: 'Json',
					url:'../TenantInfo',
					success:function(result){
						var url="http://localhost:11872/RAOSystem/TenantInformation/TenantInfoEdit.jsp"
						var myWindow = window.open(url, "MsgWindow", "width=1050,height=700, top=100,left=100,")							
					}	
				});	 // eof AJAX
			});	// EOF document.on
			$(document).on('click', "Button[name='TNTInfoDel']", function(){ 
				var tntInfoEditID  = $(this).val();
				var request =$.ajax({
					type:'POST',
					data:{"Action":"TNTInfoDelII",  "TNTIDNO" : tntInfoEditID },
				 	dataType: 'Json',
					url:'../TenantInfo',
					success:function(result){
						tntInfoTableList(result);
					}	
				});	 // eof AJAX
			});	// EOF document.on
		</script>
		/*
		-- SINAREST   ---- COLD AND COUGH
		-- AZEE 500 MG ---- COLD AND COUGH
		--
		*/
	</body>
</html>



























