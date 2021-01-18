<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add Task</title>
</head>
<body>
    <div class="container">
    <h1>Add new Task</h1>
    <p><strong>Note:</strong> type="date" is not supported in Safari or Internet Explorer 11 (or earlier).</p>
    <form:form modelAttribute="newTask">
        <form:errors path="*" element="div"/>
        <div>
                <tr>
                    <td>
                        <form:hidden path="taskId"/>
                    </td>
                </tr>
                <br>
                <tr>
                    <td>
                        <form:label path="taskName">Name</form:label>
                        <form:input path="taskName" required="true"/>
                        <form:errors path="taskName"/>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td>
                        <form:label path="taskStartDate">Start Date</form:label>
                        <form:input path="taskStartDate" required="true" type="date"/>
                        <form:errors path="taskStartDate"/>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td>
                        <form:label path="taskEndDate">End Date</form:label>
                        <form:input path="taskEndDate" required="true" type="date"/>
                        <form:errors path="taskEndDate"/>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td>
                        <form:label path="taskDescription">Descriptions</form:label>
                        <form:textarea path="taskDescription" rows="5" cols="30" required="true"/>
                        <form:errors path="taskDescription"/>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td>
                        <form:label path="taskSeverity">Severity</form:label>
                        <form:select path="taskSeverity" required="true" placeholder="choose severity">
                            <form:option value="High"/>
                            <form:option value="Medium"/>
                            <form:option value="Low"/>
                        </form:select>
                        <form:errors path="taskSeverity"/>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td>
                        <form:label path="taskEmail">Email</form:label>
                        <form:input path="taskEmail" readonly="true" value="${taskEmail}"/>
                        <form:errors path="taskEmail"/>
                    </td>
                </tr>
                <br>
                <br>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
        </div>

    </form:form>
    <br>
    <form action="./all-tasks" method="get">
        <input type = "submit" value = "Cancel"/>
    </form>
    </div>
</body>
</html>