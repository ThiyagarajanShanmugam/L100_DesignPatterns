
// Concrete product: Taxi ride
package product;

public class TaxiRide implements Transportation {
    @Override
    public String book(String pickup, String destination) {
        return "Taxi Booked!\n" +
               "Pickup: " + pickup + "\n" +
               "Destination: " + destination + "\n" +
               "Driver will call you in 5-10 minutes";
    }
    @Override
    public double calculateFare(double distance) {
        double baseFare = 25.0;
        double ratePerKm = 12.0;
        return baseFare + (distance * ratePerKm);
    }
    @Override
    public String getType() {
        return "Taxi";
    }
}
