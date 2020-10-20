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
										style="background-color: #000080" href="#"><%=Information.RWA%> <%=Information.Config%> <%=Information.Info%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-1 form-group">
						    <label for="prefix">Select Item Name</label>
							<select id="SetValueType" name="SetValueType" 	class="form-control in-valid" required style="border-bottom: 1px solid blue;">
								<option selected value ="0">Select Name*</option>
							</select>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="prefix">Prifix Value</label>
							<input type="text" class="form-control blinebl " id="prefix" name="prefix" 
							placeholder="Prefix value to combine with start Number*" required>

						</div>
						<div class="col-lg-3 offset-sm-0 - form-group">
						    <label for="prefix">Starting Value</label>
							<input type="text" class="form-control  " id="StartValue" 	name="StartValue" placeholder="Purchase Order Starting Number*" required
								   style="border-bottom: 1px solid blue;"  pattern="[0-9]"
							       title="Enter Purchase Order Starting Number">
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
						<div class="col-sm-2 offset-sm-4 ">
							<button type = "button" id ="cfAdd" name="cfAdd"  class="form-control text-light text-center h5 btn"
							 style="background-color: #00000f"><%=Information.Add%><%=Information.Config%></button>
						</div>
						<div class="col-sm-2">
							<button type = "button" id ="ViewRCS" name="ViewRCS"  class="form-control text-light text-center h5 btn"
							 style="background-color: #00000f"><%=Information.View%><%=Information.Config%> </button>
						</div>
					</div>
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="rcList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	

			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">

	
	$(document).ready(function(){
		$("#ViewRCS").click(function(){
			var request =$.ajax({
				type:'POST',
				data:{Action:"ivView"},
			 	dataType: 'Json',
				url:'../ConfigInfo',
				success:function(result){
					rcList(result);
				}	
			});	 // eof AJAX
		});
		$("#cfAdd").click(function(){
			var valueType  = $("#SetValueType").val();
			var startValue = $("#StartValue").val();
			var prefix  = $("#prefix").val();
			alert(valueType + ":" + startValue + ":" + prefix);
			if(rcValidForm(valueType, startValue , prefix)){
				cfgdata(valueType, startValue , prefix);
			}
		});
		function rcValidForm(valueType, startValue , prefix){
			alert("rcValidForm");
			if(valueType==0){
				$("#SetValueType").focusin();
				alert("Value type  can't be blank");
				return false;
			}else if(prefix==0){
				$("#prefix").focusin();
				alert("Prefix can't be blank");
				return false;
			}else if(startValue==0){
				$("#StartValue").focusin();
				alert("Start Vlaue can't be blank");
				return false;
			}
			$("#SetValueType").val("Select Name");
			$("#StartValue").val("");
			$("#prefix").val("");
			return true;
		}
		function cfgdata(valueType, startValue , prefix){
			var request =$.ajax({
				type:'POST',
				data:{Action:"1", vType:valueType, sValue:startValue, pfix:prefix},
			 	dataType: 'Json',
				url:'../ConfigInfo',
				success:function(result){
					rcList(result);
				}	
			});	 // eof AJAX
		}// eof ValidateUserEmail()	
		function rcList(result){
			$('#rcList').dataTable({
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
					 { title:	'Name'      ,data:"NameType"},  
					 { title:	'PreFix'    ,data:"PrefixStartNo"},
					 { title:	'Start No'	,data:"StartNo"}, 
					 { title:	'Last No'	,data:"LastNo"}, 
					 { title:	'Edit'	    ,data:"NameType",
					 	"render": function(data,type,row,meta){
		    			 	return	'<button type="button" name="ivEdit"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
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

	   $(document).on('click', "Button[name='ivEdit']", function(){ 
			var NameType=$(this).val();
			var request =$.ajax({
	   			type:'POST',
	   			data:{Name:NameType , Action:"ivEDIT"},
	   		    dataType: 'json',
	   			url:'../ConfigInfo',
	   			success:function(result){
					$.each(result, function(id, name){
						$('#StartValue').val(name.StartNo);
						$('#prefix').val(name.PrefixStartNo);
						$('#SetValueType').val(name.NameType);
					});
	   			}	
			});// EOF $.Ajax()
	   	});// EOF RCIVEDIT item
	});
	</script>
</html>


