package Behavioural.Command;

public class RestaurantDemo {
    
    public static void main(String[] args) {
        System.out.println("Restaurant Ordering - Command Pattern Demo");
        System.out.println("=========================================");
        
        // Create receiver and invoker
        Kitchen kitchen = new Kitchen();
        Waiter waiter = new Waiter();
        
        // Create commands (orders)
        Command order1 = new OrderCommand(kitchen, "Pizza");
        Command order2 = new OrderCommand(kitchen, "Pasta");
        Command order3 = new OrderCommand(kitchen, "Burger");
        
        // Waiter takes orders
        waiter.takeOrder(order1);
        waiter.takeOrder(order2);
        waiter.takeOrder(order3);
        
        // Serve all orders
        waiter.serveOrders();
        
        // Customer cancels last order
        System.out.println("\nCustomer wants to cancel last order:");
        waiter.cancelLastOrder();
        
        System.out.println("Demo Complete!");
    }
}
