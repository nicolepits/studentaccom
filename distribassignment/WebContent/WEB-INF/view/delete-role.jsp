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

            <h2>Please give the the user's username whose role you wish to delete.</h2>
	<form:form method="post" action="${pageContext.request.contextPath}/admin/deleteRole">
            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required><br>

                <button type="submit">Delete!</button>
                
              </div>
   </form:form>
       
  
</body>
</html>