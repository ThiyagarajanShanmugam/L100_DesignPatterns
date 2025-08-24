package Structural.Decorator;

// Concrete Component - Basic post without any decorations
public class BasicPost implements Post {
    private String content;
    
    public BasicPost(String content) {
        this.content = content;
    }
    
    @Override
    public String getContent() {
        return content;
    }
    
    @Override
    public double getCost() {
        return 0.0; // Basic post is free
    }
}