<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="css/Custom.css" type="text/css">
   		<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
   		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>	
		<style type="text/css">
			body{
			position:relativ;}
		    .panel-body{padding-top:3px;
		                padding-bottom:3px;}
		    .jthchkboxA{padding-top:3px;
		                padding-bottom:3px;}             
		</style>
	</head>
	<body>

		<div class="container-flucid" data-spy="affix" data-offset-top="50"> 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px"> 
	                <ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%= Information.raoHome%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reqdemo%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
	                </ul>
	        	</div>
			</div>
		</div>

		<div class="container" style="background:0,16,100"> 
			<div class="row "> 
                <div class="col-lg-7 " > 
 					<img src="images/KSB.png" class="img-responsive "/>
				</div>
				<div class="col-lg-5 text-right text-light"> 
	        	</div>
 			</div>
		</div>
		<br />



		<div class="container" > 
		   	<form id="login" name="login" action="getLoginChecking" method="post" class="form-horizontal" autocomplete="off">
				<div class="row justify-content-md-center" >
	 				<div class="col-sm-12">

		    		    <div class="card ">
							<div class="card-header bg-primary text-light text-center" style="max-height: 60px; padding-top:0px; padding-bottom:0px;" >
				    			<h5 class="card-title"><%= Information.RAORegInfo%></h5>
						  	</div>
						  	<div class="card-body">
								<br />
								<div class="form-group row">
									<div class="col-sm-2">
										<label class="col-form-label form-control-sm"><%= Information.RAORegNo%></label>
									</div>	
									<div class="col-sm-2 input-group">
				 				 		<input class="form-control form-control-sm" type ="text" id="RegNO" name="RegNO" placeholder=<%= Information.RAORegNo%> autocomplete="off" required >
										<div class="invalid-feedback">
											        Please provide a valid Registration Number.
										</div>
									</div>
									<div class="col-sm-1">
										<label class="col-form-label form-control-sm"><%= Information.fname%></label>
									</div>	
									<div class="col-sm-3">
				 				 		<input class="form-control form-control-sm" type ="text" id="RegName" name="RegName" placeholder=<%= Information.fname%> autocomplete="off" required >
									</div>
									<div class="col-sm-1">
										<label class="col-form-label form-control-sm"><%= Information.RAORegDt%></label>
									</div>	
									<div class="col-sm-3">
				 				 		<input class="form-control form-control-sm" type ="date" id="RegDt" name="RegDt" placeholder=<%= Information.RAORegDt%> autocomplete="off" required>
									</div>
								</div>
								<div class="form-group row ">
									<div class="col-sm-2">
										<label class="col-form-label form-control-sm"><%= Information.Mobile%></label>
									</div>
									<div class="col-sm-2">
				 				 		<input class="form-control form-control-sm" type ="text" id="RegMobile" name="RegMobile" placeholder=<%= Information.Mobile%> autocomplete="off" required>
									</div>
									<div class="col-sm-1">
										<label class="col-form-label form-control-sm"><%= Information.Phone%></label>
									</div>
									<div class="col-sm-3">
				 				 		<input class="form-control form-control-sm" type ="text" id="RegPhone" name="RegPhone" placeholder=<%= Information.Phone%> autocomplete="off" required>
									</div>
									<div class="col-sm-1">
										<label class="col-form-label form-control-sm"><%= Information.RAORegValidDt%></label>
									</div>
									<div class="col-sm-3">
				 				 		<input class="form-control form-control-sm" type ="date" id="RegValiditydt" name="RegValiditydt" placeholder=<%= Information.RAORegValidDt%> autocomplete="off" required>
									</div>

						        </div>
								<div class="form-group row">
									<div class="col-sm-2">
							 			<label class="col-form-label form-control-sm" ><%= Information.email%></label>
									</div>
									<div class="col-sm-4">
					 			 		<input class="form-control form-control-sm" type ="email" id="RegEmail" name="RegEmail" placeholder=<%= Information.email%> autocomplete="off" >
									</div>
								</div>
								<br />
								<div class="form-group row">
									<label class="col-sm-2 col-form-label"></label>
									<p>
										<a class="btn btn-primary" data-toggle="collapse" href="#collapseRAORegAdd" role="button" aria-expanded="false" aria-controls="collapseRAORegAdd"> Address[+] </a>
										<button class="btn btn-primary " type="button" data-toggle="collapse" data-target="#collapseRAORegAuth" aria-expanded="false" aria-controls="collapseRAORegAuth"> <%= Information.RAORegAuthority%>[+] </button>
										<button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="collapseRAORegAuth collapseRAORegAdd">Toggle All[+]</button>
									
									</p>
								</div>

								<div class="collapse multi-collapse" id="collapseRAORegAdd">
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
									<div class="form-group row">    
					 				 	<div class="col-sm-2">
											<label class="col-form-label form-control-sm"><%= Information.City%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOoffCity" name="RAOoffCity" placeholder=<%= Information.City%> autocomplete="off" >
										</div>
					 				 	<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.State%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOOffState" name="RAOOffState" placeholder=<%= Information.State%> autocomplete="off" >
										</div>
					 				 	<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.country%></label>
										</div>
										<div class="col-sm-2">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOOffCountry" name="RAOOffCountry" placeholder=<%= Information.country%> autocomplete="off" >
										</div>
									</div>	
									<div class="form-group row">    
										<div class="col-sm-2">
											<label class="col-form-label form-control-sm"><%= Information.pinCode%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAOoffPin" name="RAOoffPin" placeholder=<%= Information.pinCode%> autocomplete="off" >
										</div>
									</div>	

								</div>

<%-- 								<div class="form-group row">
				 				 	<label class="control-label col-sm-2 " ></label>
				 				 	<div class="col-sm-2">
										<button class="btn btn-info " type="button" data-toggle="collapse" data-target="#collapseRAORegAuth" aria-expanded="false" aria-controls="collapseRAORegAuth">
											    <%= Information.RAORegAuthority%>[+] 
									    </button>
										<button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="collapseRAORegAuth collapseRAORegAdd">Toggle All[+]</button>
				 				 	</div>
								</div>
 --%>
								<div class="collapse multi-collapse" id="collapseRAORegAuth">
									<div class="form-group row">    
										<div class="col-sm-2">
											<label class="col-form-label form-control-sm"><%= Information.RAORegAuthName%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAORegAuthority" name="RAORegAuthority" placeholder=<%= Information.RAORegAuthority%> autocomplete="off" >
										</div>
										<div class="col-sm-1">
								 			<label class="col-form-label form-control-sm" ><%= Information.email%></label>
										</div>
										<div class="col-sm-3">
						 			 		<input class="form-control form-control-sm" type ="email" id="RAORegAuthemail" name="RAORegAuthemail" placeholder=<%= Information.email%> autocomplete="off" >
										</div>
										<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.Phone%></label>
										</div>
										<div class="col-sm-2">
					 				 		<input class="form-control form-control-sm" type ="text" id="RAORegAuthPhone" name="RAORegAuthPhone" placeholder=<%= Information.Phone%> autocomplete="off" >
										</div>

									</div>	

									<div class="form-group row">    
										<div class="col-sm-2">
											<label class="col-form-label form-control-sm"><%= Information.Address%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RegoffAdd" name="RegMobile" placeholder=<%= Information.Address%> autocomplete="off" >
										</div>
										<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.Block%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RegOffBlock" name="RegOffBlock" placeholder=<%= Information.Block%> autocomplete="off" >
										</div>
										<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.Sector%></label>
										</div>
										<div class="col-sm-2">
					 				 		<input class="form-control form-control-sm" type ="text" id="RegOffSector" name="RegOffSector" placeholder=<%= Information.Sector%> autocomplete="off" >
										</div>
									</div>	

									<div class="form-group row">    
										<div class="col-sm-2">
											<label class="col-form-label form-control-sm"><%= Information.City%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RegoffCity" name="RegoffCity" placeholder=<%= Information.City%> autocomplete="off" >
										</div>
										<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.State%></label>
										</div>
										<div class="col-sm-3">
					 				 		<input class="form-control form-control-sm" type ="text" id="RegOffState" name="RegOffState" placeholder=<%= Information.State%> autocomplete="off" >
										</div>
										<div class="col-sm-1">
											<label class="col-form-label form-control-sm"><%= Information.country%></label>
										</div>
										<div class="col-sm-2">
					 				 		<input class="form-control form-control-sm" type ="text" id="RegOffCountry" name="RegOffCountry" placeholder=<%= Information.country%> autocomplete="off" >
										</div>
									</div>	

								</div>
								<br />
								<div class="form-group row">
									
				 				 	<label class="control-label col-sm-9 " ></label>
									<div class="col-sm-2">
				 				 		<input class="form-control form-control-sm btn btn-warning" type ="submit" value="Submit"  >
									</div>
								</div>
				 			</div>	
						</div>
		       		</div>
	           	</div>
           	</form>
		</div>
<!-- Footer  -->
 		<br />
		<div class ="container-flucid bg-dark" >  
			<div class="row ">
				<div class="card-group text light">
			    	<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.FooterHeadLine1%></h5>
			        		<p class="card-text"> <%= Information.GloablfooterLeft%> 
			        		<p>	<a href="#" class="btn btn-primary">Go somewhere</a> </p>
			      		</div>
			    	</div>
			  		<div class="card text-center col-sm-6">
			      		<div class="card-body">
			        		<h5 class="card-title text-warning"><%= Information.GloalResponsibility%></h5>
			        		<p class="card-text"> <%= Information.GloablfooterRight%> 
			        		<p><a href="#" class="btn btn-primary">Go somewhere</a> </p>
			      		</div>
			    	</div>
				 </div>	
			</div>		
		</div>
		<br />
 
 		<div class="container-flucid bg-dark" > 
			<div class="row" >
 				<div class="col-sm-12"> 
	    		    <div class="card bg-dark text-light text-center">
					  	<div class="card-body">
			                <ul class="list-inline " >
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.MTC%>/ </a> </li>
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.PP%>/ </a> </li>
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.OTC%> </a> </li>
			                	<li class="list-inline-item h5"><a class="text-light" href="#"> <%= Information.TC%> </a> </li>
			                </ul>
			                <h6><%= Information.Browser%></h6>
					  	</div>
					</div>
	       		</div>
           	</div>
		</div>

	<script type="text/javascript">
		$(document).ready(function() {
		 	$('#toggleButton').click(function(){ 
				$('#panelBodyOne').collapse('toggle');
				$('#panelBodyTwo').collapse('toggle');
				$('#panelBodyThree').collapse('toggle');
				$('#panelBodyFour').collapse('toggle');
				$('#panelBodyFive').collapse('toggle');
			});

			$('#hideButton').click(function(){ 
				$('#panelBodyOne').collapse('hide');
				$('#panelBodyTwo').collapse('hide');
				$('#panelBodyThree').collapse('hide');
				$('#panelBodyFour').collapse('hide');
				$('#panelBodyFive').collapse('hide');
				$('#panelBodySix').collapse('hide');
			});

			$('#showButton').click(function(){ 
				$('#panelBodyOne').collapse('hide');
				$('#panelBodyTwo').collapse('hide');
				$('#panelBodyThree').collapse('hide');
				$('#panelBodyFour').collapse('hide');
				$('#panelBodyFive').collapse('hide');
			});

			$('#toggleButton1').click(function(){ 
				$('#panelBodyOne').collapse('toggle');
				$('#panelBodyTwo').collapse('hide');
				$('#panelBodyThree').collapse('hide');
				$('#panelBodyFour').collapse('hide');
				$('#panelBodyFive').collapse('hide');

			});
			$('#toggleButton2').click(function(){ 
				$('#panelBodyOne').collapse('hide');
				$('#panelBodyTwo').collapse('toggle');
				$('#panelBodyThree').collapse('hide');
				$('#panelBodyFour').collapse('hide');
				$('#panelBodyFive').collapse('hide');

			});
			$('#toggleButton3').click(function(){ 
				$('#panelBodyOne').collapse('hide');
				$('#panelBodyTwo').collapse('hide');
				$('#panelBodyThree').collapse('toggle');
				$('#panelBodyFour').collapse('hide');
				$('#panelBodyFive').collapse('hide');

			});
			$('#toggleButton4').click(function(){ 
				$('#panelBodyOne').collapse('hide');
				$('#panelBodyTwo').collapse('hide');
				$('#panelBodyThree').collapse('hide');
				$('#panelBodyFour').collapse('toggle');
				$('#panelBodyFive').collapse('hide');
			});
			$('#toggleButton5').click(function(){ 
				$('#panelBodyOne').collapse('hide');
				$('#panelBodyTwo').collapse('hide');
				$('#panelBodyThree').collapse('hide');
				$('#panelBodyFour').collapse('hide');
				$('#panelBodyFive').collapse('toggle');
			});
		
			$('.collapse').on('shown.bs.collapse', function() {
			   	$(this).parent().find('.glyphicon-plus-sign').removeClass('glyphicon-plus-sign').addClass('glyphicon-minus-sign');
			});
			$('.collapse').on('hidden.bs.collapse', function() {
			   	$(this).parent().find('.glyphicon-minus-sign').removeClass('glyphicon-minus-sign').addClass('glyphicon-plus-sign');
			});
			
			$('#btnExpandAll').click(function(){
				$('.panel-collapse.collapse').collapse('show');	
			});
			$('#btnCollapseAll').click(function(){
				$('.panel-collapse.collapse').collapse('hide');	
			});
		});
	</script>
	</body>
</html>