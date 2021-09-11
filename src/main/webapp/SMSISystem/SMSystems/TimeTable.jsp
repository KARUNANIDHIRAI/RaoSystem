<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<!-- http://localhost:8080/swagger-ui/#/Brand%20V2%20APIs/setPasswordUsingPOST_1 -->
<html>
	<head>
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
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>

	</head>
	<body onload="STimeTable()">
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
										style="background-color: #000080" href="#"><%=SMFixedValue.CLASS%> <%=SMFixedValue.TIME_TABLE%>  </a></li>
 									<li class="nav-item " ><button type="button" class="nav-link text-white" id="xSFIR1"
									    style="background-color: #000080" onclick="xTTDataView()">
										<%=SMFixedValue.View%>  <%=SMFixedValue.TIME_TABLE%></button> </li>

 								</ul>
							</div>
						</div>				
					</div>
				</div>
				<div class="row">		
					<div class="col-sm-12 offset-sm-0">
							<p class="h5 text-center"> <%=SMFixedValue.Student%> <%=SMFixedValue.CLASS%> <%=SMFixedValue.TIME_TABLE%></p>
					</div>
				</div>
				<div class="card" >
					<div class="card-header  text-dark" id ="xSTPh">
						<div class="row">		
							<div class="col-sm-5 offset-sm-1  form-group">
							    <label for="regNo" class="h6"><%=SMFixedValue.School%> <%=SMFixedValue.Name%> </label>
								<input type="text" class="form-control blineTl" id="regNo" name="regNo" readonly >
							</div>
 						</div>	
						<div class="row">		
							<div class="col-sm-5 offset-sm-1  form-group">
							    <label for="Subject" class="h6"><%=SMFixedValue.Subject%>  <%=SMFixedValue.Name%></label>
								<select id="Subject" name="Subject" class="form-control blineTl" >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Subject%> *</option>
								</select>
							</div>
							<div class="col-sm-5 offset-sm-0  form-group">
							    <label for="fApplCF" class="h6"><%=SMFixedValue.Student%> <%=SMFixedValue.Class%>  </label>
								<select id="fApplCF" name="fApplCF" class="form-control blineTl" style="border-bootom: 1px solid blue;">
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Class%> *</option>
								</select>
							</div>
						</div>
						<div class="row">	
							<div class="col-sm-5 offset-sm-1  form-group">
							    <label for="Ssection" class="h6"><%=SMFixedValue.Section%>  </label>
	 							<select id="Ssection" name="Ssection" 	class="form-control blineTl " style="border-bootom: 1px solid blue;" >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Student%> <%=SMFixedValue.Section%>*</option>
								</select>
	 						</div>
							<div class="col-sm-5 offset-sm-0  form-group">
							    <label for="totHours" class="h6"><%=SMFixedValue.TOTAL%> <%=SMFixedValue.HRS%> </label>
								<input type="text" class="form-control blineTl " id="totHours" name="totHours" 
								placeholder="Enter Total class Hours for current session">
							</div>
						</div>
<%-- 						<div class="row">
							<div class="col-lg-2 offset-sm-1 ">
							    <label for="xTTDataView"> </label>
								<button type = "button" id ="xTTDataView" name="xTTDataView" 
									class = "form-control text-light text-center h5 btn bg-secondary" 
									style = "background:linear-gradient(90deg,#1CB5E0 0%,#000851 100%); 
										        padding-left:0 px" ><%=SMFixedValue.View%> xTTDataView</button>
							</div>
						</div>	
 --%>
 					</div>
					<div class="card-body  col-lg-12 offset-sm-0 blinew" id ="xSTPb">
						<div class="row">		
							<div class="col-sm-4 offset-sm-0  form-group">
							    <label for="teacher01" class="h6"> <%=SMFixedValue.TEACHER%> <%=SMFixedValue.Name%>  </label>
								<input type="text" class="form-control blinew H6 " id="teacher01" name="teacher01">
	 						</div>
							<div class="col-sm-2 offset-sm-0  form-group">
							    <label for="Days" class="h6"><%=SMFixedValue.CLASS%>  <%=SMFixedValue.ON%> <%=SMFixedValue.DAYS%></label>
	 							<select id="Days" name="Days" 	class="form-control blinew "  >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.DAYS%> *</option>
								</select>
	 						</div>

							<div class="col-lg-2 offset-sm-0 form-group">
							    <label for="CSTime" class="h6"><%=SMFixedValue.CLASS%> <%=SMFixedValue.START%>  </label>
								<input type="text" class="form-control blinew  " id="CSTime" name="CSTime" required 
									   title="Enter Class start Time" placeholder="class start time" >
							</div>
							<div class="col-lg-2 offset-sm-0 form-group">
							    <label for="CETime" class="h6"> <%=SMFixedValue.CLASS%> <%=SMFixedValue.END%>  </label>
								<input type="text" class="form-control   blinew " id="CETime" name="CETime" required 
								       title="Enter Class start Time" placeholder="class End time" >
							</div>
							<div class="col-lg-2 offset-sm-0 ">
							    <label for="xTTAdd"> </label>
								<button type = "button" id ="xTTAdd" name="xTTAdd" 
									class = "form-control text-light text-center h5 btn bg-secondary" 
									style = "background:linear-gradient(90deg,#1CB5E0 0%,#000851 100%); 
										        padding-left:0 px" ><%=SMFixedValue.ADD%> </button>
							</div>
 						</div>	
 					</div>
					<div class="card-footer"   id ="xSTPf">
						<p class="h5 text-center"><%=SMFixedValue.Student%> <%=SMFixedValue.CLASS%> <%=SMFixedValue.TIME_TABLE%> <%=SMFixedValue.Summary%></p>
						<div class="form-row">
							<div class="col-sm-6 offset-sm-0" >  <!--  showing data into table -->
								<div class="table-responsive ">
									<table id="AllClassTimeTable" 
										class="table table-striped table-hover compact row-border"
									 	style="width:100%; font-size:14px"></table>
								</div>
							</div>
							<div class="col-sm-5 offset-sm-1" >  <!--  showing data into table -->
								<div class="table-responsive ">
									<table id="ClassTimeTable" 
										class="table table-striped table-hover compact row-border"
									 	style="width:100%; font-size:14px"></table>
								</div>
							</div>
						</div>	
					</div>
				</div>				
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->
	</body>
	<script type="text/javascript">
		function STimeTable(){
			var request =$.ajax({
				type:'POST',
					data:{Action:"xvTTNDATA"},
			 	dataType: 'Json',
				url:'../../TimeTableInfo',
				success:function(result){
					AllClassTimeTable(result);
					scrollPageUP(6000);
				}	
			});	 // eof AJAX
		}
		function AllClassTimeTable(result){
			$('#AllClassTimeTable').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
			    "columns": [
					 { title:	'SNo'	    ,data:"SNO"},
					 { title:	'School '   ,data:"RegNo"},
					 { title:	'Class'     ,data:"Class"},  
					 { title:	'Section'   ,data:"Section"},  
					 { title:	'T.Hrs'     ,data:"THours"},  
					 { title:	'Subject'   ,data:"Subject"},  
		    		 { title:	'Remove'    ,data:"TTIDNOPK",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xvSCSSTTData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove all Schedule for this subject" ><span> &#9988; </span> </button>'; 
		        		},
			        }
				]
			}); 
		}// EOF table FUNCTION	
		$(document).on('click', "Button[name='xvSCSSTTData']", function(){ 
			var tSCSSTTDID  = $(this).val();
			var request =$.ajax({
				type:'POST',
				data:{  SCSSTTData: tSCSSTTDID, Action:"xvSCSSTTData"},
			 	dataType: 'json',
				url:'../../TimeTableInfo',
				success:function(result){
					SpecificClassSectionTimeTable(result);
					scrollPageUP(6000);
				}	
			});	 // eof AJAX
		});
		function SpecificClassSectionTimeTable(result){
			alert("SpecificClassSectionTimeTable");
			$("#ClassTimeTable").show();
			$('#ClassTimeTable').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
			    "columns": [
					 { title:	'SNo'	    ,data:"SNO"},
					 { title:	'Teacher'   ,data:"Teacher" },  
					 { title:	'Day'       ,data:"Day"},
					 { title:	'CS.Time'   ,data:"ClassStartTime"},
					 { title:	'CE.Time'   ,data:"ClassEndTime"},
		    		 { title:	'Remove'    ,data:"TTDIDNO",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="xrTTData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
		        		},
			        }
				]
			}); 
		}// EOF table FUNCTION	

    	
		$("#CSTime").datetimepicker({
			timepicker: true,
			datepicker: false,
			format: 'h:i', // formateTime
			value:  false, //visitTime() defaultTime
			hours12: true,
			step: 5	
		});
		$("#CETime").datetimepicker({
			timepicker: true,
			datepicker: false,
			format: 'h:i', // formateTime
			value:  false, //visitTime() defaultTime
			hours12: true,
			step: 5	
		});	
		var vTime = visitTime();
		function visitTime(){
			var vDate = new Date();
			var vInTime = vDate.getHours()+":"+ vDate.getMinutes();
			return 	vInTime;
		}	
		function STT(){
			$("#ClassTimeTable").hide();
		}
      	var studentPInfo = [];
      	var days = " ";
		$(document).ready(function(){
	 		$("#xTTAdd").click(function(){
				if(TTInputDataValidate()){
 	 				var TTInfo = [];
 					TTInfo = updateTTData(TTInfo);
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xTTNDATA", InputTTValues :  TTInfo},
					 	dataType: 'Json',
						url:'../../TimeTableInfo',
						success:function(result){
							TimeTable(result);
							scrollPageUP(6000);
							resetTTInputData();// RESET VALUES
						}	
					});	 // eof AJAX
				}
			});
			
			function updateTTData(ttdInfo){
				ttdInfo.push($("#Subject").val());
				ttdInfo.push($("#fApplCF").val());
				ttdInfo.push($("#Ssection").val());
				ttdInfo.push($("#totHours").val());
				ttdInfo.push($("#teacher01").val());
				ttdInfo.push($("#Days").val());
				ttdInfo.push($("#CSTime").val());
				ttdInfo.push($("#CETime").val());
		    	return ttdInfo;
			}			
			function resetTTInputData(){
 		    	$("#Days").val("");
		    	$("#CSTime").val("");
		    	$("#CETime").val("");
		    	$("#teacher01").val("");
			}			

			function TTInputDataValidate(){
				if($("#teacher01").val()==""){
					$("#teacher01").focusin();
					alert('Enter Teacher Name');
					return false;
				}else if($("#Subject").val()=="0"){
					$("#Subject").focusin();
					alert('Select Subject');
					return false;
				}else if($("#fApplCF").val()=="0"){
					$("#fApplCF").focusin();
					alert("Select Class");
					return false;
				}else if($("#Ssection").val()=="0"){
					$("#Ssection").focusin();
					alert("Enter Section");
					return false;
				}else if($("#totHours").val()==""){
					$("#totHours").focusin();
					alert("Enter Total Teaching Hours");
					return false;
				}else if($("#Days").val()==""){
					$("#Days").focusin();
					alert('Select Class on Day');
					return false;
				}else if($("#CSTime").val()==""){
					$("#CSTime").focusin();
					alert('Enter Class Start Time');
					return false;
				}else if($("#CETime").val()==""){
					$("#CETime").focusin();
					alert("Enter Class End Time");
					return false;
				}
				return true;
			}
			

			function TimeTable(result){
				$("#ClassTimeTable").show();
				$('#ClassTimeTable').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	    ,data:"SNO"},
						 { title:	'School '   ,data:"RegNo"},
						 { title:	'Class'     ,data:"Class"},  
						 { title:	'Section'   ,data:"Section"},  
						 { title:	'T.Hrs'     ,data:"THours"},  
						 { title:	'Teacher'   ,data:"Teacher" },  
						 { title:	'Subject'   ,data:"Subject"},  
						 { title:	'Day'       ,data:"Day"},
						 { title:	'CS.Time'   ,data:"ClassStart"},
						 { title:	'CE.Time'   ,data:"ClassEnd"},
			    		 { title:	'Remove'    ,data:"TTDIDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xrTTData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
			        		},
				        }
					]
				}); 
			}// EOF table FUNCTION	
			function scrollPageDown(pos){
				$("html, body").animate({
				    scrollTop: $('html, body').get(0).scrollHeight}, pos);				
			}// eof function -> function for scroll page bottom
			function scrollPageUP(pos){
				$("html, body").animate({
				    scrollTop: $('html, body').get(0).scrollHeight}, pos);	
			       var bottom = $(document).height() - $(window).height();
				$("HTML, BODY").animate({
			            scrollTop: bottom }, 1000);			
			}// eof function -> function for scroll page bottom

			$("#xTTDataView").click(function(){ 
				var ttdInfos = [];
				ttdInfos.push($("#Subject").val());
				ttdInfos.push($("#fApplCF").val());
				ttdInfos.push($("#Ssection").val());
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"xTTRDATA", InputTTRData :  ttdInfos},
				 	dataType: 'Json',
					url:'../../TimeTableInfo',
					success:function(result){
						TimeTable(result);
						scrollPageUP(6000);
					}	
				});	 // eof AJAX
			});
		   $("#Days").click(function(){
				if (days!=" "){return;}
				days=" <option selected value=0>Choose Day</option>";
			    var cDays = ['SUNDAY', 'MONDAY','TUESDAY','WEDNESSDAY','THURSDAY','FRIDAY','SATURDAY'];
		       $.each(cDays, function(index, value){
		    	   days+=" <option value='"+value +"'>"+ value+ "</option>";
		       });
		       $("#Days").html(days);
		   });

			$(document).on('click', "Button[name='xrTTData']", function(){ 
				var con = confirm("Do you really want to delete? ");
				if(con){
					var tTTDID  = $(this).val();
					var xrTTInfos = [];
					xrTTInfos = updateTTData(xrTTInfos);
					var request =$.ajax({
						type:'POST',
						data:{  TTDSNO: tTTDID, InputTTRData: xrTTInfos, Action:"xrTTDATA"},
					 	dataType: 'json',
						url:'../../TimeTableInfo',
						success:function(result){
							TimeTable(result);
							scrollPageUP(6000);
						}	
					});	 // eof AJAX
				}
			});
			function SCSSTimeTable(result){
				$("#ClassTimeTable").show();
				$('#ClassTimeTable').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	    ,data:"SNO"},
						 { title:	'Teacher'   ,data:"Teacher" },  
						 { title:	'Day'       ,data:"Day"},
						 { title:	'CS.Time'   ,data:"ClassStart"},
						 { title:	'CE.Time'   ,data:"ClassEnd"},
			    		 { title:	'Remove'    ,data:"TTDIDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xrTTData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
			        		},
				        }
					]
				}); 
			}// EOF table FUNCTION	

			$("#xTimeTable").click(function(){  
				var request =$.ajax({
					type:'POST',
					data:{ Action:"xrTimeTable"},
				 	dataType: 'json',
					url:'../../TimeTableInfo',
					success:function(result){
						alert("working");
					}	
				});	 // eof AJAX

			});

		});// document.ready eof
	</script>
</html>


