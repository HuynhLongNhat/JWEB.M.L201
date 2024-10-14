package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.DepartmentDao;
import fa.training.entities.Department;

@WebServlet("/list-departments")
public class ListDepartmentServlet extends HttpServlet {
		private static final long serialVersionUID = 1L ;
		
		  @Override
		    protected void doGet(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        DepartmentDao departmentDao = new DepartmentDao();
		        try {
		            List<Department> departments = departmentDao.getAllDepartments();
		            request.setAttribute("departments", departments);
		        } catch (ClassNotFoundException | IOException | SQLException e) {
		            e.printStackTrace();
		            request.setAttribute("errorMessage", "Unable to retrieve departments.");
		        }

		        request.getRequestDispatcher("/views/list-department.jsp").forward(request, response);
		    }
}