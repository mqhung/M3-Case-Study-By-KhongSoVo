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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">Login Form</h2>
            <h4 style="color: red">${msg}</h4>
        </div>
        <div class="panel-body">
            <form method="post">
                <div class="form-group">
                    <label for="account">Account:</label>
                    <input placeholder="Account" required="true" type="text" class="form-control" id="account" name="account"/>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input placeholder="Password" required="true" type="password" class="form-control" id="pwd" name="password"/>
                </div>
                <button class="btn btn-success">Login</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>