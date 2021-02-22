<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/22/2021
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form method="post">
    <input type="text" name="name" value="${post.getContent()}">
    <input type="submit" value="Lưu">
</form>
</center>
</body>
</html>
