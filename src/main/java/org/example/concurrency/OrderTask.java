package org.example.concurrency;

import org.example.model.Order;
import org.example.service.OrderService;

public class OrderTask implements Runnable{

    private OrderService orderService;
    private Order order;

    public OrderTask(OrderService orderService, Order order) {
        this.orderService = orderService;
        this.order = order;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (orderService.addOrder(order)) {
            System.out.println("Order added successfully by thread: " + threadName);
        } else {
            System.out.println("Failed to add order by thread: " + threadName);
        }
    }
}
