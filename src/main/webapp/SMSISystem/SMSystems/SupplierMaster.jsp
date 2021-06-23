<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
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
<!-- 			<link rel="stylesheet" href="../../css/custom.css" type="text/css"> -->
			<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
		
			<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>
<!-- 			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
 -->

	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="xSupMSX" name="xSupMSX" action="../../SupplierMaster?Action=xNrXSupMS" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"> <%=SMFixedValue.SUPPLIER%> <%=SMFixedValue.Master%> <%=SMFixedValue.CREATE%>  </a></li>
									<li class="nav-item " id="xRSupMSInfoX"><a class="nav-link text-light" href="#">
										<%=SMFixedValue.View%>  <%=SMFixedValue.SUPPLIER%> <%=SMFixedValue.INFORMATION%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-12 offset-sm-0 ">
						<p class ="h5  text-center">Fill <%=SMFixedValue.New%> <%=SMFixedValue.SUPPLIER%> <%=SMFixedValue.INFORMATION%>  </p>
					</div>
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<br />		
   					<div class="row">
						<div class="col-sm-5 offset-sm-0">
						    <label for="supName" class ="h6 "><%=SMFixedValue.SUPPLIER%> <%=SMFixedValue.Name%> </label>
							<input type="text" class="form-control blineTl " id="supName" name="supName" >
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="supCode" class ="h6 "><%=SMFixedValue.SUPPLIER%> <%=SMFixedValue.CODE%> </label>
							<input type="text" class="form-control blineTl " id="supCode" 	name="supCode"  >
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="Category" class ="h6 "><%=SMFixedValue.SUPPLIER%> <%=SMFixedValue.CATEGORY%>* </label>
								<select id="Category" name="Category" 	class="form-control blinew"  >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.BOOK%> <%=SMFixedValue.CATEGORY%>*</option>
							</select>
						</div>
					</div>	
					<br />
 				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<br />		
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="address" class ="h6 "><%=SMFixedValue.ADDRESS%> </label>
							<input type="text" class="form-control   blineTl" id="Address" 	name="Address" required
							pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="School Registration Address*">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="Sector" class ="h6 "><%=SMFixedValue.SECTOR_BLOCK%> </label>
							<input type="text" class="form-control   blineTl  " id="Sector" name="Sector" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="Street/Sector*" >
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="City" class ="h6 "><%=SMFixedValue.CITY%> </label>
							<input type="text" class="form-control   blineTl " id="City" 	name="City" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="City*" >
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="State" class ="h6 "><%=SMFixedValue.STATE%> </label>
							<input type="text" class="form-control   blineTl " id="State" 	name="State" required 
							pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*" >
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="country" class ="h6 "><%=SMFixedValue.COUNTRY%> </label>
							<select id="country" name="country" 	class="form-control    blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-3">
						    <label for="postalCode" class ="h6 "><%=SMFixedValue.PINCODE%> </label>
							<input type="number" class="form-control   blineTl" id="postalCode" 	name="postalCode"  
							pattern="[0-9]{6,8}" title=""placeholder="Postal Code*" >
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<br />		
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5"><%=SMFixedValue.CONTACT%> <%=SMFixedValue.INFORMATION%></p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="email" class ="h6 "><%=SMFixedValue.EMAIL%> </label>
							<input type="text" class="form-control   blineTl " id="email" name="email" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Email*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="mobileNo" class ="h6 "><%=SMFixedValue.MOBILE%> </label>
							<input type="text" class="form-control   blineTl " id="mobileNo" 	name="mobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*"  >
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="phoneNo" class ="h6 "><%=SMFixedValue.PHONE%> </label>
							<input type="text" class="form-control   blineTl  " id="phoneNo" 	name="phoneNo" 
							pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*"  
							title="enter minimum 10 digits">
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="Facebook" class ="h6 "><%=SMFixedValue.FACEBOOK%> </label>
							<input type="text" class="form-control blineTl " id="Facebook" 	name="Facebook"
							  placeholder="Facebook Link" >
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="Linkdin" class ="h6 "><%=SMFixedValue.LINKDIN%> </label>
							<input type="text" class="form-control blineTl" id="Linkdin" name="Linkdin" 
							 placeholder="Linkdin" >
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="Twitter" class ="h6 "><%=SMFixedValue.TWITTER%> </label>
							<input type="text" class="form-control blineTl" id="Twitter" 	name="Twitter" 
							 placeholder="Twitter" >
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
						<br />		
						<div class="col-sm-5 offset-sm-0">
							<p class ="h5 ">Head Office Conact Information </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="email" class ="h6 "><%=SMFixedValue.EMAIL%> </label>
							<input type="email" class="form-control   blinebl " id="HoEmail" name="HoEmail"  placeholder="Email*"
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] ">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="email" class ="h6 "><%=SMFixedValue.MOBILE%> </label>
							<input type="text" class="form-control   blinebl " id="HoMobileNo" 	name="HoMobileNo" 
							pattern="[0-9\s]{10,100}" placeholder="Mobile No (+91 XXXXXXXXXX)*" >
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="email" class ="h6 "><%=SMFixedValue.PHONE%> </label>
							<input type="text" class="form-control   blinebl  " id="HoPhoneNo" 	name="HoPhoneNo" 
							pattern="[0-9\s]{10,100}" placeholder="Phone No (+91 XXXXXXXXXX)*" title="enter minimum 10 digits" >
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="HoAddress" class ="h6 "><%=SMFixedValue.ADDRESS%> </label>
							<input type="text" class="form-control  blineTl" id="HoAddress" 	name="HoAddress"
							 title="" placeholder="Head Office Address*">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="HoSector" class ="h6 "><%=SMFixedValue.SECTOR_BLOCK%> </label>
							<input type="text" class="form-control blineTl" id="HoSector" name="HoSector" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="Street/Sector*"  >
						</div>
						<div class="col-sm-3 offset-sm-0">
						    <label for="HoCity" class ="h6 "><%=SMFixedValue.CITY%> </label>
							<input type="text" class="form-control blineTl" id="HoCity" 	name="HoCity" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="City*">
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-0">
						    <label for="HoState" class ="h6 "><%=SMFixedValue.STATE%> </label>
							<input type="text" class="form-control blineTl" id="HoState" 	name="HoState" 
							pattern="[A-Za-z0-9\s]{3,40}" title="" placeholder="State*"  >
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="athCountry" class ="h6 "><%=SMFixedValue.COUNTRY%> </label>
							<select id="athCountry" name="athCountry" 	class="form-control  blinew" required>
								<option selected value ="0">Country Name*</option>
							</select>
						</div>
						<div class="col-sm-3">
						    <label for="HOPostalCode" class ="h6 "><%=SMFixedValue.PINCODE%> </label>
							<input type="number" class="form-control blineTl" id="HOPostalCode" 	name="HOPostalCode" 
							pattern="[0-9]{8,8}" title=""placeholder="Postal Code*" >
						</div>
					</div>
					<br />					
				</div>
				<br />	
				
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
								<%session.removeAttribute("Message");%>
			    		</div>
			  		</div>
					<div class="form-row">
						<div class="col-sm-2 offset-sm-4 ">
							<button type="submit" id ="xSupMast01" name="xSupMast01" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=Information.Submit %></button>
						</div>
						<div class="col-sm-2 offset-sm-1 ">
							<button type="button" id ="xSupmastReset" name="xSupmastReset" class="form-control     text-light 
							text-center h5 btn btn-secondary" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px" ><%=Information.Reset %></button>
						</div>
					</div>
				</div>
				<hr class="bg-warning" id="inv02"/>
				<div class="form-row">
					<div class="col-sm-12 offset-sm-0" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="SupplierMasterList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$(document).ready(function(){
/* 			$("#xBkMSInfo1").click(function(){  
	 				var xSUPMSInfo = [];
	 				xSUPMSInfo = updateSuPData(xSUPMSInfo);
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"xNrSUPMS", xSbkBorrowed :  xSUPMSInfo},
				 	dataType: 'Json',
					url:'../BooksMaster',
					success:function(result){
						supplierMasterList(result);
						scrollPageUP(6000);
						resetBKMastData();
					}	
				});					
			});
			function updateSuPData(xSUPMSInfo){ 
				xBkMSInfo.push($("#supName").val());
				xBkMSInfo.push($("#supCode").val());
				xBkMSInfo.push($("#Category").val());
				xBkMSInfo.push($("#Address").val());
				xBkMSInfo.push($("#Sector").val());
				xBkMSInfo.push($("#City").val());
				xBkMSInfo.push($("#State").val());
				xBkMSInfo.push($("#country").val());
				xBkMSInfo.push($("#postalCode").val());
				xBkMSInfo.push($("#HoAddress").val());
				xBkMSInfo.push($("#HoSector").val());
				xBkMSInfo.push($("#HoCity").val());
				xBkMSInfo.push($("#HoState").val());
				xBkMSInfo.push($("#athCountry").val());
				xBkMSInfo.push($("#HOPostalCode").val());
					return xBkMSInfo;
				}
			function resetBKMastData(){ 
				$("#supName").val("");
				$("#supCode").val("");
				$("#Category").val("");
				$("#Address").val("");
				$("#Sector").val("");
				$("#City").val("");
				$("#State").val("");
				$("#country").val("");
				$("#postalCode").val("");
				$("#HoAddress").val("");
				$("#HoSector").val("");
				$("#HoCity").val("");
				$("#HoState").val("");
				$("#athCountry").val("");
				$("#HOPostalCode").val("");
			}
 */			
 			$("#xSupmastReset").click(function(){ 
				   $('#xSupMSX').prop('action', "../../SupplierMaster?Action=xNrXSupMS");
				   $("#xSupMast01").html("Submit")
 			});
 			function supplierMasterList(result){
				$('#SupplierMasterList').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {	targets: -1, className: 'dt-body-justify'	}, ],
				    "columns": [
						 { title:	'SNo'	        ,data:"SNO"},
						 { title:	'RegNo'         ,data:"RegNo"},
						 { title:	'Code'          ,data:"Code" },  
						 { title:	'Name'          ,data:"Name"},
						 { title:	'Email'         ,data:"Email"},
						 { title:	'Mobile No'     ,data:"Mobile" },  
						 { title:	'Phone No'      ,data:"Phone" }, 
						 { title:	'Category'      ,data:"Category"},
						 
						 { title:	'Address'	     ,data:"Address"},
						 { title:	'Sector/Block'   ,data:"Sector"},
						 { title:	'City'           ,data:"City" },  
						 { title:	'State'          ,data:"State"},
						 { title:	'Country'        ,data:"Country"},
						 
			    		 { title:	'Update'        ,data:"iDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xSUPMSiU" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Edit Book Information" ><span> &#8630; </span> </button>'; 
			        		},
				        },
		    		 	{ title:	'Remove'        ,data:"iDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xSUPMSiD" align="middle" value="'+data+'" class="bg-warning text-dark" data-toggle="tooltip" data-placement="right" title="Click to Remove Book Information" ><span> &#9747; </span> </button>'; 
			        		},
				        }
					]
				}); 
			}// EOF table FUNCTION	
			
			$("#xRSupMSInfoX").click(function(){  
				var request =$.ajax({
					type:'POST',
					data:{Action:"xRiSUPMSData"},
				 	dataType: 'Json',
					url:'../../SupplierMaster',
					success:function(result){
						supplierMasterList(result);
						scrollPageUP(6000);
						resetBKMastData();
					}	
				});					
			});
		   $(document).on('click', "Button[name='xSUPMSiD']", function(){ 
				var supIDNO=$(this).val();
				var request =$.ajax({
					type:'POST',
					data:{Action:"xRSUPMSiD",supMSIDNO : supIDNO },
				 	dataType: 'Json',
					url:'../../SupplierMaster',
					success:function(result){
						showBKMSDetails(result);
					}	
				});
		   	});// on click button
		   $(document).on('click', "Button[name='xSUPMSiU']", function(){ 
				var supIDNO=$(this).val();                                                  
				   $('#xSupMSX').prop('action', "../../SupplierMaster?Action=xRSUPMSiUpd&cid=" + supIDNO);
				   $("#xSupMast01").html("Update")
				var request =$.ajax({
					type:'POST',
					data:{Action:"xRSUPMSiDInfo",supMSIDNO : supIDNO },
				 	dataType: 'Json',
					url:'../../SupplierMaster',
					success:function(result){
						showSupplierDetails(result);
//						scrollPageDown(3500);
					}	
				});
		   	});// on click button

		   	function showSupplierDetails(result){
				$.each(result, function(id, name){
					$("#supName").val(name.Name); 
					$("#supCode").val(name.Code); 

 					$("#Address").val(name.Address); 
 					$("#Sector").val(name.Sector);
 					$("#City").val(name.City);
 					$("#State").val(name.State);
 					$("#postalCode").val(name.Pincode);
 					$("#country").html(" <option value='"+name.Country +"'>"+ name.Country+ "</option>")

					$("#Facebook").val(name.Facebook); 
					$("#Linkdin").val(name.Linkdin);  
					$("#Twitter").val(name.Twitter);
					
 					$("#mobileNo").val(name.Mobile);
 					$("#phoneNo").val(name.Phone);
 					$("#email").val(name.Email);
 					$("#HoMobileNo").val(name.HOMobile);
 					$("#HoPhoneNo").val(name.HOPhone);
 					$("#HoEmail").val(name.HOEmail);
 					$("#HoAddress").val(name.HOAddress);
 					$("#HoSector").val(name.HOSector);
 					$("#HoCity").val(name.HOCity);
 					$("#HoState").val(name.HOState);
 					$("#HOPostalCode").val(name.HOPincode);
 					$("#athCountry").html(" <option value='"+name.HOCountry +"'>"+ name.HOCountry+ "</option>")
 					$("#Category").html(" <option value='"+name.Category +"'>"+ name.Category+ "</option>")
				});
			 }

 		   	function scrollPageDown(pos){
				$("html, body").animate({ scrollTop: 0 }, "slow")						
/* 				$("html, body").animate({scrollTop: $('html, body').get(0).scrollHeight}, pos);				
				$("HTML, BODY").animate({scrollTop: top }, 6000);			
 */			}
			function scrollPageUP(pos){
				$("html, body").animate({
				    scrollTop: $('html, body').get(0).scrollHeight}, pos);	
			       var bottom = $(document).height() - $(window).height();
				$("HTML, BODY").animate({
			            scrollTop: bottom }, 1000);			
			}
		});// document.ready eof
	</script>
</html>
