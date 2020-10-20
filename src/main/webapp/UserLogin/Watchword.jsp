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
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
<%-- 		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us --> --%>
		<div class="container" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);">
			<form id = "watchPwd" name = "watchPwd" action="../UserLoginValidate?Action=chkP" method="post" class="form-horizontal needs-validation" autocomplete="off">
<!-- 			<form id="TNTInfo" name="TNTInfo" action="../UserLoginValidate?Action=chkP" method="post" class="form-horizontal needs-validation" autocomplete="off"> -->
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
										<br />
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
		
	});
	</script>
</html>
