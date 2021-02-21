package controller;

import model.Post;
import service.IPost;
import service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_post", value = "/post")
public class ServletPost extends HttpServlet {
    private final IPost iPost = new PostService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("showAll")) {
            showAll(request, response);
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        List<Post> posts = iPost.fillAll(user_id);
request.setAttribute("posts",posts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listpost.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

}

