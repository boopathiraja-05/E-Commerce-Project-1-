package org.example.repository;

import org.example.model.Order;
import org.example.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderRepository implements Repository<Order>{

    private HashMap<Integer, Order> orderMap;

    public OrderRepository() {
        this.orderMap = new HashMap<>();
    }

    @Override
    public void save(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    @Override
    public Order findById(int id) {
        return orderMap.get(id);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public void deleteById(int id) {
        orderMap.remove(id);
    }
}
