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
<h2>Please give the new service you want to add:</h2>
	<form:form method="post" action="${pageContext.request.contextPath}/admin/addService"
		modelAttribute="services">
            <div class="container">
                <label for="name"><b>New Service</b></label>
                <input type="text" placeholder="Enter New Service" name="name" required><br><br>
				<label for="authority"><b>Service's access</b></label>
                <input type="text" placeholder="Enter service's access" name="authority" required><br><br>
                
            
                <button type="submit">Save</button>
                
              </div>
    </form:form>
</body>
</html>