package fa.training.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Department;
import fa.training.utils.DBUtils;

public class DepartmentDao {

    public boolean addDepartment(Department department)throws ClassNotFoundException, IOException, SQLException  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO department(department_name) VALUES (?)";
     
        try {
            // Thiết lập kết nối
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }

            // Tạo PreparedStatement
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getName());

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

    public List<Department> getAllDepartments() throws ClassNotFoundException, IOException, SQLException {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM department";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Thiết lập kết nối
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }

            // Tạo PreparedStatement
            preparedStatement = connection.prepareStatement(query);
            // Thực thi câu lệnh SELECT
            resultSet = preparedStatement.executeQuery();

            // Lặp qua kết quả và thêm vào danh sách
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("department_id"));
                department.setName(resultSet.getString("department_name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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

        return departments;
    }	
    public String getDepartmentNameById(int departmentId) throws ClassNotFoundException, IOException, SQLException {
        String departmentName = null;
        String query = "SELECT department_name FROM department WHERE department_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Thiết lập kết nối
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }

            // Tạo PreparedStatement
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, departmentId);

            // Thực thi câu lệnh SELECT
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                departmentName = resultSet.getString("department_name");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi nếu có
        } finally {
            // Đóng tài nguyên
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // In lỗi nếu có
            }
        }

        return departmentName;
    }

}
