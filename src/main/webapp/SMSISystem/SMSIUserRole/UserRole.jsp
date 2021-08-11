<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.MaintWork.MaintConstant"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
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
	  	<script type="text/javascript" src="../../js/SMCF.js"></script>
		<link rel="stylesheet" href="../../css/custom.css" type="text/css">
		<link rel="stylesheet" href="../../css/SMST.css" type="text/css">
	
		<link rel="stylesheet"  type="text/css" href="../../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
		<script type="text/javascript" src="../../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript"	src="../../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>

		<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

		<script type="text/javascript" src="../../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
	  	<script type="text/javascript" src="../../js/CommonFunc.js"></script>	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../URBAccessInfo.java?Action=NewUser" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=SMFixedValue.CREATE%> <%=SMFixedValue.New%> <%=SMFixedValue.USER%> <%=SMFixedValue.LOGIN%> </a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
 								<%session.removeAttribute("Message");%> 
			    		</div>
			  		</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-5">
							<p class ="h5"><%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%> </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
						    <label for="RwaNo" class ="h6"><%=SMFixedValue.RegNo%></label>
							<input type="text" class="form-control   blineTl " id="RwaNo" 	name="RwaNo" placeholder="School Registration No*" required
							pattern="[A-Za-z0-9]{4,40}" title="Enter character between a-z or A-Z.Min 4 char" >
						</div>
						<div class="col-sm-5 offset-sm-0">
						    <label for="UserType" class ="h6"><%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%></label>
 							<select id="UserType" name="UserType" 	class="form-control  blineTl"  >
								<option selected value ="0"><%=SMFixedValue.Choose%> <%=SMFixedValue.USER%> <%=SMFixedValue.ROLE%> <%=SMFixedValue.TYPE%>*</option>
							</select>
						</div>
					</div>
					<br />
				</div>
				<br />
				<div class="bg-light col-sm-12 offset-sm-0">					
					<div class="row">		
						<div class="col-sm-5 offset-sm-5">
							<p class ="h5"><%=SMFixedValue.DETAILS%> <%=SMFixedValue.INFORMATION%> </p>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
						    <label for="Fname" class ="h6"><%=SMFixedValue.USER%> <%=SMFixedValue.FNAME%></label>
							<input type="text" class="form-control blineTl " id="Fname" name="Fname" 
							placeholder="First Name*" required>

						</div>
						<div class="col-sm-5 offset-sm-0">
						    <label for="UserType" class ="h6"><%=SMFixedValue.LNAME%></label>
							<input type="text" class="form-control   blineTl " id="Lname" 	name="Lname" placeholder="Last Name*" required>
						</div>
					</div>
					<div class="row">		
						<div class="col-sm-5 offset-sm-1">
						    <label for="mobileNo" class ="h6"><%=SMFixedValue.MOBILE%></label>
							<input type="text" class="form-control   blineTl " id="mobileNo" 	name="mobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
						</div>
						<div class="col-sm-5 offset-sm-0">
						    <label for="UserType" class ="h6"><%=SMFixedValue.EMAIL%></label>
							<input type="email" class="form-control   blineTl " id="kemail" name="kemail" required 
							pattern="[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="Login User Id[EmailId]*"
							title="Enter character between [A-Za-z09]@[A-Za-z09].[A-Za-z] " >
						</div>
					</div>
					<br /> <br />
					<div class="form-row">
						<div class="col-sm-2 offset-sm-6 ">
							<button type = "button" id ="XURRest" name="XURRest"  class="form-control text-light text-center h5 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.RESET%> </button>
						</div>
						<div class="col-sm-2 offset-sm-0 ">
							<button type = "button" id ="xNUROL10" name="xNUROL10"  class="form-control text-light text-center h5 btn"
							 style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
							 <%=SMFixedValue.Action%> <%=SMFixedValue.MEMBER%></button>
						</div>
					</div>
					<br />					
				</div>
				<br />
				<div class="form-row">
					<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
						<div class="table-responsive ">
							<table id="facultyList" 	class="table table-striped table-hover compact row-border"
						 	style="width:100%; font-size:14px"></table>
						</div>
					</div>
				</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#RwaNo").focusout(function() {
				alert("RWA");
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
			$("#kemail").click(function() {	
				var email = $("#email").val();
				if(!IsEmail(email)){
					$("#email").val(email +' Invalid email format');
					$("#email").focus();
					return;
				} 
				var request =$.ajax({
					type:'POST',
					data:{"Email":email, Action:"ValidEmail"},
				 	dataType: 'text',
					url:'../SchoolInfo',
					success:function(result){
						if(result == "Duplicate"){
							$("#email").val("Login UserID already exist");
							$("#email").focus();
						}
						else{
							$("#email").val(email);				
						}
					},	
				    error: function () {
						$("#email").val("Sorry, there was an error");
				    }				
				});	 // eof AJAX
			});// eof RwaNo
	
		 	function IsEmail(email) {
				var regex = /^([a-zA-Z0-9\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				 if(!regex.test(email)) {
					 return false;
				 }else{
				    return true;
				 }
			}
	
			function updateUrolInfoValue(InputURData){
				InputURData.push($("#RwaNo").val());
				InputURData.push($("#UserType").val());
				InputURData.push($("#Fname").val());
				InputURData.push($("#Lname").val());
				InputURData.push($("#mobileNo").val());
				InputURData.push($("#email").val());
		    	return InputURData;
			}			
			function resetURolInutValues(){
			    $("#Fname").val("");
		    	$("#Lname").val("");
		    	$("#mobileNo").val("");
		    	$("#mobileNo").val("");
			}			
	
			function uRolValidate(atdInfo){
				if(atdInfo[0]==""){
					$("#RwaNo").focusin();
					alert('Enter Valid Registration Number');
					return false;
				}else if(atdInfo[1]==""){
					$("#UserType").focusin();
					alert('Select test Cycle');
					return false;
				}else if(atdInfo[2]==""){
					$("#Fname").focusin();
					alert("Enter First Name");
					return false;
				}else if(atdInfo[3]==""){
					$("#Lname").focusin();
					alert("Enter Last Name");
					return false;
				}else if(atdInfo[4]==""){
					$("#mobileNo").focusin();
					alert("Enter Mobile Number");
					return false;
				}else if(atdInfo[5]==""){
					$("#mobileNo").focusin();
					alert("Enter Mobile Number");
					return false;
				return true;
				}
			}// EOF VALIDATION
			$("XURRest").click(function(){
				alert("knr"); 
				resetURolInutValues();
			});				
	
			$("#xNUROL10").click(function(){
				alert("New Record");
				var uRoleInfo = [];
				uRoleInfo = updateUrolInfoValue(uRoleInfo);
	            alert("My favourite input values: " + uRoleInfo.join("; "));
				if(uRolValidate(uRoleInfo)){
					alert("Wah chal Gaya");					
					var request =$.ajax({
						type:'POST',
	 	 				data:{Action:"xNRLUxInfo", uRLInputData :  uRoleInfo},
					 	dataType: 'Json',
						url:'../../URBAccessInfo',
						success:function(result){
//							SprotItemList(result);
//							scrollPageUP(6000);
							resetURolInutValues()
						}	
					});	
				}// eof of if
			});
		});
	</script>
</html>
