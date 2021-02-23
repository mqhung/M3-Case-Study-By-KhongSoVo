package controller;

import model.Comment;
import model.Likes;
import model.Notice;
import model.Post;
import service.IPostService;
import service.PostService;
import service.commentService.CommentService;
import service.likesService.LikesService;
import service.noticeService.NoticeService;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null)action="";
        switch (action){
            case "home":
                showAllPost(req,resp);
            case "likes":
                likePost(req,resp);

        }
    }

    private void likePost(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        int postId= Integer.parseInt(req.getParameter("postId"));
        Likes like =new Likes(postId,userId);
        int rowEffect =likesService.creatLike(like);
        if (rowEffect>0){
            int notice_id=(int) (Math.random()*1000000);
            int user_id=postService.findById(postId).getUser_id();
            String content="user id " + userId + " liked " + "post id "+postId;
            Notice notice =new Notice(notice_id,user_id,content);
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
        List<Post> list=postService.findAll();
        List<Notice> listNotice=noticeService.findNoticeByUser_id(user_id);
        int userId= Integer.parseInt(req.getParameter("id"));
//        req.setAttribute("postService",postService);
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
        }

    }

    private void comment(HttpServletRequest req, HttpServletResponse resp) {
        int userId= Integer.parseInt(req.getParameter("userId"));
        int postId= Integer.parseInt(req.getParameter("postId"));
        String content=req.getParameter("content");
        Comment comment=new Comment(userId,postId,content);
        int rowEffect=commentService.createComment(comment);
        if (rowEffect>0){
            int user_id=postService.findById(postId).getUser_id();
            String contentNotice="user id " + userId + " commented " + "post id "+postId;
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

