package Behavioural.ChainOfResponsibility;

// Regional Manager - approves up to $25,000
public class RegionalManager extends ExpenseHandler {
    
    @Override
    public void approve(String item, double amount) {
        if (amount <= 25000) {
            System.out.println("Regional Manager approved: " + item + " ($" + amount + ")");
        } else {
            System.out.println("Regional Manager escalating: " + item + " ($" + amount + ")");
            escalate(item, amount);
        }
    }
}
