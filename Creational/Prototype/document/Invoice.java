package Creational.Prototype.document;

/**
 * Concrete prototype for an Invoice document.
 * Provides a default invoice template and supports cloning.
 */
public class Invoice extends Document {
    /**
     * Constructs an Invoice template with default content and formatting.
     */
    public Invoice(String title) {
        super(title);
        this.header = "INVOICE";
        this.content = "BILL TO:\n[Client Name]\n[Client Address]\n[City, State, ZIP]\n\n" +
                      "INVOICE DETAILS:\nInvoice Number: [INV-001]\nDate: [Date]\nDue Date: [Due Date]\n\n" +
                      "SERVICES/PRODUCTS:\n1. [Service/Product Description] - $[Amount]\n2. [Service/Product Description] - $[Amount]\n\n" +
                      "SUBTOTAL: $[Amount]\nTAX (8%): $[Tax Amount]\nTOTAL: $[Total Amount]\n\n" +
                      "PAYMENT TERMS:\nPayment due within 30 days of invoice date.";
        this.footer = "Thank you for your business! | Contact: [Your Contact Info]";
        this.formatting = "Business format with itemized billing and payment terms";
    }
    
    /**
     * Clone this Invoice template.
     */
    @Override
    public Document clone() {
        System.out.println("Cloning Invoice template: " + this.title);
        return cloneDocument();
    }
}