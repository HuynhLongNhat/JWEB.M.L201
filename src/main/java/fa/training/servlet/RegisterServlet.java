package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.UserDao;
import fa.training.entities.User;
import fa.training.utils.Constants;
import fa.training.utils.LogFactory;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");


        
        User user = new User(firstName, lastName, email, userName, password);

     
        try {
        	UserDao userDao = new UserDao();
            if (userDao.registerUsers(user)) {
               
            	  response.sendRedirect(request.getContextPath() + "/login");
            } else {
               
                request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
                request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            LogFactory.getLogger().error("An exception occurred while registering user", e);
           
        }
    }
}
