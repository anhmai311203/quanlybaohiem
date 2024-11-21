package controller;

import DAO.UserDAO;
import model.User;

public class UserController {
    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    // Phương thức để thêm người dùng mới
    public boolean addUser(String username, String password, String email, String role) {
        User user = new User(username, password, email, role);
        return userDAO.addUser(user);
    }

    // Phương thức để xác thực người dùng khi đăng nhập
    public User validateUser(String username, String password) {
        return userDAO.validateUser(username, password);
    }

    // Phương thức để kiểm tra xem username có tồn tại trong hệ thống chưa
    public boolean isUsernameAvailable(String username) {
        User user = userDAO.getUserByUsername(username);
        return user == null; // Trả về true nếu username chưa tồn tại
    }

    // Phương thức để cập nhật thông tin người dùng
    public boolean updateUser(int id, String newUsername, String newPassword, String newEmail, String newRole) {
        User user = new User(newUsername, newPassword, newEmail, newRole);
        user.setId(id); // Đảm bảo bạn có setter cho id trong class User
        return userDAO.updateUser(user);
    }

    // Phương thức để xóa người dùng theo ID
    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }
}
