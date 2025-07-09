package demo;

import builder.HouseBuilder;
import product.House;

public class HouseConstructionDemo {
    
    public static void main(String[] args) {
        System.out.println("House Construction System - Builder Pattern Demo");
        System.out.println("===============================================");
        
        System.out.println("\n=== BUILDING LUXURY VILLA ===");
        House luxuryVilla = new HouseBuilder()
            .buildFoundation("Reinforced Concrete")
            .buildWalls("Brick and Stone")
            .buildRoof("Clay Tiles")
            .addRooms(6)
            .addGarage()
            .addGarden()
            .addSwimmingPool()
            .paintHouse("Cream White")
            .build();
        
        luxuryVilla.displayHouse();
        System.out.println("House Type: " + luxuryVilla.getHouseType());
        
        System.out.println("\n=== BUILDING FAMILY HOME ===");
        House familyHome = new HouseBuilder()
            .buildFoundation("Concrete Slab")
            .buildWalls("Brick")
            .buildRoof("Asphalt Shingles")
            .addRooms(4)
            .addGarage()
            .addGarden()
            .paintHouse("Light Blue")
            .build();
        
        familyHome.displayHouse();
        System.out.println("House Type: " + familyHome.getHouseType());
        
        System.out.println("\n=== BUILDING BASIC HOUSE ===");
        House basicHouse = new HouseBuilder()
            .buildFoundation("Concrete Block")
            .buildWalls("Wood Frame")
            .buildRoof("Metal Sheets")
            .addRooms(2)
            .paintHouse("Yellow")
            .build();
        
        basicHouse.displayHouse();
        System.out.println("House Type: " + basicHouse.getHouseType());
        
        System.out.println("\n=== CUSTOM HOUSE BUILDING ===");
        demonstrateFlexibility();
        
        System.out.println("\nBuilder Pattern Demo Complete!");
    }
    
    private static void demonstrateFlexibility() {
        House customHouse = new HouseBuilder()
            .paintHouse("Green")
            .addSwimmingPool()
            .buildRoof("Solar Panels")
            .addRooms(3)
            .buildFoundation("Steel Frame")
            .addGarden()
            .buildWalls("Glass and Steel")
            .build();
        
        System.out.println("Custom house built in different order:");
        customHouse.displayHouse();
        System.out.println("House Type: " + customHouse.getHouseType());
    }
}