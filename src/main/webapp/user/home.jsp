<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Social Network</title>
</head>
<body>
<center>
    <h4>
        <a href="/facebook?action=find&userId=${userId}">Find Friend By Id</a> <br>
    </h4>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Account</th>
            <th>Password</th>
            <th>Email</th>
            <th>Avatar</th>
            <th>Phone Number</th>
            <th>Address</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getAccount()}"/></td>
                <td><c:out value="${user.getPassword()}"/></td>
                <td><c:out value="${user.getEmail()}"/></td>
                <td><c:out value="${user.getAvatar()}"/></td>
                <td><c:out value="${user.getPhoneNumber()}"/></td>
                <td><c:out value="${user.getAddress()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
