package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYBAOHIEM; Integrated Security = true; TrustServerCertificate =true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "root";

    // Phương thức để lấy kết nối đến cơ sở dữ liệu
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Phương thức để đóng kết nối
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
