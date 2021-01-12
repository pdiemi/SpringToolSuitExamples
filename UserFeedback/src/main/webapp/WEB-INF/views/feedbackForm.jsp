<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Feedback</title>
</head>
<body>
	<a href="dashboard">Back to Dash Board</a>
	<h1>Add New Feedback</h1>
	<form:form modelAttribute="newFeedback">
		<form:errors path="*" element="div" />
		<div>
			<table>
				<tr>
					<td><form:label path="feedbackText">Feedback Text </form:label> 
					<form:input path="feedbackText" required="true" /> 
					<form:errors path="feedbackText" /></td>
				</tr>

				<tr>
					<td><form:label path="feedbackRating">Rating </form:label> 
					<form:input path="feedbackRating" required="true" /> 
					<form:errors path="feedbackRating" /></td>
				</tr>

				<tr>
					<td><form:label path="user">User </form:label> 
					<form:input path="user" required="true" /> 
					<form:errors path="user" /></td>
				</tr>
				
				<tr>
               		<td colspan = "2">
               		<input type = "submit" value = "Submit"/></td>
           		 </tr>
			</table>
		</div>
	</form:form>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#feedbackDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>

</body>
</html>