package Behavioural.Visitor;

// Demo class - shows Visitor Pattern for shopping cart calculations
public class ShoppingCartDemo {
    public static void main(String[] args) {
        System.out.println("Shopping Cart Tax Calculator - Visitor Pattern Demo");
        System.out.println("==================================================\n");
        
        // Create shopping cart with different item types
        java.util.List<CartItem> cart = new java.util.ArrayList<>();
        cart.add(new Book("Java Programming Guide", 45.99));
        cart.add(new Electronics("Laptop", 999.99));
        cart.add(new Clothing("T-Shirt", 19.99));
        cart.add(new Electronics("Smartphone", 699.99));
        cart.add(new Book("Design Patterns", 39.99));
        
        // Calculate subtotal
        double subtotal = cart.stream().mapToDouble(CartItem::getPrice).sum();
        System.out.println("CART CONTENTS:");
        cart.forEach(item -> System.out.println("  " + item.getName() + " - $" + item.getPrice()));
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        
        // VISITOR 1: Calculate taxes using TaxCalculatorVisitor
        System.out.println("\n--- CALCULATING TAXES ---");
        TaxCalculatorVisitor taxCalculator = new TaxCalculatorVisitor();
        double totalTax = 0;
        for (CartItem item : cart) {
            totalTax += item.accept(taxCalculator); // Each item accepts tax calculator
        }
        System.out.println("Total Tax: $" + String.format("%.2f", totalTax));
        
        // VISITOR 2: Calculate shipping using ShippingCalculatorVisitor
        System.out.println("\n--- CALCULATING SHIPPING ---");
        ShippingCalculatorVisitor shippingCalculator = new ShippingCalculatorVisitor();
        double totalShipping = 0;
        for (CartItem item : cart) {
            totalShipping += item.accept(shippingCalculator); // Each item accepts shipping calculator
        }
        System.out.println("Total Shipping: $" + String.format("%.2f", totalShipping));
        
        // Final total
        double finalTotal = subtotal + totalTax + totalShipping;
        System.out.println("\n--- FINAL CHECKOUT ---");
        System.out.println("Subtotal:      $" + String.format("%.2f", subtotal));
        System.out.println("Tax:           $" + String.format("%.2f", totalTax));
        System.out.println("Shipping:      $" + String.format("%.2f", totalShipping));
        System.out.println("TOTAL:         $" + String.format("%.2f", finalTotal));
        
        System.out.println("\nVisitor Pattern Demo Complete!");
        System.out.println("Same items, different calculations without changing item classes!");
    }
}
