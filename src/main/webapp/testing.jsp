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
						<p class="text-danger "><%=session.getAttribute("karunanidhirai") == null ? "" : session.getAttribute("karunanidhirai")%></p>
						<%
							session.removeAttribute("karunanidhirai");
						%>

						<%
							String name = (String) session.getAttribute("name");
							out.print("your name" + name);
						%>

						<h3>My name is <% session.getAttribute("karunanidhirai");%></h3>

					</div>
				</div>
			</div>
		</div>

	</form>


</body>
</html>