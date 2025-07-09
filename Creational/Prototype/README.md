# Document Template System - Prototype Pattern

## 📋 Overview

This project demonstrates the **Prototype Design Pattern** using a document template system. The Prototype pattern enables object creation by cloning existing objects (prototypes), making it easy to create new documents based on pre-defined templates.

## 🎯 Prototype Pattern Explained

**What it does:**
> Creates new objects by copying (cloning) a prototype instance, rather than instantiating new ones from scratch.

**Key benefits:**
- Reduces the cost of creating complex or resource-intensive objects.
- Allows dynamic addition of new types at runtime.
- Simplifies object creation when classes differ only in configuration.

**Real-world analogy:**
A document editor lets you create new files by duplicating a template (resume, invoice, contract), then customizing the copy.

## 🏗️ Pattern Components

| Component         | File(s) / Folder         | Role                | Description |
|-------------------|-------------------------|---------------------|-------------|
| **Prototype**     | `document/Document.java`| Base class with clone method | Declares the clone method for copying objects |
| **Concrete Prototypes** | `document/Resume.java`, `document/Invoice.java`, `document/Contract.java` | Concrete templates | Implement cloning for each document type |
| **Prototype Registry** | `registry/DocumentRegistry.java` | Registry/Manager | Stores and manages document templates |
| **Client/Demo**   | `demo/DocumentTemplateDemo.java` | Pattern usage | Uses the registry to create and customize documents |

## 🗂️ Project Structure

```
Prototype/
  document/   # Abstract and concrete document templates
  registry/   # Registry for managing prototypes
  demo/       # Demo and client code
```

## 🚦 How It Works

1. **Registry** loads default document templates (Resume, Invoice, Contract).
2. **Client** requests a new document by type; the registry clones the template and returns a new instance.
3. The client customizes the new document as needed.

## 🧩 Example Output

```
Document Template System - Prototype Pattern Demo
================================================

=== CREATING DOCUMENTS FROM TEMPLATES ===
Cloning Resume template: Professional Resume Template
Cloning Invoice template: Business Invoice Template
Cloning Contract template: Service Agreement Template

=== DISPLAYING CREATED DOCUMENTS ===
=== RESUME DOCUMENT ===
Title: John Smith - Software Engineer
Author: John Smith
...

=== CUSTOMIZING DOCUMENTS ===
Customized Resume:
=== RESUME DOCUMENT ===
Title: Senior Developer Resume
Author: Jane Doe
...

Document Template System Demo Complete!
```

## 🛠️ How to Run

1. Open a terminal in the `DesignPatterns` directory.
2. Compile all Java files:
   ```
   javac Creational\Prototype\document\*.java Creational\Prototype\registry\*.java Creational\Prototype\demo\*.java
   ```
3. Run the demo:
   ```
   java Creational.Prototype.demo.DocumentTemplateDemo
   ```

## 📚 Key Takeaways

- The Prototype pattern is ideal for creating new objects by copying existing ones (templates).
- It is useful when object creation is expensive or when you want to avoid subclassing for every configuration.
- The registry pattern complements Prototype by managing and providing access to prototypes.
