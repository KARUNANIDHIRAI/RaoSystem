<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
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
<!-- 	<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script> -->
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
<!-- 	<link rel="stylesheet" href="../../css/custom.css" type="text/css"> -->
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
<!--   	<script type="text/javascript" src="../../js/CommonFunc.js"></script> -->
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
		<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
	</head>
	<body >
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
<!-- 			<form id="subInfo" name="subInfo" action="../../PickupDropInfo?Action=xtNRoutePDInfo" method="post" class="form-horizontal needs-validation" autocomplete="off"> -->
			<form id="subInfo" name="subInfo" action="#" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
						<p class="h5 text-center"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> 
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-4 offset-sm-0  form-group">
   						    <label for="routeNo" class ="h6"><%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%>* 
								[<a href="#" target="popup" rel="noopener noreferrer"
								onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/TransportRoute.jsp','Create New Trasnport Route','width=800,height=425, Top=100, left=250')">
								<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%></span></a>]</label>
 							<select id="routeNo" name="routeNo" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%> *</option>
							</select>
						</div>
 						<div class="col-sm-4 offset-sm-0  form-group">
  						    <label for="pickId" class ="h6"><%=SMFixedValue.PICKUP_POINT%>*
								[<a href="http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp" target="popup" rel="noopener noreferrer"
								onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp','Create New Pickup & Drop','width=950,height=450, Top=100, left=250')">
								<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.PICKUP_POINT%> </span></a>]</label>
 							<select id="pickId" name="pickId" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.PICKUP_DROP_TIME%>*</option>
							</select>
						</div>
 						<div class="col-sm-4 offset-sm-0  form-group">
  						    <label for="dropId" class ="h6"><%=SMFixedValue.DROP_POINT%>*
								[<a href="http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp" target="popup" rel="noopener noreferrer"
								onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/PickupDropRoute.jsp','Create New Pickup & Drop','width=950,height=450, Top=100, left=250')">
								<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.DROP_POINT%> </span></a>]</label>
 							<select id="dropId" name="dropId" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.PICKUP_DROP_TIME%>*</option>
							</select>
						</div>
 					</div>	
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-3 text-center offset-sm-3">
							<p class="text-danger"><%=session.getAttribute("Message") == null ? "" : session.getAttribute("Message")%></p>
							<%session.removeAttribute("Message");%>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-4 offset-sm-0  form-group">
 						    <label for="vehId" class ="h6"><%=SMFixedValue.ROUTE_VEHICLE%>*
								[<a href="http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/SchoolBusRoute.jsp" target="popup" rel="noopener noreferrer"
								onclick="window.open('http://localhost:8085/RAOSystem/SMSISystem/SchoolTransport/SchoolBusRoute.jsp','Create New Route Bus','width=950,height=450, Top=100, left=250')">
								<span style="font-size:11px;" class="h6"><%=SMFixedValue.CREATE%>  <%=SMFixedValue.New%>  <%=SMFixedValue.DROP_POINT%> </span></a>]</label>
 							<select id="vehId" name="vehId" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.ROUTE_VEHICLE%>*</option>
							</select>
						</div>

						<div class="col-sm-2 offset-sm-0  form-group">
							<label for="SSClass" class="h6 "><%=SMFixedValue.CLASS%></label> 
							<select id="SSClass" name="SSClass" class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Class%>*</option>
							</select>
						</div>
						<div class="col-sm-2 offset-sm-0  form-group">
							<label for="Ssection" class="h6 "><%=SMFixedValue.Section%></label>
							<select id="Ssection" name="Ssection" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.TRANSPORT%> <%=SMFixedValue.ROUTE%> <%=SMFixedValue.Name%> *</option>
							</select>
						</div>
						<div class="col-sm-2 offset-sm-0 ">
						    <label class ="h6"  for=""></label>
							<button type = "button" id ="xtNRoutePD" name="xtNRoutePD"  class="form-control text-light text-center h6 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.View%> <%=SMFixedValue.STUDENT%><%=SMFixedValue.ACTION_LIST%></button>
						</div>
						<div class="col-sm-2 offset-sm-0 ">
							<label class ="h6"  for=""></label>
							<button type = "button" id ="xSPDPInfoCX" name="xSPDPInfoCX"  class="form-control text-light text-center h6 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.SAVE%> </button>
						</div>
					</div>	
 				</div>	
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="studentList" 	class="table table-striped table-hover compact row-border"
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
 		var vehId = "";
 		var vehicleList=" ";
 		var routeNo="";
 		var pickId= "";
 		var dropId = "";
		$(document).ready(function(){
			$("#xSPDPInfoCX").click(function(){
			    var x = $("form").serializeArray();

/* 			    alert(JSON.stringify(x));
		        var myObj = [];	
		        $.each(x, function (i, v) {
			        var nm = v.name +":"+ v.value;
		        	myObj.push[nm] ;
		        });
	            var studentsInfo = [];
	            $.each($("input[name='XsPDPChecked']:checked"), function(){
	            	studentsInfo.push({"XsPDPChecked" : $(this).val()});
	            });

		        alert("myObj" + myObj);
		        var formdata=JSON.stringify(myObj);
		        alert("formdata" + formdata);
 */
		        var request =$.ajax({
					type:'POST',
					headers: { 'Content-Type':'application/json'},	
					data: JSON.stringify(x),
/* 							data: JSON.stringify({"regNo":"MK308","routeNo":$("#routeNo").val(),"pickId":$("#pickId").val(),
								 "dropId":$("#dropId").val(),"vehId":$("#vehId").val(),
								 "stdClass": $("#SSClass").val(), "stdSection":$("#Ssection").val(),
								  "XsPDPChecked":$("#XsPDPChecked").val() }),
 */
 				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/transportInfo/CRSPD',
					success:function(result){
						xXShowStudentInfoList(result);
					}	
				});	 
			});
			
			$("#xSPDPInfoCX").prop('disabled', false);
			$("#xtNRoutePD").click(function(){
				if(validatePKDPRroute()){ 
					var request =$.ajax({
						type:'POST',
						
						data:{Action:"xRScsInfox", xZClass: $("#SSClass").val(), xZSecion:$("#Ssection").val() },
					 	dataType: 'Json',
						url:'../../StudentPInformation',
						success:function(result){
							xXShowStudentInfoList(result);
						}	
					});	 // eof AJAX
				}
			});

			function validatePKDPRroute(){
				if($("#routeNo").val()==0){
					alert("Choose route");
					return false;
				}else if($("#xtRType").val()==0){
					alert("Choose Route Type[pickup / Drop]");
					return false;
				}else if($("#SSClass").val()==0){
					alert("Choose Student Class");
					return false;
				}else if($("#Ssection").val()==0){
					alert("Choose Student Section");
					return false;
				}else if($("#Ssection").val()==0){
					alert("Choose Student Section");
					return false;
				}else if($("#xSPDP").val()==0){
					alert("Choose Student Pickup / Drop");
					return false;
				}
				
				return true;
			}
			
			$(document).on('click', "Button[name='xRmPDPInfoX']", function(){ 
				var ItemCode=$(this).val();
				resetPKDPRData();
				var request =$.ajax({
					type:'POST',
					data:{Action:"xRmPDPInfoX", Code : ItemCode},
				 	dataType: 'Json',
					url:'../../RouteInfo',
					success:function(result){
						xXShowStudentList(result);
					}	
				});
		   	});// name='XrFaculty
	
		   	function xXShowStudentInfoList(result){
				$('#studentList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
				    "columns": [
		 		    	 { title:	'SNo'	   ,data:"SNO"},
				    	 { title:	'RegNo'	   ,data:"RegNo"},
						 { title:	'Adm.No.'  ,data:"AdmNo"},
						 { title:	'Name'     ,data:"Name"},  
						 { title:	'Roll No.' ,data:"RollNo"},
						 { title:	'Class'    ,data:"Class"},  
						 { title:	'Section'  ,data:"Section"},
 			    		 { title:	'Action' ,data:"SIDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<input type="checkbox" name="XsPDPChecked" align="left" value="'+data+'" class="bg-warning text-info" data-toggle="tooltip" data-placement="right" title="Click to Check Box assigned Pickup and Drop point" ><span> Pickup/Drop </span>'; 
				        		},
				        }
					]
				}); // EOF table
			}// EOF table FUNCTION	
			$(document).on('click', "input[name='XsPDPChecked']", function(){ 
				$("#xSPDPInfoCX").prop('disabled', false);
			});

			$("#vehId").click(function(){
				if (vehicleList!=" "){	return;}
				var regCode='MK308';
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
				 	url:'http://localhost:8088/smsi/transportInfo/Vehicles?regNum='+regCode,
					success:function(result){
						vehicleList+=" <option selected value=0>Choose Vehicle *</option>";
						$.each(result.data, function(id, name){
							vehicleList+=" <option value='"+name.idNo +"'>"+name.vehNo+" -->  "+name.vehType+"</option>";
						});
						$("#vehId").html(vehicleList);
					}	
				});	 // eof AJAX
			});
			
			
			$("#routeNo").click(function(){
				if (routeNo!=""){	return;	}
				routeNo="";
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/transportInfo/RouteInfo?regNo=MK308',
					success:function(result){
						routeNo+=" <option selected value=0>Choose Transport Route*</option>";
						$.each(result.data, function(id, name){
							routeNo+=" <option value='"+name.idNo +"'>"+ name.routeName +" --> "+name.routeDescription+ "</option>";
						});
						$("#routeNo").html(routeNo);
					}	
					
				});	
			}); 

 			$("#pickId").click(function(){
 	 			var routeId = $("#routeNo").val();
				if (pickId!=""){	return;	}
				pickId="";
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId+"&spd=PP",
					success:function(result){
						pickId+=" <option selected value=0>Choose Transport Route*</option>";
						$.each(result.data, function(id,name){ 
								pickId+=" <option value='"+name.rid +"'>"+ name.routePDP +" --> "+name.routePDPTime+ "</option>";
						});
						$("#pickId").html(pickId);
					}	
				});	
			});  
 			$("#dropId").click(function(){
 	 			var routeId = $("#routeNo").val();
				if (dropId!=""){	return;	}
				dropId="";
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/transportInfo/PickUpDrop?routeIdNo='+routeId+"&spd=DP",
					success:function(result){
						dropId+=" <option selected value=0>Choose Transport Route*</option>";
						$.each(result.data, function(id,name){ 
								dropId+=" <option value='"+name.rid +"'>"+ name.routePDP +" --> "+name.routePDPTime+ "</option>";
						});
						$("#dropId").html(dropId);
					}	
				});	
			});  
		});// eof of document
	</script>
</html>















