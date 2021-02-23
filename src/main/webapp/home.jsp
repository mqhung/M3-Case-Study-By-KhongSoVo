<%--
  Created by IntelliJ IDEA.
  User: THINKPADX240
  Date: 2/21/2021
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>home</title>
</head>
<body>
<table>
    <c:forEach items="${listNotice}" var="notice">
        <tr>
            <td>${notice.getContent()}</td>
        </tr>
    </c:forEach>
</table>
<a href="/facebook?action=create&userId=${userId}" >Bạn đang nghĩ gì?</a><br><br>
<a style="text-decoration: none ; border: 1px" href="/facebook?action=profile&user_id=${userId}" >Trang cá nhân</a>
<table>
    <c:forEach items="${list}" var="post">
        <tr>
        <td><img src="${post.getImage()}"></td>
        <td>${post.getContent()}</td>
        <td>${post.getLikeAmount()}</td>
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
<%--=======--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>List Post</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <a href="/facebook?action=create" >Bạn đang nghĩ gì?</a><br><br>--%>
<%--    <a style="text-decoration: none ; border: 1px" href="/facebook?action=home&user_id=1" >Trang cá nhân</a>--%>


<%--    <c:forEach items="${posts}" var="post">--%>
<%--        <H5>Nguyễn Văn Tú</H5>--%>
<%--        <div>--%>
<%--                ${post.getContent()}--%>

<%--            <a style="text-decoration: none" href="/facebook?action=delete&id=${post.getId()}">Xóa</a>--%>
<%--            <a style="text-decoration: none" href="/facebook?action=edit&id=${post.getId()}">Sửa</a>--%>


<%--        </div>--%>

<%--        <br>--%>
<%--        <img style="max-width: 400px ; max-height: 600px" src="${post.getImage()}"><br><br>--%>
<%--        <button>--%>
<%--            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Bot%C3%B3n_Me_gusta.svg/1200px-Bot%C3%B3n_Me_gusta.svg.png"--%>
<%--                 alt="" style="width:30px;height:30px;border:0;">--%>
<%--        </button>--%>
<%--        <button>--%>
<%--            <img src="https://cdn0.iconfinder.com/data/icons/facebook-feature/32/facebook-13-512.png" alt=""--%>
<%--                 style="width:30px;height:30px;border:0;">--%>
<%--        </button>--%>
<%--        <button>--%>
<%--            <img src="https://banner2.cleanpng.com/20180704/jh/kisspng-computer-icons-share-icon-facebook-font-awesome-li-5b3c8caec6bde4.1051138415306948308141.jpg"--%>
<%--                 alt="" style="width:30px;height:30px;border:0;">--%>
<%--        </button>--%>
<%--        <h6>--%>
<%--            -----------------------------------------------------------------------------------------------------------------------------</h6>--%>
<%--    </c:forEach>--%>
<%--</center>--%>

<%--</body>--%>
<%--</html>--%>
<%-->>>>>>> d0f66aa50c053d51613edcb052faf5ea7c5e7ec3--%>
