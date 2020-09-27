<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
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
		 
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body>
							<div class="form-group row">
									<label class="col-sm-2 col-form-label"></label>
									<p>
										<a class="btn btn-primary" data-toggle="collapse" href="#collapseRAORegAdd" role="button" aria-expanded="false" aria-controls="collapseRAORegAdd"> Address[+] </a>
										<button class="btn btn-primary " type="button" data-toggle="collapse" data-target="#collapseRAORegAuth" aria-expanded="false" aria-controls="collapseRAORegAuth"> <%= Information.RAORegAuthority%>[+] </button>
										<button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="collapseRAORegAuth collapseRAORegAdd">Toggle All[+]</button>
									
									</p>
								</div>

								<div class="collapse multi-collapse show" id="collapseRAORegAdd">
									<div class="form-group row">    
					 				 	<div class="col-sm-2">
											<label class="col-form-label form-control-sm"><%= Information.Address%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOoffAdd" name="RAOoffAdd" placeholder=<%= Information.Address%> autocomplete="off" >
										</div>
					 				 	<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.Block%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOOffBlock" name="RAOOffBlock" placeholder=<%= Information.Block%> autocomplete="off" >
										</div>
					 				 	<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.Sector%></label>
										</div>
										<div class="col-sm-2">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOOffSector" name="RAOOffSector" placeholder=<%= Information.Sector%> autocomplete="off" >
										</div>
									</div>	
						</div>
	</body>
</html>