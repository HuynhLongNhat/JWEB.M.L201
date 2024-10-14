package fa.training.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.User;
import fa.training.utils.DBUtils;

public class UserDao {

    // Phương thức đăng ký người dùng
    public boolean registerUsers(User user) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }
            callableStatement = connection.prepareCall("{call usp_registerUser(?,?,?,?,?)}");
            int param = 0;
            callableStatement.setString(++param, user.getFirstName());
            callableStatement.setString(++param, user.getLastName());
            callableStatement.setString(++param, user.getEmail());
            callableStatement.setString(++param, user.getUserName());
            callableStatement.setString(++param, user.getPassword());

            int result = callableStatement.executeUpdate();
            return result > 0; // Trả về true nếu có bản ghi được thêm thành công
        } catch (SQLException e) {
            e.printStackTrace(); // In thông tin lỗi ra console
            throw e; // Ném lại ngoại lệ để xử lý ở nơi gọi
        } finally {
            // Đóng tài nguyên
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý lỗi đóng CallableStatement
                }
            }
            DBUtils.closeConnection(connection);
        }
    }

    // Phương thức lấy danh sách người dùng
    public List<User> getAllUsers() throws ClassNotFoundException, IOException, SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT first_name, last_name, email, user_name FROM users"; // Cập nhật tên bảng nếu cần

        try {
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("user_name"),
                    null // Không cần lấy mật khẩu để hiển thị
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In thông tin lỗi ra console
            throw e; // Ném lại ngoại lệ để xử lý ở nơi gọi
        } finally {
            // Đóng tài nguyên
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý lỗi đóng ResultSet
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý lỗi đóng PreparedStatement
                }
            }
            DBUtils.closeConnection(connection);
        }
        return userList; // Trả về danh sách người dùng
    }

 // Phương thức đăng nhập người dùng
    public boolean loginUser(User user) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM users WHERE userName = ? AND password = ?"; // Cập nhật tên bảng nếu cần

        try {
            connection = DBUtils.getConnection();
            if (connection == null) {
                throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.");
            }
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getUserName()); // Lấy username từ đối tượng User
            pstmt.setString(2, user.getPassword()); // Lấy password từ đối tượng User
            
            rs = pstmt.executeQuery();

        
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để xử lý ở nơi gọi
        } finally {
            // Đóng tài nguyên
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý lỗi đóng ResultSet
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý lỗi đóng PreparedStatement
                }
            }
            DBUtils.closeConnection(connection);
        }

        return false; // Trả về false nếu không tìm thấy người dùng
    }

}
