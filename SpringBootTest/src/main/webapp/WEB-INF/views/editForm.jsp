<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Form</title>
</head>
<body>
	<h1 style="color: blue">
		Edit Employee Form
	</h1>

	<form action="save" method="post">
		Emp No: <input type="text" name="id" value="${emp.getId()}" /><br> 
		Emp	Name: <input type="text" name="name" value="${emp.name}" /><br> 
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>