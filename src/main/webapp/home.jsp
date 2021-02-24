<%--
  Created by IntelliJ IDEA.
  User: THINKPADX240
  Date: 2/24/2021
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
</head>
<body>
<nav class="navbar navbar-light bg-white">
    <a href="#" class="navbar-brand">Bootsbook</a>
    <form class="form-inline">
        <div class="input-group">
            <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-primary" type="button" id="button-addon2">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </div>
    </form>
</nav>


<div class="container-fluid gedf-wrapper">
    <div class="row">
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">
                    <div class="h5">${user.getAccount()}</div>
                    <div class="h7 text-muted">email : ${user.getEmail()}</div>
                    <div class="h7">address: ${user.getAddress()}
                    </div>
                </div>
                <ul class="list-group list-group-flush">
                    <c:forEach items="${listUser}" var="user">
                    <li class="list-group-item">
                        <tr>
                            <td><img src="${user.getAvatar()}" width="50px"></td>
                            <td>${user.getAccount()}</td>
                            <td><a href="/facebook?action=messeage&userId=${userId}&friendId=${user.getId()}">messeage</a></td>
                            <td><a href="/facebook?action=profile&userId=${userId}&proId=${user.getId()}">profile</a></td>
                            <td ><a href="facebook?action=add&userId=${userId}&friendId=${user.getId()}">Add Friend</a></td>

                        </tr>
                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-md-6 gedf-main">
            <!--- \\\\\\\Post-->
            <div class="card gedf-card">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="true">Make
                                a new post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="images-tab" data-toggle="tab" role="tab" aria-controls="images" aria-selected="false" href="#images">Images</a>
                        </li>
                    </ul>
                </div>
                <form method="post" action="/facebook?action=create&userId=${userId}">
                    <div class="card-body">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                                <div class="form-group">
                                    <label class="sr-only" for="message">post</label>
                                    <textarea class="form-control" id="message" rows="3" placeholder="What are you thinking?" name ="content"></textarea>
                                </div>

                            </div>
                            <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                                <div class="form-group">
                                    <input type="text" placeholder="add image link" width="300px" name="image">
                                </div>
                                <div class="py-4"></div>
                            </div>
                        </div>
                        <div class="btn-toolbar justify-content-between">
                            <div class="btn-group">
                                <input type="submit" class="btn btn-primary" value="Post" >
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <!-- Post /////-->

            <!--- \\\\\\\Post-->
            <c:forEach items="${list}" var="post">
                <div class="card gedf-card">
                    <div class="card-header">
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="mr-2">
                                    <img class="rounded-circle" width="45" src="${post.getUserAvatar()}" alt="">
                                </div>
                                <div class="ml-2">
                                    <div class="h5 m-0">${post.getUserAcount()}</div>
                                    <div class="h7 text-muted">${post.getUserEmail()}</div>
                                </div>
                            </div>
                            <div>
                                <div class="dropdown">
                                    <button class="btn btn-link dropdown-toggle" type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
                                        <a class="dropdown-item" href="/facebook?action=edit&userId=${userId}&postId=${post.getId()}">Edit</a>
                                        <a class="dropdown-item" href="/facebook?action=delete&userId=${userId}&postId=${post.getId()}">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="card-body">
                        <div class="text-muted h7 mb-2"> <i class="fa fa-clock-o"></i>10 min ago</div>
                        <img src="${post.getImage()}>">

                        <p class="card-text">
                                ${post.getContent()}
                        </p>
                    </div>
                    <div class="card-footer">
                        <span class="card-link"><i class="fa fa-gittip"></i>${post.getLikeAmount()}</span>
                        <a href="facebook?action=likes&userId=${userId}&postId=${post.getId()}" class="card-link"><i class="fa fa-gittip"></i> Like</a>
                        <span class="card-link">${post.getCommentAmount()}</span>
                        <a href="#" class="card-link"><i class="fa fa-gittip"></i> comment</a>
                    </div>
                    <c:forEach items="${post.getListComment()}" var="comment">
                        <div class="card-body">
                            <p class="card-text">
                                <img src="${comment.getAvatar()}" width="30px"><span>${comment.getContent()} </span>
                            </p>
                        </div>
                    </c:forEach>
                    <div class="card-body">
                        <form method="post" action="/facebook?action=comment&userId=${userId}&postId=${post.getId()}">
                            <textarea name="content"></textarea>
                            <input type="submit" value="comment">
                        </form>
                    </div>
                </div>
            </c:forEach>
            <!-- Post /////-->

        </div>
        <div class="col-md-3">
            <c:forEach items="${listNotice}" var="notice">
            <div class="card gedf-card">
                <div class="card-body">
                    <h5 class="card-title">Notice</h5>
                    <p class="card-text">${notice.getContent()}</p>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>


</body>
</html>
