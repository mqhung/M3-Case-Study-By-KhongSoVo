
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Ohh, hình như có thằng nào đấy gửi yêu cầu kết bạn cho mình kìa</h3>
<h4>Giờ như nào???????</h4>
<table>
    <tr>
        <td>Đồng ý</td>
        <td>Từ chối</td>
    </tr>
    <tr>
        <td><a href="/facebook?action=accept&userId=${userId}&friendId=${friendId}&relationshipId=${relationshipId}">Accept Request</a></td>
        <td><a href="/facebook?action=deny&userId=${userId}&friendId=${friendId}&relationshipId=${relationshipId}">Deny Request</a></td>
    </tr>
</table>
</body>
</html>
