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
<form method="post" enctype="multipart/form-data">
    <h3>Bạn đang nghĩ gì?</h3>
    <input type="text" name ="content" placeholder="Bạn đang nghĩ gì?"/><br><br>
    <input type="file" name="image" placeholder="image"/><br><br>

    <input type="submit" value="Đăng">
    <input type="reset" value="reset">
    <a href="/facebook?action=home&user_id=1" >Hủy</a>

</form>
<%--    <a href="/facebook?action=home&user_id=1" >Back To List</a>--%>

</center></body>
</html>
