package Behavioural.Strategy;

// Concrete Strategy - Credit Card Payment
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    
    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    public boolean validatePaymentDetails() {
        // Simple validation - card number length and holder name
        return cardNumber != null && cardNumber.length() == 16 && cardHolderName != null;
    }
    
    @Override
    public void pay(double amount) {
        if (validatePaymentDetails()) {
            System.out.println("💳 Connecting to bank...");
            System.out.println("Card: ****" + cardNumber.substring(12));
            System.out.println("Holder: " + cardHolderName);
            System.out.println("Paid $" + amount + " via Credit Card");
        } else {
            System.out.println("Invalid credit card details");
        }
    }
    
    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}
