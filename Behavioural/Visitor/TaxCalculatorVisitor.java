package Behavioural.Visitor;

// Concrete Visitor - Calculate tax differently for each item type
public class TaxCalculatorVisitor implements CartItemVisitor {
    
    @Override
    public double visit(Book book) {
        // Books are tax-free in most states
        System.out.println("Tax for " + book.getName() + ": $0.00 (tax-free)");
        return 0.0;
    }
    
    @Override
    public double visit(Electronics electronics) {
        // Electronics have 8% sales tax
        double tax = electronics.getPrice() * 0.08;
        System.out.println("Tax for " + electronics.getName() + ": $" + 
                          String.format("%.2f", tax) + " (8%)");
        return tax;
    }
    
    @Override
    public double visit(Clothing clothing) {
        // Clothing has 6% sales tax
        double tax = clothing.getPrice() * 0.06;
        System.out.println("Tax for " + clothing.getName() + ": $" + 
                          String.format("%.2f", tax) + " (6%)");
        return tax;
    }
}
