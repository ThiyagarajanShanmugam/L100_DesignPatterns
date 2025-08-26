package Structural.Facade;

public class ComputerStartupDemo {
    
    public static void main(String[] args) {
        System.out.println("Computer Startup - Facade Pattern Demo");
        System.out.println("======================================");
        
        // Create computer facade
        ComputerFacade computer = new ComputerFacade();
        
        System.out.println("\n=== NORMAL STARTUP ===");
        computer.startComputer();
        
        System.out.println("\n=== SHUTDOWN ===");
        computer.shutdownComputer();
        
        System.out.println("\n=== RESTART ===");
        computer.restartComputer();
        
        System.out.println("\n=== FACADE PATTERN BENEFITS ===");
        demonstrateFacadeBenefits();
        
        System.out.println("\nFacade Pattern Demo Complete!");
    }
    
    private static void demonstrateFacadeBenefits() {
        ComputerFacade computer = new ComputerFacade();
        
        System.out.println("Without Facade, user would need to:");
        System.out.println("1. Manually freeze CPU");
        System.out.println("2. Clear memory");  
        System.out.println("3. Spin up hard drive");
        System.out.println("4. Initialize memory");
        System.out.println("5. Load boot sector");
        System.out.println("6. Read boot data");
        System.out.println("7. Load data into memory");
        System.out.println("8. Jump CPU to start position");
        System.out.println("9. Execute CPU instructions");
        System.out.println("10. Initialize network");
        System.out.println("11. Connect to network");
        System.out.println("12. Enable firewall");
        System.out.println("... 12 complex steps!");
        
        System.out.println("\nWith Facade, user just does:");
        System.out.println("computer.startComputer(); // One simple call!");
        
        // Show how simple it is
        System.out.println("\nDemonstrating simplicity:");
        computer.startComputer();
    }
}
