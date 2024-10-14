package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.UserDao;
import fa.training.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L; // Add this line
    private static UserDao userDao = new UserDao();	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/login-user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	
    	String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(userName , password);
        // Kiểm tra thông tin đăng nhập (ví dụ với database)
        try {
            if (userDao.loginUser(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", userName); 
                response.sendRedirect(request.getContextPath() + "/home"); // Chuyển hướng đến trang chủ
            } else {
                request.setAttribute("username", userName);
                request.setAttribute("loginFail", "User name or password is incorrect");
                request.getRequestDispatcher("/views/login-user.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // In lỗi ra console
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Class not found exception occurred.");
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "SQL error occurred during login.");
        }
	
      
        
       
    }

   
}