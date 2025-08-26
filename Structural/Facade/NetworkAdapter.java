package Structural.Facade;

// Subsystem 4 - Network operations
public class NetworkAdapter {
    
    public void initialize() {
        System.out.println("Network: Initializing network adapter");
    }
    
    public void connectToNetwork() {
        System.out.println("Network: Connecting to available networks");
    }
    
    public void enableFirewall() {
        System.out.println("Network: Enabling firewall protection");
    }
}
