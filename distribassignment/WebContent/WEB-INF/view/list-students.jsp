<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${students}
	<input type="button" value="Add Customer"
	                           onclick="window.location.href='showAddForm'; return false;"
	/>
</body>
</html>