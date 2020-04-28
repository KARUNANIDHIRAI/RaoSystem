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
<!-- duplicate house maid information -->	
<!--Page Header  -->
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
<!--Page Body-->
		<div class="container" > 
			<form id="login" name="login" action="getLoginChecking" method="post" class="form-horizontal needs-validation" autocomplete="off"  novalidate>
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="accordion" id="accordionExample">

							<div class="card">
    							<div class="card-header bg-primary "  id="headingOne">
      								<h2 >
        								<button class="btn btn-link text-light" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          									<%= Information.HouseMaidPerInfo%>[+]
        								</button>
      								</h2>
    							</div>

							    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
     							 	<div class="card-body">
										<div class="form-row">
								       		<label class="col-sm-1"></label>
									   		<div class="col-sm-4 ">
										   		<label for="Fname" class="form-control-sm"><%= Information.fname%></label>
										   		<input type="text" class="form-control form-control-sm " id="validationCustom01"  name="Fname" required>
								    		</div>
 									    	<div class="col-sm-2">
												<label for="lname" class="form-control-sm "><%= Information.lname%></label>
												<div class="input-group">
										       		<input type="text" class="form-control form-control-sm " id="lname" aria-describedby="inputGroupPrepend" required>
												</div>
									    	</div>
									    	<div class="col-sm-3 offset-sm-1">
									      		<label for="Gender" class="form-control-sm"><%= Information.gender%></label>
									      		<select class="custom-select" id="Gender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>

								  		</div>
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-4">
											      <label for="DOB" class="form-control-sm" ><%= Information.dob%></label>
											      <input type="date" class="form-control form-control-sm" id="DOB" placeholder=<%= Information.dob%> required>
									    	</div>
										    <div class="col-sm-2">
										    	<label for="Aadhar" class="form-control-sm"><%= Information.aadhar%></label>
										      	<input type="text" class="form-control form-control-sm" id="Aadhar"  required>
										    </div>
									    	<div class="col-sm-3 offset-sm-1">
									      		<label for="Mobile" class="form-control-sm"><%= Information.Mobile%></label>
											      <input type="Text" class="form-control form-control-sm" id="Mobile"  required>
									   		</div>
									  	</div>
			
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-3">
											      <label for="EmailId" class="form-control-sm"><%= Information.email%></label>
											      <input type="Text" class="form-control form-control-sm" id="DOB" placeholder=<%= Information.EmailId%> >
									    	</div>
									  	</div>
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-4">
											      <label for="husFname" class="form-control-sm"><%= Information.hWFfName%></label>
											      <input type="text" class="form-control form-control-sm" id="husFname"  >
									    	</div>
											<div class="col-sm-2 ">
												<label for="husLname" class="form-control-sm"><%=Information.lname%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm" id="husLname"  >
												</div>
										    </div>
									    	<div class="col-sm-3 offset-sm-1" >
									      		<label for="hGender" class="form-control-sm"><%=Information.gender%></label>
									      		<select class="custom-select" id="hGender" required>
									        		<option  selected disabled value="">Choose...</option>
									        		<option>Male</option>
									        		<option>Female</option>
									        		<option>Trans</option>
									      		</select>
									      		<div class="invalid-feedback">
									        		Please select a valid Gender.
									      		</div>
									   		</div>

									  	</div>
	
										<div class="form-row">
									       	<label class="col-sm-1"></label>
									    	<div class="col-sm-3">
									      		<label for="hfMobile" class="form-control-sm"><%=Information.Mobile%></label>
											      <input type="Text" class="form-control form-control-sm" id="hfMobile" name="hfMobile" placeholder=<%= Information.Mobile%> >
									   		</div>
		
										    <div class="col-sm-2 offset-sm-1">
										    	<label for="hfAadhar" class="form-control-sm"><%=Information.aadhar%></label>
										      	<input type="text" class="form-control form-control-sm" id="hfAadhar" name = "hfAadhar"  >
										    </div>
									  	</div>
      								</div>
    							</div>
  							</div>


						<div class="card">
    							<div class="card-header bg-primary " style="max-height:45px" id="headingTwo">
      								<h2 class="mb-0">
        								<button class="btn btn-link text-light" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          									<%= Information.Address%>[+]
        								</button>
      								</h2>
    							</div>

							    <div id="collapseTwo" class="collapse " aria-labelledby="headingTwo" data-parent="#accordionExample">
									<div class="card-body">
						        		<p class=""><%= Information.PAddress%> </p>
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-4 ">
											      <label for="paddress" class="form-control-sm"><%=Information.Address%></label>
											      <input type="text" class="form-control form-control-sm " id="paddress" name="paddress" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
										    	<label for="validationCustom02" class="form-control-sm " ><%=Information.Block%></label>
										      	<input type="text" class="form-control form-control-sm " id="validationCustom02"  required>
										    </div>
										    <div class="col-sm-2 offset-sm-0">
												<label for="psector" class="form-control-sm "><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm " id="psector" name="psector"  required>
												</div>
										    </div>
									  	</div>
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-3 ">
											      <label for="pcity" class="form-control-sm"><%=Information.City%></label>
											      <input type="text" class="form-control form-control-sm " id="pcity" name="pcity" required>
									    	</div>
										    <div class="col-sm-2 offset-sm-1">
										    	<label for="pstate" class="form-control-sm " ><%=Information.State%></label>
										      	<input type="text" class="form-control form-control-sm " id="pstate" name ="pstate" required>
										    </div>
										    <div class="col-sm-2 offset-sm-1">
												<label for="pcountry" class="form-control-sm "><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm " id="pcountry" name="pcountry"  >
												</div>
										    </div>
										    <div class="col-sm-1">
												<label for="ppincode" class="form-control-sm "><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm " id="ppincode" name="ppincode" >
												</div>
										    </div>
									  	</div>
										
						        		<p class=""><%= Information.CAddress%></p>
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-4 ">
											      <label for="caddress" class="form-control-sm"><%=Information.Address%></label>
											      <input type="text" class="form-control form-control-sm " id="caddress" name="caddress" required>
									    	</div>
										    <div class="col-sm-3 offset-sm-0">
										    	<label for="cblock" class="form-control-sm " ><%=Information.Block%></label>
										      	<input type="text" class="form-control form-control-sm " id="cblock"  name = "cblock" required>
										    </div>
										    <div class="col-sm-2 offset-sm-0">
												<label for="csector" class="form-control-sm "><%=Information.Sector%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm " id="csector" name="csector"  required>
												</div>
										    </div>
									  	</div>
										<div class="form-row">
									       <label class="col-sm-1"></label>
										    <div class="col-sm-3 ">
											      <label for="ccity" class="form-control-sm"><%=Information.City%></label>
											      <input type="text" class="form-control form-control-sm " id="ccity" name="ccity" required>
									    	</div>
										    <div class="col-sm-2 offset-sm-1">
										    	<label for="cstate" class="form-control-sm " ><%=Information.State%></label>
										      	<input type="text" class="form-control form-control-sm " id="cstate" name ="cstate" required>
										    </div>
										    <div class="col-sm-2 offset-sm-1">
												<label for="ccountry" class="form-control-sm "><%=Information.country%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm " id="ccountry" name="ccountry"  >
												</div>
										    </div>
										    <div class="col-sm-1">
												<label for="cpincode" class="form-control-sm "><%=Information.pinCode%></label>
												<div class="input-group">
											        <input type="text" class="form-control form-control-sm " id="cpincode" name="cpincode" >
												</div>
										    </div>
									  	</div>

						      		</div>
						    	</div>
							</div>
 	
 							<div class="card">
    							<div class="card-header bg-primary " style="max-height:45px" id="headingThree">
      								<h2 class="mb-0">
        								<button class="btn btn-link text-light" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
          									<%= Information.UploadDocs%>[+]
        								</button>
      								</h2>
    							</div>

							    <div id="collapseThree" class="collapse " aria-labelledby="headingThree" data-parent="#accordionExample">
									<div class="card-body">
										<div class="form-row">
										    <div class="col-md-4 mb-3">
						 						<label class="control-label col-xs-1 " for="photo"><%= Information.UploadPhoto%> </label>
									    		<div class="col-xs-2">
											    	<input class="form-control input-sm" type="file" id="file" name="file"  required>
												</div>
												<div class="col-xs-1">
											 		<img id="photo" src="#" />
												</div>
											</div>
										    <div class="col-md-4 mb-3">
										    	<label class="control-label col-xs-1" for="Signature"><%= Information.UploadSignature%></label>
									    		<div class="col-xs-2">
											    	<input class="form-control input-sm" type="file" name="file" id="file1"  required>
												</div>
												<div class="col-xs-1">
											 		<img id="Signature" src="#"  />
												</div>
										    </div>
										    <div class="col-md-4 mb-3">
												<label class="control-label col-xs-1" for="Aadhar"><%= Information.UploadAadhar%></label>
												<div class="col-xs-2" >
											    	<input class="form-control input-sm" type="file" name="file" id="file2"  required>
													<div class="col-xs-1">
												 		<img id="Aadhar" src="#"  />
													</div>
												</div>
										    </div>
									  	</div>

 									</div>
 								</div>
 							</div>
 	
 						</div>
					</div>
				</div>
			</form>
		</div>
<!--Footer  -->	
			
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
		<div class="container-flucid" > 
			<div class="row  header_for_fix" >
 				<div class="col-lg-12 bg-dark" Style="padding-bottom:0px"> 
	                <ul class="list-inline text-center" >
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.MTC%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.PP%>/ </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.OTC%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.TC%> </a> </li>
	                </ul>
	        	</div>
				<div class="col-lg-12 text-center text-white bg-dark" Style="padding-top:0px"> 
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
			

			 $('form[id="Husemaid01"]').validate({
				    rules: {
				      FName: {
					        required: true,
					        minlength: 4,
					        },
					  LName: {
					        required: true,
					        minlength: 3,
					        },
				      Initial: {
				           required: true,
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

		            function filePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
/* 		                        $('#uploadForm + img').remove();
		                        $('#uploadForm').after('<img src="'+e.target.result+'" width="90" height="90"/>');
		                        
 */		                      
 							$('#photo')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
	
		            function sigFilePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
		                        $('#Signature')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
		            
		            function aadFilePreview(input) {
		                if (input.files && input.files[0]) {
		                    var reader = new FileReader();
		                    reader.onload = function (e) {
		                        $('#Aadhar')
		                        .attr('src', e.target.result)
		                        .width(90)
		                        .height(90);
		                    }
		                    reader.readAsDataURL(input.files[0]);
		                }
		            }
			 
		});
</script>
		
		
		
	</body>
</html>

<!-- 
<div class="accordion" id="accordionExample">

	<div class="card ">
		<div class="card-header "  id="headingOne"">
	    	<ul class="nav nav-tabs card-header-tabs">
	      		<li class="nav-item text-light" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> <a class="nav-link active" href="#">Personal Info.</a> </li>
	      		<li class="nav-item text-light" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> <a class="nav-link " href="#">Communication Info.</a> </li>
	      		<li class="nav-item text-light" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree"> <a class="nav-link " href="#">License Information</a> </li>
	      		<li class="nav-item text-light" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour"> <a class="nav-link " href="#">KYC Information</a> </li>
	      		<li class="nav-item text-light" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive"> <a class="nav-link " href="#">Ex. Employer Information</a> </li>
	      		<li class="nav-item text-light" data-toggle="collapse" data-target="#collapseSix" aria-expanded="true" aria-controls="collapseSix"> <a class="nav-link " href="#">Preview Complete Information</a> </li>
	      		<li class="nav-item text-light">   <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> </li>
	    	</ul>
	  	</div>
	    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
	      	<div class="card-body">
		    	<h5 class="card-title">Special title treatment</h5>
		  	</div>
		</div>  	
	    <div id="collapseTwo" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
	      	<div class="card-body">
		    	<h5 class="card-title">Special title treatment</h5>
		  	</div>
		</div>  	

	</div>
</div>
 -->