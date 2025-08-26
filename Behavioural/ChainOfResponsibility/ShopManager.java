package Behavioural.ChainOfResponsibility;

// Shop Manager - approves up to $5,000
public class ShopManager extends ExpenseHandler {
    
    @Override
    public void approve(String item, double amount) {
        if (amount <= 5000) {
            System.out.println("Shop Manager approved: " + item + " ($" + amount + ")");
        } else {
            System.out.println("Shop Manager escalating: " + item + " ($" + amount + ")");
            escalate(item, amount);
        }
    }
}