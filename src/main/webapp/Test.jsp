<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="com.raoSystem.constants.Information"%>
<%@page import="com.raoSystem.createUser.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <%
	request.getAttribute("listCategory");
%> --%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href='webjars/bootstrap/4.3.1/css/bootstrap.min.css'>
<link rel="stylesheet" href='webjars/bootstrap/4.3.1/css/bootstrap.css'>
<link rel="stylesheet" href="css/Custom.css" type="text/css">
<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/4.3.1/js/bootstrap.bundle.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<body>
	<div class="container-flucid">

		<div class="row">
			<div
				class="col-lg-12 btn-dark text-right  margin-left:0  margin-right:0px">
				<ul class="list-inline">
					<li class="list-inline-item "><a class="text-light"
						href="HomePage.jsp"> <%=Information.raoHome%>
					</a></li>
					<li class="list-inline-item "><a class="text-light"
						href="LoginPage.jsp"> <%=Information.LogoutTitle%>
					</a></li>
					<li class="list-inline-item "><a class="text-light" href="#">
							<%=Information.joinPartner%>
					</a></li>
					<li class="list-inline-item "><a class="text-light" href="#">
							<%=Information.reachus%>
					</a></li>
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
	<form id="abc" name="knrai" action="UserCreate" method="post"
		class="form-horizontal needs-validation" autocomplete="off" novalidate>
		<div class="row justify-content-md-center">
			<div class="col-sm-12">
				<div class="form-row">
					<div class="col-sm-3 offset-sm-1">
						<label for="UserRolType"><%=Information.UserType%></label> <select
							name="User">
							<c:forEach items="${listCategory}" var="category">
								<option>"${category}"</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div>


					</div>
				</div>
			</div>
		</div>

	</form>

	<script>
		$(function() {
			$('#myList a:last-child').tab('show')
		})
	</script>

</body>
</html>