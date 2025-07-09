package Creational.Prototype.demo;

import Creational.Prototype.registry.DocumentRegistry;
import Creational.Prototype.document.Document;

/**
 * Demo class for the Prototype pattern using a document template system.
 * Shows how to create, clone, and customize documents from templates.
 */
public class DocumentTemplateDemo {
    /**
     * Entry point for the Prototype pattern demo.
     */
    public static void main(String[] args) {
        System.out.println("Document Template System - Prototype Pattern Demo");
        System.out.println("================================================");
        
        DocumentRegistry registry = DocumentRegistry.getInstance();
        
        System.out.println("\n=== CREATING DOCUMENTS FROM TEMPLATES ===");
        
        // Create documents by cloning templates
        Document johnResume = registry.createDocument("RESUME", "John Smith - Software Engineer");
        johnResume.setAuthor("John Smith");
        
        Document clientInvoice = registry.createDocument("INVOICE", "Invoice - Web Development Services");
        clientInvoice.setAuthor("ABC Tech Solutions");
        
        Document serviceContract = registry.createDocument("CONTRACT", "Website Development Agreement");
        serviceContract.setAuthor("Legal Department");
        
        System.out.println("\n=== DISPLAYING CREATED DOCUMENTS ===");
        johnResume.displayDocument();
        clientInvoice.displayDocument();
        serviceContract.displayDocument();
        
        System.out.println("\n=== CUSTOMIZING DOCUMENTS ===");
        customizeDocuments(registry);
        
        System.out.println("\n=== BULK DOCUMENT CREATION ===");
        createBulkDocuments(registry);
        
        System.out.println("\nDocument Template System Demo Complete!");
    }
    
    /**
     * Example of customizing documents after cloning from templates.
     */
    private static void customizeDocuments(DocumentRegistry registry) {
        // Create customized resume
        Document customResume = registry.createDocument("RESUME", "Senior Developer Resume");
        customResume.setAuthor("Jane Doe");
        customResume.setContent("PERSONAL INFORMATION:\nName: Jane Doe\nEmail: jane.doe@email.com\nPhone: (555) 123-4567\n\n" +
                              "PROFESSIONAL SUMMARY:\n5+ years of experience in full-stack development\n\n" +
                              "WORK EXPERIENCE:\nTech Corp - Senior Developer (2019-2024)\n• Led team of 5 developers\n• Increased system performance by 40%");
        
        System.out.println("Customized Resume:");
        customResume.displayDocument();
        
        // Create multiple invoices for different clients
        Document[] invoices = new Document[3];
        String[] clients = {"ABC Company", "XYZ Corp", "123 Industries"};
        
        for (int i = 0; i < clients.length; i++) {
            invoices[i] = registry.createDocument("INVOICE", "Invoice for " + clients[i]);
            invoices[i].setAuthor("Freelancer Pro");
            System.out.println("Created invoice for: " + clients[i]);
        }
    }
    
    private static void createBulkDocuments(DocumentRegistry registry) {
        System.out.println("Creating bulk documents using templates...");
        
        // Simulate office scenario - creating multiple documents quickly
        String[] resumeNames = {"Alex Johnson", "Sarah Wilson", "Mike Brown"};
        String[] contractTypes = {"Consulting Agreement", "Maintenance Contract", "Development Contract"};
        
        // Create multiple resumes
        for (String name : resumeNames) {
            Document resume = registry.createDocument("RESUME", name + " Resume");
            resume.setAuthor(name);
            System.out.println("Generated resume for: " + name);
        }
        
        // Create multiple contracts
        for (String contractType : contractTypes) {
            Document contract = registry.createDocument("CONTRACT", contractType);
            contract.setAuthor("Legal Team");
            System.out.println("Generated contract: " + contractType);
        }
        
        System.out.println("Bulk document creation completed!");
    }
}