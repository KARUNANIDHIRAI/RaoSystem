<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- https://www.codejava.net/java-ee/jsp/how-to-create-dynamic-drop-down-list-in-jsp-from-database -->
<!-- https://www.codejava.net/coding/how-to-implement-forgot-password-feature-for-java-web-application -->
<!-- https://docs.oracle.com/cd/A97339_01/doc/jsp.106/whitepapers/jsp-oow99-paper.pdf -->
<!-- https://www.tutorialspoint.com/springmvc/springmvc_dropdown.htm -->
<!-- C:\Program Files\Apache Software Foundation\Tomcat 8.5 -->
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
	                	<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%= Information.raoHome%> </a> </li>
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

		<div class="container" > 
			<form id="userRole" name="userRole" action="UserRegCheck" method="post" class="form-horizontal needs-validation" autocomplete="off"  novalidate>
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="accordion" id="accordionExample">

							<div class="card">
    							<div class="card-header bg-primary "  id="headingOne" style="max-height:60px">
      								<h2 >
        								<button class="btn btn-link text-light" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          									<%= Information.userLogin%>[+]
        								</button>
      								</h2>
    							</div>

							    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
     							 	<div class="card-body alert-secondary text-dark">
										<div class="form-row">
									   		<div class="col-sm-4 offset-sm-1">
										   		<label for="Fname" ><%= Information.fname%></label>
										   		<input type="text" class="form-control " id="Fname"  name="Fname" required>
								    		</div>
 									    	<div class="col-sm-3">
												<label for="Lname" ><%= Information.lname%></label>
												<div class="input-group">
										       		<input type="text" class="form-control " id="Lname" name = "Lname" aria-describedby="inputGroupPrepend" required>
												</div>
									    	</div>
								  		</div>
										<div class="form-row">
										    <div class="col-sm-4 offset-sm-1">
										    	<label for="email" ><%= Information.email%></label>
										      	<input type="text" class="form-control " id="email" name="email" required>
										    </div>
									    	<div class="col-sm-3 offset-sm-0">
									      		<label for="Mobile" ><%= Information.Mobile%></label>
											      <input type="Text" class="form-control " id="Mobile" name="Mobile"  required>
									   		</div>
										    <div class="col-sm-3">
											      <label for="rwaRegNo"  ><%= Information.RAORegNo%></label>
											      <input type="text" class="form-control " id="rwaRegNo" name="rwaRegNo" placeholder=<%= Information.RwaRegNO%> required>
									    	</div>
									  	</div>
			
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="UserRolType" ><%= Information.UserType%></label>

											    <select name="UserType">
													<option selected value="1">Supper Admin </option>
													<option value="2">Admin </option>
													<option value="3">Site User </option>
														    
<%-- 											    
											    	<c:forEach var="counter" items="${listCategory}">
			            								<option> "${counter.roleName}" </option>
        											</c:forEach>
 --%>											
 											    </select>
									    	</div>
									  	</div>

										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="userLogInId"><%= Information.UserID%></label>
											      <input type="Text" class="form-control" id="userLogInId" name="userLogInId" placeholder=<%= Information.UserLoinID%> >
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
    										 <label for="UserLoginPassword"><%=Information.Password%></label>
      										 <input type="password" class="form-control " id="UserLoginPassword" name="UserLoginPassword" placeholder="" 
 	     										  data-toggle="tooltip" data-placement="top" 
    	  										  title="Must contain at least one number and one uppercase and lowercase letter,  and at least 8 and max 15 characters" required>
 									    	</div>
										    <div class="col-sm-4">
	     										 <label for="LoginSecurityCode"><%=Information.SecCode%></label>
    	  										 <input type="text" class="form-control " id="LoginSecurityCode" name="LoginSecurityCode" placeholder="Any 4-5digit no." required>
									    	</div>
									  	</div>
										<br />
										<div class="form-row ">
									    	<div class="col-sm-3 offset-sm-8">
										      	<button type="button" class="form-control bg-warning" id="cont01" name = "cont01" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo" >Continue... </button>
										    </div>
									  	</div>

      								</div>
    							</div>
  							</div>


							<div class="card" id="hd2">
    							<div class="card-header bg-primary" style="max-height:60px" id="headingTwo">
      								<h2 class="mb-0">
        								<button class="btn btn-link text-light  " type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo" >
          									<%= Information.Address%>[+]
        								</button>
      								</h2>
    							</div>

							    <div id="collapseTwo" class="collapse " aria-labelledby="headingTwo" data-parent="#accordionExample">
									<div class="card-body  alert-secondary">
										<div class="form-row">
										    <div class="col-sm-4 offset-sm-1">
											      <label for="paddress" ><%=Information.PAddress%></label>
											      <input type="text" class="form-control " id="paddress" name="paddress" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
										    	<label for="pblock"  ><%=Information.Block%></label>
										      	<input type="text" class="form-control" id="pblock"  name="pblock" >
										    </div>
										    <div class="col-sm-3 offset-sm-0">
												<label for="psector" ><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control" id="psector" name="psector"  >
												</div>
										    </div>
									  	</div>
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="pcity" ><%=Information.City%></label>
											      <input type="text" class="form-control" id="pcity" name="pcity" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="pstate"  ><%=Information.State%></label>
										      	<input type="text" class="form-control" id="pstate" name ="pstate" required>
										    </div>
										    <div class="col-sm-2 offset-sm-0">
												<label for="pcountry" ><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control " id="pcountry" name="pcountry" required >
												</div>
										    </div>
										    <div class="col-sm-1">
												<label for="ppincode" ><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control" id="ppincode" name="ppincode" required>
												</div>
										    </div>
									  	</div>
										<br/>
						      		</div>
									<div class="form-row" id="hd4">
								    	<div class="col-sm-3 offset-sm-8">
									      	<button type="submit" class="form-control bg-warning" id="submit01" name = "submit01"  ><%=Information.Submit %> </button>
									    </div>
								  	</div>
						    	</div>
							</div>
 	
 	
 						</div>
					</div>
				</div>
			</form>
		</div>
	
			
			<br/>
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
		<br />
		<div class="container-flucid" > 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 bg-dark"> 
	                <ul class="list-inline text-center" >
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.MTC%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.PP%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.OTC%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.TC%> </a> </li>
	                </ul>
	        	</div>
				<div class="col-lg-12 text-center text-white bg-dark"> 
		        	<%= Information.Browser%>
           		</div>
			</div>
		</div>
		
	<script type="text/javascript">
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
		});
	
		$(document).ready(function() {

	
			$('#hd2').hide(function(){});
			$('#cont01').click(function(){
				$('#hd2').show(function(){});
			});

			 $('form[id="HoseMaid"]').validate({
				    rules: {
				      FName: {
					        required: true,
					        minlength: 4,
					        },
					  LName: {
					        required: true,
					        minlength: 3,
					        },
					  EmailId: {
				           required: true,
				           email: true,
				           },
				      MobileNO: {
				           required: true,
				           minlength: 10,
				           },
				      AaDhar: {
				           required: true,
				           minlength: 12,
				           },
				      Dob: {
					       required: true,
					      },
					  FfName: {
					     required: true,
					     minlength: 4,
					     },
					  FLName: {
					    required: true,
					    minlength: 3,
					    },
				      FInitial: {
					     required: true,
					    },
					  PerAddPinCode : {
						  digits :true,
						  minlength: 8,
					  },  
					  CorAddPinCode : {
							  digits :true,
							  minlength: 8,
					  }  

				    },
				  messages: {
					  FName   : 'First Name must be 4 Character long',
					  LName   : 'First Name must be 3 Character long',
			          Initial : 'Initial is Required',
				      EmailId : 'Email ID id Required',
				      MobileNO: 'Mobile No. Must be 10 character long',
			          AaDhar  : 'Aadhar No. Must be 12 character Long',
			          Dob     : 'Date of Birth is Required',
			          FfName  : 'Father First Name must be 5 Character long',
				      FLName  : 'Father Last Name must be 3 Character long',
			          FInitial: 'Initial is Required',
			          PerAddPinCode:'Enter only digits',
			          CorAddPinCode:'Enter only digits',
				  },
				  submitHandler: function(form) {
				      form.submit();
				  }
			});	
			 
					$('#two').addClass("disabled");
		            $('#dis').removeClass("disabled");

		            $("#file").change(function () {
		                filePreview(this);
		            });            
		            $("#file1").change(function () {
		                sigFilePreview(this);
		            });            
		            $("#file2").change(function () {
		                aadFilePreview(this);
		            });            

			 
		});
</script>
		
		
		
	</body>
</html>

