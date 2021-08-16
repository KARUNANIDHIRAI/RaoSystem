<%@page import="com.raoSystem.constants.Information"%>
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
	<body>
	
		<!-- Page Header --><jsp:include page="../../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);">
			<form id="TNTInfo" name="TNTInfo" action="../../UserLoginSMSI?Action=Action" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />	
				<div class = "row" >
					<p class ="h5 col-sm-4 offset-sm-5">Academic ERP System  </p>
				</div>

				<div class = "row" >
					<div class="card col-sm-10 offset-sm-1" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px">
						<div class="card-body" >
							<div class="row"><br />
								<div class="col-sm-6">
				      				<div class="card-body" >
										<div class="row">		
											<div class="col-sm-10 offset-sm-0">
												<p class ="h5 text-left">Login Instruction </p>
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
										        <h5 class="card-title text-center"  ><%=Information.loginPage2%></h5>
											</div>
										</div>
										<br />
										<div class="row">
									   		<div class="col-sm-8 text-center offset-sm-2">
									    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
					 								<%session.removeAttribute("Message");%> 
								    		</div>
								  		</div>
										<div class="row">		
											<div class="col-sm-10 offset-sm-1">
												<input type="text" class="form-control   blinebl " id="email" 	name="email" placeholder="User Login ID*" required>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-10 offset-sm-1 text-right">
												<p Style ="font-size: 12px"><a href="../UserLogin/UserLoginNew.jsp" data-toggle="tooltip" title="click for Registertion"><%=Information.FirstTimeUser %> <%= Information.RegisterNow%></a> </p>						
											</div>
										</div>	
										<div class="row">		
											<div class="col-sm-10 offset-sm-1">
												<input type="password" class="form-control   blinebl " id="Pwd" 	name="Pwd" placeholder="Login Password*" required>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-10 offset-sm-1 text-right">
												<p Style ="font-size: 12px">	<a href="../UserLogin/UserLoginPwdReset.jsp" data-toggle="tooltip" title="click to Reset Password"><%= Information.forgetpwd%></a></p>						
											</div>
										</div>	
										<div class="row">
											<div class="col-sm-10 offset-sm-1">
												<input type="text" class="form-control text-center  blinebl " 
												id="Captcha" name="Captcha" required placeholder="Enter Captcha*"
												title="Enter Captcha" >
											</div>
										</div>
										<br />
										<div class=" row">
											<div class="col-sm-10 offset-sm-1">
												<input class="form-control text-center h5" id="refreshCaptcha" 
													name="refreshCaptcha" type="button" readonly placeholder="Captcha"
												   style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px
												   border-top:0px;border-bottom:0px; border-left:0px;border-right:0px"
										        	data-toggle="tooltip" data-placement="top" title="Click to refresh Captcha">
											</div>
										</div>											
										<br /><br />
										<div class="row">		
											<div class="col-sm-4 offset-sm-2 ">
												<button type="button" id ="xSmSiRest01" name="xSmSiRest01" class="form-control  text-light 
												text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=Information.Reset%></button>
											</div>
											<div class="col-sm-4 offset-sm-0 ">
												<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
												text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=Information.Submit %></button>
											</div>
										</div>
								     </div>
								</div>
							</div>				
						</div>
					</div>
				</div>
				<br />	<br /> 
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$(document).ready(function(){
			getRefreshCaptcha();
 		$("#Captcha").focusout(function(){
			var captcha=$("#Captcha").val();
			var lcaptcha=$("#refreshCaptcha").val();
			if(captcha!=lcaptcha){
				$("#Captcha").val( " Invalid Captcha! Try Again" )
				$("#Captcha").focus();
			}
		});
 		$(function () {
			  $('[data-toggle="tooltip"]').tooltip()
		})				
		$("#refreshCaptcha").click(function(){
			getRefreshCaptcha();
		});		
		function getRefreshCaptcha(){
			var request =$.ajax({
				type:'POST',
				data:{Action:"refreshCaptcha"},
			 	dataType: 'text',
				url:'../../UserLoginSMSI',
				success:function(result){
					$("#refreshCaptcha").val(result);
				}	
			});	 // eof AJAX
		}
		$("#xSmSiRest01").click(function(){
			$("#email").val("");
			$("#Pwd").val("");
			$("#Captcha").val("");
			  
		});
	});
	</script>
</html>
