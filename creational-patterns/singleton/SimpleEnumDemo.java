package com.designpatterns.creational.singleton;

//Simple demonstration of Enum Singleton Pattern

public class SimpleEnumDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Simple Enum Singleton Demo ===\n");
        
        // Different parts of application using logger
        userService();
        orderService();
        
        // Verify same instance
        verifyInstance();
    }
    
    static void userService() {
        Logger.INSTANCE.info("User service started");
        Logger.INSTANCE.debug("Processing user login");
    }
    
    static void orderService() {
        Logger.INSTANCE.info("Order service started");
        Logger.INSTANCE.error("Order validation failed");
    }
    
    static void verifyInstance() {
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        
        System.out.println("\nSame instance? " + (logger1 == logger2));
        System.out.println("Logger1 hash: " + logger1.hashCode());
        System.out.println("Logger2 hash: " + logger2.hashCode());
    }
} 
