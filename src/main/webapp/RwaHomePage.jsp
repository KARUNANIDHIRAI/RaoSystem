<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
 		<title>Insert title here</title>	
	    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="css/Custom.css" type="text/css">
   		<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
   		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>	
	    <style type="text/css"> 
	        .dropdown:hover .dropdown-menu { 
	            display: block; 
	        }    
	        #dropdn:hover .dropdown-menu { 
	            display: block; 
	        } 
	    </style> 
	</head>
	<body>
		<div class="container-flucid" data-spy="affix" data-offset-top="50"> 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px"> 
	                <ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="LoginPage.jsp"> <%= Information.signout%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
	                </ul>
	        	</div>
			</div>
		</div>
		<div class="container" > 
			<div class="row "> 
                <div class="col-lg-7 " > 
 					<img src="images/KSB.png" class="img-responsive "/>
				</div>
				<div class="col-lg-5 text-right text-white"> 
	                <br />  
	                <h6> <span class ="" ></span>
	 					<img src="images/rwa/loginUser.png" class="img-responsive "/>
	                </h6>
	        	</div>
 			</div>
			<div class="row" Style="padding-top:0; padding-bottom:0">
				<div class="col-lg-2 offset-sm-10 text-right disable:false" Style="padding-top:0; padding-bottom:0" >
		  			<a class="text-warning" href="#"><%= session.getAttribute("currentUser")== null?"":session.getAttribute("currentUser") %></a>
				</div>
			</div>
			<div class="row" >
				<div class="col-lg-12 btn-group flex-wrap " role="group" aria-label="Button group with nested dropdown"  >
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown"><%= Information.home%></button>
						<div class="dropdown-menu " >
					    	<ul>
						    	<li><a  href="home.jsp">Dropdown link</a> </li>
						    	<li><a  href="DriverINfo.jsp">Dropdown lin</a> </li>
						    	<li><a  href="#">Dropdown link</a> </li>
						    	<li><a  href="#">Dropdown link</a> </li>
						    </ul>	
					    </div>
					</div>
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle " data-toggle="dropdown"><%= Information.rwaHomePageMaster%></button>
						<div class="dropdown-menu " >
					    	<a class="dropdown-item" href="userLoginRegistration.jsp">User Registration</a>
					    	<a class="dropdown-item" href="RwaRegistration.jsp">RWA Information</a>
					    	<a class="dropdown-item" href="FlatOnwer.jsp">Owner Information </a>
					    	<a class="dropdown-item" href="HKMInformation/HKMMainPage.jsp">House Maid Information</a>
					    	<a class="dropdown-item" href="DRVInformation/DRVMainPage.jsp">Driver Information </a>
					    	<a class="dropdown-item" href="SSPInformation/SSPMainPage.jsp">Security Staff Information</a>
					    	<a class="dropdown-item" href="DwellerInformation/NewDwellerInfo.jsp">Tenant Information</a>
					    	<a class="dropdown-item" href="Supplier.jsp">Supplier Master </a>
					    	<a class="dropdown-item" href="#">Maintenance Staff</a>
			  	    	</div>
					</div>
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle " data-toggle="dropdown"><%= Information.rwaHomePageTransaction%></button>
						<div class="dropdown-menu " >
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    </div>
					</div>
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle " data-toggle="dropdown"><%= Information.rwaHomePageMIS%></button>
						<div class="dropdown-menu " >
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    </div>
					</div>
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle " data-toggle="dropdown"><%= Information.career%></button>
						<div class="dropdown-menu " >
					    	<ul>
						    	<li><a  href="dirver.jsp">Dropdown link</a> </li>
						    	<li><a  href="DriverINfo.jsp">Dropdown link</a> </li>
						    	<li><a  href="#">Dropdown link</a> </li>
						    	<li><a  href="#">Dropdown link</a> </li>
					    	
					    	</ul>
					    </div>
					</div>
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle " data-toggle="dropdown"><%= Information.contacts%></button>
						<div class="dropdown-menu " >
						
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    </div>
						<div class="dropdown-menu " >
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    </div>
					</div>
					<div class="dropdown" >
				    	<button type="button" class="btn btn-light dropdown-toggle "  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%= Information.help%> </button>
						<div class="dropdown-menu " >
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    	<a class="dropdown-item" href="#">Dropdown link</a>
					    </div>
					</div>
				</div>
			</div>	
			<br />	
			<div class="row" data-spy="scroll" data-target="#navbar-example2" data-offset="0" >
				<div class="col-lg-12 "> 
					<div id="rwaHomePageCaptions" class="carousel slide carousel-fade" data-ride="carousel">
						<ol class="carousel-indicators">
					    	<li data-target="#rwaHomePageCaptions" data-slide-to="0" class="active"></li>
					    	<li data-target="#rwaHomePageCaptions" data-slide-to="1"></li>
					    	<li data-target="#rwaHomePageCaptions" data-slide-to="2"></li>
					    	<li data-target="#rwaHomePageCaptions" data-slide-to="4"></li>
					    	<li data-target="#rwaHomePageCaptions" data-slide-to="5"></li>
					    	<li data-target="#rwaHomePageCaptions" data-slide-to="6"></li>
					  	</ol>
					  	<div class="carousel-inner">
					    	<div class="carousel-item active" style="height: 500px">
					      		<img src="images/rwa/rwaImage1.jpg" class="img-fluid d-block w-100 " alt="Responsive image"  >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light"><%=Information.rwaHomePageResImg %></h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item " style="height: 500px">
					      		<img src="images/rwa/rwaImage2.jpg" class="img-fluid d-block w-100" alt="Responsive image" >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light"><%=Information.rwaHomePagePGImg %></h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item" style="height: 500px">
					      		<img src="images/rwa/rwaImage3.jpg" class="img-fluid d-block w-100" alt="Responsive image" >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-ligth"><%=Information.rwaHomePageResImg %></h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item" style="height: 500px">
					      		<img src="images/rwa/rwaImage4.jpg" class="img-fluid d-block w-100" alt="Responsive image">
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light"><%=Information.rwaHomePagePGImg %></h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item" style="height: 500px">
					      		<img src="images/rwa/rwaImage5.jpg" class="img-fluid d-block w-100" alt="Responsive image">
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light"><%=Information.rwaHomePageResImg %></h5>
					      		</div>
					    	</div>
					  </div>
					  <a class="carousel-control-prev" href="#rwaHomePageCaptions" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="carousel-control-next" href="#rwaHomePageCaptions" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>			
				</div>			
			</div>

			<br /> 

			<div class="row">
				<div class="col-sm-3">
			    	<div class="card text-center">
			      		<div class="card-body">
			        		<h5 class="card-title">Residential Apartments Automation</h5>
			        		<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        		<a href="HomePage.jsp" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
				</div>
			  	<div class="col-sm-3">
			  		<div class="card text-center">
			      		<div class="card-body">
			        		<h5 class="card-title">Commercial Space Automation</h5>
			        		<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        		<a href="HomePage.jsp" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
			  	</div>
				<div class="col-sm-3">
			    	<div class="card text-center">
			      		<div class="card-body">
			        		<h5 class="card-title">QA Automation Solution</h5>
			        		<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        		<a href="HomePage.jsp" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
				</div>
			  	<div class="col-sm-3 text-center">
			  		<div class="card">
			      		<div class="card-body">
			        		<h5 class="card-title">IT InfoSys </h5>
			        		<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        		<a href="HomePage.jsp" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
			  	</div>
			</div>		
		</div>		
		<br />
		<div class ="container-fulid bg-dark text-white" >  
         	<div class="container">
         		<div class="row">
					<div class="col-lg-3 "> 
    	     			<div class="row">
	            			<h5 class="text-warning text-white" >Our Services</h5>
           			   </div>
                		   <div class="row">
            		      <a href="" class="text-white">Business Solution</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">IT Solution</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Consulting</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Professional Solutions</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">OutSourcing </a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">HR Solution</a>
            		   </div>
            		</div> 
           			<div class="col-lg-3"> 
            			<div class="row">
	            			<h5 class="text-warning text-white" >About us</h5>
           			   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Company Overivew</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Our Mission and Value</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Our History</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Leadership & Governance</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Newsroom & Social Media </a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Events</a>
            		   </div >
            		   <div class="row">
            		      <a href="" class="text-white">Global Location</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Corporate Responsibility</a>
            		   </div>
            		   <div class="row">
            		      <a href="" class="text-white">Careers</a>
            		   </div>
            		</div> 
            			
 					<div class="col-lg-3"> 
            			<div class="row">
	            			<h5 class="text-warning text-white" >Legal</h5>
           			   </div>
           			   <div class="row">
           			      <a href="" class="text-white">Privacy</a>
           			   </div>
           			   <div class="row">
           			      <a href="" class="text-white">Term & condition</a>
           			   </div>
           			</div> 
         			
					<div class="col-lg-3" > 
            			<div class="row">
	            			<h5 class="text-warning text-white" >Working at KBS INFOSYS</h5>
           			   </div>
						<div class="row">
	          				<a href="" class="text-white">Culture</a>
						</div>
	          			<div class="row">
	          				<a href="" class="text-white">Benefits</a>
	          			</div>
	          			<div class="row">
	          				<a href="" class="text-white">Pioneer Stories</a>
						</div>
						<div class="row">
	          				<a href="" class="text-white">Diversity at KBS InfoSys </a>
	          			</div>
	          			<div class="row">
	          				<a href="" class="text-white">Leadership Principals</a>
						</div>
					</div> 
				</div>
			</div>
		</div> 
		<script>
     		$(document).ready(function(){
        		$('.dropdown-toggle').dropdown()
    		});
		</script>		
	</body>
</html>

