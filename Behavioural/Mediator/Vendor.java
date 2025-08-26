package Behavioural.Mediator;

// Abstract vendor class - all wedding vendors extend this
public abstract class Vendor {
    protected String name;
    protected WeddingPlanner planner;
    
    public Vendor(String name) {
        this.name = name;
    }
    
    public void setPlanner(WeddingPlanner planner) {
        this.planner = planner;
    }
    
    public void sendUpdate(String message) {
        System.out.println(name + " says: " + message);
        if (planner != null) {
            planner.coordinate(message, this);
        }
    }
    
    public abstract void receiveUpdate(String event, String senderType);
    public abstract String getType();
}