<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
	<a href="dashboard">Back to Dash Board</a>
	<h1>Add New User</h1>
	<form:form modelAttribute="newUser">
		<form:errors path="*" element="div" />
		<div>
			<table>
				<tr>
					<td><form:label path="userFullName">Full Name </form:label> 
					<form:input path="userFullName" required="true" /> 
					<form:errors path="userFullName" /></td>
				</tr>

				<tr>
					<td><form:label path="userEmail">Email </form:label> 
					<form:input path="userEmail" required="true" /> 
					<form:errors path="userEmail" /></td>
				</tr>

				<tr>
					<td><form:label path="userCountry">Country </form:label> 
					<form:input path="userCountry" required="true" /> 
					<form:errors path="userCountry" /></td>
				</tr>

				<tr>
					<td><form:label path="userPassword">Password </form:label> 
					<form:input path="userPassword" required="true" type="password" /> 
					<form:errors path="userPassword" /></td>
				</tr>
				
				<tr>
               		<td colspan = "2">
               		<input type = "submit" value = "Add User"/></td>
           		 </tr>
			</table>
		</div>
	</form:form>

</body>
</html>