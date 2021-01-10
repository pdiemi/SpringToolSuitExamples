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
	<a style="color:blue">${message}</a>
	<table border="1" width="90%">
		<tr>
			<th>Full Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Country</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<tr>
			<td>${user.userFullName}</td>
			<td>${user.userEmail}</td>
			<td>${user.userPassword}</td>
			<td>${user.userCountry}</td>
			<td><a href="edit-user/${user.userEmail}">Update</a></td>
			<td><a href="delete-user/${user.userEmail}">Delete</a></td>
		</tr>

	</table>
</body>
</html>