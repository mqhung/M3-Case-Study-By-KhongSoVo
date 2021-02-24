<%@ page import="controler.LoginServlet" %><%--
  Created by IntelliJ IDEA.
  User: ngominhhieu
  Date: 23/02/2021
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registation Form</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label>
        <input id="tab-2" type="radio" name="tab" class="for-pwd"><label for="tab-2" class="tab">Forgot Password</label>
        <div class="login-form">
            <div class="sign-in-htm">
                <div class="panel-heading">
                    <h4 style="color: red">${msg}</h4>
                </div>
                <form action="/login" method="post">
                <div class="group">
                    <label for="account" class="label">Account</label>
                    <input id="account" type="text" class="input" name="account">
                </div>
                <div class="group">
                    <label for="password" class="label">Password</label>
                    <input id="password" type="password" class="input" data-type="password" name="password">
                </div>
                <button class="btn btn-success">Login</button>
                    <button class="btn btn-success">Register Account</button>
                <div class="hr"></div>
            </div>
            </form>
            <div class="for-pwd-htm">
                <div class="group">
                    <label for="user" class="label">A</label>
                    <input id="user" type="text" class="input">
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Reset Password">
                </div>
                <div class="hr"></div>
            </div>
        </div>
    </div>
</div>

</body>
</html>