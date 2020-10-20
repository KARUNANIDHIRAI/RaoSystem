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
	        .dropdown:hover .dropdown-menu { display: block;}    
	        #dropdn:hover .dropdown-menu {  display: block; } 
	    </style> 
	</head>
	<body>
		<div class="container-flucid" > 
			<div class="row" >
 				<div class="col-lg-12 "> 
					<nav class="navbar navbar-expand-sm navbar-light fixed-top"  
					style=" background: linear-gradient(90deg, rgba(2,0,36,1) 3%, rgba(9,83,121,1) 57%, rgba(0,160,255,1) 100%);
							height:50px">
						<a class="navbar-brand text-light" href="#" >KBS</a>
						<button class="navbar-toggler " data-toggle="collapse" data-target="#navmenubar">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse " id ="navmenubar"> 
							<ul class="navbar-nav ml-auto">
								<li class="active nav-item "><a href="UserLogin/UserLogin.jsp" class="nav-link text-light"	> <%= Information.signout%> </a> </li> 
								<li class="nav-item"><a href="#" class="nav-link text-light"><%= Information.joinPartner%> </a> </li> 
								<li class="nav-item"><a href="#" class="nav-link text-light"> <%= Information.reachus%> </a> </li> 
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
 					<img src="images/KSB.png" class="img-responsive "/>
				</div>
				<div class="col-lg-5 text-right text-white"> 
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
			<div class="row">
				<nav class="navbar navbar-expand-lg navbar-light col-sm-12">

				  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    	<span class="navbar-toggler-icon"></span>
				  	</button>
					<div class="collapse navbar-collapse col-sm-12 bg-light" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
					    	<li class="nav-item active">
					        	<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					      	</li>
					      	<li class="nav-item dropdown">
					        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					        		<%= Information.rwaHomePageMaster%>
					        	</a>
<!-- 								<div class="dropdown-menu "  style ="width:600px;padding-left:20px; margin-bottom:90rem" aria-labelledby="navbarDropdown" > -->
								<div class="dropdown-menu " id="megha_menu" style ="width:500px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
									<div class="row">
										<div class="col-sm-5">
									    	<p> <a class="text-dark" href = "RwaRegistration.jsp">RWA Information</a> </p>
									    	<p> <a class="text-dark" href = "AppartmentInventory/CreateAptInventory.jsp">Apartment Inventory</a> </p>
									    	<p> <a class="text-dark" href = "Inventory/RWASubscriptionMainPage.jsp">RWA Subscription</a> </p>
									    	<p> <a class="text-dark" href = "OwnerInformation/OwnerMain.jsp">Owner Information </a> </p>
									    	<p> <a class="text-dark" href = "HKMInformation/HKMMainPage.jsp">House Maid Information</a> </p>
									    	<p> <a class="text-dark" href = "DRVInformation/DRVMainPage.jsp">Driver Information </a> </p>
									    	<p> <a class="text-dark" href = "SSPInformation/SSPMainPage.jsp">Security Staff Information</a> </p>
									    	<p> <a class="text-dark" href = "DwellerInformation/NewDwellerInfo.jsp">Tenant Information </a> </p>
									    	<p> <a class="text-dark" href = "#">Maintenance Staff</a> </p>
										</div>
										<div class="col-sm-4">
									    	<p><a class="text-dark" href = "Supplier.jsp">Supplier Master </a> </p>
										    <p><a class="text-dark" href="MasterItem/ItemMasterPage.jsp">Item Information</a> </p>
										</div>
								    </div>
								</div>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		<%= Information.rwaHomePageTransaction%>
					        	</a>
								<div class="dropdown-menu " id="megha_menu" style ="width:600px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
									<div class="row">
										<div class="col-sm-4">
										    <P>	<a class="text-dark" href="WaterSupplierInfo/WaterSupplierMainPage.jsp">Water Tanker </a> </P>
										    <P>	<a class="text-dark" href="#">Issue Visitor Gate Pass</a> </P>
										    <P>	<a class="text-dark" href="PO/MainPO.jsp"> Purchase Order[PO]</a> </P>
										    <P>	<a class="text-dark" href="MaterialPurchase/MaterialPurchaseHomePage.jsp"> Material Received[PO]</a> </P>
										    <P>	<a class="text-dark" href="#"> Material Rejected[PO]</a> </P>
										    <P>	<a class="text-dark"href="#"> Material Pending[PO]</a> </P>
										</div>
										<div class="col-sm-4">
										    <P>	<a class="text-dark" href="Service/MainServicePage.jsp">Maintenance Work </a> </P>
										    <P>	<a class="text-dark" href="#">Issue Visitor Gate Pass</a> </P>
										    <P>	<a class="text-dark" href="#"> Purchase Order[PO]</a> </P>
										    <P>	<a class="text-dark" href="#"> Material Received[PO]</a></P>
										    <P>	<a class="text-dark" href="#"> Material Rejected[PO]</a> </P>
										    <P>	<a class="text-dark" href="#"> Material Pending[PO]</a> </P>
										</div>
								    </div>
								</div>
					      	</li>
					      	<li class="nav-item dropdown">
					        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" 
					        	aria-expanded="false"><%= Information.rwaHomePageMIS%></a>
								<div class="dropdown-menu " id="megha_menu" style ="width:600px;padding-left:20px; margin-bottom:.60em;" aria-labelledby="navbarDropdown" >
									<div class="row">
										<div class="col-sm-4 " Style="">
									    	 <P><a class="text-dark"  href="MIS/SubscriptionSummaryMainPage.jsp">RWA Subscription</a></P>
									    	 <P><a class="text-dark"  href="MIS/WaterSupplierMainPage.jsp">Water Tanker Summary</a></P>
									    	 <P><a class="text-dark"  href="MIS/WaterSupplySumSearch.jsp">Water Tanker Summary</a></P>
									    	 <P><a class="text-dark"  href="ViewReports/ViewInfo.jsp">View Information</a></P>
									    	 <P><a class="text-dark"  href="Inventory/SubscriptionList.jsp">RWA Subscription</a></P>
									    	 <P><a class="text-dark"  href="OwnerInformation/PreviewOwnerInfo.jsp">List of Flat Owners</a></P>
									    	 <P><a class="text-dark"  href="DwellerInformation/PreviewDwellerInfo.jsp">List of Dwellers</a></P>
									    	 <P><a class="text-dark" href="DRVInformation/PreviewDRVInfo.jsp">Personal Drivers</a></P>
									    	 <P><a class="text-dark"  href="HKMInformation/PreviewHKMInfo.jsp">Personal House Maid</a></P>
										</div>
										<div class="col-sm-4">
									    	 <P><a class="text-dark" href="SSPInformation/PreviewSSPInfo.jsp">List of Security Staff</a></P>
									    	 <P><a class="text-dark" href="DRVInformation/PreviewDRVInfo.jsp">List of Drivers</a></P>
									    	 <P><a class="text-dark" href="HKMInformation/PreviewHKMInfo.jsp">List of House Maid</a></P>
										    <P>	<a class="text-dark" href="#">Item </a> </P>
										    <P>	<a class="text-dark" href="#">Issue VisitorGate Pass</a> </P>
										    <P>	<a class="text-dark" href="PO/MainPage.jsp"> Purchase Order[PO]</a> </P>
										    <P>	<a class="text-dark" href="#"> Material Received[PO]</a></P>
										    <P>	<a class="text-dark" href="#"> Material Rejected[PO]</a> </P>
										    <P>	<a class="text-dark" href="#"> Material Pending[PO]</a> </P>
										</div>
								    </div>
								</div>
					        	
					      	</li>

		
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		Careers
					        	</a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						        	<a class="dropdown-item" href="#">Action</a>
						        	<a class="dropdown-item" href="#">Another action</a>
						          	<div class="dropdown-divider"></div>
						          	<a class="dropdown-item" href="#">Something else here</a>
						        </div>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		Contact
					        	</a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						        	<a class="dropdown-item" href="#">Action</a>
						        	<a class="dropdown-item" href="#">Another action</a>
						          	<div class="dropdown-divider"></div>
						          	<a class="dropdown-item" href="#">Something else here</a>
						        </div>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		Utility
					        	</a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						        	<a class="dropdown-item" href="RwaRegistration/RwaRegMainPage.jsp">RWA Registration</a>
						        	<a class="dropdown-item" href="UserLogin/UserLoginMainPage.jsp">Create Users</a>
						        	<a class="dropdown-item" href="Configuration/RwaConfig.jsp">SetUp Configuration Parameter</a>
						          	<div class="dropdown-divider"></div>
						          	<a class="dropdown-item" href="UserLogin/UserLoginPwdReset.jsp">Reset Password</a>
						          	<a class="dropdown-item" href="UserLogin/UserLoginPwdForget.jsp">Forget Password</a>
						          	<a class="dropdown-item" href="UserLogin/UserLoginPwdForget.jsp">Retrieve  User Login</a>
						        </div>
					      	</li>
					      	<li class="nav-item dropdown">
					      		<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          		Help
					        	</a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						        	<a class="dropdown-item" href="#">Action</a>
						        	<a class="dropdown-item" href="#">Another action</a>
						          	<div class="dropdown-divider"></div>
						          	<a class="dropdown-item" href="#">Something else here</a>
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
<%-- 			
			<div class="row" >
				<div class="col-lg-12 btn-group flex-wrap " role="group" aria-label="Button group with nested dropdown"  >
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown"><%= Information.home%></button>
						<div class="dropdown-menu " >
					    	<ul>
						    	<li><a  href="home.jsp">Dropdown link</a> </li>
						    	<li><a  href="DriverINfo.jsp">Dropdown linK</a> </li>
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
					    	<a class="dropdown-item" href="Inventory/ApartmentInventoryMainPage.jsp">Apartment Inventory </a>
					    	<a class="dropdown-item" href="Inventory/RWASubscriptionMainPage.jsp">RWA Subscription </a>
					    	<a class="dropdown-item" href="OwnerInformation/OwnerMain.jsp">Owner Information </a>
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
						<div class="dropdown-menu col-sm-5" >
							<div class="row">
								<div class="col-sm-4">
							    	<a class="dropdown-item" href="WaterSupplierInfo/WaterSupplierMainPage.jsp">Water Tanker </a>
							    	<a class="dropdown-item" href="#">Issue Visitor Gate Pass</a>
							    	<a class="dropdown-item" href="PO/MainPO.jsp"> Purchase Order[PO]</a>
							    	<a class="dropdown-item" href="MaterialPurchase/MaterialPurchaseHomePage.jsp"> Material Received[PO]</a>
							    	<a class="dropdown-item" href="#"> Material Rejected[PO]</a>
							    	<a class="dropdown-item" href="#"> Material Pending[PO]</a>
								</div>
						    </div>
						</div>
					</div>
					<div class="dropdown" > 
						<button type="button" class="btn btn-light dropdown-toggle " data-toggle="dropdown"><%= Information.rwaHomePageMIS%></button>
						<div class="dropdown-menu " >
					    	<a class="dropdown-item" href="MIS/SubscriptionSummaryMainPage.jsp">RWA Subscription</a>
					    	<a class="dropdown-item" href="MIS/WaterSupplierMainPage.jsp">Water Tanker Summary</a>
					    	<a class="dropdown-item" href="MIS/WaterSupplySumSearch.jsp">Water Tanker Summary</a>
					    	<a class="dropdown-item" href="ViewReports/ViewInfo.jsp">View Information</a>
					    	<a class="dropdown-item" href="Inventory/SubscriptionList.jsp">RWA Subscription</a>
					    	<a class="dropdown-item" href="OwnerInformation/PreviewOwnerInfo.jsp">List of Flat Owners</a>
					    	<a class="dropdown-item" href="DwellerInformation/PreviewDwellerInfo.jsp">List of Dwellers</a>
					    	<a class="dropdown-item" href="DRVInformation/PreviewDRVInfo.jsp">List of Personal Drivers</a>
					    	<a class="dropdown-item" href="HKMInformation/PreviewHKMInfo.jsp">List of Personal House Maid</a>
					    	<a class="dropdown-item" href="SSPInformation/PreviewSSPInfo.jsp">List of Security Staff</a>
					    	<a class="dropdown-item" href="DRVInformation/PreviewDRVInfo.jsp">List of Drivers</a>
					    	<a class="dropdown-item" href="HKMInformation/PreviewHKMInfo.jsp">List of House Maid</a>
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
 --%>
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

