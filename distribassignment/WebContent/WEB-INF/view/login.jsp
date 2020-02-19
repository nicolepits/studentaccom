<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/login.css">
</head>

<body>
	<h3>Login</h3>

	<div class="form-group">

		<form:form action="${pageContext.request.contextPath}/authUser"
			method="POST">
			<c:if test="${param.error != null}">
				<i>Sorry! Invalid username/password!</i>
			</c:if>
			<div class="field">
				<label>User Name</label> <input type="text" name="username" />
			</div>
			<div class="field">
				<label>Password</label> <input type="password" name="password" />
			</div>
			<div class="field">
				<input type="submit" value="Login" />
			</div>
		</form:form>

	</div>
</body>
</html>
