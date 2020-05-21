<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<form id="EditLoginUser" name="EditLoginUser" action="EditLoginUser" method="post" class="form-horizontal needs-validation" autocomplete="off"  >
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
     							 	<div class="card-body alert-secondary text-dark ">
										<div class="form-row">
									   		<div class="col-sm-4 offset-sm-1">
										   		<label for="Fname"  class ="h6" ><%= Information.fname%></label>
										   		<input type="text" class="form-control is-invalid" id="Fname"  name="Fname" value=<%=session.getAttribute("Fname") %>required disabled>
								    		</div>
 									    	<div class="col-sm-3">
												<label for="Lname"  class ="h6" ><%= Information.lname%></label>
												<div class="input-group">
										       		<input type="text" class="form-control is-invalid " id="Lname" name = "Lname" value=<%=session.getAttribute("Lname") %> required disabled>
												</div>
									    	</div>
								  		</div>
										<div class="form-row">
										    <div class="col-sm-4 offset-sm-1">
										    	<label for="email"  class ="h6" ><%= Information.email%></label>
										      	<input type="text" class="form-control is-invalid" id="email" name="email" value=<%=session.getAttribute("EmailID") %> required readonly>
										    </div>
									    	<div class="col-sm-3 offset-sm-0">
									      		<label for="Mobile"  class ="h6" ><%= Information.Mobile%></label>
											      <input type="Text" class="form-control is-invalid " id="Mobile" name="Mobile" value=<%=session.getAttribute("Mobile") %>  required readonly>
									   		</div>
										    <div class="col-sm-3">
											      <label for="rwaRegNo"  class ="h6"  ><%= Information.RAORegNo%></label>
											      <input type="text" class="form-control is-invalid " id="rwaRegNo" name="rwaRegNo" value=<%=session.getAttribute("RwaRegNo") %> required readonly>
									    	</div>
									  	</div>
			
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="UserType form-control " class="h6"><%= Information.UserType%></label>

											    <select id ="UserType" name="UserType" class="form-control is-invalid " disabled>
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
										    <div class="col-sm-4 offset-sm-1">
											      <label for="userLogInId" class ="h6"><%= Information.UserID%></label>
											      <input type="Text" class="form-control is-invalid" id="userLogInId" name="userLogInId" value=<%=session.getAttribute("EmailID") %> required disabled>
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
    										 <label for="UserLoginPassword" class ="h6"><%=Information.Password%></label>
      										 <input type="password" class="form-control is-invalid" id="UserLoginPassword" name="UserLoginPassword" placeholder="" 
 	     										  data-toggle="tooltip" data-placement="top" 
    	  										  title="Must contain at least one number and one uppercase and lowercase letter,  and at least 8 and max 15 characters" required disabled>
 									    	</div>
										    <div class="col-sm-3">
	     										 <label for="LoginSecurityCode" class ="h6"><%=Information.SecCode%></label>
    	  										 <input type="text" class="form-control is-invalid" id="LoginSecurityCode" name="LoginSecurityCode" placeholder="" required disabled>
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
											      <label class ="h6" for="paddress" ><%=Information.PAddress%></label>
											      <input type="text" class="form-control is-invalid" id="paddress" name="paddress" value=<%=session.getAttribute("Address") %> required >
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
										    	<label for="pblock"   class ="h6"  ><%=Information.Block%></label>
										      	<input type="text" class="form-control " id="pblock"  name="pblock" value=<%=session.getAttribute("Block") %> >
										    </div>
										    <div class="col-sm-3 offset-sm-0">
												<label for="psector"  class ="h6" ><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control" id="psector" name="psector" value=<%=session.getAttribute("Sector") %>  >
												</div>
										    </div>
									  	</div>
									  	<br />
										<div class="form-row">
										    <div class="col-sm-3 offset-sm-1">
											      <label for="pcity"  class ="h6" ><%=Information.City%></label>
											      <input type="text" class="form-control is-invalid" id="pcity" name="pcity" value=<%=session.getAttribute("City") %> required >
									    	</div>
										    <div class="col-sm-3 offset-sm-1">
										    	<label for="pstate"  class ="h6"  ><%=Information.State%></label>
										      	<input type="text" class="form-control is-invalid" id="pstate" name ="pstate" value=<%=session.getAttribute("State") %> required >
										    </div>
										    <div class="col-sm-2 offset-sm-0">
												<label for="pcountry"  class ="h6"  ><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control is-invalid " id="pcountry" name="pcountry" value=<%=session.getAttribute("Country") %> required >
												</div>
										    </div>
										    <div class="col-sm-2">
												<label for="ppincode"  class ="h6" ><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control is-invalid" id="ppincode" name="ppincode" value=<%=session.getAttribute("PinCode") %> required>
												</div>
										    </div>
									  	</div>
										<br/>
						      		</div>
									<div class="form-row" id="hd4">
								    	<div class="col-sm-3 offset-sm-8">
									      	<button type="submit" class="form-control bg-warning h6" id="submit01" name = "submit01"  ><%=Information.Submit %> </button>
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
		
<!-- <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()"> -->
<script> 
function validate()
{ 
     var fullname = document.form.fullname.value;
     var email = document.form.email.value;
     var username = document.form.username.value; 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
     
     if (fullname==null || fullname=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (email==null || email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     } 
 } 
</script> 		
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
		
	</body>
</html>

