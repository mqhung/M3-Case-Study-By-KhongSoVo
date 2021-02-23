<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: THINKPADX240
  Date: 2/23/2021
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <s:forEach items="${listMess}" var="mess">
        <tr>
            <td><img src="${mess.getAvatar()}" width="20px"></td>
            <td>${mess.getContent()}</td>
        </tr>
    </s:forEach>

</table>
<form>
    <textarea name="messContent" ></textarea>
    <input type="submit" value="send">
 </form>
</body>
</html>
