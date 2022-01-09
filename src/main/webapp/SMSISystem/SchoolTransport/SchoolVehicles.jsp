<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	</head>
	<body >
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="txnVehicleInfoz" name="txnRouteInfo" action="" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white " id="headingOne" 
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.VEHICLE%> <%=SMFixedValue.INFORMATION%></a></li>
 									<li class="nav-item " >
										<button type="button" class="nav-link text-white" id="genXVehilceList"
									    	style="background-color: #000080"> <%=SMFixedValue.View%>  <%=SMFixedValue.VEHICLE%>
									    </button> </li>
 								</ul>

 							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row col-sm-12 offset-sm-0">
					<div class="col-sm-4 offset-sm-4">
						<p class="h5 text-center"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%>  <%=SMFixedValue.VEHICLE%> <%=SMFixedValue.INFORMATION%> 
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-1  form-group">
						    <label for="xtvRCode" class="h6"><%=SMFixedValue.VEHICLE%> <%=SMFixedValue.REGISTRATION_NO%> </label>
							<input type="text" class="form-control blineTl " id="xtvRCode" name="xtvRCode" required>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="xtVType" class="h6"><%=SMFixedValue.VEHICLE_TYPE%></label>
							<input type="text" class="form-control blineTl " id="xtVType" name="xtVType"  required>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="xtVEnginNo" class="h6"><%=SMFixedValue.ENGINE_NO%>  </label>
							<input type="text" class="form-control blineTl " id="xtVEnginNo" name="xtVEnginNo"  required>
						</div>
					</div>	
					<div class="row">		
						<div class="col-sm-2 offset-sm-1  form-group">
						    <label for="xtVModel" class="h6"><%=SMFixedValue.MODEL%> </label>
							<input type="text" class="form-control blineTl " id="xtVModel" name="xtVModel" required>
						</div>
						<div class="col-sm-2 offset-sm-0  form-group">
						    <label for="xtVColor" class="h6"><%=SMFixedValue.COLOR%> </label>
							<input type="text" class="form-control blineTl " id="xtVColor" name="xtVColor"  required>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="xtVMake" class="h6"><%=SMFixedValue.MAKE%> </label>
							<input type="text" class="form-control blineTl " id="xtVMake" name="xtVMake"  required>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
 						    <label for="routeVehicle" class ="h6"><%=SMFixedValue.ORIGIN_COUNTRY%></label>
 							<select id="OCountry" name="OCountry" 	class="form-control  blineTl" required>
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.COUNTRY%>*</option>
							</select>
						</div>
					</div>	
					<div class="row">
				   		<div class="col-sm-10 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="row" id="vehInfoAction01">
						<div class="col-sm-5 offset-sm-1 ">
				  			<p id="xSPDSVehicle" class="h6 text-danger"> </p>
				  		</div>
						<div class="col-sm-1 offset-sm-3 ">
							<input type = "button" id ="xtNRVRest" name="xtNRVRest"  
								   value="Reset" class="form-control text-light text-center h5 btn" 
								   style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"	>
						</div>
						<div class="col-sm-1 offset-sm-0 ">
							<input type="button" id="xtNRVehicle" value="Add" class="form-control text-light text-center h5 btn"
								   style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"	>
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="sMVehicleList" 	class="table table-striped table-hover compact row-border"
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
		var oCountry=" ";
		$("#genXVehilceList").click(function(){
			regCode='MK308';
			var request =$.ajax({
				type:'GET',
				data:{},
			 	dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/Vehicles?regNum='+regCode,	
				success:function(result){
					$.each(result, function(id, data){
						sMVehicleList(result.data);
						document.getElementById("xSPDSVehicle").innerHTML = "";
					});
				}	
			});	 // eof AJAX
		});
		$("#OCountry").click(function(){
			if (oCountry!=" "){	return;}
			var request =$.ajax({
				type:'GET',
				data:{},
			 	dataType: 'Json',
				url:'http://localhost:8088/smsi/transportInfo/country',	
				success:function(result){
					oCountry+=" <option selected value=0>Choose Country *</option>";
					$.each(result.data, function(id, countries){
						$.each(countries, function(id, name){
							oCountry+=" <option value='"+name.name +"'>"+name.name+"</option>";
						});
						$("#OCountry").html(oCountry);
					});
				}	
			});	 // eof AJAX
		});
		$(document).on('click', "Button[name='xRMSVehicle']", function(){ 
			var ItemCode = $(this).val();
			var request =$.ajax({
				type:'PUT',
				data:{vNo : ItemCode},
			 	dataType: 'Json',
			 	url:'http://localhost:8088/smsi/transportInfo/UPVehicles?vNo='+ItemCode,
				success:function(result){
					sMVehicleList(result.data);
					document.getElementById("xSPDSVehicle").innerHTML = result.message;
				}
			});
	   	});// name='XrFaculty
 		function sMVehicleList(results){
 			$('#sMVehicleList').dataTable({
			    destroy: true,
				"data":results,
				 columnDefs: [ {targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
 					 { title:	'School Reg No.',data:"regNo"},
					 { title:	'Vehicle No'    ,data:"vehNo"},  
					 { title:	'Vehicle Type'  ,data:"vehType"},
					 { title:	'Chassis No'    ,data:"vehChassisNo"},
					 { title:	'Model'         ,data:"vehModel"},  
					 { title:	'Make'          ,data:"vehMake"},
					 { title:	'color'         ,data:"vehColor"},
					 { title:	'Org.Country'   ,data:"vehOCountry"},
		    		 { title:	'Action'	    ,data:"idNo",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xRMSVehicle"  value="'+data+'" class="btn btn-danger btn-sm text-center"	data-toggle="tooltip" data-placement="" title="Click to remove item" ><span>&#9988;</span></button>'; 
			        	},
			        }
			    ]
			}); // EOF table
		}// EOF table FUNCTION	
		$("#xtNRVehicle").click(function(){
			if (validateSVInputValues()){
				initSubmitButton();	
				var request =$.ajax({
					type:'POST',
					headers: { 'Content-Type':'application/json'},				

					data:JSON.stringify({"vehNo":$("#xtvRCode").val(),  "vehType":$("#xtVType").val(),
	 					                 "vehChassisNo"  :$("#xtVEnginNo").val(), "vehMake"     :$("#xtVMake").val(),
	 					                 "vehModel": $("#xtVModel").val(), "vehColor": $("#xtVColor").val(),
	 					                 "vehOCountry" : $("#OCountry").val()}),
			    	dataType: 'JSON',
	 	     		url:'http://localhost:8088/smsi/transportInfo/CRVehicles',
					success:function(result){
						document.getElementById("xSPDSVehicle").innerHTML = result.message;
						sMVehicleList(result.data);
					}
				});	
			}
		});	 
		$("#xtNRVRest").click(function(){ 
			resetSubmitButton();
		});  	

		function initSubmitButton(){
			$("#xtNRVehicle").prop('disabled', true);	
			$("#xtNRVehicle").val("Add");		
		}
		function resetSubmitButton(){
			$("#xtNRVehicle").prop('disabled', false);			
			$("#xtvRCode").val('');
			$("#xtVType").val('');
			$("#xtVEnginNo").val('');
			$("#xtVMake").val('');
            $("#xtVModel").val('');
            $("#xtVColor").val('');
		}
		function validateSVInputValues(){
			if($("#xtvRCode").val()=="") {
				alert("Invalid Registration Number.");
				return false;
			}else if($("#xtVType").val()=="") {
				alert("Invalid Vehicle Type.");
				return false;
			}else if($("#xtVEnginNo").val()=="") {
				alert("Invalid Chassis Number");
				return false;
			}else if($("#xtVMake").val()=="" ){
				alert("Invalid Vehilce Make");
				return false;
			}else if($("#xtVModel").val()==""){
				alert("Invalid Vehilce Model");
				return false;
			}else if($("#xtVColor").val()==""){
				alert("Invalid Vehilce Color");
				return false;
			}
			return true;
		}		
	});// eof of document
	</script>
</html>
