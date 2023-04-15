<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>

<h2>Welcome dear employee! Please enter information</h2>
<br>
<br>
<form:form method="GET" action = "getEmplView" modelAttribute="employee">
	Name <form:input path="name"/>
	<form:errors path="name"/>
	<br><br>
	Surname <form:input path="surname"/>
	<form:errors path="surname"/>
	<br><br>
	Department <form:input path="department"/>
	<form:errors path="department"/>
	<br><br>
	Salary <form:input path="salary"/>
	<form:errors path="salary"/>
	<br><br>
	Phone number <form:input path="phone"/>
	<form:errors path="phone"/>
	<br>
	Email<form:input path="email"/>
	<form:errors path="email"/>
	<br>
	<input type="submit" value="ok">
</form:form>
</body>
</html>