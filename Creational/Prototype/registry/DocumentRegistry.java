package Creational.Prototype.registry;

import Creational.Prototype.document.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Registry for document templates (Prototype pattern).
 * Provides singleton access and manages cloning of document templates.
 */
public class DocumentRegistry {
    private static DocumentRegistry instance;
    private Map<String, Document> templates;
    
    /**
     * Private constructor to enforce singleton pattern.
     * Loads default document templates.
     */
    private DocumentRegistry() {
        templates = new HashMap<>();
        loadDefaultTemplates();
    }
    
    /**
     * Singleton accessor for the registry instance.
     */
    public static DocumentRegistry getInstance() {
        if (instance == null) {
            instance = new DocumentRegistry();
        }
        return instance;
    }
    
    /**
     * Loads default document templates into the registry.
     */
    private void loadDefaultTemplates() {
        System.out.println("Loading default document templates...");
        templates.put("RESUME", new Resume("Professional Resume Template"));
        templates.put("INVOICE", new Invoice("Business Invoice Template"));
        templates.put("CONTRACT", new Contract("Service Agreement Template"));
        System.out.println("Document templates loaded successfully!");
    }
    
    /**
     * Creates a new document by cloning a template and setting its title.
     * @param templateType The type of template (e.g., RESUME, INVOICE, CONTRACT)
     * @param title The title for the new document
     * @return A new Document instance, or null if template not found
     */
    public Document createDocument(String templateType, String title) {
        Document template = templates.get(templateType.toUpperCase());
        if (template != null) {
            Document newDocument = template.clone();
            newDocument.setTitle(title);
            return newDocument;
        } else {
            System.out.println("Template type not found: " + templateType);
            return null;
        }
    }
    
    public void addTemplate(String type, Document template) {
        templates.put(type.toUpperCase(), template);
        System.out.println("Added custom template: " + type);
    }
    
    public void listAvailableTemplates() {
        System.out.println("Available templates: " + templates.keySet());
    }
}