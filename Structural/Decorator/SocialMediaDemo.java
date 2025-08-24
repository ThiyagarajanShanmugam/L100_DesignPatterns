package Structural.Decorator;

public class SocialMediaDemo {
    
    public static void main(String[] args) {
        System.out.println("Social Media Post - Decorator Pattern Demo");
        System.out.println("=========================================");
        
        // Start with basic post
        Post myPost = new BasicPost("Just had an amazing dinner!");
        
        System.out.println("\n=== BASIC POST ===");
        displayPost("Basic Post", myPost);
        
        // Add hashtags
        myPost = new HashtagDecorator(myPost, "#food #dinner #yummy");
        System.out.println("\n=== ADDED HASHTAGS ===");
        displayPost("With Hashtags", myPost);
        
        // Add location
        myPost = new LocationDecorator(myPost, "Downtown Restaurant");
        System.out.println("\n=== ADDED LOCATION ===");
        displayPost("With Location", myPost);
        
        // Add filter
        myPost = new FilterDecorator(myPost, "Vintage");
        System.out.println("\n=== ADDED FILTER ===");
        displayPost("Full Enhanced Post", myPost);
        
        System.out.println("\nDecorator Pattern Demo Complete!");
    }
    
    private static void displayPost(String title, Post post) {
        System.out.println(title + ":");
        System.out.println("Content: " + post.getContent());
        System.out.println("Promotion Cost: $" + post.getCost());
        System.out.println("Length: " + post.getContent().length() + " characters");
    }
    
}