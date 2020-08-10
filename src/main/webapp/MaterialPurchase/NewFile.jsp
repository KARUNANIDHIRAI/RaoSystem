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
			<form id="NewPurMaterial" name="NewPurMaterial" action="../NewPurMaterial" method="post" class="form-horizontal needs-validation" autocomplete="off">
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
								</div><!--  End of card header -->
	
								<div class="card-body" style="padding-right:-1px;padding-top:0px ">
								</div><!--  end of card Body -->

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
											<div id="aUnit" class="col-sm-1 offset-sm-0">	</div>
											<div id="aPrice" class="col-sm-1 offset-sm-0">	</div>
											<div id="aAmount" class="col-sm-1 offset-sm-0">	</div>
											<div id="aDisRate" class="col-sm-1 offset-sm-0"> </div>
											<div id="aGSTRate" class="col-sm-1 offset-sm-0"> </div>
											<div id="aGSTAmt" class="col-sm-1 offset-sm-0">	</div>
											<div id="aNetAmt" class="col-sm-1 offset-sm-0">	</div>
											<div id="aAction" class="col-sm-1 offset-sm-0 text-info">	</div>
										</div>
										<div class="form-row">
											<div>
											<button type="button" name="invitemList" class=" h5 text-white  bg-primary" id="knr1" value="1" >k </button>
											 </div>
										</div>
										<div class="form-row">
											<div>
											<button type="submit" name="invitemList" class=" h5 text-white  bg-primary" id="knr1" value="1" >Submit</button>
											 </div>
										</div>
			            				<div class="form-row" id="pid">
											<div id="kSNo"  class="col-sm-1 offset-sm-0">
											
											
											</div>
										</div>
	
									</div><!--  end of card footer -->
									

								</div> <!-- end of inner main card -->
							</div>	<!-- end of main card -->
						</div><!-- col -->
					</div> <!-- rwo -->
				</div>  <!--end of card BODY -->
			</form>
		</div>
		<!-- Page Footer -->
	
		<script type="text/javascript">
				
/* 		alert("knrai");
		var namelist=[];
		namelist= {{ "1","potatokn", "pn10","tn20","dn0","cn0","rn200"},
				            { "2","Tomato",   "20","15","0","0","300"}};
 */
		
		var arr=[];
		alert("pila chal ja");
			 arr[0] = [ "3","carrot", "50","55","60","65","250"];
			 arr[1] = [ "4","raddish", "70","75","80","90","350"];

		 var str="";
		alert("array length: "+ arr.length)
		for (var i = 0; i< arr.length; i++) {
		    for (var j = 0; j< arr[i].length;  j++) {
		        str+="Name:" +arr[i][j] + ",";
		    }
		    alert("Array String :" + str );
		}
		session.setAttribute("ItemList",arr);


   });		
		
/* 		var ptr=0;
			$(document).ready(function() {
                $("Button[name='rev01']").click(function(){
					alert("wah re hindustan rev01");
                });
                $("Button[name='invitemList']").click(function(){
					alert("wah re hindustan");
                });

                $("#kn").click(function(){
                	
                });
                $("Button[name='add01']").click(function(){
					alert("10");
					ptr++;
					var value="knr"
					var newTextBoxDiv = $(document.createElement('div')).attr("id",'bAction'+ ptr);
					newTextBoxDiv.after().html('<button type="button" name="invitemList" class=" h5 text-white  bg-primary" id= "knsing" value="'+ptr +'" >E </button>');
					newTextBoxDiv.appendTo("#kSNo");
					alert("11");
	                });
			
			});
			$(document).on('click', "Button[name='invitemList']", function(){ 
				alert(13);
				alert($("Button[name='invitemList']").val());
			});
*/
			</script>	
			
			
	</body>
</html>
