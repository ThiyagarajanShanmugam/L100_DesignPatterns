
package product;

/**
 * Product class representing a House with various features.
 * Used by the Builder pattern.
 */
public class House {
    // House attributes
    private String foundation;
    private String walls;
    private String roof;
    private int rooms;
    private boolean garage;
    private boolean garden;
    private boolean swimmingPool;
    private String paintColor;
    
    public House() {}
    // Setters for builder
    public void setFoundation(String foundation) { this.foundation = foundation; }
    public void setWalls(String walls) { this.walls = walls; }
    public void setRoof(String roof) { this.roof = roof; }
    public void setRooms(int rooms) { this.rooms = rooms; }
    public void setGarage(boolean garage) { this.garage = garage; }
    public void setGarden(boolean garden) { this.garden = garden; }
    public void setSwimmingPool(boolean swimmingPool) { this.swimmingPool = swimmingPool; }
    public void setPaintColor(String paintColor) { this.paintColor = paintColor; }
    
    /**
     * Display the details of the constructed house.
     */
    public void displayHouse() {
        System.out.println("=== HOUSE CONSTRUCTION COMPLETE ===");
        System.out.println("Foundation: " + foundation);
        System.out.println("Walls: " + walls);
        System.out.println("Roof: " + roof);
        System.out.println("Rooms: " + rooms);
        System.out.println("Garage: " + (garage ? "Yes" : "No"));
        System.out.println("Garden: " + (garden ? "Yes" : "No"));
        System.out.println("Swimming Pool: " + (swimmingPool ? "Yes" : "No"));
        System.out.println("Paint Color: " + paintColor);
        System.out.println("=====================================");
    }
    
    /**
     * Returns a string representing the type of house based on features.
     */
    public String getHouseType() {
        if (swimmingPool && garage && garden && rooms >= 5) {
            return "Luxury Villa";
        } else if (garage && rooms >= 3) {
            return "Family Home";
        } else if (rooms >= 2) {
            return "Standard House";
        } else {
            return "Basic House";
        }
    }
}