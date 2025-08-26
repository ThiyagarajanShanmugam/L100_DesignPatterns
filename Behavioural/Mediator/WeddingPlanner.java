package Behavioural.Mediator;

import java.util.*;

// Mediator - coordinates all wedding vendors
public class WeddingPlanner {
    private List<Vendor> vendors;
    
    public WeddingPlanner() {
        this.vendors = new ArrayList<>();
    }
    
    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
        vendor.setPlanner(this);
    }
    
    public void coordinate(String event, Vendor sender) {
        System.out.println("Wedding Planner coordinating: " + event);
        
        // Notify relevant vendors based on event
        for (Vendor vendor : vendors) {
            if (!vendor.equals(sender)) {
                vendor.receiveUpdate(event, sender.getType());
            }
        }
    }
    
    public void startWedding() {
        System.out.println("WEDDING DAY BEGINS!");
        coordinate("Wedding ceremony starting", null);
    }
}
