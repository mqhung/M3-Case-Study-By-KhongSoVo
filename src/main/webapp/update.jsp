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
    <input type="text" name="content" value="${post.getContent()}"><br><br>
    <img style="max-width: 400px ; max-height: 600px" src="${post.getImage()}"><br><br>
    <input type="submit" value="Lưu">
    <a style="text-decoration: none ; border: 1px" href="/facebook?action=home&id=${userId}" >Hủy</a>

</form>
</center>
</body>
</html>
