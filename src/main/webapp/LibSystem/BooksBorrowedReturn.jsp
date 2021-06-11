<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">
	 	<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
		<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	 	<link rel="stylesheet" 	href='../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
	 	<link rel="stylesheet" 	href='../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
		<script type="text/javascript" 	src="../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		<script type="text/javascript"	src="../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
	  	<script type="text/javascript" src="../js/SMCF.js"></script>
		<link rel="stylesheet" href="../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
		<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
 	</head>
	<body onload="xStdInfo()">
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="xfmInfo" name="SchInfo" action="../BooksBorrowedReturn?Action=xBookPurchase" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"> <%=SMFixedValue.BOOK%> <%=SMFixedValue.BORROWED%> <%=SMFixedValue.TO%> <%=SMFixedValue.STUDENT%> </a></li>
									<li class="nav-item " id="XrBKView"><a class="nav-link text-light" href="#">
										<%=SMFixedValue.View%>  <%=SMFixedValue.BOOK%> <%=SMFixedValue.BORROWED%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0 ">
						<p class ="h5  text-center">Fill <%=SMFixedValue.New%> <%=SMFixedValue.BOOK%> <%=SMFixedValue.BORROWED%> <%=SMFixedValue.INFORMATION%>  </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0 ">
					<div class="row">
						<div class="col-sm-6 offset-sm-0">
						    <label for="RegNo" class ="h6 "><%=SMFixedValue.School%> </label>
							<input type="text" class="form-control " id="RegNo" 	name="RegNo" readonly style="border: 0px;">
						</div>
					</div>	
					<div class="row">
						<div class="col-sm-4 offset-sm-0  form-group">
						    <label for="sAdmNo" class ="h6 "><%=SMFixedValue.STUDENT%> <%=SMFixedValue.ADMISSION%> <%=SMFixedValue.NO%>  </label>
							<input type="text" class="form-control blineTl " id="sAdmNo" name="sAdmNo"  placeholder="Student Admission No.">
 						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="issueByCode" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.ISSUEDBYCODE%> </label>
							<input type="text" class="form-control blineTl" id="issueByCode" name="issueByCode"  required>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="issueByName" class ="h6 "><%=SMFixedValue.BOOK%> <%=SMFixedValue.ISSUEDBYNAME%>  </label>
							<input type="text" class="form-control   blineTl " id="issueByName" 	name="issueByName" readonly>
						</div>
					</div>	
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
					<br />
				</div>	
				<br />
				<div class=" col-sm-12 offset-sm-0 blinebl" Style="border:1px solid">
					<br />
					<div class="row bg-light">		
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkCode" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.Code%> </label>
							<input type="text" class="form-control   blineTl " id="bkCode" 	name="bkCode"  required
							pattern="[A-Za-z0-9]{4,100}" title=""  value="BK101">
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="fromDate" class ="h6"><%=SMFixedValue.BORROWED%> <%=SMFixedValue.FROM_DATE%></label>
							<input type="text" class="form-control " id="fromDate" 	name="fromDate"  readonly>
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="toDate" class="form-label h6"><%=SMFixedValue.BORROWED%> <%=SMFixedValue.TO_DATE%>*</label>
							<input type="text" class="form-control " id="toDate" 	name="toDate" readonly>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkQty" class ="h6"> <%=SMFixedValue.BOOKCOPIES%> </label>
							<input type="text" class="form-control " id="bkQty" 	name="bkQty" readonly>
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="toDate" class="form-label h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.RETURN_DATE%>*</label>
							<input type="text" class="form-control   blinew " id="toDate" 	name="toDate" required>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkQty" class ="h6"> <%=SMFixedValue.LATE_FEE%></label>
							<input type="text" class="form-control   blinew " id="bkQty" 	name="bkQty"  required
							 pattern="[0-9]{1,5}" value="50">
						</div>
					</div>	
					<br />
					<div id="xbkDetail ">
						<div class="row">		
							<div class="col-sm-2 offset-sm-0">
							    <label for="bkISBN" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.ISBN%> </label>
								<input type="text" class="form-control blinebl" id="bkISBN" name="bkISBN" readonly Style="border:0px">
							</div>
							<div class="col-sm-2 offset-sm-0">
								<label for="bkEdition" class="form-label h6"><%=SMFixedValue.EDITION%>*</label>
								<input type="text" class="form-control blinebl" id="bkEdition" name="bkEdition" readonly Style="border:0px">
							</div>
							<div class="col-sm-3 offset-sm-0">
							    <label for="bkTitle" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.TITLE%> </label>
								<input type="text" class="form-control blinebl" id="bkTitle" name="bkTitle" readonly Style="border:0px">
							</div>
							<div class="col-sm-3 offset-sm-0">
							    <label for="bkAuthor" class ="h6"><%=SMFixedValue.AUTHOR%> </label>
								<input type="text" class="form-control blinebl" id="bkAuthor" name="bkAuthor" readonly Style="border:0px">
							</div>
							<div class="col-sm-2 offset-sm-0">
							    <label for="bkPubName" class ="h6"><%=SMFixedValue.PUBLICATION%> <%=SMFixedValue.Name%></label>
								<input type="text" class="form-control blinebl" id="bkPubName" name="bkPubName" readonly Style="border:0px">
							</div>
						</div>	
						<br />
 					</div>
				</div>	
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="form-row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="form-row">
						<div class="col-sm-2 offset-sm-5 ">
							<button type="submit" id ="xbkBorrowed1" name="subSch01" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=SMFixedValue.SUBMIT %></button>
						</div>
					</div>
					<br />
				</div>
				<hr class="bg-warning" id="inv02"/>
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="BookBorrowedList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		<script type="text/javascript">
			function xStdInfo(){
				$("#xSPInfo01").hide();
				$("#xbkDetail").hide();
				$("BookBorrowedList").hide();
			}
			$(document).ready(function(){
				$("#sAdmNo").focusout(function(){// validate and retrieve info
					var admNo=$("#sAdmNo").val();
					if(xValidAdmissionNo(admNo)){
						xStudentInfoRetrieve(admNo);
						//xValidAdmissionNo($("#sName").val());
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
						url:'../StudentPInformation',
						success:function(result){
							showAdmission(result);
						}	
					});	 // eof AJAX
				}
				function showAdmission(result){ 
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
				$("#bkCode").focusout(function(){ 
					var xBookCode=$("#bkCode").val();
					if(xValidBookCode(xBookCode)){
						xBookInfoRetrieve(xBookCode);
						//var xbkTitle = $("#bkTitle").val();
						//xValidBookCode(xbkTitle);
					}
				});			
				function xValidBookCode(xBookCode){
					if(xBookCode==null || xBookCode=="" || xBookCode=="Enter Valid Book Code."){ 
						$("#bkCode").val("Enter Valid Book Code.");
						$("#bkCode").focusin();
						return false;
					}
					return true;	
				}
				function xBookInfoRetrieve(xBookCode){
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xRBookInfo", xRbookCode : xBookCode},
					 	dataType: 'Json',
						url:'../BookPurchase',
						success:function(result){
							showBookInformation(result);
						}	
					});	 // eof AJAX
				}
				function showBookInformation(result){ 
					$.each(result, function(id, name){
						$("#xbkDetail").show();
						$("#bkISBN").val(name.ISBN);
						$("#bkTitle").val(name.Title);
						$("#bkAuthor").val(name.Author);
						$("#bkPubName").val(name.Publisher);
						$("#bkEdition").val(name.Edition);
						resetSTPPage();
						scrollPageUP(6000);
					})
				}
				$("#issueByCode").focusout(function(){ 
					var xBKissueBy = $("#issueByCode").val();
					if(xValidBookIssueBy(xBKissueBy)){
						xShowIssueByName(xBKissueBy);
						//xValidBookIssueBy($("#issueByName").val());
					}
				});			
				function xValidBookIssueBy(xBKissueBy){
					if(xBKissueBy==null || xBKissueBy=="" || xBKissueBy=="Enter Valid Code."){ 
						$("#issueByCode").val("Enter Valid Code.");
						$("#issueByCode").focusin();
						return false;
					}
					return true;	
				}
				function xShowIssueByName(xBKissueBy){
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xRBKIssuedBy", bkIssueedBy : xBKissueBy},
					 	dataType: 'Json',
						url:'../FacultyInformation',
						success:function(result){
							$.each(result, function(id, name){
								$("#issueByName").val(name.Name);
							})
						}	
					});	 // eof AJAX
				}
				$("#xbkBorrowed").click(function(){  
 	 				var xBKBorrowed = [];
 	 				xBKBorrowed = updateBKBorredData(xBKBorrowed);
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xNrBookBorrowed", xSbkBorrowed :  xBKBorrowed},
					 	dataType: 'Json',
						url:'../BookIssued',
						success:function(result){
							bookBorrowedList(result);
							scrollPageUP(6000);
							resetBKBorredData()
						}	
					});					
				});
				function updateBKBorredData(xBKBorrowed){ 
					xBKBorrowed.push($("#sAdmNo").val());
					xBKBorrowed.push($("#issueByCode").val());
					xBKBorrowed.push($("#issueByName").val());
					xBKBorrowed.push($("#bkCode").val());
					xBKBorrowed.push($("#bkTitle").val());
					xBKBorrowed.push($("#fromDate").val());
					xBKBorrowed.push($("#toDate").val());
					xBKBorrowed.push($("#bkQty").val());
 					return xBKBorrowed;
				}
				function resetBKBorredData(){ 
					$("#bkCode").val("")     ;
					$("#bkTitle").val("")    ;
					$("#fromDate").val("")   ;
					$("#toDate").val("")     ;
					$("#bkQty").val("")      ;
					$("#admClass").val("")   ;
					$("#sSection").val("")   ;
				}
				function bookBorrowedList(result){
					$("BookBorrowedList").show();
					$('#BookBorrowedList').dataTable({
					    destroy: true,
						"data":result,
						 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
					    "columns": [
							 { title:	'SNo'	       ,data:"SNO"},
							 { title:	'RegNo'        ,data:"RegNo"},
							 { title:	'Adm.No'       ,data:"SAdmNo"},
							 { title:	'Book Code'    ,data:"BookCode" },  
							 { title:	'Book Name'    ,data:"BookName"},
							 { title:	'Book Issue By',data:"IssuedByName"},
							 { title:	'Issued Date'  ,data:"fromDate" },  
							 { title:	'BooksCopies'  ,data:"BooksCopies"},
				    		 { title:	'Action'       ,data:"iDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="xRiBRData" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
				        		},
					        }
						]
					}); 
				}// EOF table FUNCTION	

			   $(document).on('click', "Button[name='xRiBRData']", function(){ 
					var bookIDNO=$(this).val();
					var sAdmNo = $("#sAdmNo").val();
					var request =$.ajax({
						type:'POST',
						data:{Action:"xRiBRData", CodeId:bookIDNO, AdmNumber:sAdmNo },
					 	dataType: 'Json',
						url:'../BookIssued',
						success:function(result){
							bookBorrowedList(result);
							scrollPage(6000);
						}	
					});
			   	});// on click button

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

				$("#XrBKView").click(function(){  
	 				var sAdmNo = $("#sAdmNo").val();
					var request =$.ajax({
						type:'POST',
						data:{Action : "xRiBookBorrowed", AdmNumber : sAdmNo },
					 	dataType: 'Json',
						url:'../BooksBorrowedReturn',
						success:function(result){
							bookBorrowedList(result);
							scrollPageUP(6000);
						}	
					});					
				});
			});// eof doucment			
		</script>	
	</body>
</html>