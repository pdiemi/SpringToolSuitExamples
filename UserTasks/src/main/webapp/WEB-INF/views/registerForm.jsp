<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <a href="..">Back to Home</a><br>
    <form:form modelAttribute="newUser">
        <form:errors path="*" element="div"/>
        <div>
            <table>
                <tr>
                    <td>
                        <form:label path="userFullName">Full Name</form:label>
                        <form:input path="userFullName" required="true"/>
                        <form:errors path="userFullName"/>
                    </td>
                </tr>
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
                        <form:input path="password" required="true"/>
                        <form:errors path="password"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Register"/>
                    </td>
                </tr>
            </table>

        </div>

    </form:form>
</body>
</html>