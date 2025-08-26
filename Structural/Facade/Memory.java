package Structural.Facade;

// Subsystem 2 - Memory operations
public class Memory {
    
    public void load(long position, String data) {
        System.out.println("Memory: Loading '" + data + "' at position " + position);
    }
    
    public void clear() {
        System.out.println("Memory: Clearing all memory");
    }
    
    public void initializeSystemMemory() {
        System.out.println("Memory: Initializing system memory space");
    }
}
