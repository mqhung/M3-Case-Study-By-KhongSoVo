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
    <c:forEach items="${posts}" var="post">
        <H5>Nguyễn Văn Tú</H5>
        <div>
                ${post.getContent()}

            <a href="/facebook?action=delete&id=${post.getId()}">delete</a>
            <a href="/facebook?action=edit&id=${post.getId()}">edit</a>
        </div>
        <br>
        <img style="max-width: 700px ; max-height: 700px" src="${post.getImage()}"><br><br>
        <%--    <button name="button" type="button">Like</button><br><br>--%>
        <button>
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Bot%C3%B3n_Me_gusta.svg/1200px-Bot%C3%B3n_Me_gusta.svg.png"
                 alt="" style="width:30px;height:30px;border:0;">
        </button>
        <button>
            <img src="https://cdn0.iconfinder.com/data/icons/facebook-feature/32/facebook-13-512.png" alt=""
                 style="width:30px;height:30px;border:0;">
        </button>
        <button>
            <img src="https://banner2.cleanpng.com/20180704/jh/kisspng-computer-icons-share-icon-facebook-font-awesome-li-5b3c8caec6bde4.1051138415306948308141.jpg"
                 alt="" style="width:30px;height:30px;border:0;">
        </button>
        <h6>
            -----------------------------------------------------------------------------------------------------------------------------</h6>
    </c:forEach>
</center>

</body>
</html>
