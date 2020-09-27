<%@page import="com.rao.System.MaintWork.MaintConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../css/Custom.css" type="text/css">
	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>

 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

 
	<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
 
 
 	</head>
	<body>
		<!-- Page Header -->
			<jsp:include page="../HeaderPage.jsp"></jsp:include>
		<!-- Page Body -->
			<jsp:include page="../ContactUs/ContactUsHeader.jsp"></jsp:include>

		<br />
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../MainMWorkPage" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center">
					<div class="col-sm-12">
						<div class="row">
							<div class = "card-group">
							  	<div class="col-sm-4">
							  		<div class="card-header text-center text-dark">
							      		<h4> Life at KBS Technologies</h4>
							  		</div>
							  		<div class="card-body text-center " >
						        		<a href="../ContactUs/GeneralEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
							    	</div>
							  	</div>
							  	<div class="col-sm-4">
							  		<div class="card-header text-center text-dark">
							      		<h4> What we Do</h4>
							  		</div>
							  		<div class="card-body text-center " >
						        		<a href="../ContactUs/GeneralEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
							    	</div>
							  	</div>
							  	<div class="col-sm-4">
							  		<div class="card-header text-center text-dark">
							      		<h4> KBS Location</h4>
							  		</div>
							  		<div class="card-body text-center " >
						        		<a href="../ContactUs/GeneralEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
							    	</div>
							  	</div>
							</div>
						</div>
						<div class="row">
						  	<div class="col-sm-4">
						  		<div class="card-header text-center  text-dark">
						      		<h4> Future at KBS</h4>
						  		</div>
						  		<div class="card-body text-center " >
					        		<a href="../ContactUs/GeneralEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						  	<div class="col-sm-4">
						  		<div class="card-header text-center text-dark">
						      		<h4> Queries </h4>
						  		</div>
						  		<div class="card-body text-center " >
					        		<a href="../ContactUs/GeneralEnquiry.jsp" class="btn text-dark">With supporting text below as a natural lead-in to additional content.</a>
						    	</div>
						  	</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	
		<!--Footer  -->
		<jsp:include page="../Common/FooterPageKBS.jsp"></jsp:include>
		<jsp:include page="../FooterPage.jsp"></jsp:include>

	</body>
</html>




























