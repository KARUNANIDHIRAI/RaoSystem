<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href='../../webjars/jquery-ui/1.12.1/jquery-ui.css'>

		<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.css'>
	 	<link rel="stylesheet" 	href='../../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

		<script type="text/javascript" 	src="../../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" 	src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
	
	 	<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.min.js"></script>
		<script type="text/javascript" src="../../webjars/popper.js/1.14.3/popper.js"></script>
		<link rel="stylesheet" href="../../css/custom.css" type="text/css">
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
<!-- 	<script type="text/javascript" src="../../js/CommonFunc.js"></script> -->
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container">
			<form id="xURLINFOX10" name="xURLINFOX10" action="../URBAccessInfo.java?Action=NewUser" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.USER%> <%=SMFixedValue.LOGIN%> </a></li>
									<li class="nav-item " id="iX3UserRolelist"><a class="nav-link text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.View%> <%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%> <%=SMFixedValue.Summary%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">		
					<div class="col-sm-5 offset-sm-5">
						<p class ="h5"><%=SMFixedValue.USER%> <%=SMFixedValue.LOGIN%> <%=SMFixedValue.INFORMATION%></p>
					</div>
					<div class="col-sm-2 offset-sm-0 ">
						<button type = "button" id ="xNUROL10" name="xNUROL10"  class="form-control text-light text-center h5 btn"
						 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
						 <%=SMFixedValue.Action%> <%=SMFixedValue.USER%></button>
					</div>				
				</div>
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
 								<%session.removeAttribute("Message");%> 
			    		</div>
			  		</div>
<%-- 					<div class="row">		
						<div class="col-sm-5 offset-sm-4">
							<p class ="h5"><%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%> </p>
						</div>
					</div>
 --%>					<div class="row">		
						<div class="col-sm-4 offset-sm-0">
						    <label for="RwaNo" class ="h6"><%=SMFixedValue.RegNo%></label>
							<input type="text" class="form-control   blineTl " id="RwaNo" 	name="RwaNo" placeholder="School Registration No*" required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char" >
						</div>
						<div class="col-sm-4 offset-sm-0">
  						    <label for="UserTypeX" class ="h6"><%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%></label>
 							<select id="UserTypeX" name="UserTypeX" 	class="form-control  blineTl" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%> <%=SMFixedValue.TYPE%>*</option>
							</select>
 						</div>
						<div class="col-sm-4 offset-sm-0 form-check" >
  						    <label for="UserTypeGRP" class ="h6"><%=SMFixedValue.USER%> <%=SMFixedValue.CATEGORY%></label>
 							<select id="UserTypeGRP" name="UserTypeGRP" 	class="form-control  blineTl" >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.USER%> <%=SMFixedValue.CATEGORY%> <%=SMFixedValue.TYPE%>*</option>
							</select>
						 </div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<div class="row">		
						<div class="col-sm-5 offset-sm-4">
							<p class ="h5"><%=SMFixedValue.USER%> <%=SMFixedValue.CREDENTIALS%> </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
  						    <label for="xUserID" class ="h6"><%=SMFixedValue.USER%><%=SMFixedValue.ID%></label>
							<input type="text" class="form-control   blineTl " 
							id="xUserID" name="xUserID" placeholder="User ID [employee code / Student admin No.]*" required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z / A-Z / 0-9" >
 						</div>
						<div class="col-sm-5 offset-sm-0">
						    <label for="mobileNo" class ="h6"><%=SMFixedValue.MOBILE%></label>
							<input type="text" class="form-control   blineTl " id="mobileNo" 	name="mobileNo" disabled  
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
						    <label for="Fname" class ="h6"><%=SMFixedValue.USER%> <%=SMFixedValue.Name%></label>
							<input type="text" class="form-control blineTl " id="Fname" name="Fname" 
							placeholder="First Name*" disabled >
						</div>
						<div class="col-sm-5 offset-sm-0">
						    <label for="Lname" class ="h6"><%=SMFixedValue.LNAME%></label>
							<input type="text" class="form-control   blineTl " id="Lname" 	name="Lname" placeholder="Last Name*" disabled >
						</div>
 					</div>
					<br />					
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<div class="row">		
						<div class="col-sm-5 offset-sm-4">
							<p class ="h5"> <%=SMFixedValue.LOGIN%> <%=SMFixedValue.CREDENTIALS%></p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-4 offset-sm-2">
						    <label for="xlEmail" class ="h6"> <%=SMFixedValue.LOGIN%> <%=SMFixedValue.ID%></label>
							<input type="email" class="form-control   blineTl " id="xlEmail" name="xlEmail" disabled 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Login User Id[EmailId]*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >

						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="XUPWD" class ="h6"><%=SMFixedValue.LOGIN%> <%=SMFixedValue.PASSWORD%></label>
							<input type="password" class="form-control   blineTl " id="XUPWD" 	name="XUPWD" required>
						</div>
					</div>
					<br /> 
 				</div>

				<br />
				<div class="form-row">
					<div class="col-sm-5 offset-sm-0 table-responsive" >  <!--  showing data into table -->
							<table id="xUserRoleList10" 	class="table table-striped table-hover compact row-border"
						 	style="width:100%; font-size:14px"></table>
					</div>
					<div class="col-sm-7 offset-sm-0 table-responsive ">
						<table id="xUserRoleList11" 	class="table table-striped table-hover compact row-border"
					 	style="width:100%; font-size:14px"></table>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$(document).ready(function(){
		   	$("#xUserID").focusout(function(){
				var fmCdOrStudId= $("#xUserID").val();
				if(fmCdOrStudId==""){
					$("#xUserID").focusin();
					alert('Enter Valid user ID');
				}else{xUseMemInfo(fmCdOrStudId);}	
		   		
		   	});
		   	function xUseMemInfo(fmCdOrStudId){
				var request =$.ajax({
					type:'POST',
					data:{Action : "x10RfmInformation", xCodeInfo : fmCdOrStudId },
				 	dataType: 'Json',
					url:'../../FacultyInformation',
				    success:function(result){
					    showFMSTDInformation(result)
					}				
				});	 // eof AJAX
		   	}
			function showFMSTDInformation(result){ 
				$.each(result, function(id, name){
					$("#Fname").val(name.Name)         ;
					$("#Lname").val(name.LName)        ;
					$("#mobileNo").val(name.MobileNo)  ;
					$("#xlEmail").val(name.EmailID)     ;
				});
			}
			$("#RwaNo").focusout(function() {
				var regNo = $("#RwaNo").val();
				if(regNo.length<=4){
					$("#RwaNo").focus();
					return;
				}	
				var request =$.ajax({
					type:'POST',
					data:{"RegNo":regNo, Action:"RegNo"},
				 	dataType: 'text',
					url:'../../SchoolInfo',
				    success:function(result){
					    var Action = '2';
				    	ajaxResultValidate(result, Action);
					},	
				    error: function () {
						$("#RwaNo").val("Sorry, There is an Error ");
				    }				
				});	 // eof AJAX
			});// eof RwaNo
			function ajaxResultValidate(result, Action){
				if(result == "Duplicate"){
					$("#RwaNo").val("Invalid School Registration No.");
					$("#RwaNo").focus();
				}
				return;
			}
			
			function updateUrolInfoValue(InputURData){
				InputURData.push($("#RwaNo").val());
				InputURData.push($("#UserType").val());
				InputURData.push($("#Fname").val());
				InputURData.push($("#Lname").val());
				InputURData.push($("#mobileNo").val());
				InputURData.push($("#xlEmail").val());
				InputURData.push($("#UserTypeGRP").val());
				InputURData.push($("#XUPWD").val());	
				InputURData.push($("#xUserID").val());	
		    	return InputURData;
			}			
			function resetURolInutValues(){
		    	$("#UserTypeGRP").val("");
				$("xUserID").val("");
			    $("#Fname").val("")     ;
		    	$("#Lname").val("");
		    	$("#mobileNo").val("");
		    	$("#xlEmail").val("");
		    	$("#XUPWD").val("");
			}			
	
			function uRolValidate(atdInfo){
				if(atdInfo[1]==""){
					$("#UserType").focusin();
					alert('Select User Role.');
					return false;
				}else if(atdInfo[6]==""){
					$("#UserTypeGRP").focusin();
					alert("Select User Category.");
					return false;
				}else if(atdInfo[7]==""){
					$("#XUPWD").focusin();
					alert("Enter valid Password.");
					return false;
				}else if(atdInfo[8]==""){
					$("#xUserID").focusin();
					alert("Enter Valid User ID.");
					return false;
				}
				return true;
			}// EOF VALIDATION
			$("#xNUROL10").click(function(){
				var uRoleInfo = [];
				uRoleInfo = updateUrolInfoValue(uRoleInfo);
	            alert("My favourite input values: " + uRoleInfo.join("; "));
				if(uRolValidate(uRoleInfo)){
					resetURolInutValues();
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xNRLUxInfo", uRLInputData :  uRoleInfo},
					 	dataType: 'Json',
						url:'../../URBAccessInfo',
						success:function(result){
							xUserRoleList11(result);
							$("#xNUROL10").html("Add More User");
							scrollPageUP(6000);
						}	
					});	
				}// eof of if
			});
/* 			$("#iX3UserRolelist").click(function(){ 
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"iX3UserRolelist", registrationNumber :  $("#RwaNo").val()},
				 	dataType: 'Json',
					url:'../../URBAccessInfo',
					success:function(result){
						xUserRoleList10(result);
						scrollPageUP(6000);
					}	
				});	
			});

 			function xUserRoleList10(result){
				$('#xUserRoleList10').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {targets: -1, className: 'dt-body-right'	}, ],
				    "columns": [
						 { title:	'SNO'	    ,data:"SNO"}         ,
						 { title:	'Reg No'    ,data:"Registration"},
						 { title:	'User Role' ,data:"Role"}        ,  
//						 { title:	'Name'      ,data:"UserName"}    ,
//						 { title:	'Mobile No.',data:"Mobile"}      , 
//						 { title:	'Email ID'	,data:"Email"}       , 
						 { title:	'View'	    ,data:"uRoleId"      ,
						 	"render": function(data,type,row,meta){
			    			 	return	'<button type="button" name="xUrlView10"  value="'+data+'" class="btn btn-secondary text-light btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#xf044;</span></button>'; 
			    		 	},
			    		 }
			    	]
				}); // EOF table
			}// EOF table FUNCTION	
*/			
		   	$(document).on('click', "Button[name='xUrlView10']", function(){ 
				var ItemCode=$(this).val();
				var request =$.ajax({
					type:'POST',
					data:{Action:"iX3UserRolelistID", iDURL:ItemCode},
				 	dataType: 'Json',
					url:'../../URBAccessInfo',
					success:function(result){
						xUserRoleList11(result);
						scrollPageUP(6000);
					}	
				});
		   	});// name='xUrlView10'
			function xUserRoleList11(result){
				$('#xUserRoleList11').dataTable({
				    destroy: true,
					"data":result,
					 columnDefs: [ {targets: -1, className: 'dt-body-right'	}, ],
				    "columns": [
						 { title:	'SNO'	    ,data:"SNO"}         ,
						 { title:	'Name'      ,data:"UserName"}    ,
						 { title:	'Mobile No.',data:"Mobile"}      , 
						 { title:	'Email ID'	,data:"Email"}       , 
			    		 { title:	''		  ,data:"uRoleDetailId",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="xUrlRem10"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
				        	},
				        }
					]
				}); // EOF table
			}// EOF table FUNCTION	
		   	$(document).on('click', "Button[name='xUrlRem10']", function(){ 
				var ItemCode=$(this).val();
				var request =$.ajax({
					type:'POST',
					data:{Action:"iX3UserRolelistIDD", iDDURL:ItemCode},
				 	dataType: 'Json',
					url:'../../URBAccessInfo',
					success:function(result){
						xUserRoleList11(result);
						scrollPageUP(6000);
					}	
				});
		   	});// name='xUrlView10'
		});
	</script>
</html>
