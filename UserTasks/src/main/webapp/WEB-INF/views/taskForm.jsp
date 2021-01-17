<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Task Form</title>
</head>
<body>
    <h1>Add new Task</h1>
    <p><strong>Note:</strong> type="date" is not supported in Safari or Internet Explorer 11 (or earlier).</p>
    <form:form modelAttribute="newTask">
        <form:errors path="*" element="div"/>
        <div>
            <table>
                <tr>
                    <td>
                        <form:hidden path="taskId"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="taskName">Name</form:label>
                        <form:input path="taskName" required="true"/>
                        <form:errors path="taskName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="taskStartDate">Start Date</form:label>
                        <form:input path="taskStartDate" required="true" type="date"/>
                        <form:errors path="taskStartDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="taskEndDate">End Date</form:label>
                        <form:input path="taskEndDate" required="true" type="date"/>
                        <form:errors path="taskEndDate"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="taskDescription">Descriptions</form:label>
                        <form:input path="taskDescription" required="true"/>
                        <form:errors path="taskDescription"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="taskSeverity">Severity</form:label>
                        <form:input path="taskSeverity" required="true"/>
                        <form:errors path="taskSeverity"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="taskEmail">Email</form:label>
                        <form:input path="taskEmail" readonly="true" value="${taskEmail}"/>
                        <form:errors path="taskEmail"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add Task"/>
                    </td>
                </tr>
            </table>

        </div>

    </form:form>
    

</body>
</html>