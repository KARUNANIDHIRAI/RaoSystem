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
			<form id="ulpwd" name="ulpwd" action="../UserLoginValidate?Action=chkValidity" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />	<br /><br />                   
				
				<div class = "row" >
					<div class="card col-sm-10 offset-sm-1" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
						<div class="card-body" >
							<div class="row"><br />
								<div class="col-sm-6">
				      				<div class="card-body" >
										<div class="row">		
											<div class="col-sm-10 offset-sm-0">
												<p class ="h5 text-left">Password Reset Instruction </p>
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
										        <h5 class="card-title text-center"  >Verify your Credentials</h5>
											</div>
										</div>
										<br />
										<div class="row">
									   		<div class="col-sm-8 text-center offset-sm-2">
									    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
					 								<%session.removeAttribute("Message");%> 
								    		</div>
								  		</div>
								  		<div id="emailDiv">
											<div class="row" id ="usereml">		
												<div class="col-sm-10 offset-sm-1">
													<input type="text" class="form-control   blinebl " id="email" 	name="email" placeholder="User Login ID*" required>
												</div>
											</div>
											<div class="row ">
												<div class="col-sm-10 offset-sm-1 text-right">
													<p Style ="font-size: 12px">	<a href="../UserLogin/UserLoginIDRetrive.jsp" data-toggle="tooltip" title="click to Reset Password"><%= Information.ForgetUserID%></a></p>						
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
													<input class="form-control text-center h5" id="refreshCaptcha" 
														name="refreshCaptcha" type="text" readonly placeholder="refreshCaptcha" readonly
													   style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px
													   border-top:0px;border-bottom:0px; border-left:0px;border-right:0px"
											        	data-toggle="tooltip" data-placement="top" title="Click to refresh Captcha">
												</div>
											</div>											
											<br /> <br />
											<div class="row">		
												<div class="col-sm-5 offset-sm-3">
													<button type="button" class="form-control text-light text-center h5 btn" id="ContToOtp" 
													style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
														<%=Information.Continue %></button>
												</div>
											</div>
										</div>	
										<div id="otpDiv">
											<br />
											<div class="row" id="OTP">		
												<div class="col-sm-10 offset-sm-1">
													<input type="text" class="form-control   blinebl " id="optNo" 	name="optNo" placeholder="Enter register Email to sent OTP *" required>
												</div>
											</div>
											<br /> <br />
											<div class="row">		
												<div class="col-sm-5 offset-sm-3">
													<button type="button" class="form-control text-light text-center h5 btn" id="ContToPwd" 
														style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
														<%=Information.Continue %> </button>
												</div>
											</div>	
										</div>
										<div id="pwdDiv">
											<br /> 
											<div class="row">		
												<div class="col-sm-10 offset-sm-1">
													<input type="password" class="form-control   blinebl " id="Pwd" 	name="Pwd" placeholder="Login Password*" required>
												</div>
											</div>
											<br />
											<div class="row">		
												<div class="col-sm-10 offset-sm-1">
													<input type="password" class="form-control   blinebl " id="CPwd" 	name="CPwd" placeholder="Confirmed Password*" required>
												</div>
											</div>
											<br /><br />
											<div class="row" >		
												<div class="col-sm-4 offset-sm-2 ">
													<button type="submit" id ="ULPwdPageReset" name="ULPwdPageReset" class="form-control  text-light 
													text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=Information.Cancel%></button>
												</div>
												<div class="col-sm-4 offset-sm-0 ">
													<button type="submit" id ="subULPwdReset" name="subULPwdReset" class="form-control  text-light 
													text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=Information.Submit %></button>
												</div>
											</div>
											<br /><br />
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
		$("#pwdDiv").hide();
		$("#ContToOtp").click(function(){
			if($("#ulCaptcha").val()!=$("#refreshCaptcha").val()){
				$("#ulCaptcha").val( " Invalid Captcha! Try Again" )
				$("#ulCaptcha").focus();
			}else{
				$("#emailDiv").hide();
				$("#otpDiv").show();
			}	
		});
		$("#ContToPwd").click(function(){
			$("#emailDiv").hide();
			$("#otpDiv").hide();
		});
		$("#ulCaptcha").focusout(function(){
			if($("#ulCaptcha").val()!=$("#refreshCaptcha").val()){
				$("#ulCaptcha").val( " Invalid Captcha! Try Again" );
				$("#ulCaptcha").focus();
			}
			else{
				ValidateUserEmail();
			}
		});
		function ValidateUserEmail(){
			var ulCaptcha=$("#ulCaptcha").val();
			var refreshCaptcha=$("#refreshCaptcha").val();
			var emailID = $("#email").val();
			var request =$.ajax({
				type:'POST',
				data:{"email":emailID,"ulCaptcha":ulCaptcha,"refreshCaptcha":refreshCaptcha, Action:"sentEmail"},
			 	dataType: 'text',
				url:'../UserLoginValidate',
				success:function(result){
					if(result=="Valid"){
						$("#emailDiv").hide();
						$("#otpDiv").show();
						$("#otpNo").focus();
					}else{
						$("#email").val(' Invalid Entry');
					 }
				},	
			    error: function () {
					$("#email").val("Sorry, there was technical error");
			    }
			});	 // eof AJAX
		}// eof ValidateUserEmail()		
		$("#ContToPwd").click(function(){
			alert("CHK OTP");
			var otp=$("#optNo").val();
			alert(otp);
			var emailID = $("#email").val();
			var request =$.ajax({
				type:'POST',
				data:{"email":emailID,"otpNo":otp, Action:"chkOT"},
			 	dataType: 'text',
				url:'../UserLoginValidate',
				success:function(result){
					
					if(result=="Valid OTP"){
						$("#otpDiv").hide();
						$("#pwdDiv").show();
					}else{
						$("#otpDiv").show();
						$("#otpDiv").val("Invalid OTP");
						$("#otpDiv").focus();
					 }
				},	
			    error: function () {
					$("#email").val("Sorry, there was technical error");
			    }
			});	 // eof AJAX
		});
	});
	</script>
</html>
