package Behavioural.Observer;

public class StockDemo {
    
    public static void main(String[] args) {
        System.out.println("Stock Observer Pattern Demo");
        System.out.println("===========================");
        
        // Create stock
        Stock apple = new Stock("AAPL", 150.0);
        
        // Add investors
        apple.addInvestor("Arun");
        apple.addInvestor("Siva");
        
        // Price changes - all investors notified automatically
        apple.setPrice(95.0);   // Price drops
        apple.setPrice(200.0);  // Price rises
        
        System.out.println("\nDemo Complete!");
    }
}
