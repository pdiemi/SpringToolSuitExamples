<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefic="c"%>
<%@ taglib url="http://www.springframework.org/tags/form" prefic="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
	<h1>Add New Employee</h1>

	<form:form modelAttribute="form">
		<form:error path="" element="div" />
		<div> <!-- Spring form -->
			<form:label path="name">Employee Name</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</div>

		<div> <!-- Normal submit form -->
			<input type="submit value=" Add Employee"/>
		</div>

	</form:form>

</body>
</html>