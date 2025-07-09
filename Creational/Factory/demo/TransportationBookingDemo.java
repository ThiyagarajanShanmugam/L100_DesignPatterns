package demo;

import factory.TransportationFactory;
import product.Transportation;

// Demo for Factory pattern: book different rides
public class TransportationBookingDemo {
    public static void main(String[] args) {
        // --- Demo booking Uber and Taxi, and error handling ---
        System.out.println("Transportation Booking System Demo");
        System.out.println("=====================================");
        String pickup = "Airport";
        String destination = "Hotel";
        double distance = 15.5;
        System.out.println("Journey Details:");
        System.out.println("Pickup: " + pickup);
        System.out.println("Destination: " + destination);
        System.out.println("Distance: " + distance + " km\n");
        System.out.println("=== DEMO 1: Booking Uber ===");
        bookTransportation("uber", pickup, destination, distance);
        System.out.println("\n" + "─".repeat(50) + "\n");
        System.out.println("=== DEMO 2: Booking Taxi ===");
        bookTransportation("taxi", pickup, destination, distance);
        System.out.println("\n" + "─".repeat(50) + "\n");
        System.out.println("=== DEMO 3: Error Handling ===");
        try {
            bookTransportation("invalid", pickup, destination, distance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
        System.out.println("\nFactory Pattern Demo Complete!");
    }
    private static void bookTransportation(String type, String pickup, String destination, double distance) {
        try {
            Transportation ride = TransportationFactory.createTransportation(type);
            System.out.println(ride.book(pickup, destination));
            System.out.println("Fare: Rs. " + ride.calculateFare(distance));
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}