
// Factory for creating transportation products
package factory;

import product.*;

public class TransportationFactory {
    // Factory method: create a ride by type
    public static Transportation createTransportation(String type) {
        System.out.println("Factory creating: " + type);
        if (type.equalsIgnoreCase("uber")) {
            return new UberRide();
        } else if (type.equalsIgnoreCase("taxi")) {
            return new TaxiRide();
        } else {
            throw new IllegalArgumentException("Unknown transportation type: " + type);
        }
    }
    public static String[] getAvailableTypes() {
        return new String[]{"uber", "taxi"};
    }
}
