package Structural.Facade;

// Subsystem 1 - CPU operations
public class CPU {
    
    public void freeze() {
        System.out.println("CPU: Freezing processor state");
    }
    
    public void jump(long position) {
        System.out.println("CPU: Jumping to memory position " + position);
    }
    
    public void execute() {
        System.out.println("CPU: Executing boot instructions");
    }
}