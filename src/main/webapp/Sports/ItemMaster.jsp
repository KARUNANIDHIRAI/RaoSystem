<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		  	
			<link rel="stylesheet" href="../css/SMST.css" type="text/css">
			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
	</head>
	<body >
 		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
 		<div class="container">
			<form id="XsPORTiNFO" name="XsPORTiNFO" action="../ItemMaster?Action=xNritemInfo" method="post" class="form-horizontal needs-validation" autocomplete="off">
 				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white " id="headingOne" 
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.SPORTS%> <%=SMFixedValue.ITEM%> <%=SMFixedValue.Info%></a></li>
									<li class="nav-item " ><button type="button" class="nav-link text-white" id="xSprtItemInfo"
									    style="background-color: #000080">
										<%=SMFixedValue.View%> <%=SMFixedValue.ITEM%> <%=SMFixedValue.Info%></button> </li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row col-sm-12 offset-sm-0">
					<div class="col-sm-4 offset-sm-4">
						<p class="h5 text-center"><%=SMFixedValue.CREATE%> <%=SMFixedValue.SPORTS%> <%=SMFixedValue.ITEM%></p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="SportCategory" class ="h6 "><%=SMFixedValue.ITEM%> <%=SMFixedValue.CATEGORY%>* </label>
								<select id="SportCategory" name="SportCategory" 	class="form-control blineTl" required >
								<option selected value =""><%=SMFixedValue.Choose%> <%=SMFixedValue.SPORTS%> <%=SMFixedValue.CATEGORY%>*</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="sICode" class ="h6 "><%=SMFixedValue.ITEM%> <%=SMFixedValue.Code%></label>
							<input type="text" class="form-control blineTl " id="sICode" name="sICode" required>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="sIName" class ="h6 "><%=SMFixedValue.ITEM%> <%=SMFixedValue.Name%></label>
							<input type="text" class="form-control blineTl " id="sIName" name="sIName"  required>

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
							<button type = "submit" id ="kXsPRTiTEM" name="kXsPRTiTEM"  class="form-control text-light text-center h5 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.ITEM%></button>
						</div>
					</div>
						<br />
				</div>
				<br /><br /><br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="itemInfoList" class="table table-striped table-hover compact row-border"  style="width:100%; "> </table>
						</div>
					</div>
				</div>	
			
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		var sportCategory=" ";
		$("#XsPRTiTEM").prop('disabled', true);
		$("#sICode").focusout(function(){ 
			var ItemCode=$("#sICode").val();
			if(xValidateIC(ItemCode)){
				validateITCode(ItemCode);
			}
		});			
		function xValidateIC(ItemCode){
			if(ItemCode==null || ItemCode=="" || ItemCode=="Enter Valid item Code."){ 
				$("#sICode").val("Enter Valid Item Code.");
				$("#sICode").focusin();
				return false;
			}
			return true;	
		}
		function validateITCode(ItemCode){
			var request =$.ajax({
				type:'POST',
				data:{Action:"xiTiNFOVerify", iCode: ItemCode},
			 	dataType: 'text',
				url:'../ItemMaster',
				success:function(result){
					if(result != null){
						$("#sICode").val(result);
						$("#XsPRTiTEM").prop('disabled', true);
					}
					$("#sICode").val(ItemCode);
					$("#XsPRTiTEM").prop('disabled', false);
				}	
			});	 // eof AJAX
		}
		$("#xSprtItemInfo").click(function(){
			var request =$.ajax({
				type:'POST',
				data:{Action:"xSprtItemInfoList"},
			 	dataType: 'Json',
				url:'../ItemMaster',
				success:function(result){
					sportitemInfoList(result);					
				}	
			});	 // eof AJAX
		});
/* 		$("#XsPRTiTEM").click(function(){
			var ItemCode  = $("#sICode").val();
			var ItemName = $("#sIName").val();
			var category = $("#SportCategory").val();
			
			if(ValidateItemInfo(ItemCode, ItemName, category  )){
				itemInfo(ItemCode, ItemName, category );
			}
		});
		function ValidateItemInfo(ItemCode, ItemName , category ){
			alert("category" +category);
			if(ItemCode==""){
				$("#sICode").val("Code can't be blank");
				$("#sICode").focusin();
				return false;
			}else if(ItemName==""){
				$("#IName").val("Name can't be blank");
				$("#IName").focusin();
				return false;
			}else if(category=="0"){
				alert("Select Item Category");
				$("#SportCategory").focusin();
				return false;
			}	
			$("#sICode").val("");
			$("#IName").val("");
			return true;
		}

		function itemInfo(ItemCode, ItemName,category ){
			var request =$.ajax({
				type:'POST',
				data:{Action:"xNritemInfo", Code:ItemCode, Name:ItemName, itemCategory :category },
			 	dataType: 'Json',
				url:'../ItemMaster',
				success:function(result){
					itemInfoList(result);
				}	
			});		
		} // eof subject
 */		
		function sportitemInfoList(result){
			$('#itemInfoList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'SNO'	       ,data:"SNO"},
					 { title:	'School Code'  ,data:"sCode"},
					 { title:	'Code'         ,data:"itemCode"},  
					 { title:	'Name'         ,data:"itemName"},
					 { title:	'Category'     ,data:"Category"},
		    		 { title:	'Action'	  ,data:"Id",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="XsprtItemRMInfo"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); 
		}// EOF table FUNCTION	
		$(document).on('click', "Button[name='XsprtItemRMInfo']", function(){ 
			var ItemCode=$(this).val();
			var request =$.ajax({
				type:'POST',
				data:{Action:"XsprtITMRInfo01", iCode : ItemCode},
			 	dataType: 'Json',
				url:'../ItemMaster',
				success:function(result){
					sportitemInfoList(result);
				}	
			});
		});
		$("#SportCategory").click(function(){
			if (sportCategory!=" "){return;}
				sportCategory=" <option selected value=0>Choose Category*</option>";
		    	var cCategory = ['Football', 'Cricket','Music','Dance','Cultural Programme','Horse Ridding','Swimming', 'Atheletes'];
		      	$.each(cCategory, function(index, value){
		    	   sportCategory+=" <option value='"+value +"'>"+ value+ "</option>";
		       	});
		       	$("#SportCategory").html(sportCategory);
		   });
		});// eof of document
	</script>
</html>
