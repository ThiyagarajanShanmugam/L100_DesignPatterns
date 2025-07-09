package Creational.Prototype.document;

/**
 * Concrete prototype for a Resume document.
 * Provides a default resume template and supports cloning.
 */
public class Resume extends Document {
    /**
     * Constructs a Resume template with default content and formatting.
     */
    public Resume(String title) {
        super(title);
        this.header = "PROFESSIONAL RESUME";
        this.content = "PERSONAL INFORMATION:\nName: [Your Name]\nEmail: [Your Email]\nPhone: [Your Phone]\n\n" +
                      "PROFESSIONAL SUMMARY:\n[Brief professional summary]\n\n" +
                      "WORK EXPERIENCE:\n[Company] - [Position] ([Year-Year])\n• [Achievement 1]\n• [Achievement 2]\n\n" +
                      "EDUCATION:\n[University] - [Degree] ([Year])\n\n" +
                      "SKILLS:\n• [Skill 1]\n• [Skill 2]\n• [Skill 3]";
        this.footer = "References available upon request";
        this.formatting = "Professional layout with clear sections and bullet points";
    }
    
    /**
     * Clone this Resume template.
     */
    @Override
    public Document clone() {
        System.out.println("Cloning Resume template: " + this.title);
        return cloneDocument();
    }
}