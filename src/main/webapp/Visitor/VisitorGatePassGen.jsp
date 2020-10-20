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
			<link rel="stylesheet" href='../webjars/jquery-ui/1.12.1/jquery-ui.css'>
		 	<link rel="stylesheet" 	href='../webjars/datetimepicker/2.5.1/jquery.datetimepicker.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap-datetimepicker/2.4.4/css/bootstrap-datetimepicker.min.css'>

			<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.css'>
		 	<link rel="stylesheet" 	href='../webjars/bootstrap/4.3.1/css/bootstrap.min.css'>

			<script type="text/javascript" 	src="../webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script type="text/javascript" 	src="../webjars/bootstrap-datetimepicker/2.4.4/js/bootstrap-datetimepicker.min.js"></script>
			<script type="text/javascript" 	src="../webjars/jquery/3.4.1/jquery.min.js"></script>
		
		 	<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.min.js"></script>
			<script type="text/javascript" src="../webjars/popper.js/1.14.3/popper.js"></script>
			<script type="text/javascript"	src="../webjars/datetimepicker/2.5.1/jquery.datetimepicker.min.js"></script>
		
			<script src=" https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js" ></script>	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"></script>  	

			<script type="text/javascript" src="../webjars/jquery-ui/1.12.1/jquery-ui.js"> </script>
		  	<script type="text/javascript" src="../js/CommonFunc.js"></script>

			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" ></script>
			<link rel="stylesheet" 	href='https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css'>

	</head>
	<body >
	
		<!-- Page Header --><jsp:include page="../HeaderPage.jsp"></jsp:include><!-- Page Header -->
		<div class="container">
			<form id="TNTInfo" name="TNTInfo" action="../VisitorInfo?Action=NewVisitor" method="post" class="form-horizontal needs-validation" autocomplete="off">
				<br />
				<div class="row">
					<div class="col-sm-12 offset-sm-0">
						<div class="card" Style="Padding-top:0px">
							<div class="card-header text-white" id="headingOne"
								style="background-color: #38ACEC">
								<ul class="nav nav-tabs card-header-tabs">
									<li class="nav-item " id="ViewUser"><a class="nav-link active text-white "
										style="background-color: #000080" href="#"><%=MaintConstant.New%> <%=MaintConstant.User%> <%=MaintConstant.Login%> <%=MaintConstant.Info%></a></li>
								</ul>
							</div>
						</div>				
					</div>
				</div>
				<div class="col-sm-12 offset-sm-0">
					<div class="row">
				   		<div class="col-sm-8 text-center offset-sm-2">
				    		<p class="text-danger"><%= session.getAttribute("Message")== null?"":session.getAttribute("Message") %></p>
 								<%session.removeAttribute("Message");%> 
			    		</div>
			  		</div>
					<br />
					<div class="row"> 
						<div class="col-sm-5 offset-sm-0 bg-light ">
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0">
									<p class ="h5 text-center">Visitor Authentication  </p>
									<p class ="text-center">Please fill the form to Generate entry gate pass  </p>
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control blinew " id="vFname" name="vFname"
									pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
									placeholder="First Name*" required>
		
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vLname" 	name="vLname" 
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char"							
									placeholder="Last Name*" required>
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vMobileNo" 	name="vMobileNo" required 
								   pattern="[0-9\s]{10,100}"	placeholder="Mobile No (+91 XXXXXXXXXX)*" >
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-4 offset-sm-0 form-group">
								    <label for="vInTime">Entry Time*</label>
									<input type="text" class="form-control blinew bg-warning text-light" id="vInTime" name="vInTime" required 
										   title="Enter Visitor Entry Time" >
								</div>
								<div class="col-sm-4 offset-sm-0 form-group">
								    <label for="vOutTime">Exit Time*</label>
									<input type="text" class="form-control   blinew " id="vOutTime" name="vOutTime" required 
									       title="Enter Visitor Exit Time" >
								</div>
								<div class="col-sm-4 offset-sm-0 form-group">
								    <label for="text">Visit Date*</label>
									<input type="text" class="form-control blinew bg-warning text-light" id="vDate" name="vDate"
									       required title="Enter Visitor Exit Time" >
								</div>
							</div>


						</div>
						<div class="col-sm-3 offset-sm-0 bg-light" >
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0">
									<p class ="h5 text-center">Visitor Authentication  </p>
									<p class ="text-center"> Generate entry gate pass  </p>
								</div>
							</div>
							<br />
							<div class="row ">		
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vIdentityNo" 	name="vIdentityNo" required 
								   pattern="[0-9A-Za-z\s]{}"	placeholder="Identity Proof*" >
								</div>
							</div>
							<br />
							<div class="row">	
								<div class="col-sm-12 offset-sm-0" >
									<input type="text" class="form-control   blinew  " id="IdDocType" 	name="IdDocType" required
									pattern="[0-9A-Za-z\s]{}" placeholder="Id Proof Document Name " >
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinew " id="VehcilNo" 	name="VehcilNo" 
									placeholder="Visitor Vehicle No." 
									pattern="[A-Za-z0-9]{4,40}" title="Enter Visitor Vehicle Number" >
								</div>
							</div>
							<br />
							<div class ="row">
								<div class="col-sm-12 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vehicleType" 	name="vehicleType" 
									placeholder="Vehicle name" 
									pattern="[A-Za-z0-9]{4,40}" title="Enter name of the vehicle color">
								</div>
							</div>
							<br />
						</div>	


						<div class="col-sm-4 offset-sm-0"> 
							<div class="col-sm-12 offset-sm-0 bg-light text-dark">
								<br /> <br /> 
								<div class="row">		
									<div class="col-sm-12 offset-sm-0">
										<p class ="h5 text-center">Person to Visitor Meet  </p>
										<p class ="">  </p>
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-10 offset-sm-1">
										<input type="text" class="form-control blinebl " id="resFname" name="resFname"
										pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char" 
										placeholder="First Name" required>
			
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-10 offset-sm-1">
										<input type="text" class="form-control   blinebl " id="resLname" 	name="resLname" 
											pattern="[A-Za-z\s]{3,40}" title="Enter character between a-z or A-Z Min 5 char"							
										placeholder="Last Name" required>
									</div>
								</div>
								<br />
								<div class="row">		
									<div class="col-sm-10 offset-sm-1">
										<input type="text" class="form-control   blinebl " id="resAptTowerNO" 	name="resAptTowerNO" required 
									   pattern="[0-9A-Za-z\s]{}"	placeholder="Apartment / Tower No*" >
									</div>
								</div>
								<br />
								<div class="row">	
									<div class="col-sm-10 offset-sm-1">
										<input type="text" class="form-control   blinebl  " id="resFlatNo" 	name="resFlatNo" required
										pattern="[0-9A-Za-z\s]{}" placeholder="Flat Number*" >
									</div>
								</div>
								<br />
								<br />
							</div>
						</div>	<!--  end of Visitor to be meet -->
						<br />
					</div>
					<br />
					<div class="row ">					
						<div class="col-sm-8 offset-sm-0 bg-light">
							<br />
							<div class="row">		
								<div class="col-sm-12 offset-sm-0">
									<p class ="h5">Visitor Address </p>
								</div>
							</div>
							<div class="row">		
								<div class="col-sm-7 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vAddress" 	name="vAddress" required
									pattern="[A-Za-z0-9,-_.\s]{3,100}" title="" placeholder="RWA Registration Address*">
								</div>
								<div class="col-sm-5 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vCity" 	name="vCity" required 
									pattern="[A-Za-z\s]{3,100}" title="" placeholder="City*">
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-7 offset-sm-0">
									<select id="country" name="country" class="form-control blinew" required>
										<option selected value ="0">Country Name*</option>
									</select>
								</div>
								<div class="col-sm-5 offset-sm-0">
									<input type="text" class="form-control   blinew " id="vState" 	name="vState" required 
									pattern="[A-Za-z0-9\s]{3,100}" title="" placeholder="State*">
								</div>
							</div>
							<br />
							<div class="row">		
								<div class="col-sm-4">
									<input type="number" class="form-control   blinew" id="vPostalCode" 	name="vPostalCode"  
									pattern="[0-9]{6,8}" title=""placeholder="Pin Code">
								</div>
							</div>
						</div>
						<br />
						<div class="col-sm-4">
							<br /><br />
							<div class="row">		
								<div class="col-sm-4 offset-sm-2 ">
									<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
									text-center h5 btn" style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Reset%></button>
								</div>
								<div class="col-sm-4 offset-sm-0 ">
									<button type="submit" id ="subRwa01" name="subRwa01" class="form-control  text-light 
									text-center h5 btn " style= "background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%); padding-left:0 px"><%=MaintConstant.Submit %></button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br />
			</form>
		</div>					
		<!--Footer  --><jsp:include page="../FooterPage.jsp"></jsp:include>	<!--Footer  -->

	</body>
	<script type="text/javascript">
	$("#vOutTime").datetimepicker({
		timepicker: true,
		datepicker: false,
		format: 'h:i', // formateTime
		value:  visitTime(), //defaultTime
		hours12: true,
		step: 5	
	});
	$("#vInTime").datetimepicker({
		timepicker: true,
		datepicker: false,
		format: 'h:i', // formateTime
		value:  visitTime(), //defaultTime
		hours12: true,
		step: 5	
	});
	$("#vDate").datetimepicker({
		timepicker: false,
		datepicker: true,
		format: 'd-m-yy', // formate date
		value:  visitTime(), //defaultTime
		step: 5,	
		yearStart:yearStart(),
		yearEnd:'2030',
		weeks:true	
	});

	var vDate = curDate();
	function curDate(){
		var cdate = new Date();
		var dd = cdate.getDate()>10 ? cdate.getDate() : "0" +cdate.getDate() ;
		var mm = cdate.getMonth()+1>9 ? cdate.getMonth()+1 : "0" +(cdate.getMonth()+1).toString() ;
		var currdate = dd+ "/"+ mm +"/" + cdate.getFullYear();
		return currdate;		
	}
	
	var vTime = visitTime();
	function visitTime(){
		var vDate = new Date();
		var vInTime = vDate.getHours()+":"+ vDate.getMinutes();
		return 	vInTime;
	}	
	$(document).ready(function(){
	});
	function yearStart(){
		var cdate = new Date();
		return cdate.getFullYear();
	}
	</script>
</html>
