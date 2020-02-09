<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><u>Please enter the username of the user you wish to delete:</u></h2>

	<form:form method="post" action="${pageContext.request.contextPath}/admin/deleteUser">
	
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>
            
                <button type="submit">Delete</button>
    </form:form>
</body>
</html>