package Behavioural.Command;

// Receiver - knows how to perform operations
public class Kitchen {
    
    public void prepare(String dish) {
        System.out.println("Kitchen preparing: " + dish);
    }
    
    public void cancel(String dish) {
        System.out.println("Kitchen cancelling: " + dish);
    }
}
