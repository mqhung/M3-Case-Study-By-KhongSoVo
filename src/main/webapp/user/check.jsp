
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${listNotice}" var="notice">
        <tr>
            <td><c:out value="${notice.getContent()}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="/facebook?action=accept&userId=${userId}&friendId=${friendId}&relationshipId=${relationshipId}">Accept Request</a>
<a href="/facebook?action=deny&userId=${userId}&friendId=${friendId}&relationshipId=${relationshipId}">Deny Request</a>
</body>
</html>
