package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Policy;

public class PolicyDAO {
    // Phương thức thêm gói bảo hiểm mới vào cơ sở dữ liệu
    public boolean addPolicy(Policy policy) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Dbconnection.getConnection(); // Đảm bảo rằng Dbconnection được viết đúng
            String query = "INSERT INTO Policies (PolicyName, CoverageAmount, PremiumAmount, Duration, ServiceID) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, policy.getPolicyName());
            stmt.setBigDecimal(2, policy.getCoverageAmount());
            stmt.setBigDecimal(3, policy.getPremiumAmount());
            stmt.setInt(4, policy.getDuration());
            stmt.setInt(5, policy.getServiceID());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) Dbconnection.closeConnection(conn); // Đảm bảo Dbconnection có phương thức closeConnection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Phương thức lấy gói bảo hiểm theo ID
    public Policy getPolicyById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM Policies WHERE PolicyID = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            if (rs.next()) {
                // Tạo đối tượng Policy từ dữ liệu truy vấn được
                return new Policy(
                    rs.getInt("PolicyID"),
                    rs.getString("PolicyName"),
                    rs.getBigDecimal("CoverageAmount"),
                    rs.getBigDecimal("PremiumAmount"),
                    rs.getInt("Duration"),
                    rs.getInt("ServiceID"),
                    rs.getTimestamp("CreatedAt").toLocalDateTime()
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
        return null; // Trả về null nếu không tìm thấy gói bảo hiểm
    }
}
