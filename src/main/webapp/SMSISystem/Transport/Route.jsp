<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	 	<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>

		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

		<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
		<link rel="stylesheet" href="../../css/custom.css" type="text/css">
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
	</head>
	<body >
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="txnRouteInfo" name="txnRouteInfo" action="../../RouteInfo?Action=xtNRouteInf" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white " id="headingOne" 
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.INFORMATION%></a></li>
 									<li class="nav-item " >
										<button type="button" class="nav-link text-white" id="genxRouteLX"
									    	style="background-color: #000080"> <%=SMFixedValue.View%>  <%=SMFixedValue.ROUTE%>
									    </button> </li>
 								</ul>

 							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row col-sm-12 offset-sm-0">
					<div class="col-sm-4 offset-sm-4">
						<p class="h5 text-center"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> 
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-5 offset-sm-1  form-group">
						    <label for="tRCode"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%></label>
							<input type="text" class="form-control blineTl " id="tRCode" name="tRCode" required>
						</div>
						<div class="col-sm-5 offset-sm-0  form-group">
						    <label for="tRName"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.DESCRIPTION%></label>
							<input type="text" class="form-control blineTl " id="tRName" name="tRName"  required>
						</div>
					</div>	
					<div class="row">
				   		<div class="col-sm-10 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
			  		<br />
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
							<input type = "submit" id ="xtNRoute" name="xtNRoute"  
								   value="Create New Route" class="form-control text-light text-center h5 btn">
							<input type="submit" value="Send Request" class="form-control text-light text-center h5 btn"
								   style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"	>
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="routeList" 	class="table table-striped table-hover compact row-border"
						 	style="width:100%; font-size:14px"></table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#genxRouteLX").click(function(){
			var request =$.ajax({
				type:'POST',
				data:{Action:"genxRouteLX"},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					routeList(result);
				}	
			});	 // eof AJAX
		});

/* 		$("#xtNRoute").click(function(){
			var tRCode  = $("#tRCode").val();
			var tRName = $("#tRName").val();
			if(validateRoute(tRCode, tRName  )){
				route(tRCode, tRName );
			}
		});
		function validateRoute(tRCode, tRName  ){
			if(tRCode==""){
				$("#tRCode").val("Route Name can't be blank");
				$("#tRCode").focusin();
				return false;
			}else if(tRName==""){
				$("#tRName").val("Route Description can't be blank");
				$("#tRName").focusin();
				return false;
			}
			$("#tRCode").val("");
			$("#tRName").val("");
			return true;
		}
		function route(tRCode, trName ){
			var request =$.ajax({
				type:'POST',
				data:{Action:"xtNRouteInf", Code: tRCode, Name: tRName},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					routeList(result);
				}	
			});		
		} // eof subject
 */
 		function routeList(result){
			$('#routeList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'SNo'	           ,data:"SNO"},
					 { title:	'School Reg No.'   ,data:"RegNo"},
					 { title:	'Route Name'       ,data:"Code"},  
					 { title:	'Route Description',data:"Name"},
		    		 { title:	'Action'	       ,data:"iDNO",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xRMtRoute"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	
	   $(document).on('click', "Button[name='xRMtRoute']", function(){ 
			var routeCode=$(this).val();
			var request =$.ajax({
				type:'POST',
				data:{Action:"xRMtrRoute", Code: routeCode},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					routeList(result);
				}	
			});
	   	});// name='XrFaculty
	});// eof of document
	</script>
</html>















