<%@page import="com.rao.System.PO.ConstPO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%-- 	<%@page import="com.rao.System.WaterTankerEntry.DAOWaterTankerDetails"%>
	<%@page import="com.rao.System.WaterTankerEntry.TankerModel"%>
 --%>
	<%@page import="java.util.Iterator"%> 
	<%@page import="java.util.ArrayList"%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- 
		<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript"	src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
		<script type="text/javascript"	src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
  	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
		<link rel="stylesheet" href="../webjars/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="../webjars/bootstrap/4.3.1/css/bootstrap.css">
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">		

<!-- 	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
 -->
 		<script type="text/javascript" src="../webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
	
	
		<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
		<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript"	src="../webjars/datatables.net-select/1.3.1/js/dataTables.select.min.js"></script>

		<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	 
		<script  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
		<script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
		<script type="text/javascript" src="../js/PO.js"></script>

 --%>
 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>

	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

	<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

  	<script type="text/javascript" src="../js/PO.js"></script>
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">
 
 	</head>
	<body>
		<!-- Page Header -->
			<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<!-- Page Body -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../MainPOInfo" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=ConstPO.PO%></a></li>
									<li class="nav-item " id="NEWPO"><a class="nav-link text-light" href="NewPO.jsp">
										<%=ConstPO.New%> <%=ConstPO.PO%></a></li>
									<li class="nav-item " id="WtrTankInfoSummary"><a class="nav-link text-light"
										href="../MIS/WaterSupplySumSearch.jsp"><%=ConstPO.PO%> <%=ConstPO.Summary%></a></li>
								</ul>
							</div>
							<div class="card-body text-dark h6">
								<div class="form-row">
									<div class="col-sm-9 offset-sm-3">
										<p class="text-danger h6"><%=session.getAttribute("Message") == null ? "" : session.getAttribute("Message")%></p>
										<%session.removeAttribute("Message"); %>
									</div>
								</div>
								<br />
								<div class="form-row ">
									<div class="col-sm-4 offset-sm-2">
									<label for="PONo"><%=ConstPO.PO%> <%=ConstPO.No%></label>
										<div class="input-group">
											<input type="text" class="form-control " id="PONo" 	name="PONo" >
										</div>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="ActionType"><%=Information.ActionType%></label>
										<select id="ActionType" name="ActionType" 	class="form-control is-invalid">
											<option selected value="0">Select Action Type</option>
											<option value="1"><%=ConstPO.View%> <%=ConstPO.PO%></option>
											<option value="2"><%=ConstPO.Edit%> <%=ConstPO.PO%></option>
											<option value="3"><%=ConstPO.Remove%> <%=ConstPO.PO%></option>
										</select>
									</div>
								</div>
								<br />
								<div class="form-row " id="PODateFT">
									<div class="col-sm-4 offset-sm-2">
										<label for="FromDate"><%=ConstPO.From%> <%=ConstPO.Date%></label>
										<div class="input-group">
											<input type="date" class="form-control " 	id="FromDate" name="FromDate" >
										</div>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="ToDate"><%=ConstPO.To%> <%=ConstPO.Date%></label>
										<div class="input-group">
											<input type="date" class="form-control " id="ToDate" 	name="ToDate" >
										</div>
									</div>
								</div>
								<br /> 	<br />
								<div class="form-row">
									<div class="col-sm-2 offset-sm-4 ">
										<p>
											<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
												style="background-color: #000080"><%=Information.Cancel%></a>
										</p>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="button" id ="submit01" class="form-control h5 text-white text-center "
											style="background-color: #38ACEC" name="submit01"><%=Information.Submit%>
										</button>
									</div>
								</div>
								<hr class="bg-danger h5" id="inv01"/>
								<div class="form-row">
									<div class="col-sm-6">  <!--  showing data into table -->
										<div class="table-responsive ">
											<table id="POList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
									<div class="col-sm-6">  <!--  showing PO Item List in table -->
										<div class="table-responsive">
											<table id="POItemsList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
								</div>	
	
							</div>
						</div><!--   end of card -->
					</div>
				</div>
			</form>
		</div>
	
		<!--Footer  -->
			<jsp:include page="../FooterPage.jsp"></jsp:include>
	
		<script type="text/javascript">
			var tPONo;
			var fdate;
			var tdate;
			$(document).ready(function() {
			    var events = $('#events');
			    $("#PONo").focusout(function(){
				    if($("#PONo").val()!=""){
				    	$("#PODateFT").hide();
				    }else{
				    	$("#PODateFT").show();
				    }
			    });
			    $("#submit01").click(function(){
					fDate = $("#FromDate").val();
					tDate = $("#ToDate").val();
					var PONo=$("#PONo").val();
					var request =$.ajax({
						type:'POST',
						data:{PONO:PONo,  fromDate:fDate,toDate:tDate, Action:"POList"},
			   		    dataType: 'json',
						url:'../POSummary',
						success:function(result){
							if ($("#ActionType").val()=='2'){
								alert("wah kamal zero one");
				   				POListForEdit(result);
							}else{
								alert("wah kamal zero");
				   				POListForView(result);
							}
						}	
					});					
			    });// eof submit
	            $(document).on('click', "Button[name='POListItemForEdit']", function(){ 
					var PONo=$(this).val();
					tPONo=PONo=$(this).val();
					var request =$.ajax({
			   			type:'POST',
			   			data:{PONO:PONo,  Action:"POItemList"},
		   	   		    dataType: 'json',
			   			url:'../POSummary',
			   			success:function(result){
							alert('chal ja bhai SAHAB');
			   				DisPOListItemForEdit(result);
			   			}
					});// End Of the $.Ajax()
	            });

	            $(document).on('click', "Button[name='PODEL']", function(){
	        		var PONo=$(this).val();
	        		var request =$.ajax({
	           			type:'POST',
	        			data:{PONO:PONo, fromDate:fDate,toDate:tDate, Action:"PODEL", SNO:''},
	         	   		dataType: 'json',
	        	   		url:'../EditPO',
	           			success:function(result){
	           		    	POListForEdit(result);
	           			}
	        		});// End Of the $.Ajax()
	            });

	            $(document).on('click', "Button[name='PODelItem']", function(){ 
					var SNo=$(this).val();
					alert('PONO :' + tPONo + " SNo : " +  SNo );
					var request =$.ajax({
			   			type:'POST',
			   			data:{PONO:tPONo, SNO:SNo, Action:"PODELITEM"},
		   	   		    dataType: 'json',
			   			url:'../EditPO',
			   			success:function(result){
			   				DisPOListItemForEdit(result);
			   				//POItemListDataTable(result);			   				
			   			}	
					});// End Of the $.Ajax()
	            });
		   		

			    function POListForEdit(result){
			    	$('#POList').dataTable({
			    	    destroy: true,
			    	    "scrollX": true,
			            "scrollY": 200,
			    		"data":result,
			    		 columnDefs: [
			        		{ "width": "3%", "targets": 0 },
			        		{ "width": "7%", "targets": 1 },
			        		{ "width": "11%", "targets":2 },
			        		{ "width": "14%", "targets":3 },
			        		{ "width": "4%", "targets": 4 },
			        		{ "width": "3%", "targets": 5 },
			        		{ "width": "3%", "targets": 6 },
			      		],
			    	    "columns": [
			    			 { title:	'SNo.'             ,data:"SNo" },
			    			 { title:	'PONO     '       ,data:"PONO" },  
			    			 { title:	'PO Date'		 ,data:"PODate"},  
			    			 { title:	'Customer' ,data:"CustomerName"},
			    			 { title:	'Contact NO'   ,data:"MobileNo"}, 
			    			 { title:	'Edit'		  ,data:"PONO",
			    			 	"render": function(data,type,row,meta){
			    			 	return	'<button type="button" name="POListItemForEdit"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
			    			 	},
			    			 },
			    			 { title:	'Del'		  ,data:"PONO",
			        		 	"render": function(data,type,row,meta){
			        		 	return	'<button type="button" name="PODEL"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        		 	},
			        		}
			    		],
			    	    "footerCallback": function( row, data, start, end, display ) {
			    	    	// Remove the formatting to get integer data for summation
			    	        var api = this.api(), data;
			    	        // converting to interger to find total
			    	        var intVal = function ( i ) {
			    	            return typeof i === 'string' ?
			    	            i.replace(/[\$,]/g, '')*1 :
			    	            typeof i === 'number' ?
			    	            i : 0;
			    	        };
			    	        // computing column Total of the complete result 
			    	        var Amount = api
			    	              .column( 4 )
			    	              .data()
			    	              .reduce( function (a, b) {
			    	                  return intVal(a) + intVal(b);
			    	              }, 0 );
			    			$( api.column( 1 ).footer() ).html('Total');								
			    	    }, // end of footer
			    	}); // eof datatable
			    }// eof ()
			    function POListForView(result){
					alert("wah kamal");
				     $('#POList').dataTable({
					    destroy: true,
					    "scrollX": true,
				        "scrollY": 200,
						"data":result,
						 columnDefs: [
				    		{	targets: -1,
				        		className: 'dt-body-right'
				    		},
				    		{
				    		    data: 'Amount',
				    		    render: $.fn.dataTable.render.number( ',', '.', 2 )
				    		},							    		
				    		{ "width": "3%", "targets": 0 },
				    		{ "width": "7%", "targets": 1 },
				    		{ "width": "11%", "targets": 2 },
				    		{ "width": "14%", "targets": 3 },
				    		{ "width": "4%", "targets": 4 },
				    		{ "width": "3%", "targets": 5 },
				  		],
					    "columns": [
							 { title:	'SNo.'             ,data:"SNo" },
							 { title:	'PONO     '       ,data:"PONO" },  
							 { title:	'PO Date'		 ,data:"PODate"},  
							 { title:	'Customer' ,data:"CustomerName"},
							 { title:	'Contact NO'   ,data:"MobileNo"}, 
							 { title:	'View'		  ,data:"PONO",
				    		 	"render": function(data,type,row,meta){
				    		 	return	'<button type="button" name="ViewPOItems"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to view PO items" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
				    		 	},
				    		 },
						],
					    "footerCallback": function( row, data, start, end, display ) {
					    	// Remove the formatting to get integer data for summation
					        var api = this.api(), data;
					        // converting to interger to find total
					        var intVal = function ( i ) {
					            return typeof i === 'string' ?
					            i.replace(/[\$,]/g, '')*1 :
					            typeof i === 'number' ?
					            i : 0;
					        };
					        // computing column Total of the complete result 
					        var Amount = api
					            .column( 4 )
					            .data()
					            .reduce( function (a, b) {
					            return intVal(a) + intVal(b);
			               },   0 );
			   		       $( api.column( 1 ).footer() ).html('Total');								
					    }, // eof footer
					}); // EOF datatable
			    } //eof ()    

			    function DisPOListItemForEdit(result){
					$('#POItemsList').dataTable({
					    destroy: true,
					    "scrollX": true,
				        "scrollY": 200,
					    "data":result,
						 columnDefs: [
				    		{	targets: -1,
				        		className: 'dt-body-right'
				    		},
				  		],
					    "columns": [
			    			 { title:	'SNo.'           ,data:"SNo" },
			    			 { title:	'PONO'          ,data:"PONO" },  
			    			 { title:	'Item Code'	 ,data:"ItemCode"},  
			   				 { title:	'Item Name'  ,data:"ItemName"},
			    			 { title:	'Brand'         ,data:"Brand"}, 
			    			 { title:	'QTY'		 ,data:"Quantity"},  
			   				 { title:	'Unit'           ,data:"Unit"},
			    			 { title:	'Add'		  ,data:"PONO",
			    			 	"render": function(data,type,row,meta){
					    		return   '<a href="AddItemInPO.jsp?Id='+data+'">Add </a>';
			    			 	},
			    			 },
			    			 { title:	'Del'		  ,data:"SNo",
					    		"render": function(data,type,row,meta){
					    		return	'<button type="button" name="PODelItem"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					    		},
					    	}
				    	],
			    	}); // end of data table
				}// end of  function

			});// end of $(document) function
			
			
		</script>
	</body>
</html>




























