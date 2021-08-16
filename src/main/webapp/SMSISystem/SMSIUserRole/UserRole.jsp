
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>

		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

		<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
		<link rel="stylesheet" href="../../css/custom.css" type="text/css">
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
<!-- 	<script type="text/javascript" src="../../js/CommonFunc.js"></script> -->
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container">
			<form id="xURLINFOX10" name="xURLINFOX10" action="../URBAccessInfo.java?Action=NewUser" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.USER%> <%=SMFixedValue.LOGIN%> </a></li>
									<li class="nav-item " id="iX3UserRoleGroup"><a class="nav-link text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.View%> <%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%> <%=SMFixedValue.Summary%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row col-sm-12 offset-sm-0">
					<div class="col-sm-4 offset-sm-4">
						<p class="h5 text-center"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.USER%> 
						<%=SMFixedValue.ROLE%> </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-2  form-group">
						    <label for="RwaNo"><%=SMFixedValue.RegNo%></label>
							<input type="text" class="form-control blineTl " id="RwaNo" name="RwaNo" readonly>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="xUrGType"><%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%></label>
							<input type="text" class="form-control blineTl " id="xUrGType" name="xUrGType"  required>
						</div>
					</div>	
					<div class="row">
				   		<div class="col-sm-10 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
							<button type = "button" id ="XNxUrType10" name="XNxurType10"  class="form-control text-light text-center h5 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.Action%> <%=SMFixedValue.New%> <%=SMFixedValue.ROLE%></button>
						</div>
					</div>
						<br />
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-8 offset-sm-2 table-responsive" >  <!--  showing data into table -->
							<table id="xUserRoleLGroups" 	class="table table-striped table-hover compact row-border"
						 	style="width:100%; font-size:14px"></table>
					</div>
				</div>	
			</form>
			<br /> <br /><br /><br />	<br /> <br />	<br />		
		</div>	
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#iX3UserRoleGroup").click(function(){
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"iX3UserRolelist", registrationNumber :  $("#RwaNo").val()},
				 	dataType: 'Json',
					url:'../../URBAccessInfo',
					success:function(result){
						xUserRoleGroupList(result);
						scrollPageUP(6000);
					}	
				});	
			});
			function xUserRoleGroupList(result){
				$('#xUserRoleLGroups').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {targets: -1, className: 'dt-body-right'	}, ],
				    "columns": [
						 { title:	'SNO'	    ,data:"SNO"}         ,
						 { title:	'Reg No'    ,data:"Registration"},
						 { title:	'User Role' ,data:"Role"}        ,  
						 { title:	'Action'	,data:"uRoleId"      ,
						 	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xURLGRem1X"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			    		 	},
			    		 }
			    	]
				}); // EOF table
			}// EOF table FUNCTION	
		   $(document).on('click', "Button[name='xURLGRem1X']", function(){ 
				var ItemCode=$(this).val();
				var request =$.ajax({
					type:'POST',
					data:{Action:"xURLGR1xMe", iDURL:ItemCode},
				 	dataType: 'Json',
					url:'../../URBAccessInfo',
					success:function(result){
						xUserRoleGroupList(result);
					}	
				});
		   	});// name='XrFaculty
			$("#XNxUrType10").click(function(){
				var ItemCode  = $("#xUrGType").val();
				if(validateFaculty(ItemCode)){
					xNuRLGruoup(ItemCode);
				}
			});
			function validateFaculty(ItemCode){
				if(ItemCode==""){
					$("#xUrGType").val("User Role can't be blank");
					$("#xUrGType").focusin();
					return false;
				}
				$("#xUrGType").val("");
				return true;
			}
			function xNuRLGruoup(ItemCode){
				var request =$.ajax({
					type:'POST',
					data:{Action:"xNuRLGruoup", xUrgRole : ItemCode, registrationNumber :  $("#RwaNo").val()},
				 	dataType: 'Json',
					url:'../../URBAccessInfo',
					success:function(result){
 						$.each(result, function(id, name){
							if(name.SNO=="Duplicate"){ 
								$("#xUrGType").val("User Role Alaready Exist");
							}else{ xUserRoleGroupList(result);	} 
						});
 					}	
				});		
			} // eof subject

		});// eof of document
	</script>
</html>
