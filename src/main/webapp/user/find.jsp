<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
      crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find By Id</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label class="sr-only" for="message">post</label>
        <textarea class="form-control" id="message" rows="3" name="friendId" placeholder="Input your user ID you wanna find"></textarea>
    </div>
    <div class="btn-group">
        <input type="submit" class="btn btn-primary" value="Find Friend">
    </div>
<%--    <input type="text" name="friendId" placeholder="Input your user ID you wanna find">--%>
<%--    <input type="submit" value="Find">--%>
</form>
<h3>Result</h3>
<table>
    <tr>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getId()}</td>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getAccount()}</td>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getPassword()}</td>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getEmail()}</td>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getAvatar()}</td>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getPhoneNumber()}</td>
        <td style="border-collapse: collapse;border: 1px solid black">${user.getAddress()}</td>
        <td></td>
        <td ><a href="facebook?action=add&userId=${userId}&friendId=${friendId}">Add Friend</a></td>
    </tr>
</table>
<br>
<div>
    <img src="https://i.guim.co.uk/img/media/3841125b290fc60b6b7eaf004e7f3cb6103793da/0_193_3500_2101/master/3500.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=fc7d8685850ce7e87102803de2db659c" alt=""
         width="500px", height="500px">
</div>
</body>
</html>
