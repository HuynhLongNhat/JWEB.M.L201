package fa.training.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.DepartmentDao;
import fa.training.dao.EmployeeDao;
import fa.training.entities.Department;
import fa.training.entities.Employee;

@WebServlet("/add-emloyee")
public class AddEmployeeServlet extends HttpServlet {
		private static final long serialVersionUID = 1L ;
		
		@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Lấy danh sách department từ cơ sở dữ liệu
	        DepartmentDao departmentDao = new DepartmentDao();
	        List<Department> departments = null;
	        try {
	            departments = departmentDao.getAllDepartments();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Kiểm tra nếu không lấy được department
	        if (departments == null || departments.isEmpty()) {
	            request.setAttribute("error", "No departments found.");
	        } else {
	            // Đặt danh sách department vào request attribute
	            request.setAttribute("departments", departments);
	        }

	        // Chuyển tiếp request đến JSP
	        request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);
	    } @Override
	            protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                    throws ServletException, IOException {
	                // Lấy thông tin từ form
	                String name = request.getParameter("name");
	                String gender = request.getParameter("gender");
	                LocalDate dob = LocalDate.parse(request.getParameter("dob"));
	                int departmentId = Integer.parseInt(request.getParameter("department"));

	                // Tạo Employee object
	                Employee employee = new Employee(name, gender, dob, departmentId);

	                // Lưu employee vào cơ sở dữ liệu
	                EmployeeDao employeeDao = new EmployeeDao();
	                boolean isAdded = false;
	                try {
	                    isAdded = employeeDao.addEmployee(employee);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }

	                // Kiểm tra kết quả và chuyển hướng
	                if (isAdded) {
	                    // Chuyển hướng sang trang listEmployee.jsp nếu thêm thành công
	                    response.sendRedirect("/JWEB_M_L101/list-employees");
	                } else {
	                    // Quay lại trang thêm employee với thông báo lỗi
	                    request.setAttribute("error", "Error adding employee.");
	                    request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);
	                }
	            }
}

