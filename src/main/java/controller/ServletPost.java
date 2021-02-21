package controller;

import model.Post;
import service.IPost;
import service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@MultipartConfig
@WebServlet(name = "Servlet_post", value = "/post")
public class ServletPost extends HttpServlet {
    private final IPost iPost = new PostService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "showAll":
                showAll(request, response);
                break;
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        List<Post> posts = iPost.fillAll(user_id);
        request.setAttribute("posts", posts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listpost.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int user_id = 1; //Integer.parseInt(request.getParameter("user_id"));
        String content = request.getParameter("content");

        Part part = request.getPart("image");
        String realPart = request.getServletContext().getRealPath("/image_post");
        String fileName = part.getSubmittedFileName();

        part.write(realPart + "/" + fileName);

        Post post = new Post(0,  "image_post/" + fileName, content, user_id);
        iPost.createPost(post);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listpost.jsp?action=showAll&user_id=" + user_id);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

}

