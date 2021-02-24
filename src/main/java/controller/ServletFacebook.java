package controller;

import model.*;
import service.messeageService.MesseageService;
import service.postService.PostService;
import service.commentService.CommentService;
import service.likesService.LikesService;
import service.noticeService.NoticeService;
import service.userService.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletFacebook", urlPatterns = "/facebook")
public class ServletFacebook extends HttpServlet {
    private PostService postService=new PostService();
    private LikesService likesService=new LikesService();
    private CommentService commentService=new CommentService();
    private NoticeService noticeService=new NoticeService();
    private UserService userService=new UserService();
    private MesseageService messeageService=new MesseageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "home":
                showAllPost(req,resp);
                break;
            case "likes":
                likePost(req,resp);
                break;
            case "messeage":
                showFormMesseage(req,resp);
                break;
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deletePost(req, resp);
                break;
            case "profile":
                showProfile(req,resp);
                break;

        }
    }

    private void showProfile(HttpServletRequest req, HttpServletResponse resp) {
        int userId=Integer.parseInt(req.getParameter("userId"));
        int proId=Integer.parseInt(req.getParameter("proId"));
        List<Post> list=postService.fillAll(proId);
        req.setAttribute("userId",userId);
        req.setAttribute("list",list);
        RequestDispatcher dispatcher=req.getRequestDispatcher("listpost.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deletePost(HttpServletRequest req, HttpServletResponse resp) {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int userId=Integer.parseInt(req.getParameter("userId"));
        Post post=postService.findById(postId);
        if (userId==post.getUser_id()) {
            likesService.deleteByPostId(postId);
            commentService.deleteByPostId(postId);
            postService.delete(postId);
            try {
                resp.sendRedirect("/facebook?action=home&id=" + userId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                resp.sendRedirect("/facebook?action=home&id=" + userId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int userId=Integer.parseInt(req.getParameter("userId"));
        Post post = postService.findById(postId);
        if (post.getUser_id()==userId) {
            req.setAttribute("post", post);
            req.setAttribute("userId", userId);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("update.jsp");
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                resp.sendRedirect("/facebook?action=home&id="+userId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        req.setAttribute("userId",userId);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormMesseage(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        int friendId= Integer.parseInt(req.getParameter("friendId"));
        List<Messeage> listMess=messeageService.findByTwoId(userId,friendId);
        req.setAttribute("listMess",listMess);
        RequestDispatcher dispatcher=req.getRequestDispatcher("messForm.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void likePost(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        int postId= Integer.parseInt(req.getParameter("postId"));
        Likes like =new Likes(postId,userId);
        int rowEffect =likesService.creatLike(like);
        if (rowEffect>0){
            User user=userService.getById(userId);
            int user_id=postService.findById(postId).getUser_id();
            String contentNotice="<img src=\""+user.getAvatar()+"\" width=\"50px\">" + user.getAccount() + " liked " + "post id "+postId;
            Notice notice =new Notice(user_id,contentNotice);
            noticeService.creatNotice(notice);
        }
        try {
            resp.sendRedirect("/facebook?action=home&id="+userId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAllPost(HttpServletRequest req, HttpServletResponse resp) {
        int user_id= Integer.parseInt(req.getParameter("id"));
        User user=userService.getById(user_id);
        List<Post> list=postService.findAll();
        List<User> listUser=userService.findAll();
        List<Notice> listNotice=noticeService.findNoticeByUser_id(user_id);
        int userId= Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user",user);
        req.setAttribute("listUser",listUser);
        req.setAttribute("userId",userId);
        req.setAttribute("list",list);
        req.setAttribute("listNotice",listNotice);
        RequestDispatcher dispatcher =req.getRequestDispatcher("home.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "comment":
                comment(req,resp);
                break;
            case "messeage":
                creatMesseage(req,resp);
                break;
            case "create":
                createPost(req, resp);
                break;
            case "edit":
                updatePost(req, resp);
                break;
        }

    }

    private void updatePost(HttpServletRequest req, HttpServletResponse resp) {
        int postId = Integer.parseInt(req.getParameter("postId"));
        int userId=Integer.parseInt(req.getParameter("userId"));
        String content = req.getParameter("content");
        Post post=postService.findById(postId);
        post.setContent(content);
        postService.update(post);
        try {
            resp.sendRedirect("/facebook?action=home&id="+userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int user_id = Integer.parseInt(req.getParameter("userId"));
        String content = req.getParameter("content");
        String image=req.getParameter("image");
        Post post = new Post( image, content, user_id);
        postService.create(post);
        String redirectURL = "/facebook?action=home&id=" + user_id;
        resp.sendRedirect(redirectURL);
    }

    private void creatMesseage(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        int friendId= Integer.parseInt(req.getParameter("friendId"));
        String content=req.getParameter("messContent");
        Messeage messeage=new Messeage(userId,friendId,content);
        messeageService.createMess(messeage);
        try {
            resp.sendRedirect("/facebook?action=messeage&userId="+userId+"&friendId="+friendId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void comment(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        int postId= Integer.parseInt(req.getParameter("postId"));
        String content=req.getParameter("content");
        Comment comment=new Comment(userId,postId,content);
        int rowEffect=commentService.createComment(comment);
        if (rowEffect>0){
            User user=userService.getById(userId);
            int user_id=postService.findById(postId).getUser_id();
            String contentNotice="<img src=\""+user.getAvatar()+"\" width=\"50px\">" + user.getAccount() + " commented " + "post id "+postId;
            Notice notice =new Notice(user_id,contentNotice);
            noticeService.creatNotice(notice);
        }
        try {
            resp.sendRedirect("/facebook?action=home&id="+userId);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

