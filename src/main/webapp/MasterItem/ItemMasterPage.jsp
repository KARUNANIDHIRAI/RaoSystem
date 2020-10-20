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
		<div class="container">
			<form id="rcInfo" name="rcInfo" action="../ConfigInfo?Action=1" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white " id="headingOne" 
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.New%> <%=Information.Item%> <%=Information.Info%></a></li>
									<li class="nav-item "><button type="button" class="nav-link text-white" id="ViewItem"
									    style="background-color: #000080">
										<%=Information.View%> <%=Information.Item%> <%=Information.Info%>
									</button> </li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-3 offset-sm-2  form-group">
						    <label for="ICode">Item Code</label>
							<input type="text" class="form-control blinebl " id="ICode" name="ICode" required>

						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="IName">Item Name</label>
							<input type="text" class="form-control blinebl " id="IName" name="IName"  required>

						</div>
					</div>	
					<div class= "row">
						<div class="col-sm-3 offset-sm-2 form-group">
							<label for="MinLevel">Min Level</label>
							<input type="text" class="form-control blinebl " id="MinLevel" name="MinLevel"  required>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
							<label for="MxLevel">Max Level</label>
							<input type="text" class="form-control blinebl " id="MxLevel" name="MxLevel" required>
						</div>
						<div class="col-lg-3 offset-sm-0  form-group">
					    	<label for="RLevel">Reorder Level</label>
							<input type="text" class="form-control  " id="RLevel" 	name="RLevel" required
						   style="border-bottom: 1px solid blue;"  pattern="[0-9]"  title="Enter Purchase Order Starting Number">
						</div>
						</div>
					<br />
					<div class="row">
				   		<div class="col-sm-10 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
							<button type = "button" id ="itmAdd" name="itmAdd"  class="form-control text-light text-center h5 btn"
							 style="background-color: #00000f"><%=Information.Add%><%=Information.Item%></button>
						</div>
<%-- 						<div class="col-sm-2">
							<button type = "button" id ="ViewItems" name="ViewItems"  class="form-control text-light text-center h5 btn"
							 style="background-color: #00000f"><%=Information.View%><%=Information.Item%> </button>
						</div>
 --%>					</div>
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="nwItm" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	

			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#ViewItem").click(function(){
			var request =$.ajax({
				type:'POST',
				data:{Action:"View"},
			 	dataType: 'Json',
				url:'../ItemMainInfo',
				success:function(result){
					itmList(result);
				}	
			});	 // eof AJAX
		});

		$("#itmAdd").click(function(){
			var ItemCode  = $("#ICode").val();
			var ItemName = $("#IName").val();
			var MLevel  = $("#MinLevel").val();
			var MxLevel = $("#MxLevel").val();
			var ReLevel  = $("#RLevel").val();
			if(itemValid(ItemCode, ItemName , MLevel,MxLevel, ReLevel )){
				addItem(ItemCode, ItemName , MLevel,MxLevel, ReLevel);
			}
		});
		function itemValid(ItemCode, ItemName , MLevel,MxLevel, ReLevel ){
			alert("itemValid");
			if(ItemCode==0){
				$("#ICode").focusin();
				alert("Item Code can't be blank");
				return false;
			}else if(ItemName==0){
				$("#IName").focusin();
				alert("ItemName can't be blank");
				return false;
			}else if(MLevel==0){
				$("#MinLevel").focusin();
				alert("Min Level can't be blank");
				return false;
			}else if(MxLevel==0){
				$("#MxLevel").focusin();
				alert("Max Level can't be blank");
				return false;
			}else if(ReLevel==0){
				$("#RLevel").focusin();
				alert("Reorder  Level can't be blank");
				return false;
			}
				
			$("#ItemCode").val("");
			$("#IName").val("");
			$("#MinLevel").val("");
			$("#MxLevel").val("");
			$("#RLevel").val("");
			return true;
		}
		function addItem(ItemCode, ItemName , MLevel,MxLevel, ReLevel){
			alert("addItem");
			var request =$.ajax({
				type:'POST',
				data:{Action:"AddItem", ItmCode:ItemCode, ItmName:ItemName, MinLevel:MLevel, MaxLevel:MxLevel ,RLevel:ReLevel},
			 	dataType: 'Json',
				url:'../ItemMainInfo',
				success:function(result){
					alert("result" +result);
					itmList(result);
				}	
			});	 // eof AJAX
		}// eof ValidateUserEmail()	
		
		function itmList(result){
			$('#nwItm').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [
					 {	targets: -1, 
						className: 'dt-body-right'
					},
				 ],
			    "columns": [
					 { title:	'SNO'	    ,data:"SNO"},
					 { title:	'RwaRegNo'  ,data:"RwaNo"},
					 { title:	'ItemCode'      ,data:"ItemCode"},  
					 { title:	'ItemName'    ,data:"ItemName"},
					 { title:	'MinLabel'	,data:"MinimumLevel"}, 
					 { title:	'MaxLabel'	,data:"MaxLevel"}, 
					 { title:	'ReOrderLevel'	,data:"ReorderLevel"}, 
					 { title:	'Edit'	    ,data:"ItemCode",
					 	"render": function(data,type,row,meta){
		    			 	return	'<button type="button" name="itmEdit"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
		    		 	},
		    		 },
		    		 { title:	'Del'		  ,data:"NameType",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="ivDEL"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	

	   $(document).on('click', "Button[name='itmEdit']", function(){ 
			var ItemCode  = $("#ICode").val();
			 ItemCode=$(this).val();
			   alert("onclick");
			var request =$.ajax({
	   			type:'POST',
	   			data:{ItCode:ItemCode , Action:"itmEDIT"},
	   		    dataType: 'json',
	   			url:'../ItemMainInfo',
	   			success:function(result){
					$.each(result, function(id, name){
						$("#ICode").val(name.ItemCode);
						$("#IName").val(name.ItemName);
						$("#MinLevel").val(name.MinimumLevel);
						$("#MxLevel").val(name.MaxLevel);
						$("#RLevel").val(name.ReorderLevel);
					});
	   			}	
			});// EOF $.Ajax()
	   	});// EOF RCIVEDIT item
				

	});
	</script>
</html>


