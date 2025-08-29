package Behavioural.Strategy;

// Concrete Strategy - Apple Pay Payment
public class ApplePayPayment implements PaymentStrategy {
    private String deviceId;
    private boolean biometricAuth;
    
    public ApplePayPayment(String deviceId, boolean biometricAuth) {
        this.deviceId = deviceId;
        this.biometricAuth = biometricAuth;
    }
    
    @Override
    public boolean validatePaymentDetails() {
        return deviceId != null && biometricAuth;
    }
    
    @Override
    public void pay(double amount) {
        if (validatePaymentDetails()) {
            System.out.println("🍎 Connecting to Apple Pay...");
            System.out.println("Device: " + deviceId);
            System.out.println("Biometric authentication verified");
            System.out.println("Paid $" + amount + " via Apple Pay");
        } else {
            System.out.println("Apple Pay authentication failed");
        }
    }
    
    @Override
    public String getPaymentType() {
        return "Apple Pay";
    }
}
