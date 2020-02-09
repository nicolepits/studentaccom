<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Change Student Info</title>
<link rel="stylesheet" type="text/css" href="changeInfo1.css">
</head>
<body>
	
		
			<h1>Change you communication Info</h1>
		
		<form:form method="POST"
		          action="/distributed/student/updateStudent" modelAttribute="student">
			ID: <input type="text" name="id"><br>
			New Email: <input type="text" name="email"><br> New
			Phone number: <input type="text" name="phoneNumber"><br>
			<br>
			<br>

			<button>Change!</button>
		</form:form>
		
	

</body>
</html>