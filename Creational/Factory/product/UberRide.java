
// Concrete product: Uber ride
package product;

public class UberRide implements Transportation {
    @Override
    public String book(String pickup, String destination) {
        return "Uber Booked!\n" +
               "Pickup: " + pickup + "\n" +
               "Destination: " + destination + "\n" +
               "Driver arriving in 3-5 minutes";
    }
    @Override
    public double calculateFare(double distance) {
        double baseFare = 30.0;
        double ratePerKm = 15.0;
        return baseFare + (distance * ratePerKm);
    }
    @Override
    public String getType() {
        return "Uber";
    }
}
