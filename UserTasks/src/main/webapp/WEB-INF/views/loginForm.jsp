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
<title>Login</title>
</head>
<body>
    <div class="container">
    <h1>Login</h1>
    <a href="..">Back to Home</a><br>
    <form:form modelAttribute="user">
        <form:errors path="*" element="div"/>
        <div>
            <table>
                <tr>
                    <td>
                        <form:label path="userEmail">Email</form:label>
                        <form:input path="userEmail" required="true"/>
                        <form:errors path="userEmail"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="password">Password</form:label>
                        <form:input path="password" type="Password" required="true"/>
                        <form:errors path="password"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>

        </div>

    </form:form>
    </div>
</body>
</html>