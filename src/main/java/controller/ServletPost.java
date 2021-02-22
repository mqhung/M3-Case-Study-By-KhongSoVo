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
@WebServlet(name = "Servlet_post", value = "/facebook")
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
                updatePost(request, response);
                break;
            case "delete":
                deletePost(request, response);
        }
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) {
int id =Integer.parseInt(request.getParameter("id"));
iPost.deletePost(id);
        try {
            response.sendRedirect("/facebook?action=showAll&user_id=1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        Post post = new Post(id, image, content, user_id);
        iPost.updatePost(id, post);
        try {
            response.sendRedirect("/facebook");
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
            case "showAll":
                showAll(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = iPost.findById(id);
        request.setAttribute("post", post);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("updete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        String fileName = part.getSubmittedFileName();

        part.write(realPart + "/" + fileName);

        Post post = new Post(0, "image_post/" + fileName, content, user_id);
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

//    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String content = request.getParameter("content");
//        String image = request.getParameter("image");
//        String country = request.getParameter("country");
//        Post post = new Post(id, image, content, 1);
//        iPost.updatePost(id, post);
//        try {
//            response.sendRedirect("/post");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

