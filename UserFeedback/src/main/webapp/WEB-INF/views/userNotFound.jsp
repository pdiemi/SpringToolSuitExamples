<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find User</title>
</head>
<body>
	<a href="dashboard">Back to Dash Board</a>
	<h1>Find User</h1>
	<a style="color:red">${message}</a><br><br>
	<form action="find-user" method="get">
		<input type = "submit" value = "Find User"/>
	</form>
	
</body>
</html>