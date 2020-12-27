<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<table>
		<tr>
			<td>Id</td>
			<td>Sender Name</td>
			<td>Message</td>
			<td>Sender Email</td>




		</tr>

		<c:forEach items="${complaints}" var="complaint">
			<tr>
				<td><c:out value="${complaint.id}" /></td>
				<td><c:out value="${complaint.senderName}" /></td>
				<td><c:out value="${complaint.message}" /></td>
				<td><c:out value="${complaint.senderEmail}" /></td>




			</tr>

		</c:forEach>
	</table>



</body>
</html>