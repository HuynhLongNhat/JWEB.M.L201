package fa.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.EmployeeDao;
import fa.training.entities.Employee;

@WebServlet("/list-employees")
public class ListEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        try {
            // Lấy danh sách nhân viên từ EmployeeDao
            List<Employee> employees = employeeDao.getAllEmployees();
            // Đưa danh sách vào request attribute để sử dụng trong JSP
            request.setAttribute("employees", employees);
        } catch (Exception e) {
            e.printStackTrace();
            // Có thể thêm thông báo lỗi vào request attribute nếu cần
            request.setAttribute("errorMessage", "Không thể lấy danh sách nhân viên.");
        }

        // Chuyển tiếp đến trang JSP
        request.getRequestDispatcher("/views/list-employee.jsp").forward(request, response);
    }
}
