package org.example;


import org.example.concurrency.OrderTask;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.User;

//import org.example.repository.ProductRepository;
import org.example.payment.CreditCaedPaymentProcessor;
import org.example.payment.PaymentProcessor;
import org.example.payment.UpiPaymentProcessor;
import org.example.payment.WalletPaymentProcessor;
import org.example.repository.InMemoeryProductRepository;
import org.example.repository.OrderRepository;
import org.example.repository.Repository;
import org.example.service.OrderService;
import org.example.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() throws InterruptedException {
        // =========================================
        // STEP 1 — CREATE SHARED PRODUCT
        // =========================================

        Product laptop = new Product(
                1,
                "Laptop",
                50000,
                1
        );

        // =========================================
        // STEP 2 — CREATE USERS
        // =========================================

        User user1 = new User(
                1,
                "John",
                "john@gmail.com",
                "1234"
        );

        User user2 = new User(
                2,
                "Bob",
                "bob@gmail.com",
                "5678"
        );

        // =========================================
        // STEP 3 — CREATE ORDERS
        // BOTH USE SAME PRODUCT
        // =========================================

        Order order1 = new Order(
                1,
                user1,
                List.of(laptop),
                50000
        );

        Order order2 = new Order(
                2,
                user2,
                List.of(laptop),
                50000
        );

        // =========================================
        // STEP 4 — CREATE SHARED REPOSITORY
        // =========================================

        Repository<Order> orderRepository =
                new OrderRepository();

        // =========================================
        // STEP 5 — CREATE PAYMENT PROCESSORS
        // =========================================

        PaymentProcessor walletProcessor =
                new WalletPaymentProcessor();

        PaymentProcessor upiProcessor =
                new UpiPaymentProcessor();

        // =========================================
        // STEP 6 — CREATE SERVICES
        // =========================================

        OrderService walletOrderService =
                new OrderService(orderRepository, walletProcessor);

        OrderService upiOrderService =
                new OrderService(orderRepository, upiProcessor);

        // =========================================
        // STEP 7 — CREATE TASKS
        // =========================================

        OrderTask task1 =
                new OrderTask(walletOrderService, order1);

        OrderTask task2 =
                new OrderTask(walletOrderService, order2);

        // =========================================
        // STEP 8 — CREATE THREADS
        // =========================================

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.setName("Wallet-Thread");
        thread2.setName("Wallet 2 -Thread");

        // =========================================
        // STEP 9 — START THREADS TOGETHER
        // =========================================

        thread1.start();
        thread2.start();

        // =========================================
        // STEP 10 — WAIT FOR BOTH THREADS
        // =========================================

        thread1.join();
        thread2.join();

        // =========================================
        // STEP 11 — PRINT FINAL RESULTS
        // =========================================

        System.out.println("\n===== FINAL ORDERS =====");
        System.out.println(walletOrderService.getAllOrders());

        System.out.println("\n===== FINAL PRODUCT QUANTITY =====");
        System.out.println(laptop.getQuantity());

    }
    }
