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
<h2><u>Please give the username for the user you want to update and the new password:</u></h2>
	<form:form method="POST"
		          action="${pageContext.request.contextPath}/admin/updateUser" modelAttribute="user">
            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="password"><b>New Password</b></label>
                <input type="password" placeholder="Enter new Password" name="password" required>
            
                <button type="submit">Update</button>
                
              </div>
    </form:form>
</body>
</html>