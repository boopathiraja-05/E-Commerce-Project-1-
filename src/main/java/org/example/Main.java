package org.example;


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
    static void main() {
        // =========================
        // STEP 1 — CREATE USER
        // =========================

        User user = new User(
                1,
                "John Doe",
                "john@example.com",
                "password123"
        );

        // =========================
        // STEP 2 — CREATE PRODUCTS
        // =========================

        Product product1 = new Product(1, "Laptop", 50000);
        Product product2 = new Product(2, "Mouse", 1000);
        Product product3 = new Product(3, "Keyboard", 2000);

        // =========================
        // STEP 3 — CREATE ORDER
        // =========================

        Order order1 = new Order(
                1,
                user,
                List.of(product1, product2, product3),
                53000
        );

        // =========================
        // STEP 4 — CREATE REPOSITORY
        // =========================

        Repository<Order> orderRepository =
                new OrderRepository();

        // =====================================================
        // TEST CASE 1 — WALLET PAYMENT
        // =====================================================

        System.out.println("\n========== TEST 1 : WALLET PAYMENT ==========\n");

        PaymentProcessor walletProcessor =
                new WalletPaymentProcessor();

        OrderService walletOrderService =
                new OrderService(orderRepository, walletProcessor);

        boolean walletOrderAdded =
                walletOrderService.addOrder(order1);

        System.out.println("Order Added : " + walletOrderAdded);

        System.out.println("Fetch Order By ID:");
        System.out.println(walletOrderService.getOrderById(1));

        System.out.println("Fetch All Orders:");
        System.out.println(walletOrderService.getAllOrders());

        // =====================================================
        // TEST CASE 2 — DUPLICATE ORDER
        // =====================================================

        System.out.println("\n========== TEST 2 : DUPLICATE ORDER ==========\n");

        boolean duplicateOrder =
                walletOrderService.addOrder(order1);

        System.out.println("Duplicate Order Added : " + duplicateOrder);

        // =====================================================
        // TEST CASE 3 — DELETE ORDER
        // =====================================================

        System.out.println("\n========== TEST 3 : DELETE ORDER ==========\n");

        boolean isDeleted =
                walletOrderService.RemoveOrderById(1);

        System.out.println("Order Deleted : " + isDeleted);

        System.out.println("Orders After Delete:");
        System.out.println(walletOrderService.getAllOrders());

        // =====================================================
        // TEST CASE 4 — DELETE NON-EXISTING ORDER
        // =====================================================

        System.out.println("\n========== TEST 4 : DELETE NON EXISTING ORDER ==========\n");

        boolean deleteAgain =
                walletOrderService.RemoveOrderById(1);

        System.out.println("Delete Again Result : " + deleteAgain);

        // =====================================================
        // TEST CASE 5 — NULL ORDER
        // =====================================================

        System.out.println("\n========== TEST 5 : NULL ORDER ==========\n");

        boolean nullOrder =
                walletOrderService.addOrder(null);

        System.out.println("Null Order Added : " + nullOrder);

        // =====================================================
        // TEST CASE 6 — UPI PAYMENT
        // =====================================================

        System.out.println("\n========== TEST 6 : UPI PAYMENT ==========\n");

        PaymentProcessor upiProcessor =
                new UpiPaymentProcessor();

        OrderService upiOrderService =
                new OrderService(orderRepository, upiProcessor);

        Order order2 = new Order(
                2,
                user,
                List.of(product1),
                50000
        );

        boolean upiOrderAdded =
                upiOrderService.addOrder(order2);

        System.out.println("UPI Order Added : " + upiOrderAdded);

        System.out.println("All Orders:");
        System.out.println(upiOrderService.getAllOrders());

        // =====================================================
        // TEST CASE 7 — CREDIT CARD PAYMENT
        // =====================================================

        System.out.println("\n========== TEST 7 : CREDIT CARD PAYMENT ==========\n");

        PaymentProcessor cardProcessor =
                new CreditCaedPaymentProcessor();

        OrderService cardOrderService =
                new OrderService(orderRepository, cardProcessor);

        Order order3 = new Order(
                3,
                user,
                List.of(product2),
                1000
        );

        boolean cardOrderAdded =
                cardOrderService.addOrder(order3);

        System.out.println("Card Order Added : " + cardOrderAdded);

        System.out.println("All Orders:");
        System.out.println(cardOrderService.getAllOrders());

        // =====================================================
        // FINAL STATE
        // =====================================================

        System.out.println("\n========== FINAL ORDERS ==========\n");

        System.out.println(cardOrderService.getAllOrders());

    }
    }
