package builder;

import product.House;

/**
 * Builder class for constructing House objects step by step.
 */
public class HouseBuilder {
    private House house;
    
    /**
     * Initializes a new HouseBuilder with an empty House.
     */
    public HouseBuilder() {
        this.house = new House();
    }
    
    /**
     * Set the foundation type.
     */
    public HouseBuilder buildFoundation(String foundationType) {
        house.setFoundation(foundationType);
        System.out.println("Building " + foundationType + " foundation...");
        return this;
    }
    
    /**
     * Set the wall type.
     */
    public HouseBuilder buildWalls(String wallType) {
        house.setWalls(wallType);
        System.out.println("Constructing " + wallType + " walls...");
        return this;
    }
    
    /**
     * Set the roof type.
     */
    public HouseBuilder buildRoof(String roofType) {
        house.setRoof(roofType);
        System.out.println("Installing " + roofType + " roof...");
        return this;
    }
    
    /**
     * Add rooms to the house.
     */
    public HouseBuilder addRooms(int numberOfRooms) {
        house.setRooms(numberOfRooms);
        System.out.println("Adding " + numberOfRooms + " rooms...");
        return this;
    }
    
    /**
     * Add a garage to the house.
     */
    public HouseBuilder addGarage() {
        house.setGarage(true);
        System.out.println("Building garage...");
        return this;
    }
    
    public HouseBuilder addGarden() {
        house.setGarden(true);
        System.out.println("Landscaping garden...");
        return this;
    }
    
    public HouseBuilder addSwimmingPool() {
        house.setSwimmingPool(true);
        System.out.println("Installing swimming pool...");
        return this;
    }
    
    public HouseBuilder paintHouse(String color) {
        house.setPaintColor(color);
        System.out.println("Painting house " + color + "...");
        return this;
    }
    
    public House build() {
        System.out.println("House construction completed!");
        return house;
    }
}