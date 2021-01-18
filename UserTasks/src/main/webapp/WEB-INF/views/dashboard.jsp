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

<title>Dash Board</title>
</head>
<body>
    <div class="container">
        <h1>Tasks</h1>
        <a href="./add-task">Add new task</a>
        <p>List of tasks for ${user.getUserFullName()}</p>
        <table class="table table-bordered table-hover">
            <!--
            <caption>List of tasks for ${user.getUserFullName()}</caption>
            -->
            <thead class="thead-dark">
                <tr>
                    <th>Task ID</th>
                    <th>Task Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Description</th>
                    <th>Severity</th>
                    <th>Email</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <c:forEach items="${taskList}" var="task">
                <tbody>
                    <tr>
                        <th>${task.getTaskId()}</th>
                        <td>${task.getTaskName()}</td>
                        <td>${task.getTaskStartDate()}</td>
                        <td>${task.getTaskEndDate()}</td>
                        <td>${task.getTaskDescription()}</td>
                        <td>${task.getTaskSeverity()}</td>
                        <td>${task.getTaskEmail()}</td>
                        <td><a href="./update-task/${task.getTaskId()}">Update</a></td>
                        <td><a href="./delete-task/${task.getTaskId()}">Delete</a></td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>

</body>
</html>