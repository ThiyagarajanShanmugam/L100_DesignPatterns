package Structural.Decorator;

// Concrete Decorator - Adds hashtags to post
public class HashtagDecorator implements Post {
    private Post post;
    private String hashtags;
    
    public HashtagDecorator(Post post, String hashtags) {
        this.post = post;
        this.hashtags = hashtags;
    }
    
    @Override
    public String getContent() {
        return post.getContent() + " " + hashtags;
    }
    
    @Override
    public double getCost() {
        return post.getCost() + 1.0; // Hashtags cost $1 for better reach
    }
}