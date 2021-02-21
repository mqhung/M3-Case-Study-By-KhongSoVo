<%--
  Created by IntelliJ IDEA.
  User: minh.nv
  Date: 2/21/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Post</title>
</head>
<body>
<c:forEach items="${posts}" var="post">
    <div>
            ${post.getContent()}
    </div><br>
    <img style="max-width: 400px ; max-height: 600px"  src="${post.getImage()}"><br><br>
    <button name="button" type="button">Like</button><br><br>

    </c:forEach>
</body>
</html>
