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
<h2><u>Please give the username for the user you want to update his role from and which will be the new role:</u></h2>
	<form:form method="post" action="${pageContext.request.contextPath}/admin/updateRole"
		modelAttribute="authorities">
            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required><br>

                <label for="authority"><b>New Role</b></label>
                <input type="text" placeholder="Enter New Role" name="authority" required><br><br>
            
                <button type="submit">Update</button>
                
              </div>
     </form:form>
</body>
</html>