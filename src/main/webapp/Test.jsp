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
	   	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<body>
		<div class="container-flucid">
			<div class="row">
				<div class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px">
					<ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="HomePage.jsp"> <%= Information.raoHome%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="LoginPage.jsp"> <%= Information.LogoutTitle%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
				<div class="row">
					<div class="col-sm-7">
						<img src="images/KSB.png" class="img-responsive " />
					</div>
				</div>
		</div>


<div>
<ul class="list-group">
  <li class="list-group-item disabled" aria-disabled="true">disable Cras justo odio</li>
  <li class="list-group-item disable">disable Dapibus ac facilisis in</li>
  <li class="list-group-item">Morbi leo risus</li>
  <li class="list-group-item">Porta ac consectetur ac</li>
  <li class="list-group-item">Vestibulum at eros</li>
</ul>

</div>



	<div class="list-group list-group-horizontal-sm col-sm-8" id="myList" role="tablist" >
	  <a class="list-group-item list-group-item-action active" data-toggle="list" href="#home" role="tab">Home</a>
	  <a class="list-group-item disable " aria-disabled="true" data-toggle="list" href="#profile" role="tab">Profile</a>
	  <a class="list-group-item disable" aria-disabled="true" data-toggle="list" href="#messages" role="tab">Messages</a>
	  <a class="list-group-item disable" data-toggle="list" href="#settings" role="tab">Save</a>
	</div>
	
	<div class="tab-content">
		<div class="tab-pane active" id="home" role="tabpanel">
			<div class="list-group col-sm-4 bg-light col-sm-4">
			<p> ramkumar verma is very famous film maker <p>
		</div>
	</div>	
	<div class="tab-pane" id="profile" role="tabpanel">
		<div class="bg-dark text-light offset-col-2 col-sm-4">
			<p> ramkumar verma is very famous film maker <p>
			<p> ramkumar verma is very famous film maker <p>
		</div>
	</div>
	<div class="tab-pane" id="messages" role="tabpanel">
		<div class="bg-primary text-light offset-col-4 col-sm-4">		
			<p> ramkumar verma is very famous film maker <p>
			<p> ramkumar verma is very famous film maker <p>
		</div>		
	</div>
	<div class="tab-pane col-sm-4" id="settings" role="tabpanel ">
		<div class="bg-warning text-light offset-col-8">		
			<p> ramkumar verma is very famous film maker <p>
		</div>		
	 
	</div>

<script>
  $(function () {
    $('#myList a:last-child').tab('show')
  })
</script>

</body>
</html>