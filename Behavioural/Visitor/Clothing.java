package Behavioural.Visitor;

// Concrete Element - Clothing that can be visited for calculations
public class Clothing extends CartItem {
    
    public Clothing(String name, double price) {
        super(name, price);
    }
    
    @Override
    public double accept(CartItemVisitor visitor) {
        // Key method: allows visitor to visit this clothing item
        return visitor.visit(this);
    }
}
