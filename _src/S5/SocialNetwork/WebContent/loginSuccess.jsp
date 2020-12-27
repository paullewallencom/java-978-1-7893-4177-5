<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Add Friends</h1>
	<s:form action="addFriend">
		<s:textfield key="name" label="User Name" />
		<s:submit />
	</s:form>

	<h1>Your Friends</h1>

	<s:iterator value="#session.user.friends" var="user">
		<li><s:property value="#user.userName" /></li>
	</s:iterator>

</body>
</html>