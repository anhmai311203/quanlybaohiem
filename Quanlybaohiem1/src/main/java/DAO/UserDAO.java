package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.User;

public class UserDAO {
    // Thêm người dùng mới
    
    

    // Xác thực người dùng khi đăng nhập
    public User validateUser(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getString("Role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Dbconnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Kiểm tra username
    public User getUserByUsername(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM Users WHERE Username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            rs = stmt.executeQuery();   
            if (rs.next()) {
                return new User(
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getString("Role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Dbconnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Cập nhật người dùng
    public boolean updateUser(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "UPDATE Users SET Pass = ?, Email = ?, Role = ? WHERE Username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getPassword());
            //stmt.setString(2, user.getEmail());
             stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getRole());
           

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                Dbconnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Xóa người dùng theo ID
    public boolean deleteUser(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "DELETE FROM Users WHERE UserID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                Dbconnection.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
public boolean authenticateUser(String username, String password) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = Dbconnection.getConnection();
        String query = "SELECT * FROM Users WHERE Username = ? AND Pass = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);

        rs = stmt.executeQuery();
        return rs.next(); // Trả về true nếu có bản ghi khớp, ngược lại trả về false
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            Dbconnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
// Kiểm tra xem tên đăng ký đã tồn tại chưa
public boolean isUsernameExist(String username) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = Dbconnection.getConnection();
        String query = "SELECT COUNT(*) FROM Users WHERE Username = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, username);

        rs = stmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            return true; // Tên đăng ký đã tồn tại
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            Dbconnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false; // Tên đăng ký không tồn tại
}
// Kiểm tra xem mật khẩu có trùng với người dùng khác không
public boolean isPasswordUsedByOtherUser(String password) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = Dbconnection.getConnection();
        String query = "SELECT COUNT(*) FROM Users WHERE Password = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, password);

        rs = stmt.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            return true; // Mật khẩu đã được sử dụng
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            Dbconnection.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false; // Mật khẩu chưa được sử dụng
}
// Thêm người dùng mới với các kiểm tra
public boolean addUser(User user) {
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
        conn = Dbconnection.getConnection();
        String query = "INSERT INTO Users (Username, Pass, Roles) VALUES (?, ?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
//        stmt.setString(3, user.getEmail());
        stmt.setString(3, user.getRole());

        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        if (e.getErrorCode() == 2601 || e.getErrorCode() == 2627)
        {
            JOptionPane.showMessageDialog(null, "Đã tồn tại");
            return false;
        }
        e.printStackTrace();
        return false;
        
    }
}


    
}
