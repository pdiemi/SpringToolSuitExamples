<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefic="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Employees</title>
</head>
<body>
<h1 style="color:blue"><marquee behavior="alternate">List of Employees</marquee></h1>
	<ul>
		<c:foreach items="employess" var=emps>
			<li>{emps.id}</li>
			<li>{emps.name}</li>
		</c:foreach>
		<% %>
	</ul>

</body>
</html>