<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title> <!--  09AMIPR9371F1ZH -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
		<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
		<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		<script type="text/javascript" 	src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/popper.js/1.14.3/popper.js"></script>
		<script type="text/javascript" 	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		<script type="text/javascript" src="../../js/SMCF.js"></script>
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
		
		<link rel="stylesheet" type="text/css" 	href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" 	src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>
		
		<script type="text/javascript" 	src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"></script> 
		<link rel="stylesheet" 	href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'> 
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
		<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
	</head>
<body onload="xStdItbrInfo()">
	<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
	<div class="container">
		<form id="xfmInfo" name="SchInfo"
			action="../BooksBorrowed?Action=xBookPurchase" method="post"
			class="form-horizontal needs-validation" autocomplete="off">
			<br />
			<div class="row">
				<div class="col-sm-12 offset-sm-0">
					<div class="card" Style="Padding-top: 0px">
						<div class="card-header text-white" id="headingOne"
							style="background-color: #38ACEC">
							<ul class="nav nav-tabs card-header-tabs">
								<li class="nav-item " id="ViewUser"><a	class="nav-link active text-white "
									style="background-color: #000080" href="#"> <%=SMFixedValue.ITEM%>
										<%=SMFixedValue.LOST%> <%=SMFixedValue.INFORMATION%> </a>
								</li>
								<li class="nav-item " id="XLiTBListView"><a class="nav-link text-light" href="#"> 
									<%=SMFixedValue.View%> <%=SMFixedValue.ITEM%> <%=SMFixedValue.BORROWED%></a>
								</li>
								<li class="nav-item " id="xLTodayiTRV"><a class="nav-link text-light" href="#"> 
									<%=SMFixedValue.TODAY_REPORT_LOSTITEM%></a>
								</li>
								<li class="nav-item " id="xLiTlistView10"><a class="nav-link text-light" href="#"> 
									<%=SMFixedValue.LOSTITEMS%></a>
								</li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-12 offset-sm-0 ">
					<p class="h5  text-center">
						Fill <%=SMFixedValue.BORROWED%> <%=SMFixedValue.ITEM%> <%=SMFixedValue.RETURN%> <%=SMFixedValue.INFORMATION%>
					</p>
				</div>
			</div>
			<div class="bg-light col-sm-12 offset-sm-0 ">
				<br />
				<div class="row">
					<label for="sAdmNo"  class="h6 "><%=SMFixedValue.STUDENT%> <%=SMFixedValue.ADMISSION%> <%=SMFixedValue.NO%> </label>
					<div class=" col-sm-4 offset-sm-0 ">
						<input type="text"   class="form-control blineTl " id="sAdmNo"
						   name="sAdmNo" placeholder="Student Admission No.">
					</div>
					<label for="staticEmail" class="offset-sm-3 col-form-label h6"><%=SMFixedValue.TOTAL%> <%=SMFixedValue.LATEFEE%></label>
					<div id = "siIRifnoX1" class="col-sm-2 offset-sm-0">
		      			<input type="text" class="form-control-plaintext blinew text-info  text-center h6" id="xtLateFee"
	      			       name="xtLateFee"  value="0" readonly>
			  		</div>			
				</div>
				<br />
				<div class="row" id="xSPInfo01">
					<div class="col-sm-3 offset-sm-0">
						<P><%=SMFixedValue.Name%>: <span id="sName" class="h6"> </span></P>
					</div>
					<div class="col-sm-3 offset-sm-0">
						<P><%=SMFixedValue.COURSE%>: <span id="sCourse" class="h6"> </span>	</P>
					</div>
					<div class="col-sm-2 offset-sm-0">
						<P><%=SMFixedValue.Class%>: <span id="admClass" class="h6"> </span>	</P>
					</div>
					<div class="col-sm-2 offset-sm-0">
						<P><%=SMFixedValue.Section%>: <span id="sSection" class="h6"> </span></P>
					</div>
					<div class="col-sm-2 offset-sm-0">
						<P><%=SMFixedValue.RollNo%>	: <span id="sRollNo" class="h6"> </span></P>
					</div>
				</div>
				<br />
			</div>
			<br />
			<div id ="siIRifnoX" class=" col-sm-12 offset-sm-0 blinebl bg-light" Style="border: 1px solid">
				<br />
 				<div class="row ">
					<div class="col-sm-3 offset-sm-0">
						<label for="xSMINmae" class="h6"><%=SMFixedValue.ITEM%> <%=SMFixedValue.Code%> & <%=SMFixedValue.Name%> </label> 
						<input type="text"	class="form-control-plaintext blineTlw" id="xSMINmae" name="xSMINmae" disabled>
					</div>

					<div class="col-sm-2 offset-sm-0">
						<label for="borwDate" class="h6"><%=SMFixedValue.BORROWED%> <%=SMFixedValue.DATE%></label>
						<input type="text"	class="form-control-plaintext blineTlw" id="borwDate" name="borwDate" disabled>
					</div>
					<div class="col-sm-2 offset-sm-0">
						<label for="rItemAmt" class="h6"><%=SMFixedValue.Item%> <%=SMFixedValue.Amount%> </label>
					    <input type="text" class="form-control-plaintext blineTl" id="rItemAmt" name="rItemAmt" >
					</div>

					<div class="col-sm-2 offset-sm-0">
						<label for="itemQty" class="h6"><%=SMFixedValue.LOST%> <%=SMFixedValue.QUANTITY%>
						</label> <input type="text" class="form-control   blineTl " id="itemQty"
							name="itemQty" required pattern="[0-9]{1,5}">
					</div>
					<div class="col-sm-2 offset-sm-0">
						<label for="xLateFee" class="h6"><%=SMFixedValue.LOST_CHARGES%>
						</label> <input type="text" class="form-control   blineTl " id="xLateFee"
							name="xLateFee" required pattern="[0-9]{1,5}">
					</div>
					<div class="col-sm-1 offset-sm-0 ">
						<label for="xNSMITBLInfo" class="h6"></label>
						<button type="button" id="xNSMITBLInfo" name="xNSMITBLInfo"
						class="form-control text-light text-center h5 btn btn-secondary"
						style="background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left: 0 px">
						<%=SMFixedValue.RETURN%> </button>
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="form-row">
						<div class="col-sm-8 text-center offset-sm-2">
							<p class="text-danger"><%=session.getAttribute("Message") == null ? "" : session.getAttribute("Message")%></p>
							<%session.removeAttribute("Message");%>
							<input type="hidden" id="SmitSnoid" >
						</div>
					</div>
				</div>
			</div>
			<br />
			<div class="form-row">
				<div class="col-sm-12 offset-sm-0">
					<!--  showing data into table -->
					<div class="table-responsive " id="dIVxSMItemBList">
						<table id="xSMItemBList" class="table table-striped table-hover compact row-border"
							style="width: 100%; font-size: 12px;">
						</table>
					</div>
					<div class="table-responsive" id="dIVxSMItemRList">
						<table id="xSMItemRList" class="table table-striped table-hover compact row-border"
							style="width: 100%; font-size: 12px;">
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>
	<script type="text/javascript">
		var sportList = " ";
		function xStdItbrInfo() {
			$("#xSPInfo01").hide();
			$("#siIRifnoX").hide();
			$("#xSMItemBList").hide();
			$("#xSMItemRList").hide();
		}
		$(document).ready(function() {
			$("#sAdmNo").focusout(function() {// validate and retrieve info
				var admNo = $("#sAdmNo").val();
				if (xValidAdmissionNo(admNo)) {
					xStudentInfoRetrieve(admNo);
				}
			});
			function xValidAdmissionNo(admNo) {
				if (admNo == null || admNo == "" || admNo == "Enter Valid Admission No.") {
					$("#sAdmNo").val("Enter Valid Admission No.");
					$("#sAdmNo").focusin();
					return false;
				}
				return true;
			}
			function xStudentInfoRetrieve(admNo) {
				var request = $.ajax({
					type : 'POST',
					data : {Action : "xRSINFO",	sAdmNo : admNo	},
					dataType : 'Json',
					url : '../../StudentPInformation',
					success : function(result) {
						showAdmission(result);
					}
				}); // eof AJAX
			}
			function showAdmission(result){ 
				$.each(result, function(id, name){
					$("#xSPInfo01").show();
					$("#sName").html(name.Name);
					$("#admClass").html(name.Class);
					$("#sSection").html(name.Section);
					$("#sRollNo").html(name.RollNo);
					$("#sCourse").html(name.Course);
				})
			}

 
 			$("#xNSMITBLInfo").click(function() {
 				$("#xNSMITBLInfo").attr("disabled", true)
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"xNSMITBLInfo", SmitSnoid :$("#SmitSnoid").val(),
 	 	 				 itemQty: $("#itemQty").val(), xLateFee: $("#xLateFee").val(),
 	 	 				 xLAmount  : $("#rItemAmt").val()},
				 	dataType: 'Json',
					url:'../../SMItemLostInfo',
					success:function(result){
						$("#xLateFee").val("");
						$("#itemQty").val("");
						$("#rItemAmt").val("");
						scrollPageUP(6000);
						resetItemBorredData();
					}	
				});					
			});
			function resetItemBorredData() {
				$("#xLateFee").val("");
				$("#itemQty").val("");
				$("#rItemAmt").val("");
			}
			$("#XLiTBListView").click(function(){ 
				if(xValidAdmissionNo($("#sAdmNo").val())){ 
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"XiTBrPendInfo10", Student :  $("#sAdmNo").val()},
					 	dataType: 'Json',
						url:'../../ItemBorrowedInfo',
						success:function(result){
							$("#dIVxSMItemBList").show();
							$("#dIVxSMItemRList").hide();
 							$("#xSMItemBList").show();
 							$("#xSMItemRList").hide();
							xItemBorrowedList(result);
							scrollPageUP(6000);
							resetItemBorredData();
						}	
					});
				}						
			});
			function xItemBorrowedList(result){
				$('#xSMItemBList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	          ,data:"SNO"},
						 { title:	'Reg.No'           ,data:"RegNo"},
						 { title:	'Adm.No'          ,data:"SAdmNo"},
						 { title:	'Item Code & Name',data:"ICodeAndName" },  
						 { title:	'Issue By'        ,data:"IssueBy"},
						 { title:	'Issued Date'     ,data:"IssFromDate" },  
						 { title:	'Due Date'      ,data:"IssToDate" },  
						 { title:	'Iss.Qty'         ,data:"IssQty"},
						 { title:	'Return Date'     ,data:"RetDate" },  
			    		 { title:	'Action'          ,data:"iDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xRiTBidInfoX" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove " ><span> &#9988; </span> </button>'; 
			        		},
				        }
					]
				}); 
			}// EOF table FUNCTION	
			$("#xLTodayiTRV").click(function(){ 
				if(xValidAdmissionNo($("#sAdmNo").val())){ 
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xLTodayiTRV", Student :  $("#sAdmNo").val()},
					 	dataType: 'Json',
						url:'../../SMItemLostInfo',
						success:function(result){
							$("#dIVxSMItemBList").hide();
							$("#dIVxSMItemRList").show();
 							$("#xSMItemBList").hide();
 							$("#xSMItemRList").show();

							xRTodayiTLView(result);
							scrollPageUP(6000);
							resetItemBorredData();
						}	
					});
				}						
			});
			
			$("#xLiTlistView10").click(function(){ 
				if(xValidAdmissionNo($("#sAdmNo").val())){ 
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"XLiTBrInfo10", Student :  $("#sAdmNo").val()},
					 	dataType: 'Json',
						url:'../../SMItemLostInfo',
						success:function(result){
							$("#dIVxSMItemBList").hide();
							$("#dIVxSMItemRList").show();
 							$("#xSMItemBList").hide();
 							$("#xSMItemRList").show();

							xRTodayiTLView(result);
							scrollPageUP(6000);
							resetItemBorredData();
						}	
					});
				}						
			});
			
			function xRTodayiTLView(result){
				$('#xSMItemRList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	          ,data:"SNO"}         ,
						 { title:	'Reg.No'          ,data:"RegNo"}       ,
						 { title:	'Adm.No'          ,data:"SAdmNo"}      ,
						 { title:	'Item Code & Name',data:"ICodeAndName"},  
						 { title:	'Due Date'        ,data:"IssToDate" }  ,  
						 { title:	'Issued Date'     ,data:"IssFromDate"} ,  
						 { title:	'Recieved By'     ,data:"RecordedBy"}     ,
						 { title:	'Return Qty'      ,data:"LostQty"}      ,
						 { title:	'Return Date'     ,data:"LostDate" }  
					]
				}); 
			}// EOF table FUNCTION	

			$(document).on('click',	"Button[name='xRiTBidInfoX']", function() {
				if(xValidAdmissionNo($("#sAdmNo").val())){ 
	 				$("#xNSMITBRetI").attr("disabled", false);
	 				$("#SmitSnoid").val($(this).val());
					var request = $.ajax({
						type : 'POST',
						data : {Action : "xRiTBidInfoX", CodeId : $(this).val(), Student : $("#sAdmNo").val()},
						dataType : 'Json',
						url:'../../ItemBorrowedInfo',
						success : function(result) {
							$.each(result, function(id, name) {
								$("#siIRifnoX").show();
								$("#xSMICode").val(name.ICode);
								$("#xSMINmae").val(name.ICodeAndName);
								$("#borwDate").val(name.IssFromDate);
								$("#rDueDate").val(name.IssToDate);
								$("#itemQty").val(name.IssQty);
							});
						}
					});
				} //eof if
			});// on click button 
		});// eof doucment
	</script>
</body>
</html>