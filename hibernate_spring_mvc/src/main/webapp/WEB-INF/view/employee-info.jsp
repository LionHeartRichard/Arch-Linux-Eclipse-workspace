<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
<h2>Employee INFO</h2>
<br>
<form:form action="saveEmployee" modelAttribute="employee">

	<form:hidden path="id"/>
	
	Name: <form:input path="name"/>
	<br>
	Surname: <form:input path="surname"/>
	<br>
	Department: <form:input path="department"/>
	<br>
	Salary: <form:input path="salary"/>
	<br>
	<input type="submit" value="ok">
</form:form>
</body>
</html>