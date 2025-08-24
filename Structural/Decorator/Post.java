package Structural.Decorator;

// Component - Common interface for all posts
public interface Post {
    String getContent();
    double getCost(); // Cost to boost/promote the post
}