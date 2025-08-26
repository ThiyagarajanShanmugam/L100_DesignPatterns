package Behavioural.ChainOfResponsibility;

public class JewelleryShopDemo {
    
    public static void main(String[] args) {
        System.out.println("Jewellery Shop Expense Approval Demo");
        System.out.println("====================================");
        
        // Create chain: Sales → Manager → Regional → Owner
        ExpenseHandler chain = new SalesAssociate();
        chain.setNext(new ShopManager());
        chain.nextHandler.setNext(new RegionalManager());
        chain.nextHandler.nextHandler.setNext(new ShopOwner());
        
        // Test different expense amounts
        chain.approve("Ring Polish", 300.0);
        chain.approve("Display Case", 2500.0);
        chain.approve("Security System", 15000.0);
        chain.approve("Diamond Collection", 75000.0);
        
        System.out.println("Demo Complete!");
    }
}   