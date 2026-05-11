package org.example.service;

import org.example.model.Order;
import org.example.payment.PaymentProcessor;
import org.example.repository.OrderRepository;
import org.example.repository.Repository;

import java.util.List;

public class OrderService {

    private Repository<Order> orderRepository;
    private PaymentProcessor paymentProcessor;



    public OrderService(Repository<Order> orderRepository, PaymentProcessor paymentProcessor) {
        this.orderRepository = orderRepository;
        this.paymentProcessor = paymentProcessor;
    }

    public boolean addOrder(Order o){
        if(o == null){
            System.out.println("Order cannot be null");
            return false;
        }
        if(orderRepository.findById(o.getOrderId()) != null ){
            System.out.println("Order already exists");
            return false;
        }
        if(!paymentProcessor.processPayment(o.getTotalAmount())){
            System.out.println("Payment failed");
            return false;
        }
        System.out.println("Payment processed successfully");
        orderRepository.save(o);
        System.out.println("Order added successfully");
        return true;
    }

    public Order getOrderById(int id){
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public boolean RemoveOrderById(int id){
        if (orderRepository.findById(id) == null){
            System.out.println("Order not found");
            return false;
        }
        orderRepository.deleteById(id);
        System.out.println("Order deleted successfully");
        return true;
    }



}
