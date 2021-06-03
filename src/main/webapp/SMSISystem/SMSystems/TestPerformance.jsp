<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<!-- http://localhost:8080/swagger-ui/#/Brand%20V2%20APIs/setPasswordUsingPOST_1 -->
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
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>

	</head>
	<body onload="STP()">
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
										style="background-color: #000080" href="#"><%=SMFixedValue.Student%> <%=SMFixedValue.TEST%> <%=SMFixedValue.PERFORMANCE%>  </a></li>
 									<li class="nav-item " ><button type="button" class="nav-link text-white" id="xSFIR1"
									    style="background-color: #000080">
										<%=SMFixedValue.View%>  <%=SMFixedValue.PERFORMANCE%></button> </li>

 								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0">
							<p class="h5 text-center"> <%=SMFixedValue.Student%> <%=SMFixedValue.Info%> </p>
					</div>
				</div>
				<div class="card" >
					<div class="card-header  text-dark" id ="xSTPh">
						<div class="row">		
							<div class="col-sm-5 offset-sm-0  form-group">
							    <label for="regNo"><%=SMFixedValue.School%> <%=SMFixedValue.Name%> </label>
								<input type="text" class="form-control blinew " id="regNo" name="regNo" readonly >
							</div>
							<div class="col-sm-5 offset-sm-0  form-group">
							    <label for="sAdmNo"> <%=SMFixedValue.ADMISSION%> <%=SMFixedValue.NO%>  </label>
								<input type="text" class="form-control blineTl " id="sAdmNo" name="sAdmNo"  placeholder=<%=SMFixedValue.RegNo%>>
	 						</div>
							<div class="col-sm-2 offset-sm-0 ">
							    <label for="xSPIR"> </label>
								<button type="button" id ="xSPIR" name="xSPIR" class="form-control     text-light 
								text-center h5 btn bg-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=SMFixedValue.View%> </button>
							</div>
						</div>			
					</div>
					<div class="card-body  col-sm-12 offset-sm-0 " id ="xSTPb">
						<div class="row" id="xSPInfo01" >		
							<div class="col-sm-3 offset-sm-0">
								<P><%=SMFixedValue.Name%> : <span id="sName" class="h6"> </span></P>
							</div>
							<div class="col-sm-3 offset-sm-0">
								<P><%=SMFixedValue.COURSE%> : <span id="sCourse" class="h6"> </span></P>
	 						</div>
							<div class="col-sm-2 offset-sm-0">
								<P><%=SMFixedValue.Class%> : <span id="admClass" class="h6"> </span></P>
							</div>
							<div class="col-sm-2 offset-sm-0">
								<P><%=SMFixedValue.Section%> : <span id="sSection" class="h6"> </span></P>
							</div>
							<div class="col-sm-2 offset-sm-0">
								<P><%=SMFixedValue.RollNo%> : <span id="sRollNo" class="h6"> </span></P>
							</div>
						</div>
					</div>
<%-- 					
					<div class="card-footer col-sm-12 offset-sm-0 " id ="xSTPb">
						<div class="row">		
							<div class="col-sm-3 offset-sm-1  form-group">
							    <label for="testType"><%=SMFixedValue.TEST%> <%=SMFixedValue.Type%>  </label>
								<select id="testType" name="testType" class="form-control blineTl" >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.TEST_TYPE%> *</option>
									<option  		 value ="CycleTest">Cycle Test</option>
									<option 	     value ="UnitTest"> Unit Test</option>
								</select>
							</div>
							<div class="col-sm-3 offset-sm-0  form-group">
							    <label for="testCycle"><%=SMFixedValue.TEST%>  <%=SMFixedValue.TEST_CYCLE%></label>
	 							<select id="testCycle" name="testCycle" 	class="form-control blineTl "  >
									<option selected value ="0"><%=SMFixedValue.Choose%>* <%=SMFixedValue.Student%> <%=SMFixedValue.Section%>*</option>
									<option  		 value ="1">1</option>
									<option 	     value ="2">2</option>
									<option  		 value ="3">3</option>
								</select>
	 						</div>
							<div class="col-sm-3 offset-sm-0  form-group">
							    <label for="testCatg"><%=SMFixedValue.TEST%>  <%=SMFixedValue.CATEGORY%></label>
	 							<select id="testCatg" name="testCatg" 	class="form-control blineTl "  >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.CATEGORY%>*</option>
									<option  		 value ="Practial">Practial</option>
									<option 	     value ="Theory">Theory<%=SMFixedValue.Class%> *</option>
								</select>
	 						</div>
	 					</div>	
					</div>

 --%>

				</div>				
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0">
						<p class="h5"><%=SMFixedValue.TEST%> <%=SMFixedValue.PERFORMANCE%> <%=SMFixedValue.DETAILS%></p>
					</div>
				</div>
				<div class="card" id ="studentInfoList">
					<div class="card-header bg-secondary text-light" id ="xSTPh">
						<div class="row">		
							<div class="col-sm-3 offset-sm-1  form-group">
							    <label for="testType"><%=SMFixedValue.TEST%> <%=SMFixedValue.Type%>  </label>
								<select id="testType" name="testType" class="form-control blineTl" >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.TEST_TYPE%> *</option>
									<option  		 value ="CycleTest">Cycle Test</option>
									<option 	     value ="UnitTest"> Unit Test</option>
								</select>
							</div>
							<div class="col-sm-3 offset-sm-0  form-group">
							    <label for="testCycle"><%=SMFixedValue.TEST%>  <%=SMFixedValue.TEST_CYCLE%></label>
	 							<select id="testCycle" name="testCycle" 	class="form-control blineTl "  >
									<option selected value ="0"><%=SMFixedValue.Choose%>* <%=SMFixedValue.Student%> <%=SMFixedValue.Section%>*</option>
									<option  		 value ="1">1</option>
									<option 	     value ="2">2</option>
									<option  		 value ="3">3</option>
								</select>
	 						</div>
							<div class="col-sm-3 offset-sm-0  form-group">
							    <label for="testCatg"><%=SMFixedValue.TEST%>  <%=SMFixedValue.CATEGORY%></label>
	 							<select id="testCatg" name="testCatg" 	class="form-control blineTl "  >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.CATEGORY%>*</option>
									<option  		 value ="Practial">Practial</option>
									<option 	     value ="Theory">Theory<%=SMFixedValue.Class%> *</option>
								</select>
	 						</div>
							<div class="col-sm-2 offset-sm-0 ">
							    <label for="XsTPInfo01"> </label>
								<button type="button" id ="XsTPInfo01" name="XsTPInfo01" class="form-control     text-light 
								text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); 
								padding-left:0 px" ><%=SMFixedValue.View%> <%=SMFixedValue.MARKS%></button>
							</div>
	 					</div>	
					</div>
					<div class="card-body  col-sm-12 offset-sm-0 " id ="xSTPb">
						<div class="row">		
							<div class="col-sm-3 offset-sm-1  form-group">
							    <label for="Subject"><%=SMFixedValue.Subject%>  </label>
								<select id="Subject" name="Subject" class="form-control blineTl" >
									<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.Subject%> *</option>
								</select>
							</div>
							<div class="col-sm-3 offset-sm-0  form-group">
							    <label for="sMarks"><%=SMFixedValue.MARKS%> </label>
								<input type="text" class="form-control blineTl " id="sMarks" name="sMarks" >
							</div>
							<div class="col-sm-3 offset-sm-0  form-group">
							    <label for="maxMarks"><%=SMFixedValue.MAX%> <%=SMFixedValue.MARKS%> </label>
								<input type="text" class="form-control blineTl " id="maxMarks" name="maxMarks" >
							</div>
							<div class="col-sm-2 offset-sm-0 ">
							    <label for="XsTPInfo"> </label>
								<button type="button" id ="XsTPInfo" name="XsTPInfo" class="form-control     text-light 
								text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); 
								padding-left:0 px" ><%=SMFixedValue.Action%> <%=SMFixedValue.MARKS%></button>
							</div>
						</div>
					</div>
					<div class="card-footer"   id ="xSTPf">
							<p class = "h5 text-center"> Student Marks Summary </p>
						<div class="form-row">
							<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
								<div class="table-responsive ">
									<table id="StudentMarksList" class="table table-striped table-hover compact row-border" style="width:100%; font-size:14px"></table>
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
		function STP(){
			$("#studentInfoList").hide();
			$("#xSPInfo01").hide();
			$("#xSPInfo02").hide();
		}
      	var studentPInfo = [];
		$(document).ready(function(){
	 		$("#XsAttInfo").click(function(){
		    	var atdInfo = {
	                "tType"   : $("#testType").val() ,
	                "tCycle"  : $("#testCycle").val(),
	                "Category": $("#testCatg").val() ,
	   	            "subject" : $("#Subject").val()  ,
	                "tMarks"  : $("#sMarks").val()   ,
	                "mMarks"  : $("#maxMarks").val()
	            };
 				var atdInfos = [];
 				atdInfos = updateValue(atdInfos);
	            alert("My favourite input values: " + atdInfos.join("; "));
				if(subjectValidate(atdInfo)){
					rSListForAttendance(atdInfos);
				}
			});
			function updateSTPIV(InputMarksData){
				InputMarksData.push($("#testType").val());
				InputMarksData.push($("#testCycle").val());
				InputMarksData.push($("#testCatg").val());
				InputMarksData.push($("#Subject").val());
				InputMarksData.push($("#sMarks").val());
				InputMarksData.push($("#maxMarks").val());
		    	return InputMarksData;
			}			
			function resetSTPPage(){
 		    	$("#testType").val("");
		    	$("#testCycle").val("");
		    	$("#testCatg").val("");
		    	$("#Subject").val("");
		    	$("#sMarks").val("");
		    	$("#maxMarks").val("");
			}			

			function subjectValidate(atdInfo ){
				if(atdInfo.tType==""){
					$("#testType").focusin();
					alert('Enter test Type');
					return false;
				}else if(atdInfo.tCycle==""){
					$("#testCycle").focusin();
					alert('Select test Cycle');
					return false;
				}else if(atdInfo.subject==""){
					$("#Subject").focusin();
					alert("Select test subject");
					return false;
				}else if(atdInfo.tMarks==""){
					$("#sMarks").focusin();
					alert("Enter test marks obtain");
					return false;
				}else if(atdInfo.mMarks==""){
					$("#mMarks").focusin();
					alert("Enter Max.Marks");
					return false;
				}
				return true;
			}


			$("#sAdmNo").focusout(function(){// validate and retrieve info
				var admNo=$("#sAdmNo").val();
				if(xValidAdmissionNo(admNo)){
					xStudentInfoRetrieve(admNo)
				}
			});			
			$("#xSPIR").click(function(){ // validate and retrieve info
				var xAdmNo=$("#sAdmNo").val();
				if(xValidAdmissionNo(xAdmNo)){
					xStudentInfoRetrieve(xAdmNo)
				}
			});
			function xValidAdmissionNo(admNo){
				if(admNo==null || admNo=="" || admNo=="Enter Valid Admission No."){ 
					$("#sAdmNo").val("Enter Valid Admission No.");
					$("#sAdmNo").focusin();
					return false;
				}
				return true;	
			}
			function xStudentInfoRetrieve(admNo){
				var request =$.ajax({
					type:'POST',
	 				data:{Action:"xRSINFO", sAdmNo: admNo},
				 	dataType: 'Json',
					url:'../../StudentPInformation',
					success:function(result){
						$.each(result, function(id, name){
							$("#studentInfoList").show();
							$("#xSPInfo01").show();
							$("#xSPInfo02").show();
							$("#sName").html(name.Name);
							$("#admClass").html(name.Class);
							$("#sSection").html(name.Section);
							$("#sRollNo").html(name.RollNo);
							$("#sCourse").html(name.Course);
							studentPInfo.push(name.Class);
							studentPInfo.push(name.Section);
							studentPInfo.push(name.RollNo);
							resetSTPPage();
							scrollPageUP(6000);
						})
					}	
				});	 // eof AJAX
			}
			
			$("#XsTPInfo").click(function(){
				var sAdmNo=$("#sAdmNo").val();
 				var InputMarksData = [];
 				InputMarksData = updateSTPIV(InputMarksData);
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"XSTPDATA", InputMarksValues :  InputMarksData, SAdmNo : sAdmNo, SPInfo : studentPInfo},
				 	dataType: 'Json',
					url:'../../STestPerformance',
					success:function(result){
						StudentMarksList(result);
						resetSTPPage();
						scrollPageUP(6000);
					}	
				});	 // eof AJAX
			}); 
		   	
			function StudentMarksList(result){
				$('#StudentMarksList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	     ,data:"SNO"},
						 { title:	'School Code',data:"RegNo"},
						 { title:	'Test Type' ,data:"TType" },  
						 { title:	'Test Cycle',data:"TCycle"},  
						 { title:	'Test Category',data:"TCategory"},  
						 { title:	'Subject'   ,data:"Subject"},
						 { title:	'Marks'     ,data:"MarksObtained"},
						 { title:	'Max.Marks' ,data:"MaxMark"},
			    		 { title:	'Remove'    ,data:"TPIDNOFK",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xSMarksData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
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

			$("#XsTPInfo01").click(function(){ 
				var inputSTPRetData = [];
				inputSTPRetData.push($("#sAdmNo").val());
				inputSTPRetData.push($("#testType").val());
				inputSTPRetData.push($("#testCycle").val());
				inputSTPRetData.push($("#testCatg").val());
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"XSTPRDATA", InputSTPRetvData :  inputSTPRetData},
				 	dataType: 'Json',
					url:'../../STestPerformance',
					success:function(result){
						StudentMarksList(result);
						resetSTPPage();
						scrollPageUP(6000);
					}	
				});	 // eof AJAX
			});

		});// document.ready eof
	</script>
</html>


