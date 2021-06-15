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
										style="background-color: #000080" href="#"> <%=SMFixedValue.BOOK%> <%=SMFixedValue.Master%> <%=SMFixedValue.CREATE%>  </a></li>
									<li class="nav-item " id="xRBkMSInfoX"><a class="nav-link text-light" href="#">
										<%=SMFixedValue.View%>  <%=SMFixedValue.BOOK%> <%=SMFixedValue.INFORMATION%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0 ">
						<p class ="h5  text-center">Fill <%=SMFixedValue.New%> <%=SMFixedValue.BOOK%> <%=SMFixedValue.INFORMATION%>  </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0 ">
					<br />
					<div class="row">
						<div class="col-sm-5 offset-sm-0">
						    <label for="RegNo" class ="h6 "><%=SMFixedValue.School%> </label>
							<input type="text" class="form-control blinew " id="RegNo" 	name="RegNo" readonly style="border: 0px;">
						</div>
						<div class="col-sm-4 offset-sm-3">
						    <label for="Category" class ="h6 "><%=SMFixedValue.BOOK%> <%=SMFixedValue.CATEGORY%>* </label>
								<select id="Category" name="Category" 	class="form-control blineTl"  >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.BOOK%> <%=SMFixedValue.CATEGORY%>*</option>
							</select>
						</div>
					</div>	
						<br />
					<div class="row">
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkCode" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.Code%>* </label>
							<input type="text" class="form-control   blineTl " id="bkCode" 	name="bkCode"  required
							pattern="[A-Za-z0-9]" value='BK101'>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkTitle" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.TITLE%>* </label>
							<input type="text" class="form-control blineTl" id="bkTitle" name="bkTitle"
							pattern="[A-Za-z0-9,-_.\s]{2,100}" required value='JAVA REFERENCE'>
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkAuthor" class ="h6"><%=SMFixedValue.AUTHOR%>* </label>
							<input type="text" class="form-control blineTl" id="bkAuthor" name="bkAuthor" 
							pattern="[A-Za-z0-9,-_.\s]{2,100}" required value='MCGRAW HILL'>
						</div>
					</div>	
					<br />
					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="bkPubName" class ="h6"><%=SMFixedValue.PUBLICATION%> <%=SMFixedValue.Name%>*</label>
							<input type="text" class="form-control blineTl" id="bkPubName" name="bkPubName" 
							pattern="[A-Za-z0-9,-_.\s]{2,100}" required value='MICROSOFT'>
						</div>
						<div class="col-sm-2 offset-sm-0">
							<label for="bkEdition" class="form-label h6"><%=SMFixedValue.EDITION%>*</label>
							<input type="text" class="form-control blineTl" id="bkEdition" name="bkEdition" 
							pattern="[A-Za-z0-9,-_.\s]{2,100}" required value='2021'>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkISBN" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.ISBN%>* </label>
							<input type="text" class="form-control blineTl" id="bkISBN" name="bkISBN" 
							pattern="[A-Za-z0-9]" value='ISBN101'>
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkPrice" class ="h6"><%=SMFixedValue.BOOK%> <%=SMFixedValue.PRICE%>* </label>
							<input type="text" class="form-control blineTl" id="bkPrice" name="bkPrice"	pattern="[0-9]" >
						</div>
						<div class="col-sm-2 offset-sm-0">
						    <label for="bkQty" class ="h6"> <%=SMFixedValue.BOOKCOPIES%>* </label>
							<input type="text" class="form-control blineTl" id="bkQty" 	name="bkQty" 
							pattern="[0-9]{1,4}" required value='20'>
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
							<button type="button" id ="xBkMSInfo1" name="subSch01" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=SMFixedValue.SUBMIT %></button>
						</div>
					</div>
				</div>
				<hr class="bg-warning" id="inv02"/>
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="BookMasterList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		<script type="text/javascript">
			var category=" ";
			function xStdInfo(){
				$("BookMasterList").hide();
			}
			$(document).ready(function(){
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
						$("#bkCode").val(name.BookCode);
						$("#bkTitle").val(name.Title);
						$("#bkAuthor").val(name.Author);
						$("#bkISBN").val(name.ISBN);
						$("#bkPubName").val(name.Publisher);
						$("#bkEdition").val(name.Edition);
						$("#bkPrice").val(name.price);
						$("#bkQty").val(BookQty);
						$("#Category").val(Category);
					})
				}
				$("#xBkMSInfo1").click(function(){  
 	 				var xBkMSInfo = [];
 	 				alert('price' + $("#bkPrice").val() + ' , Category:' + $("#Category").val());
 	 				xBkMSInfo = updateBKMSData(xBkMSInfo);
 	 				alert('xBkMSInfo'+ xBkMSInfo.join(","));
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xNrBkMS", xSbkBorrowed :  xBkMSInfo},
					 	dataType: 'Json',
						url:'../BooksMaster',
						success:function(result){
							bookMasterList(result);
							scrollPageUP(6000);
							resetBKMastData();
						}	
					});					
				});
				function updateBKMSData(xBkMSInfo){ 
					xBkMSInfo.push($("#bkCode").val());
					xBkMSInfo.push($("#bkTitle").val());
					xBkMSInfo.push($("#bkAuthor").val());
					xBkMSInfo.push($("#bkISBN").val());
					xBkMSInfo.push($("#bkPubName").val());
					xBkMSInfo.push($("#bkEdition").val());
					xBkMSInfo.push($("#Category").val());
					xBkMSInfo.push($("#bkPrice").val());
					xBkMSInfo.push($("#bkQty").val());
 					return xBkMSInfo;
 				}
				function resetBKMastData(){ 
					$("#bkCode").val("")     ;
					$("#bkTitle").val("")    ;
					$("#bkAuthor").val("")   ;
					$("#bkISBN").val("")     ;
					$("#bkPubName").val("")  ;
					$("#bkEdition").val("")  ;
					$("#bkQty").val("")      ;
					$("#bkPrice").val("")    ;
				}
				function bookMasterList(result){
					$("BookMasterList").show();
					$('#BookMasterList').dataTable({
					    destroy: true,
						"data":result,
						 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
					    "columns": [
							 { title:	'SNo'	        ,data:"SNO"},
							 { title:	'RegNo'         ,data:"RegNo"},
							 { title:	'Book Code'     ,data:"BookCode" },  
							 { title:	'Book Titel'    ,data:"BookTitle"},
							 { title:	'Author'        ,data:"Author"},
							 { title:	'ISBN'          ,data:"ISBN" },  
							 { title:	'EDITION'       ,data:"EDITION" },  
							 { title:	'PUBLISHER'     ,data:"PUBLISHER"},
							 { title:	'Price'         ,data:"Price"},
							 { title:	'Book Copies(N)',data:"NoOfBooks"},
							 { title:	'Cagetory'      ,data:"Category"},
				    		 { title:	'Update'        ,data:"iDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="xRBKMSiU" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Edit Book Information" ><span> &#8630; </span> </button>'; 
				        		},
					        },
			    		 	{ title:	'Remove'        ,data:"iDNO",
						     	"render": function(data,type,row,meta){
						       	 	return	'<button type="button" name="xRBKMSiD" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove Book Information" ><span> &#9747; </span> </button>'; 
				        		},
					        }
						]
					}); 
				}// EOF table FUNCTION	
				
			   $(document).on('click', "Button[name='xRBKMSiU']", function(){ 
					var bookIDNO=$(this).val();
					var request =$.ajax({
						type:'POST',
						data:{Action:"xRBKMSiU",bkMSIDNO : bookIDNO },
					 	dataType: 'Json',
						url:'../BooksMaster',
						success:function(result){
							showBKMSDetails(result);
						}	
					});
			   	});// on click button
				function showBKMSDetails(result){ 
					$.each(result, function(id, name){
						$("#bkCode").val(name.BookCode);
						$("#bkTitle").val(name.BookTitle);
						$("#bkAuthor").val(name.Author);
						$("#bkISBN").val(name.ISBN);
						$("#bkPubName").val(name.PUBLISHER);
						$("#bkEdition").val(name.EDITION);
						$("#bkPrice").val(name.Price);
						$("#Category").val(name.Category);
						$("#bkQty").val(name.NoOfBooks);
//				    	 var  category=" <option value='"+name.Category +"'>"+ name.Category+ "</option>";
						$("#Category").html(" <option value='"+name.Category +"'>"+ name.Category+ "</option>")
					});
				}

				   $(document).on('click', "Button[name='xRBKMSiD']", function(){ 
						var bookIDNO=$(this).val();
						var request =$.ajax({
							type:'POST',
							data:{Action:"xRBKMSiD",bkMSIDNO : bookIDNO },
						 	dataType: 'Json',
							url:'../BooksMaster',
							success:function(result){
								showBKMSDetails(result);
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

				$("#xRBkMSInfoX").click(function(){  
					alert("xRBkMSInfoX");
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xRiBKMSData"},
					 	dataType: 'Json',
						url:'../BooksMaster',
						success:function(result){
							bookMasterList(result);
							scrollPageUP(6000);
							resetBKMastData();
						}	
					});					
				});
				   $("#Category").click(function(){
						if (category!=" "){return;}
						category=" <option selected value=0>Choose Category*</option>";
					    var cCategory = ['Computer Science', 'History','Social Science','English','Mathematics','Music','Dance', 'Home Science'];
				       $.each(cCategory, function(index, value){
				    	   category+=" <option value='"+value +"'>"+ value+ "</option>";
				       });
				       $("#Category").html(category);
				   });

				
			});// eof doucment			
		</script>	
	</body>
</html>