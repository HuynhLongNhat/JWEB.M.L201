package fa.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            // Tải driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Thay thế với URL, username và password của bạn
            String url = "jdbc:mysql://localhost:3306/JNWEBML201_SMS"; // Thay đổi thành database của bạn
            String user = "root"; // Thay đổi thành username của bạn
            String password = "admin"; // Thay đổi thành password của bạn
            
            // Thiết lập kết nối
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công đến cơ sở dữ liệu.");
        } catch (SQLException e) {
            System.err.println("Kết nối không thành công. Lỗi: " + e.getMessage());
            throw e; // Ném lại ngoại lệ để xử lý ở nơi gọi
        }
        return connection;
    }

    // Phương thức đóng kết nối
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Kết nối đã được đóng.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}
