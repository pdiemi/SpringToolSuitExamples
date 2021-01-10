<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find User</title>
</head>
<body>
	<a href="../dashboard">Back to Dash Board</a>
	<h1>Find User</h1>
	<form:form modelAttribute="userToFind">
		<form:errors path="*" element="div" />
		<div>
			<table>
				<tr>
					<td><form:label path="userEmail">Email </form:label> 
					<form:input path="userEmail" required="true" /> 
					<form:errors path="userEmail" /></td>
				</tr>

				<tr>
               		<td colspan = "2">
               		<input type = "submit" value = "Find User"/></td>
           		 </tr>
			</table>
		</div>
	</form:form>
	<form action="../dashboard" method="get">
		<input type = "submit" value = "Cancel"/>
	</form>
</body>
</html>