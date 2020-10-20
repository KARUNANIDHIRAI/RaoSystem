<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

			<link rel="stylesheet" href="../css/Custom.css" type="text/css">
			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
	</head>
	<body onload="getRefreshCaptcha()">
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);">
			<form id="ulpwd" name="ulpwd" action="../UserLoginInfoValidate?Action=VUIRD" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />	<br /><br />                   
				
				<div class = "row" >
					<div class="card col-sm-10 offset-sm-1" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
						<div class="card-body" >
							<div class="row"><br />
								<div class="col-sm-6">
				      				<div class="card-body" >
										<div class="row">		
											<div class="col-sm-10 offset-sm-0">
												<p class ="h5 text-left">Login User Id Retrieve Instruction </p>
											</div>
										</div>
										<br />	<br />
								        <p class="card-text">
										To log on to this online account use your Web Interface -username and password as your login credentials</p><br />
										<p class="h6">User Guide:</p> <br />
										<p>Just log on to your account with the Registered EmailID as User Login ID
										  and password </p>
								        <br /> <br /><br /><br />
							      	</div>
								</div>
			 					<div class="col-sm-6">
		      						<div class="card-body" >
										<div class="row">		
											<div class="col-sm-10 offset-sm-1" >
										        <h5 class="card-title text-center">Verify your Login Authentication</h5>
											</div>
										</div>
										<br />
										<div class="row">
									   		<div class="col-sm-8 text-center offset-sm-2">
									    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
					 								<%session.removeAttribute("Message");%> 
								    		</div>
								  		</div>
								  		<div id="ulIdDiv">
											<div class="row" id ="usereml">		
												<div class="col-sm-10 offset-sm-1">
													<input type="text" class="form-control   blinebl " id="ulRID" 	name="ulRID" 
													placeholder="Enter your EmailID or Mobile No or Security Code*" required>
												</div>
											</div>
											<br /> 
											<div class="row" >
												<div class="col-sm-10 offset-sm-1">
													<input type="text" class="form-control text-center  blinebl " 
													id="ulCaptcha" name="ulCaptcha" required placeholder="Enter Captcha*"
													title="Enter Captcha" >
												</div>
	 										</div>
											<br />
											<div class=" row">
												<div class="col-sm-10 offset-sm-1">
													<input class="form-control text-center h5 text-light" id="refreshCaptcha" 
														name="refreshCaptcha" type="text" readonly placeholder="refreshCaptcha" readonly
													   style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px
													   border-top:0px;border-bottom:0px; border-left:0px;border-right:0px"
											        	data-toggle="tooltip" data-placement="top" title="Click to refresh Captcha">
												</div>
											</div>											
											<br /> <br />
											<div class="row">		
												<div class="col-sm-5 offset-sm-3">
													<button type="button" class="form-control text-light text-center h5 btn" id="UlContToOtp" 
													style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
														<%=Information.Continue %></button>
												</div>
											</div>
										</div>	
										<div id="otpDiv">
											<br />
											<div class="row" id="OTP">		
												<div class="col-sm-10 offset-sm-1">
													<input type="text" class="form-control   blinebl " id="uoptNo" 	name="uoptNo" placeholder="Enter register Email to sent OTP *" required>
												</div>
											</div>
											<br /> <br />
											<div class="row">		
												<div class="col-sm-5 offset-sm-3">
													<input type="submit" class="form-control text-light text-center h5 btn" id="ContToPwd" 
														style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"
														placeholder =<%=Information.Submit %>>
												</div>
											</div>	
										</div>
								     </div>
								</div>
							</div>				
						</div>
					</div>
				</div>
				<br />	<br /> <br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		var counter = 0;
		var capcha;
		$("#otpDiv").hide();
		$("#ulCaptcha").focusin(function(){
			if($("#ulRID").val().length<=0){
				$("#ulRID").val("Invalid ID");
				$("#ulRID").focus()
			}
		});
		$("#UlContToOtp").click(function(){
			if($("#ulCaptcha").val()!=$("#refreshCaptcha").val()){
				$("#ulCaptcha").val( " Invalid Captcha! Try Again" )
				$("#ulCaptcha").focus();
			}else{
				alert("wah retrieve user id");
				ValidateUserID();
			}	
		});
		function ValidateUserID(){
			var uLID = $("#ulRID").val();
			alert(uLID);
			var request =$.ajax({
				type:'POST',
				data:{"userID":uLID, Action:"uLRD"},
			 	dataType: 'text',
				url:'../UserLoginInfoValidate',
				success:function(result){
					if(result=="Valid"){
						$("#ulIdDiv").hide();
						$("#otpDiv").show();
						$("#uoptNo").focus();
					}else{
						$("#ulIdDiv").show();
						$("#ulRID").val(' Invalid user info');
					 }
				},	
			    error: function () {
					$("#ulRID").val("Sorry, there was technical error");
			    }
			});	 // eof AJAX
		}// eof ValidateUserEmail()		
	});
	</script>
</html>
