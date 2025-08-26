package Behavioural.TemplateMethod;

// Concrete implementation - JSON file processing
public class JSONProcessor extends DataProcessor {
    
    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data: Converting to objects");
        System.out.println("   - Reading key-value pairs");
        System.out.println("   - Handling nested objects and arrays");
        logProgress(); // Using hook method
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating JSON data: Checking JSON schema");
        System.out.println("   - Verifying required fields");
        System.out.println("   - Checking data format compliance");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing JSON data: Transforming for business use");
        System.out.println("   - Mapping JSON properties to domain objects");
        System.out.println("   - Applying data transformation rules");
    }
    
    // Override hook method for JSON-specific logging
    @Override
    protected void logProgress() {
        System.out.println("JSON processing progress: Tracking object count");
    }
}