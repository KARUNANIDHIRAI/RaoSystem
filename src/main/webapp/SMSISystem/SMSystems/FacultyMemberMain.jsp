
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../../css/Custom.css" type="text/css">
	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>

 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>

	<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

	<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
	<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
 
  	<script type="text/javascript" src="../../js/SMCF.js"></script>
 
 	</head>
	<body>
		<!-- Page Header -->
			<jsp:include page="../../HeaderPage.jsp"></jsp:include>
		<!-- Page Body -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../MainItemPage" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="fminfoF"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.FACULTY%> <%=SMFixedValue.INFORMATION%></a></li>
									<li class="nav-item " id="fminfoX"><a class="nav-link text-light" href="FacultyMembers.jsp">
										<%=SMFixedValue.New%>  <%=SMFixedValue.FACULTY%> <%=SMFixedValue.MEMBER%> </a></li>
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
										<label for="RegNo"><%=SMFixedValue.RegNo%> </label>
										<select id="RegNo" name="RegNo" 	class="form-control is-invalid">
										</select>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<label for="ActionType"><%=SMFixedValue.ACTION%></label>
										<select id="ActionType" name="ActionType" 	class="form-control  blinew" required>
												<option selected value ="0">Choose Action*</option>
										</select>
									</div>
								</div>
								<br />
								<br /> 	<br />
								<div class="form-row">
									<div class="col-sm-2 offset-sm-4 ">
										<p>
											<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
												style="background-color: #000080"><%=SMFixedValue.CANCEL%></a>
										</p>
									</div>
									<div class="col-sm-2 offset-sm-0">
										<button type="button" id ="submitMainItemPage" name ="submitMainItemPage" class="form-control h5 text-white text-center "
											style="background-color: #38ACEC"><%=SMFixedValue.SUBMIT%>
										</button>
									</div>
								</div>
								<hr class="bg-warning" id="inv02"/>
								<div class="form-row">
									<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
										<div class="table-responsive ">
											<table id="fmlist" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
									<div class="col-sm-6">  <!--  showing PO Item List in table -->
										<div class="table-responsive">
											<table id="fmDetailList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
										</div>
									</div>
								</div>	
							</div>
						</div><!--   end of card -->
					</div>
				</div>
			</form>
		</div>
		<br> 	
		<!--Footer  -->
		<jsp:include page="../../FooterPage.jsp"></jsp:include>
		<script type="text/javascript">
			$(document).ready(function(){		
				function xRfmListTable(result){
					$('#fmlist').dataTable({
					    destroy: true,
						"data":result,
						 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
					    "columns": [

					    	{ title:	'SNo'	    ,data:"SNO"},
							{ title:	'Teacher'   ,data:"RegNo" },  
							{ title:	'Day'       ,data:"Code"},
							{ title:	'CS.Time'   ,data:"Faculty"},
							{ title:	'CE.Time'   ,data:"Designation"},
						    { title:	'SNo'	    ,data:"Name"},
							{ title:	'Teacher'   ,data:"MobileNo" },  
							{ title:	'Day'       ,data:"Phone"},
							{ title:	'CS.Time'   ,data:"Qualification"},
							{ title:	'CE.Time'   ,data:"EmailID"},
							{ title:    'Expertise' ,data:"Expertise",
							{ title:	'Action'    ,data:"fMIDNO",
						    	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="xfmRemIDNO" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
				        		},
					        }
						]
					}); 
				}// EOF table FUNCTION	
	
				$("#xRfmList").click(function(){  
					alert("wait hai ji");
					var request =$.ajax({
						type:'POST',
						data:{ Action:"xRfmList"},
					 	dataType: 'json',
						url:'../../FacultyInformation',
						success:function(result){
							alert("working");
							xRfmListTable(result);
							scrollPageUP(6000);
						}	
					});	 // eof AJAX
				});
			});// document.ready eof
		
		</script>

	</body>
</html>




























