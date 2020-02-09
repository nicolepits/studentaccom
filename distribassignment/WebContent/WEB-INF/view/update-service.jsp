<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update a service's access</title>
</head>
<body>
<h2>Please give the id of the service and the access you want to give to it:</h2>
	<form:form method="post" action="${pageContext.request.contextPath}/admin/updateService"
		modelAttribute="services">
            <div class="container">
                <label for="id"><b>ID</b></label>
                <input type="text" placeholder="Enter Service's name" name="id" required><br>

                <label for="authority"><b>New Access</b></label>
                <input type="text" placeholder="Enter New Access" name="authority" required><br><br>
            
                <button type="submit">Update!</button>
                
              </div>
    </form:form>
</body>
</html>