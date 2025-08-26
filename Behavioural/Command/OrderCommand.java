package Behavioural.Command;

// Concrete command - represents a food order
public class OrderCommand implements Command {
    private Kitchen kitchen;
    private String dish;
    
    public OrderCommand(Kitchen kitchen, String dish) {
        this.kitchen = kitchen;
        this.dish = dish;
    }
    
    @Override
    public void execute() {
        kitchen.prepare(dish);
    }
    
    @Override
    public void undo() {
        kitchen.cancel(dish);
    }
}
