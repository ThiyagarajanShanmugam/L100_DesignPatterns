package Behavioural.Command;

import java.util.*;

// Invoker - executes commands
public class Waiter {
    private List<Command> orders = new ArrayList<>();
    
    public void takeOrder(Command order) {
        orders.add(order);
        System.out.println("Waiter took order");
    }
    
    public void serveOrders() {
        System.out.println("Waiter serving all orders:");
        for (Command order : orders) {
            order.execute();
        }
    }
    
    public void cancelLastOrder() {
        if (!orders.isEmpty()) {
            Command lastOrder = orders.remove(orders.size() - 1);
            lastOrder.undo();
        }
    }
}
