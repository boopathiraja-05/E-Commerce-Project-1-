package org.example.payment;

public class WalletPaymentProcessor implements PaymentProcessor{
        private double walletLimit = 10000;

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing wallet payment of amount: " + amount);

        // TODO: Implement wallet payment processing logic
        if (amount > walletLimit){
            System.out.println("Wallet limit exceeded");
            return false;
        }
        System.out.println("Wallet payment processed successfully");
        return true;
    }
}
