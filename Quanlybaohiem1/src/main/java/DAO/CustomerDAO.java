package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;

public class CustomerDAO {
    // Phương thức thêm khách hàng mới vào cơ sở dữ liệu
    public boolean addCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "INSERT INTO Customers (Name, Address, Phone, isVip) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getPhone());
            stmt.setBoolean(4, customer.isVip());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
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

    // Phương thức xóa khách hàng theo ID
    public boolean deleteCustomer(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "DELETE FROM Customers WHERE Id = ?";
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

    // Phương thức lấy khách hàng theo ID
    public Customer getCustomerById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Dbconnection.getConnection();
            String query = "SELECT * FROM Customers WHERE Id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getString("Name"),
                    rs.getString("Address"),
                    rs.getString("Phone"),
                    rs.getBoolean("isVip")
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
}
