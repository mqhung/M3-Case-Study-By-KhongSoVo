package controler;

import model.User;
import storage.UserSevice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String avata = request.getParameter("avata");
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");

        User user = new User(account,password,email,avata,phoneNumber,address);

        HttpSession session = request.getSession(false);
        session.getAttribute("user");

        response.sendRedirect("/login");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
                requestDispatcher.forward(request, response);
        }

    }

}
