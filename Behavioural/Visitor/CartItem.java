package Behavioural.Visitor;

// Element interface - all items must accept visitors
public abstract class CartItem {
    protected String name;
    protected double price;
    
    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // Key method: allows visitors to calculate costs
    public abstract double accept(CartItemVisitor visitor);
    
    public String getName() { return name; }
    public double getPrice() { return price; }
}
