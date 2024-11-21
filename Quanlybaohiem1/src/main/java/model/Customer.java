package model;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private boolean isVip;

    public Customer(String name, String address, String phone, boolean isVip) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isVip = isVip;
    }

    // Các getter và setter cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }
}
