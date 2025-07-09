package Creational.Singleton;

//Demo class for the Enum Singleton Logger pattern.
//Shows how the singleton logger can be used across different services
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Simple Enum Singleton Demo ===\n");
        
        // Different parts of application using logger
        userService();
        orderService();
        
        // Verify same instance
        verifyInstance();
    }

    //Simulates a user service using the logger.
    
    static void userService() {
        Logger.INSTANCE.info("User service started");
        Logger.INSTANCE.debug("Processing user login");
    }
    
    //Simulates an order service using the logger
    static void orderService() {
        Logger.INSTANCE.info("Order service started");
        Logger.INSTANCE.error("Order validation failed");
    }
    
    //Verifies that the logger instance is the same across usages.
    static void verifyInstance() {
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        
        System.out.println("\nSame instance? " + (logger1 == logger2));
        System.out.println("Logger1 hash: " + logger1.hashCode());
        System.out.println("Logger2 hash: " + logger2.hashCode());
    }
} 
