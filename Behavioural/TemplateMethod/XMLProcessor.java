package Behavioural.TemplateMethod;

// Concrete implementation - XML file processing
public class XMLProcessor extends DataProcessor {
    
    @Override
    protected void parseData() {
        System.out.println("Parsing XML data: Building DOM tree");
        System.out.println("   - Reading XML tags and attributes"); 
        System.out.println("   - Creating hierarchical structure");
        logProgress(); // Using hook method
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating XML data: Checking against XSD schema");
        System.out.println("   - Verifying XML structure");
        System.out.println("   - Validating data types and constraints");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing XML data: Extracting meaningful information");
        System.out.println("   - Traversing XML nodes");
        System.out.println("   - Converting XML to business objects");
    }
}
