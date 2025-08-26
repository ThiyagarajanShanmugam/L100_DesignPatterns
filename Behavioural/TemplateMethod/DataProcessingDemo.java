package Behavioural.TemplateMethod;

// Demo class - shows Template Method Pattern in action
public class DataProcessingDemo {
    public static void main(String[] args) {
        System.out.println("Data Processing Pipeline - Template Method Pattern Demo");
        System.out.println("=======================================================\n");
        
        // Process CSV file
        System.out.println("SCENARIO 1: Processing CSV Sales Data");
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.processFile("sales_data.csv");
        
        // Process XML file  
        System.out.println("SCENARIO 2: Processing XML Configuration");
        DataProcessor xmlProcessor = new XMLProcessor();
        xmlProcessor.processFile("system_config.xml");
        
        // Process JSON file
        System.out.println("SCENARIO 3: Processing JSON User Data");
        DataProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.processFile("user_profiles.json");
        
        System.out.println("Template Method Pattern Demo Complete!");
        System.out.println("Same processing workflow, different format implementations!");
    }
}
