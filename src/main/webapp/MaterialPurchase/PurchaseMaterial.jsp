
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.WaterTankerEntry.TankerModel"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
	    <link rel="stylesheet" href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
 	   	<link rel="stylesheet" href="../css/custom.css" type="text/css">
   		<script type="text/javascript" src="../webjars/query-validation/1.19.0/jquery.validate.min.js"></script>
   		<script type="text/javascript" src="../webjars/query-validation/1.19.0/jquery.validate.js"></script>

   		<script type="text/javascript" src="../webjars/jquery/3.4.1/jquery.min.js"></script>

   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
   		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>	
  		<script type="text/javascript" src="../webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
  		<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>

  	</head>	

	<body>
		<div class="container-flucid">
			<div class="row">
				<div class="col-lg-12 text-right  margin-left:0  margin-right:0px" style="background-color:#000080">
					<ul class="list-inline">
	                	<li class="list-inline-item "><a class="text-light" href="RwaHomePage.jsp"> <%= Information.raoHome%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="LoginPage.jsp"> <%= Information.LogoutTitle%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.joinPartner%> </a> </li>
	                	<li class="list-inline-item "><a class="text-light" href="#"> <%= Information.reachus%> </a> </li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" >
			<div class="row">
				<div class="col-sm-7">
					<img src="../images/KSB.png" class="img-responsive " />
				</div>
			</div>
		</div>
		
		<div class="container" >
			<form id="WaterTanker" name="WaterTanker" action="" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="card" style="background-color:#FFFFFF">
							<div class="form-row ">
								<div class="col-sm-12  offset-sm-0" style="padding-left:20px; padding-right:20px">
					    			<p class="text-danger text-center"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
																	<%session.removeAttribute("Message");%>
								</div>
							</div>
	   	
							<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC ;
							    padding-right:-1px; ">
	
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a 	class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.Create%> <%=Information.MaterialPurchase%></a></li>
								</ul>
							</div>
							<br /> <br />
							<div class="card" Style="Padding-top:0px" id="inv02">
								<div class="card-header" style="padding-right:-1px;padding-top:0px ">
									 <div class="form-row">
										<div class="col-sm-2 offset-sm-7">
											<label for="InvoiceNo" class="h6"><%=Information.InvoiceNo%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id="InvoiceNo" name="InvoiceNo"	 >
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="InvoiceDate" class="h6"><%=Information.InvoiceDate%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id=InvoiceDate name="InvoiceDate">
											</div>
										</div>
									</div>
									<hr />
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="CustomerName"><%=Information.CustomerName%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id=CustomerName name="CustomerName">
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="CMobileNo"><%=Information.CMobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid" 	id="CMobileNo" name="CMobileNo" >
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="OrderNO"><%=Information.OrderNO%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid" 	id="OrderNO" name="OrderNO" >
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="PaymentMode"><%=Information.PaymentMode%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id="PaymentMode" name="PaymentMode"	 >
											</div>
										</div>
									</div>
	
								</div><!--  End of card header -->
								<div class="card-body" style="padding-right:-1px;padding-top:0px ">
									<br />
									<div class="form-row">
										<div class="col-sm-4 offset-sm-5">
											<div class="input-group h5 text-center">
												<p class="text-center">Vender Information</p>
											</div>
										</div>
									</div>
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="VendorName"><%=Information.VendorName%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id="VendorName" name="VendorName"
												minlength="3">
												
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="VMobileNo"><%=Information.MobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid" 	id="VMobileNo" name="VMobileNo" >
											</div>
										</div>
										<div class="col-sm-4 offset-sm-0">
											<label for="TinNo"><%=Information.TinNo%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id="TinNo" name="TinNo"	 >
											</div>
										</div>
									</div>
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="Address"><%=Information.Address%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid" 	id="Address" name="Address" >
											</div>
										</div>	
										<div class="col-sm-3 offset-sm-0">
											<label for="City"><%=Information.City%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id=City name="City">
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="State"><%=Information.State%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid" 	id="State" name="State" >
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="Country"><%=Information.country%></label>
											<div class="input-group">
												<input type="text" class="form-control is-invalid"	id="Country" name="Country"	 >
											</div>
										</div>
										<div class="col-sm-1	 offset-sm-0">
											<label for="ZipCode"><%=Information.PinCode%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id=ZipCode name="ZipCode" pattern="[0-9]0123456789">
											</div>
										</div>
									</div>
								</div><!--  end of card Body -->
								<br />
								<div class="card" Style="Padding-top:0px" >
									<div class="card-header text-dark" id="inv02">
										<div class="text-center h6 ">
											Purchase Item Detail Information
										</div>
									</div>
									<div class="card-body" >
										 <div class="form-row ">
											<div class="col-sm-3 offset-sm-0">
												<label for="ItemName"><%=Information.ItemName%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm" 	id="ItemName" name="ItemName" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-1">
												<label for="Quantity"><%=Information.Quantity%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="Quantity" name="Quantity"	 >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="Unit"><%=Information.Unit%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="Unit"name="Unit" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="Price"><%=Information.Price%></label>
												<div class="input-group ">
													<input type="text" class="form-control form-control-sm"	id="Price"	name="Price" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="BAmount"><%=Information.Amount%> </label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="BAmount" name="BAmount"	>
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="DisRate" ><%=Information.Dis%> <%=Information.Percentage%></label>
											  	<div class="input-group">
														<input type="text" class="form-control form-control-sm"	id="DisRate"	name="DisRate" >
												</div>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="GSTRate"><%=Information.GST%> <%=Information.Percentage%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm"	id="GSTRate" name="GSTRate" >
												</div>
											</div>

											<div class="col-sm-1 offset-sm-0">
												<label for="NetAmount" ><%=Information.NetAmount%></label>
											  	<div class=" input-group ">
													<input type="text" class="form-control form-control-sm"	id="NetAmount" name= "NetAmount" >
											    </div>
											</div>
												
											<div class="col-sm-1 offset-sm-0 ">
												<label for="" ><%=Information.Action%></label>
												<button type="button" 	class="form-control form-control-sm h5 text-white text-center bg-primary "	 id="addButton"
													name="add01"  data-toggle="tooltip" data-placement="left" title="Click to Add Item In List"><%=Information.Add%>
												</button>
											</div>
										</div>


	
									</div><!-- 	end of card body -->
									<div class="card-footer" Id="ItemHd0">
										<div class="form-row h6" id="ItemHd1">
											<div class="col-sm-1 offset-sm-0">
												<label for="Sno"><%=Information.SNo%></label>
											</div>
											<div class="col-sm-2 offset-sm-0">
												<label for="lblName"><%=Information.ItemName%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblQuantity"><%=Information.Quantity%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblUnit"><%=Information.Unit%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblPrice"><%=Information.Price%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblAmount"><%=Information.Amount%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblDisRate"><%=Information.Dis%> <%=Information.Percentage%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblGST" ><%=Information.GST%> <%=Information.Percentage%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblGSTAmount"><%=Information.GST%> <%=Information.GSTAmt%></label>
											</div>
											<div class="col-sm-1 offset-sm-0">
												<label for="lblNetAmount" ><%=Information.NetAmount%></label>
											</div>
											<div class="col-sm-1 offset-sm-0 ">
												<label for="" ><%=Information.Remove%></label>
												<button type="button" 	class="form-control form-control-sm h5 text-white text-center bg-primary "	 id="revButton"
													name="rev01"  data-toggle="tooltip" data-placement="left" title="Click to Remove Item from the list"><%=Information.Remove%>
												</button>
											</div>

										</div>
										<hr class="bg-primary">
										<div class="form-row h6" id="PuchaseItemList">
											<div id="aSNo"  class="col-sm-1 offset-sm-0">	</div>
											<div id="aName" class="col-sm-2 offset-sm-0">	</div>
											<div id="aQty"  class="col-sm-1 offset-sm-0">	</div>
											<div id="aUnit" class="col-sm-1 offset-sm-0">	    </div>
											<div id="aPrice" class="col-sm-1 offset-sm-0">	</div>
											<div id="aAmount" class="col-sm-1 offset-sm-0">	</div>
											<div id="aDisRate" class="col-sm-1 offset-sm-0">	</div>
											<div id="aGSTRate" class="col-sm-1 offset-sm-0">  </div>
											<div id="aGSTAmt" class="col-sm-1 offset-sm-0">	</div>
											<div id="aNetAmt" class="col-sm-1 offset-sm-0">	</div>
											<div id="aAction" class="col-sm-1 offset-sm-0 text-info">	</div>
										</div>
	
									</div><!--  end of card footer -->
									
									<div class="form-row " >
										<label for="blbTotBillAmount" class="col-sm-2 offset-sm-8 col-form-label"><%=Information.Total%> <%=Information.Bill%><%=Information.Amount%></label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control " 	id="TotBillAmount" name="TotBillAmount" Readonly  >
										</div>
									</div>
									<div class="form-row " >
										<label for="TotDisAmount" class="col-sm-2 offset-sm-8 col-form-label"><%=Information.Total%> <%=Information.Dis%> <%=Information.Amount%>(-)</label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control "	id="TotDisAmount" name="TotDisAmount" Readonly   >
										</div>
									</div>	
									<div class="form-row " >
										<label for="TotGSTAmt" class="col-sm-2 offset-sm-8 col-form-label"><%=Information.Total%> <%=Information.GST%> <%=Information.Amount%>(+)</label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control "	id="TotGSTAmt" name="TotGSTAmt"  Readonly >
										</div>
									</div>	
									<div class="form-row " >
										<label for="TNetAmount" class="col-sm-2 offset-sm-8 col-form-label"><%=Information.Total%> <%=Information.Net%> <%=Information.Amount%> </label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control "	id="TotNetAmount" name="TotNetAmount" Readonly >
										</div>
									</div>	

				<div id="ramkumar">
					<div id ="bull1">
					    <input type="radio" id="id6" name="newsletter" value="Hourly" >kamla
					</div>
					<div id ="bull2">
					    <input type="radio" id="id6" name="newsletter" value="Daily">vimla
					</div>
					<div id ="bull3">
					    <input type="radio" id="id3" name="newsletter" value="Weekly">nimla
					</div>
					<div id ="bull4"> 
					    <input type="radio" id="id4" name="newsletter" value="Monthly" >simla
					</div>
					<div id ="bull5">
					    <input type="radio" id="id5"  name="newsletter" value="Yearly">timla	
					</div>
					<div id ="bull6">
					    <input type="radio" id="id1" name="newsletter" value="1" >pimla
					</div>
					<div id ="bull7">
					    <input type="radio" id="id2"  name="newsletter" value="2">ramla
					</div>
				</div>


								</div> <!-- end of inner main card -->
							</div>	<!-- end of main card -->
							<br /> <br />  
							<div class="form-row">
								<div class="col-sm-2 offset-sm-4 ">
									<p>	<a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
										style="background-color: #000080"><%=Information.Cancel%></a>
									</p>
								</div>
								<div class="col-sm-2 offset-sm-0 ">
									<button type="submit" 	class="form-control h5 text-white text-center "
										style="background-color: #38ACEC" id="submit01"	name="submit01"><%=Information.Submit%>
									</button>
								</div>
							</div>
							<br />
						</div><!-- col -->
					</div> <!-- rwo -->
				</div>  <!--end of card BODY -->
			</form>
		</div>
		<!-- Page Footer -->
		<br />
		<div class="container-flucid bg-dark">
			<div class="row ">
				<div class="card-group text light">
					<div class="card text-center col-sm-6">
						<div class="card-body">
							<h5 class="card-title text-warning"><%=Information.FooterHeadLine1%></h5>
							<p class="card-text">
								<%=Information.GloablfooterLeft%>
							<p>
								<a href="#" class="btn text-white"
									style="background-color: #000080">Go somewhere</a>
							</p>
						</div>
					</div>
					<div class="card text-center col-sm-6">
						<div class="card-body">
							<h5 class="card-title text-warning"><%=Information.GloalResponsibility%></h5>
							<p class="card-text">
								<%=Information.GloablfooterRight%>
							<p>
								<a href="#" class="btn text-white"
									style="background-color: #000080">Go somewhere</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br />
	
		<div class="container-flucid">
			<div class="row  header_for_fix">
				<div class="col-lg-12 bg-dark" Style="padding-bottom: 0px">
					<ul class="list-inline text-center">
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.MTC%>/</a></li>
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.PP%>/</a></li>
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.OTC%></a></li>
						<li class="list-inline-item "><a class="text-light" href="#"><%=Information.TC%></a></li>
					</ul>
				</div>
				<div class="col-lg-12 text-center text-white bg-dark"
					Style="padding-top: 0px">
					<%=Information.Browser%>
				</div>
			</div>
		</div>
	
		<script type="text/javascript">
			$(document).ready(function() {

				var counter = 0; 
				var TotBillAmt=0;
				var TotDisAmt=0;
				var TotNetAmt=0;
				var TotVatAmt=0;
				var TotGSTAmt=0;
				var netAmt=0;
				var amt=0
				var PurMaterialList=[];
                $("Button[name='rev01']").click(function(){
					alert("wah re hindustan rev01");
                });
                $("#Price").focusout(function(){
					if($("#Quantity").val()>0 &&  $("#Price").val()>0 ){
						$("#BAmount").val(parseFloat($("#Quantity").val()) * parseFloat( $("#Price").val()));
				      	$("#DisRate").focus();
					}
			  	});
                $("Button[name='invitemList']").click(function(){
					alert("wah re hindustan");
                });
                $("Button[name='invitemList']").click(function(){
					alert("wah re hindustan");
                });
				

                $("#GSTRate").focusout(function(){
			      	$("#NetAmount").focus();
			  	});

                $("Button[name='invitem']").click(function(){
					alert("wah re hindustan");
                });


                $("Button[name='add01']").click(function(){
					var  netAmt=0;
					var Amt=0;
					var Dis=0;
					var GST=0;
					
					if($("#Quantity").val()>0 &&  $("#Price").val()>0 ){
						var Amt= parseFloat($("#Quantity").val()) * parseFloat( $("#Price").val()) ;
						if (parseFloat( $("#DisRate").val() )>0) {
		 					var Dis= (Amt       * (parseFloat( $("#DisRate").val()) /100 ));
						}
						if (parseFloat( $("#GSTRate").val() )>0) {
							var GST= ((Amt-Dis) * (parseFloat( $("#GSTRate").val()) /100 ));
						}
						netAmt= Amt-(Dis+GST);
						counter++;
						PurMaterialList.push(	{SNo: counter ,	 Name:$("#ItemName").val() , Qty: $("#Quantity").val() ,   Unit: $("#Unit").val() ,
							                     Price: $("#Price").val() ,	 Amount: Amt  , DisRate:$("#DisRate").val(),GSTRate:$("#GSTRate").val(), 
							                     GSTAmt: GST , DisAmt:Dis, NetAmt: netAmt, Action:"Edit"} );

						
						
						var ptr=0;
						$.each(PurMaterialList, function() {
						 	ptr++;
						  $.each(this, function(name, value) {
							  $("#b"+ name + ptr).remove();
						  });
						});				
						
 					// code to print purchase item summary list
					 	var ptr=0;
					 	$.each(PurMaterialList, function() {
							ptr++;
							  $.each(this, function(name, value) {
								  var newTextBoxDiv = $(document.createElement('div')).attr("id",'b'+name	+ ptr);
								  if (name!="Action"){
									  newTextBoxDiv.after().html(
									  '<input type="text" class="form-control-sm form-control-plaintext" Readonly  name="'+ name + ptr +'"  id="'+name + ptr + '" value='+value +' >');
									  newTextBoxDiv.appendTo("#a"+name );
								  }else{
									  newTextBoxDiv.after().html(
 									 '<button type="button" class="form-control form-control-sm h5 text-white text-center "  name="invitemList"  id="'+name + ptr + '" value = '+ptr+'> </button>'  );
								 		newTextBoxDiv.appendTo("#a"+name );

								  }
							  });
						});				
						$("#ItemName").val("");
			            $("#Quantity").val("");
			            $("#Price").val("");
			            $("#Unit").val("");
			            $("#BAmount").val("");
			            $("#DisRate").val("");
			            $("#GSTRate").val("");
			            $("#NetAmount").val("");

	 					TotBillAmt= TotBillAmt + Amt;
						TotDisAmt =TotDisAmt + Dis;
						TotNetAmt =TotNetAmt + netAmt;
						TotGSTAmt +=GST;  
						$("#TotBillAmount").val(TotBillAmt);
						$("#TotDisAmount").val(TotDisAmt);
						$("#TotNetAmount").val(TotNetAmt);
						$("#TotGSTAmt").val(TotGSTAmt);
						$("#NetAmount").val(netAmt)
						$("#Quantity").focus();
		            
					}/*   end of if qty > 0 and price>0 */
               
               
               
               
               
               });	
			
			
			
			}); 
		</script>	
	</body>
</html>
<!--  				var gender_check = $('input:radio[name=invitem]:checked').val();
				if ( !gender_check ) {
				    alert("Please select your gender.");
				}
                $("input[name='invitem']").change(function(){
                	 alert("wah");
	                    alert($(this).val());
	            });	              
                $("input[name='newsletter']:radio").change(function(){
                    alert($(this).val());
	            });	              
                $("input[name='invitem']:radio").change(function(){
                    alert($(this).val());
	            });	              

                if ($('#invitem').attr("checked") == "checked") {
                    alert("checked radio");
                }
                if ($("input[name='invitem']").attr("checked")==true) {
                    alert("checked input");
               }                
               $('#invitem').click(function() {
                    alert('radio selected');
                  if ($(this).attr("checked") == "checked") {
                        alert("checked");
                  }
               });
 -->



 
												 	
 	
 	