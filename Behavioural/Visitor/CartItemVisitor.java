package Behavioural.Visitor;

// Visitor interface - defines calculations for different item types
public interface CartItemVisitor {
    double visit(Book book);
    double visit(Electronics electronics);
    double visit(Clothing clothing);
}
