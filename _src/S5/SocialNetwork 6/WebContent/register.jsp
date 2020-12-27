<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<h1>Register</h1>
<s:form action="register">
		<s:textfield key="user.userName" label="User Name"/>
		<s:password key = "user.password" label="Password"/>
		<s:submit/>
 	</s:form>
</body>
</html>