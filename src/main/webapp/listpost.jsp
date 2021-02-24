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
<center>
    <a href="/facebook?action=home&id=${userId}">HOME</a>
    <table>
        <c:forEach items="${list}" var="post">
            <tr>
                <td><img src="${post.getImage()}"></td>
                <td>${post.getContent()}</td>
                <td>${post.getLikeAmount()}</td>
                <td><a href="/facebook?action=edit&userId=${userId}&postId=${post.getId()}">Edit</a></td>
                <td><a href="/facebook?action=delete&userId=${userId}&postId=${post.getId()}">Delete</a></td>
                <td><a href="facebook?action=likes&userId=${userId}&postId=${post.getId()}">like</a></td>
                <c:forEach items="${post.getListComment()}" var="comment">
                    <td><img src="${comment.getAvatar()}" width="30px"></td>
                    <td>${comment.getContent()}</td>
                </c:forEach>
                <td><form method="post" action="/facebook?action=comment&userId=${userId}&postId=${post.getId()}">
                    <textarea name="content"></textarea>
                    <input type="submit" value="Comment">
                </form></td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
