<%--
  Created by IntelliJ IDEA.
  User: THINKPADX240
  Date: 2/24/2021
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html>
<head>
    <title>home</title>
</head>
<body>
<%--<table>--%>
<%--    <c:forEach items="${listNotice}" var="notice">--%>
<%--        <tr>--%>
<%--            <td>${notice.getContent()}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<a href="/facebook?action=create&userId=${userId}" >Bạn đang nghĩ gì?</a><br><br>--%>
<a style="text-decoration: none ; border: 1px" href="/facebook?action=profile&userId=${userId}" >Trang cá nhân</a>
<%--<table>--%>
<%--    <c:forEach items="${list}" var="post">--%>
<%--        <tr>--%>
<%--            <td><img src="${post.getImage()}"></td>--%>
<%--            <td>${post.getContent()}</td>--%>
<%--            <td>${post.getLikeAmount()}</td>--%>
<%--            <td><a href="/facebook?action=edit&userId=${userId}&postId=${post.getId()}">Edit</a></td>--%>
<%--            <td><a href="/facebook?action=delete&userId=${userId}&postId=${post.getId()}">Delete</a></td>--%>
<%--            <td><a href="facebook?action=likes&userId=${userId}&postId=${post.getId()}">like</a></td>--%>
<%--            <c:forEach items="${post.getListComment()}" var="comment">--%>
<%--                <td><img src="${comment.getAvatar()}" width="30px"></td>--%>
<%--                <td>${comment.getContent()}</td>--%>
<%--            </c:forEach>--%>
<%--            <td><form method="post" action="/facebook?action=comment&userId=${userId}&postId=${post.getId()}">--%>
<%--                <textarea name="content"></textarea>--%>
<%--                <input type="submit" value="Comment">--%>
<%--            </form></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<table>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td><img src="${user.getAvatar()}" width="100px"></td>
            <td>${user.getAccount()}</td>
            <td><a href="/facebook?action=messeage&userId=${userId}&friendId=${user.getId()}">send messeage</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
</body>
</html>
