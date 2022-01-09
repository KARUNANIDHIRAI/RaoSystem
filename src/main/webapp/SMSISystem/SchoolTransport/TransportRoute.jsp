<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	 	<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
<!-- 			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script> -->
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>
<!-- 			<link rel="stylesheet" href="../../css/custom.css" type="text/css"> -->
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
		
			<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
 			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
	</head>
	<body >
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="subInfo" name="subInfo" action="../../RouteInfo?Action=xtNRoutePD" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white " id="headingOne" 
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.INFORMATION%></a></li>
									<li class="nav-item " ><button type="button" class="nav-link text-white" id="tRouteVLX"
									    style="background-color: #000080">
										<%=SMFixedValue.View%>  <%=SMFixedValue.ROUTE%></button> </li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row col-sm-12 offset-sm-0">
					<div class="col-sm-6 offset-sm-4">
						<p class="h5 text-center">Fill Information to <%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> 
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-1  form-group">
   						    <label for="xtRCode" class ="h6"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%>* </label>
							<input type="text" class="form-control blineTl " id="xtRCode" name="xtRCode" required>
						</div>
						<div class="col-sm-5 offset-sm-0  form-group">
  						    <label for="xtRDescription" class ="h6"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.DESCRIPTION%>*</label>
							<input type="text" class="form-control blineTl " id="xtRDescription" name="xtRDescription" required>
 						</div>
					</div>	
				</div>
				<div class="row">
					<div class="col-sm-5 offset-sm-1 ">
			  			<p id="xSTVehicleRoute" class="h6 text-danger"> </p>
			  		</div>
		  		</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-2 offset-sm-4 ">
						    <label class ="h6"  for=""></label>
							<button type = "button" id ="xtNRoutePD" name="xtNRoutePD"  class="form-control text-light text-center h6 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.SAVE%> </button>
						</div>
						<div class="col-sm-2 offset-sm-0 ">
						    <label class ="h6"  for=""></label>
							<button type = "button" id ="xtNRouteReset" name="xtNRouteReset"  class="form-control text-light text-left h6 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.RESET%> </button>
						</div>
					</div>
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
		<br /><br /><br /><br /> <br />
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	var trCode=" ";
	$(document).ready(function(){

		$("#tRouteVLX").click(function(){
/* 			var request =$.ajax({
				type:'POST',
				data:{Action:"genxRouteLX"},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					routeList(result);
				}	
			});	 // eof AJAX
 */
			var request =$.ajax({
				type:'GET',
				data:{},
			 	dataType: 'Json',
// 				url:'http://localhost:8088/smsi/route/getTransportRoutes',
				url:'http://localhost:8088/smsi/transportInfo/RouteInfo?regNo=MK308',
				
				success:function(result){
					routeList(result.data);
					document.getElementById("xSTVehicleRoute").innerHTML = "";
				}	
			});	 // eof AJAX

		});
		$("#xtNRouteReset").click(function(){ 
			$("#xtNRouteReset").html("Reset")
			$("#xtNRoutePD").prop('disabled', false);
		});
		$("#KNxtNRoutePD").click(function(){
			if(validatePKDPRroute()){
				var xrouteUpdata = [];
				xrouteUpdata = updatePKDRData(xrouteUpdata);
				$("#xtNRoutePD").prop('disabled', true);
				$("#xtNRouteReset").html("Add")
				var request =$.ajax({
					type:'POST',
	 				data:{Action:"xtNRoutePKPDR", xPKAndDRP :  xrouteUpdata},
				 	dataType: 'Json',
					url:'../../RouteInfo',
					success:function(result){
						scrollPageUP(6000);
					}	
				});					
			}
		});
		$("#xtNRoutePD").click(function(){
			if(validatePKDPRroute()){
				$("#xtNRoutePD").prop('disabled', true);
				$("#xtNRouteReset").html("Add")
				var request =$.ajax({
					type:'POST',
					headers: { 'Content-Type':'application/json'},				
					data:JSON.stringify({"routeName" : $("#xtRCode").val(), "routeDescription" : $("#xtRDescription").val() }),
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/route/transportRoute',
					success:function(result){
						document.getElementById("xSTVehicleRoute").innerHTML = result.message;
					}	
				});					
			}
		});

		function updatePKDRData(xrouteUpdata){ 
			xrouteUpdata.push($("#xtRCode").val()) ;
			xrouteUpdata.push($("#xtRDescription").val()) ;
			return xrouteUpdata;
		}
		
		function validatePKDPRroute(xrouteUpdata){
			if($("#xtRCode").val()=="" || $("#xtRCode").val()=="Invalid Route Name."){
				alert("Invalid Route Name.");
				return false;
			}else if($("#xtRDescription").val()=="" || $("#xtRDescription").val()=="Invalid Route Description."){
				alert("Invalid Route Description.");
				return false;
			}
			return true;
		}
		function routeList(result){
			$('#routeList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'SNo'	        ,data:"id",
				          "render": function (data, type, row, meta) {  return meta.row + meta.settings._iDisplayStart + 1; },
					 },
					 { title:	'School Reg.No.',data:"regNo"},
					 { title:	'Route '        ,data:"routeName"},  
					 { title:	'Description'   ,data:"routeDescription"},
 		    		 { title:	''	            ,data:'idNo'/*'idno idNO*/,
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xRMtRoute"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" ><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF 	


		$(document).on('click', "Button[name='xRMtRoute']", function(){ 
			var ItemCode=$(this).val();
			var request =$.ajax({
/* 				type:'POST',data:{Action:"xRMtrRoute", Code:ItemCode},
			 	dataType: 'Json',url:'../../RouteInfo',	success:function(result){routeList(result);}	
 */
				type:'PUT',
				data:{id : ItemCode},
			 	dataType: 'Json',
//	     		url:'http://localhost:8088/smsi/route/routeInfoChk?id='+ItemCode,				
	     		url:'http://localhost:8088/smsi/transportInfo/RouteInfo?id='+ItemCode,				
				success:function(result){
					document.getElementById("xSTVehicleRoute").innerHTML = result.message;
				}

			});
	   	});// name='XrFaculty
	});// eof of document

	
	</script>
</html>















