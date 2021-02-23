package controller;

import model.Notice;
import model.Post;
import model.RelationShip;
import model.User;
import storage.IUser;
import storage.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "UserServlet", urlPatterns = "/facebook")
public class UserServlet extends javax.servlet.http.HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "find":
                findUserById(request, response);
                break;
        }
    }

    private void findUserById(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int friendId = Integer.parseInt(request.getParameter("friendId"));
        RequestDispatcher dispatcher;
        User user = userDAO.findFriendById(friendId);
        request.setAttribute("user", user);
        request.setAttribute("userId", userId);
        request.setAttribute("friendId", friendId);
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("user/find.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "find":
                showFindForm(request, response);
                break;
            case "home":
                showAllUser(request, response);
                break;
            case "add":
                addFriend(request, response);
                break;
            case "accept":
                acceptFriend(request,response);
                break;
        }
    }

    private void acceptFriend(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addFriend(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int friendId = Integer.parseInt(request.getParameter("friendId"));
        int id = (int) (Math.random() * 1000000);
        RelationShip relationShip = new RelationShip(id, userId, friendId, 1);
        int rowEffect = userDAO.createRelative(relationShip);
        if (rowEffect > 0) {
            int notice_id = (int) (Math.random() * 1000000);
            int user_id = userDAO.findFriendById(userId).getId();
            String content = "user has id " + userId + " send invite request to user has id " + friendId
                    + "<a href=\"/facebook?action=accept&relationship="+ id + "\"></a>";
            Notice notice = new Notice(notice_id, user_id, content);
            userDAO.createNotice(notice);
        }
        try {
            response.sendRedirect("/facebook?action=find&id=" + userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllUser(HttpServletRequest request, HttpServletResponse response) {
        int userId = Integer.parseInt(request.getParameter("id"));
        List<User> list = userDAO.showAllFriend();
        request.setAttribute("userId", userId);
        request.setAttribute("listUser", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFindForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/find.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
