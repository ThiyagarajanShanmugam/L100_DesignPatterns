package Behavioural.Strategy;

// Demo class - shows Strategy Pattern in action
public class PaymentDemo {
    public static void main(String[] args) {
        System.out.println("Payment Processing - Strategy Pattern Demo");
        System.out.println("=========================================\n");
        
        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();
        
        // Add items to cart
        System.out.println("--- Adding items to cart ---");
        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);
        cart.addItem("Keyboard", 79.99);
        
        // SCENARIO 1: Credit Card Payment
        System.out.println("\n=== PAYMENT SCENARIO 1: CREDIT CARD ===");
        PaymentStrategy creditCard = new CreditCardPayment("1234567812345678", "John Doe");
        cart.setPaymentMethod(creditCard);
        cart.checkout();
        
        // SCENARIO 2: PayPal Payment
        System.out.println("\n=== PAYMENT SCENARIO 2: PAYPAL ===");
        PaymentStrategy paypal = new PayPalPayment("john@email.com", "secure123");
        cart.setPaymentMethod(paypal);
        cart.checkout();
        
        // SCENARIO 3: Apple Pay Payment
        System.out.println("\n=== PAYMENT SCENARIO 3: APPLE PAY ===");
        PaymentStrategy applePay = new ApplePayPayment("iPhone-12-Pro", true);
        cart.setPaymentMethod(applePay);
        cart.checkout();
        
        System.out.println("\n🎉 Strategy Pattern Demo Complete!");
        System.out.println("Same cart, different payment algorithms!");
    }
}