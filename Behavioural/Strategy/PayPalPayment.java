package Behavioural.Strategy;

// Concrete Strategy - PayPal Payment
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean validatePaymentDetails() {
        return email != null && email.contains("@") && password != null;
    }
    
    @Override
    public void pay(double amount) {
        if (validatePaymentDetails()) {
            System.out.println("🔵 Connecting to PayPal...");
            System.out.println("Email: " + email);
            System.out.println("Authenticating PayPal account...");
            System.out.println("Paid $" + amount + " via PayPal");
        } else {
            System.out.println("Invalid PayPal credentials");
        }
    }
    
    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}
