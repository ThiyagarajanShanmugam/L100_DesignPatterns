package Structural.Facade;

// Subsystem 3 - Hard drive operations
public class HardDrive {
    
    public String read(long lba, int size) {
        System.out.println("HardDrive: Reading " + size + " bytes from sector " + lba);
        return "BOOT_DATA_" + lba;
    }
    
    public void spinUp() {
        System.out.println("HardDrive: Spinning up drive motor");
    }
    
    public void loadBootSector() {
        System.out.println("HardDrive: Loading boot sector from disk");
    }
}