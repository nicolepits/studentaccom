<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		 <form:form method="POST"
		          action="/distribassignment/student/saveStudent" modelAttribute="student">>
		  Student name:<br>
		  <input type="text" name="name"><br>
		  Department id:<br>
		  <input type="text" name="department.id"><br>
		  Email:<br>
		  <input type="text" name="email"><br>
		  Phone number:<br>
		  <input type="text" name="phoneNumber"><br>
		  <input type="submit" value="Submit">
		</form:form> 
	</table>
</body>
</html>