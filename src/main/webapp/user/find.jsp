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
    <input type="text" name="friendId">
    <input type="submit" value="Find">
</form>
<h3>Result</h3>
<table>
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getAccount()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getAvatar()}</td>
        <td>${user.getPhoneNumber()}</td>
        <td>${user.getAddress()}</td>
        <td><a href="facebook?action=add&userId=${userId}&friendId=${friendId}">Add Friend</a></td>
    </tr>
</table>
</body>
</html>
