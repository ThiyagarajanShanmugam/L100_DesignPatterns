
// Product interface for all transportation types
package product;

public interface Transportation {
    String book(String pickup, String destination);
    double calculateFare(double distance);
    String getType();
}
