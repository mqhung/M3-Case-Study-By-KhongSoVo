<%--
  Created by IntelliJ IDEA.
  User: ngominhhieu
  Date: 23/02/2021
  Time: 08:53
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
      <h2 class="text-center">Registation Form</h2>
    </div>
    <div class="panel-body">
      <form action="/register" method="post">
      <div class="form-group">
        <label for="usr">Name:</label>
        <input placeholder="Name" required="true" type="text" class="form-control" id="usr" name="name"/>
      </div>
        <div class="form-group">
          <label for="account">Account:</label>
          <input placeholder="Account" required="true" type="text" class="form-control" id="account" name="account"/>
        </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input placeholder="Email" required="true" type="email" class="form-control" id="email" name="email"/>
      </div>
      <div class="form-group">
        <label for="birthday">Birthday:</label>
        <input type="date" class="form-control" id="birthday" name="birthday"/>
      </div>
        <div class="form-group">
          <label for="phoneNumber">Phone Number</label>
          <input placeholder="Phone Number" required="true" type="text" class="form-control" id="phoneNumber" name="phoneNumber"/>
        </div>
        <div class="form-group">
          <label for="avata">Avata</label>
          <input required="true" type="text" class="form-control" id="avata" name="avata"/>
        </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input placeholder="Password" required="true" type="password" class="form-control" id="pwd" name="password"/>
      </div>
      <div class="form-group">
        <label for="confirmation_pwd">Confirmation Password:</label>
        <input placeholder="Confirmation Password" required="true" type="password" class="form-control" id="confirmation_pwd" name="confirmation_pwd"/>
      </div>
      <div class="form-group">
        <label for="address">Address:</label>
        <input placeholder="Address" type="text" class="form-control" id="address" name="address"/>
      </div>
      <button class="btn btn-success">Register</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>