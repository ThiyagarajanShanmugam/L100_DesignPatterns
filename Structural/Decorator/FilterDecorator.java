package Structural.Decorator;

// Concrete Decorator - Adds photo filter to post
public class FilterDecorator implements Post {
    private Post post;
    private String filter;
    
    public FilterDecorator(Post post, String filter) {
        this.post = post;
        this.filter = filter;
    }
    
    @Override
    public String getContent() {
        return post.getContent() + " [" + filter + " filter applied]";
    }
    
    @Override
    public double getCost() {
        return post.getCost() + 0.5; // Premium filters cost $0.50
    }
}