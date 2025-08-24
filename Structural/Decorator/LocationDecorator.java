package Structural.Decorator;

// Concrete Decorator - Adds location tag to post
public class LocationDecorator implements Post {
    private Post post;
    private String location;
    
    public LocationDecorator(Post post, String location) {
        this.post = post;
        this.location = location;
    }
    
    @Override
    public String getContent() {
        return post.getContent() + " 📍 at " + location;
    }
    
    @Override
    public double getCost() {
        return post.getCost() + 2.0; // Location targeting costs $2
    }
}