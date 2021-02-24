package controller;

import model.Post;
import service.IPost;
import service.PostStatusService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet(name = "Servlet_post", value = "/tu")
public class ServletPost extends HttpServlet {
    private final IPost iPost = new PostStatusService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "edit":
                updatePost(request, response);
                break;
            case "delete":
                deletePost(request, response);

        }
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iPost.deletePost(id);
        try {
            response.sendRedirect("/facebook?action=home&user_id=1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
//        String image = request.getParameter("image");
//        int user_id = Integer.parseInt(request.getParameter("user_id"));
        Post post = new Post(id, content);
        iPost.updatePost(id, post);
        try {
            response.sendRedirect("/facebook?action=home&user_id=1");
        } catch (IOException e) {
            e.printStackTrace();
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
            case "home":
                showAll(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            default:
                showAll(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = iPost.findById(id);
        request.setAttribute("post", post);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(request, response);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts;
        if (request.getParameter("user_id") == null) {
            posts = iPost.fillAll();
            request.setAttribute("posts", posts);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
            return;

        } else {
            int user_id = Integer.parseInt(request.getParameter("user_id"));
            posts = iPost.fillAll(user_id);
        }
        request.setAttribute("posts", posts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listpost.jsp");
        requestDispatcher.forward(request, response);

    }


    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = iPost.findById(id);
        request.setAttribute("post", post);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int user_id = 1; //Integer.parseInt(request.getParameter("user_id"));
        String content = request.getParameter("content");
        Part part = request.getPart("image");
        String realPart = request.getServletContext().getRealPath("/image_post");
        String fileName = UUID.randomUUID() + part.getSubmittedFileName();

        part.write( realPart+"/" + fileName);

        Post post = new Post(0, "image_post/" + fileName, content, user_id);
        iPost.createPost(post);
        String redirectURL = "/facebook?action=home&user_id=" + user_id;
        response.sendRedirect(redirectURL);

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }
}

