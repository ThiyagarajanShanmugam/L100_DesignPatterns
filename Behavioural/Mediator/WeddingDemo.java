package Behavioural.Mediator;

public class WeddingDemo {
    
    public static void main(String[] args) {
        System.out.println("Wedding Planner Coordination - Mediator Pattern Demo");
        System.out.println("===================================================");
        
        // Create mediator (wedding planner)
        WeddingPlanner planner = new WeddingPlanner();
        
        // Create vendors
        Vendor photographer = new Photographer();
        Vendor dj = new DJ();
        Vendor caterer = new Caterer();
        
        // Add vendors to planner
        planner.addVendor(photographer);
        planner.addVendor(dj);
        planner.addVendor(caterer);
        
        // Wedding day events coordinated by planner
        planner.startWedding();
        
        System.out.println("\n--- During Wedding Events ---");
        
        // Vendors communicate through planner
        photographer.sendUpdate("Photos of ceremony complete");
        caterer.sendUpdate("Dinner is ready for party");
        dj.sendUpdate("Ready for cake cutting ceremony");
        
        System.out.println("\nMediator Pattern Demo Complete!");
    }
}
