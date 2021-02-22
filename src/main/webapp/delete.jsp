<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/22/2021
  Time: 10:06 AM
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
    <div>
        ${post.getContent()}
    </div><br>
    <img style="max-width: 400px ; max-height: 600px"  src="${post.getImage()}"><br><br>
    <input type="submit" value="Delete">
</form>
</center>


</body>
</html>
