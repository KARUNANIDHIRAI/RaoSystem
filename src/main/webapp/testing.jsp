<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>

	<meta name="viewport" content="width=device-width, initial-scale=1" charset="ISO-8859-1">
</head>
<body>
	<form id="abc" name="knrai" action="TestServlet" method="post"
		class="form-horizontal needs-validation" autocomplete="off" novalidate>
		<div class="row justify-content-md-center">
			<div class="col-sm-12">
				<div class="form-row">
					<div>
						<p class="text-danger "><%=session.getAttribute("raju") == null ? "" : session.getAttribute("raju")%></p>
						<%=	session.removeAttribute("raju")	%>





					</div>
				</div>
			</div>
		</div>

	</form>


</body>
</html>