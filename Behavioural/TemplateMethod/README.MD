```markdown
# Data Processing Pipeline - Template Method Pattern Explanation

## The Problem

Imagine you have different data processing workflows that follow similar steps but with variations:

**Without Template Method Pattern (Processing Chaos):**
```java
public class CSVProcessor {
    public void processFile() {
        openFile();
        readCSVData();
        validateCSVData();
        processCSVData();
        saveResults();
        closeFile();
        // Same structure as XML and JSON processors!
    }
}

public class XMLProcessor {
    public void processFile() {
        openFile();
        parseXMLData();     // Different parsing
        validateXMLData();   // Different validation
        processXMLData();    // Different processing
        saveResults();
        closeFile();
        // Almost identical structure!
    }
}

public class JSONProcessor {
    public void processFile() {
        openFile();
        parseJSONData();     // Different parsing
        validateJSONData();  // Different validation
        processJSONData();   // Different processing
        saveResults();
        closeFile();
        // Code duplication everywhere!
    }
}
```

**This creates processing madness:** Same algorithm structure with slight variations duplicated across multiple classes!

## The Solution - Template Method Pattern

Create a **master template** that defines the algorithm structure, with specific steps implemented by subclasses:
- **Data Processor Template** defines: "1. Open file, 2. Parse data, 3. Validate data, 4. Process data, 5. Save results, 6. Close file"
- **CSV Processor** knows: "I parse CSV format, validate CSV rules, process CSV data"
- **XML Processor** knows: "I parse XML format, validate XML schema, process XML data"
- **Template** controls the flow, **subclasses** implement the variations

**The magic:** Algorithm structure is **defined once** in template, **variations implemented in subclasses**!

## Step-by-Step Code Explanation

### Step 1: The Template Class (Algorithm Skeleton)
```java
public abstract class DataProcessor {
    // Template method - defines the algorithm structure (final prevents override)
    public final void processFile(String fileName) {
        openFile(fileName);          // Common step
        parseData();                 // Abstract - subclass implements
        validateData();              // Abstract - subclass implements  
        processData();               // Abstract - subclass implements
        saveResults();               // Common step
        closeFile();                 // Common step
    }
    
    // Common methods - same for all subclasses
    protected void openFile(String fileName) { /* common implementation */ }
    protected void saveResults() { /* common implementation */ }
    protected void closeFile() { /* common implementation */ }
    
    // Abstract methods - subclasses must implement these
    protected abstract void parseData();
    protected abstract void validateData();
    protected abstract void processData();
}
```
**Translation:** "I'm the template! I define the processing workflow structure. Subclasses must fill in the format-specific details!"

### Step 2: CSV Processor (Concrete Implementation)
```java
public class CSVProcessor extends DataProcessor {
    @Override
    protected void parseData() {
        System.out.println("Parsing CSV data: Reading comma-separated values");
        // CSV-specific parsing logic here
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating CSV data: Checking column count");
        // CSV-specific validation logic here
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing CSV data: Converting to internal format");
        // CSV-specific processing logic here
    }
}
```
**Translation:** "I'm CSV processor! I know how to parse CSV format, validate CSV rules, and process CSV data!"

### Step 3: XML Processor (Different Implementation)
```java
public class XMLProcessor extends DataProcessor {
    @Override
    protected void parseData() {
        System.out.println("Parsing XML data: Building DOM tree");
        // XML-specific parsing logic here
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating XML data: Checking against XSD schema");
        // XML-specific validation logic here
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing XML data: Extracting information");
        // XML-specific processing logic here
    }
}
```
**Translation:** "I'm XML processor! I know how to parse XML format, validate XML schema, and process XML data!"

### Step 4: Using the Template (Client Code)
```java
public class DataProcessingDemo {
    public static void main(String[] args) {
        // Process CSV file
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.processFile("sales_data.csv");
        
        // Process XML file  
        DataProcessor xmlProcessor = new XMLProcessor();
        xmlProcessor.processFile("system_config.xml");
    }
}
```
**Translation:** "I'm the client! I just call processFile() and the template handles the workflow while subclasses handle the specifics!"

## The Magic Data Processing Flow

### **Step 1: Template Method Called**
```java
DataProcessor csvProcessor = new CSVProcessor();
csvProcessor.processFile("sales_data.csv");
```
**What happens inside:**
The template method `processFile()` executes in this exact order:

### **Step 2: Template Controls the Flow**
```java
public final void processFile(String fileName) {
    openFile(fileName);          // Template executes common step
    parseData();                 // Template calls CSVProcessor.parseData()
    validateData();              // Template calls CSVProcessor.validateData()
    processData();               // Template calls CSVProcessor.processData()
    saveResults();               // Template executes common step
    closeFile();                 // Template executes common step
}
```

### **Step 3: Common Steps Execute (Same for All)**
```java
// DataProcessor.openFile() executes
protected void openFile(String fileName) {
    System.out.println("Opening file: " + fileName);
}
```

### **Step 4: Abstract Steps Execute (Subclass-Specific)**
```java
// CSVProcessor.parseData() executes
protected void parseData() {
    System.out.println("Parsing CSV data: Reading comma-separated values");
    // CSV-specific parsing logic
}
```

### **Step 5: Switch to XML Processor - Same Flow, Different Implementation**
```java
DataProcessor xmlProcessor = new XMLProcessor();
xmlProcessor.processFile("config.xml");
```
**What happens inside:**
Same template method, but now calls XML-specific implementations:
```java
// Same template flow, but:
parseData();     // Now calls XMLProcessor.parseData() instead
validateData();  // Now calls XMLProcessor.validateData() instead  
processData();   // Now calls XMLProcessor.processData() instead
```

## Why This is Amazing

### **Without Template Method (Code Duplication Hell):**
```java
public class CSVProcessor {
    public void processCSVFile() {
        System.out.println("Opening file");           // Duplicated
        System.out.println("Parsing CSV data");       // CSV-specific
        System.out.println("Validating CSV data");    // CSV-specific
        System.out.println("Processing CSV data");    // CSV-specific
        System.out.println("Saving results");         // Duplicated
        System.out.println("Closing file");           // Duplicated
    }
}

public class XMLProcessor {
    public void processXMLFile() {
        System.out.println("Opening file");           // Duplicated again!
        System.out.println("Parsing XML data");       // XML-specific
        System.out.println("Validating XML data");    // XML-specific
        System.out.println("Processing XML data");    // XML-specific
        System.out.println("Saving results");         // Duplicated again!
        System.out.println("Closing file");           // Duplicated again!
    }
}
```

### **With Template Method (Clean Structure):**
```java
public abstract class DataProcessor {
    public final void processFile(String fileName) {    // Algorithm defined once!
        openFile(fileName);        // Common code in one place
        parseData();              // Subclass implements variation
        validateData();           // Subclass implements variation
        processData();            // Subclass implements variation
        saveResults();            // Common code in one place
        closeFile();              // Common code in one place
    }
}

public class CSVProcessor extends DataProcessor {
    // Only implement the varying parts!
    protected void parseData() { /* CSV parsing */ }
    protected void validateData() { /* CSV validation */ }
    protected void processData() { /* CSV processing */ }
}
```

## Project Structure
```
DesignPatterns/
└── Behavioral/
    └── TemplateMethod/
        ├── README.md                  # This documentation
        ├── DataProcessor.java         # Abstract template (algorithm skeleton)
        ├── CSVProcessor.java          # Concrete implementation (CSV processing)
        ├── XMLProcessor.java          # Concrete implementation (XML processing)
        ├── JSONProcessor.java         # Concrete implementation (JSON processing)
        └── DataProcessingDemo.java    # Client (demonstrates template usage)
```

## How to Run

### Prerequisites
- Java 8 or higher
- Command line or IDE

### Running the Application
```bash
# Navigate to TemplateMethod directory
cd DesignPatterns/Behavioral/TemplateMethod

# Compile all Java files
javac *.java

# Run the demonstration
java DataProcessingDemo
```

## Expected Output
```
Data Processing Pipeline - Template Method Pattern Demo
=======================================================

SCENARIO 1: Processing CSV Sales Data
=== Starting Data Processing Pipeline ===
Opening file: sales_data.csv
Parsing CSV data: Reading comma-separated values
   - Splitting rows by newline
   - Splitting columns by comma
Processing progress logged
Validating CSV data: Checking column count and data types
   - Verifying expected number of columns
   - Checking for missing values
Processing CSV data: Converting to internal format
   - Mapping CSV columns to object properties
   - Applying business logic transformations
Saving processed results to database
Closing file and cleaning up resources
=== Data Processing Complete ===

SCENARIO 2: Processing XML Configuration
=== Starting Data Processing Pipeline ===
Opening file: system_config.xml
Parsing XML data: Building DOM tree
   - Reading XML tags and attributes
   - Creating hierarchical structure
Processing progress logged
Validating XML data: Checking against XSD schema
   - Verifying XML structure
   - Validating data types and constraints
Processing XML data: Extracting meaningful information
   - Traversing XML nodes
   - Converting XML to business objects
Saving processed results to database
Closing file and cleaning up resources
=== Data Processing Complete ===

SCENARIO 3: Processing JSON User Data
=== Starting Data Processing Pipeline ===
Opening file: user_profiles.json
Parsing JSON data: Converting to objects
   - Reading key-value pairs
   - Handling nested objects and arrays
JSON processing progress: Tracking object count
Validating JSON data: Checking JSON schema
   - Verifying required fields
   - Checking data format compliance
Processing JSON data: Transforming for business use
   - Mapping JSON properties to domain objects
   - Applying data transformation rules
Saving processed results to database
Closing file and cleaning up resources
=== Data Processing Complete ===

Template Method Pattern Demo Complete!
Same processing workflow, different format implementations!
```

## The Template Method Behavior in Action

### Algorithm Flow Control
```
Data Processing Algorithm Template:
├── processFile() [TEMPLATE METHOD - controls flow]
│   ├── openFile() [COMMON STEP - same for all formats]
│   ├── parseData() [ABSTRACT STEP - format-specific implementation]
│   ├── validateData() [ABSTRACT STEP - format-specific implementation]
│   ├── processData() [ABSTRACT STEP - format-specific implementation]
│   ├── saveResults() [COMMON STEP - same for all formats]
│   └── closeFile() [COMMON STEP - same for all formats]
```

### Template Method Enforcement
```
Template Method ensures consistent workflow:

CSV Processing:
processFile() → openFile() → CSVProcessor.parseData() → CSVProcessor.validateData() → CSVProcessor.processData() → saveResults() → closeFile()

XML Processing:
processFile() → openFile() → XMLProcessor.parseData() → XMLProcessor.validateData() → XMLProcessor.processData() → saveResults() → closeFile()

JSON Processing:
processFile() → openFile() → JSONProcessor.parseData() → JSONProcessor.validateData() → JSONProcessor.processData() → saveResults() → closeFile()

Same structure guaranteed, different implementations executed!
```

## Pattern Benefits Demonstrated

### 1. **Eliminates Algorithm Duplication**
```java
// Without Template Method (duplicated structure):
public class CSVProcessor {
    public void process() {
        openFile(); parseCSV(); validateCSV(); processCSV(); saveResults(); closeFile();
    }
}
public class XMLProcessor {
    public void process() {
        openFile(); parseXML(); validateXML(); processXML(); saveResults(); closeFile();
    }
}

// With Template Method (structure defined once):
public abstract class DataProcessor {
    public final void processFile() {
        openFile(); parseData(); validateData(); processData(); saveResults(); closeFile();
    }
}
```

### 2. **Enforces Consistent Algorithm Structure**
```java
// Template method is final - subclasses cannot change the algorithm flow
public final void processFile(String fileName) {
    // This sequence cannot be changed by subclasses
    openFile(fileName);
    parseData();
    validateData();
    processData();
    saveResults();
    closeFile();
}
```

### 3. **Promotes Code Reuse**
```java
// Common steps implemented once in base class
public abstract class DataProcessor {
    protected void openFile(String fileName) {
        System.out.println("Opening file: " + fileName);  // Reused by all subclasses
    }
    
    protected void saveResults() {
        System.out.println("Saving results to database");  // Reused by all subclasses
    }
    
    protected void closeFile() {
        System.out.println("Closing file");  // Reused by all subclasses
    }
}
```

### 4. **Easy Extension with Hook Methods**
```java
// Hook method - optional override with default implementation
public abstract class DataProcessor {
    protected void logProgress() {
        System.out.println("Processing progress logged");  // Default implementation
    }
}

// Subclasses can optionally override hook methods
public class JSONProcessor extends DataProcessor {
    @Override
    protected void logProgress() {
        System.out.println("JSON processing progress: Tracking object count");  // Custom implementation
    }
}
```

## Real-World Applications

This same Template Method pattern is used in:

- **Spring Framework**: JdbcTemplate, RestTemplate, TransactionTemplate for database operations
- **Servlet API**: HttpServlet service method defines request processing template
- **Unit Testing**: JUnit test execution lifecycle (setup, test, teardown)
- **Android Development**: Activity lifecycle methods (onCreate, onStart, onResume, etc.)
- **Web Frameworks**: Request processing pipelines (authentication, routing, response generation)
- **Build Systems**: Maven/Gradle build lifecycle phases
- **Data Import/Export**: ETL (Extract, Transform, Load) processing pipelines
- **Compiler Design**: Compilation phases (lexical analysis, parsing, code generation)

## Without vs With Template Method Pattern

### Without Template Method (Structure Chaos)
```java
public class CSVFileProcessor {
    public void processCSVFile(String fileName) {
        System.out.println("Opening CSV file: " + fileName);
        System.out.println("Reading CSV headers");
        System.out.println("Parsing CSV rows");
        System.out.println("Validating CSV data types");
        System.out.println("Converting CSV to objects");
        System.out.println("Saving to database");
        System.out.println("Closing CSV file");
    }
}

public class XMLFileProcessor {
    public void processXMLFile(String fileName) {
        System.out.println("Opening XML file: " + fileName);    // Duplicated
        System.out.println("Building XML DOM tree");
        System.out.println("Validating against XSD schema");
        System.out.println("Extracting XML data");
        System.out.println("Converting XML to objects");
        System.out.println("Saving to database");              // Duplicated
        System.out.println("Closing XML file");                // Duplicated
    }
}

// Adding new format requires duplicating the structure again!
// Changing common steps requires updating ALL processors!
```

### With Template Method (Clean Structure)
```java
public abstract class DataProcessor {
    public final void processFile(String fileName) {
        openFile(fileName);      // Common - defined once
        parseData();            // Abstract - subclass specific
        validateData();         // Abstract - subclass specific
        processData();          // Abstract - subclass specific
        saveResults();          // Common - defined once
        closeFile();            // Common - defined once
    }
    
    // Common steps defined once
    protected void openFile(String fileName) { /* common implementation */ }
    protected void saveResults() { /* common implementation */ }
    protected void closeFile() { /* common implementation */ }
}

public class CSVProcessor extends DataProcessor {
    // Only implement the varying parts
    protected void parseData() { /* CSV-specific */ }
    protected void validateData() { /* CSV-specific */ }
    protected void processData() { /* CSV-specific */ }
}

// Adding new format = implement only the varying methods!
// Changing common steps = update template class only!
```

## Template Method Pattern Extensions

### Adding Excel Processor
```java
public class ExcelProcessor extends DataProcessor {
    @Override
    protected void parseData() {
        System.out.println("Parsing Excel data: Reading worksheets and cells");
        System.out.println("   - Loading workbook structure");
        System.out.println("   - Reading cell values and formulas");
    }
    
    @Override
    protected void validateData() {
        System.out.println("Validating Excel data: Checking formulas and ranges");
        System.out.println("   - Verifying formula calculations");
        System.out.println("   - Checking data ranges");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing Excel data: Converting spreadsheet to objects");
        System.out.println("   - Mapping cells to properties");
        System.out.println("   - Handling multiple worksheets");
    }
}
```

### Adding Preprocessing Hook
```java
public abstract class DataProcessor {
    public final void processFile(String fileName) {
        openFile(fileName);
        preprocessData();        // New hook method
        parseData();
        validateData();
        processData();
        saveResults();
        closeFile();
    }
    
    // Hook method with default implementation
    protected void preprocessData() {
        System.out.println("No preprocessing required");
    }
}

// Subclasses can override if preprocessing needed
public class CSVProcessor extends DataProcessor {
    @Override
    protected void preprocessData() {
        System.out.println("Preprocessing CSV: Removing BOM and normalizing line endings");
    }
}
```

### Adding Error Handling Template
```java
public abstract class DataProcessor {
    public final void processFile(String fileName) {
        try {
            openFile(fileName);
            parseData();
            validateData();
            processData();
            saveResults();
        } catch (Exception e) {
            handleError(e);
        } finally {
            closeFile();
        }
    }
    
    // Hook method for error handling
    protected void handleError(Exception e) {
        System.out.println("Error processing file: " + e.getMessage());
    }
}
```

## Key Template Method Pattern Rules

### Do This (Good Template Design):
```java
// Template method should be final to prevent override
public final void processFile(String fileName) {
    // Algorithm structure cannot be changed by subclasses
}

// Abstract methods define points of variation
protected abstract void parseData();
protected abstract void validateData();

// Common code stays in template
protected void openFile(String fileName) {
    // Same implementation for all subclasses
}

// Hook methods provide optional customization points
protected void logProgress() {
    // Default implementation, can be overridden
}
```

### Don't Do This (Breaks Template Pattern):
```java
// Don't make template method non-final
public void processFile(String fileName) { // Missing 'final'
    // Subclasses could override and break the algorithm structure
}

// Don't put varying logic in template
public final void processFile(String fileName) {
    openFile(fileName);
    if (this instanceof CSVProcessor) {  // Wrong! Use abstract methods
        // This defeats the purpose of polymorphism
    }
}

// Don't make everything abstract if there's common logic
protected abstract void openFile(String fileName); // Wrong if same for all
protected abstract void closeFile(); // Wrong if same for all
```

## Enterprise Example: Spring Framework's JdbcTemplate

**Spring's JdbcTemplate uses Template Method Pattern:**

**Template Structure:**
1. **Acquire Connection** (common step)
2. **Prepare Statement** (varies by operation)
3. **Execute Query/Update** (varies by operation)
4. **Process Results** (varies by operation)
5. **Handle Exceptions** (common step)
6. **Release Connection** (common step)

**Template Method Benefits in Spring:**
- **Connection Management**: Handled consistently across all database operations
- **Exception Translation**: Common SQLException handling and translation
- **Resource Cleanup**: Guaranteed connection and statement cleanup
- **Operation Variation**: Different SQL operations implement their specific logic

**Usage Example:**
```java
// Spring handles the template, you provide the varying parts
jdbcTemplate.query("SELECT * FROM users", 
    (rs, rowNum) -> new User(rs.getString("name"), rs.getString("email"))
);
```

This demonstrates how Template Method Pattern enables frameworks to provide consistent structure while allowing customization of specific steps!

## Learning Takeaway

After running this demo, you should understand:
- How Template Method pattern eliminates code duplication in similar algorithms
- Why the template method should be final to enforce algorithm structure
- How abstract methods define points of variation while common methods provide reuse
- When to use Template Method pattern for algorithms with consistent structure but varying implementations

## Remember

The Template Method Pattern is like having **a recipe with customizable ingredients**:
- **Same cooking process** (algorithm structure) with **different ingredients** (implementations)
- **Each chef** (subclass) follows the same steps but uses their specialty ingredients
- **Recipe steps** (template method) cannot be changed, but **ingredients** (abstract methods) vary
- **Common techniques** (common methods) are shared, **special techniques** (abstract methods) are chef-specific

When you see **algorithms with consistent structure**, **code duplication in similar workflows**, **need for framework design**, or **common steps with varying details** - that's Template Method Pattern organizing consistent behavior with customizable variations into clean, reusable templates!

This data processing example perfectly demonstrates how Template Method Pattern eliminates duplication while maintaining consistent algorithm structure across different implementations!
```