package Behavioural.Visitor;

// Concrete Visitor - Calculate shipping differently for each item type
public class ShippingCalculatorVisitor implements CartItemVisitor {
    
    @Override
    public double visit(Book book) {
        // Books ship cheap - flat rate
        System.out.println("Shipping for " + book.getName() + ": $2.99 (standard book rate)");
        return 2.99;
    }
    
    @Override
    public double visit(Electronics electronics) {
        // Electronics need careful packaging - weight-based
        double shipping = electronics.getPrice() > 500 ? 19.99 : 12.99;
        System.out.println("Shipping for " + electronics.getName() + ": $" + 
                          String.format("%.2f", shipping) + " (fragile item)");
        return shipping;
    }
    
    @Override
    public double visit(Clothing clothing) {
        // Clothing ships light - minimal cost
        System.out.println("Shipping for " + clothing.getName() + ": $4.99 (lightweight)");
        return 4.99;
    }
}
