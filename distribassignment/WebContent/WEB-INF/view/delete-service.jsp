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
<h2><u>Please give the ID for the service you wish to delete:</u></h2>
		<form:form method="post" action="${pageContext.request.contextPath}/admin/deleteService">
            <div class="container">
                <label for="id"><b>ID of service</b></label>
                <input type="text" placeholder="Enter id of service" name="id" required><br><br>

                <button type="submit">Delete</button>
                
              </div>
              
      </form:form>
      
</body>
</html>