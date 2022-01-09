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
					<div class="col-sm-4 offset-sm-4">
						<p class="h5 text-center"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.ROUTE%> <%=SMFixedValue.PICKUP_DROP_POINT%>  
						<div id ="xPDPStatus"> </div>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-1  form-group">
   						    <label for="XRouteName" class ="h6"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%>* 
								[<a href="http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/TransportRoute.jsp" target="popup" rel="noopener noreferrer"
								onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/TransportRoute.jsp','Create New Trasnport Route','width=800,height=425, Top=100, left=250')">
								<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%></span></a>]</label>

							<select id="XRouteName" name="XRouteName" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%> *</option>
							</select>
 						</div>
						<div class="col-sm-5 offset-sm-0  form-group">
  						    <label for="xtRType" class ="h6"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.Type%>*</label>
 							<select id="xtRType" name="xtRType" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Type%> *</option>
								<option  value ="PP">Pickup Point</option>
								<option  value ="DP">Drop Point</option>
							</select>
						</div>
					</div>	
				</div>
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="bg-light ">
 							<div class="row" >		
<%-- 								<div class="col-sm-2 offset-sm-1  form-group" Style="padding-left:-10px">
								    <label class ="h6" for="xpSNo"><%=SMFixedValue.SNO%>* </label>
									<input type="text" class="form-control blineTl " id="xpSNo" name="xpSNo" required>
								</div>
 --%>
 								<div class="col-sm-4 offset-sm-1  form-group">
								    <label class ="h6" for="xpTRName"><%=SMFixedValue.PICKUP_DROP_POINT%>* </label>
									<input type="text" class="form-control blineTl " id="xpTRName" name="xpTRName"  required>
								</div>
								<div class="col-sm-2 offset-sm-0  form-group">
								    <label class ="h6"  for="CSTime"><%=SMFixedValue.PICKUP_TIME%>* </label>
									<input type="text" class="form-control blineTl " id="CSTime" name="CSTime"  required >;
								</div>
								<div class="col-sm-1 offset-sm-2 ">
								    <label class ="h6"  for=""></label>
									<button type = "button" id ="xtNRoutePD" name="xtNRoutePD"  class="form-control text-light text-center h6 btn"
									 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
									 <%=SMFixedValue.SAVE%> </button>
								</div>
								<div class="col-sm-1 offset-sm-0 ">
								    <label class ="h6"  for=""></label>
									<button type = "button" id ="xtNRouteReset" name="xtNRouteReset"  class="form-control text-light text-center h6 btn"
									 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
									 <%=SMFixedValue.RESET%> </button>
								</div>

							</div>	
							<div class="row">
						   		<div class="col-sm-10 text-center offset-sm-2">
						    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
										<%session.removeAttribute("Message");%>
						    		</div>
					  		</div>
 						</div>
					</div>
 					<br />
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-5 offset-sm-0" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="routeList" 	class="table table-striped table-hover compact row-border"
						 	style="width:100%; font-size:14px"></table>
						</div>
					</div>
					<div class="col-sm-6 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="PickUpDropList" 	class="table table-striped table-hover compact row-border"
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

		$("#CSTime").datetimepicker({
			timepicker: true,
			datepicker: false,
			format: 'h:i', // formateTime
			value:  false, //visitTime() defaultTime
			hours12: true,
			step: 5	
		});
/* 		$("#tRouteVLX").click(function(){
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
 */
		$("#tRouteVLX").click(function(){
//			url:'http://localhost:8088/smsi/route/getTransportRoutes',
			var request =$.ajax({
				type:'GET',
				data:{},
				dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/RouteInfo?regNo=MK308',
				success:function(result){
					routeList(result.data);
					document.getElementById("xSTVehicleRoute").innerHTML = "";
				}	
			});	 // eof tRouteVLX

		});
 		$("#xtNRouteReset").click(function(){ 
			$("#xtNRouteReset").html("Reset");
			$("#xtNRoutePD").prop('disabled', false);
			resetPKDPRData();
		});
		function resetPKDPRData(){
			$("#xpTRName").val("") ;
			$("#CSTime").val("") ;
		}
		function savebutton(){ 
			$("#xtNRoutePD").prop('disabled', true);
			$("#xtNRouteReset").html("Add");
		}
		
	/* 		$("#xtNRoutePD").click(function(){
			if(validatePKDPRroute(xrouteUpdata)){
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
						pPDList(result);
						resetPKDPRData();
						scrollPageUP(6000);
					}	
				});					
			}
		});
		function updatePKDRData(xrouteUpdata){ 
			xrouteUpdata.push($("#xtRCode").val()) ;
			xrouteUpdata.push($("#xtRType").val()) ;
			xrouteUpdata.push($("#xpSNo").val())   ;
			xrouteUpdata.push($("#xpTRName").val());
			xrouteUpdata.push($("#CSTime").val());
			return xrouteUpdata;
		}
*/
		$("#xtNRoutePD").click(function(){
			if(validatePKDPRroute()){
				savebutton();
				var rCode   = $("#XRouteName").val() ;
				var request =$.ajax({
					type:'PUT',
					headers: { 'Content-Type':'application/json'},				
					data:JSON.stringify({"id" : $("#XRouteName").val(), "pdpType" : $("#xtRType").val(), "routePDP" : $("#xpTRName").val(), "routePDPTime" : $("#CSTime").val() }),
				 	dataType: 'Json',
				 	url:'http://localhost:8088/smsi/transportInfo/NewRPD?id='+ rCode,
					success:function(result){
						document.getElementById("xPDPStatus").innerHTML = result.message;
						showPickupDropData(result.data);
						resetPKDPRData();
					}	
				});		
			}
		});
		function showPickupDropData(data){
			$.each(data, function(id, name){
				if(name.routePDP.length >0){
					pPDList(data);
				}
			});
		}
		
		function validatePKDPRroute(){
			if($("#XRouteName").val()==0){
				alert("Choose route");
				return false;
			}else if($("#xtRType").val()==0){
				alert("Choose Route Type[pickup / Drop]");
				return false;
			}else if($("#xpTRName").val()==""){
				$("#xpTRName").val("Invalid PickUp Point");
				return false;
			}else if($("#CSTime").val()==""){
				$("#CSTime").val("Invalid PickUp Time");
				return false;
			}
			return true;
		}
		function routeList(result){
			$('#routeList').dataTable({
				"destroy": true,
				"data":result,
				"columnDefs": [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'SNo'	        ,data:"id",
				          "render": function (data, type, row, meta) {  return meta.row + meta.settings._iDisplayStart + 1; },
					 },
					 { title:	'School Reg.No.',data:"regNo"},
					 { title:	'Route '        ,data:"routeName"},  
					 { title:	'Description'   ,data:"routeDescription"},
 		    		 { title:	'PP'	        ,data:'idNo'/*'idno*/,
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xVTRPP"  value="'+data+'" class="btn btn-warning btn-sm"	data-toggle="tooltip" data-placement="right" title="View Pickup Points" ><span>&#10010;</span></button>'; 
			        	},
			        },
 				 	{ title:	'DP'	       ,data:"idNo",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xVTRDP"  value="'+data+'" class="btn btn-success btn-sm"	data-toggle="tooltip" data-placement="right" title="view Drop Points" ><span>&#10010;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF 
/* 			
		function pickUpDropList(result){
			$('#routeList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'SNo'	           ,data:"SNO"},
					 { title:	'School Reg No.'   ,data:"RegNo"},
					 { title:	'Route Name'       ,data:"Route"},  
					 { title:	'Description'      ,data:"RouteDesc"},
					 { title:	'PDP SNo'	       ,data:"PDPSNO"},
					 { title:	'Pickup/Drop Point',data:"PDPoint"},
					 { title:	'PickUp/Drop'      ,data:"PDType"},  
					 { title:	'Time'             ,data:"PDTime"},
		    		 { title:	'Action'	       ,data:"RTPD",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xRmPDPInfoX"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	

		$(document).on('click', "Button[name='xRIPdpInfoX']", function(){ 
			var ItemCode=$(this).val();
			var request =$.ajax({
				type:'POST',
				data:{Action:"xRIPdpInfoX", Code : ItemCode},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					pPDList(result);
				}	
			});
	   	});// name='XrFaculty
		$(document).on('click', "Button[name='xRmPDPInfoX']", function(){ 
			var ItemCode=$(this).val();
			resetPKDPRData();
			var request =$.ajax({
				type:'POST',
				data:{Action:"xRmPDPInfoX", Code : ItemCode},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					
					pPDList(result);
				}	
			});
	   	});// name='XrFaculty


 	   	function pPDList(result){
			$('#PickUpDropList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'PDP SNo'	       ,data:"PDPSNO"},
					 { title:	'Pickup/Drop Point',data:"PDPoint"},
					 { title:	'PickUp/Drop'      ,data:"PDType"},  
					 { title:	'Time'             ,data:"PDTime"},
		    		 { title:	'Action'	       ,data:"RTPD",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xRmPDPInfoX"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	
 */
  	   	function pPDList(pdpData){
			$('#PickUpDropList').dataTable({
			    "destroy": true,
				"data":pdpData,
				"columnDefs": [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
 					 { title:	'SNo'	        ,data:"id",
				          "render": function (data, type, row, meta) {  return meta.row + meta.settings._iDisplayStart + 1; },
					 },
 					 { title:	'Pickup/Drop Point',data:"routePDP"},
					 { title:	'PP[PickUp],DP[Drop]',data:"pdpType"},  
					 { title:	'Time'             ,data:"routePDPTime"},
		    		 { title:	'Action'	       ,data:"rid" ,
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xRmPDPInfoX"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" ><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	 

 /* 		$(document).on('click', "Button[name='xRMtRoute']", function(){ 
			var ItemCode=$(this).val();
			 alert("onclick :" + ItemCode);
			var request =$.ajax({
				type:'POST',
				data:{Action:"xRMtrRoute", Code:ItemCode},
			 	dataType: 'Json',
				url:'../../RouteInfo',
				success:function(result){
					routeList(result);
				}	
			});
	   	});// name='XrFaculty
 */
	 	$(document).on('click', "Button[name='xVTRPP']", function(){ 
			var routeId=$(this).val();
			var request =$.ajax({
				type:'GET',	data:{},dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId+"&spd=PP",
				success:function(result){
/* 					$.each(result.data, function(id, name){
						if(name.routePDP.length >0){
							pPDList(result.data);
						}
					});
 */
 					showPickupDropData(result.data);
				}	
			});	 
		});// name='xVTRPP
	 	$(document).on('click', "Button[name='xVTRDP']", function(){ 
			var routeId=$(this).val();
			var request =$.ajax({
				type:'GET',	data:{},dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId+"&spd=DP",
				success:function(result){
/* 					$.each(result.data, function(id, name){
						if(name.routePDP.length >0){
							pPDList(result.data);
						}
					});
 */
					showPickupDropData(result.data);
				}	
			});	 
	   	});// name='xVTRDP	   	

	 	$(document).on('click', "Button[name='xRmPDPInfoX']", function(){ 
			var idr=$(this).val();
			var pos = idr.indexOf("/");
			var	rPDP = idr.substr(pos+1);
			var code = idr.substr(0,pos);
 			var request =$.ajax({
				type:'PUT',	data:{},dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/UpdateRPD?iDNo='+code +'&rPDid='+rPDP,
				success:function(result){
					pPDList(result.data);
				}	
			});	 
	   	});// name='xVTRDP	   	
		$("#XRouteName").click(function(){
			if (xRouteName!=""){	return;	}
			xRouteName="";
			var request =$.ajax({
				type:'GET',
				data:{},
			 	dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/RouteInfo?regNo=MK308',
				success:function(result){
					console.log(result.data);
					xRouteName+=" <option selected value=0>Choose Transport Route*</option>";
					$.each(result.data, function(id, name){
						xRouteName+=" <option value='"+name.idNo +"'>"+ name.routeName +" --> "+name.routeDescription+ "</option>";
					});
					$("#XRouteName").html(xRouteName);
				}	
				
			});	
		}); 

	   	
	});// eof of document

	
	</script>
</html>















