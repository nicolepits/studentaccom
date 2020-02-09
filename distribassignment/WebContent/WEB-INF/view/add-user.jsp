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
<h2><u>Welcome!</u><br></h2>
       <h3> If you want to add a new User please fill the fields below!</u></h3>
        <br><br><br>


        <form:form method="post" action="/distributed/admin/saveUser"
		modelAttribute="user">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required><br>

                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required><br>

                <label for="enabled"><b>Enabled</b></label>
                <input type="text" placeholder="Enabled value" name="enabled" required><br>

                <button type="submit">Add User</button>

        </form:form>
</body>
</html>