package Behavioural.ChainOfResponsibility;

// Shop Owner - approves unlimited amounts
public class ShopOwner extends ExpenseHandler {
    
    @Override
    public void approve(String item, double amount) {
        System.out.println("Shop Owner approved: " + item + " ($" + amount + ") - Final approval");
    }
}