<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
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
			<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		  	<script type="text/javascript" src="../../js/SMCF.js"></script>
			<link rel="stylesheet" href="../../css/custom.css" type="text/css">
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
		
			<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>

			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>

	</head>
	<body onload="foo()">
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="SfdInfo" name="SfdInfo" action="" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row" id="chkscroll">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne" style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.Student%> <%=SMFixedValue.Attendance%>  </a></li>
 									<li class="nav-item " ><button type="button" class="nav-link text-white" id="xSFIR1"
									    style="background-color: #000080">
										<%=SMFixedValue.View%>  <%=SMFixedValue.Attendance%></button> </li>

 								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0">
							<p class="h5 text-center"><%=SMFixedValue.Student%> <%=SMFixedValue.Info%> <%=SMFixedValue.For%> <%=SMFixedValue.Attendance%></p>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-5 offset-sm-1  form-group">
						    <label for="regNo"><%=SMFixedValue.School%> <%=SMFixedValue.Name%> </label>
							<input type="text" class="form-control blineTl " id="regNo" name="regNo" readonly placeholder=<%=SMFixedValue.RegNo%>>
						</div>
						<div class="col-sm-5 offset-sm-0  form-group">
						    <label for="CltName"><%=SMFixedValue.Class%> <%=SMFixedValue.Teacher%> <%=SMFixedValue.Name%>  </label>
							<input type="text" class="form-control blineTl " id="CltName" name="CltName"  placeholder=<%=SMFixedValue.RegNo%>>
 						</div>
 						<br />
					</div>	
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">		
						<div class="col-sm-4 offset-sm-2  form-group">
						    <label for="fApplCF"><%=SMFixedValue.Student%> <%=SMFixedValue.Class%>  </label>
							<select id="fApplCF" name="fApplCF" class="form-control" style="border-bootom: 1px solid blue;">
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Class%> *</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="Ssection"><%=SMFixedValue.Section%>  </label>
 							<select id="Ssection" name="Ssection" 	class="form-control  " style="border-bootom: 1px solid blue;" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Student%> <%=SMFixedValue.Section%>*</option>
							</select>
 						</div>
					</div>	
					<div class="row">		
						<div class="col-sm-4 offset-sm-2  form-group">
						    <label for="Subject"><%=SMFixedValue.Subject%>  </label>
							<select id="Subject" name="Subject" class="form-control" style="border-bootom: 1px solid blue;">
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Subject%> *</option>
							</select>
						</div>
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="SRollN"><%=SMFixedValue.RollNo%> </label>
							<input type="text" class="form-control blineTl " id="SRollN" name="SRollN" placeholder="" style="border-bootom: 1px solid blue;">
						</div>
					</div>	
					<br/ >
					<div class="row">
						<div class="col-sm-2 offset-sm-5 ">
							<button type="button" id ="XsAttInfo" name="XsAttInfo" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=Information.View%> <%=Information.Info%></button>
						</div>
					</div>
				</div>

				<br />
				<div class="card" id ="studentInfoList">
					<div class="card-header  text-light bg-secondary" id ="ItemHd1">
						<p class="h5 text-center"><%=SMFixedValue.Student%> <%=SMFixedValue.Info%></p>
					</div>
					<div class="card-body  text-dark " id ="ItemHd1">
						<div class="form-row">
							<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
								<div class="table-responsive ">
									<table id="StudentList" class="table table-striped table-hover compact row-border" style="width:100%; font-size:14px"></table>
								</div>
							</div>
						</div>	
					</div>
					<div class="card-body  text-light bg-secondary" id ="ItemHd1">
							<button type="button" id ="XsAttMarks" name="XsAttMarks" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" >
							<%=SMFixedValue.Save%> <%=SMFixedValue.Attendance%></button>
					</div>
									
				</div>				
			</form>
			
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		function foo(){
			$("#studentInfoList").hide();
		}
		$(document).ready(function(){
			$("#XsAttMarks").click(function(){
	          	var sAttendance = [];
				$.each($("input[name='XstudentAtd']:checked"), function(){
					sAttendance.push($(this).val());
		        });
		        if (sAttendance.length>0){
	 				var InputData = [];
					InputData = updateValue(InputData);
		            alert("My favourite input values: " + InputData.join("; "));
					var request =$.ajax({
						type:'POST',
		 				data:{Action:"StdPresent", attendance: sAttendance, InputValues :  InputData},
					 	dataType: 'Json',
						url:'../../StudentAttendanceInfo',
						success:function(result){
						}	
					});	 // eof AJAX
		        }
			});	
	 		function markAttendance(sAttendance,InputData ){
	            alert("sAttendance: " + sAttendance.join(", "));
	            alert("InputData: " + InputData.join(", "));
				var request =$.ajax({
					type:'POST',
	 				data:{Action:"StdPresent", attendance: sAttendance, InputValues :  InputData},
				 	dataType: 'Json',
					url:'../../StudentAttendanceInfo',
					success:function(result){
					}	
				});	 // eof AJAX
			}		
	 		$("#XsAttInfo").click(function(){
		    	var atdInfo = {
	                "STeacher": $("#CltName").val(),
	                "SClass"  : $("#fApplCF").val(),
	                "Section" : $("#Ssection").val(),
	                "SRollNo" : $("#SRollN").val(),
	                "Subject" : $("#Subject").val()
	            };
 				var atdInfos = [];
 				atdInfos = updateValue(atdInfos);
	            alert("My favourite input values: " + atdInfos.join("; "));
				if(subjectValidate(atdInfo)){
					rSListForAttendance(atdInfos);
				}
			});
			function updateValue(atdInfos){
 		    	atdInfos.push($("#CltName").val());
		    	atdInfos.push($("#fApplCF").val());
		    	atdInfos.push($("#Ssection").val());
		    	atdInfos.push($("#SRollN").val());
		    	atdInfos.push($("#Subject").val());
		    	return atdInfos;
			}			
	 		function subjectValidate(atdInfo ){
				if(atdInfo.STeacher==""){
					$("#CltName").focusin();
					alert('Enter Class Teacher Name');
					return false;
				}else if(atdInfo.SClass==""){
					$("#fApplCF").focusin();
					alert('Select Student Class');
					return false;
				}else if(atdInfo.Section==""){
					$("#Ssection").focusin();
					alert("Select Class Section");
					return false;
				}else if(atdInfo.SRollNo==""){
					$("#SRollN").focusin();
					alert("Enter Stundent Roll Number");
					return false;
				}
				return true;
			}

 	 		function rSListForAttendance(atdInfo){
				var request =$.ajax({
					type:'POST',
	 				data:{Action:"SAtdInfo", InputValues: atdInfo},
				 	dataType: 'Json',
					url:'../../StudentAttendanceInfo',
					success:function(result){
						$("#studentInfoList").show();
						StudentList(result);
						scrollPage(6000);
					}	
				});	 // eof AJAX
			}


			
 
		   	$("#xSFIR1").click(function(){
				var request =$.ajax({
					type:'POST',
					data:{Action:"xSFIR1"},
				 	dataType: 'Json',
					url:'../../StudentAttendanceInfo',
					success:function(result){
						feeList(result);
						scrollPage(6000);
					}	
				});	 // eof AJAX
			});
		   	
			function StudentList(result){
				$('#StudentList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	       ,data:"SNO"},
						 { title:	'School Code'  ,data:"RegNo"},
						 { title:	'Student Name' ,data:"Name" },  
						 { title:	'Class'       ,data:"Class"},  
						 { title:	'Section'     ,data:"Class"},
						 { title:	'Roll Number' ,data:"RollNo"},
			    		 { title:	'Attendance' ,data:"SIDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<INPUT type="checkbox" name="XstudentAtd" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to mark Student as Present " ><span> Present </span>'; 
			        		},
				        }
					]
				}); 
			}// EOF table FUNCTION	
			function scrollPage(pos){
				$("html, body").animate({
				    scrollTop: $('html, body').get(0).scrollHeight}, pos);				
			}// eof function -> function for scroll page bottom

	/*	

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
		   	
 */		
		});// document.ready eof
	</script>
</html>


