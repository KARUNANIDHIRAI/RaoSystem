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
		  	
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
		 
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
		 
				  	
		  	
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="subInfo" name="subInfo" action="../../SubjectsInfo?Action=information" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white " id="headingOne" 
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.Item%> <%=SMFixedValue.Master%> <%=SMFixedValue.Info%></a></li>
									<li class="nav-item " ><button type="button" class="nav-link text-white" id="xSRVl"
									    style="background-color: #000080">
										<%=SMFixedValue.View%>  <%=SMFixedValue.Info%></button> </li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row col-sm-12 offset-sm-0">
					<div class="col-sm-4 offset-sm-4">
						<p class="h5 text-center">Create New Subject Code and Name</p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />
					<div class="row">		
						<div class="col-sm-3 offset-sm-3  form-group">
						    <label for="ICode"><%=SMFixedValue.Item%> <%=SMFixedValue.Code%></label>
							<input type="text" class="form-control blineTl " id="ICode" name="ICode" required>

						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="IName"><%=SMFixedValue.Item%> <%=SMFixedValue.Name%></label>
							<input type="text" class="form-control blineTl " id="IName" name="IName"  required>

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
							<button type = "button" id ="XsAr" name="XsAr"  class="form-control text-light text-center h5 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.Action%> <%=SMFixedValue.New%> <%=SMFixedValue.Item%></button>
						</div>
					</div>
						<br />
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="sList" class="table table-striped table-hover compact row-border"  style="width:100%; "> </table>
						</div>
					</div>
				</div>	
			
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#xSRVl").click(function(){
			var request =$.ajax({
				type:'POST',
				data:{Action:"xSRVl"},
			 	dataType: 'Json',
				url:'../../SubjectsInfo',
				success:function(result){
					sList(result);
				}	
			});	 // eof AJAX
		});

		$("#XsAr").click(function(){
			var ItemCode  = $("#ICode").val();
			var ItemName = $("#IName").val();
			if(subjectValidate(ItemCode, ItemName  )){
				subject(ItemCode, ItemName );
			}
		});
		function subjectValidate(ItemCode, ItemName  ){
			if(ItemCode==""){
				$("#ICode").val("Item Code can't be blank");
				$("#ICode").focusin();
				return false;
			}else if(ItemName==""){
				$("#IName").val("Subject Name can't be blank");
				$("#IName").focusin();
				return false;
			}
			$("#ICode").val("");
			$("#IName").val("");
			return true;
		}

		function subject(ItemCode, ItemName ){
			var request =$.ajax({
				type:'POST',
				data:{Action:"sInfromation", Code:ItemCode, Name:ItemName},
			 	dataType: 'Json',
				url:'../../SubjectsInfo',
				success:function(result){
					sList(result);
				}	
			});		
		} // eof subject

		function sList(result){
			$('#sList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
			    "columns": [
					 { title:	'SNO'	       ,data:"SNO"},
					 { title:	'School Code'  ,data:"RegNo"},
					 { title:	'Code'         ,data:"Code"},  
					 { title:	'Subject Name' ,data:"Name"},
		    		 { title:	'Del'		  ,data:"Code",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="XsRs"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	

		   $(document).on('click', "Button[name='XsRs']", function(){ 
				var ItemCode=$(this).val();
				 alert("onclick :" + ItemCode);
				var request =$.ajax({
					type:'POST',
					data:{Action:"XsRs", Code:ItemCode},
				 	dataType: 'Json',
					url:'../../SubjectsInfo',
					success:function(result){
						sList(result);
					}	
				});// EOF $.Ajax()
		   	});// EOF RCIVEDIT item
				

	});// eof of document
	</script>
</html>















