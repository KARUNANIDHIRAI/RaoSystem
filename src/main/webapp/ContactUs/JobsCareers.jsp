<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
	<link rel="stylesheet" href="css/Custom.css" type="text/css">

	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>

	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

		<script type="text/javascript" 	src="../webjars/jquery-validation/1.19.0/jquery.validate.js"></script>	
		<script type="text/javascript" 	src="../webjars/jquery-validation/1.19.0/jquery.validate.min.js"></script>
		<script type= "text/javascript" src="../webjars/bootstrap-maxlength/1.10.0/src/bootstrap-maxlength.js"></script>
		<script type= "text/javascript" src="webjars/bootstrap-maxlength/1.10.0/src/bootstrap-maxlength.js"></script>
 <script src=//cdnjs.cloudflare.com/ajax/libs/bootstrap-maxlength/1.7.0/bootstrap-maxlength.min.js></script>
	 
	  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body>
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<!-- Contact Us Header --><jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include><!-- Contact Us -->
		<div class="container">
			<form id="BusInfo" name="BusInfo" action="../ContactUs/ContactUsHeader.jsp" method="post" class="" autocomplete="off" >
				<div class="form-group">
					<label>Name:</label>
					<input type="text" name="name" class="form-control" 
						style="border-bottom: 1px solid blue;"  
						maxlength="40"     
					    data-bv-stringlength-message="The full name must be more than 10 and less than 40 characters" >
				</div>
				<input name="email" id="email" type="text" placeholder="Please enter your email" class="contact-input">
					<span class="error">Enter your email-id here</span>
		         	<span class="error" id="invalid_email">Email-id is invalid</span>


				<div class="row">		
						<div class="form-group col-sm-10 offset-sm-1">
							<label>Enter your Message*</label>
							<textarea class="form-control" maxlength="1000" rows="5" class="form-control" id="textareaMsg" 	name="textareaMsg" 
								style="border-bottom: 1px solid blue;border-top: 1px solid blue;"> </textarea>
					            <span style ="font-size:11px; color:blue">Your full message should be maximum<strong>1000 character </strong> and  <span style ="font-size:11px;color:red" id="rchars"><strong> 0 </strong></span> </span> 
					            <span style ="font-size:11px;color:blue">Character(s) Remaining </span>
						</div>
					</div>
					<br />
				<div class="form-group">
					<button type= "button" class="btn btn-success"  id="submit">Submit</button>
				</div>

			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		<script type = "text/javaScript">
		alert("wah re hindustatn");
			$(document).ready(function(){
				var enqMsg   = $("#textareaMsg").val().length;
				alert("enqMsg :"+  enqMsg);			
				$('#submit').click(function(){
					if(enqMsg <=1)	{
						alert("kindly enter your enquiry message cannot be Empty");
						return false;
					}	
				});	
			});
			</script>	
	</body>
</html>






















