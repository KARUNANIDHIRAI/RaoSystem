<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
<!-- 		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">

		 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
			<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>

			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>
			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>

			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>
 -->
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="../../css/custom.css" type="text/css">
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
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
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		
			<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>

			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>


	</head>
	<body >
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="SfdInfo" name="SfdInfo" action="" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row" id="chkscroll">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">

								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.RWA%> <%=Information.Registration%> <%=Information.Info%> </a></li>
									<li class="nav-item " ><button type="button" class="nav-link text-white" id="xSFIR1"
									    style="background-color: #000080">
										<%=SMFixedValue.View%> <%=SMFixedValue.Item%>  <%=SMFixedValue.Info%></button> </li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<div class="row">		
					<div class="col-sm-5 offset-sm-1">
						<p class="h5 text-center"><%=SMFixedValue.Define%> <%=SMFixedValue.School%> <%=SMFixedValue.Fee%></p>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-4 offset-sm-1  form-group">
						    <label for="regNo"><%=SMFixedValue.School%> <%=SMFixedValue.Name%> </label>
							<input type="text" class="form-control blineTl " id="regNo" name="regNo" readonly placeholder=<%=SMFixedValue.RegNo%>>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="feeGrade"><%=SMFixedValue.Define%> <%=SMFixedValue.Fee%> <%=SMFixedValue.For%> <%=SMFixedValue.Grade%> </label>
 							<select id="feeGrade" name="feeGrade" 	class="form-control  " style="border-top: 1px solid blue;" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Fee%> <%=SMFixedValue.Grade%>*</option>
							</select>
 						</div>
 						<br />
					</div>	
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
							<p class="h5 text-center"><%=SMFixedValue.Fee%> <%=SMFixedValue.Info%> </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-4 offset-sm-1  form-group">
						    <label for="fApplCF"><%=SMFixedValue.Fee%> <%=SMFixedValue.Type%> </label>
 							<select id="feeType" name="feeType" 	class="form-control  " style="border-top: 1px solid blue;" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Fee%> <%=SMFixedValue.Type%>*</option>
							</select>
 						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="fApplCF"><%=SMFixedValue.Fee%> <%=SMFixedValue.Applicable%> <%=SMFixedValue.For%> <%=SMFixedValue.Class%> </label>
							<select id="fApplCF" name="fApplCF" class="form-control" style="border-top: 1px solid blue;">
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Applicable%> <%=SMFixedValue.For%> <%=SMFixedValue.Class%>*</option>
							</select>
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="fProgram"><%=SMFixedValue.To%>Programme </label>
							<select id="fProgram" name="fProgram" 	class="form-control  " style="border-top: 1px solid blue;"
							        multiple aria-label="multiple select example" size="2" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Program%>*</option>
							</select>
						</div>
					</div>	
					<div class="row">		
<%-- 						<div class="col-sm-4 offset-sm-1  form-group">
						    <label for="fProgram"><%=SMFixedValue.To%>Programme </label>
							<select id="fProgram" name="fProgram" 	class="form-control  " style="border-top: 1px solid blue;"
							        multiple aria-label="multiple select example" size="2" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Program%>*</option>
							</select>
						</div> --%>
						<div class="col-sm-4 offset-sm-1  form-group">
						    <label for="feeSlab"><%=SMFixedValue.To%> <%=SMFixedValue.Slab%> </label>
							<select id="feeSlab" name="feeSlab" 	class="form-control  " style="border-top: 1px solid blue;">
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Slab%> <%=SMFixedValue.Range%> *</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="fAmount"><%=SMFixedValue.Fee%> <%=SMFixedValue.Amount%></label>
							<input type="text" class="form-control blineTl " id="fAmount" name="fAmount" style="border-top: 1px solid blue;" >
						</div>
						<div class="col-sm-3 offset-sm-0  form-group">
						    <label for="DisAmt"><%=SMFixedValue.Fee%> <%=SMFixedValue.Discount%> <%=SMFixedValue.Amount%></label>
							<input type="text" class="form-control blineTl " id="DisAmt" name="DisAmt" style="border-top: 1px solid blue;" >
						</div>
						<br />
					</div>	
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="row">
						<div class="col-sm-2 offset-sm-9 ">
							<button type="button" id ="XsdfAr" name="XsdfAr" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=Information.Submit %></button>
						</div>
					</div>
				</div>

				<br />
				<div class="card" id ="feeHeading1">
					<div class="card-header  text-light bg-secondary" id ="ItemHd1">
						<p class="h5 text-center">School Fee Detail Information</p>
					</div>
					<div class="card-body  text-dark " id ="ItemHd1">
						<div class="form-row">
							<div class="col-sm-7 offset-sm-0" >  <!--  showing data into table -->
								<div class="table-responsive ">
									<table id="feeList" class="table table-striped table-hover compact row-border" style="width:100%; font-size:12px"></table>
								</div>
							</div>
							<div class="col-sm-5 offset-sm-0" >  <!--  showing data into table -->
								<div class="table-responsive ">
									<table id="feeSubList" class="table table-striped table-hover compact row-border " style="width:100%; font-size:12px"></table>
								</div>
							</div>
						</div>	
					</div>				
				</div>				
			</form>
			
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">

		$(document).ready(function(){
	 		function addFeeData(feeGrade,feeType, fprogram,feeSLab,fApplCF, fAmount,DisAmt){
				var programs = [];
			    $("#fProgram :selected").each(function() {
						programs.push($(this).val());
			    });
				var request =$.ajax({
					type:'POST',
	 				data:{Action:"SFDInfo", selec: programs,fGrade:feeGrade,fType:feeType, feeProgram:fprogram,fSlab:feeSLab,feeApl:fApplCF, feeAmount:fAmount,DAmt:DisAmt},
				 	dataType: 'Json',
					url:'../../FeeDefineInformation',
					success:function(result){
						alert(result);
						feeList(result);
						scrollPage(6000);
					}	
				});	 // eof AJAX
			}// function
			
	 		$("#XsdfAr").click(function(){
	 	 		var feeGrade = $("#feeGrade").val();
				var feeType  = $("#feeType").val() ;
				var fprogram = $("#fProgram").val();
				var feeSLab  = $("#feeSlab").val();
				var fApplCF  = $("#fApplCF").val() ;
				var fAmount  = $("#fAmount").val() ;
				var DisAmt   = $("#DisAmt").val();
				if(subjectValidate(feeGrade,feeType, fprogram,feeSLab,fApplCF, fAmount,DisAmt)){
					addFeeData(feeGrade,feeType, fprogram,feeSLab,fApplCF, fAmount,DisAmt);
				}
			});
	 		function subjectValidate(feeGrade,feeType, fprogram,feeSLab,fApplCF, fAmount,DisAmt ){
				if(feeGrade=="0"){
					alert('Select Fee Grade');
					$("#feeGrade").focusin();
					return false;
				}else if(feeType=="0"){
					alert('Select Fee Tyep');
					$("#feeType").focusin();
					return false;
				}else if(fprogram=="0"){
					alert("select Course Program");
					$("#fprogram").focusin();
					return false;
				}else if(feeSLab=="0"){
					alert("select fees tenure");
					$("#feeSLab").focusin();
					return false;
				}else if(fApplCF=="0"){
					alert("select fee applicable for class");;
					$("#fApplCF").focusin();
					return false;
				}else if(fAmount==""){
					alert("Enter Fee amount");
					$("#fAmount").focusin();
					return false;
				}
				return true;
			}

		   	$("#xSFIR1").click(function(){
				var request =$.ajax({
					type:'POST',
					data:{Action:"xSFIR1"},
				 	dataType: 'Json',
					url:'../../FeeDefineInformation',
					success:function(result){
						feeList(result);
						scrollPage(6000);
					}	
				});	 // eof AJAX
			});
		   	
			function feeList(result){
				$('#feeList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
				    "columns": [
						 { title:	'SNo'	      ,data:"SNO"},
						 { title:	'School Code' ,data:"RegNo"},
						 { title:	'Fee Grade'   ,data:"fGrade"},  
						 { title:	'Class'       ,data:"fClass"},  
						 { title:	'Fee Type'    ,data:"fType"},
						 { title:	'Fee Tennure' ,data:"fTennure"},
// 						 { title:	'Stream'      ,data:"Stream" },
// 						 { title:	'Fee Amount'  ,data:"FeeAmount"},
// 						 { title:	'Fee Discount',data:"FeeDisocunt" },
			    		 { title:	'View'		 ,data:"fIdno",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="XFeeVr"  value="'+data+'" class="btn btn-primary btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to View Fee Amount" onclick="RemoveItem('+data+')"><span>i</span></button>'; 
			        		},
				        },
			    		 { title:	'Del'		 ,data:"fIdno",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="XFeeDr"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					        	},
			    		 }	
					]
				}); 
			}// EOF table FUNCTION	
	
			   $(document).on('click', "Button[name='XFeeDr']", function(){ 
					var ItemCode=$(this).val();
					var request =$.ajax({
						type:'POST',
						data:{Action:"XFeeDr", Code:ItemCode},
					 	dataType: 'Json',
						url:'../../FeeDefineInformation',
						success:function(result){
							feeList(result);
							scrollPage(6000);
						}	
					});
			   	});// on click button

				function feeSubList(result){
					$('#feeSubList').dataTable({
					    destroy: true,
						"data":result,
						 columnDefs: [ {	targets: -1, className: 'dt-body-right'	}, ],
					    "columns": [
							 { title:	'SNo'	      ,data:"SNO"},
	 						 { title:	'Stream'      ,data:"Stream" },
	 						 { title:	'Fee Amount'  ,data:"FeeAmount"},
	 						 { title:	'Fee Discount',data:"FeeDisocunt" },
				    		 { title:	'Del'		 ,data:"FPIdNo",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="XFeeSubDLR"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
					        	},
					        }
						]
					}); // EOF table
				}// EOF table FUNCTION	

			function scrollPage(pos){
				$("html, body").animate({
				    scrollTop: $('html, body').get(0).scrollHeight}, 6000);				
			}// eof function -> function for scroll page bottom
			
		   $(document).on('click', "Button[name='XFeeSubDLR']", function(){ 
				var ItemCode=$(this).val();
				var request =$.ajax({
					type:'POST',
					data:{Action:"XFeeSubDLR", Code:ItemCode},
				 	dataType: 'Json',
					url:'../../FeeDefineInformation',
					success:function(result){
						feeSubList(result);
					}	
				});
		   	});// EOF RCIVEDIT item

		   $(document).on('click', "Button[name='XFeeVr']", function(){ 
				var ItemCode=$(this).val();
				alert(ItemCode);
				var request =$.ajax({
					type:'POST',
					data:{Action:"XFeeVr", Code:ItemCode},
				 	dataType: 'Json',
					url:'../../FeeDefineInformation',
					success:function(result){
						feeSubList(result);
					}	
				});
		   	});// on click button
		   	
		});// document.ready eof
	</script>
</html>


