<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/22/2021
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find By Id</title>
</head>
<body>
<form method="post">
    <input type="text" name="id" value="${users.getId()}">
    <input type="submit" value="Find">
</form>
<h3>Result</h3>
<table>
    <tr>
        <td>${users.getId()}</td>
        <td>${users.getAccount()}</td>
        <td>${users.getPassword()}</td>
        <td>${users.getEmail()}</td>
        <td>${users.getAvatar()}</td>
        <td>${users.getPhoneNumber()}</td>
        <td>${users.getAddress()}</td>
    </tr>
</table>
</body>
</html>
