<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Message:<br /> <textarea rows="500" style="height:200px;font-size: 14pt;" form="complaintForm" name="complaint"></textarea><br />


<form action="/complaintsystem/submitComplaint" method="post" id="complaintForm">
	
	Email: <input type ="text" name="email" /><br />
	Name: <input type = "text" name="name" /><br />
	<input type = "submit" value="Submit"/>
</form>

</body>
</html>