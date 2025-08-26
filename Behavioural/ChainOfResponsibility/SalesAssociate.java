package Behavioural.ChainOfResponsibility;

// Sales Associate - approves up to $500
public class SalesAssociate extends ExpenseHandler {
    
    @Override
    public void approve(String item, double amount) {
        if (amount <= 500) {
            System.out.println("Sales Associate approved: " + item + " ($" + amount + ")");
        } else {
            System.out.println("Sales Associate escalating: " + item + " ($" + amount + ")");
            escalate(item, amount);
        }
    }
}