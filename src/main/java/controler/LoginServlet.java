package controler;

import model.User;
import storage.IUserSevice;
import storage.UserSevice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private IUserSevice userSevice = new UserSevice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        User user = new User(account,password);
        List<User> userList = userSevice.findAll();
        boolean check = false;
        int userId = 0;

        for (User p:userList) {
            if( account.equals(p.getAccount()) && password.equals(p.getPassword()) ){
                userId = p.getId();
                check = true;
                break;
            }
        }
        if(check){
            response.sendRedirect("/facebook?action=home&id="+userId);

        }else{
            request.setAttribute("msg","Thông tin đăng nhập không đúng");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg","");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                requestDispatcher.forward(request, response);
        }
    }
}
