<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.sm.System.SMInformation.SMFixedValue"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
 		<title>Insert title here</title>	
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		 	<link rel="stylesheet" 	href='../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
			<script type="text/javascript"	src="../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		  	<script type="text/javascript" src="../js/SMCF.js"></script>
			<link rel="stylesheet" href="../css/custom.css" type="text/css">
			<link rel="stylesheet" href="../css/SMST.css" type="text/css">
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
	
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>	

			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
		    <style type="text/css"> 
		        .dropdown:hover .dropdown-menu {   display: block; }    
		        #dropdn:hover .dropdown-menu   {   display: block; } 
		    </style> 
	</head>
	<body>
		<div class="container-flucid" > 
			<div class="row" >
 				<div class="col-lg-12 "> 
					<nav class="navbar navbar-expand-sm navbar-light fixed-top bg-dark text-light"  	style=" height:50px">
						<a class="navbar-brand text-light" href="#" > </a>
						<button class="navbar-toggler " data-toggle="collapse" data-target="#navmenubar">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse " id ="navmenubar"> 
							<ul class="navbar-nav ml-auto">
								<li class="nav-item"><a href="../UserLogin/UserLogin.jsp" class="nav-link text-light"><%= SMFixedValue.logout%> </a> </li> 
								<li class="nav-item"><a href="../ContactUs/ContactUsMainPage.jsp" class="nav-link text-light"> <%= Information.reachus%> </a> </li> 
							</ul>
						</div>
					</nav>

				</div>
			</div>
		</div>		
        <br /><br />



		<div class="container-flucid" > 
			<div class="row "> 
                <div class="col-lg-2 offset-sm-1" > 
 					<img src="../images/KSB.png" class="img-responsive "/>
				</div>
				<div class="col-lg-7  text-dark"> 
	                <br />  
	                <p class="h4"> <%= SMFixedValue.student%> <%= SMFixedValue.information%> <%= SMFixedValue.portal%> </p>  
	        	</div>
 			</div>
 		</div>	

		<div class="container-flucid" > 
			<div class="row">
				<div class="col-lg-2 offset-lg-0 " >
					<nav class="navbar navbar-expand-lg navbar-light "  Style="paddinb-top:0px; padding-bottom:0px padding-left:0px; padding-right:0px">
						<ul class="navbar-nav mr-auto bg-light" >
					    	<li class="nav-item active " >
					        	<a class="nav-link h6" href="#" style="padding-top:8px;padding-bottom:8px; padding-right:20px">
					        	User : Karuna Nidh Rai <span class="sr-only">(current)</span></a>
					      	</li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-9" Style="padding-left:0px; padding-right:0px" >
					<nav class="navbar navbar-expand-lg navbar-light col-lg-12 ">
					  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" 
					  			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					    		<span class="navbar-toggler-icon"></span>
					  	</button>
						<div class="collapse navbar-collapse col-sm-12 bg-light text-light" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto">
						    	<li class="nav-item active">
						        	<a class="nav-link h6" href="#"><%= SMFixedValue.home%> <span class="sr-only">(current)</span></a>
						      	</li>
						    	<li class="nav-item dropdown">
						      		<a class="nav-link dropdown-toggle h6" href="#" id="navbarDropdown" role="button" 
						      		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">	<%= SMFixedValue.profile%>
						        	</a>
									<div class="dropdown-menu " id="megha_menu" style ="width:400px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
										<div class="row">
											<div class="col-sm-10">
											    <P id ="sIERP"><a onclick="sIERP()" class="text-dark" href="SISystem/SGenProfile.html" target="myFrame">General Information</a> </P>
											    <P>	<a class="text-dark" href="SMSystems/sPersonalInformation.jsp">Hostel Details</a> </P>
											    <P>	<a class="text-dark" href="SMSystems/MasSubject.jsp">Transport Details</a> </P>
											    <P>	<a class="text-dark" href="SMSystems/MasSubject.jsp">Liabrary Detials</a> </P>
											</div>
									    </div>
									</div>
						      	</li>
						      	<li class="nav-item dropdown">
						        	<a class="nav-link dropdown-toggle h6" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" 
						        	aria-expanded="false"><%= SMFixedValue.academic%></a>
									<div class="row">
										<div class="dropdown-menu " id="megha_menu" style ="width:500px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
											<div class="row">
												<div class="col-sm-4">
										          	<a class="dropdown-item" href="#"><h6>Performance</h6></a>
										          	<div class="dropdown-divider"></div>
										          	<a id ="sIERP" class="dropdown-item" onclick="sIERP()()"  href= <%= SMFixedValue.TEST_PERFORMANCE%> target="myFrame">Test Performance</a>
												</div>
												<div class="col-sm-4">
										          	<a class="dropdown-item" href="#"><h6>Academic Details</h6></a>
										          	<div class="dropdown-divider"></div>
										          	<a id ="sIERP"class="dropdown-item" onclick="sIERP()"  href= <%= SMFixedValue.ATTENDANCE%> target="myFrame">Attendance</a>
										          	<a id ="sIERP" class="dropdown-item" onclick="sIERP()"  href= <%= SMFixedValue.TIMETABLE%> target="myFrame">Class Schedule</a>
										          	<a class="dropdown-item" href="#">Subject List</a>
										          	<a class="dropdown-item" href="#">Scocial Misbehaviour</a>
												</div>
										    </div>
										</div>
									</div>
						      	</li>
						      	<li class="nav-item dropdown">
						      		<a class="nav-link dropdown-toggle h6" href="#" id="navbarDropdown" role="button" 
						      		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">	<%= SMFixedValue.grievance%>
						        	</a>
									<div class="dropdown-menu " id="megha_menu" style ="width:400px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
										<div class="row">
											<div class="col-sm-10">
											    <P>	<a class="text-dark" href="SMSystems/SchoolInformation.jsp">Post Grievance</a> </P>
											    <P>	<a class="text-dark" href="SMSystems/sPersonalInformation.jsp">View Grievance</a> </P>
											</div>
									    </div>
									</div>
						      	</li>
						      	<li class="nav-item dropdown">
						      		<a class="nav-link dropdown-toggle h6" href="#" id="navbarDropdown" role="button" 
						      		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">	<%= SMFixedValue.examination%>
						        	</a>
									<div class="dropdown-menu " id="megha_menu" style ="width:400px;padding-left:20px; margin-bottom:.90rem" aria-labelledby="navbarDropdown" >
										<div class="row">
											<div class="col-sm-10">
											    <P>	<a class="text-dark" href="SMSystems/SchoolInformation.jsp">Post Grievance</a> </P>
											    <P>	<a class="text-dark" href="SMSystems/sPersonalInformation.jsp">View Grievance</a> </P>
											</div>
									    </div>
									</div>
						      	</li>
						      	<li class="nav-item dropdown">
						      		<a class="nav-link dropdown-toggle h6" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          		<%= SMFixedValue.update%>
						        	</a>
							        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
							        	<a class="dropdown-item" href="#">dropdown menu</a>
							        </div>
						      	</li>
						      	<li class="nav-item dropdown">
						      		<a class="nav-link dropdown-toggle h6" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          		<%= SMFixedValue.studentPayment%>
						        	</a>
							        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
							        	<a class="dropdown-item" href="#">dropdown menu</a>
							        </div>
						      	</li>
						    </ul>
						    <form class="form-inline my-3 my-lg-0">
						      <button class="btn btn-outline-success my-2 my-sm-0 h5" type="button"><%= SMFixedValue.logout%></button>
						    </form>
						</div>
					</nav>	
				</div>
			</div> <!--  eof NAV -->
			<div class="row" data-spy="scroll" data-target="#navbar-example2" data-offset="0" >
				<div class="col-sm-2 offset-sm-0" >  <!--  showing data into table -->
					<div class="card" style="width: 14rem;">
					  <div class="card-header bg-light text-justify" ">
						   <p id="regNo" style="font-size: 13px;"></p>
					  </div>
					  <ul class="list-group list-group-flush bg-light" style="font-size: 13px;">
					    <li id="AdmNo" class="list-group-item"  ></li>
					    <li id="SName" class="list-group-item"  ></li>
					    <li id="Course" class="list-group-item" ></li>
					    <li id="Class" class="list-group-item"  ></li>
					    <li id="Section" class="list-group-item"></li>
					    <li id="RollNo" class="list-group-item" ></li>
					  </ul>
					</div>				
 				</div>			
				<div class="col-lg-9 offset-sm-0"> 
				    <iframe id="myFrame" name="myFrame" style="width:100%;height:440px;"></iframe>
				
					<div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel">
						<ol class="carousel-indicators">
					    	<li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
					    	<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
					  	</ol>
					  	<div class="carousel-inner">
					    	<div class="carousel-item active" style="height: 440px">
					      		<img src="../images/Academic/school-education.jpg" class="img-fluid d-block w-100 " alt="Responsive image"  >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light">School Sketch Building </h5>
					      		</div>
					    	</div>
					    	<div class="carousel-item " style="height: 440px">
					      		<img src="../images/Academic/education-learning.jpg" class="img-fluid d-block w-100 " alt="Responsive image"  >
					      		<div class="carousel-caption d-none d-md-block">
					        		<h5 class= "text-light">Student Career </h5>
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
			</div> <!--  end of image scroll data-target -->
		</div>		
		<br />
		<div class="row">
			<div class="col-sm-2 offset-sm-0" >  <!--  showing data into table -->
			</div>
			<div class="col-lg-8"  >
			</div>
		</div>
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
		
		<script>
		 	$( window ).on( "load", function() {
		 		$("#myFrame").hide();
		        console.log( "window loaded" );
				showStudentProfile();
		    });
			function showStudentProfile(){
				var request =$.ajax({
					type:'POST',
 	 				data:{Action:"XSTProfile"},
				 	dataType: 'json',
					url:'../StudentERP',
					success:function(result){
						$.each(result, function(id, name){
							$("#regNo").text("School : " +name.RegNo);
							$("#SName").text("S.Name : " +name.SName);
							$("#AdmNo").text("Adm.No : " +name.AdmNo);
							$("#Course").text("Course : " +name.Course);
							$("#Class").text("Class   : " +name.Class);
							$("#Section").text("Section : " +name.Section);
							$("#RollNo").text("Roll No : " +name.RollNo);
						});
					}	
				});	 // eof AJAX
			}
			function sIERP(){ 
		 		$("#myFrame").show();
		 		$("#carouselExampleCaptions").hide();
			}
		 	$(document).ready(function(){
        		$('.dropdown-toggle').dropdown()
				showStudentProfile();
        		$("#sIERP").click(function(){ 
    		 		$("#myFrame").show();
                })			   	
				
        		$("#sGInfo").click(function(){ 
    		 		$("#myFrame").show();
                })			   	
	      		$("#xTimeTable").click(function(){ 
    		 		$("#myFrame").show();
                })
	      		$("#xAttendance").click(function(){ 
    		 		$("#myFrame").show();
                })
                			   	
				function scrollPageDown(pos){
					$("html, body").animate({
					    scrollTop: $('html, body').get(0).scrollHeight}, pos);				
				}// eof function -> function for scroll page bottom
				function scrollPageUP(pos){
					$("html, body").animate({
					    scrollTop: $('html, body').get(0).scrollHeight}, pos);	
				       var bottom = $(document).height() - $(window).height();
					$("HTML, BODY").animate({
				            scrollTop: bottom }, 1000);			
				}// eof function -> function for scroll page bottom
	   		});
		</script>		
	</body>
</html>

