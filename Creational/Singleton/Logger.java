package Creational.Singleton;
/**
 * Simple Enum-based Singleton Pattern - Logger Service
 * Real-world scenario: Application logging where we need exactly one logger instance
 */
public enum Logger {
    
    // This is our singleton instance
    INSTANCE;
    
    //Log an info message
    public void info(String message) {
        System.out.println("[INFO] " + message);
    }

    //Log an error message
    public void error(String message) {
        System.out.println("[ERROR] " + message);
    }

    //Log a debug message
    public void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
}