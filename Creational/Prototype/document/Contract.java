package Creational.Prototype.document;

/**
 * Concrete prototype for a Contract document.
 * Provides a default contract template and supports cloning.
 */
public class Contract extends Document {
    /**
     * Constructs a Contract template with default content and formatting.
     */
    public Contract(String title) {
        super(title);
        this.header = "SERVICE AGREEMENT CONTRACT";
        this.content = "PARTIES:\nClient: [Client Name and Address]\nService Provider: [Provider Name and Address]\n\n" +
                      "SCOPE OF WORK:\n[Detailed description of services to be provided]\n\n" +
                      "PAYMENT TERMS:\nTotal Amount: $[Amount]\nPayment Schedule: [Payment Details]\n\n" +
                      "DURATION:\nStart Date: [Start Date]\nEnd Date: [End Date]\n\n" +
                      "TERMS AND CONDITIONS:\n1. [Term 1]\n2. [Term 2]\n3. [Term 3]\n\n" +
                      "SIGNATURES:\nClient: _________________ Date: _______\nProvider: _________________ Date: _______";
        this.footer = "This contract is legally binding upon signature by both parties";
        this.formatting = "Legal document format with clear sections and signature lines";
    }
    
    /**
     * Clone this Contract template.
     */
    @Override
    public Document clone() {
        System.out.println("Cloning Contract template: " + this.title);
        return cloneDocument();
    }
}