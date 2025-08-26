package Behavioural.Visitor;

// Concrete Element - Book that can be visited for calculations
public class Book extends CartItem {
    
    public Book(String name, double price) {
        super(name, price);
    }
    
    @Override
    public double accept(CartItemVisitor visitor) {
        // Key method: allows visitor to visit this book
        return visitor.visit(this);
    }
}
