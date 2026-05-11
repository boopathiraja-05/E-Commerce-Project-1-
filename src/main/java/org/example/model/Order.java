package org.example.model;

import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private List<Product> products;
    private double totalAmount;

    public Order(int orderId, User user, List<Product> products, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", user=" + user + ", products=" + products + ", totalAmount=" + totalAmount + "]";}

}
