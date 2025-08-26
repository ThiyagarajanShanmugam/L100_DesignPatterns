package Behavioural.Strategy;

// Strategy interface - defines payment contract
public interface PaymentStrategy {
    void pay(double amount);
    String getPaymentType();
    boolean validatePaymentDetails();
}
