package Creational.AbstractFactory.demo;

import Creational.AbstractFactory.factory.MenuFactory;
import Creational.AbstractFactory.factory.NorthIndianMenuFactory;
import Creational.AbstractFactory.factory.SouthIndianMenuFactory;
import Creational.AbstractFactory.product.Appetizer;
import Creational.AbstractFactory.product.Dessert;
import Creational.AbstractFactory.product.MainCourse;

/**
 * Demo class for the Abstract Factory pattern using an Indian restaurant menu.
 * Shows how to create families of related products (menu items) for different cuisines.
 */
public class RestaurantDemo {
    /**
     * Entry point for the Abstract Factory pattern demo.
     */
    public static void main(String[] args) {
        System.out.println("Indian Restaurant - Abstract Factory Pattern Demo");
        System.out.println("===========================================");
        
        // Demo North Indian Menu
        System.out.println("\n=== NORTH INDIAN RESTAURANT ===");
        processOrder("northindian");
        
        // Demo South Indian Menu  
        System.out.println("\n=== SOUTH INDIAN RESTAURANT ===");
        processOrder("southindian");
        
        System.out.println("\nAbstract Factory Pattern Demo Complete!");
    }
    
    /**
     * Client method using Abstract Factory to process an order for a cuisine.
     */
    private static void processOrder(String cuisine) {
        MenuFactory factory = MenuFactoryProducer.getFactory(cuisine);
        
        if (factory == null) {
            System.out.println("Cuisine not available");
            return;
        }
        
        // Create family of related products
        Appetizer appetizer = factory.createAppetizer();
        MainCourse mainCourse = factory.createMainCourse();
        Dessert dessert = factory.createDessert();
        
        // Display order processing
        System.out.println("Processing order...");
        System.out.println(appetizer.prepare());
        System.out.println(mainCourse.prepare());
        System.out.println(dessert.prepare());
        
        System.out.println("\nOrder Summary:");
        factory.displayFullMenu();
    }
}

/**
 * Factory Producer - decides which factory to use based on cuisine.
 */
class MenuFactoryProducer {
    public static MenuFactory getFactory(String cuisine) {
        if (cuisine.equalsIgnoreCase("northindian")) {
            return new NorthIndianMenuFactory();
        } else if (cuisine.equalsIgnoreCase("southindian")) {
            return new SouthIndianMenuFactory();
        }
        return null;
    }
}