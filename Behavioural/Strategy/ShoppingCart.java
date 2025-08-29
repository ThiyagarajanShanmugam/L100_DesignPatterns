package Behavioural.Strategy;

// Context class - uses PaymentStrategy
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double totalAmount = 0.0;
    
    // Add items to cart
    public void addItem(String item, double price) {
        totalAmount += price;
        System.out.println("🛒 Added " + item + " - $" + price);
    }
    
    // Set payment method dynamically - KEY STRATEGY PATTERN FEATURE
    public void setPaymentMethod(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("Payment method set: " + paymentStrategy.getPaymentType());
    }
    
    // Process checkout using selected payment strategy
    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method");
            return;
        }
        
        System.out.println("\n--- CHECKOUT ---");
        System.out.println("Total: $" + totalAmount);
        paymentStrategy.pay(totalAmount); // Delegate to strategy
    }
}