package Behavioural.TemplateMethod;

// Concrete implementation - CSV file processing
public class CSVProcessor extends DataProcessor {
    
    @Override
    protected void parseData() {
        System.out.println("Parsing CSV data: Reading comma-separated values");
        System.out.println("   - Splitting rows by newline");
        System.out.println("   - Splitting columns by comma");
        logProgress(); // Using hook method
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating CSV data: Checking column count and data types");
        System.out.println("   - Verifying expected number of columns");
        System.out.println("   - Checking for missing values");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing CSV data: Converting to internal format");
        System.out.println("   - Mapping CSV columns to object properties");
        System.out.println("   - Applying business logic transformations");
    }
}
