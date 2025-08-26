package Structural.Facade;

// Facade - Simple interface for complex computer startup
public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private NetworkAdapter network;
    
    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
        this.network = new NetworkAdapter();
    }
    
    // Facade method - hides all the complex startup steps
    public void startComputer() {
        System.out.println("Starting computer...");
        System.out.println("================================");
        
        // Step 1: Initialize hardware
        cpu.freeze();
        memory.clear();
        hardDrive.spinUp();
        
        // Step 2: Load boot data
        memory.initializeSystemMemory();
        hardDrive.loadBootSector();
        String bootData = hardDrive.read(0, 1024);
        memory.load(0, bootData);
        
        // Step 3: Start CPU execution
        cpu.jump(0);
        cpu.execute();
        
        // Step 4: Initialize network
        network.initialize();
        network.connectToNetwork();
        network.enableFirewall();
        
        System.out.println("================================");
        System.out.println("Computer startup complete!");
    }
    
    // Another facade method for shutdown
    public void shutdownComputer() {
        System.out.println("Shutting down computer...");
        System.out.println("================================");
        
        network.connectToNetwork(); // Disconnect (simplified)
        memory.clear();
        cpu.freeze();
        
        System.out.println("================================");
        System.out.println("Computer shutdown complete!");
    }
    
    // Facade method for restart
    public void restartComputer() {
        System.out.println("Restarting computer...");
        shutdownComputer();
        System.out.println("\nWaiting 3 seconds...\n");
        startComputer();
    }
}
