<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Application Form</title>
</head>
<body>
<table>


	<form:form method="post" action="/distributed/student/saveApp"
		modelAttribute="application">
Enter your application ID: <input type="text" name="id"/>
		<br>
Please enter your income: <input type="number" name="income" />
		<br>
Please enter your city of permanent residency: <input type="text"
			name="permanentResidency" />
		<br>
Please enter your years of study: <input type="number"
			name="yearsOfStudies" />
		<br>
Please enter your years of accomodation(if you don't have already, put 0): <input
			type="number" name="yearsOfAccomodation" />
		<br>
		Please enter your years of number of siblings: <input
			type="number" name="numberOfSiblings" />
			Please enter your city of studies: <input
			type="text" name="cityOfStudies" />
		<input type="submit" value="Submit">
	</form:form>
	</table>
</body>