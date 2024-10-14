package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.DepartmentDao;
import fa.training.entities.Department;

@WebServlet("/add-department")
public class AddDepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/add-department.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy tên department từ form
        String name = request.getParameter("name");

        // Tạo đối tượng Department
        Department department = new Department();
        department.setName(name);

        // Khởi tạo giá trị mặc định cho isAdded
        boolean isAdded = false;

        // Gọi DAO để thêm department vào cơ sở dữ liệu
        DepartmentDao departmentDao = new DepartmentDao();
        try {
            isAdded = departmentDao.addDepartment(department);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isAdded) {
            // Nếu thêm thành công, chuyển hướng về trang danh sách departments
            response.sendRedirect("list-departments");
        } else {
            // Nếu thêm không thành công, quay lại trang thêm department với thông báo lỗi
            request.setAttribute("errorMessage", "Failed to add department. Please try again.");
            request.getRequestDispatcher("/views/add-department.jsp").forward(request, response);
        }
    }
}
