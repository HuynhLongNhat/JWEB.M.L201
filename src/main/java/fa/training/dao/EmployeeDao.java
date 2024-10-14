package fa.training.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Employee;
import fa.training.utils.DBUtils;

public class EmployeeDao {

    public boolean addEmployee(Employee employee) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO employee(employee_name, gender, date_of_birth, department_id) VALUES (?, ?, ?, ?)";

        try {
            // Thiết lập kết nối
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }

            // Tạo PreparedStatement
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getGender());
            preparedStatement.setDate(3, Date.valueOf(employee.getDob())); // Chuyển từ LocalDate sang java.sql.Date
            preparedStatement.setInt(4, employee.getDepartmentId());

            // Thực thi câu lệnh INSERT
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    public List<Employee> getAllEmployees() throws ClassNotFoundException, IOException, SQLException {
    	 List<Employee> employees = new ArrayList<>();
    	    String query = "SELECT e.*, d.department_name FROM employee e JOIN department d ON e.department_id = d.department_id";

    	    try (Connection connection = DBUtils.getConnection();
    	         PreparedStatement preparedStatement = connection.prepareStatement(query);
    	         ResultSet resultSet = preparedStatement.executeQuery()) {

    	        if (connection == null) {
    	            throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
    	        }

    	        while (resultSet.next()) {
    	            Employee employee = new Employee();
    	            employee.setId(resultSet.getInt("employee_id"));
    	            employee.setName(resultSet.getString("employee_name"));
    	            employee.setGender(resultSet.getString("gender"));
    	            employee.setDob(resultSet.getDate("date_of_birth").toLocalDate());
    	            employee.setDepartmentId(resultSet.getInt("department_id"));
    	            employee.setDepartmentName(resultSet.getString("department_name")); // Lưu tên phòng ban vào đối tượng Employee
    	            employees.add(employee);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        throw new SQLException("Không thể lấy danh sách nhân viên kèm theo tên phòng ban: " + e.getMessage());
    	    }

    	    return employees; 
    }
}
