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
<h2>Give the id of the student you want to activate:<br></h2>
       
        <br><br><br>


        <form:form method="post" action="/distributed/employee/activateStudent">


            <div class="container">
               

                <label for="id"><b>Id</b></label>
                <input type="text" placeholder="Enter Id" name="id" required><br>

                <button type="submit">Activate!</button>
             </div>

        </form:form>
</body>
</html>