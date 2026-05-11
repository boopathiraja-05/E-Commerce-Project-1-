package org.example.payment;

public class CreditCaedPaymentProcessor implements PaymentProcessor{

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of amount: " + amount);
        return true;
    }
}
