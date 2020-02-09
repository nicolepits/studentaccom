<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/studentMenu">Student</a> | <a href="${pageContext.request.contextPath}/adminMenu">Admin</a> |<a href="${pageContext.request.contextPath}/employee/showActivation">Employee</a>| <a href="javascript:document.getElementById('logout').submit()">Logout</a>

<h3>Welcome to our Student Accomodation Application</h3>


<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
