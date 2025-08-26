package Behavioural.TemplateMethod;

// Abstract Template class - defines the algorithm structure
public abstract class DataProcessor {
    
    // Template method - defines the algorithm skeleton (final prevents override)
    public final void processFile(String fileName) {
        System.out.println("=== Starting Data Processing Pipeline ===");
        
        openFile(fileName);          // Common step
        parseData();                 // Abstract - subclass implements
        validateData();              // Abstract - subclass implements  
        processData();               // Abstract - subclass implements
        saveResults();               // Common step
        closeFile();                 // Common step
        
        System.out.println("=== Data Processing Complete ===\n");
    }
    
    // Common steps - implemented in template (same for all processors)
    protected void openFile(String fileName) {
        System.out.println("📂 Opening file: " + fileName);
    }
    
    protected void saveResults() {
        System.out.println("💾 Saving processed results to database");
    }
    
    protected void closeFile() {
        System.out.println("Closing file and cleaning up resources");
    }
    
    // Abstract steps - subclasses must implement (vary by format)
    protected abstract void parseData();
    protected abstract void validateData();
    protected abstract void processData();
    
    // Hook method - optional override (has default implementation)
    protected void logProgress() {
        System.out.println("Processing progress logged");
    }
}
