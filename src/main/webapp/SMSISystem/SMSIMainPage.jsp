<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
 		<title>Insert title here</title>	
	    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="../css/Custom.css" type="text/css">
   		<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>	


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

		<div class="container-flucid" > 
			<div class="row" >
 				<div class="col-lg-12 "> 
					<nav class="navbar navbar-expand-sm navbar-light fixed-top bg-dark text-light"  	style=" height:50px">
						<a class="navbar-brand text-light" href="#" ></a>
						<button class="navbar-toggler " data-toggle="collapse" data-target="#navmenubar">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse " id ="navmenubar"> 
							<ul class="navbar-nav ml-auto">
								<li class="active nav-item "><a href="../ContactUs/ProdDemoEnquiry.jsp" class="nav-link text-light"	> <%= Information.reqdemo%> </a> </li> 
								<li class="nav-item"><a href="../ContactUs/CollaborationEnquiry.jsp" class="nav-link text-light"><%= Information.joinPartner%> </a> </li> 
								<li class="nav-item"><a href="../ContactUs/ContactUsMainPage.jsp" class="nav-link text-light"> <%= Information.reachus%> </a> </li> 
							</ul>
						</div>
					</nav>

				</div>
			</div>
		</div>		
        <br /><br />



		<div class="container" > 
			<div class="row "> 
                <div class="col-lg-7 " > 
 					<img src="../images/KSB.png" class="img-responsive "/>
				</div>
				<div class="col-lg-5 text-right text-white"> 
	                <br />  
	                <h6> <span class ="glyphicon glyphicon-user" ></span>
						<a href="Common/RLoginPage.jsp"> <%= Information.signin%></a> 

<%-- 	                  	<a href="#"> <%= Information.joinPartner%>/ </a>
		                <a href="#"> <%= Information.reachus%> </a>
 --%>
	                </h6>
	        	</div>
 			</div>

			<div class="row">
				<nav class="navbar navbar-expand-lg navbar-light col-sm-12">

				  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    	<span class="navbar-toggler-icon"></span>
				  	</button>
					<div class="collapse navbar-collapse col-sm-12 bg-light text-light" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
					    	<li class="nav-item active">
					        	<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle " href="#" id="navbarDropdown" role="button" 
					      		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">	<%= Information.product%>
					        	</a>
								<div class="dropdown-menu " id="megha_menu" style ="width:400px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
									<div class="row">
										<div class="col-sm-10">
										    <P>	<a class="text-dark" href="SMInfoSystem.jsp">School Management & Information System</a> </P>
										    <P>	<a class="text-dark" href="SIMainPage.jsp">Student Information System</a> </P>
										</div>
								    </div>
								</div>

					      	</li>
					      	<li class="nav-item dropdown">
					        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" 
					        	aria-expanded="false"><%= Information.service%></a>
								<div class="row">
									<div class="dropdown-menu " id="megha_menu" style ="width:650px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
										<div class="row">
											<div class="col-sm-6">
									        	<a class="dropdown-item" href="#">Service Offering</a>
									          	<div class="dropdown-divider"></div>
									        	<a class="dropdown-item" href="#">Advance Service</a>
									        	<a class="dropdown-item" href="#">Technology and Consulting</a>
									        	<a class="dropdown-item" href="#">Enhance and Upgrade</a>
									        	<a class="dropdown-item" href="#">Outsourcing Software Development</a>
									        	<a class="dropdown-item" href="#">Corporate Technology Training</a>
									        	<a class="dropdown-item" href="#">End of Life Service</a>
											</div>
											<div class="col-sm-5">
									          	<a class="dropdown-item" href="#">Service for Products and Systems</a>
									          	<div class="dropdown-divider"></div>
									          	<a class="dropdown-item" href="#">Software Development</a>
									          	<a class="dropdown-item" href="#">Data Science and Analysis</a>
									          	<a class="dropdown-item" href="#">QA Automation</a>
									          	<a class="dropdown-item" href="#">ERP System</a>
									          	<a class="dropdown-item" href="#">Apartment Automation</a>
									          	<a class="dropdown-item" href="#">PG Automation Automation</a>
									          	<a class="dropdown-item" href="#">Business Solution</a>
											</div>
									    </div>
									</div>
								</div>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
					      		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		<%= Information.about%>
					        	</a>
								<div class="dropdown-menu " id="megha_menu" style ="width:758px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
									<div class="row">
										<div class="col-sm-4">
								        	<a class="dropdown-item h5" href="#" >About Us</a>
								          	<div class="dropdown-divider"></div>
								        	<a class="dropdown-item" href="#">Advance Service</a>
								        	<a class="dropdown-item" href="#">Technology & Consulting</a>
								        	<a class="dropdown-item" href="#">Enhance and Upgrade</a>
								        	<a class="dropdown-item" href="#">End of Life Service</a>
										</div>
										<div class="col-sm-3">
											<div class="accordion" id="accordionDriver">
				    							<div class=" "  id="headingOne">
								      				<a class="dropdown-item text-dark h5" data-toggle="collapse" data-target="#collapse0" aria-expanded="true" aria-controls="collapse0" href="#"  >Who We are # </a>
				    							</div>
									          	<div class="dropdown-divider"></div>
				    							<div class=" "  id="headingOne">
								      				<a class="dropdown-item text-dark" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1" href="#"  >Sustainability </a>
				    							</div>
				    							<div class=" "  id="headingOne">
								      				<a class="dropdown-item text-dark" data-toggle="collapse" data-target="#collapse2" aria-expanded="true" aria-controls="collapse2" href="#"  >Our business </a>
				    							</div>
				    							<div class=" "  id="headingOne">
								      				<a class="dropdown-item text-dark" data-toggle="collapse" data-target="#collapse3" aria-expanded="true" aria-controls="collapse3" href="#"  >Our value</a>
				    							</div>
				    							<div class=" "  id="headingOne">
								      				<a class="dropdown-item text-dark" data-toggle="collapse" data-target="#collapse4" aria-expanded="true" aria-controls="collapse4" href="#"  >Innovation</a>
				    							</div>
				    							<div class=" "  id="headingOne">
								      				<a class="dropdown-item text-dark" data-toggle="collapse" data-target="#collapse5" aria-expanded="true" aria-controls="collapse5" href="#"  >Social Media</a>
				    							</div>
				    						</div>
										</div>
										<div class="col-sm-4">
										    <div id="collapse0" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionDriver">
									          	<a class="dropdown-item h5 text-dark" href="#">KBS Technology</a>
									          	<div class="dropdown-divider"></div>
									          	<a class="dropdown-item" href="#">Business</a>
									          	<a class="dropdown-item" href="#">Strategy</a>
									          	<a class="dropdown-item" href="#">Technology</a>
									          	<a class="dropdown-item" href="#">Board of Director</a>
									          	<a class="dropdown-item" href="#">Executive Committee</a>
									          	<a class="dropdown-item" href="#">Delivering</a>
								          	</div>
										    <div id="collapse1" class="collapse " aria-labelledby="headingOne" data-parent="#accordionDriver">
										       	<a class="dropdown-item  h5 text-dark" href="#">Sustainability</a>
										       	<a class="dropdown-item" href="#">Our approach</a>
										       	<a class="dropdown-item" href="#">Society</a>
										       	<a class="dropdown-item" href="#">Environment</a>
										       	<a class="dropdown-item" href="#">Life style</a>
											</div>  
										    <div id="collapse2" class="collapse " aria-labelledby="headingOne" data-parent="#accordionDriver">
										       	<a class="dropdown-item  h5 text-dark" href="#">Our business</a>
										       	<a class="dropdown-item" href="#">Business solution & Automation</a>
										       	<a class="dropdown-item" href="#">IT Consultant and Services</a>
										       	<a class="dropdown-item" href="#">QA Automation</a>
										       	<a class="dropdown-item" href="#">Corporate IT Training</a>
										       	<a class="dropdown-item" href="#">OutScourcing Software Development</a>
										       	<a class="dropdown-item" href="#">Software Development</a>
											</div>  
										    <div id="collapse3" class="collapse " aria-labelledby="headingOne" data-parent="#accordionDriver">
										       	<a class="dropdown-item  h5 text-dark" href="#">Our Value</a>
										       	<a class="dropdown-item" href="#">Training & Communication</a>
										       	<a class="dropdown-item" href="#">Commitment</a>
										       	<a class="dropdown-item" href="#">Standard</a>
										       	<a class="dropdown-item" href="#">Conduct</a>
										       	<a class="dropdown-item" href="#">Reporting</a>
											</div>  
										    <div id="collapse4" class="collapse " aria-labelledby="headingOne" data-parent="#accordionDriver">
										       	<a class="dropdown-item  h5 text-dark" href="#">Innovation</a>
										       	<a class="dropdown-item" href="#">Research</a>
										       	<a class="dropdown-item" href="#">Review</a>
										       	<a class="dropdown-item" href="#">Collaboration</a>
										       	<a class="dropdown-item" href="#">Technology</a>
											</div>  
										    <div id="collapse5" class="collapse " aria-labelledby="headingOne" data-parent="#accordionDriver">
										       	<a class="dropdown-item  h5 text-dark" href="#">Social Media</a>
										       	<a class="dropdown-item" href="#">Linkedin</a>
										       	<a class="dropdown-item" href="#">Facebook</a>
										       	<a class="dropdown-item" href="#">YouTube</a>
										       	<a class="dropdown-item" href="#">Twitter</a>
											</div>  
										    <div id="collapse6" class="collapse " aria-labelledby="headingOne" data-parent="#accordionDriver">
										       	<a class="dropdown-item  h5 text-dark" href="#">Life style</a>
										       	<a class="dropdown-item" href="#">Our approach</a>
										       	<a class="dropdown-item" href="#">Society</a>
										       	<a class="dropdown-item" href="#">Environment</a>
										       	<a class="dropdown-item" href="#">Life style</a>
											</div>  
										</div>	
								    </div>
								</div>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		<%= Information.help%>
					        	</a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						        	<a class="dropdown-item" href="#">dropdown menu</a>
						        	<a class="dropdown-item" href="#">dropdown menu</a>
						          	<div class="dropdown-divider"></div>
						          	<a class="dropdown-item" href="#">dropdown menu</a>
						        </div>
					      	</li>
					    </ul>
					    <form class="form-inline my-3 my-lg-0">
					      <input class="form-control mr-sm-3" type="search" placeholder="Search" aria-label="Search">
					      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					    </form>
					</div>
				</nav>			
			</div>
			<div class="row" data-spy="scroll" data-target="#navbar-example2" data-offset="0" >
				<div class="col-lg-12 "> 
					<div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel">
						<ol class="carousel-indicators">
					    	<li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="4"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="5"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="6"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="7"></li>
					  	</ol>

					  	<div class="carousel-inner">
					    	<div class="carousel-item active" style="height: 500px">
					      		<img src="../images/Academic/LIbrary2.jpg" class="img-fluid d-block w-100 " alt="Responsive image"  >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light">Library Information </h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item active" style="height: 500px">
					      		<img src="../images/Academic/education1.jpg" class="img-fluid d-block w-100 " alt="Responsive image"  >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light">Library Information </h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item " style="height: 500px">
					      		<img src="../images/Academic/CLASSROOM0.jpg" class="img-fluid d-block w-100" alt="Responsive image" >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light">Classroom Information </h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item" style="height: 500px">
					      		<img src="../images/Academic/STUDENT 1.jpg" class="img-fluid d-block w-100" alt="Responsive image" >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-ligth">Student Information </h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item" style="height: 500px">
					      		<img src="../images/Academic/TRAINING3.jpg" class="img-fluid d-block w-100" alt="Responsive image">
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light">Training </h5>
					      		</div>
					    	</div>
						   	<div class="carousel-item" style="height: 500px">
						      	<img src="../images/Academic/transport.jpg" class="img-fluid d-block w-100" alt="Responsive image">
						      	<div class="carousel-caption d-none d-md-block">
						        	<h5 class= "text-light">Transport Information</h5>
						      	</div>
						  </div>
						  <div class="carousel-item" style="height: 500px">
						  	<img src="../images/Academic/transport4.jpg" class="img-fluid d-block w-100" alt="Responsive image">
						    <div class="carousel-caption d-none d-md-block">
						    	<h5 class= "text-light">Transport Information</h5>
						    </div>
						  </div>
						  <div class="carousel-item" style="height: 500px">
				      	  	<img src="../images/Academic/COMPUTERLAB2.jpg" class="img-fluid d-block w-100" alt="Responsive image">
				      		<div class="carousel-caption d-none d-md-block">
				        		<h5 class= "text-light">Transport Information</h5>
				      		</div>
					  	</div>
					  	<a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
					    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    	<span class="sr-only">Previous</span>
					  	</a>
					  	<a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
					    	<span class="carousel-control-next-icon" aria-hidden="true"></span>
					    	<span class="sr-only">Next</span>
					  	</a>
					</div>			
				</div>			
			</div>
			<br /><br />
<!-- 			</div>  -->
			<div class="row">
				<div class="col-sm-6 offset-sm-0">
			    	<div class="card text-center">
			      		<div class="card-body">
			        		<h5 class="card-title">School Management Information Portal <span Style ="font-size:20px">(SMIP)</span></h5>
			        		<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
			      		</div>
			    	</div>
				</div>
			  	<div class="col-sm-6">
			  		<div class="card text-center">
			      		<div class="card-body">
			        		<h5 class="card-title">Student Information Portal <span Style ="font-size:20px">(SIP)</span></h5>
			        		<p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
			        		<a href="#" class="btn btn-primary">Go somewhere</a>
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