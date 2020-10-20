<%@page import="com.raoSystem.constants.Information"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

			<link rel="stylesheet" href="../css/Custom.css" type="text/css">
			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
		
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
		 
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		 
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
		  	<script type="text/javascript" src="../js/CommonJSFile.js"></script>
	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->

		<div class="container" >
			<form id="AptInfo01" name="AptInfo01" action="../SubscriptionInfo?Action=NewSubscription" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<div class="row justify-content-md-center" >
					<div class="col-sm-12">
						<div class="card" style="background-color:#FFFFFF">
							<div class="card-header text-white" id="headingOne"	style="background-color: #38ACEC ;
							    padding-right:-1px">
	
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewSub"><a 	class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=Information.NewAPTInfo%></a></li>
										<li class="nav-item "><button type="button" class="nav-link text-white" id="ViewSubscription"
										    style="background-color: #000080">
											<%=Information.View%> <%=Information.APTFaltInventory%> 
										</button> </li>
								</ul>
							</div>
							<br />
							<div class="row">
								<div class="col-sm-12  offset-sm-0" style="padding-left:20px; padding-right:20px">
								    <h5 class="card-title text-center">Appartment Inventory Information</h5>
					    			<p class="text-danger text-center"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
																	<%session.removeAttribute("Message");%>
								</div>									
		        				<br />
							</div>
							<div class="bg-light col-sm-12 offset-sm-0">
								<br /><br />
								<div class="row">		
									<div class="col-sm-4 offset-sm-1  form-group ">
										    <select id ="SubscriptionType" name="SubscriptionType" class="form-control blineTl " required
										    data-toggle="tooltip" data-placement="top" title="Select RWA subscription Type."  >
												<option value="0">Select Subscritpion Type</option>
												<option value="Fixed Monthly">Fixed Monthly Subscription</option>
												<option value="Flat Size based">Flat Size based Subscription </option>
												<option value="Fixed and Flat Size based">Fixed and Flat Size based Subscription </option>
										    </select>
									</div>
									<div class="col-sm-4 offset-sm-0  form-group">
							            <input type="text" class="form-control   blineTl " id="subsDate" 	name="subsDate"
							 			placeholder="Monthly Subscritpion Date Effect From*" required>
									</div>
								</div>
								<br />	
								<div class="row">		
									<div class="col-sm-4 offset-sm-1">
										    <select id ="subscription" name="subscription" class="form-control blineTl  "  required
										    data-toggle="tooltip" data-placement="top" title="Select Expense Type"  >
												<option value="0">Select Expense Type</option>
												<option value="Fixed Monthly Charge">Fixed monthly all charge</option>
												<option value="Swimming Pool Charge">Swimming Pool Charge</option>
												<option value="Gym Charges">Gym Charges  </option>
												<option value="Audit Charges">Audit Charges  </option>
										    </select>
									</div>
									<div class="col-sm-4 offset-sm-0">
										<div class="input-group">
									    	<div class="input-group-prepend">
									        	<div class="input-group-text"><sub >Rs</sub></div>
									    	</div>
											<input type="text" class="form-control blineTl " id="subAmt" required 
											name="subAmt" data-toggle="tooltip" data-placement="top" 
											title="Enter the RWA subscription amount" required placeholder = "RWA Subscription Amount">
										</div>
									</div>
									<div class="col-sm-3 offset-sm-0">
										    <select id ="fixFloat" name="fixFloat" class="form-control blineTl" required
										    data-toggle="tooltip" data-placement="top" title="Select Expense"  >
												<option value="0">Choose Option </option>
												<option value="Fixed">Fixed </option>
												<option value="Flat Sq Feet Based">Size Based </option>
										    </select>
									</div>
								</div>	
								<br /><br />
								<div class="row">
									<div class="col-sm-2 offset-sm-4 ">
										<p><a href="rwaHomePage.jsp" class="form-control text-white text-center h5"
											style="background-color: #000080"><%=Information.Cancel%></a></p>
									</div>
									<div class="col-sm-2 offset-sm-0 ">
										<button type="button" 	class="form-control h5 text-white text-center "
											style="background-color: #38ACEC" id="subsAdd" name="subsAdd"><%=Information.Add%>
										</button>
									</div>
								</div>
								<br />
							</div>
							<div class="row">
								<div class="col-sm-10 offset-sm-1" >  <!--  showing data into table -->
									<div class="table-responsive ">
										<table id="nwItm" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
									</div>
								</div>
							</div>	
						</div>  <!--end of card BODY -->
					</div>
				</div>
			</form>
		</div>
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->
	</body>
	<script type="text/javascript">
	$(document).ready(function(){
/* 		$("#subsDate").datepicker();
		
		$("#ViewSubscription").click(function(){
			alert("india");
			var request =$.ajax({
				type:'POST',
				data:{Action:"subView"},
			 	dataType: 'Json',
				url:'../SubscriptionInfo',
				success:function(result){
					subsList(result);
				}	
			});	 // eof AJAX
		});

		$(document).on('click', "Button[name='DelSubsInventory']", function(){ 
			var con = confirm("Do you really want to delete? ");
			alert("checking");
			if(con){
				var subsDelID  = $(this).val();
				alert("checking del id:" +subsDelID);
				var request =$.ajax({
					type:'POST',
					data:{ subsdel : subsDelID, Action:"subscriptionDel"},
				 	dataType: 'json',
					url:'../SubscriptionInfo',
					success:function(result){
						subsList(result);
					}	
				});	 // eof AJAX
			}
		});
				
		function subsList(result){
			$('#nwItm').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [
					 {	targets: -1, className: 'dt-body-right'	},
				 ],
			    "columns": [
					 { title:	'SNO'	            ,data:"SNO"},
					 { title:	'RWA Reg No'        ,data:"rwaNo"},
					 { title:	'Subscription Type'  ,data:"subType"},  
					 { title:	'Eff Date'          ,data:"efDate"},
					 { title:	'Scription'	        ,data:"subscription"}, 
					 { title:	'Amount'			,data:"amount"}, 
					 { title:	'Type'	            ,data:"expType"}, 
		    		 { title:	'Del'		  ,data:"iDNO",
				     	"render": function(data,type,row,meta){
				       	 	return	'<button type="button" name="DelSubsInventory"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
			        	},
			        }
				]
			}); // EOF table
		}// EOF table FUNCTION	
		$("#subsAdd").click(function(){
			var subscriptionType  = $("#SubscriptionType").val();
			var subsDate = $("#subsDate").val();
			var subscription  = $("#subscription").val();
			var subAmt = $("#subAmt").val();
			var fixFloat  = $("#fixFloat").val();
			if(subsValid(subscriptionType, subsDate , subscription,subAmt, fixFloat )){
				addSubs(subscriptionType, subsDate , subscription,subAmt, fixFloat);
			}
		});
		function subsValid(subscriptionType, subsDate , subscription,subAmt, fixFloat){
			if(subscriptionType==0){
				$("#SubscriptionType").focusin();
				$("#SubscriptionType").val("Subscription Type can't be blank");
				return false;
			}else if(subsDate==0){
				$("#subsDate").focusin();
				$("#subsDate").val("subscription Date can't be blank");
				return false;
			}else if(subscription==0){
				$("#subscription").focusin();
				$("#subscription").val("subscription can't be blank");
				return false;
			}else if(subAmt==0){
				$("#subAmt").focusin();
				$("#subAmt").val("sub Amt can't be blank");
				return false;
			}else if(fixFloat==0){
				$("#fixFloat").focusin();
				$("#fixFloat").val("fixFloat can't be blank");
				return false;
			}
			$("#SubscriptionType").val("");
			$("#subsDate").val("");
			$("#subscription").val("");
			$("#subAmt").val("");
			$("#fixFloat").val("");
			return true;
		}
		function addSubs(subscriptionType, subsDate , subscription,subAmt, fixFloat){
			var request =$.ajax({
				type:'POST',
				data:{Action:"NewSubscription", "SubscriptionType" : subscriptionType, "subsDate" : subsDate,
					 "subscription" :subscription, "subAmt" :subAmt ,"fixFloat" :fixFloat},
			 	dataType: 'Json',
				url:'../SubscriptionInfo',
				success:function(result){
					subsList(result);
				}	
			});	 // eof AJAX
		}// eof ValidateUserEmail()	
 */
	});
	</script>
</html>


