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
		<jsp:include page="../HeaderPage.jsp"></jsp:include>		
		<div class="container" >
			<form id="PurMatId" name="WaterTanker" action="" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12" >
						<div class="card" style="background-color:#FFFFFF Padding-top:0px" id="" >
							<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC ;
							    padding-right:-1px; ">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a 	class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.Create%> <%=Information.MaterialPurchase%></a></li>
								</ul>
							</div>
							<div class="form-row ">
								<div class="col-sm-12  offset-sm-0" style="padding-left:20px; padding-right:20px">
					    			<p class="text-danger text-center"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
											<%session.removeAttribute("Message");%>
								</div>
							</div>
							
							<br />
							<div class="card" Style="Padding-top:0px" id="inv02">
								<div class="card-header" style="padding-right:-1px;padding-top:0px ">
									 <div class="form-row">
										<div class="col-sm-2 offset-sm-7">
											<label for="InvoiceNo" class="h6"><%=Information.InvoiceNo%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="InvoiceNo" name="InvoiceNo"	 >
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="InvoiceDate" class="h6"><%=Information.InvoiceDate%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id=InvoiceDate name="InvoiceDate">
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-sm-3 offset-sm-0">
											<label class="h5"><%=Information.Customer%> <%=Information.Info%></label>
										</div>
									</div>	
									<hr class="bg-success"/>
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="CustomerName"><%=Information.CustomerName%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id=CustomerName name="CustomerName" 
												pattern="[A-Za-z]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char">
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="CMobileNo"><%=Information.CMobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control " 	id="CMobileNo" name="CMobileNo" 
												pattern="[0-9]{10,44}" title="Enter character between a-z or A-Z name lenght max 40 char">
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="OrderNO"><%=Information.OrderNO%></label>
											<div class="input-group">
												<input type="text" class="form-control" 	id="OrderNO" name="OrderNO" >
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="PaymentMode"><%=Information.PaymentMode%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="PaymentMode" name="PaymentMode"	 >
											</div>
										</div>
									</div>
									<br />
								</div><!--  End of card header -->
								<div class="card-footer" style="padding-right:-1px;padding-top:0px ">
									<br />
									<div class="form-row" >
										<div class="col-sm-4 offset-sm-0">
												<p class="h5"><%=Information.Vendor%> <%=Information.Info%></p>
										</div>
									</div>
									<hr class="bg-warning h5" />
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="VendorName"><%=Information.VendorName%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="VendorName" name="VendorName"
												minlength="3" pattern="[A-Za-z]{4,40}" title="Enter character between a-z or A-Z name lenght max 40 char">
												
											</div>
										</div>
										<div class="col-sm-3 offset-sm-0">
											<label for="VMobileNo"><%=Information.MobileNo%></label>
											<div class="input-group">
												<input type="text" class="form-control " 	id="VMobileNo" name="VMobileNo" >
											</div>
										</div>
										<div class="col-sm-4 offset-sm-0">
											<label for="HsnNo"><%=Information.TinNo%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="HsnNo" name="HsnNo"	 >
											</div>
										</div>
									</div>
									 <div class="form-row">
										<div class="col-sm-4 offset-sm-0">
											<label for="VAddress"><%=Information.Address%></label>
											<div class="input-group">
												<input type="text" class="form-control " 	id="VAddress" name="VAddress" >
											</div>
										</div>	
										<div class="col-sm-3 offset-sm-0">
											<label for="City"><%=Information.City%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id=City name="City">
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="State"><%=Information.State%></label>
											<div class="input-group">
												<input type="text" class="form-control " 	id="State" name="State" >
											</div>
										</div>
										<div class="col-sm-2 offset-sm-0">
											<label for="Country"><%=Information.country%></label>
											<div class="input-group">
												<input type="text" class="form-control "	id="Country" name="Country"	 >
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
									<div class="card-header text-dark"  id="inv02">
										<div class="text-center h6 ">
											Purchase Item Detail Information
										</div>
									</div>
									<div class="card-body" >
										 <div class="form-row ">
											<div class="col-sm-1 offset-sm-0">
												<label for="ItemSno"><%=Information.SNo%></label>
												<div class="input-group">
													<input type="text" class="form-control form-control-sm" 	id="ItemSno" name="ItemSno" >
												</div>
											</div>
											<div class="col-sm-2 offset-sm-0">
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
												<button type="button" 	class="form-control form-control-sm h5 text-white text-center bg-primary "	 id="removeAll"
													name="removeAll"  data-toggle="tooltip" data-placement="left" title="Click to Remove Item from the list"><%=Information.Remove%>
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
									<br />
									<div class="form-row " >
										<label for="blbTotBillAmount" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.Bill%><%=Information.Amount%></label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control " 	id="TotBillAmount" name="TotBillAmount" Readonly  >
										</div>
									</div>
									<div class="form-row " >
										<label for="TotDisAmount" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.Dis%> <%=Information.Amount%>(-)</label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control "	id="TotDisAmount" name="TotDisAmount" Readonly   >
										</div>
									</div>	
									<div class="form-row " >
										<label for="TotGSTAmt" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.GST%> <%=Information.Amount%>(+)</label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control "	id="TotGSTAmt" name="TotGSTAmt"  Readonly >
										</div>
									</div>	
									<div class="form-row " >
										<label for="TNetAmount" class="col-sm-2 offset-sm-7 col-form-label"><%=Information.Total%> <%=Information.Net%> <%=Information.Amount%> </label>
										<div class="input-group col-sm-2 offset-sm-0">
										  	<div class="input-group-prepend">
										        <div class="input-group-text ">&#8377</div>
										    </div>
											<input type="text" class="form-control "	id="TotNetAmount" name="TotNetAmount" Readonly >
										</div>
									</div>	
									<br />

								</div> <!-- end of inner main card -->
							</div>	<!-- end of main card -->
							<br /> <br />  
							<div class="form-row" >
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
		<!-- branch code hdfc 3781 electronic city phase -1 -->
		<jsp:include page="../FooterPage.jsp"></jsp:include>
		<script>
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
//				$.session.set("PurItemList",PurMaterialList);
				session.setAttribute("PurItemList",PurMaterialList);
				$("#ItemSno").hide();

                $("Button[name='invitemList']").click(function(){
					alert("wah re hindustan");
					
                });
                $("#ItemSno").focusout(function(){
					var sno=$("#ItemSno").val();
   					var filteredValue = PurMaterialList.filter(function (item) {
  					      return item.SNo!= sno ;
   					});

					      
//   					removeDivItem(PurMaterialList.length);
   					removeDivItems(PurMaterialList);
					PurMaterialList=filteredValue;
					showItem(PurMaterialList);
					$("#ItemSno").hide();
					
			  	});

                $(document).on('click', "Button[name='invitemList']", function(){ 
    				alert($(this).val());
					var sno=$(this).val();
   					var filteredValue = PurMaterialList.filter(function (item) {
  					      return item.SNo!= sno ;
   					});

   					
   					//					removeDivItem(PurMaterialList.length);
   					removeDivItems(PurMaterialList);
					PurMaterialList=filteredValue;

					
					var ptr=0;
					$.each(PurMaterialList, function() {
						ptr++;
						var arrString;
					  	$.each(this, function(name, value) {
					  		
					  		arrString += "name:" + name + " value - " + value + " ," ;
					  	});
				  		alert( arrString);
					});				
					
					showItem(PurMaterialList);
    			});

                $("Button[name='removeAll']").click(function(){
					alert("wah re hindustan rev01");
					$("#ItemSno").show();
					$("#ItemSno").focus();

                });
                $("#Price").focusout(function(){
					if($("#Quantity").val()>0 &&  $("#Price").val()>0 ){
						$("#BAmount").val(parseFloat($("#Quantity").val()) * parseFloat( $("#Price").val()));
				      	$("#DisRate").focus();
					}
			  	});

                $("Button[name='add01']").click(function(){
					var Amt=0;
					var Dis=0;
					var GST=0;
					var Qty=0;
        			var DiscountRate = (parseFloat( $("#DisRate").val()) >0 ) ? parseFloat( $("#DisRate").val()) : "0";
					var GstRate=  (parseFloat( $("#GSTRate").val()) >0 ) ? parseFloat( $("#GSTRate").val()) : "0";
					var qty=parseFloat($("#Quantity").val());
					var price=parseFloat($("#Price").val());
					var Amt=qty * price;
                	var  netAmt=0;
					if(Amt>0 ){
						if (DiscountRate >0) {
 							Dis= ((Amt * DiscountRAte)/100);
                		}	
						if (GstRate >0) {
							GST= ( ((Amt-Dis) * GstRate) /100 );
						}
						netAmt= (Amt+GST)-Dis;
						counter=PurMaterialList.length+1;
						PurMaterialList.push({SNo: counter.toString() ,	 Name:$("#ItemName").val() , Qty: $("#Quantity").val() ,   Unit: $("#Unit").val() ,
		                    Price: $("#Price").val() ,	 Amount: Amt  , DisRate:$("#DisRate").val(),GSTRate:$("#GSTRate").val(), 
		                    GSTAmt: GST , DisAmt:Dis, NetAmt: netAmt, Action:"Edit"} );
	 					txtInit();	// initialize text box value
						removeDivItems(PurMaterialList);// remove already print items list
	                	alert("wah1");
 						showItem(PurMaterialList); // display Array List Items
					} //end of Amt
					txtInit(); 
				});	
			});		
			function txtInit(){
				$("#ItemName").val("");
	            $("#Quantity").val("");
	            $("#Price").val("");
	            $("#Unit").val("");
	            $("#BAmount").val("");
	            $("#DisRate").val("");
	            $("#GSTRate").val("");
	            $("#NetAmount").val("");
			}
			function removeDivItem(PurMaterialList){
				for(var ptr=1;ptr<=PurMaterialList;ptr++) {
					$('#bSNo'+ptr).remove();
					$('#bName'+ptr).remove();
					$('#bQty'+ptr).remove();
					$('#bUnit'+ptr).remove();
					$('#bPrice'+ptr).remove();
					$('#bAmount'+ptr).remove();
					$('#bDisRate'+ptr).remove();
					$('#bGSTRate'+ptr).remove();
					$('#bGSTAmt'+ptr).remove();
					$('#bDisAmt'+ptr).remove();
					$('#bNetAmt'+ptr).remove();
					$('#bNetAmt'+ptr).remove();
					$("#bAction" + ptr).remove();
				}

			}
			function removeDivItems(PurMaterialList){
				var ptr=0;
				$.each(PurMaterialList, function() {
					ptr++;
				  	$.each(this, function(name, value) {
						$("#b"+ name + ptr).remove();
				  	});
				});				
			}
			function showItem(PurMaterialList){
				var ptr=0;
				TotBillAmt=0;
				TotDisAmt=0;
				TotGSTAmt=0;
				TotNetAmt=0;
			 	$.each(PurMaterialList, function() {
					ptr++;
					$.each(this, function(name, value) {
						var newTextBoxDiv = $(document.createElement('div')).attr("id",'b'+name	+ ptr);
						var mtr= (name=="SNo" ) ? ptr : value;

						if(name == "SNo"){
			            	alert("wah1111");
//			            	PurMaterialList[this.value]=ptr.toString();
					    }
	 					if (name!="Action" ){
							newTextBoxDiv.after().html(
							'<input type="text" class="form-control-sm form-control-plaintext" Readonly  name="'+ name + ptr +'"  id="'+name + ptr + '" value='+mtr +' >');
							 newTextBoxDiv.appendTo("#a"+name );
						}else{
							newTextBoxDiv.after().html(
							'<button type="button" class="form-control-sm text-white text-center "  name="invitemList"  id="'+name + ptr + '" value = '+ptr+'></button>'  );
						 	newTextBoxDiv.appendTo("#a"+name );
						}
	 					if (name=="Amount"){TotBillAmt+= value;}
	 					if (name=="Dicount"){TotDisAmt+=  value;}
	 					if (name=="GSTAmt"){TotGSTAmt +=value;}  
	 					if (name=="NetAmt"){TotNetAmt += value;}
					});
			 	});				
				$("#TotBillAmount").val(TotBillAmt);
				$("#TotDisAmount").val(TotDisAmt);
				$("#TotGSTAmt").val(TotGSTAmt);
				$("#TotNetAmount").val(TotNetAmt);
			}
			
		</script>
	

	</body>
</html>
