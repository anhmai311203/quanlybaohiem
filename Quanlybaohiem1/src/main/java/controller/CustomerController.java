package controller;

import DAO.CustomerDAO;
import model.Customer;

public class CustomerController {
    private CustomerDAO customerDAO;

    public CustomerController() {
        customerDAO = new CustomerDAO();
    }

    // Thêm khách hàng bình thường
    public boolean addRegularCustomer(String name, String address, String phone) {
        Customer customer = new Customer(name, address, phone, false);
        return customerDAO.addCustomer(customer);
    }

    // Thêm khách hàng VIP
    public boolean addVipCustomer(String name, String address, String phone) {
        Customer customer = new Customer(name, address, phone, true);
        return customerDAO.addCustomer(customer);
    }

    // Xóa khách hàng theo ID
    public boolean deleteCustomer(int id) {
        return customerDAO.deleteCustomer(id);
    }

    // Lấy thông tin khách hàng theo ID
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }
}
