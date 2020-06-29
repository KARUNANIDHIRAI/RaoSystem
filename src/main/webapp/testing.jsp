<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
	<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1" charset="ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
</head>
<body>
	<form id="abc" name="knrai" action="Inventory/RwaSubscriptionReport" method="post"
		class="form-horizontal needs-validation" autocomplete="off" novalidate>
		<div class="row justify-content-md-center">
			<div class="col-sm-12">
				<div class="form-row">
					<div>
						<c:forEach items="${EmpList}" var="product" >
								<tr>
									<td>${product. }</td>
									<td>${product.name }</td>
									<td>${product.price }</td>
									<td>${product.quantity }</td>
								</tr>
							</c:forEach>

					</div>
				</div>
			</div>
		</div>

	</form>


</body>
</html>