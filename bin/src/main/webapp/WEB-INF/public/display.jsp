<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@page import="com.reliable.model.Customer"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>Reliable Project
</head>
<body>
	<h2>Sample table for CRUD operations</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Password</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="customer">
			<tr>
				<td><c:out value="${customer.id}" /></td>
				<td><c:out value="${customer.userName}" /></td>
				<td><c:out value="${customer.userPassword}" /></td>
				<form:form modelAttribute="user" class="form-horizontal"
					method="put" enctype="multipart/form-data" action="edit"
					charset="utf-8" accept-charset="UTF-8">

					<td><a href="<c:url value='/delete/${customer.id}'/>">Delete</a></td>

				</form:form>
			</tr>
		</c:forEach>
		<c:forEach items="${list}" var="customer">
			<tr>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
