<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users and Authorities List</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
	        <div class="ui segment">
	        User: <sec:authentication property="principal.username" />, Role: <sec:authentication property="principal.authorities"/>
	        </div>
	</sec:authorize>
</body>
</html>