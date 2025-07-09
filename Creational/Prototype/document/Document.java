
package Creational.Prototype.document;

/**
 * Abstract base class for all document types in the Prototype pattern.
 * Implements Cloneable to support cloning of document templates.
 */
public abstract class Document implements Cloneable {
    protected String title;
    protected String content;
    protected String author;
    protected String dateCreated;
    protected String header;
    protected String footer;
    protected String formatting;
    
    /**
     * Constructor for a document template.
     * @param title The title of the document.
     */
    public Document(String title) {
        this.title = title;
        this.dateCreated = getCurrentDate();
    }
    
    /**
     * Clone method to be implemented by concrete subclasses.
     */
    public abstract Document clone();
    
    /**
     * Helper method to perform shallow cloning using Object.clone().
     */
    protected Document cloneDocument() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported: " + e.getMessage());
            return null;
        }
    }
    
    // Setters for document properties
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setAuthor(String author) { this.author = author; }
    public void setHeader(String header) { this.header = header; }
    public void setFooter(String footer) { this.footer = footer; }
    public void setFormatting(String formatting) { this.formatting = formatting; }
    
    // Getters
    public String getTitle() { return title; }
    public String getDocumentType() { return this.getClass().getSimpleName(); }
    
    /**
     * Display the document's details in a formatted way.
     */
    public void displayDocument() {
        System.out.println("=== " + getDocumentType().toUpperCase() + " DOCUMENT ===");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Date: " + dateCreated);
        System.out.println("Header: " + header);
        System.out.println("Content Preview: " + getContentPreview());
        System.out.println("Footer: " + footer);
        System.out.println("Formatting: " + formatting);
        System.out.println("=====================================");
    }
    
    protected String getContentPreview() {
        return content != null && content.length() > 50 ? 
               content.substring(0, 50) + "..." : content;
    }
    
    private String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }
}