<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert Job Information: </h1>
	<br />
	<br />
	Message Body:
	<br />
	<textarea style="font-size:14pt;" rows="20" cols="70" form="postJobForm" name="messageBody"></textarea>

	<form action="/JobPortal/PostJob" method="POST" id="postJobForm">
		Job Name: <input type="text" name="jobname" /> <br /> Poster Name: <input
			type="text" name="postername" /><br /> Secret Password:<input
			type="text" name="password" /><br /> Contact Phone: <input
			type="text" name="contactphone" /><br /> <input type="submit"
			value="submit" />
	</form>

</body>
</html>