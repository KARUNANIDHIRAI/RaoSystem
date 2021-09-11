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

		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
		<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	 	<link rel="stylesheet" 	href='../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
		<script type="text/javascript" 	src="../../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
		<script type="text/javascript"	src="../../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
		<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
 	</head>
	<body onload="xStdInfo()">
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
 		<div class="container">
			<form id="xfmInfo" name="SchInfo" action="../../SMItemMasterOPBalQty?Action=xNOpBlrItemInfo" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"> <%=SMFixedValue.ITEM%> <%=SMFixedValue.Master%> <%=SMFixedValue.OPENBAL%>  </a></li>
									<li class="nav-item " id="xRITOPBQInfoX"><a class="nav-link text-light" href="#">
										<%=SMFixedValue.View%>  <%=SMFixedValue.OPENBAL%>  </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0 ">
						<p class ="h5  text-center">Fill <%=SMFixedValue.OPENBAL%> <%=SMFixedValue.INFORMATION%>  </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0 ">
					<br />
					<div class="row">
						<div class="col-sm-6 offset-sm-0">
						    <label for="RegNo" class ="h6 "><%=SMFixedValue.School%> </label>
							<input type="text" class="form-control blineTl" id="RegNo" name="RegNo" disabled  
							value=<%=(String)session.getAttribute("RegNo")%>>
						</div>
						<div class="col-sm-4 offset-sm-2">
						    <label for="SportCategory" class ="h6 "><%=SMFixedValue.SPORTS%> <%=SMFixedValue.ITEM%> <%=SMFixedValue.CATEGORY%>* </label>
								<select required id="SportCategory" name="SportCategory" class="form-control blineTlw" >
								<option selected value =""><%=SMFixedValue.Choose%> <%=SMFixedValue.SPORTS%> <%=SMFixedValue.CATEGORY%>*</option>
							</select>
						</div>
					</div>	
					<br />  
					<div class="row">
						<div class="col-sm-4 offset-sm-0">
						    <label for="sprtICode" class ="h6"><%=SMFixedValue.ITEM%> <%=SMFixedValue.Code%>* </label>
							<select id="sprtICode" name="sprtICode" class="form-control blineTlw" required >
								<option selected value =""><%=SMFixedValue.Choose%> <%=SMFixedValue.ITEM%> <%=SMFixedValue.CODE%>*</option>
							</select>					
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="manufYear" class ="h6"><%=SMFixedValue.MANUFACTURING_YEAR%> </label>
							<input type="text" class="form-control blineTl" id="manufYear" name="manufYear" 
							pattern="[0-9]{4,4}"  >
						</div>
 						<div class="col-sm-4 offset-sm-0">
						    <label for="sprtMake" class ="h6"><%=SMFixedValue.MAKE%> </label>
							<input type="text" class="form-control blineTl" id="sprtMake" name="sprtMake" 
							pattern="[A-Za-z0-9,-_.\s]{2,100}"  >
						</div>
					</div>	
					<br />
					<div class="row">		
 						<div class="col-sm-4 offset-sm-0">
							<label for="dor" class="form-label h6"><%=SMFixedValue.EXPIRY_DATE%></label>
							<input type="text" class="form-control blineTl" id="dor" name="dor">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="sprtItmQty" class ="h6"> <%=SMFixedValue.QUANTITY%>* </label>
							<input type="text" class="form-control blineTlw" id="sprtItmQty" 	name="sprtItmQty" 
							pattern="[0-9]{1,10}" required >
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="Unit" class ="h6 "><%=SMFixedValue.UNIT%>* </label>
								<select id="Unit" name="Unit" 	class="form-control blineTlw"  >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.UNIT%> *</option>
							</select>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="sptPrice" class ="h6"><%=SMFixedValue.PRICE%> </label>
							<input type="text" class="form-control blineTl" id="sptPrice" name="sptPrice" >
						</div>
					</div>	
					<br />
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
							<button type="submit" id ="xsportItemInfoOPBL1" name="xsportItemInfoOPBL1" 
							        class="form-control  text-light text-center h5 btn btn-secondary" 
							        style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
							        padding-left:0 px" ><%=SMFixedValue.SUBMIT %></button>
						</div>
					</div>
				</div>
				<hr class="bg-warning" id="inv02"/>
				<div class="form-row">
					<div class="col-sm-12 offset-sm-0" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="itemMasterOpBalList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	
			</form>
		</div>		
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		<script type="text/javascript">
//			var unit=" ";
			
			function xStdInfo(){
				//$("itemMasterOpBalList").hide();
			}
			$(document).ready(function(){
				$("#SportCategory").focusout(function(){ 
					var request =$.ajax({
						type:'POST',
						data:{Action:"xSprtItemsLIst", itemCategory : $("#SportCategory").val()},
					 	dataType: 'Json',
						url:'../../ItemMaster',
						success:function(result){
							var sportList = " ";
							sportList+=" <option selected value=0>Choose Item Code*</option>";
							$.each(result, function(id, name){
								sportList+=" <option value='"+name.itemCode1 +"'>"+ name.itemCode +" "+ name.itemName+ "</option>";
							});
							$("#sprtICode").html(sportList);
						}	
					});	 // eof AJAX
					
				});
			    $(document).on('click', "Button[name='xRITOPBiDN']", function(){ 
				    var itopbIxN = $(this).val();
					var con = confirm("Do you really want to delete? ");
					if(con){
						var request =$.ajax({
							type:'POST',
							data:{Action:"RmITOPBiDxIfno",opbalIDNO : itopbIxN },
						 	dataType: 'Json',
							url:'../../SMItemMasterOPBalQty',
							success:function(result){
								sMITMOpBalList(result);
								scrollPageUP(6000);
								resetBKMastData();
							}	
						});
					}
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

				$("#xRITOPBQInfoX").click(function(){ 
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xRITOPBQInfoX"},
					 	dataType: 'Json',
						url:'../../SMItemMasterOPBalQty',
						success:function(result){
							sMITMOpBalList(result);
							scrollPageUP(6000);
							resetBKMastData();
						}	
					});					
				});
				function sMITMOpBalList(result){
					//$("itemMasterOpBalList").show();
					$('#itemMasterOpBalList').dataTable({
					    destroy: true,
						"data":result,
						 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
					    "columns": [
 					    	 { title: 'SNo'	             ,data:"SNO"}     ,
							 { title: 'RegNo'            ,data:"RegNo"}   ,
							 { title: 'Item Code and Name' ,data:"CodeAndName"},
							 { title: 'Category'         ,data:"Category"},
 							 { title: 'Open.Balance'     ,data:"OpBal" }  ,  
							 { title: 'Mfg.Year'         ,data:"MfgYear"} ,  
							 { title: 'Make'             ,data:"Make"}    ,
							 { title: 'Exp.Date'         ,data:"ExpDate"} ,
 							 { title: 'Price'            ,data:"Price"}   ,   
							 { title: 'Unit'             ,data:"Unit"}    ,  
				    		 { title: 'Action'           ,data:"iDNO"     ,
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="xRITOPBiDN" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove Book Information" ><span> &#9747; </span> </button>'; 
				        		},
				    		 }
						]
					}); 
				}// EOF table FUNCTION	
			});// eof doucment			
		</script>	
	</body>
</html>