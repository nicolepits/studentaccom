<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <title>Get rank</title>
        <link rel="stylesheet" type="text/css" href="deleteUser.css">
    </head>
    <body>
        <center>
            <h2><u>Application ID:</u></h2>
			<form:form method="GET"
		          action="/distributed/student/viewResultRank" modelAttribute="id">
            <div class="container">
                <label for="id"><b>ID</b></label>
                <input type="text" placeholder="Enter ID" name="id" required>
            
                <button type="submit">Show results</button>
            </form:form>
              </div>
        </center>
    </body>
</html>