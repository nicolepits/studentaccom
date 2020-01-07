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
		          action="/distribassignment/saveStudent" modelAttribute="student">>
		  Student name:<br>
		  <input type="text" name="firstname"><br>
		  Department id:<br>
		  <input type="text" name="departmentid"><br>
		  Email:<br>
		  <input type="text" name="email"><br>
		  Phone number:<br>
		  <input type="text" name="phonenumber"><br>
		  Number of Siblings:<br>
		  <input type="text" name="numberofsiblings"><br>
		  <input type="submit" value="Submit">
		</form:form> 
	</table>
</body>
</html>