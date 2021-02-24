<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/21/2021
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body><center>
<form method="post" >
    <h3>Bạn đang nghĩ gì?</h3>
    <input type="text" name ="content" placeholder="Bạn đang nghĩ gì?"/><br><br>
    <input type="text" name="image" placeholder="image"/><br><br>

    <input type="submit" value="Đăng">
    <input type="reset" value="Reset">
    <a style="text-decoration: none " href="/facebook?action=home&id=${userId}" >Hủy</a>

</form>
</center></body>
</html>
