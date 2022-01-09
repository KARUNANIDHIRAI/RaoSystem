  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>

			<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
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
	<body >
		<!-- Page Header -->
			<jsp:include page="../../HeaderPage.jsp"></jsp:include>
		<!-- Page Body -->
		<div class="container">
			<form id="xfmMainPage" name="xfmMainPage" action="../FacultyMemeberMain" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="fminfoF"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.STUDENT%> <%=SMFixedValue.PERSONAL%> <%=SMFixedValue.INFORMATION%></a></li>
									<li class="nav-item " id="fminfoX"><a class="nav-link text-light" href="FacultyMembers.jsp">
										<%=SMFixedValue.New%>  <%=SMFixedValue.STUDENT%>  </a></li>
								</ul>
							</div>
							<div class="card-body text-dark h6">
		 						<div class="row" > 
									<div class="col-sm-12 offset-sm-0 bg-light " >
										<br />
		 								<div class="row">	
											<div class="col-sm-4 offset-sm-2">
												<label for="RegNo"><%=SMFixedValue.RegNo%> </label>
												<select id="RegNo" name="RegNo" 	class="form-control is-invalid">
												</select>
											</div>
											<div class="col-sm-4 offset-sm-0">
												<label for="studentSearchType"><%=SMFixedValue.ACTION%></label>
												<select id="studentSearchType" name="studentSearchType" class="form-control  blinew" >
														<option selected value ="0">Choose Action*</option>
												</select>
											</div>
										</div>
										<br />
									</div>
								</div>	
								<br />							
		 						<div class="row" id="xsAdmNo"> 
									<div class="col-sm-12 offset-sm-0 bg-light " >
										<br />							
		 								<div class="row">	
											<div class="col-sm-6 offset-sm-3">
												<label for="admNo" class="form-label h6"><%=SMFixedValue.ADMISSION%> <%=SMFixedValue.NO%>*</label>
												<input type="text" class="form-control   blineTl " id="admNo" 	name="admNo" 
													 title=<%=SMFixedValue.STUDENT%> <%=SMFixedValue.ADMISSION%> <%=SMFixedValue.NO%>	>
											</div>
										</div>
										<br />
									</div>
								</div>	
		 						<div class="row" id="xsClass"> 
									<div class="col-sm-12 offset-sm-0 bg-light " >
										<br />							
		 								<div class="row">	
											<div class="col-sm-4 offset-sm-1">
												<label for="sClassF" class="h6"><%=SMFixedValue.CLASS%> <%=SMFixedValue.From%></label>
												<select id="sClassF" name="sClassF" class="form-control  blinew" required>
														<option selected value ="0"><%=SMFixedValue.SELECT%> <%=SMFixedValue.STUDENT%> <%=SMFixedValue.CLASS%>*</option>
												</select>
											</div>
											<div class="col-sm-4 offset-sm-0">
												<label for="sClassT" class="h6"><%=SMFixedValue.CLASS%> <%=SMFixedValue.TO%></label>
												<select id="sClassT" name="sClassT" class="form-control  blinew" required>
														<option selected value ="0"><%=SMFixedValue.SELECT%> <%=SMFixedValue.CLASS%>*</option>
												</select>
											</div>
											<div class="col-sm-2 offset-sm-0">
												<label for="sadmInSection" class="h6"><%=SMFixedValue.SECTION%> </label>
												<select id="sadmInSection" name="sadmInSection" class="form-control  blinew" required>
														<option selected value ="0"><%=SMFixedValue.SELECT%> <%=SMFixedValue.SECTION%>*</option>
												</select>
											</div>
										</div>
										<br />
									</div>
								</div>	
		 						<div class="row" id="xsrollNo"> 
									<div class="col-sm-12 offset-sm-0 bg-light " >
										<br />							
		 								<div class="row">	
											<div class="col-sm-4 offset-sm-1">
												<label for="rollNo" class="form-label h6"><%=SMFixedValue.RollNo%> *</label>
												<input type="text" class="form-control   blineTl " id="rollNo" 	name="rollNo" 
													 placeholder="Enter Student Roll Number" >
											</div>
											<div class="col-sm-4 offset-sm-0">
												<label for="admInClass" class="h6"><%=SMFixedValue.CLASS%> </label>
												<select id="admInClass" name="admInClass" class="form-control  blinew" required>
														<option selected value ="0"><%=SMFixedValue.SELECT%> <%=SMFixedValue.CLASS%>*</option>
												</select>
											</div>
											<div class="col-sm-2 offset-sm-0">
												<label for="admInSection" class="h6"><%=SMFixedValue.SECTION%> </label>
												<select id="admInSection" name="admInSection" class="form-control  blinew" required>
														<option selected value ="0"><%=SMFixedValue.SELECT%> <%=SMFixedValue.SECTION%>*</option>
												</select>
											</div>

										</div>
										<br />
									</div>
								</div>	
								<br />
		 						<div class="row" id="xsrollNo"> 
									<div class="col-sm-12 offset-sm-0 bg-light " >
										<div class="form-row">
											<div class="col-sm-2 offset-sm-5">
												<button type="button" onclick="xSiStudentSearch()"  class="form-control  text-light 
												text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);" >
												<%=SMFixedValue.SEARCH%> </button>
	 										</div>
										</div>
									</div>
								</div>
								<hr class="bg-warning" />
								<div class="form-row">
									<div class="col-sm-12 offset-sm-0" >  <!--  showing data into table -->
										<div class="table-responsive ">
											<table id="StudentSearchResult" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
								</div>	
							</div>
						</div><!--   end of card -->
					</div>
					<br /> <br /> <br />
				</div>
			</form>
		</div>
		<br> 	
		<!--Footer  -->
		<jsp:include page="../../FooterPage.jsp"></jsp:include>
		<script type="text/javascript">
			$("#xsrollNo").hide();
			$("#xsAdmNo").hide();
			$("#xsClass").hide();
			
			var studentSearchOption =" ";
			const studentSearch = ['Choose Search Option', 'All Class', 'Specific Class and section', 'Admission Number', 'Roll No NUmber'];
			const studentSrchShowHide = ["#StdSrch0", "#All Class", "#xsClass", "#xsAdmNo", '#xsrollNo'];

			function populateStudentSearchType(){ 
//				if(studentSearchOption!=" "){return;}
					studentSearchOption="";
			       $.each(studentSearch, function(index, value){
			    	   studentSearchOption+=" <option value='"+index +"'>"+ value+ "</option>";
			       });
			       $("#studentSearchType").html(studentSearchOption);
			}

			function xSiStudentSearch(){ 
				studentListForAllClass();				
			}			
			function studentListForAllClass(){ 
				var request =$.ajax({
					type:'GET',
					data:{},
				 	dataType: 'Json',
					url:'http://localhost:8088/smsi/sInformation/StudentInfoFAC',
					success:function(result){
						alert("knrai2");
						studentlistFAC(result.data);
					}	
				});	 // eof AJAX
			}
			function studentlistFAC(result){
				$('#StudentSearchResult').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	        ,data:"id",
					          "render": function (data, type, row, meta) {
						                return meta.row + meta.settings._iDisplayStart + 1; },
						 },
						 { title:	'Reg.No.'   ,data:"regNo"}     ,
						 { title:	'FName'     ,data:"firstName"} ,  
						 { title:	'LName'     ,data:"lastName"}  ,  
						 { title:	'Adm.No.'   ,data:"admNo"}     ,  
						 { title:	'Adm.Date'  ,data:"admDate"}   ,
						 { title:	'Class'     ,data:"admInClass"},
						 { title:	'Section'   ,data:"admInSection"}   ,
						 { title:	'Roll No.'  ,data:"rollNo"}    ,
					     { title:	'Course'    ,data:"streamName"},  
						 { title:	'Action'    ,data:"admNo"     ,
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xfmRemIDNO" align="middle" value="'+data+'" class="bg-primary text-Light" data-toggle="tooltip" data-placement="right" title="Click to View " ><span> &#128065; </span> </button>'; 
			        		},
				        },
						{ title:	'Action'    ,data:"admNo"     ,
						   	"render": function(data,type,row,meta){
						   	 	return	'<button type="button" name="xfmRemIDNO" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Update " ><span> &#9997; </span> </button>'; 
				        	},
					    },
						{ title:	'Action'    ,data:"admNo"     ,
						   	"render": function(data,type,row,meta){
						   	 	return	'<button type="button" name="xfmRemIDNO" align="middle" value="'+data+'" class="bg-danger text-light" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
				        	},
					    }
					]
				}); 
			}// EOF table FUNCTION	
			function xRfmListActionTable(result){
				$('#fmlist').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	       ,data:"SNo"},
						 { title:	'Academic '    ,data:"RegNo"},
						 { title:	'Faculty Code' ,data:"Code" },  
						 { title:	'Faculty Name' ,data:"Faculty"},  
						 { title:	'Designation'  ,data:"Designation"},  
						 { title:	'Name'         ,data:"Name"},
						 { title:	'Mobile No'    ,data:"MobileNo"},
						 { title:	'Phone'        ,data:"Phone"},
 						     { title:	'Qualification',data:"Qualification"},  
						 { title:	'Email'        ,data:"EmailID"},
						 { title:	'Expertise'    ,data:"Expertise"},
						 { title:	'Action'       ,data:"fMIDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xfmRemIDNO" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
			        		},
				         },
						 { title:	''       ,data:"fMIDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="xfmUPDIDNO" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Update Information. " ><span>&#9734;</span> </button>'; 
				        		},
					     }
					]
				}); 
			}// EOF table FUNCTION	
			function studentSrchDivShowHide(indx){
				for(var i=1; i<studentSrchShowHide.length ;i++){
					i==indx?$(studentSrchShowHide[i]).show():$(studentSrchShowHide[i]).hide();
				}
			}
			$(document).ready(function(){
				$("#studentSearchType").click(function(){
					populateStudentSearchType();
				});
				$("#studentSearchType").change(function(){
					var srchTypeIndx = parseInt($("#studentSearchType").val());
				    studentSrchDivShowHide(srchTypeIndx);
				});
				$("#knstudentSearchType").click(function(){
				    alert("jaiho");
				    studentListForAllClass();
				});
			
				$(document).on('click', "Button[name='xfmRemIDNO']", function(){ 
					var con = confirm("Do you really want to delete? ");
					if(con){
						var fmxUPDMID  = $(this).val();
						var request =$.ajax({
							type:'POST',
							data:{ Action:"xRfmIDNO",fmIDNOU: fmxUPDMID},
						 	dataType: 'json',
							url:'../../FacultyInformation',
							success:function(result){
								xRfmListActionTable(result);
								scrollPageUP(6000);
							}	
						});	
					}// eof if
				});// onclick sfmremidno
				$(document).on('click', "Button[name='xfmUPDIDNO']", function(){ 
					var con = confirm("Do you really want to Update? ");
					if(con){
						var xUfmIDNO  = $(this).val();
						var request =$.ajax({
							type:'POST',
							data:{ Action:"xUfmIDNO",fmIDNOU: xUfmIDNO},
						 	dataType: 'json',
							url:'../../FacultyInformation',
							success:function(result){
								xRfmListActionTable(result);
								scrollPageUP(6000);
							}	
						});	
					}// eof if
				});// onclick xfmUPDIDNO
			});// document.ready eof
		
		</script>

	</body>
</html>




























                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       