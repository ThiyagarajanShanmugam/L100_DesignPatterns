package Behavioural.ChainOfResponsibility;

// Base handler class
public abstract class ExpenseHandler {
    protected ExpenseHandler nextHandler;
    
    public void setNext(ExpenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public abstract void approve(String item, double amount);
    
    protected void escalate(String item, double amount) {
        if (nextHandler != null) {
            nextHandler.approve(item, amount);
        }
    }
}