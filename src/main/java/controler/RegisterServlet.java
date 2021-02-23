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
    UserSevice userSevice = new UserSevice();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            default:
                createAccount(request, response);
                break;
        }
        HttpSession session = request.getSession(false);
        session.getAttribute("user");



    }
        private void createAccount(HttpServletRequest request, HttpServletResponse response) {
//            int id = Integer.parseInt(request.getParameter("id"));
            String avata = request.getParameter("avata");
            String account = request.getParameter("account");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
            String address = request.getParameter("address");

            User user = new User(account,password,email,avata,phoneNumber,address);
            System.out.println("ok ba ba"+user);
            userSevice.save(user);

            try {
                response.sendRedirect("/login");
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
            default:
                showCreateForm(request,response);
                break;
        }

        }



    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
