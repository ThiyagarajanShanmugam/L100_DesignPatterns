package Behavioural.Visitor;

// Concrete Element - Electronics that can be visited for calculations
public class Electronics extends CartItem {
    
    public Electronics(String name, double price) {
        super(name, price);
    }
    
    @Override
    public double accept(CartItemVisitor visitor) {
        // Key method: allows visitor to visit this electronics item
        return visitor.visit(this);
    }
}
