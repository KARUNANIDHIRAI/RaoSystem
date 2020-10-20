<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.rao.System.MaintWork.MaintConstant"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 	<meta charset="ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="../css/Custom.css" type="text/css">

			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>
			<script type="text/javascript" 	src="../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript"	src="../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>

		 	<link rel="stylesheet" 	href='../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
				
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>
		
			<link rel="stylesheet"  type="text/css" href="../webjars/datatables/1.10.19/css/jquery.dataTables.min.css">
			<script type="text/javascript" src="../webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
			<script type="text/javascript"	src="../webjars/datatables-buttons/1.6.1/js/buttons.print.min.js"></script>
			<script src="//cdn.datatables.net/tabletools/2.2.4/js/dataTables.tableTools.min.js"></script>	   	
			<script src="//cdn.datatables.net/buttons/1.6.0/js/dataTables.buttons.min.js"></script>
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	


			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>

	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="VVInfo" name="VVInfo" action="#" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=MaintConstant.VisitorGP%>  <%=MaintConstant.Info%></a></li>
										<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
											style="background-color: #000080" href="../Visitor/VisitorGatePassGen.jsp"><%=MaintConstant.New%> <%=MaintConstant.VisitorGP%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<br />
				<div class="row">	
			   		<div class="col-sm-10 text-center offset-sm-1">
			    		<p class="h5 text-center"><%=MaintConstant.View%> <%=MaintConstant.VisitorGP%>  <%=MaintConstant.Info%></p>
			    		</div>
		    		</div>
				<div class="bg-light" >
					<div class="row">	
				   		<div class="col-sm-10 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
									<%session.removeAttribute("Message");%> 
			    		</div>
		    		</div>
			    	<br />
					<div class="row ">
						<div class="col-sm-4 offset-sm-2">
						    <label for="text">Mobile No*</label>
							<input type="text" class="form-control   blinew " id="vMobileNo" 	name="vMobileNo" required 
						   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" 
						   data-toggle="tooltip" data-placement="bottom" title="Enter Mobile No of the visitor to view visitor list">
						</div>
						<div class="col-sm-4 offset-sm-0">
						    <label for="text">Appartment No/ Tower No*</label>
							<input type="text" class="form-control   blinebl " id="resAptTowerNO" 	name="resAptTowerNO" required 
						   pattern="[0-9A-Za-z\s]{}"	placeholder="Apartment / Tower No*" 
						   data-toggle="tooltip" data-placement="bottom" title="Enter Apartment/ Tower No you want to view visitor list">
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-4 offset-sm-2 form-group">
						    <label for="text">Visit Date From*</label>
							<input type="text" class="form-control blinew text-dark h6" id="vDateFrom" name="vDateFrom"
							       required placeholder="Enter Visitor Exit Time"
							       data-toggle="tooltip" data-placement="bottom" title="Enter Date to genereate View Report">
						</div>
						<div class="col-sm-4 offset-sm-0 form-group">
						    <label for="text">Visit Date*</label>
							<input type="text" class="form-control blinew text-dark h6" id="vDate" name="vDate"
							       required placeholder="Enter Visitor Exit Time"
							       data-toggle="tooltip" data-placement="bottom" title="Enter Date to genereate View Report" >
						</div>
					</div>
					<br /> 
					<div class="row" > 
						<div class="col-sm-2 offset-sm-4">
							<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
							text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
						</div>
						<div class="col-sm-2 offset-sm-0 ">
							<button type="button" id ="subGP" name="subGP" class="form-control  text-light 
							text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
						</div>
					</div>
				</div>
					<br />
					<div class="row">
						<div class="col-sm-12 offset-sm-0" >  <!--  showing data into table -->
							<div class="table-responsive gb-light" >
								<table id="vvInfoList" class="table table-striped table-hover compact row-border"  style="width:100%; font-size: 12px;"> </table>
							</div>
						</div>
					</div>	
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$("#vDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
        value :visitTime(),
		yearStart:"2020",
		yearEnd:'2030',
		weeks:true	
	});
	
	$("#vDateFrom").datetimepicker({
		timepicker: false,
		datepicker: true,
		defaultDate:false,
		format: 'd-m-yy', // formate date
		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});
	

	function visitTime(){
		var vDate = new Date();
		return 	vDate;
	}	
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	$("#document").ready(function(){
		
		$("#subGP").click(function(){
			var MobileNo = $("#vMobileNo").val();
			var vresAptTowerNo = $("#resAptTowerNO").val();
			var DateFrom = $("#vDateFrom").val();
			var DateTo = $("#vDate").val();
 			var request =$.ajax({
				type:'POST',
				data:{"vMobileNo":MobileNo, "resAptTowerNO":vresAptTowerNo, "vDateFrom":DateFrom,"vDateTo":DateTo ,Action:"VVInfo"},
				dataType: 'Json',
				url:'../VisitorInfo',
				success:function(result){
					vvInfoList(result);
				}	
			});	 // eof AJAX
 
		});
		function vvInfoList(result){
			$('#vvInfoList').dataTable({
			    destroy: true,
				"data":result,
				 columnDefs: [
					 {	targets: -1, className: 'dt-body-right'	},
				 ],
				    "columns": [
 				    	 {title:	'SNO'	               ,data:"SNO"},
						 { title:	'RWA Reg No'         ,data:"RwaNo"},
						 { title:	'Vistor Name'       ,data:"vFName"},  
						 { title:	'Mobile No'	     ,data:"vMobileNo"}, 
						 { title:	'Visit Date'     ,data:"visitDate"}, 
						 { title:	'In Time'	       ,data:"vInTime"}, 
						 { title:	'Out Time'	      ,data:"vOutTime"}, 
						 { title:	'Res.Name'	      ,data:"resFName"}, 
						 { title:	'Apt. No.'	      ,data:"resAptNo"}, 
						 { title:	'Flat No.'	      ,data:"resFltNo"}, 
						 { title:	'Visitor ID'       ,data:"idProof"}, 
						 { title:	'Vehicle No'	 ,data:"vehicleNo"}, 
						 { title:	'Vehicle Name' ,data:"vehicleName"}, 
						 { title:	'View'		          ,data:"iDNO",
					     	"render": function(data,type,row,meta){
					       	 	return	'<button type="button" name="VVinfo"  value="'+data+'" class="btn btn-danger btn-sm"	data-toggle="tooltip" data-placement="right" title="Click to remove item" onclick="RemoveItem('+data+')"><span>&#9988;</span></button>'; 
				        	},
				        }
					]
				
			}); // EOF table
		}// EOF table FUNCTION	
	});
	</script>
</html>



























